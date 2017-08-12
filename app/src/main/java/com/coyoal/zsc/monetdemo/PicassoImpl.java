package com.coyoal.zsc.monetdemo;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.coyoal.zsc.monet.core.ImageCore;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/7/24.
 */

public class PicassoImpl implements ImageCore {
    @Override
    public void displayImage(Context context, ImageView view, Uri uri) {
        Picasso.with(context).load(uri).into(view);
    }

    @Override
    public void displayImage(Context context, ImageView view, Uri uri, int sizeX, int sizeY) {
        Picasso.with(context).load(uri).into(view);
    }
}
