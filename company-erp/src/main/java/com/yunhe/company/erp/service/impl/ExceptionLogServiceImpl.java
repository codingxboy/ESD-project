package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yunhe.company.erp.generator.mappers.ExcLogsMapper;
import com.yunhe.company.erp.service.ExceptionLogService;
import com.yunhe.entity.domain.erp.ExcLogs;
import org.springframework.stereotype.Service;

/**
 * @ClassName ExceptionLogServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/16 11:25
 * @Version 1.0
 */
@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExcLogsMapper, ExcLogs> implements ExceptionLogService {

}
