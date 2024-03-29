package com.technology.paymentappbeta;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 12/12/16.
 */

public class SampleAdapter <T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List< T > mItems;
    private Map< Integer, IAdapterDelegate > mViewTypeDelegates;
    private Map< Class, IAdapterDelegate > mClassDelegates;

    public SampleAdapter(List<T> mItems) {
        this.mItems = mItems;
        mViewTypeDelegates= new HashMap<>(2);
        mClassDelegates= new HashMap<>(2);

    }
    public  void addDelegate(IAdapterDelegate delegate){
        mViewTypeDelegates.put(delegate.getViewType(),delegate);
        mClassDelegates.put(delegate.getItemClass(),delegate);
    }

    @Override
    public int getItemViewType(int position) {

        return mClassDelegates.get(mItems.get(position).getClass()).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return mViewTypeDelegates.get(viewType).onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mViewTypeDelegates.get(getItemViewType(position)).onBindViewHolder(holder,mItems.get(position));

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
