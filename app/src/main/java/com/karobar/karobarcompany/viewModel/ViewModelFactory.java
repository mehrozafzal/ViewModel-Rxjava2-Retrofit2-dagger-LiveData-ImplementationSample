package com.karobar.karobarcompany.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.karobar.karobarcompany.repository.RemoteRepository;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public RemoteRepository remoteRepository;

    @Inject
    public ViewModelFactory(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(remoteRepository);
        } else if (modelClass.isAssignableFrom(SignUpViewModel.class)) {
            return (T) new SignUpViewModel(remoteRepository);
        }
        return null;
    }


}
