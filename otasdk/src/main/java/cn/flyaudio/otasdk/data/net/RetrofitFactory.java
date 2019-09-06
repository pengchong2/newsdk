package cn.flyaudio.otasdk.data.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.flyaudio.otasdk.common.BaseConstant;
import cn.flyaudio.otasdk.utils.AppPrefsUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitFactory {
    /**
     * retrofit
     */
    private Retrofit retrofit;
    /**
     * http client
     */
    private OkHttpClient okHttpClient;
    /**
     * http 拦截器，添加默认请求头字段用
     */
    private Interceptor interceptor;

    private RetrofitFactory(){

        init();

    }

    /**
     * 静态内部类单例
     */
    static class RetrofitHolder{

        private static final RetrofitFactory INSTANCE = new RetrofitFactory();

    }

    /**
     * 获取Retrofit单例
     * @return
     */
    public static RetrofitFactory getRetrofit(){
        return RetrofitHolder.INSTANCE;
    }

    /**
     * 获取OkHttp单例
     * @return
     */
    public static OkHttpClient getOkHttpClient(){

        return RetrofitHolder.INSTANCE.okHttpClient;

    }

    /**
     * 初始化设置
     */
    private void init(){

        interceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                // 本地保存的token
                String token = AppPrefsUtils.getInstance().getString(BaseConstant.KEY_SP_TOKEN);
                // 添加默认的header
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type","application/json")
                        .addHeader("charset","utf-8")
                        .addHeader("token",token)
                        .build();

                return chain.proceed(request);

            }

        };



        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build();
    }

    /**
     * 初始化okHttpClient
     * @return okHttpClient
     */
    private OkHttpClient initClient() {

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
//              .addInterceptor(new TokenInterceptor())
//              .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(BaseConstant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(BaseConstant.READ_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(BaseConstant.WRITE_TIMEOUT,TimeUnit.SECONDS)
                .build();
        return okHttpClient;

    }

    /**
     * 初始化http log打印器
     * @return interceptor
     */
    private Interceptor initLogInterceptor(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;

    }

    /**
     * 创建服务实例
     * @param service
     * @param <T>
     * @return service实例
     */
    public <T> T create(Class<T> service){

        return retrofit.create(service);

    }
}
