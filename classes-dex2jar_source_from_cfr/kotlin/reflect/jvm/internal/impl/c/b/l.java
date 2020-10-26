/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.i.n;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.c.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.k;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.h.d.c;
import kotlin.y;

final class l
implements k<j> {
    public static final l a = new l();

    private l() {
    }

    @Override
    public /* synthetic */ Object a() {
        return this.b();
    }

    @Override
    public /* synthetic */ Object a(String string2) {
        return this.c(string2);
    }

    @Override
    public j a(j object) {
        kotlin.e.b.j.b(object, "possiblyPrimitiveType");
        j j2 = object;
        if (object instanceof j.c) {
            j.c c2 = (j.c)object;
            j2 = object;
            if (c2.a() != null) {
                object = kotlin.reflect.jvm.internal.impl.h.d.b.a(c2.a().d());
                kotlin.e.b.j.a(object, "JvmClassName.byFqNameWit\u2026mitiveType.wrapperFqName)");
                object = ((kotlin.reflect.jvm.internal.impl.h.d.b)object).c();
                kotlin.e.b.j.a(object, "JvmClassName.byFqNameWit\u2026apperFqName).internalName");
                j2 = this.d((String)object);
            }
        }
        return j2;
    }

    @Override
    public /* synthetic */ Object b(String string2) {
        return this.d(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public String b(j object) {
        CharSequence charSequence;
        kotlin.e.b.j.b(object, "type");
        if (object instanceof j.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            charSequence = this.b(((j.a)object).a());
            object = stringBuilder;
        } else {
            if (object instanceof j.c) {
                if ((object = ((j.c)object).a()) != null && (object = ((c)((Object)object)).c()) != null) {
                    return object;
                }
                return "V";
            }
            if (!(object instanceof j.b)) {
                throw new m();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("L");
            ((StringBuilder)charSequence).append(((j.b)object).a());
            String string2 = ";";
            object = charSequence;
            charSequence = string2;
        }
        ((StringBuilder)object).append((String)charSequence);
        return ((StringBuilder)object).toString();
    }

    public j b() {
        return this.d("java/lang/Class");
    }

    public j c(String object) {
        char c2;
        int n2;
        int n3;
        Object object22;
        block10 : {
            kotlin.e.b.j.b(object, "representation");
            n3 = ((String)object).length();
            n2 = 0;
            n3 = n3 > 0 ? 1 : 0;
            if (y.a && n3 == 0) {
                throw (Throwable)((Object)new AssertionError((Object)"empty string as JvmType"));
            }
            c2 = ((String)object).charAt(0);
            for (Object object22 : c.values()) {
                boolean bl2 = object22.c().charAt(0) == c2;
                if (!bl2) {
                    continue;
                }
                break block10;
            }
            object22 = null;
        }
        if (object22 != null) {
            return new j.c((c)((Object)object22));
        }
        if (c2 != 'V') {
            if (c2 != '[') {
                n3 = n2;
                if (c2 == 'L') {
                    n3 = n2;
                    if (n.b((CharSequence)object, ';', false, 2, null)) {
                        n3 = 1;
                    }
                }
                if (y.a && n3 == 0) {
                    object22 = new StringBuilder();
                    ((StringBuilder)object22).append("Type that is not primitive nor array should be Object, but '");
                    ((StringBuilder)object22).append((String)object);
                    ((StringBuilder)object22).append("' was found");
                    throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object22).toString()));
                }
                object = ((String)object).substring(1, ((String)object).length() - 1);
                kotlin.e.b.j.a(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                object = new j.b((String)object);
            } else {
                object = ((String)object).substring(1);
                kotlin.e.b.j.a(object, "(this as java.lang.String).substring(startIndex)");
                object = new j.a(this.c((String)object));
            }
            return (j)object;
        }
        return new j.c(null);
    }

    public j.b d(String string2) {
        kotlin.e.b.j.b(string2, "internalName");
        return new j.b(string2);
    }
}

