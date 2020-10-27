package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, mo21739d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, mo21740k = 5, mo21741mv = {1, 1, 16}, mo21743xi = 1, mo21744xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final <T> List<T> asReversed(List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$asReversed");
        return new ReversedListReadOnly(list);
    }

    @JvmName(name = "asReversedMutable")
    public static final <T> List<T> asReversedMutable(List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$asReversed");
        return new ReversedList(list);
    }

    /* access modifiers changed from: private */
    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return CollectionsKt__CollectionsKt.getLastIndex(list) - i;
        }
        StringBuilder b = C0681a.m338b("Element index ", i, " must be in range [");
        b.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)));
        b.append("].");
        throw new IndexOutOfBoundsException(b.toString());
    }

    /* access modifiers changed from: private */
    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder b = C0681a.m338b("Position index ", i, " must be in range [");
        b.append(new IntRange(0, list.size()));
        b.append("].");
        throw new IndexOutOfBoundsException(b.toString());
    }
}