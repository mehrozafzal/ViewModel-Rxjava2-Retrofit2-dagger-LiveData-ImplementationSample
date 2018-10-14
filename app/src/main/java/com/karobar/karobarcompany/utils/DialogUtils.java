package com.karobar.karobarcompany.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.karobar.karobarcompany.R;

public class DialogUtils {

    private static DialogUtils dialogUtils;

    public static DialogUtils getInstance() {
        if (dialogUtils == null) {
            synchronized (DialogUtils.class) {
                dialogUtils = new DialogUtils();
            }
        }
        return dialogUtils;
    }

    public void createAddProductDialog(Context context) {
        @SuppressLint("RestrictedApi")
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_product, null);

//        Button dialogGalleryButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromGallery);
//        Button dialogCameraButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromCamera);
//        ImageView dialogCancelButton = (ImageView) dialogView.findViewById(R.id.basicSignUpImageDialog_cancelImage);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        if (alertDialog.getWindow() != null)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


//        dialogGalleryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onGalleryButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCameraButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onCameraButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
        alertDialog.show();
    }

    public void createProductDetailDialog(Context context) {
        @SuppressLint("RestrictedApi")
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_product_detail, null);

//        Button dialogGalleryButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromGallery);
//        Button dialogCameraButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromCamera);
//        ImageView dialogCancelButton = (ImageView) dialogView.findViewById(R.id.basicSignUpImageDialog_cancelImage);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        if (alertDialog.getWindow() != null)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        dialogGalleryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onGalleryButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCameraButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onCameraButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
        alertDialog.show();
    }

    public void createEditProductDialog(Context context) {
        @SuppressLint("RestrictedApi")
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_product_edit, null);

//        Button dialogGalleryButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromGallery);
//        Button dialogCameraButton = (Button) dialogView.findViewById(R.id.basicSignUpImageDialog_fromCamera);
//        ImageView dialogCancelButton = (ImageView) dialogView.findViewById(R.id.basicSignUpImageDialog_cancelImage);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        if (alertDialog.getWindow() != null)
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        dialogGalleryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onGalleryButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCameraButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imagePickerDialogNotifier.onCameraButtonClicked();
//                alertDialog.dismiss();
//            }
//        });
//        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
        alertDialog.show();
    }

}
