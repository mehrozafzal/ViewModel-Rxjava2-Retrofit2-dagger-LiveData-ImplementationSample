package com.karobar.karobarcompany.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.karobar.karobarcompany.repository.RemoteRepository;
import com.karobar.karobarcompany.retrofit.ApiResponse;
import com.karobar.karobarcompany.retrofit.model.request.signUp.SignUpRequest;
import com.karobar.karobarcompany.utils.DisposableManagerUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SignUpViewModel extends ViewModel {
    public RemoteRepository remoteRepository;
    private final MutableLiveData<ApiResponse> signUpResponseLiveData = new MutableLiveData<>();

    public SignUpViewModel(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public MutableLiveData<ApiResponse> signUpResponse() {
        return signUpResponseLiveData;
    }

    public void hitSignUpApi(SignUpRequest signUpRequest) {

        DisposableManagerUtils.add(remoteRepository.executeSignUp(signUpRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> signUpResponseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> signUpResponseLiveData.setValue(ApiResponse.success(result)),
                        throwable -> signUpResponseLiveData.setValue(ApiResponse.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        DisposableManagerUtils.clear();
    }
}
