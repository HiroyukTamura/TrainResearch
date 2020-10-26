/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.media.MediaDescription$Builder
 *  android.net.Uri
 */
package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class b {
    public static Uri a(Object object) {
        return ((MediaDescription)object).getMediaUri();
    }

    static class a {
        public static void a(Object object, Uri uri) {
            ((MediaDescription.Builder)object).setMediaUri(uri);
        }
    }

}

