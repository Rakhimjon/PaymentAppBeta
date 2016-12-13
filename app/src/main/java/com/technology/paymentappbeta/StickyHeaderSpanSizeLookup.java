package com.technology.paymentappbeta;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by root on 12/12/16.
 */

public class StickyHeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {


    private IHeaderSpanSizeProvider mHeaderSpanProvider;
    private IHeaderProvider mHeaderProvider;
    private GridLayoutManager.SpanSizeLookup mDelegate;

    /**
     * Construct a StickyHeaderSpanSizeLookup using a default span size lookup for other items.
     *
     * @param spanSizeProvider
     * @param headerProvider
     */
    public StickyHeaderSpanSizeLookup( IHeaderSpanSizeProvider spanSizeProvider,
                                       IHeaderProvider headerProvider ) {
        mHeaderSpanProvider = spanSizeProvider;
        mHeaderProvider = headerProvider;
        mDelegate = new GridLayoutManager.DefaultSpanSizeLookup( );
    }

    /**
     * Construct a StickyHeaderSpanSizeLookup using a provided delegate to get the span size lookup
     * for other items.
     *
     * @param spanSizeProvider
     * @param headerProvider
     * @param delegate
     */
    public StickyHeaderSpanSizeLookup( IHeaderSpanSizeProvider spanSizeProvider,
                                       IHeaderProvider headerProvider,
                                       GridLayoutManager.SpanSizeLookup delegate ) {
        mHeaderSpanProvider = spanSizeProvider;
        mHeaderProvider = headerProvider;
        mDelegate = delegate;
    }

    @Override
    public int getSpanSize( int position ) {
        return mHeaderProvider.isHeader( position ) ?
                mHeaderSpanProvider.getSpanCount( ) : mDelegate.getSpanSize( position );
    }
}

