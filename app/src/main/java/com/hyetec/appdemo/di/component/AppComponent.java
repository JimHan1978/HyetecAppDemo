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

package com.hyetec.appdemo.di.component;

import com.hyetec.appdemo.DemoApp;
import com.hyetec.appdemo.di.module.AppModule;
import com.hyetec.appdemo.di.module.BaseActivityModule;
import com.hyetec.appdemo.di.module.FragmentBuildersModule;
import com.hyetec.daggerlibrary.di.component.DaggerComponent;
import com.hyetec.daggerlibrary.di.scope.AppScope;

import dagger.Component;

@AppScope
@Component(dependencies = DaggerComponent.class,
        modules = {
        AppModule.class,BaseActivityModule.class,FragmentBuildersModule.class
})
public interface AppComponent {

    void inject(DemoApp demoApp);
}
