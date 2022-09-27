package com.yunhe.flowable.core.utils;

import org.flowable.bpmn.constants.BpmnXMLConstants;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.common.engine.impl.identity.Authentication;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FlowableUtil
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/12 15:50
 * @Version 1.0
 */
public class FlowableUtil {

    public static void setAuthenticatedUserId(Long userId){
        Authentication.setAuthenticatedUserId(String.valueOf(userId));
    }

    public static void clearAuthenticatedUserId(){
        Authentication.setAuthenticatedUserId(null);
    }
    /**
     * @description: 获得 BPMN 流程中，指定的元素们
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/12 15:56
     */
    public static <T extends FlowElement> List<T> getBpmnModelElements(BpmnModel model, Class<T> clazz){
        List<T> result = new ArrayList<>();
        model.getProcesses().forEach(process -> {
            process.getFlowElements().forEach(flowElement -> {
                if (flowElement.getClass().isAssignableFrom(clazz)){
                    result.add((T) flowElement);
                }
            });
        });
        return result;
    }

    /**
     * @description:
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/12 16:04
     */
    public static boolean equals(BpmnModel oldBpmnModel,BpmnModel newBpmaModel){
        return Arrays.equals(getBpmnBytes(oldBpmnModel), getBpmnBytes(newBpmaModel));
    }
    /**
     * @description: 把 bpmnModel 转换成 byte[]
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/12 16:06
     */
    public static byte[] getBpmnBytes(BpmnModel bpmnModel){
        if (bpmnModel==null){
            return new byte[0];
        }
        BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
        return bpmnXMLConverter.convertToXML(bpmnModel);
    }
}
