package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo21739d2 = {"<anonymous>", "", "T", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends T>> {
    final /* synthetic */ Object[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        super(0);
        this.$this_withIndex = objArr;
    }

    public final Iterator<T> invoke() {
        return ArrayIteratorKt.iterator(this.$this_withIndex);
    }
}