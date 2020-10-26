/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.i.a;
import kotlin.i.n;
import kotlin.i.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\b\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\f\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2={"toByteOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/text/StringsKt")
class u
extends t {
    public static final Byte a(String object, int n2) {
        j.b(object, "$receiver");
        object = n.c((String)object, n2);
        if (object != null && (n2 = ((Integer)object).intValue()) >= -128) {
            if (n2 > 127) {
                return null;
            }
            return (byte)n2;
        }
        return null;
    }

    public static final Short b(String object, int n2) {
        j.b(object, "$receiver");
        object = n.c((String)object, n2);
        if (object != null && (n2 = ((Integer)object).intValue()) >= -32768) {
            if (n2 > 32767) {
                return null;
            }
            return (short)n2;
        }
        return null;
    }

    public static final Integer c(String string2) {
        j.b(string2, "$receiver");
        return n.c(string2, 10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Integer c(String string2, int n2) {
        int n3;
        int n4;
        int n5;
        boolean bl2;
        int n6;
        int n7;
        block9 : {
            block10 : {
                block7 : {
                    block8 : {
                        j.b(string2, "$receiver");
                        a.a(n2);
                        n7 = string2.length();
                        if (n7 == 0) {
                            return null;
                        }
                        n4 = 0;
                        n6 = 0;
                        n5 = string2.charAt(0);
                        n3 = -2147483647;
                        if (n5 >= 48) break block7;
                        if (n7 == 1) {
                            return null;
                        }
                        if (n5 != 45) break block8;
                        n3 = Integer.MIN_VALUE;
                        n5 = 1;
                        bl2 = true;
                        break block9;
                    }
                    if (n5 != 43) return null;
                    n5 = 1;
                    break block10;
                }
                n5 = 0;
            }
            bl2 = false;
        }
        int n8 = n3 / n2;
        if (n5 <= --n7) {
            n4 = n6;
            do {
                if ((n6 = a.a(string2.charAt(n5), n2)) < 0) {
                    return null;
                }
                if (n4 < n8) {
                    return null;
                }
                if ((n4 *= n2) < n3 + n6) {
                    return null;
                }
                n4 = n6 = n4 - n6;
                if (n5 == n7) break;
                ++n5;
                n4 = n6;
            } while (true);
        }
        if (!bl2) return -n4;
        return n4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final Long d(String var0, int var1_1) {
        j.b(var0, "$receiver");
        a.a(var1_1);
        var4_2 = var0.length();
        if (var4_2 == 0) {
            return null;
        }
        var2_3 = 0;
        var3_4 = var0.charAt(0);
        var6_5 = -9223372036854775807L;
        if (var3_4 >= '0') ** GOTO lbl19
        if (var4_2 == 1) {
            return null;
        }
        if (var3_4 == '-') {
            var6_5 = Long.MIN_VALUE;
            var2_3 = 1;
            var3_4 = '\u0001';
        } else {
            if (var3_4 != '+') return null;
            var2_3 = 1;
lbl19: // 2 sources:
            var3_4 = '\u0000';
        }
        var12_6 = var1_1;
        var14_7 = var6_5 / var12_6;
        var10_8 = 0L;
        var8_9 = var10_8;
        if (var2_3 <= --var4_2) {
            do {
                if ((var5_10 = a.a(var0.charAt(var2_3), var1_1)) < 0) {
                    return null;
                }
                if (var10_8 < var14_7) {
                    return null;
                }
                var8_9 = var10_8 * var12_6;
                var10_8 = var5_10;
                if (var8_9 < var6_5 + var10_8) {
                    return null;
                }
                var8_9 = var10_8 = var8_9 - var10_8;
                if (var2_3 == var4_2) break;
                ++var2_3;
            } while (true);
        }
        if (var3_4 == '\u0000') return -var8_9;
        return var8_9;
    }
}

