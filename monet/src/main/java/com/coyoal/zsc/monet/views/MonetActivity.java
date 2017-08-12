package com.coyoal.zsc.monet.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coyoal.zsc.monet.R;
import com.coyoal.zsc.monet.adapter.ThumbAdapter;
import com.coyoal.zsc.monet.entity.MediaProvider;

/**
 * activity for displaying images
 * Created by Administrator on 2017/7/22.
 */

public class MonetActivity extends AppCompatActivity implements MediaProvider.AlbumCallback {

    private RecyclerView mThumbView;
    private MediaProvider mMediaProvider = new MediaProvider();
    private ThumbAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monet);
        initThumbView();
        if (ContextCompat.checkSelfPermission(MonetActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //申请CAMERA权限
            ActivityCompat.requestPermissions(MonetActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
        } else {
            mMediaProvider.init(this);
            mMediaProvider.loadImages();
        }
    }

    private void initThumbView () {
        mThumbView = (RecyclerView) findViewById(R.id.rv_thumb);
        mAdapter = new ThumbAdapter(this, null);
        mThumbView.setLayoutManager(new GridLayoutManager(this, 3));
        mThumbView.setAdapter(mAdapter);
    }

    @Override
    public void onLoadFinished(Cursor cursor) {
        mAdapter.setCursor(cursor);
    }

    @Override
    public void onLoadReset() {
        mAdapter.setCursor(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaProvider.destroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 3) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 授权
                mMediaProvider.init(this);
                mMediaProvider.loadImages();
                initThumbView();
            }
        }
    }
}
