package com.karobar.karobarcompany.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.karobar.karobarcompany.repository.RemoteRepository;
import com.karobar.karobarcompany.retrofit.ApiResponse;
import com.karobar.karobarcompany.retrofit.model.request.signIn.SignInRequest;
import com.karobar.karobarcompany.utils.DisposableManagerUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    public RemoteRepository remoteRepository;
    private final MutableLiveData<ApiResponse> loginResponseLiveData = new MutableLiveData<>();


    public LoginViewModel(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public MutableLiveData<ApiResponse> loginResponse() {
        return loginResponseLiveData;
    }

    public void hitLoginApi(SignInRequest signInRequest) {

        DisposableManagerUtils.add(remoteRepository.executeLogin(signInRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> loginResponseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> loginResponseLiveData.setValue(ApiResponse.success(result)),
                        throwable -> loginResponseLiveData.setValue(ApiResponse.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManagerUtils.clear();
    }
}
