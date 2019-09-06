package cn.flyaudio.otasdk.upgrade;

import cn.flyaudio.otasdk.recovery.RecoveryAdapter;

/**
 * @author weifule
 * @date 19-7-1
 * Email: fulewei@foxmail.com
 * Description: MVP-V
 */
public interface IUpgrade {

    /**
     * 下载状态的变化
     */
    void onStateChanged();

    /**
     * 下载进度
     * @param progress
     */
    void onDownloadProgress(int progress);

    /**
     * 下载失败
     */
    void onDownloadFail(int code, String reason);

    /**
     * 下载中断
     */
    void onDownloadPaused();

    /**
     * 下载成功
     */
    void onDownloadSuccess();

    /**
     * 升级进度反馈
     */
    void onUpgradeProgress(int progress);

    /**
     * 升级失败
     */
    void onUpgradeFail(int code, String reason);

    /**
     * 安装写入完成
     */
    void onUpgradeWriteDone();

    /**
     * 升级成功
     */
    void onUpgradeSuccess();

    /**
     * 用户需要自己实现升级方式
     * @return
     */
    RecoveryAdapter getRecoveryAdapter();
}
