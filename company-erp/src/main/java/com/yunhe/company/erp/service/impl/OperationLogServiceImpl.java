package com.yunhe.company.erp.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.company.erp.generator.mappers.OperLogsMapper;
import com.yunhe.company.erp.service.OperationLogService;
import com.yunhe.entity.domain.erp.OperLogs;
import org.springframework.stereotype.Service;

/**
 * @ClassName OperationLogServiceImpl
 * @Description TODO 操作日志实现类
 * @Author xiaozuqin
 * @Date 2022/8/16 11:24
 * @Version 1.0
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperLogsMapper, OperLogs> implements OperationLogService {

}
