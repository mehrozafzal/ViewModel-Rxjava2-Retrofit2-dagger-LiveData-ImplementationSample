package com.karobar.karobarcompany.view.activities;

import android.view.Window;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.karobar.karobarcompany.constants.SharedPrefsVariables;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentUtils;
import com.karobar.karobarcompany.utils.PreferenceUtils;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        configSplash.setBackgroundColor(R.color.colorWhite);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        configSplash.setLogoSplash(R.drawable.karobar_icon);
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);
        configSplash.setTitleSplash(null);
    }

    @Override
    public void animationsFinished() {
        if (PreferenceUtils.getInstance(this).getBooleanPref(SharedPrefsVariables.KEY_APPINTRO))
            IntentUtils.getInstance(this).moveToNextActivity(this, LoginActivity.class,null);
        else {
            IntentUtils.getInstance(this).moveToNextActivity(this, IntroductionActivity.class,null);
            PreferenceUtils.getInstance(this).setBooleanPref(SharedPrefsVariables.KEY_APPINTRO, true);
        }
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }
}
