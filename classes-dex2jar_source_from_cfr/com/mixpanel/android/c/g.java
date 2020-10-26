/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Pair
 */
package com.mixpanel.android.c;

import android.os.Build;
import android.util.Pair;

public class g<F, S>
extends Pair<F, S> {
    public g(F f2, S s2) {
        super(f2, s2);
    }

    public boolean equals(Object object) {
        boolean bl2;
        block6 : {
            block7 : {
                boolean bl3;
                block5 : {
                    if (Build.VERSION.SDK_INT > 16) {
                        return super.equals(object);
                    }
                    bl2 = object instanceof Pair;
                    bl3 = false;
                    if (!bl2) {
                        return false;
                    }
                    object = (Pair)object;
                    if (((Pair)object).first == this.first) break block5;
                    bl2 = bl3;
                    if (((Pair)object).first == null) break block6;
                    bl2 = bl3;
                    if (!((Pair)object).first.equals(this.first)) break block6;
                }
                if (((Pair)object).second == this.second) break block7;
                bl2 = bl3;
                if (((Pair)object).second == null) break block6;
                bl2 = bl3;
                if (!((Pair)object).second.equals(this.second)) break block6;
            }
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        if (Build.VERSION.SDK_INT > 16) {
            return super.hashCode();
        }
        Object object = this.first;
        int n2 = 0;
        int n3 = object == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            n2 = this.second.hashCode();
        }
        return n3 ^ n2;
    }
}

