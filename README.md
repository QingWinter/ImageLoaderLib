# ImageLoaderLib
基于Picasso封装的图片加载库，可以实现图片加载库的切换，对调用者透明。
## 使用在`Application`中初始化统一的设置
```java
    /**
     * 初始化图片加载信息，如全局统一的占位符和错误展示，客户端可根据需要覆盖
     */
    private void initImageManager() {
        ImageHelper imageHelper = new ImageHelper(context)
                .error(R.drawable.starlife)
                .placeHolder(R.drawable.placeholder);
        ImageManager.getInstance().setImageHelper(imageHelper);
    }
```

之后在只需要这样写

```java
        ImageManager.with(this)
                    .load("http://img3.hao123.com/data/1_4abffcd85f9bd08daca67c43f6067f5e_510")
                    .error(R.mipmap.ic_launcher)
                    .resize(100, 200)
                    .centerCrop()
                    .into((ImageView) findViewById(R.id.imageView), new Listener() {
                        @Override
                        public void onComplete() {
                            Log.d(TAG, "~~~~~~~~~~~~~~~~onComplete");
                        }

                        @Override
                        public void onError() {
                            Log.d(TAG, "~~~~~~~~~~~~~~~~onError");
                        }
                    });

```
