package p042j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, mo21739d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.q */
public final class C2081q extends AbstractList<C2073i> implements RandomAccess {

    /* renamed from: c */
    public static final C2082a f2912c = new C2082a((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final C2073i[] f2913a;

    /* renamed from: b */
    private final int[] f2914b;

    public /* synthetic */ C2081q(C2073i[] iVarArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2913a = iVarArr;
        this.f2914b = iArr;
    }

    /* renamed from: a */
    public final C2073i[] mo29226a() {
        return this.f2913a;
    }

    /* renamed from: b */
    public final int[] mo29227b() {
        return this.f2914b;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof C2073i) {
            return super.contains((C2073i) obj);
        }
        return false;
    }

    public Object get(int i) {
        return this.f2913a[i];
    }

    public int getSize() {
        return this.f2913a.length;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof C2073i) {
            return super.indexOf((C2073i) obj);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof C2073i) {
            return super.lastIndexOf((C2073i) obj);
        }
        return -1;
    }

    /* renamed from: j.q$a */
    public static final class C2082a {
        public /* synthetic */ C2082a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        private final long m3589a(C2068f fVar) {
            return fVar.size() / ((long) 4);
        }

        /* renamed from: a */
        private final void m3590a(long j, C2068f fVar, int i, List<? extends C2073i> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            C2068f fVar2;
            C2068f fVar3 = fVar;
            int i8 = i;
            List<? extends C2073i> list3 = list;
            int i9 = i2;
            int i10 = i3;
            List<Integer> list4 = list2;
            if (i9 < i10) {
                int i11 = i9;
                while (i11 < i10) {
                    if (((C2073i) list3.get(i11)).mo29212d() >= i8) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                C2073i iVar = (C2073i) list.get(i2);
                C2073i iVar2 = (C2073i) list3.get(i10 - 1);
                if (i8 == iVar.mo29212d()) {
                    int intValue = list4.get(i9).intValue();
                    int i12 = i9 + 1;
                    i4 = i12;
                    i5 = intValue;
                    iVar = (C2073i) list3.get(i12);
                } else {
                    i4 = i9;
                    i5 = -1;
                }
                if (iVar.mo29201a(i8) != iVar2.mo29201a(i8)) {
                    int i13 = 1;
                    for (int i14 = i4 + 1; i14 < i10; i14++) {
                        if (((C2073i) list3.get(i14 - 1)).mo29201a(i8) != ((C2073i) list3.get(i14)).mo29201a(i8)) {
                            i13++;
                        }
                    }
                    long a = j + m3589a(fVar3) + ((long) 2) + ((long) (i13 * 2));
                    fVar3.writeInt(i13);
                    fVar3.writeInt(i5);
                    for (int i15 = i4; i15 < i10; i15++) {
                        byte a2 = ((C2073i) list3.get(i15)).mo29201a(i8);
                        if (i15 == i4 || a2 != ((C2073i) list3.get(i15 - 1)).mo29201a(i8)) {
                            fVar3.writeInt((int) a2 & UByte.MAX_VALUE);
                        }
                    }
                    C2068f fVar4 = new C2068f();
                    while (i4 < i10) {
                        byte a3 = ((C2073i) list3.get(i4)).mo29201a(i8);
                        int i16 = i4 + 1;
                        int i17 = i16;
                        while (true) {
                            if (i17 >= i10) {
                                i6 = i10;
                                break;
                            } else if (a3 != ((C2073i) list3.get(i17)).mo29201a(i8)) {
                                i6 = i17;
                                break;
                            } else {
                                i17++;
                            }
                        }
                        if (i16 == i6 && i8 + 1 == ((C2073i) list3.get(i4)).mo29212d()) {
                            fVar3.writeInt(list4.get(i4).intValue());
                            i7 = i6;
                            fVar2 = fVar4;
                        } else {
                            fVar3.writeInt(((int) (a + m3589a(fVar4))) * -1);
                            i7 = i6;
                            fVar2 = fVar4;
                            m3590a(a, fVar4, i8 + 1, list, i4, i6, list2);
                        }
                        fVar4 = fVar2;
                        i4 = i7;
                    }
                    fVar3.mo29135a((C1016z) fVar4);
                    return;
                }
                int min = Math.min(iVar.mo29212d(), iVar2.mo29212d());
                int i18 = i8;
                int i19 = 0;
                while (i18 < min && iVar.mo29201a(i18) == iVar2.mo29201a(i18)) {
                    i19++;
                    i18++;
                }
                long a4 = j + m3589a(fVar3) + ((long) 2) + ((long) i19) + 1;
                fVar3.writeInt(-i19);
                fVar3.writeInt(i5);
                int i20 = i8 + i19;
                while (i8 < i20) {
                    fVar3.writeInt((int) iVar.mo29201a(i8) & UByte.MAX_VALUE);
                    i8++;
                }
                if (i4 + 1 == i10) {
                    if (i20 == ((C2073i) list3.get(i4)).mo29212d()) {
                        fVar3.writeInt(list4.get(i4).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                C2068f fVar5 = new C2068f();
                fVar3.writeInt(((int) (m3589a(fVar5) + a4)) * -1);
                m3590a(a4, fVar5, i20, list, i4, i3, list2);
                fVar3.mo29135a((C1016z) fVar5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @JvmStatic
        /* renamed from: a */
        public final C2081q mo29233a(C2073i... iVarArr) {
            C2073i[] iVarArr2 = iVarArr;
            Intrinsics.checkParameterIsNotNull(iVarArr2, "byteStrings");
            int i = 0;
            if (iVarArr2.length == 0) {
                return new C2081q(new C2073i[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List mutableList = ArraysKt___ArraysKt.toMutableList((T[]) iVarArr);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(iVarArr2.length);
            for (C2073i iVar : iVarArr2) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
                int length = iVarArr2.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    mutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, (Comparable) iVarArr2[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                    i2++;
                    i3++;
                }
                if (((C2073i) mutableList.get(0)).mo29212d() > 0) {
                    int i4 = 0;
                    while (i4 < mutableList.size()) {
                        C2073i iVar2 = (C2073i) mutableList.get(i4);
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (i6 < mutableList.size()) {
                            C2073i iVar3 = (C2073i) mutableList.get(i6);
                            if (iVar3 != null) {
                                Intrinsics.checkParameterIsNotNull(iVar2, "prefix");
                                if (!iVar3.mo29205a(0, iVar2, 0, iVar2.mo29212d())) {
                                    continue;
                                    break;
                                }
                                if (!(iVar3.mo29212d() != iVar2.mo29212d())) {
                                    throw new IllegalArgumentException(("duplicate option: " + iVar3).toString());
                                } else if (((Number) mutableListOf.get(i6)).intValue() > ((Number) mutableListOf.get(i4)).intValue()) {
                                    mutableList.remove(i6);
                                    mutableListOf.remove(i6);
                                } else {
                                    i6++;
                                }
                            } else {
                                throw null;
                            }
                        }
                        i4 = i5;
                    }
                    C2068f fVar = new C2068f();
                    m3590a(0, fVar, 0, mutableList, 0, mutableList.size(), mutableListOf);
                    int[] iArr = new int[((int) m3589a(fVar))];
                    while (!fVar.mo29152c()) {
                        iArr[i] = fVar.readInt();
                        i++;
                    }
                    Object[] copyOf = Arrays.copyOf(iVarArr2, iVarArr2.length);
                    Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new C2081q((C2073i[]) copyOf, iArr, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}
