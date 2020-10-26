/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.mixpanel.android.c;

import android.content.Context;
import com.mixpanel.android.c.h;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public interface i {
    public void a();

    public boolean a(Context var1, h var2);

    public byte[] a(String var1, Map<String, Object> var2, SSLSocketFactory var3);

    public static class a
    extends Exception {
        private final int a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public a(String string2, String string3) {
            int n2;
            block2 : {
                super(string2);
                try {
                    n2 = Integer.parseInt(string3);
                    break block2;
                }
                catch (NumberFormatException numberFormatException) {}
                n2 = 0;
            }
            this.a = n2;
        }

        public int a() {
            return this.a;
        }
    }

}

