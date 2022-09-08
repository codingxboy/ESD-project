package com.yunhe.company.erp.generator.constant;

/**
 * @ClassName GeneratorConstant
 * @Description TODO 常量配置
 * @Author xiaozuqin
 * @Date 2022/7/19 14:45
 * @Version 1.0
 */
public class GeneratorConstant {
    public static final String BASE_PACKAGE = "com.yunhe.company.erp.generator";

    // 实体类所在包
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entities";

    // Mapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mappers";

    // Service所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    // ServiceImpl所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    // Controller所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    // vo所在包
    public static final String VO_PACKAGE = BASE_PACKAGE + ".vo";

    // Mapper插件基础接口的完全限定名
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".common.mapper.CrudMapper";
}
