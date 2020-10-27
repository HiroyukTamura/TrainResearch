package com.google.android.gms.ads.formats;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;

public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbkw;
    private final int zzbkx;
    private final int zzbky;
    private final boolean zzbkz;
    private final int zzbla;
    private final VideoOptions zzblb;
    private final boolean zzblc;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbkw = false;
        /* access modifiers changed from: private */
        public int zzbkx = -1;
        /* access modifiers changed from: private */
        public int zzbky = 0;
        /* access modifiers changed from: private */
        public boolean zzbkz = false;
        /* access modifiers changed from: private */
        public int zzbla = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzblb;
        /* access modifiers changed from: private */
        public boolean zzblc = false;

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzbla = i;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbkx = i;
            return this;
        }

        public final Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzbky = i;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzblc = z;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbkz = z;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbkw = z;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzblb = videoOptions;
            return this;
        }
    }

    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbkw = builder.zzbkw;
        this.zzbkx = builder.zzbkx;
        this.zzbky = builder.zzbky;
        this.zzbkz = builder.zzbkz;
        this.zzbla = builder.zzbla;
        this.zzblb = builder.zzblb;
        this.zzblc = builder.zzblc;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbla;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbkx;
    }

    public final int getMediaAspectRatio() {
        return this.zzbky;
    }

    @Nullable
    public final VideoOptions getVideoOptions() {
        return this.zzblb;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbkz;
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbkw;
    }

    public final boolean zzjr() {
        return this.zzblc;
    }
}
