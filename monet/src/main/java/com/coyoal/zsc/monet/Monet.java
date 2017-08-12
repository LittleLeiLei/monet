package com.coyoal.zsc.monet;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * Entry
 * Created by Administrator on 2017/7/22.
 */

public class Monet {

    public static int REQUEST_CODE = 0x1;

    private WeakReference<Activity> mContext;
    private WeakReference<Fragment> mFrg;
    private MonetPuppet mPuttet;

    public Monet (Activity activity) {
        this(activity, null);
    }

    public Monet (Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public Monet (Activity activity, Fragment fragment) {
        mPuttet = new MonetPuppet(this);
        mContext = new WeakReference<>(activity);
        mFrg = new WeakReference<>(fragment);
    }

    public static Monet inject (Activity activity) {
        return new Monet(activity);
    }

    public static Monet inject (Fragment fragment) {
        return new Monet(fragment);
    }

    public Activity getActivity () {
        return mContext.get();
    }

    /**
     * start images picker
     */
    public MonetPuppet puppet () {
        return new MonetPuppet(this);
    }
}
