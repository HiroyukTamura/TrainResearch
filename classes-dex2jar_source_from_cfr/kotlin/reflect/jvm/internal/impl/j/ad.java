/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;

public abstract class ad
extends az {
    public ad() {
        super(null);
    }

    public abstract ad a(boolean var1);

    public abstract ad c(h var1);

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        for (Object object : this.x().c()) {
            c c2 = object.c();
            object = object.d();
            n.a(charSequence, new String[]{"[", kotlin.reflect.jvm.internal.impl.g.c.h.a(c2, (e)((Object)object)), "] "});
        }
        charSequence.append(this.g());
        if (!this.a().isEmpty()) {
            m.a(this.a(), charSequence, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (this.c()) {
            charSequence.append("?");
        }
        charSequence = charSequence.toString();
        j.a((Object)charSequence, "StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }
}

