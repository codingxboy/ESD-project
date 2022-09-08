package com.yunhe.company.erp.domain.converter;

import com.yunhe.company.erp.domain.dto.UserAuthDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

//    UserAuthDTO do2Dto(User user);
}
