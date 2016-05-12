package com.winter.huang.picassosample;

import android.content.Context;
import android.drm.DrmManagerClient;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

/**
 * Created by Winter on 2016/2/1.
 */
public class GlideImp<T>{
    Glide glide;
    RequestManager requestManager;
    DrawableTypeRequest<T> drawableTypeRequest;


    public void setImageHelper(ImageHelper imageHelper) {

    }
//
//    @Override
//    public void with(Context context) {
//         requestManager = Glide.with(context);
//    }
//
//    @Override
//    public void load(Uri uri) {
//        drawableTypeRequest = (DrawableTypeRequest<T>) requestManager.load(uri);
//    }
//
//    @Override
//    public void load(String path) {
//        drawableTypeRequest = (DrawableTypeRequest<T>) requestManager.load(path);
//    }
//
//    @Override
//    public void load(File file) {
//        drawableTypeRequest = (DrawableTypeRequest<T>) requestManager.load(file);
//    }
//
//    @Override
//    public void load(int resourceId) {
//        drawableTypeRequest = (DrawableTypeRequest<T>) requestManager.load(resourceId);
//    }
//
//    @Override
//    public void error(Drawable drawable) {
//        drawableTypeRequest.error(drawable);
//    }
//
//    @Override
//    public void error(int resourceId) {
//        drawableTypeRequest.error(resourceId);
//    }
//
//    @Override
//    public void placeHolder(Drawable drawable) {
//        drawableTypeRequest.placeholder(drawable);
//    }
//
//    @Override
//    public void placeHolder(int resourceId) {
//        drawableTypeRequest.placeholder(resourceId);
//    }
//
//    @Override
//    public void resize(int targetWidth, int targetHeight) {
//        drawableTypeRequest.override(targetWidth, targetHeight);
//    }
//
//    @Override
//    public void centerCrop() {
//        drawableTypeRequest.centerCrop();
//    }
//
//    @Override
//    public void fitCenter() {
//        drawableTypeRequest.fitCenter();
//    }
//
//    @Override
//    public void into(ImageView target) {
//
//    }

//    @Override
//    public void into(ImageView target, Listener listener) {
//        drawableTypeRequest.listener(new GlideListener(listener));
//        drawableTypeRequest.into(target);
//    }


    private  class GlideListener implements RequestListener<T, GlideDrawable> {
        private Listener listener;

        public GlideListener(Listener listener) {
            this.listener = listener;
        }

        @Override
        public boolean onException(Exception e, T model, Target<GlideDrawable> target, boolean isFirstResource) {
            listener.onError();
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, T model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            listener.onComplete();
            return false;
        }
    }
}
