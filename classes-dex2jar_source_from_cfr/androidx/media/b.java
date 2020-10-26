/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.media.AudioAttributes
 */
package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.media.a;

@TargetApi(value=21)
class b
implements a {
    AudioAttributes a;
    int b = -1;

    b() {
    }

    public boolean equals(Object object) {
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return this.a.equals((Object)((b)object).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioAttributesCompat: audioattributes=");
        stringBuilder.append((Object)this.a);
        return stringBuilder.toString();
    }
}

