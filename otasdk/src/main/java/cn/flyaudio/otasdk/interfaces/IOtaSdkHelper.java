package cn.flyaudio.otasdk.interfaces;

public interface IOtaSdkHelper {

    /**
     * 初始化传入的系统信息
     * @param deviceid  设备唯一ID ,可以为sn号或者mac地址
     * @param systeminfo 系统信息
     */
    void init(String deviceid,ISystemInfo systeminfo);

    /**
     *获取ota实例
     * @param pid  产品ID 申请使用SDK的时候获取
     * @param ps 产品密钥 申请使用SDK的时候获取
     * @return ota的实例
     */
    IOtaAgent getInt(String pid,String ps);

    /**
     * 设置升级包下载存储路径
     * 注明：建议使用API获取到这个路径
     *      若不设置，默认为/cache分区路径，android 8.1以后为/data/cache
     * @param path 路径
     */
    void setUpgradePath(String path);

    /**
     * 设置升级过程日志信息的生成路径
     * @param path 日志路径
     */
    void setLogPath(String path);

    /**
     * 设置日志级别
     * @param level 级别 2-6 verbose-error
     */
    void setLogLevel(int level);

    /**
     * 设置是否要进行自动检测,该功能默认开启，SDK会定时请求更新(30min),若检查到更新，SDK会发送一个action为
     * otasdk.ota.Constants.BROADCAST_NEWVERSION的本地广播，开发者可以根据此广播信息来完成后续的升级步骤
     * 广播里面会携带升级包的信息
     * @param check 自动检查更新
     */
    void setAutoCheck(boolean check);

    /**
     * 设置静默升级时间段
     * @param starttime 开始时间 格式 时:分钟 10:43
     * @param endtime 结束时间  格式 时:分钟 18:00  24小时制
     */
    void setSlientUpgradeTime(String starttime,String endtime);

    /**
     * 设置扩展选项
     * @param key  key=1:下载进度反馈时间间隔，val为毫秒默认300毫秒
     *             key=2;下载连接超时时间，val为毫秒默认20000毫秒
     *             key=3:下载读流超时时间，val为毫秒默认60000毫秒
     *             key=4:下载失败重试次数，val为次数，默认3次
     *             key=5:网络异常导致的下载失败，网络恢复后是否完成断点下载，默认开启 1启用 0不启动
     * @param value
     */
    void setExtOption(String key,String value);

}
