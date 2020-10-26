/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.c;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.c.a;

public final class MediaMetadataCompat
implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    static final a<String, Integer> a;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;
    final Bundle b;
    private Object f;

    static {
        a = new a();
        a.put("android.media.metadata.TITLE", 1);
        a.put("android.media.metadata.ARTIST", 1);
        a.put("android.media.metadata.DURATION", 0);
        a.put("android.media.metadata.ALBUM", 1);
        a.put("android.media.metadata.AUTHOR", 1);
        a.put("android.media.metadata.WRITER", 1);
        a.put("android.media.metadata.COMPOSER", 1);
        a.put("android.media.metadata.COMPILATION", 1);
        a.put("android.media.metadata.DATE", 1);
        a.put("android.media.metadata.YEAR", 0);
        a.put("android.media.metadata.GENRE", 1);
        a.put("android.media.metadata.TRACK_NUMBER", 0);
        a.put("android.media.metadata.NUM_TRACKS", 0);
        a.put("android.media.metadata.DISC_NUMBER", 0);
        a.put("android.media.metadata.ALBUM_ARTIST", 1);
        a.put("android.media.metadata.ART", 2);
        a.put("android.media.metadata.ART_URI", 1);
        a.put("android.media.metadata.ALBUM_ART", 2);
        a.put("android.media.metadata.ALBUM_ART_URI", 1);
        a.put("android.media.metadata.USER_RATING", 3);
        a.put("android.media.metadata.RATING", 3);
        a.put("android.media.metadata.DISPLAY_TITLE", 1);
        a.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        a.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        a.put("android.media.metadata.DISPLAY_ICON", 2);
        a.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        a.put("android.media.metadata.MEDIA_ID", 1);
        a.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        a.put("android.media.metadata.MEDIA_URI", 1);
        a.put("android.media.metadata.ADVERTISEMENT", 0);
        a.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>(){

            public MediaMetadataCompat a(Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }

            public MediaMetadataCompat[] a(int n2) {
                return new MediaMetadataCompat[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
    }

    MediaMetadataCompat(Parcel parcel) {
        this.b = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat a(Object object) {
        if (object != null && Build.VERSION.SDK_INT >= 21) {
            Parcel parcel = Parcel.obtain();
            c.a(object, parcel, 0);
            parcel.setDataPosition(0);
            MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
            parcel.recycle();
            mediaMetadataCompat.f = object;
            return mediaMetadataCompat;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeBundle(this.b);
    }

}

