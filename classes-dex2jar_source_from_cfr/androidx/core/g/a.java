/*
 * Decompiled with CFR 0.139.
 */
package androidx.core.g;

public class a {
    /*
     * Enabled aggressive block sorting
     */
    public static void a(Object object, StringBuilder stringBuilder) {
        block5 : {
            String string2;
            block7 : {
                String string3;
                block6 : {
                    block4 : {
                        if (object != null) break block4;
                        object = "null";
                        break block5;
                    }
                    string3 = object.getClass().getSimpleName();
                    if (string3 == null) break block6;
                    string2 = string3;
                    if (string3.length() > 0) break block7;
                }
                string3 = object.getClass().getName();
                int n2 = string3.lastIndexOf(46);
                string2 = string3;
                if (n2 > 0) {
                    string2 = string3.substring(n2 + 1);
                }
            }
            stringBuilder.append(string2);
            stringBuilder.append('{');
            object = Integer.toHexString(System.identityHashCode(object));
        }
        stringBuilder.append((String)object);
    }
}

