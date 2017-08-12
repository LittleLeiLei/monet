package com.coyoal.zsc.monet.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coyoal.zsc.monet.R;
import com.coyoal.zsc.monet.core.ImageLoaderWrapper;
import com.coyoal.zsc.monet.entity.Thumb;

/**
 * adapter for thumbs
 * Created by Administrator on 2017/7/22.
 */

public class ThumbAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    public ThumbAdapter (Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_thumb, parent, false);
        return new ThumbViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // TODO: 2017/7/23 bind image
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("cannot move to position " + position);
        }
        ThumbViewHolder mHolder = (ThumbViewHolder) holder;
        Thumb thumb = Thumb.convert(mCursor);
        ImageLoaderWrapper.getInstance().displayImage(mContext, mHolder.thumb, thumb.src);
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setCursor (Cursor cursor) {
        this.mCursor = cursor;
        notifyDataSetChanged();
    }

    class ThumbViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumb;

        public ThumbViewHolder(View itemView) {
            super(itemView);
            thumb = (ImageView) itemView.findViewById(R.id.iv_thumb);
        }
    }
}
