package cn.flyaudio.otasdk.data.protocal.response;

import android.os.Parcel;
import android.os.Parcelable;

public class DetectionOtaResponse {
    public DetectionOtaResponse(){}
    /**
     * 业务返回码
     */
    private String flag;

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

    /**
     * 业务描述
     */
    private String msg;
    /**
     * 更新包详情信息
     */
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static class Info implements Parcelable {
        public Info(){}
        private String packageName;

        private String id;

        private String fileId;

        private String currentVesion;

        private String newVersion;

        private String size;

        private String description;

        private String allowDownloadEnv;

        private String spaceLimit;

        private String type;

        private String allowUpdateTime;

        private String sendType;

        private String isompulsory;

        private String way;

        private String imei;

        private String packageType;

        protected Info(Parcel in) {
            packageName = in.readString();
            id = in.readString();
            fileId = in.readString();
            currentVesion = in.readString();
            newVersion = in.readString();
            size = in.readString();
            description = in.readString();
            allowDownloadEnv = in.readString();
            spaceLimit = in.readString();
            type = in.readString();
            allowUpdateTime = in.readString();
            sendType = in.readString();
            isompulsory = in.readString();
            way = in.readString();
            imei = in.readString();
            packageType = in.readString();
        }

        public static final Creator<Info> CREATOR = new Creator<Info>() {
            @Override
            public Info createFromParcel(Parcel in) {
                return new Info(in);
            }

            @Override
            public Info[] newArray(int size) {
                return new Info[size];
            }
        };

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(packageName);
            dest.writeString(id);
            dest.writeString(fileId);
            dest.writeString(currentVesion);
            dest.writeString(newVersion);
            dest.writeString(size);
            dest.writeString(description);
            dest.writeString(allowDownloadEnv);
            dest.writeString(spaceLimit);
            dest.writeString(type);
            dest.writeString(allowUpdateTime);
            dest.writeString(sendType);
            dest.writeString(isompulsory);
            dest.writeString(way);
            dest.writeString(imei);
            dest.writeString(packageType);
        }

        public Info(String packageName, String id, String fileId, String currentVersion, String newVersion, String size, String description, String allowDownloadEnv, String spaceLimit, String type, String allowUpdateTime, String sendType, String isompulsory, String way, String imei, String packageType) {
            this.packageName = packageName;
            this.id = id;
            this.fileId = fileId;
            this.currentVesion = currentVersion;
            this.newVersion = newVersion;
            this.size = size;
            this.description = description;
            this.allowDownloadEnv = allowDownloadEnv;
            this.spaceLimit = spaceLimit;
            this.type = type;
            this.allowUpdateTime = allowUpdateTime;
            this.sendType = sendType;
            this.isompulsory = isompulsory;
            this.way = way;
            this.imei = imei;
            this.packageType = packageType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getCurrentVersion() {
            return currentVesion;
        }

        public void setCurrentVersion(String currentVersion) {
            this.currentVesion = currentVersion;
        }

        public String getNewVersion() {
            return newVersion;
        }

        public void setNewVersion(String newVersion) {
            this.newVersion = newVersion;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAllowDownloadEnv() {
            return allowDownloadEnv;
        }

        public void setAllowDownloadEnv(String allowDownloadEnv) {
            this.allowDownloadEnv = allowDownloadEnv;
        }

        public String getSpaceLimit() {
            return spaceLimit;
        }

        public void setSpaceLimit(String spaceLimit) {
            this.spaceLimit = spaceLimit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAllowUpdateTime() {
            return allowUpdateTime;
        }

        public void setAllowUpdateTime(String allowUpdateTime) {
            this.allowUpdateTime = allowUpdateTime;
        }

        public String getSendType() {
            return sendType;
        }

        public void setSendType(String sendType) {
            this.sendType = sendType;
        }

        public String getIsompulsory() {
            return isompulsory;
        }

        public void setIsompulsory(String isompulsory) {
            this.isompulsory = isompulsory;
        }

        public String getWay() {
            return way;
        }

        public void setWay(String way) {
            this.way = way;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getPackageType() {
            return packageType;
        }

        public void setPackageType(String packageType) {
            this.packageType = packageType;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "packageName='" + packageName + '\'' +
                    ", id='" + id + '\'' +
                    ", fileId='" + fileId + '\'' +
                    ", currentVersion='" + currentVesion + '\'' +
                    ", newVersion='" + newVersion + '\'' +
                    ", size='" + size + '\'' +
                    ", description='" + description + '\'' +
                    ", allowDownloadEnv='" + allowDownloadEnv + '\'' +
                    ", spaceLimit='" + spaceLimit + '\'' +
                    ", type='" + type + '\'' +
                    ", allowUpdateTime='" + allowUpdateTime + '\'' +
                    ", sendType='" + sendType + '\'' +
                    ", isompulsory='" + isompulsory + '\'' +
                    ", way='" + way + '\'' +
                    ", imei='" + imei + '\'' +
                    ", packageType='" + packageType + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }


    }

}
