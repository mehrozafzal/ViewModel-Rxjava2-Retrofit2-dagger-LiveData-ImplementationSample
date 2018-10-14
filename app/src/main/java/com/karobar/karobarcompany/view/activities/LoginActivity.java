package com.karobar.karobarcompany.view.activities;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonElement;
import com.karobar.karobarcompany.MyApplication;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.constants.ActivityVariables;
import com.karobar.karobarcompany.retrofit.ApiResponse;
import com.karobar.karobarcompany.retrofit.model.request.signIn.SignInRequest;
import com.karobar.karobarcompany.retrofit.model.request.signIn.User;
import com.karobar.karobarcompany.utils.IntentUtils;
import com.karobar.karobarcompany.utils.ProgressDialogUtils;
import com.karobar.karobarcompany.utils.ToastDuration;
import com.karobar.karobarcompany.utils.ToastUtils;
import com.karobar.karobarcompany.viewModel.LoginViewModel;
import com.karobar.karobarcompany.viewModel.ViewModelFactory;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginActivity_fab)
    FloatingActionButton fabNext;
    @BindView(R.id.loginActivity_registerBtn)
    Button loginActivityRegisterBtn;

    @Inject
    ViewModelFactory viewModelFactory;
    LoginViewModel loginViewModel;

    private void initViews() {
        ProgressDialogUtils.getInstance().initProgressDialog(this, "Please wait...");
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        loginViewModel.loginResponse().observe(this, this::consumeResponse);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick({R.id.loginActivity_fab, R.id.loginActivity_registerBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginActivity_fab:
                processLogin();
                break;
            case R.id.loginActivity_registerBtn:
                IntentUtils.getInstance(this).moveToNextActivity(this, RegisterActivity.class, null);
                break;
        }
    }

    /*
     * method to handle response
     * */
    private void consumeResponse(ApiResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:
                ProgressDialogUtils.getInstance().showProgressDialog();
                break;

            case SUCCESS:
                ProgressDialogUtils.getInstance().dismissProgressDialog();
                if (apiResponse.data != null) {
                    renderLoginResponse(apiResponse.data);
                    // ResponseUtils.getInstance().renderResponse(apiResponse.data, ResponseVariables.LOGIN_RESPONSE_ID);
                }
                break;

            case ERROR:
                ProgressDialogUtils.getInstance().dismissProgressDialog();
                if (apiResponse.error != null) {
                    Log.d(ActivityVariables.Tags.LOGIN_ACTIVITY_TAG, apiResponse.error.getMessage());
                    ToastUtils.getInstance().showToast(this, apiResponse.error.toString(), ToastDuration.LONG);
                }
                break;

            default:
                break;
        }
    }

    private void renderLoginResponse(JsonElement response) {
        if (!response.isJsonNull()) {
            IntentUtils.getInstance(this).moveToNextActivity(this, HomeActivity.class, null);
        }
    }

    private void processLogin() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.INTERNET)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        User user = new User();
                        user.setEmail("mehroz.mehar99@gmail.com");
                        user.setPassword("mehroz2123330");
                        user.setAppType("company");
                        SignInRequest signInRequest = new SignInRequest();
                        signInRequest.setUser(user);
                        loginViewModel.hitLoginApi(signInRequest);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                }).check();
    }

}
