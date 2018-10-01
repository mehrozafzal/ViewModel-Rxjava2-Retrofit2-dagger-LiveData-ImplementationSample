package com.karobar.karobarcompany.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karobar.karobarcompany.R;

import butterknife.ButterKnife;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {



    private Context context;
    //  private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.item_name)
//        TextView itemName;
//        @BindView(R.id.item_price)
//        TextView itemPrice;
//        @BindView(R.id.item_subcategory_name)
//        TextView itemSubcategoryName;
//        @BindView(R.id.item_amount)
//        TextView itemAmount;
//        @BindView(R.id.item_quantity_label)
//        TextView itemQuantityLabel;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

//        public void bindViews(List<Product> productList, int position) {
//
//        }
    }

    public ProductListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        final Product product = ResponseVariables.productList.get(position);
//        holder.itemName.setText(product.getName());
//        holder.itemSubCategory.setText(""+product.getCompanyName());
//        holder.itemPrice.setText(product.getPrice());

        //  holder.bindViews(productList, position);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              //  Bundle bundle = new Bundle();
//                //    bundle.putInt("productId",product.getId());
////                ((DashboardActivity) v.getContext()).selectFragment(FragmentVariables.HomeFragments.PRODUCT_DETAIL_FRAGMENT, bundle);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}