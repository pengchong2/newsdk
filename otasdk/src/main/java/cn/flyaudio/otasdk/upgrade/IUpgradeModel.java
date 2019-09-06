package cn.flyaudio.otasdk.upgrade;

/**
 * @author weifule
 * @date 19-7-3
 * Email: fulewei@foxmail.com
 * Description:MVP-M
 */
public interface IUpgradeModel {
    /**
     * 检查更新
     */
    void checkUpdate();

    /**
     * 下载
     */
    void download();

    /**
     * 取消下载
     */
    void cancelDownload();

    /**
     * 升级
     */
    void upgrade();
}
