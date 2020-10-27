package p043jp.reifrontier.gym.activity;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.domain.api.RFGResponse;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGPasswordActivity$requestResetPassword$1 */
final class RFGPasswordActivity$requestResetPassword$1<T> implements C1741d<RFGH2Client.H2APIResponse> {
    final /* synthetic */ RFGPasswordActivity this$0;

    RFGPasswordActivity$requestResetPassword$1(RFGPasswordActivity rFGPasswordActivity) {
        this.this$0 = rFGPasswordActivity;
    }

    public final void accept(RFGH2Client.H2APIResponse h2APIResponse) {
        RFGPasswordActivity rFGPasswordActivity;
        String str;
        if (h2APIResponse.getCode() == 200) {
            Object data = h2APIResponse.getData();
            if (data != null) {
                RFGResponse rFGResponse = (RFGResponse) data;
                String str2 = "resources.getString(R.string.password_reset_error)";
                if (rFGResponse.getResult() == null || !Intrinsics.areEqual((Object) rFGResponse.getResult(), (Object) FirebaseAnalytics.Param.SUCCESS)) {
                    this.this$0.stopLoading();
                    this.this$0.isLoading = false;
                    rFGPasswordActivity = this.this$0;
                    str = rFGPasswordActivity.getResources().getString(R.string.password_reset_error);
                } else {
                    this.this$0.stopLoading();
                    this.this$0.isLoading = false;
                    rFGPasswordActivity = this.this$0;
                    str = rFGPasswordActivity.getResources().getString(R.string.password_reset_success);
                    str2 = "resources.getString(R.st…g.password_reset_success)";
                }
                Intrinsics.checkExpressionValueIsNotNull(str, str2);
                rFGPasswordActivity.errorDialog(str);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.api.RFGResponse");
        }
    }
}
