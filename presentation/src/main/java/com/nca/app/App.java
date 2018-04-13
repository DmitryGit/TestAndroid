package com.nca.app;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.nca.data.repository.UserRepositoryImpl;
import com.nca.domain.executor.PostExecutionThread;
import com.nca.domain.repository.UserRepository;
import com.nca.executor.UIThread;
import com.nca.injection.AppComponent;
import com.nca.injection.AppModule;
import com.nca.injection.DaggerAppComponent;

import javax.inject.Singleton;

import dagger.Provides;
import io.fabric.sdk.android.Fabric;

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
