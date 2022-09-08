package com.yunhe.company.erp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.web.exception.BizException;

import com.yunhe.company.erp.generator.mappers.UserBusinessMapper;
import com.yunhe.company.erp.service.UserBusinessService;
import com.yunhe.entity.domain.erp.UserBusiness;
import com.yunhe.entity.domain.erp.UserBusinessExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserBusinessServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/26 14:57
 * @Version 1.0
 */
@Service
public class UserBusinessServiceImpl extends ServiceImpl<UserBusinessMapper,UserBusiness> implements UserBusinessService {
    private Logger logger = LoggerFactory.getLogger(UserBusinessServiceImpl.class);
    @Resource
    private UserBusinessMapper userBusinessMapper;
    @Resource
    private LogServiceImpl logServiceImpl;
    /**
     * @description:
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 14:57
     */
    @Override
    public List<UserBusiness> getBasicData(String keyId, String type) {
        List<UserBusiness> userBusinessList=null;
        try {
            UserBusinessExample userBusinessExample = new UserBusinessExample();
            userBusinessExample.createCriteria().andKeyIdEqualTo(keyId).andTypeEqualTo(type)
                    .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            userBusinessList=userBusinessMapper.selectByExample(userBusinessExample);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BizException("数据查询异常", exception);
        }
        return userBusinessList;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    @Override
    public int insertUserBusiness(JSONObject obj, HttpServletRequest request) {
        int result=0;
        UserBusiness userBusiness = JSONObject.parseObject(obj.toJSONString(), UserBusiness.class);
        try {
//            String token="";
//            if (request!=null){
//                token = request.getHeader(BusinessConstants.X_ACCESS_TOKEN);
//            }
            String value = userBusiness.getValue();
            logger.error(value);
            String newValue = value.replaceAll(",", "\\]\\[");
            newValue = newValue.replaceAll("\\[0\\]","").replaceAll("\\[\\]","");
            userBusiness.setValue(newValue);
            result=userBusinessMapper.insertSelective(userBusiness);
            logServiceImpl.insertLog("关联关系", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BizException("用户模块关系异常", exception);
        }
        return result;
    }

    @Override
    public List<UserBusiness> getUserBusinessBykeyId(Long keyId) {
        UserBusinessExample userBusinessExample = new UserBusinessExample();
        userBusinessExample.createCriteria().andKeyIdEqualTo(String.valueOf(keyId));
        return userBusinessMapper.selectByExample(userBusinessExample);
    }
}
