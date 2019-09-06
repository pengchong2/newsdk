package cn.flyaudio.otasdk.interfaces;

/**
*@author pengchong
*@date 2019/8/20
*@function  升级包升级过程的回调
*
*/
public interface IUpgradeListener {

    /**
     * 升级进度更新
     * @param progress 升级进度 1-100
     */
    void onProgress(  int progress);

    /**
     * 升级失败
     * @param errorCode 错误码 见ErrorCode
     * @param reason 失败原因
     */
    void onFailed( int errorCode, String reason);

    /**
     * 升级成功
     */
    void onSuccess();
}
