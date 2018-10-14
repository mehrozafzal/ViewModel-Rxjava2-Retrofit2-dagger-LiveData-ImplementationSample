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
    private final MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();


    public LoginViewModel(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public MutableLiveData<ApiResponse> loginResponse() {
        return responseLiveData;
    }

    public void hitLoginApi(SignInRequest signInRequest) {

        DisposableManagerUtils.add(remoteRepository.executeLogin(signInRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> responseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> responseLiveData.setValue(ApiResponse.success(result)),
                        throwable -> responseLiveData.setValue(ApiResponse.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManagerUtils.clear();
    }
}
