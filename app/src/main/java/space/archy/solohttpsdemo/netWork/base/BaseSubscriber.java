package space.archy.solohttpsdemo.netWork.base;

import android.util.Log;

import rx.Subscriber;
import space.archy.solohttpsdemo.BuildConfig;

/**
 * @Author Archy Wang
 * @Date 2017/8/11
 * @Description subscriber基类
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onStart() {
        if (BuildConfig.DEBUG) Log.d("BaseSubscriber", "onStart");
    }

    @Override
    public void onCompleted() {
        if (BuildConfig.DEBUG) Log.d("BaseSubscriber", "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

}
