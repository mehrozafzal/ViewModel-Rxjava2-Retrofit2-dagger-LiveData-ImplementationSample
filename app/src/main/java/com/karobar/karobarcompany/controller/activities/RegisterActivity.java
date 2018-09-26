package com.karobar.karobarcompany.controller.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentHelperClass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.registerActivity_fab)
    FloatingActionButton fabNext;
    ImageView backButton;
    @BindView(R.id.generalBackButton)
    ImageView generalBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.generalBackButton, R.id.registerActivity_fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.generalBackButton:
                IntentHelperClass.getInstance(this).moveToPrevActivity(this, LoginActivity.class);
                break;
            case R.id.registerActivity_fab:
                //TODO call registering api
                break;
        }
    }

}
