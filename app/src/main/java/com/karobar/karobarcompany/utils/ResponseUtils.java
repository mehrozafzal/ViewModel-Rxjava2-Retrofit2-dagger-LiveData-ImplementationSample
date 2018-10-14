package com.karobar.karobarcompany.utils;

import android.util.Log;

import com.google.gson.JsonElement;
import com.karobar.karobarcompany.constants.ResponseVariables;
import com.karobar.karobarcompany.retrofit.ResponseCallBack;

public class ResponseUtils {

    private static ResponseUtils responseUtils;

    public static ResponseUtils getInstance() {
        if (responseUtils == null) {
            synchronized (ResponseUtils.class) {
                responseUtils = new ResponseUtils();
            }
        }
        return responseUtils;
    }

    public void renderResponse(ResponseCallBack responseCallBack, JsonElement response, int responseId) {
        if (!response.isJsonNull()) {
            switch (responseId) {
                case ResponseVariables.LOGIN_RESPONSE_ID:
                    responseCallBack.onResponseReceived();
                    break;
                default:
                    break;
            }
            Log.d("response=", response.toString());
        } else {
            Log.d("response=", "Error");
        }
    }
}
