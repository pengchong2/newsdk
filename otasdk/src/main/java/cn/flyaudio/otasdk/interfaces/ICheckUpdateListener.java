package cn.flyaudio.otasdk.interfaces;


import cn.flyaudio.otasdk.data.protocal.response.DetectionOtaResponse;

/**
*@author  pengchong
*@date 2019/8/20
*@function  检查服务器升级包的回调接口
*
*/
public interface ICheckUpdateListener {

    /**
     * 成功后的回调
     * @param info 返回的信息有version(版本号)，info(更新信息) url(升级包下载路径)，
     *  size(升级包的大小byte)其他的参数按照实际需求添加，返回成功后可以调用IOtaAgent::downLoad()下载升级包
     * @param exist 升级包是否已经下载，如果下载完后，直接调用IOtaAgent::upgrade()安装升级
     */
    void onSuccess(DetectionOtaResponse.Info info, boolean exist);

    /**
     * 失败后的回调
     * @param errorCode 错误码 见ErrorCode
     * @param reason 错误原因
     */
    void onFail(int errorCode,String reason);
}
