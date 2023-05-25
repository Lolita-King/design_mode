package com.example.designmode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Imageloader {
    //图片缓存
    ImageCache  mImageCache = new ImageCache();

    //sd卡缓存
    DiskCache mDiskCache = new DiskCache();
    //双缓存
    DoubleCache mDoubleCache = new DoubleCache();
    //使用双缓
    boolean isUseDoubleCache = false;
    //是否使用SD卡缓存
    boolean isUseDiskCache = false;

    //线程池数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());



    public void displayImage(final String url, final ImageView imageView) {
        //判断使用哪种缓存
        Bitmap bitmap = null;
        if (isUseDoubleCache){
            bitmap = mDoubleCache.get(url);
        } else if(isUseDiskCache){
            mDiskCache.get(url);
        } else {
            mImageCache.get(url);
        }
        if (bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(url, bitmap);
            }
        });
    }

    public Bitmap downloadImage(String ImageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(ImageUrl);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (Exception e) {

        }
        return bitmap;
    }

    public void steUseDiskCache(boolean useDiskCache){
        isUseDiskCache = useDiskCache;
    }

    public void setUseDoubleCache(boolean useDiskCache){
        isUseDiskCache = useDiskCache;
    }

}
