/*
 * Decompiled with CFR 0.139.
 */
package androidx.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.a;
import java.util.Arrays;

class c
implements a {
    int a = 0;
    int b = 0;
    int c = 0;
    int d = -1;

    c() {
    }

    public int a() {
        if (this.d != -1) {
            return this.d;
        }
        return AudioAttributesCompat.a(false, this.c, this.a);
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        int n2;
        int n3 = this.c;
        int n4 = this.a();
        if (n4 == 6) {
            n2 = n3 | 4;
        } else {
            n2 = n3;
            if (n4 == 7) {
                n2 = n3 | 1;
            }
        }
        return n2 & 273;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof c;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = (c)object;
        bl2 = bl3;
        if (this.b == ((c)object).b()) {
            bl2 = bl3;
            if (this.c == ((c)object).d()) {
                bl2 = bl3;
                if (this.a == ((c)object).c()) {
                    bl2 = bl3;
                    if (this.d == ((c)object).d) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.a, this.d});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            stringBuilder.append(" stream=");
            stringBuilder.append(this.d);
            stringBuilder.append(" derived");
        }
        stringBuilder.append(" usage=");
        stringBuilder.append(AudioAttributesCompat.a(this.a));
        stringBuilder.append(" content=");
        stringBuilder.append(this.b);
        stringBuilder.append(" flags=0x");
        stringBuilder.append(Integer.toHexString(this.c).toUpperCase());
        return stringBuilder.toString();
    }
}

