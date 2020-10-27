package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo21739d2 = {"jp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedEditText$setUpEdit$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedEditText$setUpEdit$3 */
public final class RFGAutoCompletedEditText$setUpEdit$3 implements TextWatcher {
    final /* synthetic */ RFGAutoCompletedEditText this$0;

    RFGAutoCompletedEditText$setUpEdit$3(RFGAutoCompletedEditText rFGAutoCompletedEditText) {
        this.this$0 = rFGAutoCompletedEditText;
    }

    public void afterTextChanged(Editable editable) {
        String str;
        RFGAutoCompletedAdapter adapter = this.this$0.getAdapter();
        if (editable == null || (str = editable.toString()) == null) {
            str = "";
        }
        adapter.updateFilterText(str);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
