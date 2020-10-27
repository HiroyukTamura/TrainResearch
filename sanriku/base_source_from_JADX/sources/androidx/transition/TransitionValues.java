package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("TransitionValues@");
        a.append(Integer.toHexString(hashCode()));
        a.append(":\n");
        StringBuilder c = C0681a.m340c(a.toString(), "    view = ");
        c.append(this.view);
        c.append("\n");
        String a2 = C0681a.m320a(c.toString(), "    values:");
        for (String next : this.values.keySet()) {
            a2 = a2 + "    " + next + ": " + this.values.get(next) + "\n";
        }
        return a2;
    }
}
