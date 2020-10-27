package p043jp.reifrontier.gym.p044ui.tab;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragmentHistory;", "", "()V", "stackArr", "", "", "emptyStack", "", "getStackSize", "isEmpty", "", "peek", "popPrevious", "push", "entry", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.tab.RFGFragmentHistory */
public final class RFGFragmentHistory {
    private List<Integer> stackArr = new ArrayList();

    public final void emptyStack() {
        this.stackArr.clear();
    }

    public final int getStackSize() {
        return this.stackArr.size();
    }

    public final boolean isEmpty() {
        return this.stackArr.size() == 0;
    }

    public final int peek() {
        if (isEmpty()) {
            return -1;
        }
        List<Integer> list = this.stackArr;
        return list.get(list.size() - 1).intValue();
    }

    public final int popPrevious() {
        if (this.stackArr.size() <= 1) {
            return 0;
        }
        int intValue = this.stackArr.get(this.stackArr.size() - 2).intValue();
        List<Integer> list = this.stackArr;
        list.remove(list.size() - 1);
        List<Integer> list2 = this.stackArr;
        list2.remove(list2.size() - 1);
        return intValue;
    }

    public final boolean push(int i) {
        if ((!this.stackArr.isEmpty()) && ((Number) CollectionsKt___CollectionsKt.last(this.stackArr)).intValue() == i) {
            return false;
        }
        this.stackArr.add(Integer.valueOf(i));
        return true;
    }
}
