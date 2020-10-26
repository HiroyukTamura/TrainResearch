/*
 * Decompiled with CFR 0.139.
 */
package a.b;

public final class f {
    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static <T> T a(T t2, String string2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string2);
    }

    public static <T> T a(T object, String string2, Object object2) {
        if (object == null) {
            if (string2.contains("%s")) {
                if (string2.indexOf("%s") == string2.lastIndexOf("%s")) {
                    object = object2 instanceof Class ? ((Class)object2).getCanonicalName() : String.valueOf(object2);
                    throw new NullPointerException(string2.replace("%s", (CharSequence)object));
                }
                throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
            }
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        }
        return object;
    }
}

