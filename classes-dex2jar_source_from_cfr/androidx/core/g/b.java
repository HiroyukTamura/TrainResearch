/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.g;

import android.util.Log;
import java.io.Writer;

public class b
extends Writer {
    private final String a;
    private StringBuilder b = new StringBuilder(128);

    public b(String string2) {
        this.a = string2;
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d((String)this.a, (String)this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }

    @Override
    public void close() {
        this.a();
    }

    @Override
    public void flush() {
        this.a();
    }

    @Override
    public void write(char[] arrc, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = arrc[n2 + i2];
            if (c2 == '\n') {
                this.a();
                continue;
            }
            this.b.append(c2);
        }
    }
}

