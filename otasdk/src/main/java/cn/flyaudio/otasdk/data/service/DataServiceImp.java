package cn.flyaudio.otasdk.data.service;

import javax.inject.Inject;

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
import cn.flyaudio.otasdk.data.remote.WebRepository;
import cn.flyaudio.otasdk.ext.CommonExt;
import io.reactivex.Observable;


public class DataServiceImp implements DataService {

  private WebRepository webRepository;

  public DataServiceImp(){
      webRepository = new WebRepository();
  }

    /**
     * 添加升级日志
     * @param updatePackageLogForm
     * @return
     */
    @Override
    public Observable<DeviceUpdatePackageLogResponse> addDeviceUpdatePackageLog(UpdatePackageLogForm updatePackageLogForm) {

        return CommonExt.convert(webRepository.addDeviceUpdatePackageLog(updatePackageLogForm));
    }

    /**
     * 检查当前ota是否具有新版本
     * @param detectionOtaVersionForm
     * @return
     */
    @Override
    public Observable<DetectionOtaResponse> detectionOtaVersion(DetectionOtaVersionForm detectionOtaVersionForm) {

        return CommonExt.convert(webRepository.detectionOtaVersion(detectionOtaVersionForm));

    }

    /**
     * 查看当前Ota详情 #1
     * @param getCurrentOtaDetailForm
     * @return
     */
    @Override
    public Observable<CurrentOtaDetailResponse> getCurrentOtaDetail(GetCurrentOtaDetailForm getCurrentOtaDetailForm) {

        return CommonExt.convert(webRepository.getCurrentOtaDetail(getCurrentOtaDetailForm));

    }

    /**
     * 下载成功或失败，更新成功或失败
     * @param updateDevicePackageLogForm
     * @return
     */
    @Override
    public Observable<UpdateDevicePackageLogResponse> updateDevicePackageLog(UpdateDevicePackageLogForm updateDevicePackageLogForm) {

        return CommonExt.convert(webRepository.updateDevicePackageLog(updateDevicePackageLogForm));

    }

    /**
     * 获取包信息
     * @param imei
     * @param language
     * @param packageId
     * @return
     */
    @Override
    public Observable<UpdatePackageInfoResponse> getPackageInfoById(String imei, String language, String packageId) {

        GetPackageInfoForm getPackageInfoForm = new GetPackageInfoForm(imei,language,packageId);
        return CommonExt.convert(webRepository.getPackageDetailById(getPackageInfoForm));

    }

}
