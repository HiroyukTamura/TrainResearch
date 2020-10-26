/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package androidx.databinding.b.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.c;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.List;

public class a
extends c {
    private static final SparseIntArray a = new SparseIntArray(0);

    @Override
    public ViewDataBinding a(e e2, View view, int n2) {
        if (a.get(n2) > 0 && view.getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override
    public ViewDataBinding a(e e2, View[] arrview, int n2) {
        if (arrview != null) {
            if (arrview.length == 0) {
                return null;
            }
            if (a.get(n2) > 0) {
                if (arrview[0].getTag() != null) {
                    return null;
                }
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    @Override
    public List<c> a() {
        return new ArrayList<c>(0);
    }
}

