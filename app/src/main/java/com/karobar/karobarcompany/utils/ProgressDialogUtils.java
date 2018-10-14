package com.karobar.karobarcompany.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtils {

    private static ProgressDialogUtils progressDialogUtils;
    private static ProgressDialog progressDialog;

    public static ProgressDialogUtils getInstance() {
        if (progressDialogUtils == null) {
            synchronized (ProgressDialogUtils.class) {
                progressDialogUtils = new ProgressDialogUtils();
            }
        }
        return progressDialogUtils;
    }

    public void initProgressDialog(Context context, String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(false);
        }
        progressDialog.setMessage(msg);
    }

    public void showProgressDialog() {
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }
    }
}
