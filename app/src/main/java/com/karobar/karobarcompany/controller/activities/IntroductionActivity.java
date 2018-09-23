package com.karobar.karobarcompany.controller.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentHelperClass;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroductionActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFadeAnimation();
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.title1), getResources().getString(R.string.description1), R.drawable.ic_karobar_smartphone, getResources().getColor(R.color.intro_color1)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.title2), getResources().getString(R.string.description2), R.drawable.ic_karobar_manage, getResources().getColor(R.color.intro_color2)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.title3), getResources().getString(R.string.description3), R.drawable.ic_karobar_products, getResources().getColor(R.color.intro_color3)));
        // OPTIONAL METHODS.
        setBarColor(Color.parseColor("#90000000"));
        setSeparatorColor(Color.parseColor("#7351B2"));
        showSkipButton(true);
        setProgressButtonEnabled(true);
        setNextArrowColor(getResources().getColor(R.color.colorWhite));
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        IntentHelperClass.getInstance(this).moveToNextActivity(this, LoginActivity.class, null);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        IntentHelperClass.getInstance(this).moveToNextActivity(this, LoginActivity.class, null);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }
}
