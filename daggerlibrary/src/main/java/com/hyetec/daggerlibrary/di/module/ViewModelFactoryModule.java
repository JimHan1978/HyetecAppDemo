package com.hyetec.daggerlibrary.di.module;

import com.hyetec.daggerlibrary.mvvm.ViewModelFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

/**
 * @author xiaobailong24
 * @date 2017/7/31
 * Dagger ViewModelFactoryModule
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
