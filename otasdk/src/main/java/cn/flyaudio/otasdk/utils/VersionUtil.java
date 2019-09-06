package cn.flyaudio.otasdk.utils;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Locale;
import cn.flyaudio.otasdk.FlyFotaApplicationInit;
import cn.flyaudio.otasdk.common.AppConstants;

/**
*@author pengchong
*@date 2019/8/27
*@function  版本信息工具类
*
*/
public class VersionUtil {
    private static String TAG = "VersionUtil";
    /**
     * 默认加密用的key,测试阶段没法烧写key,所以暂用default_key
     */
    private static final String DEFAULT_TEST_KEY = "flyaudio_aes2580";
    /**
     * 默认加密用的iv,测试阶段没法烧写key,所以暂用default_iv
     */
    private static final String DEFAULT_TEST_IV = "20ACB4C429BF0321";
    /**
     * 旧版本，也就是系统当前的版本 ，比如20190330_1130
     */
    private  String oldVersion="";
    /**
     * 分支,比如测试分支alpha,发布分支release
     */
    private  String systemBranchMode= "";
    /**
     * 车机Android 版本  比如6.0.0
     */
    private  String systemVersion = "";
    /**
     * imei
     */
    private  String imei = "";

    /**
     * 数据加解密用的key 默认为
     */
    private String key = "";
    /**
     * 数据加解密用的iv
     */
    private String iv = "";
    /**
     * 平台 比如 G8III
     */
    private  String carPlatform = "";
    /**
     * 机型 比如 CHN_DuerOS_VS960X1280
     */
    private String carType = "";
    /**
     * android 系统版本 比如6.0.0
     */
    private  String carVersion = "";
    /**
     * 当前系统对应的OTA升级包版本号，比如20190330_1130
     */
    private String otaVersion = "";
    /**
     * 升级包分属：正式版，测试版，公测版("alpha or realease")
     */
    private String packageProperty = "";
    /**
     * 当前系统对应的OTA升级包包名
     */
    private String packageName = "";


    /**
     * 构造私有
     * @param context
     */
    private VersionUtil(Context context) {

        init(context);

    }

    /**
     * 单例
     */
    private static VersionUtil mInstance;

    /**
     * 获取单例
     * @return
     */
    public static VersionUtil getInstance(Context context){

        if (mInstance == null){

            synchronized (VersionUtil.class){

                if (mInstance == null){

                    mInstance = new VersionUtil(context);

                }

            }
        }
        return mInstance;

    }

    public void init(Context context){

        //厂商平台,G8III
        carPlatform = SystemPropertyUtils.get("fly.ota.platform");
        //机型 CHN_DuerOS_VS960X1280
         carType = SystemPropertyUtils.get("fly.ota.model");
//        carType = "CHN_DuerOS_VS960X1280";
        //系统版本"6.0.0"
      //  carType = "CHN_DUEROS";
        //android系统版本 "6.0.0"
        carVersion = SystemPropertyUtils.get("fly.ota.android.ver");
        // ota当前版本"20190413_1449"
        otaVersion = SystemPropertyUtils.get("ro.release.version");
//       otaVersion = "20190413_1449";
        // 升级包分属：正式版，测试版，公测版"alpha or realease"
        packageProperty = SystemPropertyUtils.get("fly.ota.branchmode");
        // 当前系统对应的升级包完整包包名：例 flyupdate-G8III-CHN_DUEROS-6.0.0-alpha-com-20190413_1449.fup
        packageName = "flyupdate"+"-"+carPlatform+"-"+carType+"-"+carVersion+"-"+packageProperty+"-"+"com"+"-"+otaVersion+".fup";
        /*************************请求参数**************************/
        //当前版本
        oldVersion = SystemPropertyUtils.get("ro.release.version", "20160423_0920");
//        oldVersion = "20190413_1449";
        //测试版本
        systemBranchMode = SystemPropertyUtils.get("fly.ota.branchmode", AppConstants.UPGRADE_PACKAGE_IS_RELEASE);
        //android系统版本
        systemVersion = SystemPropertyUtils.get("fly.ota.android.ver");
       //车机IMEI
        imei = IMEIUtils.getIMEI(context);
        initKey();
    }

    /**
     * 初始化key,iv
     *
     */

    private void initKey(){
       key = SystemPropertyUtils.get(AppConstants.KEY_DEVICE_KEY);
       iv = SystemPropertyUtils.get(AppConstants.KEY_DEVICE_IV);
    }

    public String getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(String oldVersion) {
        this.oldVersion = oldVersion;
    }

    public String getSystemBranchMode() {
        return systemBranchMode;
    }

    public void setSystemBranchMode(String systemBranchMode) {
        this.systemBranchMode = systemBranchMode;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getImei() {
        if (TextUtils.isEmpty(imei)){
            imei = IMEIUtils.getIMEI(FlyFotaApplicationInit.mContext);
        }
        return imei;
    }


    public String getKey() {
        if (TextUtils.isEmpty(key)){
            key =  SystemPropertyUtils.get(AppConstants.KEY_DEVICE_KEY);
        }
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIv() {
        if (TextUtils.isEmpty(iv)){
            iv = SystemPropertyUtils.get(AppConstants.KEY_DEVICE_IV);
        }
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCarPlatform() {
        return carPlatform;
    }

    public void setCarPlatform(String carPlatform) {
        this.carPlatform = carPlatform;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarVersion() {
        return carVersion;
    }

    public void setCarVersion(String carVersion) {
        this.carVersion = carVersion;
    }

    public String getOtaVersion() {
        return otaVersion;
    }

    public void setOtaVersion(String otaVersion) {
        this.otaVersion = otaVersion;
    }

    public String getPackageProperty() {
        return packageProperty;
    }

    public void setPackageProperty(String packageProperty) {
        this.packageProperty = packageProperty;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 获取当前系统语言  比如zh_CN
     * @return
     */
    public  String getCurrentLanguageAndCountry(){
        // 获取系统当前使用的语言
        String mCurrentLanguage = Locale.getDefault().getLanguage();
        String mCurrentCountry = Locale.getDefault().getCountry();
        return mCurrentLanguage+"_"+mCurrentCountry;
    }


    /**
     * 标志对应的键名
     */
    public static final String FLYMQTTSERVICE_FLAG_KEY = "flag_key";
    /**
     * 检查IMEI有没有录入
     */
    public static final int FLYMQTTSERVICE_FLAG_CHECK_DEVICE_INPUT = 2009;
    /**
     * 触发智慧飞歌服务检查设备IMEI有没有录入
     */
    public static void checkDeviceInput(){

        Intent intent = new Intent();
        intent.putExtra(FLYMQTTSERVICE_FLAG_KEY,FLYMQTTSERVICE_FLAG_CHECK_DEVICE_INPUT);
        ComponentName componentName = new ComponentName("cn.flyaudio.flyaudiosmartservice2019","cn.flyaudio.flyaudiosmartservice2019.business.service.FlyMqttService");
        intent.setComponent(componentName);
        FlyFotaApplicationInit.mContext.startService(intent);

    }


    @Override
    public String toString() {

        return "VersionUtil{" +
                " language= '"+getCurrentLanguageAndCountry()+'\''+
                ", oldVersion='" + oldVersion + '\'' +
                ", systemBranchMode='" + systemBranchMode + '\'' +
                ", carPlatform='" + carPlatform + '\'' +
                ", carVersion='" + carVersion + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                ", imei='" + imei + '\'' +
                ", key='" + key + '\'' +
                ", iv='" + iv + '\'' +
                '}';

    }


}
