package org.tfm.util;

/**
 * Created by christ on 14-6-17.
 * Make move.
 */
public class RGBUtil {
    public static String convert(String num){
        String[] data = num.split(" ");
        String result = "";
        for(String s:data){
            result+=Integer.toHexString(Integer.parseInt(s));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("53 95 49"));;
    }
}
