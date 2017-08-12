package com.coyoal.zsc.monet.entity;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * entity for image
 * Created by Administrator on 2017/7/23.
 */

public class Thumb {
    public Uri src;

    public Thumb (Uri src) {
        this.src = src;
    }

    public static Thumb convert(Cursor cursor) {
        return new Thumb(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getLong(cursor.getColumnIndex(MediaStore.Files.FileColumns._ID))));
    }
}
