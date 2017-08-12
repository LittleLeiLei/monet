package com.coyoal.zsc.monet;

import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.coyoal.zsc.monet.core.ImageCore;
import com.coyoal.zsc.monet.core.ImageLoaderWrapper;
import com.coyoal.zsc.monet.views.MonetActivity;

/**
 *
 * Created by Administrator on 2017/8/12.
 */

public class MonetPuppet {

    public static int REQUEST_CODE = 0x1;
    private int maxCount = 1;
    private boolean preview = false;
    private Monet monet;

    public MonetPuppet (Monet monet) {
        this.monet = monet;
    }

    public MonetPuppet maxCount (@IntRange(from = 1, to = 9) int maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    public MonetPuppet preview (@NonNull boolean preview) {
        this.preview = preview;
        return this;
    }

    public MonetPuppet imageCore (ImageCore core) {
        ImageLoaderWrapper.getInstance().setCore(core);
        return this;
    }

    public void start () {
        if (this.monet.getActivity() == null) {
            throw new IllegalStateException("the injected activity can not be null");
        }
        Intent intent = new Intent(this.monet.getActivity(), MonetActivity.class);
        this.monet.getActivity().startActivityForResult(intent, REQUEST_CODE);
    }
}
