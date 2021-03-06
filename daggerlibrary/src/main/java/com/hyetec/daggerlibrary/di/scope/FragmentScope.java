package com.hyetec.daggerlibrary.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiaobailong24 on 2017/9/6.
 * Dagger FragmentScope
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
