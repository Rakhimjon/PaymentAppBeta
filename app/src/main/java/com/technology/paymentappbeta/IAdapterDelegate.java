package com.technology.paymentappbeta;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by root on 12/12/16.
 */
interface IAdapterDelegate<VH extends RecyclerView.ViewHolder, T> {

    Class< T > getItemClass( );

    int getViewType( );

    VH onCreateViewHolder( ViewGroup parent, int viewType );

    void onBindViewHolder( VH holder, T item );



}