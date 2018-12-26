package com.hyetec.appdemo.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyetec.appdemo.DemoApp;
import com.hyetec.appdemo.R;
import com.hyetec.appdemo.di.Injectable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class UserFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private UserViewModel mViewModel;
    private TextView tvName;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);

        tvName = view.findViewById(R.id.tvName);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // viewModelFactory = ((DemoApp)getActivity().getApplication()).getViewModelFactory();
        mViewModel = ViewModelProviders.of(this.getActivity(),viewModelFactory).get(UserViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.init("1");
        mViewModel.getUser().observe(this,user -> {
            tvName.setText(user.name);
        });
    }

}
