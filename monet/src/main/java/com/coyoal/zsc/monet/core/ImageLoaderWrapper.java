package com.coyoal.zsc.monet.core;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

/**
 * wrapper for imageloader
 * Created by Administrator on 2017/7/24.
 */

public class ImageLoaderWrapper implements ImageCore {

    private ImageCore core;

    private static class SingletonHolder {
        private static final ImageLoaderWrapper INSTANCE = new ImageLoaderWrapper();
    }

    public static ImageLoaderWrapper getInstance () {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void displayImage(Context context, ImageView view, Uri uri) {
        if (core == null) {
            throw new IllegalStateException("ImageCore has been not initialize");
        }
        core.displayImage(context, view, uri);
    }

    @Override
    public void displayImage(Context context, ImageView view, Uri uri, int sizeX, int sizeY) {
        if (core == null) {
            throw new IllegalStateException("ImageCore has been not initialize");
        }
        core.displayImage(context, view, uri, sizeX, sizeY);
    }

    public void setCore (ImageCore core) {
        this.core = core;
    }
}
