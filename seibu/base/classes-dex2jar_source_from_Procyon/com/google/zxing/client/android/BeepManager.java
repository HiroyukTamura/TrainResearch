// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.android;

import android.annotation.SuppressLint;
import android.os.Vibrator;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
import android.util.Log;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Context;

public final class BeepManager
{
    private static final float BEEP_VOLUME = 0.1f;
    private static final String TAG;
    private static final long VIBRATE_DURATION = 200L;
    private boolean beepEnabled;
    private final Context context;
    private boolean vibrateEnabled;
    
    static {
        TAG = BeepManager.class.getSimpleName();
    }
    
    public BeepManager(final Activity activity) {
        this.beepEnabled = true;
        this.vibrateEnabled = false;
        activity.setVolumeControlStream(3);
        this.context = activity.getApplicationContext();
    }
    
    public boolean isBeepEnabled() {
        return this.beepEnabled;
    }
    
    public boolean isVibrateEnabled() {
        return this.vibrateEnabled;
    }
    
    public MediaPlayer playBeepSound() {
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener((MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public void onCompletion(final MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
        mediaPlayer.setOnErrorListener((MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
            public boolean onError(final MediaPlayer mediaPlayer, final int i, final int j) {
                Log.w(BeepManager.TAG, "Failed to beep " + i + ", " + j);
                mediaPlayer.stop();
                mediaPlayer.release();
                return true;
            }
        });
        try {
            final AssetFileDescriptor openRawResourceFd = this.context.getResources().openRawResourceFd(R.raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            }
            finally {
                openRawResourceFd.close();
            }
        }
        catch (IOException ex) {
            Log.w(BeepManager.TAG, (Throwable)ex);
            mediaPlayer.release();
            return null;
        }
    }
    
    @SuppressLint({ "MissingPermission" })
    public void playBeepSoundAndVibrate() {
        synchronized (this) {
            if (this.beepEnabled) {
                this.playBeepSound();
            }
            if (this.vibrateEnabled) {
                final Vibrator vibrator = (Vibrator)this.context.getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(200L);
                }
            }
        }
    }
    
    public void setBeepEnabled(final boolean beepEnabled) {
        this.beepEnabled = beepEnabled;
    }
    
    public void setVibrateEnabled(final boolean vibrateEnabled) {
        this.vibrateEnabled = vibrateEnabled;
    }
}
