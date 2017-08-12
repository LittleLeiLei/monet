package com.coyoal.zsc.monet.entity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import java.lang.ref.WeakReference;

/**
 *
 * Created by Administrator on 2017/7/22.
 */

public class MediaProvider implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LOADER_ID = 1;
    private WeakReference<Context> mContext;
    private LoaderManager mLoaderManager;

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        if (mContext.get() != null) {
            return MediaLoader.newInstance(mContext.get());
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Cursor data) {
        if (mContext.get() == null) return;
        if (mContext.get() instanceof AlbumCallback) {
            ((AlbumCallback)mContext.get()).onLoadFinished(data);
        } else {
            throw new IllegalStateException("activity not implements AlbumCallback yet!");
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {
        if (mContext.get() == null) return;
        if (mContext.get() instanceof AlbumCallback) {
            ((AlbumCallback)mContext.get()).onLoadReset();
        } else {
            throw new IllegalStateException("activity not implements AlbumCallback yet!");
        }
    }

    public void init (FragmentActivity activity) {
        mContext = new WeakReference<Context>(activity);
        mLoaderManager = activity.getSupportLoaderManager();
    }

    public void destroy () {
        mLoaderManager.destroyLoader(LOADER_ID);
    }

    public void loadImages () {
        mLoaderManager.initLoader(LOADER_ID, null, this);
    }

    public interface AlbumCallback {
        void onLoadFinished(Cursor cursor);
        void onLoadReset();
    }
}
