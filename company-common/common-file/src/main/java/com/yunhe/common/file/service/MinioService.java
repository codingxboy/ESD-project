package com.yunhe.common.file.service;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.yunhe.common.core.result.ResultCode;
import com.yunhe.common.core.util.ImgUtil;
import io.minio.*;
import io.minio.http.Method;
import lombok.Data;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @ClassName MinioService
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/23 15:03
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "minio")
@Slf4j
@Data
public class MinioService implements InitializingBean {
    /**
     * MinIO的API地址
     */
//    @Value("${minio.endpoint}")
    private String endpoint;
    /**
     * 用户名
     */
//    @Value("${minio.access-key}")
    private String accessKey;
    /**
     * 密钥
     */
//    @Value("${minio.secret-key}")
    private String secretKey;
    /**
     * 自定义域名(非必须)
     */
//    @Value("${minio.custom-domain}")
    private String customDomain;
    /**
     * 存储桶名称，默认微服务单独一个存储桶
     */
//    @Value("${minio.default-bucket}")
    private String defaultBucket;

    @Value("${minio.img-compression-enabled}")
    private boolean imgCompressionEnabled;

    private MinioClient minioClient;


    @Override
    public void afterPropertiesSet() {
        log.info("初始化 MinIO 客户端~~~~~~~~~~~~~~~~~~~~~~~~~");
        Assert.notBlank(endpoint, "MinIO endpoint不能为空");
        Assert.notBlank(accessKey, "MinIO accessKey不能为空");
        Assert.notBlank(secretKey, "MinIO secretKey不能为空");
        this.minioClient=MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
        log.info("MinioClient客户端连接服务器信息为:{}",this.getEndpoint()+"/"+this.getAccessKey()+"/"+this.getSecretKey());
    }
    /**
     * @description: 创建存储桶(存储桶不存在)
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/23 15:36
     */
    @SneakyThrows
    public void createBucketIfAbsent(String bucketName){
        BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(bucketName).build();
        if (!minioClient.bucketExists(bucketExistsArgs)){
            MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder().bucket(bucketName).build();
            minioClient.makeBucket(makeBucketArgs);
            //设置存储桶的访问权限为public,如不匹配权限为private,访问桶文件拒绝
            SetBucketPolicyArgs bucketPolicyArgs = SetBucketPolicyArgs.builder().bucket(bucketName)
                    .config(publicBucketPolicy(bucketName).toString()).build();

            minioClient.setBucketPolicy(bucketPolicyArgs);

        }

    }
    /**
     * @description: 上传文件对象（默认桶）
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/23 15:54
     */
    @SneakyThrows
    public String putObject(MultipartFile multipartFile) {
        return putObject(multipartFile,defaultBucket);
    }
    /**
     * @description: 上传文件对象
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/23 15:56
     */
    @SneakyThrows
    public String putObject(MultipartFile multipartFile,String bucketName) {
        //文件路径
        String fileUrl = null;
        try {
            //存储桶为空则使用默认桶
            if (StringUtils.isBlank(bucketName)) {
                bucketName=defaultBucket;
            }
            //判断存储桶是否存在
            createBucketIfAbsent(bucketName);
            //获取文件后缀名
            String suffix = FileUtil.getSuffix(multipartFile.getName());
            //文件名
            String uuid = IdUtil.simpleUUID();
            String fileName = DateUtil.format(LocalDateTime.now(), "yyyy/MM/dd") + "/" + uuid + "." + suffix;
            InputStream inputStream;
            //是否开启压缩
            if (ImgUtil.isImg(fileName)&&imgCompressionEnabled) {
                long size = multipartFile.getSize();
                log.info("图片({})压缩前大小：{}KB", uuid, size / 1024);
                float compressQuality = ImgUtil.getCompressQuality(size);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Convert.toInt(size));
                Thumbnails.of(multipartFile.getInputStream())
                        .scale(1f)
                        .outputQuality(compressQuality)
                        .toOutputStream(byteArrayOutputStream);
                inputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                log.info("图片({})压缩后大小：{}KB", uuid, inputStream.available() / 1024);
            }else{
                inputStream=multipartFile.getInputStream();
            }
            //上传参数构建
            PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName)
                    .object(fileName)
                    .contentType(multipartFile.getContentType())
                    .stream(inputStream, inputStream.available(), -1)
                    .build();

            //上传
            minioClient.putObject(putObjectArgs);
            if (StrUtil.isBlank(customDomain)){
                GetPresignedObjectUrlArgs presignedObjectUrlArgs = GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .method(Method.GET)
                        .build();

                fileUrl=minioClient.getPresignedObjectUrl(presignedObjectUrlArgs);
                fileUrl.substring(0,fileUrl.indexOf("?"));
            }else {
                // 自定义文件路径域名，Nginx配置代理转发
                fileUrl=customDomain+'/'+bucketName+"/"+fileName;
            }
        } catch (Exception e){
            log.error(ResultCode.USER_UPLOAD_FILE_ERROR.getMsg());
            e.printStackTrace();
        }
        return fileUrl;
    }

    /**
     * @description: 删除文件
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/23 16:43
     */
    @SneakyThrows
    public void removeObject(String bucketName,String fileName) {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build();
        minioClient.removeObject(removeObjectArgs);
    }

    /**
     * @description: 如果不配置，则新建的存储桶默认是PRIVATE，则存储桶文件会拒绝访问 Access Denied
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/23 15:49
     */
    public static StringBuilder publicBucketPolicy(String bucketName){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Version\":\"2022-9-23\"," + "\"Statement\":[{\"Effect\":\"Allow\"," + "\"Principal\":{\"AWS\":[\"*\"]}," + "\"Action\":[\"s3:ListBucketMultipartUploads\",\"s3:GetBucketLocation\",\"s3:ListBucket\"]," + "\"Resource\":[\"arn:aws:s3:::")
                .append(bucketName).append("\"]},").append("{\"Effect\":\"Allow\",").append("\"Principal\":{\"AWS\":[\"*\"]},")
                .append("\"Action\":[\"s3:ListMultipartUploadParts\",\"s3:PutObject\",\"s3:AbortMultipartUpload\",\"s3:DeleteObject\",\"s3:GetObject\"],")
                .append("\"Resource\":[\"arn:aws:s3:::").append(bucketName)
                .append("/*\"]}]}");
        return stringBuilder;
    }


}
