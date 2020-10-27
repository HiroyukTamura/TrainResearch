package p043jp.reifrontier.gym.activity;

import android.view.View;
import kotlin.Metadata;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$setupTerms$1 */
final class RFGInitActivity$setupTerms$1 implements View.OnClickListener {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$setupTerms$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void onClick(View view) {
        this.this$0.isTermsTap = true;
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "001", "001a", (String) null, 4, (Object) null);
        this.this$0.openLink(BuildConfig.URL_TERMS);
    }
}
