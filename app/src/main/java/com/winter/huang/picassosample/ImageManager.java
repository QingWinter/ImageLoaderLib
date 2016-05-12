package com.winter.huang.picassosample;

import android.content.Context;
import android.net.Uri;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Winter on 2016/2/1.
 * 暴露给客户端的图片管理类，依托于
 * @see ImageHelper
 */
public class ImageManager {
    private ImageHelper imageHelper;
    private static ImageManager singleton;
    static Context context;

    public static ImageManager getInstance() {
        if (singleton == null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    singleton = new ImageManager();
                }
            }
        }
        return singleton;
    }

    public static ImageManager with(Context context) {
        ImageManager.context = context;
        return getInstance();
    }

    public void setImageHelper(ImageHelper imageHelper) {
        this.imageHelper = imageHelper;
    }

    public ImageHelper load(String path) {
        return this.load(Uri.parse(path));
    }

    public ImageHelper load(File file) {
        return this.load(Uri.fromFile(file));
    }

    public ImageHelper load(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("uri can't be null");
        }
        if (imageHelper == null) {
            imageHelper = new ImageHelper(this, uri, 0);
        } else {
            imageHelper.getWrapper().imageManager = this;
            imageHelper.getWrapper().uri = uri;
        }
        return imageHelper;
    }

    public ImageHelper load(int resId) {
        if (resId == 0) {
            throw new IllegalArgumentException("resId can't be 0");
        }
        if (imageHelper == null) {
            imageHelper = new ImageHelper(this, null, resId);
        } else {
            imageHelper.getWrapper().imageManager = this;
            imageHelper.getWrapper().resourceId = resId;
        }
        return imageHelper;
    }

}
