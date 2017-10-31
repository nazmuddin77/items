package com.example.nazmuddinmavliwala.credr.ui.items.views.viewholders;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazmuddinmavliwala.credr.R;
import com.example.nazmuddinmavliwala.credr.base.views.recyclerview.ReactiveViewHolder;
import com.example.nazmuddinmavliwala.credr.ui.items.models.ItemVO;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

import static android.content.ContentValues.TAG;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemsViewHolder extends ReactiveViewHolder<ItemVO> {

    @BindViews({
            R.id.tv_name,
            R.id.tv_price
    })
    List<TextView> textViews;

    @BindView(R.id.image)
    ImageView imageView;

    public ItemsViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void bindData(ItemVO data) {

        Picasso.Builder builder = new Picasso.Builder(this.context);
        builder.listener((picasso, uri, exception) -> exception.printStackTrace());
        builder.build().load("http://" + data.getImgUri()).into(imageView);

        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(data.getName());

        TextView tvPrice = findViewById(R.id.tv_price);
        tvPrice.setText(data.getPrice());
    }
}
