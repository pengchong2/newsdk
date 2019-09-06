package cn.flyaudio.otasdk.interfaces;

/**
*@author pengchong
*@date 2019/8/20
*@function  定义检查升级包，下载升级包，升级过程中错误码
*
*/
public class ErrorCode {

    //检查更新包的错误码
    //参数错误
    public static final int CHECK_PARAM_ERROR = 1;
    //网络错误
    public static final int CHECK_NET_ERROR = 2;
    //没有更新包
    public static final int CHECK_NO_UPDATE = 3;
    //车机没有imei号
    public static final  int CHECK_NO_IMEI = 4;
    //车机没有key
    public static final  int CHECK_NO_KEY = 5;
    //服务器返回值为null
    public static final  int CHECK_RETURN_EMPTY = 6;
    //服务器没有新的更新包
    public static final int CHECK_NO_PACKAGE = 7;
    //服务器操作失败
    public static final int CHECK_OPERATE_ERROR = 8;
    //服务器返回值为null
    public static final int CHECK_RETURN_NULL = 9;



    //下载回调错误码
    //参数错误
    public static final int DOWNLOAD_PARAM_ERROR = 11;
    //网络错误
    public static final int DOWNLOAD_NET_ERROR = 12;
    //终端空间不足
    public static final int DOWNLOAD_NO_SPACE = 13;
    //sha1校验失败
    public static final int DOWNLOAD_SHA1_VERIFY_ERROR = 14;

    //升级过程的错误码
    //参数错误
    public static final int UPGRADE_PARAM_ERROR = 21;
    //sha1校验失败
    public static final int UPGRADE_SHA1_VERIFY_ERROR = 22;
    //文件不存在
    public static final int UPGRADE_FILE_NOT_EXIST_ERROR = 23;
   //升级自定义错误
    public static final int UPGRADE_CUSTOM_ERROR = 24;
    //用户取消升级
    public static final int UPGRADE_USER_NOT_CONFIRM = 25;

    private ErrorCode() {
    }
}
