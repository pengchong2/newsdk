package cn.flyaudio.otasdk.utils;

import java.lang.reflect.Method;

/**
*@author pengchong
*@date 2019/8/27
*@function  反射获取系统属性
*
*/
public class SystemPropertyUtils {

    public static String get(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String)(get.invoke(c, key, "0" ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static String get(String key)
   {
        String value = "";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String)(get.invoke(c, key, "0" ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean getPropertyBoolean(String key,boolean defaultValue){
        boolean value = false;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("getBoolean", String.class, boolean.class);
            value = (boolean)(get.invoke(c, key, false ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
