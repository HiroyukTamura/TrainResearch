/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class s {
    private final String[] a;

    s(a a2) {
        this.a = a2.a.toArray(new String[a2.a.size()]);
    }

    private s(String[] arrstring) {
        this.a = arrstring;
    }

    public static /* varargs */ s a(String ... object) {
        if (object != null) {
            if (((String[])object).length % 2 == 0) {
                int n2;
                Object object2 = (String[])object.clone();
                for (n2 = 0; n2 < ((String[])object2).length; ++n2) {
                    if (object2[n2] != null) {
                        object2[n2] = object2[n2].trim();
                        continue;
                    }
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                for (n2 = 0; n2 < ((String[])object2).length; n2 += 2) {
                    object = object2[n2];
                    String string2 = object2[n2 + 1];
                    if (((String)object).length() != 0 && ((String)object).indexOf(0) == -1 && string2.indexOf(0) == -1) {
                        continue;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Unexpected header: ");
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(": ");
                    ((StringBuilder)object2).append(string2);
                    throw new IllegalArgumentException(((StringBuilder)object2).toString());
                }
                return new s((String[])object2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    private static String a(String[] arrstring, String string2) {
        for (int i2 = arrstring.length - 2; i2 >= 0; i2 -= 2) {
            if (!string2.equalsIgnoreCase(arrstring[i2])) continue;
            return arrstring[i2 + 1];
        }
        return null;
    }

    public int a() {
        return this.a.length / 2;
    }

    public String a(int n2) {
        return this.a[n2 * 2];
    }

    @Nullable
    public String a(String string2) {
        return s.a(this.a, string2);
    }

    public a b() {
        a a2 = new a();
        Collections.addAll(a2.a, this.a);
        return a2;
    }

    public String b(int n2) {
        return this.a[n2 * 2 + 1];
    }

    public List<String> b(String string2) {
        int n2 = this.a();
        ArrayList<String> arrayList = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            ArrayList<String> arrayList2 = arrayList;
            if (string2.equalsIgnoreCase(this.a(i2))) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<String>(2);
                }
                arrayList2.add(this.b(i2));
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof s && Arrays.equals(((s)object).a, this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(this.a(i2));
            stringBuilder.append(": ");
            stringBuilder.append(this.b(i2));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static final class a {
        final List<String> a = new ArrayList<String>(20);

        private void d(String string2, String charSequence) {
            if (string2 != null) {
                if (!string2.isEmpty()) {
                    char c2;
                    int n2;
                    int n3 = string2.length();
                    for (n2 = 0; n2 < n3; ++n2) {
                        c2 = string2.charAt(n2);
                        if (c2 > ' ' && c2 < '') {
                            continue;
                        }
                        throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", new Object[]{(int)c2, n2, string2}));
                    }
                    if (charSequence != null) {
                        n3 = ((String)charSequence).length();
                        for (n2 = 0; n2 < n3; ++n2) {
                            c2 = ((String)charSequence).charAt(n2);
                            if ((c2 > '\u001f' || c2 == '\t') && c2 < '') {
                                continue;
                            }
                            throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", new Object[]{(int)c2, n2, string2, charSequence}));
                        }
                        return;
                    }
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("value for name ");
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append(" == null");
                    throw new NullPointerException(((StringBuilder)charSequence).toString());
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }

        a a(String string2) {
            int n2 = string2.indexOf(":", 1);
            if (n2 != -1) {
                return this.b(string2.substring(0, n2), string2.substring(n2 + 1));
            }
            if (string2.startsWith(":")) {
                return this.b("", string2.substring(1));
            }
            return this.b("", string2);
        }

        public a a(String string2, String string3) {
            this.d(string2, string3);
            return this.b(string2, string3);
        }

        public s a() {
            return new s(this);
        }

        public a b(String string2) {
            int n2 = 0;
            while (n2 < this.a.size()) {
                int n3 = n2;
                if (string2.equalsIgnoreCase(this.a.get(n2))) {
                    this.a.remove(n2);
                    this.a.remove(n2);
                    n3 = n2 - 2;
                }
                n2 = n3 + 2;
            }
            return this;
        }

        a b(String string2, String string3) {
            this.a.add(string2);
            this.a.add(string3.trim());
            return this;
        }

        public a c(String string2, String string3) {
            this.d(string2, string3);
            this.b(string2);
            this.b(string2, string3);
            return this;
        }
    }

}

