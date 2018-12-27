package com.hyetec.repository;

import android.app.Application;
import android.content.Context;

import com.hyetec.repository.cache.Cache;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import retrofit2.Retrofit;

/**
 * @author xiaobailong24
 * @date 2017/9/28
 * 数据管理层实现类
 */
@Singleton
public class RepositoryManager implements IRepositoryManager {
    private Application mApplication;
    private Lazy<Retrofit> mRetrofit;
    private Cache<String, Object> mRetrofitServiceCache;
    private Cache<String, Object> mCacheServiceCache;
    private Cache<String, Object> mRoomDatabaseCache;

    @Inject
    public RepositoryManager(Application application, Lazy<Retrofit> retrofit) {
        this.mApplication = application;
        this.mRetrofit = retrofit;
    }

    @Override
    public <T> T obtainRetrofitService(Class<T> service) {

        T retrofitService;
        synchronized (mRetrofitServiceCache) {
            retrofitService = (T) mRetrofitServiceCache.get(service.getName());
            if (retrofitService == null) {
                retrofitService = mRetrofit.get().create(service);
                mRetrofitServiceCache.put(service.getName(), retrofitService);
            }
        }
        return retrofitService;
    }

    @Override
    public Context getContext() {
        return this.mApplication;
    }


}
