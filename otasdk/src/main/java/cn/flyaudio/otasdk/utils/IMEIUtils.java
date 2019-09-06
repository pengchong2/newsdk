package cn.flyaudio.otasdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Method;

/**
*@author pengchong
*@date 2019/8/27
*@function  获取IMEI的工具类
*
*/
public class IMEIUtils {

    private static final String TAG = "Utils";

    private static String IMEI = null;

    /**
     * 获取imei
     * Invoke
     * @param context
     * @return imei
     */
    public static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(IMEI)) {
            return IMEI;
        }else {
            Class<?> cx = null;
            Object obj = null;
            try {
                cx = Class.forName("android.telephony.TelephonyManager");
                obj = context.getSystemService(Context.TELEPHONY_SERVICE);
                Method imeiMethod = cx.getMethod("getImei");
                IMEI = (String) imeiMethod.invoke(obj);
            } catch (Exception e) {
                IMEI = null;
                Log.e(TAG,"getDeviceImeiCode getImei Exception e : " + e.toString());
            }

            try {
                if (TextUtils.isEmpty(IMEI)) {
                    Method dviceIdMethod = cx.getMethod("getDeviceId");
                    IMEI = (String) dviceIdMethod.invoke(obj);
                }
            } catch (Exception e) {
                Log.e(TAG,"getDeviceImeiCode getDeviceId Exception e : " + e.toString());
            }

        }

        if (!isLegalImei(IMEI)) {
            IMEI = null;
        }

        Log.d(TAG,"getIMEI====" + IMEI);

        return IMEI;
    }

    /**
     * 是否是合法的Imei
     * @param imei
     * @return
     */
    private static boolean isLegalImei(String imei){
        if (!TextUtils.isEmpty(imei)&&imei.length()==15&&!imei.equals("000000000000000")) {
            return true;
        }
        return false;
    }
}