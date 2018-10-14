package com.karobar.karobarcompany.view.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.utils.IntentUtils;

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
        setCustomTransformer(new ZoomOutPageTransformer());
        setBarColor(Color.parseColor("#90000000"));
        setSeparatorColor(Color.parseColor("#7351B2"));
        showSkipButton(true);
        setProgressButtonEnabled(true);
        setNextArrowColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        IntentUtils.getInstance(this).moveToNextActivity(this, LoginActivity.class, null);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        IntentUtils.getInstance(this).moveToNextActivity(this, LoginActivity.class, null);
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

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
