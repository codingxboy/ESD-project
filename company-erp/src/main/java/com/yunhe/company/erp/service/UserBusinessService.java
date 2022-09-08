package com.yunhe.company.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
;
import com.yunhe.entity.domain.erp.UserBusiness;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserBusinessService
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/26 14:54
 * @Version 1.0
 */
public interface UserBusinessService extends IService<UserBusiness> {

    List<UserBusiness> getBasicData(String keyId, String type);

    int insertUserBusiness(JSONObject obj, HttpServletRequest request);

    List<UserBusiness> getUserBusinessBykeyId(Long keyId);
}
