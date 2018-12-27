package com.hyetec.appdemo.repository;

import android.app.Application;

import com.hyetec.appdemo.api.ApiResponse;
import com.hyetec.appdemo.api.WebService;
import com.hyetec.appdemo.vo.User;
import com.hyetec.repository.IRepositoryManager;
import com.hyetec.repository.utils.RepositoryUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private LiveData<User> user;

    //private final WebService webService;
    private IRepositoryManager mRepositoryManager;

    @Inject
    public UserRepository(Application application) {
        this.mRepositoryManager = RepositoryUtils.INSTANCE
                .obtainRepositoryComponent(application)
                .repositoryManager();
    }

    public LiveData<User> loadUser(String userId) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        //userCache.put(userId, data);
        // this is still suboptimal but better than before.
        // a complete implementation must also handle the error cases.
        mRepositoryManager.obtainRetrofitService(WebService.class).getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }
}
