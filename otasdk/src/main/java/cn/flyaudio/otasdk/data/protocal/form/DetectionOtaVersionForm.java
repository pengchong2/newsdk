package cn.flyaudio.otasdk.data.protocal.form;


/**
*@author pengchong
*@date 2019/8/23
*@function 查询升级包更新需要传递的表单
*
*/
public class DetectionOtaVersionForm {

    /**
     * imei
     */
    private String imei;
    /**
     * 语言
     */
    private String lan;
    /**
     * json字符串加密的字符串
     */
    private String data;

    public DetectionOtaVersionForm(String imei, String lan,String data) {

        this.imei = imei;
        this.lan = lan;
        this.data = data;

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DetectionOtaVersionForm{" +
                "imei='" + imei + '\'' +
                ", lan='" + lan + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
