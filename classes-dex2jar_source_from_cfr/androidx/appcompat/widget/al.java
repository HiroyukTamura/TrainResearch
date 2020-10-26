/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.appcompat.widget.an;
import androidx.appcompat.widget.at;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class al
extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<al>> b;
    private final Resources c;
    private final Resources.Theme d;

    private al(Context context) {
        super(context);
        if (at.a()) {
            this.c = new at((Context)this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new an((Context)this, context.getResources());
        this.d = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Context a(Context object) {
        if (!al.b(object)) {
            return object;
        }
        Object object2 = a;
        synchronized (object2) {
            if (b == null) {
                b = new ArrayList();
            } else {
                Object object3;
                int n2 = b.size() - 1;
                do {
                    if (n2 < 0) break;
                    object3 = b.get(n2);
                    if (object3 == null || object3.get() == null) {
                        b.remove(n2);
                    }
                    --n2;
                } while (true);
                for (n2 = al.b.size() - 1; n2 >= 0; --n2) {
                    object3 = b.get(n2);
                    object3 = object3 != null ? (al)((Object)object3.get()) : null;
                    if (object3 == null || object3.getBaseContext() != object) continue;
                    return object3;
                }
            }
            object = new al((Context)object);
            b.add(new WeakReference<Context>((Context)object));
            return object;
        }
    }

    private static boolean b(Context context) {
        boolean bl2;
        block4 : {
            block5 : {
                boolean bl3;
                boolean bl4 = context instanceof al;
                bl2 = bl3 = false;
                if (bl4) break block4;
                bl2 = bl3;
                if (context.getResources() instanceof an) break block4;
                if (context.getResources() instanceof at) {
                    return false;
                }
                if (Build.VERSION.SDK_INT < 21) break block5;
                bl2 = bl3;
                if (!at.a()) break block4;
            }
            bl2 = true;
        }
        return bl2;
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Resources.Theme getTheme() {
        if (this.d == null) {
            return super.getTheme();
        }
        return this.d;
    }

    public void setTheme(int n2) {
        if (this.d == null) {
            super.setTheme(n2);
            return;
        }
        this.d.applyStyle(n2, true);
    }
}

