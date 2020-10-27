package p040i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import p040i.p103M.C1764b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006("}, mo21739d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.y */
public final class C1952y implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: b */
    public static final C1954b f2848b = new C1954b((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String[] f2849a;

    /* renamed from: i.y$a */
    public static final class C1953a {

        /* renamed from: a */
        private final List<String> f2850a = new ArrayList(20);

        /* renamed from: a */
        public final C1953a mo28122a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "line");
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', 1, false, 4, (Object) null);
            if (indexOf$default != -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                mo28125b(substring, substring2);
            } else {
                if (str.charAt(0) == ':') {
                    str = str.substring(1);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
                }
                mo28125b("", str);
            }
            return this;
        }

        /* renamed from: a */
        public final C1953a mo28123a(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            C1952y.f2848b.m3384a(str);
            C1952y.f2848b.m3385a(str2, str);
            mo28125b(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C1952y mo28124a() {
            Object[] array = this.f2850a.toArray(new String[0]);
            if (array != null) {
                return new C1952y((String[]) array, (DefaultConstructorMarker) null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* renamed from: b */
        public final C1953a mo28125b(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2850a.add(str);
            this.f2850a.add(StringsKt__StringsKt.trim((CharSequence) str2).toString());
            return this;
        }

        /* renamed from: b */
        public final String mo28126b(String str) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.downTo(this.f2850a.size() - 2, 0), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return null;
                }
            } else if (first < last) {
                return null;
            }
            while (!StringsKt__StringsJVMKt.equals(str, this.f2850a.get(first), true)) {
                if (first == last) {
                    return null;
                }
                first += step2;
            }
            return this.f2850a.get(first + 1);
        }

        /* renamed from: b */
        public final List<String> mo28127b() {
            return this.f2850a;
        }

        /* renamed from: c */
        public final C1953a mo28128c(String str) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int i = 0;
            while (i < this.f2850a.size()) {
                if (StringsKt__StringsJVMKt.equals(str, this.f2850a.get(i), true)) {
                    this.f2850a.remove(i);
                    this.f2850a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public final C1953a mo28129c(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            C1952y.f2848b.m3384a(str);
            C1952y.f2848b.m3385a(str2, str);
            mo28128c(str);
            mo28125b(str, str2);
            return this;
        }
    }

    /* renamed from: i.y$b */
    public static final class C1954b {
        public /* synthetic */ C1954b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m3384a(String str) {
            if (str.length() > 0) {
                int length = str.length();
                int i = 0;
                while (i < length) {
                    char charAt = str.charAt(i);
                    if ('!' <= charAt && '~' >= charAt) {
                        i++;
                    } else {
                        throw new IllegalArgumentException(C1764b.m2621a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m3385a(String str, String str2) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == 9 || (' ' <= charAt && '~' >= charAt)) {
                    i++;
                } else {
                    throw new IllegalArgumentException(C1764b.m2621a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        @JvmStatic
        @JvmName(name = "of")
        /* renamed from: a */
        public final C1952y mo28130a(String... strArr) {
            Intrinsics.checkParameterIsNotNull(strArr, "namesAndValues");
            if (strArr.length % 2 == 0) {
                Object clone = strArr.clone();
                if (clone != null) {
                    String[] strArr2 = (String[]) clone;
                    int length = strArr2.length;
                    int i = 0;
                    while (i < length) {
                        if (strArr2[i] != null) {
                            String str = strArr2[i];
                            if (str != null) {
                                strArr2[i] = StringsKt__StringsKt.trim((CharSequence) str).toString();
                                i++;
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            throw new IllegalArgumentException("Headers cannot be null".toString());
                        }
                    }
                    IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, strArr2.length), 2);
                    int first = step.getFirst();
                    int last = step.getLast();
                    int step2 = step.getStep();
                    if (step2 < 0 ? first >= last : first <= last) {
                        while (true) {
                            String str2 = strArr2[first];
                            String str3 = strArr2[first + 1];
                            m3384a(str2);
                            m3385a(str3, str2);
                            if (first == last) {
                                break;
                            }
                            first += step2;
                        }
                    }
                    return new C1952y(strArr2, (DefaultConstructorMarker) null);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    public /* synthetic */ C1952y(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2849a = strArr;
    }

    /* renamed from: a */
    public final C1953a mo28112a() {
        C1953a aVar = new C1953a();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(aVar.mo28127b(), (T[]) this.f2849a);
        return aVar;
    }

    /* renamed from: a */
    public final String mo28113a(int i) {
        return this.f2849a[i * 2];
    }

    /* renamed from: a */
    public final List<String> mo28114a(String str) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (StringsKt__StringsJVMKt.equals(str, mo28113a(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo28115b(i));
            }
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    /* renamed from: b */
    public final String mo28115b(int i) {
        return this.f2849a[(i * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1952y) && Arrays.equals(this.f2849a, ((C1952y) obj).f2849a);
    }

    public final String get(String str) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        String[] strArr = this.f2849a;
        IntProgression step = RangesKt___RangesKt.step(RangesKt___RangesKt.downTo(strArr.length - 2, 0), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 >= 0) {
            if (first > last) {
                return null;
            }
        } else if (first < last) {
            return null;
        }
        while (!StringsKt__StringsJVMKt.equals(str, strArr[first], true)) {
            if (first == last) {
                return null;
            }
            first += step2;
        }
        return strArr[first + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2849a);
    }

    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.m4300to(mo28113a(i), mo28115b(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    @JvmName(name = "size")
    public final int size() {
        return this.f2849a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(mo28113a(i));
            sb.append(": ");
            sb.append(mo28115b(i));
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
