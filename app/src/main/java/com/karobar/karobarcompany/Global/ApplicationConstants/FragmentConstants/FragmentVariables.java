package com.karobar.karobarcompany.Global.ApplicationConstants.FragmentConstants;

import com.cinvoc.mehroz.wyse.Model.RouteModel;
import com.cinvoc.mehroz.wyse.Rest.Response.OrdersResponse.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mezzy on 10/22/2017.
 */

public final class FragmentVariables {

    public static final class SigninLoginFragments {
        public static final String LOGIN_FRAG_TAG = "LOGIN_FRAG";
        public static final String SIGNUP_BASIC_FRAG_TAG = "SIGNUP_BASIC_FRAG";
        public static final String SIGNUP_ADDRESS_FRAG_TAG = "SIGNUP_ADDRESS_FRAG";
        public static final String SIGNUP_MAP_FRAG_TAG = "SIGNUP_MAP_FRAG";
    }

    public static final class RoutePlanner
    {
        public static final int PLANNER_LIST_ID = 1;

    }


    public static final class DashboardFragments {
        public static final String HOME_FRAG_TAG = "HOME_FRAG";
        public static final String PROFILE_FRAG_TAG = "PROFILE_FRAG";
        public static final String SETTINGS_FRAG_TAG = "SETTINGS_FRAG";
        public static final String HISTORY_FRAG_TAG = "HISTORY_FRAG";
        public static final String LOGOUT_FRAG_TAG = "LOGOUT_FRAG";

        public static final String PRODUCT_LIST_FRAGMENT = "PRODUCT_LIST_FRAG";
        public static final String MESSAGES_FRAGMENT = "MESSAGES_FRAG";
        public static final String ADD_PRODUCT_FRAGMENT = "ADD_PRODUCT_FRAG";
        public static final String MAPS_FRAGMENT = "MAPS_FRAG";
        public static final String ORDER_LIST_FRAGMENT = "ORDER_LIST_FRAG";
    }

    public static final class HomeFragments {
        public static final ArrayList<RouteModel> routeList = new ArrayList<>();
        public static  List<Order> routePlannerList = new ArrayList<>();
        public static final String ROUTE_PLANNER_FRAG_TAG = "ROUTE_PLANNER_FRAG";
        public static final String MAP_DELIVERY_LIST_FRAGMENT = "MAP_ORDER_LIST_FRAG";
        public static final String ORDER_DETAIL_FRAGMENT = "ORDER_DETAIL_FRAG";
        public static final String PRODUCT_DETAIL_FRAGMENT = "PRODUCT_DETAIL_FRAG";
    }


    public static final class Tags {
        public static final String EMAIL_TAG = "Email";
        public static final String PASSWORD_TAG = "Password";
        public static final String CONFIRM_PASSWORD_TAG = "ConfirmPassword";
    }

    public static final class FragmentBundle {
        public static final String NAME = "Name";
        public static final String EMAIL = "Email";
        public static final String PASSWORD = "Password";
        public static final String CONFIRM_PASSWORD = "ConfirmPassword";
        public static final String CONTACT = "Contact";
        public static final String PROMOTIONAL_MESSAGE = "PromotionalMessage";
        public static final String ADDRESS = "Address";
        public static final String CITY = "City";
        public static final String PROVINCE = "Province";
        public static final String COUNTRY = "Country";
        public static final String ZIP_CODE = "ZipCode";
        public static final String PROFILE_IMAGE = "ProfileImage";
    }

}
