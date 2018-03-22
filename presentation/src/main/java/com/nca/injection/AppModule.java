package com.nca.injection;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nca.data.net.RestApi;
import com.nca.data.net.RestService;
import com.nca.data.repository.UserRepositoryImpl;
import com.nca.domain.executor.PostExecutionThread;
import com.nca.domain.repository.UserRepository;
import com.nca.executor.UIThread;
import com.nca.testandroid.BuildConfig;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Context context;
    RestService restService;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public RestService getRestService() {
        return new RestService(getRestApi(getRetrofit(getGson())));
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }

//    @Binds
//    public abstract  PostExecutionThread getUiThread(UIThread uiThread);

    @Provides
    @Singleton
    @Named("rep1")
    public UserRepository getUserRepository(Context context) {
        return new UserRepositoryImpl(context, getRestService());
    }

    @Provides
    @Singleton
    @Named("rep2")
    public UserRepository getUserRepository2(Context context) {
        return new UserRepositoryImpl(context, restService);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
        return new Retrofit
                .Builder()
//                .addCallAdapterFactory( /*Rx in Gson*/)
//                .addConverterFactory()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.backendless.com/FD247E47-9C63-BE0D-FF02-EE6FC26EE800/57954579-3843-763B-FF76-3458E1999F00/")
                .build();
//                .baseUrl(BuildConfig.APPLICATION_ID).build();

        // в градле
        // https://api.backendless.com/FD247E47-9C63-BE0D-FF02-EE6FC26EE800/57954579-3843-763B-FF76-3458E1999F00
        // gson подлючит на сайте retrofita
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

//    @Provides
//    @Singleton
//    public RestService getRestServiсe() {
//
//    }

    @Provides
    @Singleton
    public Gson getGson() {

        return new GsonBuilder()
                // туту можно добавить настройки для прасинга даты например
                .create();

    }

}

