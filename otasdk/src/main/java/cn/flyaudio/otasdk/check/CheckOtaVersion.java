package cn.flyaudio.otasdk.check;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import cn.flyaudio.otasdk.FlyFotaApplicationInit;
import cn.flyaudio.otasdk.R;
import cn.flyaudio.otasdk.data.protocal.form.DetectionOtaVersionForm;
import cn.flyaudio.otasdk.data.protocal.response.DetectionOtaResponse;
import cn.flyaudio.otasdk.data.service.DataService;
import cn.flyaudio.otasdk.data.service.DataServiceImp;
import cn.flyaudio.otasdk.ext.CommonExt;
import cn.flyaudio.otasdk.interfaces.ErrorCode;
import cn.flyaudio.otasdk.interfaces.ICheckUpdateListener;
import cn.flyaudio.otasdk.rx.BaseSubscriber;
import cn.flyaudio.otasdk.utils.CommonUtil;
import cn.flyaudio.otasdk.utils.JSONUtils;
import cn.flyaudio.otasdk.utils.NetWorkUtils;
import cn.flyaudio.otasdk.utils.VersionUtil;
import cn.flyaudio.otasdk.utils.XTEA;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
*@author pengchong
*@date 2019/8/27
*@function 检查当前版本服务器是否有升级版本
*
*/
public class CheckOtaVersion {

    public static String TAG = "CheckOtaVersion";
    public static CheckOtaVersion minstance = null;
    private  DataService dataService = null;

    public static CheckOtaVersion getInstance(){
        if(minstance == null){
            minstance = new CheckOtaVersion();
        }
        return minstance;
    }


    public  CheckOtaVersion(){
          dataService = new DataServiceImp();
    }

    public void checkOtaDetails(final ICheckUpdateListener listener){

        if(listener == null){
            return;
        }
        if(!NetWorkUtils.isNetWorkAvailable(FlyFotaApplicationInit.mContext)){
            //底部显示无网络提示
            listener.onFail(ErrorCode.CHECK_NET_ERROR,"网络未连接");
            return;
        }

        /**
         * 获取车机平台验证码
         */
        String imei = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getImei();
        if(TextUtils.isEmpty(imei)){
            listener.onFail(ErrorCode.CHECK_NO_IMEI,"机器没有IMEI号");
            return;
        }

        // key
        String key = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getKey();
        // iv
        String iv = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getIv();

        if(TextUtils.isEmpty(key) || TextUtils.isEmpty(iv)){

            listener.onFail(ErrorCode.CHECK_NO_KEY,"机器没有key");
            // 通知智慧飞歌服务去获取key,iv
            //VersionUtil.checkDeviceInput();
            return;
        }

        /**
         * 请求参数
         */
        Map<String,Object> param = new HashMap<>(7);

        /**
         * 获取系统语言
         */
        String lan = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getCurrentLanguageAndCountry();
        /**
         * 厂商平台
         */
        String catPlat = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getCarPlatform();
        /**
         * 机型
         */
        String carType = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getCarType();
        /**
         * 系统版本
         */
        String carVersion = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getCarVersion();
        /**
         * Ota当前版本
         */
        String otaVersion = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getOtaVersion();
        /**
         * 升级包属性,packageProperty
         */
        String packageProperty = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getPackageProperty();
        /**
         * 升级包包名
         */
        String packageName = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getPackageName();
        // 打印packageName
        param.put("carPlat",catPlat);
        param.put("carType",carType);
        param.put("carVersion",carVersion);
        param.put("otaVersion",otaVersion);
        param.put("packageProperty",packageProperty);
        param.put("packageName",packageName);

        //未加密之前的Json数据
        String json = JSONUtils.object2JsonString(param);
        Log.d(TAG, "initRequestForm: json>>>"+ json);
        String data = XTEA.getEncryptStr(key,iv,json);
        Log.d(TAG, "initRequestForm: data>>>"+ data);
        Log.d(TAG, "initRequestForm: Imei>>>"+ imei);
        Log.d(TAG, "initRequestForm: key>>>"+ key);
        Log.d(TAG, "initRequestForm: iv>>>"+ iv);

      final  DetectionOtaVersionForm detectionOtaVersionForm = new DetectionOtaVersionForm(imei,lan,data);
        // 至少延时1s执行，达到优化界面加载效果
        Observable<DetectionOtaResponse> observable = Observable.timer(1, TimeUnit.SECONDS)
                .flatMap(new Function<Long, ObservableSource<DetectionOtaResponse>>() {
                    @Override
                    public ObservableSource<DetectionOtaResponse> apply(Long aLong) throws Exception {
                        return dataService.detectionOtaVersion(detectionOtaVersionForm);
                    }
                });

        CommonExt.execute(observable, new BaseSubscriber<DetectionOtaResponse>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);

            }
            @Override
            public void onNext(DetectionOtaResponse detectionOtaResponse) {
                super.onNext(detectionOtaResponse);
                if(detectionOtaResponse != null){

                    String flag = detectionOtaResponse.getFlag();
                    String returnMsg = CommonUtil.judgeFlag(flag);
                    if(returnMsg == null){
                        listener.onFail(ErrorCode.CHECK_RETURN_EMPTY,FlyFotaApplicationInit.mContext.getString(R.string.empty_response));
                    }else{
                        if(returnMsg.equals(FlyFotaApplicationInit.mContext.getString(R.string.successful_operation))){
                            // 操作成功
                            String info  = detectionOtaResponse.getInfo();
                            if (!TextUtils.isEmpty(info)){
                                listener.onSuccess(getOtaVersioinInfo(info),false);
                            }else {
                                // 没有最新的更新包
                                listener.onFail(ErrorCode.CHECK_NO_PACKAGE,FlyFotaApplicationInit.mContext.getString(R.string.there_is_no_latest_update_package));
                           }
                        }else{
                            // 操作失败
                            listener.onFail(ErrorCode.CHECK_OPERATE_ERROR,FlyFotaApplicationInit.mContext.getString(R.string.operation_failed));
                        }
                    }
                }else{
                       listener.onFail(ErrorCode.CHECK_RETURN_NULL,"empty response!");
                }
            }

            @Override
            public void onComplete() {
                super.onComplete();
            }
        });

    }


    /**
     * 将获取到升级包版本信息解密出来
     * @param response
     * @return
     */
    private  DetectionOtaResponse.Info getOtaVersioinInfo(String response){
        String  key = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getKey();
        String  iv = VersionUtil.getInstance(FlyFotaApplicationInit.mContext).getIv();
        // 解密data
        String decry = XTEA.getDecryptStr(key,iv,response);
        Log.d(TAG,"解密出的信息："+decry);
        //json数据转换为Object对象
        DetectionOtaResponse.Info info = JSONUtils.jsonString2Object(decry,DetectionOtaResponse.Info.class);
        return info;
    }
}
