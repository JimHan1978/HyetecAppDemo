package com.hyetec.repository;

import android.app.Application;
import android.content.Context;

import com.hyetec.repository.di.component.DaggerRepositoryComponent;
import com.hyetec.repository.di.component.RepositoryComponent;
import com.hyetec.repository.di.module.RepositoryModule;

public class RepositoryInjector implements IRepository{

    private Application mApplication;
    private RepositoryComponent mRepositoryComponent;
    private RepositoryModule mRepositoryModule;

    public RepositoryInjector(Context context) {

    }

    public void onCreate(Application application) {
        this.mApplication = application;
        if (mRepositoryModule == null) {
            mRepositoryModule = new RepositoryModule(mApplication);
        }
        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .repositoryModule(mRepositoryModule)
                //.clientModule(new ClientModule(mApplication))
                //.repositoryConfigModule(getRepositoryConfigModule(mApplication, mConfigRepositories))
                .build();
        mRepositoryComponent.inject(this);
    }

    public void onTerminate(Application application) {
        this.mRepositoryModule = null;
        this.mRepositoryComponent = null;
        this.mApplication = null;
    }

    @Override
    public RepositoryComponent getRepositoryComponent() {
        return this.mRepositoryComponent;
    }

    @Override
    public RepositoryModule getRepositoryModule() {
        return this.mRepositoryModule;
    }
}
