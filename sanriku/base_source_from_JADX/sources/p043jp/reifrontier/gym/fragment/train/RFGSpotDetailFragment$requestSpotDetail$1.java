package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;
import kotlin.Pair;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;
import p043jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotDetailFragment$requestSpotDetail$1 */
final class RFGSpotDetailFragment$requestSpotDetail$1<T> implements C1741d<Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends RFGContent>> {
    public static final RFGSpotDetailFragment$requestSpotDetail$1 INSTANCE = new RFGSpotDetailFragment$requestSpotDetail$1();

    RFGSpotDetailFragment$requestSpotDetail$1() {
    }

    public final void accept(Pair<? extends RFGRailroadClient.RailroadApiResult, RFGContent> pair) {
        C1126c.m1638c().mo21903a((Object) new RFGSpotDetailFragment.OnCompletedSpotDetailRequest((RFGRailroadClient.RailroadApiResult) pair.component1(), pair.component2()));
    }
}
