package com.winter.huang.picassosample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by Winter on 2016/2/2.
 * 辅助ImageManager来配置图片加载
 *
 * @see ImageWrapper
 */
public class ImageHelper implements IHelper {

    ImageWrapper wrapper;
    private ILoader iLoader;

    public ImageHelper(Context context) {
        wrapper = new ImageWrapper();
        wrapper.context = context;
    }

    public ImageHelper(ImageManager imageManager, Uri uri, int resId) {
        wrapper = new ImageWrapper();
        wrapper.imageManager = imageManager;
        wrapper.context = imageManager.context;
        wrapper.uri = uri;
        wrapper.resourceId = resId;
    }

    @Override
    public ImageHelper error(Drawable errorDrawable) {
        if (errorDrawable == null) {
            throw new IllegalArgumentException("placeHolderDrawable can't be null");
        }
//
//        if (wrapper.errorResId != 0) {
//            throw new IllegalArgumentException("errorResId already exits");
//        }
        wrapper.errorDrawable = errorDrawable;
        return this;
    }

    @Override
    public ImageHelper error(int errorResId) {
        wrapper.errorResId = errorResId;
        if (errorResId == 0) {
            throw new IllegalArgumentException("errorResId can't be 0");
        }
//        if (wrapper.errorDrawable != null) {
//            throw new IllegalArgumentException("errorDrawable already exits");
//        }
        wrapper.errorDrawable = wrapper.context.getResources().getDrawable(errorResId);
        return this;
    }

    @Override
    public ImageHelper placeHolder(Drawable placeHolderDrawable) {
        if (placeHolderDrawable == null) {
            throw new IllegalArgumentException("placeHolderDrawable can't be null");
        }

//        if (wrapper.placeHolderResId != 0) {
//            throw new IllegalArgumentException("placeHolderResId already exits");
//        }
        wrapper.placeHolderDrawable = placeHolderDrawable;
        return this;
    }

    @Override
    public ImageHelper placeHolder(int placeHolderResId) {
        wrapper.placeHolderResId = placeHolderResId;

        if (placeHolderResId == 0) {
            throw new IllegalArgumentException("placeHolderResId can't be 0");
        }
//        if (wrapper.placeHolderDrawable != null) {
//            throw new IllegalArgumentException("placeHolderDrawable already exits");
//        }
        wrapper.placeHolderDrawable = wrapper.context.getResources().getDrawable(placeHolderResId);
        return this;
    }

    @Override
    public ImageHelper centerCrop() {
        wrapper.isCenterCrop = true;
        return this;
    }

    @Override
    public ImageHelper fitCenter() {
        wrapper.isFitCenter = true;
        return this;
    }

    @Override
    public ImageHelper resize(int targetWidth, int targetHeight) {
        wrapper.isResize = true;
        wrapper.targetWidth = targetWidth;
        wrapper.targetHeight = targetHeight;
        return this;
    }

    @Override
    public void into(ImageView target) {
        this.into(target, null);
    }

    @Override
    public void into(ImageView target, Listener listener) {
        wrapper.target = target;
        wrapper.listener = listener;

        iLoader = new PicassoImp();
        iLoader.setImageWrapper(wrapper);
    }

    public ImageWrapper getWrapper() {
        return wrapper;
    }
}
