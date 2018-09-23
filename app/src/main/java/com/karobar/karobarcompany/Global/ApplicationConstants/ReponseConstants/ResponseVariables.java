package com.karobar.karobarcompany.Global.ApplicationConstants.ReponseConstants;

import com.cinvoc.mehroz.wyse.Rest.Response.CategoryResponseViewModel;
import com.cinvoc.mehroz.wyse.Rest.Response.OrdersResponse.Order;
import com.cinvoc.mehroz.wyse.Rest.Response.OrdersResponse.OrderProduct;
import com.cinvoc.mehroz.wyse.Rest.Response.OrdersResponse.OrdersResponseViewModel;
import com.cinvoc.mehroz.wyse.Rest.Response.ProductResponse.Product;
import com.cinvoc.mehroz.wyse.Rest.Response.ProductResponse.ProductResponseViewModel;
import com.cinvoc.mehroz.wyse.Rest.Response.ProfileResponse.countryResponse.CountryResponse;
import com.cinvoc.mehroz.wyse.Rest.Response.SignInResponse.SignInResponseViewModel;
import com.cinvoc.mehroz.wyse.Rest.Response.SubCategoriesResponseViewModel;

import java.util.ArrayList;


public class ResponseVariables {
    public static SignInResponseViewModel signInResponseViewModel = null;
    public static OrdersResponseViewModel ordersResponseViewModel = null;
    public static ProductResponseViewModel productDataViewModel = null;
    public static CategoryResponseViewModel categoryResponse = null;
    public static CountryResponse countryResponse = null;
    public static SubCategoriesResponseViewModel subCategoriesResponse = null;

    public static ArrayList<Order> orderList = new ArrayList<>();
    public static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<OrderProduct> orderProductsList = new ArrayList<>();
}
