/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.MediaMetadata
 *  android.os.Parcel
 */
package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

class c {
    public static void a(Object object, Parcel parcel, int n2) {
        ((MediaMetadata)object).writeToParcel(parcel, n2);
    }
}

