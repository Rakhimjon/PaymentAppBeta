package com.technology.paymentappbeta;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by root on 12/12/16.
 */


public class DefaultHeaderSpanSizeProvider implements IHeaderSpanSizeProvider {

    private final int mSpanSize;

    /**
     * Construct a DefaultHeaderSpanSizeProvider returning the span size from the layout
     * manager.
     * @param layoutManager the GridLayoutManager
     */
    public DefaultHeaderSpanSizeProvider( GridLayoutManager layoutManager ) {
        mSpanSize = layoutManager.getSpanCount( );
    }

    @Override
    public int getSpanCount( ) {
        return mSpanSize;
    }
}
