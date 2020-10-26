/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.os.Parcelable
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class IconCompatParcelizer {
    public static IconCompat read(a a2) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = a2.b(iconCompat.a, 1);
        iconCompat.c = a2.b(iconCompat.c, 2);
        iconCompat.d = a2.b(iconCompat.d, 3);
        iconCompat.e = a2.b(iconCompat.e, 4);
        iconCompat.f = a2.b(iconCompat.f, 5);
        iconCompat.g = a2.b(iconCompat.g, 6);
        iconCompat.j = a2.b(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a a2) {
        a2.a(true, true);
        iconCompat.a(a2.a());
        a2.a(iconCompat.a, 1);
        a2.a(iconCompat.c, 2);
        a2.a(iconCompat.d, 3);
        a2.a(iconCompat.e, 4);
        a2.a(iconCompat.f, 5);
        a2.a((Parcelable)iconCompat.g, 6);
        a2.a(iconCompat.j, 7);
    }
}

