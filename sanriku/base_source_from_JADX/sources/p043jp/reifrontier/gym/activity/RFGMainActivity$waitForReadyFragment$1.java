package p043jp.reifrontier.gym.activity;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "run"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$waitForReadyFragment$1 */
final class RFGMainActivity$waitForReadyFragment$1 implements Runnable {
    final /* synthetic */ Function0 $doSomething;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ int $tryCount;
    final /* synthetic */ RFGMainActivity this$0;

    RFGMainActivity$waitForReadyFragment$1(RFGMainActivity rFGMainActivity, Fragment fragment, Function0 function0, int i) {
        this.this$0 = rFGMainActivity;
        this.$fragment = fragment;
        this.$doSomething = function0;
        this.$tryCount = i;
    }

    public final void run() {
        this.this$0.waitForReadyFragment(this.$fragment, this.$doSomething, this.$tryCount + 1);
    }
}
