package com.winter.huang.picassosample;

/**
 * Created by Winter on 2016/2/1.
 * Image加载回调
 */
public interface Listener {
    /**
     * 图片加载成功的回调
     */
    void onComplete();

    /**
     * 图片加载失败的回调
     */
    void onError();
}
