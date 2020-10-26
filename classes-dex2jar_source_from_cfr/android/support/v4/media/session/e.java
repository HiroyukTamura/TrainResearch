/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.session.PlaybackState
 *  android.media.session.PlaybackState$CustomAction
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class e {
    public static int a(Object object) {
        return ((PlaybackState)object).getState();
    }

    public static long b(Object object) {
        return ((PlaybackState)object).getPosition();
    }

    public static long c(Object object) {
        return ((PlaybackState)object).getBufferedPosition();
    }

    public static float d(Object object) {
        return ((PlaybackState)object).getPlaybackSpeed();
    }

    public static long e(Object object) {
        return ((PlaybackState)object).getActions();
    }

    public static CharSequence f(Object object) {
        return ((PlaybackState)object).getErrorMessage();
    }

    public static long g(Object object) {
        return ((PlaybackState)object).getLastPositionUpdateTime();
    }

    public static List<Object> h(Object object) {
        return ((PlaybackState)object).getCustomActions();
    }

    public static long i(Object object) {
        return ((PlaybackState)object).getActiveQueueItemId();
    }

    static final class a {
        public static String a(Object object) {
            return ((PlaybackState.CustomAction)object).getAction();
        }

        public static CharSequence b(Object object) {
            return ((PlaybackState.CustomAction)object).getName();
        }

        public static int c(Object object) {
            return ((PlaybackState.CustomAction)object).getIcon();
        }

        public static Bundle d(Object object) {
            return ((PlaybackState.CustomAction)object).getExtras();
        }
    }

}

