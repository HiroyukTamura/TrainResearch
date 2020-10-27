package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.p044ui.widget.autocompleted.RFGAutoCompletedAdapter;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedEditText$setUpList$1 */
final class RFGAutoCompletedEditText$setUpList$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ RFGAutoCompletedEditText this$0;

    RFGAutoCompletedEditText$setUpList$1(RFGAutoCompletedEditText rFGAutoCompletedEditText) {
        this.this$0 = rFGAutoCompletedEditText;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) this.this$0.getAdapter().getItem(i);
        if (str != null) {
            Intrinsics.checkExpressionValueIsNotNull(str, "adapter.getItem(position…rn@setOnItemClickListener");
            boolean isAlwaysShow = this.this$0.getAdapter().isAlwaysShow(str);
            ArrayList arrayList = new ArrayList();
            if (!isAlwaysShow) {
                RFGAutoCompletedAdapter.RFGHintData hintData = this.this$0.getAdapter().getHintData(i);
                if (hintData != null) {
                    arrayList.add(hintData);
                }
                this.this$0.setText(str);
            }
            this.this$0.hideKeyboard();
            this.this$0.hideDropDown();
            Function3<String, List<RFGAutoCompletedAdapter.RFGHintData>, Boolean, Unit> onDoneListener = this.this$0.getOnDoneListener();
            if (onDoneListener != null) {
                Unit invoke = onDoneListener.invoke(str, arrayList, Boolean.valueOf(isAlwaysShow));
            }
        }
    }
}
