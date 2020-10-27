package p043jp.reifrontier.gym.p044ui.adapter;

import android.net.Uri;
import android.view.View;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p028d.p061c.p062a.C1562e;
import p009e.p028d.p061c.p062a.p063g.C1566a;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGOperationAdapter$instantiateItem$1 */
final class RFGOperationAdapter$instantiateItem$1 implements View.OnClickListener {
    final /* synthetic */ RFGOperationAdapter this$0;

    RFGOperationAdapter$instantiateItem$1(RFGOperationAdapter rFGOperationAdapter) {
        this.this$0 = rFGOperationAdapter;
    }

    public final void onClick(View view) {
        TrustedWebActivityIntentBuilder toolbarColor = new TrustedWebActivityIntentBuilder(Uri.parse(BuildConfig.URL_DELAY)).setToolbarColor(ContextCompat.getColor(this.this$0.context, R.color.sanriku_blue));
        Intrinsics.checkExpressionValueIsNotNull(toolbarColor, "TrustedWebActivityIntent…t, R.color.sanriku_blue))");
        new C1562e(this.this$0.context).mo27330b(toolbarColor, (C1566a) null, (Runnable) null);
    }
}
