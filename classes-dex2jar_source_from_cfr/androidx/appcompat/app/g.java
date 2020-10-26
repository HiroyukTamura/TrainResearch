/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.app.d;
import androidx.appcompat.app.e;
import androidx.appcompat.view.b;
import androidx.core.h.e;

public class g
extends Dialog
implements d {
    private e a;
    private final e.a b = new e.a(){

        @Override
        public boolean a(KeyEvent keyEvent) {
            return g.this.a(keyEvent);
        }
    };

    public g(Context context, int n2) {
        super(context, g.a(context, n2));
        this.a().a((Bundle)null);
        this.a().i();
    }

    private static int a(Context context, int n2) {
        int n3 = n2;
        if (n2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.a.dialogTheme, typedValue, true);
            n3 = typedValue.resourceId;
        }
        return n3;
    }

    public e a() {
        if (this.a == null) {
            this.a = e.a(this, (d)this);
        }
        return this.a;
    }

    @Override
    public b a(b.a a2) {
        return null;
    }

    @Override
    public void a(b b2) {
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().b(view, layoutParams);
    }

    @Override
    public void b(b b2) {
    }

    public boolean b(int n2) {
        return this.a().c(n2);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        return androidx.core.h.e.a(this.b, view, (Window.Callback)this, keyEvent);
    }

    public <T extends View> T findViewById(int n2) {
        return this.a().a(n2);
    }

    public void invalidateOptionsMenu() {
        this.a().f();
    }

    protected void onCreate(Bundle bundle) {
        this.a().h();
        super.onCreate(bundle);
        this.a().a(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.a().d();
    }

    public void setContentView(int n2) {
        this.a().b(n2);
    }

    public void setContentView(View view) {
        this.a().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().a(view, layoutParams);
    }

    public void setTitle(int n2) {
        super.setTitle(n2);
        this.a().a(this.getContext().getString(n2));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a().a(charSequence);
    }

}

