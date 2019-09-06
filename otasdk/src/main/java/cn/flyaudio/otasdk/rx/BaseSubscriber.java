package cn.flyaudio.otasdk.rx;

import cn.flyaudio.otasdk.utils.ExceptionHandle;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
*@author pengchong
*@date 2019/8/27
*@function 基础的订阅类
*
*/
public abstract class BaseSubscriber<T> implements Observer<T> {

    public BaseSubscriber(){
    }

    @Override
    public void onError(Throwable e) {
        // 异常处理
        ExceptionHandle.ResponseException exception = ExceptionHandle.handleException(e);
    }

    /**
     * 完成
     */
    @Override
    public void onComplete() {
        // 关闭loading


    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

}
