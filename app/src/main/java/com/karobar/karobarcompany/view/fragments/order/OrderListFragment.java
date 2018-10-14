package com.karobar.karobarcompany.view.fragments.order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karobar.karobarcompany.R;
import com.karobar.karobarcompany.view.adapters.OrderListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OrderListFragment extends Fragment {

    Unbinder unbinder;
    OrderListAdapter orderListAdapter;
    @BindView(R.id.orderList_recyclerView)
    RecyclerView orderListRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        bindViews();
        return view;
    }

    private void bindViews()
    {
        orderListAdapter = new OrderListAdapter(getContext());
        orderListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        orderListRecyclerView.setAdapter(orderListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
