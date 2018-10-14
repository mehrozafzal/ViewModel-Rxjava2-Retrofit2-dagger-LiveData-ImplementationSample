package com.karobar.karobarcompany.view.fragments.product;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.view.adapters.ProductListAdapter;
import com.karobar.karobarcompany.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProductListFragment extends Fragment {

    @BindView(R.id.productList_addBtn)
    FloatingActionButton productListAddBtn;
    Unbinder unbinder;
    ProductListAdapter productListAdapter;
    @BindView(R.id.productList_recyclerView)
    RecyclerView productListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        bindViews();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void bindViews() {
        productListAdapter = new ProductListAdapter(getContext());
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productListRecyclerView.setAdapter(productListAdapter);
    }


    @OnClick(R.id.productList_addBtn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.productList_addBtn: {
                DialogUtils.getInstance().createAddProductDialog(getActivity());
            }
            break;
        }
    }
}
