package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\b¨\u0006\u0003"}, mo21739d2 = {"hashCode", "", "", "kotlin-stdlib"}, mo21740k = 2, mo21741mv = {1, 1, 16})
public final class HashCodeKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
