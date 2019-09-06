package cn.flyaudio.otasdk.interfaces;

public interface IOtaAgent {

    /**
     * 得到系统的版本号和sdk的版本号
     * @return json {system_version:"";sdk_version:""}
     */
    String getSdkInfo();

    /**
     * 获取产品ID
     * @return
     */
    String getProductId();

    /**
     * 检查升級包是否有更新
     * @param listener 更新后的回调
     */
    void checkUpdate( ICheckUpdateListener listener);


    /**
     * 下载升级包
     * @param listener 下载的回调
     */
    void downLoad( IDownloadListener listener);

    /**
     * 下载终止，下次下载会继续上次的下载，不会丢失上一次的数据
     */
    void downLoadAbort();

    /**
     * 升级包更新
     * @param lsitener
     */
    void upgrade( IUpgradeListener lsitener);


}
