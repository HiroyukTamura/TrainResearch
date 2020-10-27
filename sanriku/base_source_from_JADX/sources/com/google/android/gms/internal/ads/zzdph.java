package com.google.android.gms.internal.ads;

import java.util.Map;
import kotlin.UByte;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdph<K, V> extends zzdoy<K, V> {
    private static final zzdoy<Object, Object> zzhfv = new zzdph((Object) null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhft;
    private final transient Object zzhfw;

    private zzdph(Object obj, Object[] objArr, int i) {
        this.zzhfw = obj;
        this.zzhft = objArr;
        this.size = i;
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder b = C0681a.m337b(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39, "Multiple entries with same key: ", valueOf, "=", valueOf2);
        b.append(" and ");
        b.append(valueOf3);
        b.append("=");
        b.append(valueOf4);
        return new IllegalArgumentException(b.toString());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r10v5 ?, r10v4 ?, r10v7 ?, r10v9 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.gms.internal.ads.zzdph<K, V> zzc(int r10, java.lang.Object[] r11) {
        /*
            int r10 = r11.length
            int r10 = r10 >> 1
            r0 = 5
            com.google.android.gms.internal.ads.zzdoj.zzt(r0, r10)
            int r10 = com.google.android.gms.internal.ads.zzdpb.zzeh(r0)
            int r1 = r10 + -1
            r2 = 0
            r3 = -1
            r4 = 128(0x80, float:1.794E-43)
            if (r10 > r4) goto L_0x004b
            byte[] r10 = new byte[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x0018:
            if (r2 >= r0) goto L_0x00bd
            int r3 = r2 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzdoo.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzdoq.zzef(r6)
        L_0x002d:
            r6 = r6 & r1
            byte r7 = r10[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x003b
            byte r3 = (byte) r3
            r10[r6] = r3
            int r2 = r2 + 1
            goto L_0x0018
        L_0x003b:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0046
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0046:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x004b:
            r4 = 32768(0x8000, float:4.5918E-41)
            if (r10 > r4) goto L_0x0089
            short[] r10 = new short[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x0055:
            if (r2 >= r0) goto L_0x00bd
            int r3 = r2 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.ads.zzdoo.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzdoq.zzef(r6)
        L_0x006a:
            r6 = r6 & r1
            short r7 = r10[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0079
            short r3 = (short) r3
            r10[r6] = r3
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0079:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0084
            int r6 = r6 + 1
            goto L_0x006a
        L_0x0084:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0089:
            int[] r10 = new int[r10]
            java.util.Arrays.fill(r10, r3)
        L_0x008e:
            if (r2 >= r0) goto L_0x00bd
            int r4 = r2 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.ads.zzdoo.zzb(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.ads.zzdoq.zzef(r7)
        L_0x00a3:
            r7 = r7 & r1
            r8 = r10[r7]
            if (r8 != r3) goto L_0x00ad
            r10[r7] = r4
            int r2 = r2 + 1
            goto L_0x008e
        L_0x00ad:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00b8
            int r7 = r7 + 1
            goto L_0x00a3
        L_0x00b8:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x00bd:
            com.google.android.gms.internal.ads.zzdph r1 = new com.google.android.gms.internal.ads.zzdph
            r1.<init>(r10, r11, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdph.zzc(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdph");
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzhfw;
        V[] vArr = this.zzhft;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzef = zzdoq.zzef(obj.hashCode());
                while (true) {
                    int i2 = zzef & length;
                    byte b = bArr[i2] & UByte.MAX_VALUE;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zzef = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzef2 = zzdoq.zzef(obj.hashCode());
                while (true) {
                    int i3 = zzef2 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zzef2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzef3 = zzdoq.zzef(obj.hashCode());
                while (true) {
                    int i4 = zzef3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zzef3 = i4 + 1;
                }
            }
        }
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final zzdpb<Map.Entry<K, V>> zzavz() {
        return new zzdpg(this, this.zzhft, 0, this.size);
    }

    /* access modifiers changed from: package-private */
    public final zzdpb<K> zzawa() {
        return new zzdpi(this, new zzdpl(this.zzhft, 0, this.size));
    }

    /* access modifiers changed from: package-private */
    public final zzdot<V> zzawb() {
        return new zzdpl(this.zzhft, 1, this.size);
    }
}
