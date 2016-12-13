package com.technology.paymentappbeta;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.technology.paymentappbeta.model.Item;

/**
 * Created by root on 12/12/16.
 */

public class TextItemAdapterDelegate implements IAdapterDelegate<TextItemAdapterDelegate.TextViewHolder, Item> {

    Context context;

    public TextItemAdapterDelegate(Context c){
        context = c;
    }

    @Override
    public Class<Item> getItemClass() {
        return Item.class;
    }

    @Override
    public int getViewType() {
        return getClass().hashCode();
    }

    @Override
    public TextItemAdapterDelegate.TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new TextItemAdapterDelegate.TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextItemAdapterDelegate.TextViewHolder holder, Item item) {
        Glide.with(context).load(item.imageurl).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public TextViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
