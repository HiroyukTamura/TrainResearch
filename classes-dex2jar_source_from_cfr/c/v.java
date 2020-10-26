/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class v {
    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;
    private final String d;
    private final String e;
    @Nullable
    private final String f;

    private v(String string2, String string3, String string4, @Nullable String string5) {
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = string5;
    }

    @Nullable
    public static v a(String string2) {
        Object object = a.matcher(string2);
        if (!((Matcher)object).lookingAt()) {
            return null;
        }
        String string3 = ((Matcher)object).group(1).toLowerCase(Locale.US);
        String string4 = ((Matcher)object).group(2).toLowerCase(Locale.US);
        Matcher matcher = b.matcher(string2);
        int n2 = ((Matcher)object).end();
        Matcher matcher2 = null;
        while (n2 < string2.length()) {
            matcher.region(n2, string2.length());
            if (!matcher.lookingAt()) {
                return null;
            }
            String string5 = matcher.group(1);
            object = matcher2;
            if (string5 != null) {
                if (!string5.equalsIgnoreCase("charset")) {
                    object = matcher2;
                } else {
                    string5 = matcher.group(2);
                    if (string5 != null) {
                        object = string5;
                        if (string5.startsWith("'")) {
                            object = string5;
                            if (string5.endsWith("'")) {
                                object = string5;
                                if (string5.length() > 2) {
                                    object = string5.substring(1, string5.length() - 1);
                                }
                            }
                        }
                    } else {
                        object = matcher.group(3);
                    }
                    if (matcher2 != null && !((String)object).equalsIgnoreCase((String)((Object)matcher2))) {
                        return null;
                    }
                }
            }
            n2 = matcher.end();
            matcher2 = object;
        }
        return new v(string2, string3, string4, (String)((Object)matcher2));
    }

    public String a() {
        return this.d;
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        Charset charset2 = charset;
        try {
            if (this.f != null) {
                charset2 = Charset.forName(this.f);
            }
            return charset2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return charset;
        }
    }

    @Nullable
    public Charset b() {
        return this.a(null);
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof v && ((v)object).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return this.c;
    }
}

