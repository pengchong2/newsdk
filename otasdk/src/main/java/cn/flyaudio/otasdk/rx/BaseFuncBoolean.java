package cn.flyaudio.otasdk.rx;

import cn.flyaudio.otasdk.common.BaseConstant;
import cn.flyaudio.otasdk.data.BaseResp;
import cn.flyaudio.otasdk.utils.ExceptionHandle;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
*@author pengchong
*@date 2019/8/27
*@function  基本的观察者转换，转为boolean结果，成功则返回true,失败则返回异常信息
*
*/
public class BaseFuncBoolean implements Function<BaseResp, Observable<Boolean>> {
    @Override
    public Observable<Boolean> apply(BaseResp tBaseResp) {
        String errorString = "异常";
        // 接口约定的异常处理
        switch (tBaseResp.getCode()){
            case BaseConstant.STATUS_OK:
            case BaseConstant.STATUS_ACESS_NOMAL:
                // 正常请求,传递业务数据
                return Observable.just(true);
            case BaseConstant.STATUS_NEED_TOKEN:
                errorString = "需要用户认证";
                break;
            case BaseConstant.STATUS_NOT_FOUND:
                errorString = "找不到服务";
                break;
            case BaseConstant.STATUS_REJECT:
                errorString = "服务拒绝";
                break;
            case BaseConstant.STATUS_SERVER_ERROR:
                errorString = "服务内部错误";
                break;
            default:
                if (tBaseResp.getMsg()!=null){
                    errorString = tBaseResp.getMsg();
                }
                break;
        }
        // 传递约定异常
        Throwable throwable = new Throwable(errorString);
        ExceptionHandle.ResponseException responseException = new ExceptionHandle.ResponseException(throwable, ExceptionHandle.ERROR.CUSTOM_ERROR);
        return Observable.error(responseException);
    }
}
