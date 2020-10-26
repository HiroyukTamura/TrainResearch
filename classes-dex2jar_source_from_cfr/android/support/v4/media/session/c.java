/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.MediaMetadata
 *  android.media.session.MediaController
 *  android.media.session.MediaController$Callback
 *  android.media.session.MediaController$PlaybackInfo
 *  android.media.session.MediaSession
 *  android.media.session.MediaSession$QueueItem
 *  android.media.session.PlaybackState
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

class c {
    public static Object a(a a2) {
        return new b<a>(a2);
    }

    public static interface a {
        public void a();

        public void a(int var1, int var2, int var3, int var4, int var5);

        public void a(Bundle var1);

        public void a(CharSequence var1);

        public void a(Object var1);

        public void a(String var1, Bundle var2);

        public void a(List<?> var1);

        public void b(Object var1);
    }

    static class b<T extends a>
    extends MediaController.Callback {
        protected final T a;

        public b(T t2) {
            this.a = t2;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.a.a(playbackInfo.getPlaybackType(), c.b((Object)playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.a.a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.a.b((Object)mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.a.a((Object)playbackState);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.a.a(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.a.a(charSequence);
        }

        public void onSessionDestroyed() {
            this.a.a();
        }

        public void onSessionEvent(String string2, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.a.a(string2, bundle);
        }
    }

    public static class c {
        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                default: {
                    return 3;
                }
                case 13: {
                    return 1;
                }
                case 6: {
                    return 2;
                }
                case 5: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    return 5;
                }
                case 4: {
                    return 4;
                }
                case 3: {
                    return 8;
                }
                case 2: {
                    return 0;
                }
                case 1: 
                case 11: 
                case 12: 
                case 14: 
            }
            return 3;
        }

        public static AudioAttributes a(Object object) {
            return ((MediaController.PlaybackInfo)object).getAudioAttributes();
        }

        public static int b(Object object) {
            return c.a(c.a(object));
        }
    }

}

