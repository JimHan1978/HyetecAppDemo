package com.hyetec.appdemo.di.module;

import com.hyetec.appdemo.ui.user.UserViewModel;
import com.hyetec.daggerlibrary.di.scope.ViewModelScope;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelScope(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

    /*@Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel bindSearchViewModel(SearchViewModel searchViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel.class)
    abstract ViewModel bindRepoViewModel(RepoViewModel repoViewModel);*/

//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
