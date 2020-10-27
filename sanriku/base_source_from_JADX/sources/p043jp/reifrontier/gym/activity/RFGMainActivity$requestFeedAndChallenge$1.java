package p043jp.reifrontier.gym.activity;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012`\u0010\u0002\u001a\\\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \b*.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u00070\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007H\n¢\u0006\u0002\b\t"}, mo21739d2 = {"<anonymous>", "", "it", "Ljava/util/HashMap;", "", "", "", "Lkotlin/collections/HashMap;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestFeedAndChallenge$1 */
final class RFGMainActivity$requestFeedAndChallenge$1<T> implements C1741d<HashMap<String, List<? extends Object>>> {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$requestFeedAndChallenge$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public final void accept(HashMap<String, List<Object>> hashMap) {
        this.this$0.stopLoading();
        RFGMainActivity rFGMainActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(hashMap, "it");
        rFGMainActivity.bindChallengesAndActivitiesAndFeeds(hashMap);
        this.this$0.checkLoginBonus();
    }
}
