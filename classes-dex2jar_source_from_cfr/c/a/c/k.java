/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.y;
import java.net.ProtocolException;

public final class k {
    public final y a;
    public final int b;
    public final String c;

    public k(y y2, int n2, String string2) {
        this.a = y2;
        this.b = n2;
        this.c = string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static k a(String var0) {
        var4_1 = var0.startsWith("HTTP/1.");
        var1_2 = 9;
        if (!var4_1) ** GOTO lbl20
        if (var0.length() >= 9 && var0.charAt(8) == ' ') {
            var2_3 = var0.charAt(7) - 48;
            if (var2_3 == 0) {
                var5_4 = y.a;
            } else {
                if (var2_3 != 1) {
                    var5_5 = new StringBuilder();
                    var5_5.append("Unexpected status line: ");
                    var5_5.append(var0);
                    throw new ProtocolException(var5_5.toString());
                }
                var5_4 = y.b;
            }
        } else {
            var5_6 = new StringBuilder();
            var5_6.append("Unexpected status line: ");
            var5_6.append(var0);
            throw new ProtocolException(var5_6.toString());
lbl20: // 1 sources:
            if (!var0.startsWith("ICY ")) {
                var5_9 = new StringBuilder();
                var5_9.append("Unexpected status line: ");
                var5_9.append(var0);
                throw new ProtocolException(var5_9.toString());
            }
            var5_4 = y.a;
            var1_2 = 4;
        }
        var3_10 = var0.length();
        var2_3 = var1_2 + 3;
        if (var3_10 < var2_3) {
            var5_4 = new StringBuilder();
            var5_4.append("Unexpected status line: ");
            var5_4.append(var0);
            throw new ProtocolException(var5_4.toString());
        }
        try {
            var3_10 = Integer.parseInt(var0.substring(var1_2, var2_3));
            var6_11 = "";
        }
        catch (NumberFormatException var5_7) {}
        if (var0.length() <= var2_3) return new k((y)var5_4, var3_10, var6_11);
        if (var0.charAt(var2_3) == ' ') {
            var6_11 = var0.substring(var1_2 + 4);
            return new k((y)var5_4, var3_10, var6_11);
        }
        var5_4 = new StringBuilder();
        var5_4.append("Unexpected status line: ");
        var5_4.append(var0);
        throw new ProtocolException(var5_4.toString());
        var5_8 = new StringBuilder();
        var5_8.append("Unexpected status line: ");
        var5_8.append(var0);
        throw new ProtocolException(var5_8.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a == y.a ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}

