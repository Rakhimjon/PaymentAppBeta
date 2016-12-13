package com.technology.paymentappbeta;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.technology.paymentappbeta.model.Header;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by root on 12/12/16.
 */

public class HeaderItemAdapterDelegate implements IAdapterDelegate<HeaderItemAdapterDelegate.HeaderViewHolder, Header>,
        IHeaderProvider<HeaderItemAdapterDelegate.HeaderViewHolder> {
    private List<Object> mItemes;

    public HeaderItemAdapterDelegate(List<Object> mItemes) {
        this.mItemes = mItemes;
    }

    @Override
    public Class<Header> getItemClass() {
        return Header.class;
    }

    @Override
    public int getViewType() {
        return getClass().hashCode();
    }

    @Override
    public HeaderItemAdapterDelegate.HeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_header,parent,false);

        return new  HeaderItemAdapterDelegate.HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeaderItemAdapterDelegate.HeaderViewHolder holder, Header item) {
        holder.textView.setText(item.text);

    }

    @Override
    public boolean isHeader(int position) {
        return mItemes.get(position) instanceof Header;
    }

    @Override
    public int getHeaderForPosition(int position) {
        if (position<0|| position>=mItemes.size()){
            return IHeaderProvider.NO_HEADER;
        }

        if (mItemes.get(position)instanceof Header) {
            return position;
        }
        for (int i=position-1 ;i>=0; --i){
            if (mItemes.get(i)instanceof Header){
                return i;
            }
        }
        return IHeaderProvider.NO_HEADER;
    }

    @Override
    public HeaderItemAdapterDelegate.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return onCreateViewHolder(parent,getViewType());
    }

    @Override
    public void onBindHeaderViewHolder(HeaderItemAdapterDelegate.HeaderViewHolder holder, final int position) {
        onBindViewHolder(holder,(Header)mItemes.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });



    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.text);
        }
    }
}
