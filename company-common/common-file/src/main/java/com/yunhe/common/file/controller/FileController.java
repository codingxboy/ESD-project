package com.yunhe.common.file.controller;

import com.yunhe.common.core.result.Result;
import com.yunhe.common.core.result.ResultCode;
import com.yunhe.common.file.service.MinioService;
import com.yunhe.common.web.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/23 14:56
 * @Version 1.0
 */
@Api(tags = "文件接口")
@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {
    private final MinioService minioService;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    @SneakyThrows
    @WebLog
    public Result<String> uploadFile(@ApiParam("文件") @RequestParam(value = "multipartFile") MultipartFile multipartFile,
                                     @ApiParam("存储桶名称(没值默认存储桶)") @RequestParam(value = "bucketName", required = false)String bucketName) {
        return Result.success(ResultCode.USER_UPLOAD_FILE_SUCCESS,minioService.putObject(multipartFile, bucketName));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "文件删除")
    @SneakyThrows
    public Result deleteFile(@ApiParam("文件路径") @RequestParam(value = "filePath") String filePath) {
        int lastIndex = filePath.lastIndexOf("/");
        String bucketName = filePath.substring(filePath.lastIndexOf("/", lastIndex - 1) + 1, lastIndex);
        String fileName = filePath.substring(lastIndex + 1);
        minioService.removeObject(bucketName, fileName);
        return Result.success();


    }
}
