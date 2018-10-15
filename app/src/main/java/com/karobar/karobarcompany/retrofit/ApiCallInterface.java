package com.karobar.karobarcompany.retrofit;

import com.google.gson.JsonElement;
import com.karobar.karobarcompany.constants.UrlConstants;
import com.karobar.karobarcompany.retrofit.model.request.signIn.SignInRequest;
import com.karobar.karobarcompany.retrofit.model.request.signUp.SignUpRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiCallInterface {

    @POST(UrlConstants.LOGIN_URL)
    Observable<JsonElement> login(@Body SignInRequest signInRequest);

    @POST(UrlConstants.SIGNUP_URL)
    Observable<JsonElement> signup(@Body SignUpRequest signUpRequest);
}


