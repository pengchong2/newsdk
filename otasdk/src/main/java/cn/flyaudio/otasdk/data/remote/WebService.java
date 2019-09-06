package cn.flyaudio.otasdk.data.remote;

import cn.flyaudio.otasdk.data.BaseResp;
import cn.flyaudio.otasdk.data.protocal.form.DetectionOtaVersionForm;
import cn.flyaudio.otasdk.data.protocal.form.GetCurrentOtaDetailForm;
import cn.flyaudio.otasdk.data.protocal.form.GetPackageInfoForm;
import cn.flyaudio.otasdk.data.protocal.form.UpdateDevicePackageLogForm;
import cn.flyaudio.otasdk.data.protocal.form.UpdatePackageLogForm;
import cn.flyaudio.otasdk.data.protocal.response.CurrentOtaDetailResponse;
import cn.flyaudio.otasdk.data.protocal.response.DetectionOtaResponse;
import cn.flyaudio.otasdk.data.protocal.response.DeviceUpdatePackageLogResponse;
import cn.flyaudio.otasdk.data.protocal.response.UpdateDevicePackageLogResponse;
import cn.flyaudio.otasdk.data.protocal.response.UpdatePackageInfoResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
*@author pengchong
*@date 2019/8/23
*@function  retrofit请求接口定义
*
*/
public interface WebService {

    /**
     * 添加升级日志
     */
    @POST("otaDevice/addDeviceUpdatePackageLog")
    Observable<BaseResp<DeviceUpdatePackageLogResponse>> addDeviceUpdatePackageLog(@Body UpdatePackageLogForm updatePackageLogForm);

    /**
     * 检测当前ota是否具有新版本#2
     */
    @POST("otaDevice/detectionOtaVersion")
    Observable<BaseResp<DetectionOtaResponse>> detectionOtaVersion(@Body DetectionOtaVersionForm detectionOtaVersionForm);

    /**
     * 查看当前OTA详情#1
     */
    @POST("otaDevice/getCurrentOtaDetail")
    Observable<BaseResp<CurrentOtaDetailResponse>> getCurrentOtaDetail(@Body GetCurrentOtaDetailForm getCurrentOtaDetailForm);

    /**
     * 下载成功或失败、更新成功或失败接口
     */
    @POST("otaDevice/updateDevicePackageLog")
    Observable<BaseResp<UpdateDevicePackageLogResponse>> updateDevicePackageLog(@Body UpdateDevicePackageLogForm UpdateDevicePackageLogForm);

    /**
     * 获取包信息
     * @param getPackageInfoForm
     * @return
     */
    @POST("otaDevice/getPackageDetailByPackageId")
    Observable<BaseResp<UpdatePackageInfoResponse>> getPackageDetailByPackageId(@Body GetPackageInfoForm getPackageInfoForm);

}
