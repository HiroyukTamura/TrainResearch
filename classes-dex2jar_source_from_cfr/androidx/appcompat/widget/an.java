/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.i;
import java.lang.ref.WeakReference;

class an
extends af {
    private final WeakReference<Context> a;

    public an(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference<Context>(context);
    }

    @Override
    public Drawable getDrawable(int n2) {
        Drawable drawable2 = super.getDrawable(n2);
        Context context = (Context)this.a.get();
        if (drawable2 != null && context != null) {
            i.a();
            i.a(context, n2, drawable2);
        }
        return drawable2;
    }
}

