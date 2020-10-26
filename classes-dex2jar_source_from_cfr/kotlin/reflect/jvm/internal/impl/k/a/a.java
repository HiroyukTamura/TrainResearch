/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k.a;

import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.i.n;

public final class a {
    public static final String a(String string2) {
        j.b(string2, "$receiver");
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (bl2) {
            return string2;
        }
        char c2 = string2.charAt(0);
        if ('a' > c2) {
            return string2;
        }
        CharSequence charSequence = string2;
        if ('z' >= c2) {
            c2 = Character.toUpperCase(c2);
            string2 = string2.substring(1);
            j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(String.valueOf(c2));
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public static final String a(final String string2, final boolean bl2) {
        j.b(string2, "$receiver");
        Object object = new kotlin.e.a.b<Integer, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a(((Number)object).intValue());
            }

            @Override
            public final boolean a(int n2) {
                char c2 = string2.charAt(n2);
                if (bl2) {
                    return 'A' <= c2 && 'Z' >= c2;
                }
                return Character.isUpperCase(c2);
            }
        };
        CharSequence charSequence = string2;
        int n2 = charSequence.length() == 0 ? 1 : 0;
        Object object22 = string2;
        if (n2 == 0) {
            if (!object.a(0)) {
                return string2;
            }
            if (string2.length() != 1 && object.a(1)) {
                kotlin.e.a.b<String, String> b2;
                block6 : {
                    b2 = new kotlin.e.a.b<String, String>(){

                        @Override
                        public final String a(String string2) {
                            j.b(string2, "string");
                            if (bl2) {
                                return a.c(string2);
                            }
                            string2 = string2.toLowerCase();
                            j.a((Object)string2, "(this as java.lang.String).toLowerCase()");
                            return string2;
                        }
                    };
                    for (Object object22 : (Iterable)n.b(charSequence)) {
                        if (!(object.a(((Number)object22).intValue()) ^ true)) continue;
                        break block6;
                    }
                    object22 = null;
                }
                object22 = (Integer)object22;
                if (object22 != null) {
                    n2 = (Integer)object22 - 1;
                    object22 = new StringBuilder();
                    object = string2.substring(0, n2);
                    j.a(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    ((StringBuilder)object22).append(b2.a((String)object));
                    string2 = string2.substring(n2);
                    j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
                    ((StringBuilder)object22).append(string2);
                    return ((StringBuilder)object22).toString();
                }
                return b2.a(string2);
            }
            if (bl2) {
                return a.b(string2);
            }
            object22 = n.e(string2);
        }
        return object22;
    }

    public static final String b(String string2) {
        j.b(string2, "$receiver");
        boolean bl2 = ((CharSequence)string2).length() == 0;
        if (bl2) {
            return string2;
        }
        char c2 = string2.charAt(0);
        if ('A' > c2) {
            return string2;
        }
        CharSequence charSequence = string2;
        if ('Z' >= c2) {
            c2 = Character.toLowerCase(c2);
            string2 = string2.substring(1);
            j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(String.valueOf(c2));
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public static final String c(String string2) {
        j.b(string2, "$receiver");
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2;
            char c3 = string2.charAt(i2);
            if ('A' > c3) {
                c2 = c3;
            } else {
                c2 = c3;
                if ('Z' >= c3) {
                    c2 = Character.toLowerCase(c3);
                }
            }
            stringBuilder.append(c2);
        }
        string2 = stringBuilder.toString();
        j.a((Object)string2, "builder.toString()");
        return string2;
    }

}

