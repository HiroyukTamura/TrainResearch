/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import java.util.Collections;
import java.util.List;

public abstract class c {
    public abstract ViewDataBinding a(e var1, View var2, int var3);

    public abstract ViewDataBinding a(e var1, View[] var2, int var3);

    public List<c> a() {
        return Collections.emptyList();
    }
}

