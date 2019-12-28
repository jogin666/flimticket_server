package com.zy.flimticketserver.util;

public class StringUtils {

    public static boolean isEmpty(String str){
        if (str!=null){
            if (!"".equals(str)){
                return true;
            }
        }
        return false;
    }
}
