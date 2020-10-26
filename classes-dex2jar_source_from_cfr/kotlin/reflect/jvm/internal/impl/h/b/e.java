/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import java.util.Arrays;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.m;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class e
extends m<Character> {
    public e(char c2) {
        super(Character.valueOf(c2));
    }

    private final String a(char c2) {
        String string2;
        switch (c2) {
            default: {
                string2 = this.b(c2) ? Character.toString(c2) : "?";
            }
            case '\r': {
                return "\\r";
            }
            case '\f': {
                return "\\f";
            }
            case '\n': {
                return "\\n";
            }
            case '\t': {
                return "\\t";
            }
            case '\b': {
                return "\\b";
            }
        }
        j.a((Object)string2, "if (isPrintableUnicode(c\u2026cter.toString(c) else \"?\"");
        return string2;
    }

    private final boolean b(char c2) {
        byte by2 = (byte)Character.getType(c2);
        return by2 != 0 && by2 != 13 && by2 != 14 && by2 != 15 && by2 != 16 && by2 != 18 && by2 != 19;
    }

    @Override
    public /* synthetic */ w a(y y2) {
        return this.b(y2);
    }

    public ad b(y y2) {
        j.b(y2, "module");
        return y2.a().getCharType();
    }

    @Override
    public String toString() {
        Object object = new Object[]{(int)((Character)this.a()).charValue(), this.a(((Character)this.a()).charValue())};
        object = String.format("\\u%04X ('%s')", Arrays.copyOf(object, ((Object[])object).length));
        j.a(object, "java.lang.String.format(this, *args)");
        return object;
    }
}

