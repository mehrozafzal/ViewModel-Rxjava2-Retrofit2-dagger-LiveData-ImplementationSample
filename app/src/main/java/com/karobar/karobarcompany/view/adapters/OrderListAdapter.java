package com.karobar.karobarcompany.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.karobar.karobarcompany.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {



    private Context context;
    //  private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.orderList_shopName)
        TextView orderListShopName;
        @BindView(R.id.horizontal_line_route)
        View horizontalLineRoute;
        @BindView(R.id.orderList_location)
        TextView orderListLocation;
        @BindView(R.id.orderList_assignBtn)
        Button orderListAssignBtn;
        @BindView(R.id.orderList_viewOrderBtn)
        Button orderListViewOrderBtn;
        @BindView(R.id.orderList_viewRouteBtn)
        Button orderListViewRouteBtn;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

//        public void bindViews(List<Product> productList, int position) {
//
//        }
    }

    public OrderListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        final Product product = ResponseVariables.productList.get(position);
//        holder.itemName.setText(product.getName());
//        holder.itemSubCategory.setText(""+product.getCompanyName());
//        holder.itemPrice.setText(product.getPrice());

        //  holder.bindViews(productList, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Bundle bundle = new Bundle();
                //    bundle.putInt("productId",product.getId());
//                ((DashboardActivity) v.getContext()).selectFragment(FragmentVariables.HomeFragments.PRODUCT_DETAIL_FRAGMENT, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}