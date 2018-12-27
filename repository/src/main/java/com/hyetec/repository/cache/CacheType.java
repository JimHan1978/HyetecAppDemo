package com.hyetec.repository.cache;

/**
 * @author xiaobailong24
 * @date 2017/10/10
 * 缓存类型，不同的模块具有不同的缓存策略
 */
public enum CacheType {
    /**
     * RepositoryManager 的 RetrofitService 容器类型
     */
    RETROFIT_SERVICE_CACHE_TYPE,

    /**
     * RepositoryManager 的 CacheService 容器类型
     */
    CACHE_SERVICE_CACHE_TYPE,

    /**
     * RepositoryManager 的 RoomDatabase 容器类型
     */
    ROOM_DATABASE_CACHE_TYPE,

    /**
     * 外部使用类型
     */
    EXTRAS_CACHE_TYPE,

    /**
     * 自定义缓存类型，方便扩展
     */
    CUSTOM_CACHE_TYPE
}
