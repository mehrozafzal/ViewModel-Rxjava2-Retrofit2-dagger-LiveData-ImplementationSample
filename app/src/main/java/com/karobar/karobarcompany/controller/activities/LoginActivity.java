package com.karobar.karobarcompany.controller.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentHelperClass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginActivity_fab)
    FloatingActionButton fabNext;
    @BindView(R.id.loginActivity_registerBtn)
    Button loginActivityRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick({R.id.loginActivity_fab, R.id.loginActivity_registerBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginActivity_fab:
                IntentHelperClass.getInstance(this).moveToNextActivity(this, HomeActivity.class, null);
                break;
            case R.id.loginActivity_registerBtn:
                IntentHelperClass.getInstance(this).moveToNextActivity(this, RegisterActivity.class, null);
                break;
        }
    }
}
