package p043jp.reifrontier.silentlogsdkandroid.daily;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo21739d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader$removeLocalSegmentsFromServer$$inlined$sortBy$1 */
public final class RFLDailyLoader$removeLocalSegmentsFromServer$$inlined$sortBy$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        String str = (String) t;
        Intrinsics.checkExpressionValueIsNotNull(str, "t");
        Integer valueOf = Integer.valueOf(Integer.parseInt(str));
        String str2 = (String) t2;
        Intrinsics.checkExpressionValueIsNotNull(str2, "t");
        return ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(Integer.parseInt(str2)));
    }
}