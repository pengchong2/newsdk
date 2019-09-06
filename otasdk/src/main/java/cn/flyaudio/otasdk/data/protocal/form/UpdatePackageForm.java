package cn.flyaudio.otasdk.data.protocal.form;

public class UpdatePackageForm {

    /**
     * 模型
     */
    private String carPlat;
    /**
     * 版本
     */
    private String carType;
    /**
     * 系统版本
     */
    private String carVersion;
    /**
     * 升级包子版本：传差分包的时候使用
     */
    private String childVersion;
    /**
     * 文件Key
     */
    private String fileId;
    /**
     * 新版本：传差分包的时候使用
     */
    private String newVersion;
    /**
     * 传查分包的时候使用
     */
    private String oldVersion;
    /**
     * 升级包名称
     */
    private String packageName;
    /**
     * 所属渠道
     */
    private String packageProperty;
    /**
     * 包类型,1-查分包,2-完整包
     */
    private String packageType;
    /**
     * 升级包父版本：传差分包的时候使用
     */
    private String parentVersion;
    /**
     * 完整包的大小，单位:字节
     */
    private String size;
    /**
     * 当前包版本
     */
    private String version;

    public UpdatePackageForm(String carPlat, String carType, String carVersion, String childVersion, String fileId, String newVersion, String oldVersion, String packageName, String packageProperty, String packageType, String parentVersion, String size, String version) {

        this.carPlat = carPlat;
        this.carType = carType;
        this.carVersion = carVersion;
        this.childVersion = childVersion;
        this.fileId = fileId;
        this.newVersion = newVersion;
        this.oldVersion = oldVersion;
        this.packageName = packageName;
        this.packageProperty = packageProperty;
        this.packageType = packageType;
        this.parentVersion = parentVersion;
        this.size = size;
        this.version = version;

    }

    public String getCarPlat() {
        return carPlat;
    }

    public void setCarPlat(String carPlat) {
        this.carPlat = carPlat;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarVersion() {
        return carVersion;
    }

    public void setCarVersion(String carVersion) {
        this.carVersion = carVersion;
    }

    public String getChildVersion() {
        return childVersion;
    }

    public void setChildVersion(String childVersion) {
        this.childVersion = childVersion;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(String oldVersion) {
        this.oldVersion = oldVersion;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageProperty() {
        return packageProperty;
    }

    public void setPackageProperty(String packageProperty) {
        this.packageProperty = packageProperty;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getParentVersion() {
        return parentVersion;
    }

    public void setParentVersion(String parentVersion) {
        this.parentVersion = parentVersion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "UpdatePackageForm{" +
                "carPlat='" + carPlat + '\'' +
                ", carType='" + carType + '\'' +
                ", carVersion='" + carVersion + '\'' +
                ", childVersion='" + childVersion + '\'' +
                ", fileId='" + fileId + '\'' +
                ", newVersion='" + newVersion + '\'' +
                ", oldVersion='" + oldVersion + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageProperty='" + packageProperty + '\'' +
                ", packageType='" + packageType + '\'' +
                ", parentVersion='" + parentVersion + '\'' +
                ", size='" + size + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
