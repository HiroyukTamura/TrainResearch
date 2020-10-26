/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.e.b;
import c.a.e.c;
import d.e;
import java.util.List;

public interface l {
    public static final l a = new l(){

        @Override
        public void a(int n2, b b2) {
        }

        @Override
        public boolean a(int n2, e e2, int n3, boolean bl2) {
            e2.i(n3);
            return true;
        }

        @Override
        public boolean a(int n2, List<c> list) {
            return true;
        }

        @Override
        public boolean a(int n2, List<c> list, boolean bl2) {
            return true;
        }
    };

    public void a(int var1, b var2);

    public boolean a(int var1, e var2, int var3, boolean var4);

    public boolean a(int var1, List<c> var2);

    public boolean a(int var1, List<c> var2, boolean var3);

}

