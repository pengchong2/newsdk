package cn.flyaudio.otasdk.data.service;


import cn.flyaudio.otasdk.data.protocal.form.DetectionOtaVersionForm;
import cn.flyaudio.otasdk.data.protocal.form.GetCurrentOtaDetailForm;
import cn.flyaudio.otasdk.data.protocal.form.UpdateDevicePackageLogForm;
import cn.flyaudio.otasdk.data.protocal.form.UpdatePackageLogForm;
import cn.flyaudio.otasdk.data.protocal.response.CurrentOtaDetailResponse;
import cn.flyaudio.otasdk.data.protocal.response.DetectionOtaResponse;
import cn.flyaudio.otasdk.data.protocal.response.DeviceUpdatePackageLogResponse;
import cn.flyaudio.otasdk.data.protocal.response.UpdateDevicePackageLogResponse;
import cn.flyaudio.otasdk.data.protocal.response.UpdatePackageInfoResponse;
import io.reactivex.Observable;


public interface DataService {
    /**
     * 添加升级日志
     */
    Observable<DeviceUpdatePackageLogResponse> addDeviceUpdatePackageLog(UpdatePackageLogForm updatePackageLogForm);

    /**
     * 检测当前Ota是否具有新版本 #2
     */
    Observable<DetectionOtaResponse> detectionOtaVersion(DetectionOtaVersionForm detectionOtaVersionForm);

    /**
     * 查看当前的Ota详情 #1
     */
    Observable<CurrentOtaDetailResponse> getCurrentOtaDetail(GetCurrentOtaDetailForm getCurrentOtaDetailForm);
    /**
     * 下载成功或失败、更新成功或失败的接口
     */
    Observable<UpdateDevicePackageLogResponse> updateDevicePackageLog(UpdateDevicePackageLogForm updateDevicePackageLogForm);

    /**
     * 获取包信息
     * @param imei
     * @param language
     * @param packageId
     * @return
     */
    Observable<UpdatePackageInfoResponse> getPackageInfoById(String imei, String language, String packageId);

}
