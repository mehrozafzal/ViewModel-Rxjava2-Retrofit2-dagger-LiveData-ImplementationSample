package com.karobar.karobarcompany.controller.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.karobar.karobarcompany.global.applicationConstants.ActitvityConstants.ActivityVariables;
import com.karobar.karobarcompany.global.applicationConstants.FragmentConstants.FragmentVariables;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.controller.fragments.product.ProductListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProductActivity extends FragmentActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    View toolBarLayout;
    ImageView backBtn;
    @BindView(R.id.productActivity_container)
    FrameLayout productActivityContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        bindViews();
    }

    private void bindViews() {
        backBtn = (ImageView) toolBarLayout.findViewById(R.id.toolbar_backBtn);
        backBtn.setOnClickListener(this);
        selectFragment(FragmentVariables.ProductFragments.PRODUCT_LIST_FRAGMENT,null);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_backBtn:
                super.onBackPressed();
                break;
        }
    }

    public void selectFragment(String type, Bundle bundle) {
        Fragment fragment = null;
        String fragmentTag = "";
        switch (type) {
            case FragmentVariables.ProductFragments.PRODUCT_DETAIL_FRAGMENT:
                fragment = new ProductDetailFragment();
                fragmentTag = FragmentVariables.ProductFragments.PRODUCT_DETAIL_FRAGMENT;
                break;
            case FragmentVariables.ProductFragments.EDIT_PRODUCT_FRAGMENT:
                fragment = new EditProductFragment();
                fragmentTag = FragmentVariables.ProductFragments.EDIT_PRODUCT_FRAGMENT;
                break;

            case FragmentVariables.ProductFragments.PRODUCT_LIST_FRAGMENT:
                fragment = new ProductListFragment();
                fragmentTag = FragmentVariables.ProductFragments.PRODUCT_LIST_FRAGMENT;
                break;
            default:
                return;
        }
        if (bundle != null)
            fragment.setArguments(bundle);


        ActivityVariables.fragmentName = fragmentTag;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        fragmentTransaction.replace(productActivityContainer.getId(), fragment, fragmentTag);
        fragmentTransaction.commit();
    }

}
