/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class y {
    private final HashMap<String, v> a = new HashMap();

    final v a(String string2) {
        return this.a.get(string2);
    }

    public final void a() {
        Iterator<v> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
        this.a.clear();
    }

    final void a(String object, v v2) {
        if ((object = this.a.put((String)object, v2)) != null) {
            ((v)object).a();
        }
    }
}

