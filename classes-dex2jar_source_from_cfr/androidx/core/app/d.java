/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.c.g;
import androidx.core.h.e;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.t;

public class d
extends Activity
implements e.a,
j {
    private g<Class<? extends Object>, Object> a = new g();
    private k b = new k(this);

    @Override
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view != null && e.a(view, keyEvent)) {
            return true;
        }
        return e.a(this, view, (Window.Callback)this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view != null && e.a(view, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override
    public androidx.lifecycle.g g() {
        return this.b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.a(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(g.b.c);
        super.onSaveInstanceState(bundle);
    }
}

