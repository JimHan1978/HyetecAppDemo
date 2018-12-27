package com.hyetec.repository;

import android.content.Context;

/**
 * @author xiaobailong24
 * @date 2017/9/28
 * 数据管理层接口
 */
public interface IRepositoryManager {
    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service Retrofit Service Class
     * @param <T>     Retrofit Service
     * @return Retrofit Service
     */
    <T> T obtainRetrofitService(Class<T> service);


    /**
     * 获取 Context(Application)
     *
     * @return Context
     */
    Context getContext();

}
