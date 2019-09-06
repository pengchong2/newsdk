package cn.flyaudio.otasdk.data.protocal.form;

public class GetCurrentOtaDetailForm {
    /**
     * imei
     */
    private String imei;
    /**
     * 语言
     */
    private String lan;
    /**
     * 车机ota当前版本
     */
    private String version;
    /**
     * 升级包属性，正式版，测试版，公测版
     */
    private String packageProperty;


    public String getPackageProperty() {

        return packageProperty;

    }

    public void setPackageProperty(String packageProperty) {

        this.packageProperty = packageProperty;

    }

    public GetCurrentOtaDetailForm(String imei, String lan, String packagePropertity,String version) {

        this.imei = imei;
        this.lan = lan;
        this.packageProperty = packagePropertity;
        this.version = version;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "GetCurrentOtaDetailForm{" +
                "imei='" + imei + '\'' +
                ", lan='" + lan + '\'' +
                ", version='" + version + '\'' +
                ", packageProperty='" + packageProperty + '\'' +
                '}';
    }
}
