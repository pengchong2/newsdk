package cn.flyaudio.otasdk;

/**
 * @author weifule
 * @date 19-7-4
 * Email: fulewei@foxmail.com
 * Description:
 */
public interface IFlyFotaProxy {

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

}
