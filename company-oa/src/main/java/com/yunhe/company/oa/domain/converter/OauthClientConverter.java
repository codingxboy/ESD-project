package com.yunhe.company.oa.domain.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @description: 客户端转换器
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/26 23:46
 */
@Mapper
public interface OauthClientConverter {

    OauthClientConverter INSTANCE = Mappers.getMapper(OauthClientConverter.class);


}
