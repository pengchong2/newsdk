package cn.flyaudio.otasdk.data.remote;


import javax.inject.Inject;
import cn.flyaudio.otasdk.data.BaseResp;
import cn.flyaudio.otasdk.data.net.RetrofitFactory;
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

/**
*@author pengchong
*@date 2019/8/23
*@function retrofit请求接口的实现
*
*/
public class WebRepository {


    /**
     * 查看OTA详情 #1
     * @param getCurrentOtaDetailForm
     * @return 请求后的返回数据
     */
    public Observable<BaseResp<CurrentOtaDetailResponse>> getCurrentOtaDetail(GetCurrentOtaDetailForm getCurrentOtaDetailForm){

        return RetrofitFactory.getRetrofit().create(WebService.class)
                .getCurrentOtaDetail(getCurrentOtaDetailForm);

    }

    /**
     * 检测当前ota是否具有新版本 #2
     * @return 请求后的返回数据
     */
    public Observable<BaseResp<DetectionOtaResponse>> detectionOtaVersion(DetectionOtaVersionForm detectionOtaVersionForm){
        return RetrofitFactory.getRetrofit().create(WebService.class)
                .detectionOtaVersion(detectionOtaVersionForm);
    }

    /**
     * 添加升级日志
     * @return 请求后的返回数据
     */
    public Observable<BaseResp<DeviceUpdatePackageLogResponse>> addDeviceUpdatePackageLog(UpdatePackageLogForm updatePackageLogForm){
        return RetrofitFactory.getRetrofit().create(WebService.class)
                .addDeviceUpdatePackageLog(updatePackageLogForm);
    }

    /**
     *
     * @param updatePackageLogForm updatePackageLogForm
     * @return 请求后的返回数据
     */
    public Observable<BaseResp<UpdateDevicePackageLogResponse>> updateDevicePackageLog(UpdateDevicePackageLogForm updatePackageLogForm){

        return RetrofitFactory.getRetrofit().create(WebService.class)
                .updateDevicePackageLog(updatePackageLogForm);

    }

    /**
     * 获取包信息
     * @param getPackageInfoForm
     * @return
     */
    public Observable<BaseResp<UpdatePackageInfoResponse>> getPackageDetailById(GetPackageInfoForm getPackageInfoForm){
        return RetrofitFactory.getRetrofit()
                .create(WebService.class)
                .getPackageDetailByPackageId(getPackageInfoForm);

    }

}
