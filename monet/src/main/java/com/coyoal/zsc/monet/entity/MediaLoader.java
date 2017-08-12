package com.coyoal.zsc.monet.entity;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;

/**
 * loader for images
 * Created by Administrator on 2017/7/23.
 */

public class MediaLoader extends CursorLoader {

    private static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    private static final String[] PROJECTION = {
            MediaStore.Files.FileColumns._ID,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.SIZE };
    private static final String ORDER = MediaStore.Images.Media.DATE_TAKEN + " DESC";
    private static final String SELECTION_FOR_IMAGES = MediaStore.Files.FileColumns.MEDIA_TYPE + "=?" + " AND " + MediaStore.MediaColumns.SIZE + ">0";
    // only iamges
    private static final String[] SELECTION_ARGS = { String.valueOf(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE) };


    public MediaLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    public static CursorLoader newInstance (Context context) {
        return new MediaLoader(context, QUERY_URI, PROJECTION, SELECTION_FOR_IMAGES, SELECTION_ARGS, ORDER);
    }
}
