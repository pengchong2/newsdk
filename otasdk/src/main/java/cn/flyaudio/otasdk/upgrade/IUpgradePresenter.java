package cn.flyaudio.otasdk.upgrade;

import android.content.Context;

/**
 * @author weifule
 * @date 19-7-3
 * Email: fulewei@foxmail.com
 * Description:MVP-P
 */
public interface IUpgradePresenter {

    int STATE_INIT = 0;
    int STATE_DOWNLOADING = 1;
    int STATE_DOWNLOAD_SUCCESS = 2;
    int STATE_DOWNLOAD_FAIL = 3;
    int STATE_DOWNLOAD_PAUSED = 4;
    int STATE_UPGRADING = 5;
    int STATE_UPGRADE_FAIL = 6;
    int STATE_UPGRADE_SUCCESS = 7;
    int STATE_UPGRADE_WRITE_DONE = 8;

    /**
     * 开始下载
     */
    void download();

    /**
     * 暂停下载
     */
    void cancelDownload();

    /**
     * 开始升级
     */
    void upgrade();

    /**
     * 安装系统包
     */
    void installSystem(Context context);

}
