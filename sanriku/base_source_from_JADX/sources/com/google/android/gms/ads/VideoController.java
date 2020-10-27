package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzzf;

public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @Nullable
    private zzxl zzacw;
    @Nullable
    private VideoLifecycleCallbacks zzacx;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = this.zzacw.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return 0;
            }
            try {
                int playbackState = this.zzacw.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return 0.0f;
            }
            try {
                float currentTime = this.zzacw.getCurrentTime();
                return currentTime;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return 0.0f;
            }
            try {
                float duration = this.zzacw.getDuration();
                return duration;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzacx;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzacw != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = this.zzacw.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = this.zzacw.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzacw == null) {
                return true;
            }
            try {
                boolean isMuted = this.zzacw.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzacw != null) {
                try {
                    this.zzacw.mute(z);
                } catch (RemoteException e) {
                    zzazw.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzacw != null) {
                try {
                    this.zzacw.pause();
                } catch (RemoteException e) {
                    zzazw.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzacw != null) {
                try {
                    this.zzacw.play();
                } catch (RemoteException e) {
                    zzazw.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzacx = videoLifecycleCallbacks;
            if (this.zzacw != null) {
                try {
                    this.zzacw.zza(new zzzf(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzazw.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzacw != null) {
                try {
                    this.zzacw.stop();
                } catch (RemoteException e) {
                    zzazw.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzxl zzxl) {
        synchronized (this.lock) {
            this.zzacw = zzxl;
            if (this.zzacx != null) {
                setVideoLifecycleCallbacks(this.zzacx);
            }
        }
    }

    public final zzxl zzdu() {
        zzxl zzxl;
        synchronized (this.lock) {
            zzxl = this.zzacw;
        }
        return zzxl;
    }
}
