package com.winter.huang.picassosample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Picasso.with(this)
//                .load("http://img3.hao123.com/data/1_4abffcd85f9bd08daca67c43f6067f5e_510")
//                .error(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher)
////                .memoryPolicy(MemoryPolicy.NO_CACHE)
//                .into((ImageView) findViewById(R.id.imageView), new Callback() {
//                    @Override
//                    public void onSuccess() {
//
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });
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


    }

}
