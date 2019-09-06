package cn.flyaudio.otasdk.data.protocal.response;

public class DeviceUpdatePackageResponse {
    private String flag;

    private String msg;

    public DeviceUpdatePackageResponse(String flag, String msg) {
        this.flag = flag;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "DeviceUpdatePackageResponse{" +
                "flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
