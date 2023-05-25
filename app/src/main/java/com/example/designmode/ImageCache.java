package com.example.designmode;

import android.graphics.Bitmap;
import android.util.LruCache;

public interface ImageCache {

    public Bitmap get(String url);
    public void put(String url , Bitmap bitmap);
}

