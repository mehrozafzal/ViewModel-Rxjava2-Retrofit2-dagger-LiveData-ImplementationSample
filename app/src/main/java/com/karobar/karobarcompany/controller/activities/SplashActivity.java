package com.karobar.karobarcompany.controller.activities;

import com.daimajia.androidanimations.library.Techniques;
import com.karobar.karobarcompany.Global.SharedPrefConstants.SharedPrefsVariables;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentHelperClass;
import com.karobar.karobarcompany.utils.SharedPrefsHelper;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

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
        if (SharedPrefsHelper.getInstance(this).getBooleanPref(SharedPrefsVariables.KEY_APPINTRO))
            IntentHelperClass.getInstance(this).moveToNextActivity(this, LoginActivity.class,null);
        else {
            IntentHelperClass.getInstance(this).moveToNextActivity(this, IntroductionActivity.class,null);
            SharedPrefsHelper.getInstance(this).setBooleanPref(SharedPrefsVariables.KEY_APPINTRO, true);
        }
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }
}
