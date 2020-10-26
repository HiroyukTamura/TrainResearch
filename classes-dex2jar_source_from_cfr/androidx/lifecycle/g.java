/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.i;

public abstract class g {
    public abstract b a();

    public abstract void a(i var1);

    public abstract void b(i var1);

    public static enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        
    }

    public static enum b {
        a,
        b,
        c,
        d,
        e;
        

        public boolean a(b b2) {
            return this.compareTo(b2) >= 0;
        }
    }

}

