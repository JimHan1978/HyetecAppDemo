package com.hyetec.daggerlibrary;

import android.app.Application;

import com.hyetec.daggerlibrary.di.component.DaggerComponent;
import com.hyetec.daggerlibrary.di.component.DaggerDaggerComponent;
import com.hyetec.daggerlibrary.di.module.DaggerModule;
import com.hyetec.repository.RepositoryInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by xiaobailong24 on 2017/9/16.
 * Dagger DaggerDelegate
 */

public class DaggerDelegate {
    @Inject
    DaggerActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    
    private DaggerComponent mComponent;
    private final Application mApplication;

    /**
     * {@link RepositoryInjector}
     */
    private RepositoryInjector mRepositoryInjector;


    public DaggerDelegate(Application application) {
        mApplication = application;

        if (mRepositoryInjector == null) {
            mRepositoryInjector = new RepositoryInjector(application);
        }
    }

    public void onCreate() {
        Timber.plant(new Timber.DebugTree());

        //Repository inject
        mRepositoryInjector.onCreate(mApplication);
        //顶级依赖注入
        mComponent = DaggerDaggerComponent.builder()
                .daggerModule(new DaggerModule(mApplication))
                .build();
        mComponent.inject(this);

        //注册 ActivityLifecycleCallbacks 来进行 Activity/Fragment 的依赖注入
        mApplication.registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }


    public DaggerComponent getComponent() {
        return mComponent;
    }
}
