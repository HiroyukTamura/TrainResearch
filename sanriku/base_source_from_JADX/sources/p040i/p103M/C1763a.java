package p040i.p103M;

/* renamed from: i.M.a */
public final class C1763a {
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a0, code lost:
        if ((r2 - r15) != 0) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d7 A[LOOP:0: B:1:0x000e->B:60:0x00d7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ea A[EDGE_INSN: B:69:0x00ea->B:61:0x00ea ?: BREAK  
    EDGE_INSN: B:72:0x00ea->B:61:0x00ea ?: BREAK  , RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.net.InetAddress m2603a(java.lang.String r20, int r21, int r22) {
        /*
            r6 = r20
            r7 = r22
            r8 = 16
            byte[] r9 = new byte[r8]
            r10 = -1
            r12 = r21
            r13 = 0
            r14 = -1
            r15 = -1
        L_0x000e:
            r16 = 0
            if (r12 >= r7) goto L_0x00eb
            if (r13 != r8) goto L_0x0015
            return r16
        L_0x0015:
            int r5 = r12 + 2
            r4 = 255(0xff, float:3.57E-43)
            r3 = 4
            if (r5 > r7) goto L_0x0045
            r17 = 0
            r18 = 4
            r19 = 0
            java.lang.String r1 = "::"
            r0 = r20
            r2 = r12
            r11 = 4
            r3 = r17
            r11 = 255(0xff, float:3.57E-43)
            r4 = r18
            r11 = r5
            r5 = r19
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0045
            if (r14 == r10) goto L_0x003a
            return r16
        L_0x003a:
            int r13 = r13 + 2
            if (r11 != r7) goto L_0x0041
            r14 = r13
            goto L_0x00eb
        L_0x0041:
            r15 = r11
            r14 = r13
            goto L_0x00ba
        L_0x0045:
            if (r13 == 0) goto L_0x00b9
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r0 = r20
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0059
            int r12 = r12 + 1
            goto L_0x00b9
        L_0x0059:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r0 = r20
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00b8
            int r0 = r13 + -2
            r1 = r0
        L_0x006a:
            if (r15 >= r7) goto L_0x00ab
            if (r1 != r8) goto L_0x006f
            goto L_0x00b1
        L_0x006f:
            if (r1 == r0) goto L_0x007c
            char r2 = r6.charAt(r15)
            r3 = 46
            if (r2 == r3) goto L_0x007a
            goto L_0x00b1
        L_0x007a:
            int r15 = r15 + 1
        L_0x007c:
            r2 = r15
            r3 = 0
        L_0x007e:
            if (r2 >= r7) goto L_0x009e
            char r4 = r6.charAt(r2)
            r5 = 48
            if (r4 < r5) goto L_0x009e
            r11 = 57
            if (r4 <= r11) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            if (r3 != 0) goto L_0x0092
            if (r15 == r2) goto L_0x0092
            goto L_0x00b1
        L_0x0092:
            int r3 = r3 * 10
            int r3 = r3 + r4
            int r3 = r3 - r5
            r4 = 255(0xff, float:3.57E-43)
            if (r3 <= r4) goto L_0x009b
            goto L_0x00b1
        L_0x009b:
            int r2 = r2 + 1
            goto L_0x007e
        L_0x009e:
            int r4 = r2 - r15
            if (r4 != 0) goto L_0x00a3
            goto L_0x00b1
        L_0x00a3:
            int r4 = r1 + 1
            byte r3 = (byte) r3
            r9[r1] = r3
            r15 = r2
            r1 = r4
            goto L_0x006a
        L_0x00ab:
            r2 = 4
            int r0 = r0 + r2
            if (r1 != r0) goto L_0x00b1
            r0 = 1
            goto L_0x00b2
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            if (r0 != 0) goto L_0x00b5
            return r16
        L_0x00b5:
            int r13 = r13 + 2
            goto L_0x00eb
        L_0x00b8:
            return r16
        L_0x00b9:
            r15 = r12
        L_0x00ba:
            r12 = r15
            r0 = 0
        L_0x00bc:
            if (r12 >= r7) goto L_0x00cf
            char r1 = r6.charAt(r12)
            int r1 = p040i.p103M.C1764b.m2605a((char) r1)
            if (r1 != r10) goto L_0x00c9
            goto L_0x00cf
        L_0x00c9:
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L_0x00bc
        L_0x00cf:
            int r1 = r12 - r15
            if (r1 == 0) goto L_0x00ea
            r2 = 4
            if (r1 <= r2) goto L_0x00d7
            goto L_0x00ea
        L_0x00d7:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L_0x000e
        L_0x00ea:
            return r16
        L_0x00eb:
            if (r13 == r8) goto L_0x00fe
            if (r14 != r10) goto L_0x00f0
            return r16
        L_0x00f0:
            int r0 = r13 - r14
            int r1 = 16 - r0
            java.lang.System.arraycopy(r9, r14, r9, r1, r0)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            byte r0 = (byte) r0
            java.util.Arrays.fill(r9, r14, r8, r0)
        L_0x00fe:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.C1763a.m2603a(java.lang.String, int, int):java.net.InetAddress");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010a, code lost:
        r2 = 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m2602a(java.lang.String r12) {
        /*
            java.lang.String r0 = "$this$toCanonicalHost"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            r0 = 2
            r1 = 0
            r2 = 0
            java.lang.String r3 = ":"
            boolean r3 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r12, (java.lang.CharSequence) r3, (boolean) r2, (int) r0, (java.lang.Object) r1)
            r4 = -1
            r5 = 1
            if (r3 == 0) goto L_0x00c1
            java.lang.String r3 = "["
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r3, r2, r0, r1)
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = "]"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r12, r3, r2, r0, r1)
            if (r0 == 0) goto L_0x002c
            int r0 = r12.length()
            int r0 = r0 - r5
            java.net.InetAddress r0 = m2603a(r12, r5, r0)
            goto L_0x0034
        L_0x002c:
            int r0 = r12.length()
            java.net.InetAddress r0 = m2603a(r12, r2, r0)
        L_0x0034:
            if (r0 == 0) goto L_0x00c0
            byte[] r1 = r0.getAddress()
            int r3 = r1.length
            r5 = 4
            r6 = 16
            if (r3 != r6) goto L_0x009c
            java.lang.String r12 = "address"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r12)
            r12 = 0
            r0 = 0
        L_0x0047:
            int r3 = r1.length
            if (r12 >= r3) goto L_0x0065
            r3 = r12
        L_0x004b:
            if (r3 >= r6) goto L_0x005a
            byte r7 = r1[r3]
            if (r7 != 0) goto L_0x005a
            int r7 = r3 + 1
            byte r7 = r1[r7]
            if (r7 != 0) goto L_0x005a
            int r3 = r3 + 2
            goto L_0x004b
        L_0x005a:
            int r7 = r3 - r12
            if (r7 <= r0) goto L_0x0062
            if (r7 < r5) goto L_0x0062
            r4 = r12
            r0 = r7
        L_0x0062:
            int r12 = r3 + 2
            goto L_0x0047
        L_0x0065:
            j.f r12 = new j.f
            r12.<init>()
        L_0x006a:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0097
            r3 = 58
            if (r2 != r4) goto L_0x007b
            r12.writeByte((int) r3)
            int r2 = r2 + r0
            if (r2 != r6) goto L_0x006a
            r12.writeByte((int) r3)
            goto L_0x006a
        L_0x007b:
            if (r2 <= 0) goto L_0x0080
            r12.writeByte((int) r3)
        L_0x0080:
            byte r3 = r1[r2]
            r5 = 255(0xff, float:3.57E-43)
            int r3 = p040i.p103M.C1764b.m2604a((byte) r3, (int) r5)
            int r3 = r3 << 8
            int r7 = r2 + 1
            byte r7 = r1[r7]
            r5 = r5 & r7
            r3 = r3 | r5
            long r7 = (long) r3
            r12.mo29151c((long) r7)
            int r2 = r2 + 2
            goto L_0x006a
        L_0x0097:
            java.lang.String r12 = r12.mo29175o()
            return r12
        L_0x009c:
            int r1 = r1.length
            if (r1 != r5) goto L_0x00a4
            java.lang.String r12 = r0.getHostAddress()
            return r12
        L_0x00a4:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid IPv6 address: '"
            r1.append(r2)
            r1.append(r12)
            r12 = 39
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        L_0x00c0:
            return r1
        L_0x00c1:
            java.lang.String r12 = java.net.IDN.toASCII(r12)     // Catch:{ IllegalArgumentException -> 0x010f }
            java.lang.String r0 = "IDN.toASCII(host)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)     // Catch:{ IllegalArgumentException -> 0x010f }
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x010f }
            java.lang.String r3 = "Locale.US"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)     // Catch:{ IllegalArgumentException -> 0x010f }
            java.lang.String r12 = r12.toLowerCase(r0)     // Catch:{ IllegalArgumentException -> 0x010f }
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)     // Catch:{ IllegalArgumentException -> 0x010f }
            int r0 = r12.length()     // Catch:{ IllegalArgumentException -> 0x010f }
            if (r0 != 0) goto L_0x00e2
            r0 = 1
            goto L_0x00e3
        L_0x00e2:
            r0 = 0
        L_0x00e3:
            if (r0 == 0) goto L_0x00e6
            return r1
        L_0x00e6:
            int r0 = r12.length()     // Catch:{ IllegalArgumentException -> 0x010f }
            r3 = 0
        L_0x00eb:
            if (r3 >= r0) goto L_0x010b
            char r7 = r12.charAt(r3)     // Catch:{ IllegalArgumentException -> 0x010f }
            r6 = 31
            if (r7 <= r6) goto L_0x010a
            r6 = 127(0x7f, float:1.78E-43)
            if (r7 < r6) goto L_0x00fa
            goto L_0x010a
        L_0x00fa:
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            java.lang.String r6 = " #%/:?@[\\]"
            int r6 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r6, (char) r7, (int) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ IllegalArgumentException -> 0x010f }
            if (r6 == r4) goto L_0x0107
            goto L_0x010a
        L_0x0107:
            int r3 = r3 + 1
            goto L_0x00eb
        L_0x010a:
            r2 = 1
        L_0x010b:
            if (r2 == 0) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r1 = r12
        L_0x010f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.C1763a.m2602a(java.lang.String):java.lang.String");
    }
}
