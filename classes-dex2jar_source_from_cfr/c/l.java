/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.a.c.d;
import c.a.h.a;
import c.s;
import c.t;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class l {
    private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private l(String string2, String string3, long l2, String string4, String string5, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.e = string2;
        this.f = string3;
        this.g = l2;
        this.h = string4;
        this.i = string5;
        this.j = bl2;
        this.k = bl3;
        this.m = bl4;
        this.l = bl5;
    }

    private static int a(String string2, int n2, int n3, boolean bl2) {
        while (n2 < n3) {
            char c2 = string2.charAt(n2);
            c2 = !(c2 < ' ' && c2 != '\t' || c2 >= '' || c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == ':') ? (char)'\u0000' : '\u0001';
            if (c2 == (bl2 ^ true)) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    private static long a(String string2) {
        try {
            long l2 = Long.parseLong(string2);
            if (l2 <= 0L) {
                return Long.MIN_VALUE;
            }
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            if (string2.matches("-?\\d+")) {
                if (string2.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return Long.MAX_VALUE;
            }
            throw numberFormatException;
        }
    }

    private static long a(String object, int n2, int n3) {
        int n4 = l.a((String)object, n2, n3, false);
        Matcher matcher = d.matcher((CharSequence)object);
        int n5 = -1;
        n2 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        while (n4 < n3) {
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15 = l.a((String)object, n4 + 1, n3, true);
            matcher.region(n4, n15);
            if (n5 == -1 && matcher.usePattern(d).matches()) {
                n4 = Integer.parseInt(matcher.group(1));
                n10 = Integer.parseInt(matcher.group(2));
                n11 = Integer.parseInt(matcher.group(3));
                n13 = n2;
                n12 = n6;
                n14 = n7;
            } else if (n6 == -1 && matcher.usePattern(c).matches()) {
                n12 = Integer.parseInt(matcher.group(1));
                n4 = n5;
                n13 = n2;
                n14 = n7;
                n10 = n8;
                n11 = n9;
            } else if (n7 == -1 && matcher.usePattern(b).matches()) {
                String string2 = matcher.group(1).toLowerCase(Locale.US);
                n14 = b.pattern().indexOf(string2) / 4;
                n4 = n5;
                n13 = n2;
                n12 = n6;
                n10 = n8;
                n11 = n9;
            } else {
                n4 = n5;
                n13 = n2;
                n12 = n6;
                n14 = n7;
                n10 = n8;
                n11 = n9;
                if (n2 == -1) {
                    n4 = n5;
                    n13 = n2;
                    n12 = n6;
                    n14 = n7;
                    n10 = n8;
                    n11 = n9;
                    if (matcher.usePattern(a).matches()) {
                        n13 = Integer.parseInt(matcher.group(1));
                        n11 = n9;
                        n10 = n8;
                        n14 = n7;
                        n12 = n6;
                        n4 = n5;
                    }
                }
            }
            n15 = l.a((String)object, n15 + 1, n3, false);
            n5 = n4;
            n2 = n13;
            n6 = n12;
            n7 = n14;
            n8 = n10;
            n9 = n11;
            n4 = n15;
        }
        n3 = n2;
        if (n2 >= 70) {
            n3 = n2;
            if (n2 <= 99) {
                n3 = n2 + 1900;
            }
        }
        n2 = n3;
        if (n3 >= 0) {
            n2 = n3;
            if (n3 <= 69) {
                n2 = n3 + 2000;
            }
        }
        if (n2 >= 1601) {
            if (n7 != -1) {
                if (n6 >= 1 && n6 <= 31) {
                    if (n5 >= 0 && n5 <= 23) {
                        if (n8 >= 0 && n8 <= 59) {
                            if (n9 >= 0 && n9 <= 59) {
                                object = new GregorianCalendar(c.g);
                                ((Calendar)object).setLenient(false);
                                ((Calendar)object).set(1, n2);
                                ((Calendar)object).set(2, n7 - 1);
                                ((Calendar)object).set(5, n6);
                                ((Calendar)object).set(11, n5);
                                ((Calendar)object).set(12, n8);
                                ((Calendar)object).set(13, n9);
                                ((Calendar)object).set(14, 0);
                                return ((Calendar)object).getTimeInMillis();
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Nullable
    static l a(long var0, t var2_1, String var3_2) {
        var5_3 = var3_2.length();
        var4_4 = c.a(var3_2, 0, var5_3, ';');
        var6_5 = c.a(var3_2, 0, var4_4, '=');
        if (var6_5 == var4_4) {
            return null;
        }
        var27_6 = c.c(var3_2, 0, var6_5);
        if (var27_6.isEmpty() != false) return null;
        if (c.b(var27_6) != -1) {
            return null;
        }
        var28_7 = c.c(var3_2, var6_5 + 1, var4_4);
        if (c.b(var28_7) != -1) {
            return null;
        }
        ++var4_4;
        var23_9 = var24_8 = null;
        var10_10 = -1L;
        var8_11 = 253402300799999L;
        var18_12 = false;
        var19_13 = false;
        var17_14 = true;
        var16_15 = false;
        do {
            block27 : {
                block29 : {
                    block30 : {
                        block31 : {
                            block28 : {
                                block25 : {
                                    block26 : {
                                        if (var4_4 >= var5_3) break block25;
                                        var6_5 = c.a(var3_2, var4_4, var5_3, ';');
                                        var7_16 = c.a(var3_2, var4_4, var6_5, '=');
                                        var29_25 = c.c(var3_2, var4_4, var7_16);
                                        var25_22 = var7_16 < var6_5 ? c.c(var3_2, var7_16 + 1, var6_5) : "";
                                        if (!var29_25.equalsIgnoreCase("expires")) break block26;
                                        try {
                                            var8_11 = var12_17 = l.a(var25_22, 0, var25_22.length());
                                            ** GOTO lbl35
                                        }
                                        catch (IllegalArgumentException | NumberFormatException var25_23) {
                                            var25_22 = var24_8;
                                            var12_17 = var10_10;
                                            var20_19 = var18_12;
                                            var21_20 = var17_14;
                                            var26_24 = var23_9;
                                            var14_18 = var8_11;
                                            var22_21 = var16_15;
                                        }
                                    }
                                    if (var29_25.equalsIgnoreCase("max-age")) {
                                        var10_10 = var12_17 = l.a(var25_22);
lbl35: // 2 sources:
                                        var22_21 = true;
                                        var25_22 = var24_8;
                                        var12_17 = var10_10;
                                        var20_19 = var18_12;
                                        var21_20 = var17_14;
                                        var26_24 = var23_9;
                                        var14_18 = var8_11;
                                    } else if (var29_25.equalsIgnoreCase("domain")) {
                                        var25_22 = l.b(var25_22);
                                        var21_20 = false;
                                        var12_17 = var10_10;
                                        var20_19 = var18_12;
                                        var26_24 = var23_9;
                                        var14_18 = var8_11;
                                        var22_21 = var16_15;
                                        ** GOTO lbl132
                                    } else if (var29_25.equalsIgnoreCase("path")) {
                                        var26_24 = var25_22;
                                        var25_22 = var24_8;
                                        var12_17 = var10_10;
                                        var20_19 = var18_12;
                                        var21_20 = var17_14;
                                        var14_18 = var8_11;
                                        var22_21 = var16_15;
                                    } else if (var29_25.equalsIgnoreCase("secure")) {
                                        var20_19 = true;
                                        var25_22 = var24_8;
                                        var12_17 = var10_10;
                                        var21_20 = var17_14;
                                        var26_24 = var23_9;
                                        var14_18 = var8_11;
                                        var22_21 = var16_15;
                                    } else {
                                        var25_22 = var24_8;
                                        var12_17 = var10_10;
                                        var20_19 = var18_12;
                                        var21_20 = var17_14;
                                        var26_24 = var23_9;
                                        var14_18 = var8_11;
                                        var22_21 = var16_15;
                                        if (var29_25.equalsIgnoreCase("httponly")) {
                                            var19_13 = true;
                                            var22_21 = var16_15;
                                            var14_18 = var8_11;
                                            var26_24 = var23_9;
                                            var21_20 = var17_14;
                                            var20_19 = var18_12;
                                            var12_17 = var10_10;
                                            var25_22 = var24_8;
                                        }
                                    }
                                    break block27;
                                }
                                var12_17 = Long.MIN_VALUE;
                                if (var10_10 != Long.MIN_VALUE) break block28;
                                var0 = var12_17;
                                break block29;
                            }
                            if (var10_10 == -1L) break block30;
                            var8_11 = var10_10 <= 9223372036854775L ? var10_10 * 1000L : Long.MAX_VALUE;
                            if ((var8_11 = var0 + var8_11) < var0) break block31;
                            var0 = var8_11;
                            if (var8_11 <= 253402300799999L) break block29;
                        }
                        var0 = 253402300799999L;
                        break block29;
                    }
                    var0 = var8_11;
                }
                var25_22 = var2_1.f();
                if (var24_8 == null) {
                    var3_2 = var25_22;
                } else {
                    if (!l.a(var25_22, var24_8)) {
                        return null;
                    }
                    var3_2 = var24_8;
                }
                if (var25_22.length() != var3_2.length() && a.a().a(var3_2) == null) {
                    return null;
                }
                if (var23_9 != null && var23_9.startsWith("/")) {
                    var2_1 = var23_9;
                    return new l(var27_6, var28_7, var0, var3_2, (String)var2_1, var18_12, var19_13, var17_14, var16_15);
                }
                var4_4 = (var2_1 = var2_1.h()).lastIndexOf(47);
                if (var4_4 != 0) {
                    var2_1 = var2_1.substring(0, var4_4);
                    return new l(var27_6, var28_7, var0, var3_2, (String)var2_1, var18_12, var19_13, var17_14, var16_15);
                }
                var2_1 = "/";
                return new l(var27_6, var28_7, var0, var3_2, (String)var2_1, var18_12, var19_13, var17_14, var16_15);
            }
            var4_4 = var6_5 + 1;
            var24_8 = var25_22;
            var10_10 = var12_17;
            var18_12 = var20_19;
            var17_14 = var21_20;
            var23_9 = var26_24;
            var8_11 = var14_18;
            var16_15 = var22_21;
        } while (true);
    }

    @Nullable
    public static l a(t t2, String string2) {
        return l.a(System.currentTimeMillis(), t2, string2);
    }

    public static List<l> a(t t2, s object) {
        List<String> list = ((s)object).b("Set-Cookie");
        int n2 = list.size();
        object = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            l l2 = l.a(t2, list.get(i2));
            if (l2 == null) continue;
            Object object2 = object;
            if (object == null) {
                object2 = new ArrayList();
            }
            object2.add(l2);
            object = object2;
        }
        if (object != null) {
            return Collections.unmodifiableList(object);
        }
        return Collections.emptyList();
    }

    private static boolean a(String string2, String string3) {
        if (string2.equals(string3)) {
            return true;
        }
        return string2.endsWith(string3) && string2.charAt(string2.length() - string3.length() - 1) == '.' && !c.c(string2);
    }

    private static String b(String string2) {
        if (!string2.endsWith(".")) {
            String string3 = string2;
            if (string2.startsWith(".")) {
                string3 = string2.substring(1);
            }
            if ((string2 = c.a(string3)) != null) {
                return string2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public String a() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    String a(boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append('=');
        stringBuilder.append(this.f);
        if (this.l) {
            String string2;
            if (this.g == Long.MIN_VALUE) {
                string2 = "; max-age=0";
            } else {
                stringBuilder.append("; expires=");
                string2 = d.a(new Date(this.g));
            }
            stringBuilder.append(string2);
        }
        if (!this.m) {
            stringBuilder.append("; domain=");
            if (bl2) {
                stringBuilder.append(".");
            }
            stringBuilder.append(this.h);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.i);
        if (this.j) {
            stringBuilder.append("; secure");
        }
        if (this.k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public String b() {
        return this.f;
    }

    public boolean equals(@Nullable Object object) {
        boolean bl2 = object instanceof l;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = (l)object;
        bl2 = bl3;
        if (((l)object).e.equals(this.e)) {
            bl2 = bl3;
            if (((l)object).f.equals(this.f)) {
                bl2 = bl3;
                if (((l)object).h.equals(this.h)) {
                    bl2 = bl3;
                    if (((l)object).i.equals(this.i)) {
                        bl2 = bl3;
                        if (((l)object).g == this.g) {
                            bl2 = bl3;
                            if (((l)object).j == this.j) {
                                bl2 = bl3;
                                if (((l)object).k == this.k) {
                                    bl2 = bl3;
                                    if (((l)object).l == this.l) {
                                        bl2 = bl3;
                                        if (((l)object).m == this.m) {
                                            bl2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return ((((((((527 + this.e.hashCode()) * 31 + this.f.hashCode()) * 31 + this.h.hashCode()) * 31 + this.i.hashCode()) * 31 + (int)(this.g ^ this.g >>> 32)) * 31 + (this.j ^ true)) * 31 + (this.k ^ true)) * 31 + (this.l ^ true)) * 31 + (this.m ^ true);
    }

    public String toString() {
        return this.a(false);
    }
}

