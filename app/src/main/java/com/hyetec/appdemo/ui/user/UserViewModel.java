package com.hyetec.appdemo.ui.user;

import android.util.Log;

import com.hyetec.appdemo.repository.UserRepository;
import com.hyetec.appdemo.vo.User;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private static final String TAG = "UserViewModel";

    private UserRepository userRepo;

    @Inject
    public UserViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public LiveData<User> getUser() {
        return user;
    }

    private LiveData<User> user;
    public void init(String userId) {
        Log.i(TAG, "init: "+userId);
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        user = userRepo.loadUser(userId);
    }


}
