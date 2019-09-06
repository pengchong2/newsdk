package cn.flyaudio.otasdk.data.protocal.response;

public class CurrentOtaDetailResponse {
    /**
     * Imei
     */
    private String Imei;
    /**
     * 标志
     */
    private String flag;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 描述
     */
    private String description;

    /**
     * 构造方法
     * @param imei Imei
     * @param flag 标志
     * @param msg  返回消息
     * @param description 描述
     */
    public CurrentOtaDetailResponse(String imei, String flag, String msg, String description) {
        Imei = imei;
        this.flag = flag;
        this.msg = msg;
        this.description = description;
    }

    public String getImei() {
        return Imei;
    }

    public void setImei(String imei) {
        Imei = imei;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CurrentOtaDetailResponse{" +
                "Imei='" + Imei + '\'' +
                ", flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
