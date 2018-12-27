package com.hyetec.repository.di.component;

import com.hyetec.repository.IRepositoryManager;
import com.hyetec.repository.RepositoryInjector;
import com.hyetec.repository.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author xiaobailong24
 * @date 2017/9/28
 * Dagger RepositoryComponent 向外提供一些方法获取需要的对象，
 *
 */
@Singleton
@Component(modules = {RepositoryModule.class})
public interface RepositoryComponent {
    /**
     * 用于管理网络请求层和数据库层
     *
     * @return RepositoryManager
     */
    IRepositoryManager repositoryManager();


    /**
     * Dagger 注入
     *
     * @param repositoryInjector RepositoryInjector
     */
    void inject(RepositoryInjector repositoryInjector);
}
