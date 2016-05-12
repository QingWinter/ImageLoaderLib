package com.winter.huang.picassosample;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Winter on 2016/2/1.
 * Image配置的接口，为
 * @see ImageHelper
 * 提供统一格式的配置，日后如有需要可重新实现此接口替换ImageHelper
 */
public interface IHelper {
    IHelper error(Drawable drawable);
    IHelper error(int resourceId);
    IHelper placeHolder(Drawable drawable);
    IHelper placeHolder(int resourceId);
    IHelper resize(int targetWidth, int targetHeight);
    IHelper centerCrop();
    IHelper fitCenter();
    void into(ImageView target);
    void into(ImageView target, Listener listener);
}