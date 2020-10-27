package p043jp.reifrontier.gym.activity;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo21739d2 = {"jp/reifrontier/gym/activity/RFGMainActivity$mOnNavigationItemSelectedListener$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$mOnNavigationItemSelectedListener$1 */
public final class RFGMainActivity$mOnNavigationItemSelectedListener$1 implements TabLayout.C1208c {
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$mOnNavigationItemSelectedListener$1(RFGMainActivity rFGMainActivity) {
        this.this$0 = rFGMainActivity;
    }

    public void onTabReselected(TabLayout.C1213f fVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "tab");
    }

    public void onTabSelected(TabLayout.C1213f fVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "tab");
        this.this$0.getFragmentHistory().push(fVar.mo25546c());
        this.this$0.switchTab(fVar.mo25546c());
    }

    public void onTabUnselected(TabLayout.C1213f fVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "tab");
    }
}
