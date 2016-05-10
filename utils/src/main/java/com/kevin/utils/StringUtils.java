package com.kevin.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 字符串处理类
 * 
 * @author Kevin
 * 
 */
public class StringUtils {

    /**
     * 校验是否为null
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 检查是否不为null
     * 
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断是否为数字格式
     * 
     * @param cs
     * @return
     */
    public static boolean isNumeric(final CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将String类型的金额格式化 举例：12345678.00 --->> 12,345,678.00
     * @param amt
     * @return
     */
    public static String getFormatMoney(String amt) {
        String moneyFormat;
        Double doubleMoney = 0.00;
        NumberFormat rmat = new DecimalFormat("###,###,##0.00");
        if (null != amt) {
            doubleMoney = Double.valueOf(amt.trim());
            moneyFormat = rmat.format(doubleMoney);
            return moneyFormat;
        } else {
            return "0.00";
        }
    }
    
    /**
     * 将String类型的金额格式化 举例：12345678.00 --->> 12,345,678.00
     * @param amt
     * @return
     */
    public static String getFormatMoneyInt(String amt) {
        if(StringUtils.isNotEmpty(amt)){
            if(amt.contains(".")){
                return amt.split("\\.")[0] + "";
            }else{
                return amt.trim();
            }
        }else{
            return "0";
        }
    }

    /**
     * 名字 安全显示；举例 张三 --> 张*； 李四王 --> 李*王
     * @param name
     * @return
     */
    public static String getNameSecret(String name) {
        String nameSecret = null;
        if (name.length() == 2) {
            nameSecret = name.charAt(0) + "*";
        } else {
            for (int i = 0; i < name.length(); i++) {
                if (i == 0) {
                    nameSecret = name.charAt(0) + "";
                } else if (i == name.length() - 1) {
                    nameSecret = nameSecret + name.charAt(i);
                } else {
                    nameSecret = nameSecret + "*";
                }
            }
        }
        return nameSecret;
    }
    
    /**
     * 创建UUID
     * @return
     */
    public static synchronized String makeUUID() {
        Date date = new Date();
        StringBuffer s = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date));
        return s.append((new Random().nextInt(900) + 100)).toString();
    }
}
