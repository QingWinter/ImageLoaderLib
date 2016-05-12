package com.winter.huang.picassosample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by Winter on 2016/2/3.
 * 图片包装器
 */
public class ImageWrapper {
    Uri uri;
    Context context;
    ImageView target;
    Listener listener;
    int resourceId;
    int targetWidth;
    int targetHeight;
    int errorResId;
    int placeHolderResId;
    boolean isResize;
    boolean isFitCenter;
    boolean isCenterCrop;
    Drawable errorDrawable;
    Drawable placeHolderDrawable;
    ImageManager imageManager;

    public static class Builder {
        private int targetWidth;
        private int targetHeight;
        private int errorResId;
        private int placeHolderResId;
        private boolean isResize;
        private boolean isFitCenter;
        private boolean isCenterCrop;
        private Drawable errorDrawable;
        private Drawable placeHolderDrawable;

        public Builder targetWidth(int targetWidth) {
            this.targetWidth = targetWidth;
            return this;
        }

        public Builder targetHeight(int targetHeight) {
            this.targetHeight = targetHeight;
            return this;
        }

        public Builder errorResId(int errorResId) {
            this.errorResId = errorResId;
            return this;
        }

        public Builder placeHolderResId(int placeHolderResId) {
            this.placeHolderResId = placeHolderResId;
            return this;
        }

        public Builder isResize(boolean isResize) {
            this.isResize = isResize;
            return this;
        }

        public Builder isFitCenter(boolean isFitCenter) {
            this.isFitCenter = isFitCenter;
            return this;
        }

        public Builder isCenterCrop(boolean isCenterCrop) {
            this.isCenterCrop = isCenterCrop;
            return this;
        }

        public Builder errorDrawable(Drawable errorDrawable) {
            this.errorDrawable = errorDrawable;
            return this;
        }

        public Builder placeHolderDrawable(Drawable placeHolderDrawable) {
            this.placeHolderDrawable = placeHolderDrawable;
            return this;
        }

        public ImageWrapper build(){
            ImageWrapper imageWrapper = new ImageWrapper();
            imageWrapper.targetWidth = targetWidth;
            imageWrapper.targetHeight = targetHeight;
            imageWrapper.errorResId = errorResId;
            imageWrapper.placeHolderResId = placeHolderResId;
            imageWrapper.isResize = isResize;
            imageWrapper.isFitCenter = isFitCenter;
            imageWrapper.isCenterCrop = isCenterCrop;
            imageWrapper.errorDrawable = errorDrawable;
            imageWrapper.placeHolderDrawable = placeHolderDrawable;
            return imageWrapper;
        }

    }
}
