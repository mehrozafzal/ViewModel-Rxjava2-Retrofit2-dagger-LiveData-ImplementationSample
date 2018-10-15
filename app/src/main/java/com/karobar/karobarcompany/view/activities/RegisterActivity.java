package com.karobar.karobarcompany.view.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.JsonElement;
import com.karobar.karobarcompany.MyApplication;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.constants.ActivityVariables;
import com.karobar.karobarcompany.retrofit.ApiResponse;
import com.karobar.karobarcompany.retrofit.model.request.signUp.CompanyAttributes;
import com.karobar.karobarcompany.utils.IntentUtils;
import com.karobar.karobarcompany.utils.ProgressDialogUtils;
import com.karobar.karobarcompany.utils.ToastDuration;
import com.karobar.karobarcompany.utils.ToastUtils;
import com.karobar.karobarcompany.viewModel.SignUpViewModel;
import com.karobar.karobarcompany.viewModel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.registerActivity_fab)
    FloatingActionButton fabNext;
    ImageView backButton;
    @BindView(R.id.generalBackButton)
    ImageView generalBackButton;
    @BindView(R.id.registerActivity_name)
    EditText registerActivityName;
    @BindView(R.id.registerActivity_companyName)
    EditText registerActivityCompanyName;
    @BindView(R.id.registerActivity_address)
    EditText registerActivityAddress;
    @BindView(R.id.registerActivity_emailAddress)
    EditText registerActivityEmailAddress;
    @BindView(R.id.registerActivity_password)
    EditText registerActivityPassword;
    @BindView(R.id.registerActivity_contact)
    EditText registerActivityContact;

    @Inject
    ViewModelFactory viewModelFactory;
    SignUpViewModel signUpViewModel;


    private void initViews() {
        ProgressDialogUtils.getInstance().initProgressDialog(this, "Please wait...");
        ((MyApplication) getApplication()).getAppActivityComponent().doInjection(this);
        signUpViewModel = ViewModelProviders.of(this, viewModelFactory).get(SignUpViewModel.class);
        signUpViewModel.signUpResponse().observe(this, this::consumeResponse);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick({R.id.generalBackButton, R.id.registerActivity_fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.generalBackButton:
                IntentUtils.getInstance(this).moveToPrevActivity(this, LoginActivity.class);
                break;
            case R.id.registerActivity_fab:
                //TODO call registering api
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
                    renderSignUpResponse(apiResponse.data);
                }
                break;

            case ERROR:
                ProgressDialogUtils.getInstance().dismissProgressDialog();
                if (apiResponse.error != null) {
                    Log.d(ActivityVariables.Tags.SIGNUP_ACTIVITY_TAG, apiResponse.error.getMessage());
                    ToastUtils.getInstance().showToast(this, apiResponse.error.toString(), ToastDuration.LONG);
                }
                break;

            default:
                break;
        }
    }

    private void renderSignUpResponse(JsonElement response) {
        if (!response.isJsonNull()) {
            IntentUtils.getInstance(this).moveToNextActivity(this, HomeActivity.class, null);
        }
    }

    private void construstSignUpObject() {
        CompanyAttributes companyAttributes = new CompanyAttributes();
        companyAttributes.setName(registerActivityName.getText().toString());
        companyAttributes.setAddress(registerActivityAddress.getText().toString());
        companyAttributes.setEmail(registerActivityEmailAddress.getText().toString());
        companyAttributes.setContactNumer(registerActivityContact.getText().toString());
    }

}
