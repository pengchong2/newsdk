package cn.flyaudio.otasdk.data.protocal.form;

public class UpdateDevicePackageLogForm {

    /**
     * 更新升级包日志状态的请求模型
     */
    private String id;
    /**
     * imei
     */
    private String imei;
    /**
     * 1-未知，2-失败，3-成功
     */
    private String status;
    /**
     * 1-下载、2-更新
     */
    private String type;

    @Override
    public String toString() {
        return "UpdateDevicePackageLogForm{" +
                "id='" + id + '\'' +
                ", imei='" + imei + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {

        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
