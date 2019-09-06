package cn.flyaudio.otasdk.common;

/**
*@author pengchong
*@date 2019/8/27
*@function  保存常量
*
*/
public class AppConstants {
    /**
     * 开始时间
     */
    public static long startTime;
    /**
     * 结束时间
     */
    public static long endTime;

    /**
     * 是否可以点击
     */
    public static boolean isClickable = false;

    /**
     * 判断手势滑动状态的基本距离
     */
    public static final int FLIP_DISTANCE = 50;

    /**
     * 判断是否重新测量
     */
    public static boolean isRemeasure = false;
    /**
     * 皮肤包应用的包名
     */
    public static String OtaSkinPackage = "cn.flyaudio.otaskin";
    /**
     * 操作成功
     */
    public static final String OPREATION_SUCCESS = "操作成功";
    /**
     * 是否下载
     */
    public static boolean isDownLoad = false;
    /**
     * y轴记录标志
     */
    public static boolean recordInitialYFlag = false;

    /**
     * 是否在腰部
     */
    public static boolean isCenter = true;
    /**
     * 初始坐标x
     */
    public static int initialX = 0;
    /**
     * 初始坐标Y
     */
    public static int initialY = 0;



    /**
     * 主页界面的intent action
     */
    public static final String ACTION_MAIN_ACTIVITY = "cn.flyaudio.ota.main";

    /**
     * 当前系统分支：alpha,beta表示测试分支， release表示正式分支
     */
    public static final String UPGRADE_PACKAGE_IS_RELEASE = "release";
    public static final String UPGRADE_PACKAGE_IS_BETA = "beta";
    public static final String UPGRADE_PACKAGE_IS_ALPHA = "alpha";


    /**
     * 定位数据 action
     */
    public static final String ACTION_LOCATION_DATA = "cn.flyaudio.location.data";
    /**
     * key for 定位数据
     */
    public static final String KEY_LOCATION_DATA = "key_location_data";
    /**
     * action for ota 推送
     */
    public static final String ACTION_OTA_PUSH = "cn.flyaudio.otaclient.push";
    /**
     * ota 推送消息 key
     */
    public static final String KEY_OTA_PUSH_DATA = "key_ota_push_data";
    /**
     * 下载通知id
     */
    public static final int NOTIFICATION_ID_DOWNLOAD = 100;
    /**
     * 推送通知id
     */
    public static final int NOTIFICATION_ID_PUSH = 101;
    /**
     * 通知渠道id
     */
    public static final String  NOTIFICATION_CHANNEL_ID = "ota_channel";
    /**
     * action for ota 下载
     */
    public static final String ACTION_OTA_DOWNLOAD = "cn.flyaudio.otaclient.download";
    /**
     * action for ota 重新下载
     */
    public static final String ACTION_OTA_DOWNLOAD_RESTART = "cn.flyaudio.otaclient.download_restart";
    /**
     * action for 暂停下载
     */
    public static final String ACTION_OTA_DOWNLOAD_PAUSE = "cn.flyaudio.otaclient.download_pause";
    /**
     * action for 继续下载
     */
    public static final String ACTION_OTA_DOWNLOAD_RESUME = "cn.flyaudio.otaclient.download_resume";
    /**
     * action for cancel
     */
    public static final String ACTION_OTA_DOWNLOAD_CANCEL = "cn.flyaudio.otaclient.download_cancel";
    /**
     * action for 下载完成
     */
    public static final String ACTION_OTA_DOWNLOAD_COMPLETE = "cn.flyaudio.otaclient.download_complete";
    /**
     * key for 是否隐藏ota推送通知条
     */
    public static final String KEY_HIDE_OTA_PUSH_NOTIFICATION = "key_hide_ota_push_notification";
    /**
     * key for 是否隐藏升级包下载通知条
     */
    public static final String KEY_HIDE_OTA_DOWNLOAD_NOTIFICATION = "key_hide_ota_download_notification";
    /**
     * 升级准备广播 的 action
     */
    public static final String ACTION_OTA_REBOOT = "cn.flyaudio.action.OTA_REBOOT";
    /**
     * key for 升级包文件的下载任务id
     */
    public static final String KEY_UPDATE_FILE_DOWNLOAD_ID = "key_update_file_download_id";
    /**
     * 升级类型：推送升级
     */
    public static final String UPDATE_TYPE_PUSH = "update_type_push";
    /**
     * 升级类型：手动升级
     */
    public static final String UPDATE_TYPE_MANUAL = "update_type_manual";
    /**
     * key for 原系统版本 比如20190410_1209
     */
    public static final String KEY_OLD_SYSTEM_VERSION ="key_old_system_version";
    /**
     * key for 原升级包文件id
     */
    public static final String KEY_OLD_DOWNLOAD_TASK_ID ="key_old_download_task_id";
    /**
     * key for 升级log id
     */
    public static final String KEY_UPDATE_PACKAGE_LOG_ID ="key_update_package_log_id";
    /**
     * 完整包类型
     */
    public static final String PACKAGE_TYPE_COMPLETE = "2";
    /**
     * 差分包类型
     */
    public static final String PACKEGE_TYPE_DIFF = "1";
    /**
     * key for 推送升级包的信息
     */
    public static final String KEY_PUSH_OTA_PACKAGE_INFO = "key_push_ota_package_info";
    /**
     * key for 上次推送升级包的json
     */
    public static final String KEY_LAST_PUSH_PACKAGE_INFO = "key_last_push_package_info";
    /**
     * key for device key
     */
    public static final String KEY_DEVICE_KEY = "fly.device_key";
    /**
     * key for device iv
     */
    public static final String KEY_DEVICE_IV = "fly.device_iv";
    /**
     * 推送下载
     */
    public static final String DOWNLOAD_TASK_TYPE_PUSH = "push";
    /**
     * 非推送下载
     */
    public static final String DOWNLOAD_TASK_TYPE_NORMAL = "normal";
    /**
     * 是推送通知条的“下载”按钮启动的下载
     */
    public static final long NOTIFICATION_START_DOWNLOAD = 100;
    /**
     * 默认限制大小 1500 MB
     */
    public static final long DEFAULT_SIZE = 1500;
    /**
     * 事件码：更新升级包信息
     */
    public static final int EVENT_CODE_UPDATE_PACAGEINFO = 1000;
    /**
     * key for 是否是静默强制升级
     */
    public static final String  KEY_IS_FORCE_UPDATE = "key_is_force_update";
}
