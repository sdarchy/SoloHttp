package space.archy.solohttpsdemo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import space.archy.solohttpsdemo.netWork.NetWorkUtils;
import space.archy.solohttpsdemo.netWork.bean.AdvertisementBean;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testNetwork(){
        Observable<AdvertisementBean> advertisementBeanObservable = NetWorkUtils.getInstance().getCleanService().getAdvertisementConfig(25)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());
        AdvertisementBean first = advertisementBeanObservable.toBlocking().first();
        System.out.println(first.toString());
    }




    @Test
    public void addition_isCorrect() throws Exception {
        TestSubscriber<String> stringTestSubscriber = new TestSubscriber<String>(){
            @Override
            public void onNext(String o) {
                System.out.println(o);
                super.onNext(o);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                System.out.println("onError");
            }
        };
        Observable<String> stringObservable = Observable.just("1,2,3")
                .delay(3, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.immediate())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation());
        String first = stringObservable.toBlocking().first();
        System.out.println(first);

    }
}