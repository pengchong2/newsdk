package cn.flyaudio.otasdk.interfaces;

/**
*@author pengchong
*@date 2019/7/5
*@function  固件信息的接口
*
*/
public interface ISystemInfo {

    /**
     * 返回系统的版本号
     * @return 不能为空
     */
    String getVersion();

    /**
     * 返回系统型号
     * @return 不能为空
     */
    String getModel();

    /**
     * 返回cpu型号
     * @return 不能为空
     */
    String getCPU();
}
