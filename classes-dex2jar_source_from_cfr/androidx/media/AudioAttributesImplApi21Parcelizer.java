/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.os.Parcelable
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.media.b;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public final class AudioAttributesImplApi21Parcelizer {
    public static b read(a a2) {
        b b2 = new b();
        b2.a = a2.b(b2.a, 1);
        b2.b = a2.b(b2.b, 2);
        return b2;
    }

    public static void write(b b2, a a2) {
        a2.a(false, false);
        a2.a((Parcelable)b2.a, 1);
        a2.a(b2.b, 2);
    }
}

