package p043jp.reifrontier.gym.fragment;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.RFGUserChartData;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "left", "Ljp/reifrontier/gym/domain/api/RFGUserChartData;", "kotlin.jvm.PlatformType", "right", "compare"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGProfileFragment$bindChart$2 */
final class RFGProfileFragment$bindChart$2<T> implements Comparator<RFGUserChartData> {
    public static final RFGProfileFragment$bindChart$2 INSTANCE = new RFGProfileFragment$bindChart$2();

    RFGProfileFragment$bindChart$2() {
    }

    public final int compare(RFGUserChartData rFGUserChartData, RFGUserChartData rFGUserChartData2) {
        return Intrinsics.compare(rFGUserChartData2.ord(), rFGUserChartData.ord());
    }
}
