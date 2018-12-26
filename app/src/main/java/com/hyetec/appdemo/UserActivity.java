package com.hyetec.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import android.os.Bundle;

import com.hyetec.appdemo.ui.user.UserFragment;
import com.hyetec.appdemo.ui.user.UserViewModel;

import javax.inject.Inject;

public class UserActivity extends AppCompatActivity {

    /**
     * MVVM ViewModel ViewModelProvider.Factory
     */
    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    UserViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建ViewModel
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(UserViewModel.class);

        setContentView(R.layout.user_activity);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, UserFragment.newInstance())
                    .commitNow();
        }
    }



}
