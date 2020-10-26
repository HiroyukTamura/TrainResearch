/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.media.session.MediaSession
 *  android.media.session.MediaSession$QueueItem
 */
package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;

class d {

    static class a {
        public static Object a(Object object) {
            return ((MediaSession.QueueItem)object).getDescription();
        }

        public static long b(Object object) {
            return ((MediaSession.QueueItem)object).getQueueId();
        }
    }

}

