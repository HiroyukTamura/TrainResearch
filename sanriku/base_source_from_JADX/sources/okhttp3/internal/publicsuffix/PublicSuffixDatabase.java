package okhttp3.internal.publicsuffix;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.p103M.C1764b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo21739d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
public final class PublicSuffixDatabase {

    /* renamed from: e */
    private static final byte[] f4283e = {(byte) 42};

    /* renamed from: f */
    private static final List<String> f4284f = CollectionsKt__CollectionsJVMKt.listOf("*");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final PublicSuffixDatabase f4285g = new PublicSuffixDatabase();

    /* renamed from: h */
    public static final C2611a f4286h = new C2611a((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final AtomicBoolean f4287a = new AtomicBoolean(false);

    /* renamed from: b */
    private final CountDownLatch f4288b = new CountDownLatch(1);

    /* renamed from: c */
    private byte[] f4289c;

    /* renamed from: d */
    private byte[] f4290d;

    /* renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$a */
    public static final class C2611a {
        public /* synthetic */ C2611a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static final /* synthetic */ String m4561a(C2611a aVar, byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int i3;
            boolean z;
            int a;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            if (aVar != null) {
                int length = bArr3.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = (i4 + length) / 2;
                    while (i5 > -1 && bArr3[i5] != ((byte) 10)) {
                        i5--;
                    }
                    int i6 = i5 + 1;
                    int i7 = 1;
                    while (true) {
                        i2 = i6 + i7;
                        if (bArr3[i2] == ((byte) 10)) {
                            break;
                        }
                        i7++;
                    }
                    int i8 = i2 - i6;
                    int i9 = i;
                    boolean z2 = false;
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        if (z2) {
                            i3 = 46;
                            z = false;
                        } else {
                            boolean z3 = z2;
                            i3 = C1764b.m2604a(bArr4[i9][i10], 255);
                            z = z3;
                        }
                        a = i3 - C1764b.m2604a(bArr3[i6 + i11], 255);
                        if (a == 0) {
                            i11++;
                            i10++;
                            if (i11 == i8) {
                                break;
                            } else if (bArr4[i9].length != i10) {
                                z2 = z;
                            } else if (i9 == bArr4.length - 1) {
                                break;
                            } else {
                                i9++;
                                z2 = true;
                                i10 = -1;
                            }
                        } else {
                            break;
                        }
                    }
                    if (a >= 0) {
                        if (a <= 0) {
                            int i12 = i8 - i11;
                            int length2 = bArr4[i9].length - i10;
                            int length3 = bArr4.length;
                            for (int i13 = i9 + 1; i13 < length3; i13++) {
                                length2 += bArr4[i13].length;
                            }
                            if (length2 >= i12) {
                                if (length2 <= i12) {
                                    Charset charset = StandardCharsets.UTF_8;
                                    Intrinsics.checkExpressionValueIsNotNull(charset, "UTF_8");
                                    return new String(bArr3, i6, i8, charset);
                                }
                            }
                        }
                        i4 = i2 + 1;
                    }
                    length = i6 - 1;
                }
                return null;
            }
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        throw r2;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m4559b() throws java.io.IOException {
        /*
            r5 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 == 0) goto L_0x0057
            j.m r1 = new j.m
            j.z r0 = p042j.C2080p.m3583a((java.io.InputStream) r0)
            r1.<init>(r0)
            java.lang.String r0 = "$this$buffer"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            j.t r0 = new j.t
            r0.<init>(r1)
            r1 = 0
            int r2 = r0.readInt()     // Catch:{ all -> 0x0050 }
            long r2 = (long) r2     // Catch:{ all -> 0x0050 }
            byte[] r2 = r0.mo29156e(r2)     // Catch:{ all -> 0x0050 }
            int r3 = r0.readInt()     // Catch:{ all -> 0x0050 }
            long r3 = (long) r3     // Catch:{ all -> 0x0050 }
            byte[] r3 = r0.mo29156e(r3)     // Catch:{ all -> 0x0050 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0050 }
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)
            monitor-enter(r5)
            if (r2 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004d }
        L_0x003b:
            r5.f4289c = r2     // Catch:{ all -> 0x004d }
            if (r3 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004d }
        L_0x0042:
            r5.f4290d = r3     // Catch:{ all -> 0x004d }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            java.util.concurrent.CountDownLatch r0 = r5.f4288b
            r0.countDown()
            return
        L_0x004d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0050:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.m4559b():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0059 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0185 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0186  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo35638a(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "domain"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r3 = java.net.IDN.toUnicode(r21)
            java.lang.String r0 = "unicodeDomain"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            r9 = 1
            char[] r4 = new char[r9]
            r10 = 46
            r11 = 0
            r4[r11] = r10
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r3 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r3, (char[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f4287a
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0068
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f4287a
            boolean r0 = r0.compareAndSet(r11, r9)
            if (r0 == 0) goto L_0x0068
            r4 = 0
        L_0x0033:
            r20.m4559b()     // Catch:{  }
            if (r4 == 0) goto L_0x0075
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ InterruptedIOException -> 0x0059, IOException -> 0x0042 }
            r0.interrupt()     // Catch:{ InterruptedIOException -> 0x0059, IOException -> 0x0042 }
            goto L_0x0075
        L_0x0040:
            r0 = move-exception
            goto L_0x005e
        L_0x0042:
            r0 = move-exception
            i.M.k.h$a r5 = p040i.p103M.p112k.C1890h.f2683c     // Catch:{ all -> 0x0040 }
            i.M.k.h r5 = p040i.p103M.p112k.C1890h.f2681a     // Catch:{ all -> 0x0040 }
            java.lang.String r6 = "Failed to read public suffix list"
            r7 = 5
            r5.mo27964a((java.lang.String) r6, (int) r7, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0075
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x0075
        L_0x0059:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0040 }
            r4 = 1
            goto L_0x0033
        L_0x005e:
            if (r4 == 0) goto L_0x0067
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
        L_0x0067:
            throw r0
        L_0x0068:
            java.util.concurrent.CountDownLatch r0 = r1.f4288b     // Catch:{ InterruptedException -> 0x006e }
            r0.await()     // Catch:{ InterruptedException -> 0x006e }
            goto L_0x0075
        L_0x006e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0075:
            byte[] r0 = r1.f4289c
            if (r0 == 0) goto L_0x007b
            r0 = 1
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            if (r0 == 0) goto L_0x01ca
            int r0 = r3.size()
            byte[][] r4 = new byte[r0][]
            r5 = 0
        L_0x0085:
            if (r5 >= r0) goto L_0x00ac
            java.lang.Object r6 = r3.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r8 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            if (r6 == 0) goto L_0x00a4
            byte[] r6 = r6.getBytes(r7)
            java.lang.String r7 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0085
        L_0x00a4:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)
            throw r0
        L_0x00ac:
            r5 = 0
        L_0x00ad:
            java.lang.String r6 = "publicSuffixListBytes"
            r7 = 0
            if (r5 >= r0) goto L_0x00c6
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$a r8 = f4286h
            byte[] r12 = r1.f4289c
            if (r12 != 0) goto L_0x00bb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00bb:
            java.lang.String r8 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.C2611a.m4561a(r8, r12, r4, r5)
            if (r8 == 0) goto L_0x00c3
            r12 = r8
            goto L_0x00c7
        L_0x00c3:
            int r5 = r5 + 1
            goto L_0x00ad
        L_0x00c6:
            r12 = r7
        L_0x00c7:
            if (r0 <= r9) goto L_0x00ec
            java.lang.Object r5 = r4.clone()
            byte[][] r5 = (byte[][]) r5
            int r8 = r5.length
            int r8 = r8 - r9
            r13 = 0
        L_0x00d2:
            if (r13 >= r8) goto L_0x00ec
            byte[] r14 = f4283e
            r5[r13] = r14
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$a r14 = f4286h
            byte[] r15 = r1.f4289c
            if (r15 != 0) goto L_0x00e1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00e1:
            java.lang.String r14 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.C2611a.m4561a(r14, r15, r5, r13)
            if (r14 == 0) goto L_0x00e9
            r5 = r14
            goto L_0x00ed
        L_0x00e9:
            int r13 = r13 + 1
            goto L_0x00d2
        L_0x00ec:
            r5 = r7
        L_0x00ed:
            if (r5 == 0) goto L_0x0108
            int r0 = r0 - r9
            r6 = 0
        L_0x00f1:
            if (r6 >= r0) goto L_0x0108
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$a r8 = f4286h
            byte[] r13 = r1.f4290d
            if (r13 != 0) goto L_0x00fe
            java.lang.String r14 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
        L_0x00fe:
            java.lang.String r8 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.C2611a.m4561a(r8, r13, r4, r6)
            if (r8 == 0) goto L_0x0105
            goto L_0x0109
        L_0x0105:
            int r6 = r6 + 1
            goto L_0x00f1
        L_0x0108:
            r8 = r7
        L_0x0109:
            r0 = 33
            if (r8 == 0) goto L_0x012b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r12 = r4.toString()
            char[] r13 = new char[r9]
            r13[r11] = r10
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r4 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r12, (char[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            goto L_0x016f
        L_0x012b:
            if (r12 != 0) goto L_0x0132
            if (r5 != 0) goto L_0x0132
            java.util.List<java.lang.String> r4 = f4284f
            goto L_0x016f
        L_0x0132:
            if (r12 == 0) goto L_0x0145
            char[] r13 = new char[r9]
            r13[r11] = r10
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r4 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r12, (char[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            if (r4 == 0) goto L_0x0145
            goto L_0x0149
        L_0x0145:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0149:
            if (r5 == 0) goto L_0x015f
            char[] r15 = new char[r9]
            r15[r11] = r10
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            r14 = r5
            java.util.List r5 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r14, (char[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            if (r5 == 0) goto L_0x015f
            goto L_0x0163
        L_0x015f:
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0163:
            int r6 = r4.size()
            int r8 = r5.size()
            if (r6 <= r8) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r4 = r5
        L_0x016f:
            int r5 = r3.size()
            int r6 = r4.size()
            if (r5 != r6) goto L_0x0186
            java.lang.Object r5 = r4.get(r11)
            java.lang.String r5 = (java.lang.String) r5
            char r5 = r5.charAt(r11)
            if (r5 == r0) goto L_0x0186
            return r7
        L_0x0186:
            java.lang.Object r5 = r4.get(r11)
            java.lang.String r5 = (java.lang.String) r5
            char r5 = r5.charAt(r11)
            if (r5 != r0) goto L_0x019b
            int r0 = r3.size()
            int r3 = r4.size()
            goto L_0x01a4
        L_0x019b:
            int r0 = r3.size()
            int r3 = r4.size()
            int r3 = r3 + r9
        L_0x01a4:
            int r0 = r0 - r3
            char[] r3 = new char[r9]
            r3[r11] = r10
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r21
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, (char[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            kotlin.sequences.Sequence r2 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r2)
            kotlin.sequences.Sequence r3 = kotlin.sequences.SequencesKt___SequencesKt.drop(r2, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 62
            r11 = 0
            java.lang.String r4 = "."
            java.lang.String r0 = kotlin.sequences.SequencesKt___SequencesKt.joinToString$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x01ca:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            goto L_0x01d7
        L_0x01d6:
            throw r0
        L_0x01d7:
            goto L_0x01d6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.mo35638a(java.lang.String):java.lang.String");
    }
}
