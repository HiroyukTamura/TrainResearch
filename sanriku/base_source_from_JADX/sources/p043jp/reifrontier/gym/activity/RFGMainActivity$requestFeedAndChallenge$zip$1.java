package p043jp.reifrontier.gym.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1739b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\tH\n¢\u0006\u0002\b\f"}, mo21739d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "", "Lkotlin/collections/HashMap;", "feed", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "operationPair", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestFeedAndChallenge$zip$1 */
final class RFGMainActivity$requestFeedAndChallenge$zip$1<T1, T2, R> implements C1739b<RFGH2Client.H2APIResponse, Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<? extends RFGApiOperation>>, HashMap<String, List<? extends Object>>> {
    public static final RFGMainActivity$requestFeedAndChallenge$zip$1 INSTANCE = new RFGMainActivity$requestFeedAndChallenge$zip$1();

    RFGMainActivity$requestFeedAndChallenge$zip$1() {
    }

    public final HashMap<String, List<Object>> apply(RFGH2Client.H2APIResponse h2APIResponse, Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<RFGApiOperation>> pair) {
        List<RFGFeed> list;
        Intrinsics.checkParameterIsNotNull(h2APIResponse, "feed");
        Intrinsics.checkParameterIsNotNull(pair, "operationPair");
        HashMap<String, List<Object>> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (h2APIResponse.getCode() == 200 && (list = (List) h2APIResponse.getData()) != null) {
            for (RFGFeed rFGFeed : list) {
                if (rFGFeed.isWeight()) {
                    arrayList.add(rFGFeed);
                } else {
                    if (Intrinsics.areEqual((Object) rFGFeed.getSpecId(), (Object) RFGFeed.FeedType.REACH_METS.getSpecId())) {
                        RFGShared.INSTANCE.setMets(rFGFeed.getFeedCreateDate(), rFGFeed.extMets());
                    }
                    arrayList2.add(rFGFeed);
                }
            }
        }
        hashMap.put("weight", arrayList);
        hashMap.put("feeds", arrayList2);
        RFGRailroadClient.RailroadApiResult railroadApiResult = (RFGRailroadClient.RailroadApiResult) pair.component1();
        hashMap.put("operation", (List) pair.component2());
        if (railroadApiResult != RFGRailroadClient.RailroadApiResult.SUCCESS) {
            C1122a.m1599b("[Gym]::Error request operation error. result: " + railroadApiResult, new Object[0]);
        }
        return hashMap;
    }
}
