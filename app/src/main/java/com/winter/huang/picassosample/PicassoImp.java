package com.winter.huang.picassosample;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by Winter on 2016/2/1.
 * Picasso相关实现 统一实现
 *
 * @see ILoader
 * 可以快速切换实现方式而保证客户端API不变
 */
public class PicassoImp implements ILoader {
    private RequestCreator requestCreator;

    @Override
    public void setImageWrapper(ImageWrapper imageWrapper) {
        if (imageWrapper != null) {
            Picasso picasso = Picasso.with(imageWrapper.context);
            requestCreator = (imageWrapper.uri != null) ?
                    picasso.load(imageWrapper.uri) : picasso.load(imageWrapper.resourceId);
            requestCreator = (imageWrapper.errorDrawable != null) ?
                    requestCreator.error(imageWrapper.errorDrawable) : requestCreator;
            requestCreator = (imageWrapper.placeHolderDrawable != null) ?
                    requestCreator.placeholder(imageWrapper.placeHolderDrawable) : requestCreator;
            requestCreator = (imageWrapper.isResize) ?
                    requestCreator.resize(imageWrapper.targetWidth, imageWrapper.targetHeight) : requestCreator;
            requestCreator = (imageWrapper.isFitCenter) ?
                    requestCreator.fit() : requestCreator;
            requestCreator = (imageWrapper.isCenterCrop) ?
                    requestCreator.centerCrop() : requestCreator;
            if (imageWrapper.listener == null) {
                requestCreator.into(imageWrapper.target);
            } else {
                requestCreator.into(imageWrapper.target, new PicassoCallBack(imageWrapper.listener));
            }

        }

    }

    /**
     * 图片加载结果的回调，为Picasso的Callback设置自己的Listener进行代理
     */
    class PicassoCallBack implements Callback {
        private Listener listener;

        public PicassoCallBack(Listener listener) {
            this.listener = listener;
        }


        @Override
        public void onSuccess() {
            listener.onComplete();
        }

        @Override
        public void onError() {
            listener.onError();
        }
    }
}
