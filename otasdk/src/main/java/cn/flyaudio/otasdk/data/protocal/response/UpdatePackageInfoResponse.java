package cn.flyaudio.otasdk.data.protocal.response;

public class UpdatePackageInfoResponse {

    private String msg;
    private String flag;
    private String description;

    public UpdatePackageInfoResponse(String msg, String flag, String description) {
        this.msg = msg;
        this.flag = flag;
        this.description = description;
    }

    public UpdatePackageInfoResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UpdatePackageInfoResponse{" +
                "msg='" + msg + '\'' +
                ", flag='" + flag + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
