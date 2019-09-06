package cn.flyaudio.otasdk.data.protocal.form;

public class UpdatePackageLogForm {
    /**
     *地区行政编码
     */
    private String adcode;
    /**
     * OTA安装包是否下载成功，1-未知，2-失败，3-成功:此处调用填写1
     */
    private String downloadSucess;
    /**
     * 升级车机imei
     */
    private String imei;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 升级包Id，检测时返回的Id
     */
    private String packageId;
    /**
     * OTA是否升级成功，1-未知，2-失败 3-成功：此处调用是填写1
     */
    private String updateSuccess;
    /**
     * 升级类型，1-推送升级，2-手动升级
     */
    private String updateType;

    public UpdatePackageLogForm(String adcode, String downloadSucess, String imei, String latitude, String longitude, String packageId, String updateSuccess, String updateType) {

        this.adcode = adcode;
        this.downloadSucess = downloadSucess;
        this.imei = imei;
        this.latitude = latitude;
        this.longitude = longitude;
        this.packageId = packageId;
        this.updateSuccess = updateSuccess;
        this.updateType = updateType;

    }

    public UpdatePackageLogForm(){}

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getDownloadSucess() {
        return downloadSucess;
    }

    public void setDownloadSucess(String downloadSucess) {
        this.downloadSucess = downloadSucess;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getUpdateSuccess() {
        return updateSuccess;
    }

    public void setUpdateSuccess(String updateSuccess) {
        this.updateSuccess = updateSuccess;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    @Override
    public String toString() {

        return "UpdatePackageLogForm{" +
                "adcode='" + adcode + '\'' +
                ", downloadSucess='" + downloadSucess + '\'' +
                ", imei='" + imei + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", packageId='" + packageId + '\'' +
                ", updateSuccess='" + updateSuccess + '\'' +
                ", updateType='" + updateType + '\'' +
                '}';

    }
}
