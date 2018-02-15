package com.nca.testandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public final class MyAppGlideModule extends AppGlideModule {

    public static void showImage(Context context, String url, ImageView imageView) {
        GlideApp.with(context)
                .load((url == null || url.isEmpty())? imageView.getContentDescription(): url)
                .into(imageView);

    }
}