package com.yunhe.common.core.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName UuidUtil
 * @Description TODO 生成uuid
 * @Author xiaozuqin
 * @Date 2022/8/16 13:52
 * @Version 1.0
 */
public class UuidUtil {

    private static final String chars="abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    /**
     * UUID
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * UUID+时间
     *
     * @return
     */
    public static String uuidDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date());
        return UUID.randomUUID().toString().replace("-", "") + dateString;
    }

    /**
     *
     * 时间戳+随机数+序列号
     *
     * @return
     */
    public static String uuidCreId() {
        byte[] lock = new byte[0];
        long l = 1000000;
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * l);
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(date);
        return dateString + String.valueOf(r).substring(1);
    }

    /**
     * 时间+6位随机数
     *
     * @return
     */
    public static String dateCode() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(date);
        return dateString + genSixRandomNum();
    }
    /**
     * @description: 随机生成六位数
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/16 14:02
     */
    public static int genSixRandomNum(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result = result * 10 + array[i];
        }
        if (String.valueOf(result).length() == 6) {
            return result;
        } else {
            return genSixRandomNum();
        }
    }

    /**
     * 生成十位随机邀请码
     *
     * @return
     */
    public static String inviteCode() {
       return RandomStringUtils.random(10, chars);
    }

    public static String getDateFormat(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(df);
        String dateFormatStr = format.replace('-', ' ').replace(':', ' ');
        return StringUtils.deleteWhitespace(dateFormatStr);
//        return dateFormatStr.replaceAll("\\s+", "");
    }
}
