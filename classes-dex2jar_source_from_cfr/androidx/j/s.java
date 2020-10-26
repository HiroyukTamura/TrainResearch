/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.j;

import android.view.View;
import androidx.j.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class s {
    public final Map<String, Object> a = new HashMap<String, Object>();
    public View b;
    final ArrayList<m> c = new ArrayList();

    public boolean equals(Object object) {
        if (object instanceof s) {
            View view = this.b;
            object = (s)object;
            if (view == ((s)object).b && this.a.equals(((s)object).a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode() * 31 + this.a.hashCode();
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("TransitionValues@");
        charSequence.append(Integer.toHexString(this.hashCode()));
        charSequence.append(":\n");
        charSequence = charSequence.toString();
        Object object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append("    view = ");
        ((StringBuilder)object).append((Object)this.b);
        ((StringBuilder)object).append("\n");
        charSequence = ((StringBuilder)object).toString();
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append("    values:");
        charSequence = ((StringBuilder)object).toString();
        for (String string2 : this.a.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append("    ");
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(this.a.get(string2));
            stringBuilder.append("\n");
            charSequence = stringBuilder.toString();
        }
        return charSequence;
    }
}

