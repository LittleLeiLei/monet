package com.coyoal.zsc.monet.core;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

/**
 * interface for imageloader
 * Created by Administrator on 2017/7/24.
 */

public interface ImageCore {

    void displayImage(Context context, ImageView view, Uri uri);

    void displayImage(Context context, ImageView view, Uri uri, int sizeX, int sizeY);

}
