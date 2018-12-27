package com.hyetec.repository.di.module;

import android.app.Application;

import com.hyetec.repository.IRepositoryManager;
import com.hyetec.repository.RepositoryManager;

import javax.inject.Singleton;

import androidx.annotation.Nullable;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {
    private Application mApplication;

    public RepositoryModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return HttpUrl.parse("http://192.168.176.175:8080/") ;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(HttpUrl httpUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                //域名
                .baseUrl(httpUrl)
                // TODO: 2017/10/20 使用LiveData
                //.addCallAdapterFactory(new LiveDataCallAdapterFactory())
                //使用rxjava
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //使用Gson
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }


    @Singleton
    @Provides
    IRepositoryManager provideRepositoryManager(Lazy<Retrofit> retrofit) {
        return new RepositoryManager(mApplication, retrofit);
    }
}
