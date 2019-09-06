package cn.flyaudio.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import cn.flyaudio.otasdk.FlyFotaApplicationInit;
import cn.flyaudio.otasdk.interfaces.IOtaSdkHelper;

/**
 * SDK初始化方式二：在自定义的Application类中，调用SDK的初始化接口
 * @author weifule
 * @date 19-7-1
 */
public class MyApplication2 extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        FlyFotaApplicationInit.attachBaseContext(base, new FlyFotaApplicationInit.IOtaListener() {
            @Override
            public void initService(IOtaSdkHelper helpr) {
                //得到IOtaSdkHelper类
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FlyFotaApplicationInit.onCreate();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        FlyFotaApplicationInit.onConfigurationChanged(newConfig);
    }

}
