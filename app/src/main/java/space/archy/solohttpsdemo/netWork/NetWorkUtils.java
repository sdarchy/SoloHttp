package space.archy.solohttpsdemo.netWork;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import space.archy.solohttpsdemo.netWork.constant.TimeConstant;
import space.archy.solohttpsdemo.netWork.interception.JsonInterceptor;
import space.archy.solohttpsdemo.netWork.serviceInterface.ICleanService;
import space.archy.solohttpsdemo.BuildConfig;
/**
 * @Author Archy Wang
 * @Date 2017/8/8
 * @Description Retrofit 网络工具类
 */

public class NetWorkUtils {

    private final static String BASE_URL_RELEASE_https = "";
    private final Retrofit mRetrofit;

    private NetWorkUtils() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        httpClientBuilder.connectTimeout(TimeConstant.TIMEOUT_CONNECTION, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(TimeConstant.TIMEOUT_READ,TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(TimeConstant.TIMEOUT_WRITE,TimeUnit.SECONDS);


        httpClientBuilder.addInterceptor(new JsonInterceptor());


        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_RELEASE_https)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build();


    }


    public Retrofit getRetrofit(){
        return mRetrofit;
    }

    /**
     * 返回统一的Service
     * @return ICleanService
     */
    public ICleanService getCleanService(){
        return mRetrofit.create(ICleanService.class);
    }



    public static NetWorkUtils getInstance(){
        return NetWorkHolder.sInstance;
    }

    private static class NetWorkHolder {
        private static final NetWorkUtils sInstance = new NetWorkUtils();
    }
}
