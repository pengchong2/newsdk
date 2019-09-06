package cn.flyaudio.otasdk.data.protocal.form;

public class GetPackageInfoForm {
    private String imei;
    private String lan;
    private String packageId;

    public GetPackageInfoForm(String imei, String lan, String packageId) {
        this.imei = imei;
        this.lan = lan;
        this.packageId = packageId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return "GetPackageInfoForm{" +
                "imei='" + imei + '\'' +
                ", lan='" + lan + '\'' +
                ", packageId='" + packageId + '\'' +
                '}';
    }
}
