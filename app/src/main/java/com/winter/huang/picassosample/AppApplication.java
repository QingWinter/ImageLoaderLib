package com.winter.huang.picassosample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Winter on 2016/2/3.
 */
public class AppApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initImageManager();
    }

    /**
     * 初始化图片加载信息，如全局统一的占位符和错误展示，客户端可根据需要覆盖
     */
    private void initImageManager() {
        ImageHelper imageHelper = new ImageHelper(context)
                .error(R.drawable.starlife)
                .placeHolder(R.drawable.placeholder);
        ImageManager.getInstance().setImageHelper(imageHelper);
    }

}
