package app;

import android.app.Application;

import component.DaggerNetComponent;
import component.NetComponent;
import io.realm.Realm;
import module.AppModule;
import module.NetModule;

/**
 * Created by kiwitech on 26/7/17.
 */

public class MyApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
