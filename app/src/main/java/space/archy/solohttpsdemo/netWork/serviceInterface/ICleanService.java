package space.archy.solohttpsdemo.netWork.serviceInterface;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import space.archy.solohttpsdemo.netWork.bean.AdvertisementBean;

/**
 * @Author Archy Wang
 * @Date 2017/8/8
 * @Description service接口类
 */

public interface ICleanService {

    @GET("/api/cleaner/advertisement/")
    Observable<AdvertisementBean> getAdvertisementConfig(@Query("app_version_code")int versionId);

}
