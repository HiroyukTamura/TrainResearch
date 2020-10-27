package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

public interface MediaContent {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    @Nullable
    Drawable getMainImage();

    VideoController getVideoController();

    boolean hasVideoContent();

    void setMainImage(@Nullable Drawable drawable);
}
