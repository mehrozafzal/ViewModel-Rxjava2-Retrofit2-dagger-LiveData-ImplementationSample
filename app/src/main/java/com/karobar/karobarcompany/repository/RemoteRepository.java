package com.karobar.karobarcompany.repository;

import com.google.gson.JsonElement;
import com.karobar.karobarcompany.retrofit.ApiCallInterface;
import com.karobar.karobarcompany.retrofit.model.request.signIn.SignInRequest;

import io.reactivex.Observable;

public class RemoteRepository {

    ApiCallInterface apiCallInterface;

    public RemoteRepository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    public Observable<JsonElement> executeLogin(SignInRequest signInRequest) {
        return apiCallInterface.login(signInRequest);
    }
}
