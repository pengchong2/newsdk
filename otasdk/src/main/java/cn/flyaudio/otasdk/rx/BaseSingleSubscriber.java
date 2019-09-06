package cn.flyaudio.otasdk.rx;
import cn.flyaudio.otasdk.utils.ExceptionHandle;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
*@author pengchong
*@date 2019/8/27
*@function 基础的Single订阅类
*
*/
public abstract class BaseSingleSubscriber<T> implements SingleObserver<T> {

    public BaseSingleSubscriber() {

    }

    @Override
    public void onError(Throwable e) {
        // 异常处理
        ExceptionHandle.ResponseException exception = ExceptionHandle.handleException(e);

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(T t) {
    }


}
