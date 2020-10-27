package p043jp.reifrontier.gym.activity;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGEditActivity$setupEdit$4 */
final class RFGEditActivity$setupEdit$4 implements View.OnClickListener {
    final /* synthetic */ RFGEditActivity this$0;

    RFGEditActivity$setupEdit$4(RFGEditActivity rFGEditActivity) {
        this.this$0 = rFGEditActivity;
    }

    public final void onClick(View view) {
        this.this$0.closeKeyboard();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2092R.C2094id.editHeight);
        Intrinsics.checkExpressionValueIsNotNull(textView, "editHeight");
        CharSequence text = textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "editHeight.text");
        this.this$0.openBodySheet(RFGDef.BodyType.Height, (String) StringsKt__StringsKt.split$default(text, new String[]{"c"}, false, 0, 6, (Object) null).get(0));
    }
}
