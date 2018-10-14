package com.karobar.karobarcompany.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.karobar.karobarcompany.constants.ActivityVariables;
import com.karobar.karobarcompany.constants.FragmentVariables;
import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.view.fragments.order.OrderDetailFragment;
import com.karobar.karobarcompany.view.fragments.order.OrderListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class OrderActivity extends FragmentActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    View toolBarLayout;
    ImageView backBtn;
    @BindView(R.id.orderActivity_container)
    FrameLayout orderActivityContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        bindViews();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void bindViews() {
        backBtn = (ImageView) toolBarLayout.findViewById(R.id.toolbar_backBtn);
        backBtn.setOnClickListener(this);
        selectFragment(FragmentVariables.OrderFragments.ORDER_LIST_FRAGMENT,null);
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
            case FragmentVariables.OrderFragments.ORDER_DETAIL_FRAGMENT:
                fragment = new OrderDetailFragment();
                fragmentTag = FragmentVariables.OrderFragments.ORDER_DETAIL_FRAGMENT;
                break;
            case FragmentVariables.OrderFragments.ORDER_LIST_FRAGMENT:
                fragment = new OrderListFragment();
                fragmentTag = FragmentVariables.OrderFragments.ORDER_LIST_FRAGMENT;
                break;
            default:
                return;
        }
        if (bundle != null)
            fragment.setArguments(bundle);


        ActivityVariables.fragmentName = fragmentTag;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        fragmentTransaction.replace(orderActivityContainer.getId(), fragment, fragmentTag);
        fragmentTransaction.commit();
    }

}
