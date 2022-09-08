package com.yunhe.company.oa.domain.converter;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @description: 用户转换器
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/26 23:55
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    /**
     * DO转换为DTO
     * @date: 2022/8/25 15:11
     */
//    UserAuthDTO do2Dto(User user);
}
