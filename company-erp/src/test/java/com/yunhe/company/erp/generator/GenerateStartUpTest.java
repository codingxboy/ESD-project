package com.yunhe.company.erp.generator;

import com.google.common.base.CaseFormat;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.util.Md5Util;
import com.yunhe.common.core.util.PasswordUtil;
import com.yunhe.common.core.util.UuidUtil;
import com.yunhe.company.erp.common.redis.RedisService;
import com.yunhe.company.erp.generator.constant.GeneratorConstant;
import com.yunhe.company.erp.generator.mappers.AccountMapper;
import com.yunhe.company.erp.generator.mappers.UserBOMapper;
import com.yunhe.company.erp.service.impl.DepartmentServiceImpl;
import com.yunhe.company.erp.service.impl.UserServiceImpl;
import com.yunhe.entity.domain.erp.Account;
import com.yunhe.entity.domain.erp.AccountExample;
import com.yunhe.entity.domain.erp.User;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.config.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class GenerateStartUpTest {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private UserBOMapper userBOMapper;
    @Resource
    private UserServiceImpl userServiceImpl;
    @Resource
    private RedisService redisService;
    @Resource
    private DepartmentServiceImpl departmentServiceImpl;
    @Resource
    private HttpServletRequest httpServletRequest;
    // 数据库地址，根据配置自行修改
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/nb_erp?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    // 项目在硬盘上的基础路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    // 模板位置
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/template";

    // java文件路径
    private static final String JAVA_PATH = "/src/main/java";

    // 资源文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";

    // 生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(GeneratorConstant.SERVICE_PACKAGE);

    // 生成的Service实现存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(GeneratorConstant.SERVICE_IMPL_PACKAGE);

    // 生成的Controller存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(GeneratorConstant.CONTROLLER_PACKAGE);

    //VO
    private static final String PACKAGE_PATH_VO = packageConvertPath(GeneratorConstant.VO_PACKAGE);

    // @author
    private static final String AUTHOR = "jochen";
    // @date
    private static final String DATE = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    private static final boolean IMPLEMENTS_SERIALIZABLE = true;

    @Test
    void test() {
        // genCode("输入表名");
        genCode("erp_account_head");
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。 如输入表名称 "t_user_detail" 将生成
     * TUserDetail、TUserDetailMapper、ITUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            genCodeByCustomModelName(tableName, null);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User"
     * 将生成 User、UserMapper、IUserService ...
     *
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    public static void genCodeByCustomModelName(String tableName, String modelName) {
//        genModelAndMapper(tableName, modelName);
//        genService(tableName, modelName);
//        genController(tableName, modelName);
        genVo(tableName, modelName);
    }

    public static void genVo(String tableName, String modelName) {
        Context context = new Context(ModelType.FLAT);
        context.setId(UUID.randomUUID().toString());
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        // 设置注释生成器
        /*CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.setConfigurationType(CommentPlugin.class.getName());*/

        // 是否去除自动生成的注释
       /* commentGeneratorConfiguration.addProperty("suppressAllComments", "false");
        commentGeneratorConfiguration.addProperty("addRemarkComments", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);*/

        JDBCConnectionConfiguration connectionConfiguration = new JDBCConnectionConfiguration();
        connectionConfiguration.setConnectionURL(JDBC_URL);
        connectionConfiguration.setUserId(JDBC_USERNAME);
        connectionConfiguration.setPassword(JDBC_PASSWORD);
        connectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        connectionConfiguration.addProperty("nullCatalogMeansCurrent", "true");
        context.setJdbcConnectionConfiguration(connectionConfiguration);

        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("vo_package", GeneratorConstant.VO_PACKAGE);
//            data.put("CONTROLLER_PACKAGE", GeneratorConstant.CONTROLLER_PACKAGE);
//            data.put("MAPPER_PACKAGE", GeneratorConstant.MAPPER_PACKAGE);
//            data.put("MODEL_PACKAGE", GeneratorConstant.MODEL_PACKAGE);
//            data.put("SERVICE_PACKAGE", GeneratorConstant.SERVICE_PACKAGE);
//            data.put("SERVICE_IMPL_PACKAGE", GeneratorConstant.SERVICE_IMPL_PACKAGE);
            data.put("basePackage", GeneratorConstant.BASE_PACKAGE);
            File file = new File(
                    PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_VO + modelNameUpperCamel + "VO.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("Vo.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "VO.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成vo失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(
                freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private static String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String tableNameConvertMappingPath(String tableName) {
        // 兼容使用大写的表名
        tableName = tableName.toLowerCase();
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    @Test
    void testErp() {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andDeleteFlagNotEqualTo("1");
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        accounts.forEach(System.out::println);
    }

    @Test
    void testPassWord() {
        String encode = Md5Util.md5Encode("123456", "utf-8");
        System.out.println("e10adc3949ba59abbe56e057f20f883e");
        System.out.println(encode);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("83be0f82689342dc4de6c86628737699bb4aa6060b89d424");
//        System.out.println(Md5Util.generate("123456"));
    }

    @Test
    void testCode() {
        List<User> list = userBOMapper.getUserListByUserNameOrLoginName("书记", null);
        System.out.println(list.get(0));
    }

    @Test
    void testImages() {
        int validateUser = userServiceImpl.validateUser("书记", "12392892892");
        System.out.println(validateUser);
    }

    @Test
    void testSalt() {
        System.out.println(Md5Util.getMd5Salt(8));
    }

    @Test
    void testSalts() throws Exception {
        System.out.println(PasswordUtil.encrypt("123456", "rffq3333343", "43343908"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(PasswordUtil.decrypt("7d4e8d31a5bcec39", "rffq3333343", "43343908"));
    }

    @Test
    void testSaltKey() {
        System.out.println(PasswordUtil.getPublicKey("123456"));
    }

    @Test
    void TestRedis() {
        redisService.storageObjectBySession("token", "12323232", new User());
    }
    @Test
    void testDepartment(){
        System.out.println(departmentServiceImpl.getDepartIdByDepartName("开发三部"));
    }

    @Test
    void testDepartmentList(){
        System.out.println(departmentServiceImpl.getDepartIdByDepartName(Arrays.asList("开发三部","测试一部","财务二部")));
    }
    @Test
    void testMAth(){
        AtomicLong sequence = new AtomicLong();
            for (; ; ) {
                long oldSeq = sequence.get();
                long curMS = System.currentTimeMillis() * 1000;
                long newSeq = curMS > oldSeq ? curMS : oldSeq + 1;
                if (sequence.compareAndSet(oldSeq, newSeq)) {
                    System.out.println(newSeq);
                }
            }
    }

    @Test
    void testBIlls(){
        String billsType = BusinessConstants.BILLS_TYPE_CGD + UuidUtil.uuidDate();
        System.out.println(billsType);
        System.out.println(UuidUtil.uuidDate());
        System.out.println(UuidUtil.dateCode());
        System.out.println(UuidUtil.getDateFormat());
        System.out.println(LocalDateTime.now());
        System.out.println(new Date());

    }


}
