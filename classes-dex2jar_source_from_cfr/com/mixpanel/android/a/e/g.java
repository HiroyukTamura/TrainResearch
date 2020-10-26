/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.e;

import com.mixpanel.android.a.e.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
implements c {
    private byte[] a;
    private TreeMap<String, String> b = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    @Override
    public void a(String string2, String string3) {
        this.b.put(string2, string3);
    }

    @Override
    public void a(byte[] arrby) {
        this.a = arrby;
    }

    @Override
    public String b(String string2) {
        String string3;
        string2 = string3 = this.b.get(string2);
        if (string3 == null) {
            string2 = "";
        }
        return string2;
    }

    @Override
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override
    public boolean c(String string2) {
        return this.b.containsKey(string2);
    }

    @Override
    public byte[] c() {
        return this.a;
    }
}

