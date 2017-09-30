package space.archy.solohttpsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import space.archy.solohttpsdemo.netWork.base.BaseSubscriber;
import space.archy.solohttpsdemo.netWork.NetWorkUtils;
import space.archy.solohttpsdemo.netWork.bean.AdvertisementBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(v->test());

    }

    public void test(){
        Observable<AdvertisementBean> advertisementConfig = NetWorkUtils.getInstance().getCleanService().getAdvertisementConfig(25);
        advertisementConfig.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<AdvertisementBean>() {
                    @Override
                    public void onNext(AdvertisementBean advertisementBean) {
                        Log.d("MainActivity", advertisementBean.toString());
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                        super.onCompleted();
                    }
                });

    }




}
