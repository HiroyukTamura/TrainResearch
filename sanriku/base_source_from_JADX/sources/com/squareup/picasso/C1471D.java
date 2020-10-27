package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.C1513u;

/* renamed from: com.squareup.picasso.D */
public interface C1471D {
    void onBitmapFailed(Exception exc, Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, C1513u.C1519e eVar);

    void onPrepareLoad(Drawable drawable);
}
