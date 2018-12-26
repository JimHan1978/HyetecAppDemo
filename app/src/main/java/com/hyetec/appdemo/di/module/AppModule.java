/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hyetec.appdemo.di.module;

import com.hyetec.appdemo.api.WebService;
import com.hyetec.daggerlibrary.di.module.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelFactoryModule.class,ViewModelModule.class,BaseActivityModule.class,FragmentBuildersModule.class})
public class AppModule {
    @Singleton
    @Provides
    WebService provideWebService() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.2.206:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(WebService.class);
    }

    /*@Singleton @Provides
    GithubDb provideDb(Application app) {
        return Room.databaseBuilder(app, GithubDb.class,"github.db").build();
    }

    @Singleton @Provides
    UserDao provideUserDao(GithubDb db) {
        return db.userDao();
    }

    @Singleton @Provides
    RepoDao provideRepoDao(GithubDb db) {
        return db.repoDao();
    }*/
}