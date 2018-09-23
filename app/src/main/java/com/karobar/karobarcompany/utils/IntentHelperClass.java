package com.karobar.karobarcompany.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.karobar.karobarcompany.R;


/**
 * Created by Mezzy on 10/22/2017.
 */

public class IntentHelperClass {

    private Intent intent;
    private Context context;
    private Activity activity;
    private static IntentHelperClass intentHelperClass;


    private IntentHelperClass(Context context) {
        this.context = context;
    }

    public static synchronized IntentHelperClass getInstance(Context context) {
        if (intentHelperClass == null) {
            intentHelperClass = new IntentHelperClass(context);
        }

        return intentHelperClass;
    }

    public void moveToNextActivity(Context context, Class<?> nextClass, Bundle bundle) {
        intent = new Intent(context, nextClass);
        if (bundle != null)
            intent.putExtras(bundle);
        context.startActivity(intent);
        activity = (Activity) context;
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }

    public void moveToPrevActivity(Context context, Class<?> prevClass) {
        intent = new Intent(context, prevClass);
        context.startActivity(intent);
        activity = (Activity) context;
        //  activity.overridePendingTransition(R.anim.exit, R.anim.enter);
    }


}
