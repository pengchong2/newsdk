package cn.flyaudio.otasdk.interfaces;

/**
*@author pengchong
*@date 2019/8/20
*@function  升级包下载过程中的回调接口
*
*/
public interface IDownloadListener {

    /**
     * 等待下载
     */
    void onPending();

    /**
     * 下载任务已开始
     */
    void onPrepare();

    /**
     * 下载进度更新
     * @param currentByte 当前已经下载的字节数
     * @param totalByte 升级包总的字节数
     */
    void onProgress( int currentByte, int totalByte);

    /**
     * 下载中断
     */
    void onPaused();

    /**
     * 下载失败
     * @param errorCode 错误码 见ErrorCode
     * @param reason 错误原因
     */
    void onFailed( int errorCode, String reason);

    /**
     * 下载完成
     */
    void onFinished();
}
