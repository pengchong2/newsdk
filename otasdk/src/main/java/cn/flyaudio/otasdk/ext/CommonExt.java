package cn.flyaudio.otasdk.ext;

import cn.flyaudio.otasdk.data.BaseResp;
import cn.flyaudio.otasdk.rx.BaseFunc;
import cn.flyaudio.otasdk.rx.BaseFuncBoolean;
import cn.flyaudio.otasdk.rx.BaseSubscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
*@author pengchong
*@date 2019/8/27
*@function  rxjava观察者和被观察者的管理
*
*/
public final class CommonExt {
    /**
     * 执行订阅，并绑定生命周期
     * @param observable 被观察者
     * @param subscriber 观察者
     */
    public static  void execute(Observable observable, BaseSubscriber subscriber){

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);

    }
    /**
     * 将Observable<BaseResp<T>>变换为Observable<T>
     */
    public static <T> Observable<T> convert (Observable<BaseResp<T>> observable){

       return observable.flatMap(new BaseFunc<T>());

    }
    /**
     * 将Observable<BaseResp<T>>变换为Observable<Boolean>
     */
    public static <T> Observable<Boolean> convertBoolean(Observable<BaseResp> observable){

        return observable.flatMap(new BaseFuncBoolean());

    }

}
