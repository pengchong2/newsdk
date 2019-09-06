package cn.flyaudio.otasdk.data.protocal.response;

public class DeviceUpdatePackageLogResponse {

    private String flag;

    private String msg;

    private String id;

    public DeviceUpdatePackageLogResponse(String flag, String msg, String id) {
        this.flag = flag;
        this.msg = msg;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeviceUpdatePackageLogResponse{" +
                "flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
