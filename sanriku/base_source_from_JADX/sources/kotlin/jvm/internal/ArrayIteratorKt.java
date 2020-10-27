package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo21739d2 = {"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, mo21740k = 2, mo21741mv = {1, 1, 16})
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "array");
        return new ArrayIterator(tArr);
    }
}
