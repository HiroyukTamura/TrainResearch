/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.ListAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.g;

public class b
extends g
implements DialogInterface {
    final AlertController a = new AlertController(this.getContext(), this, this.getWindow());

    protected b(Context context, int n2) {
        super(context, b.a(context, n2));
    }

    static int a(Context context, int n2) {
        if ((n2 >>> 24 & 255) >= 1) {
            return n2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button a(int n2) {
        return this.a.d(n2);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (this.a.a(n2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(n2, keyEvent);
    }

    public boolean onKeyUp(int n2, KeyEvent keyEvent) {
        if (this.a.b(n2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(n2, keyEvent);
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }

    public static class a {
        private final AlertController.a a;
        private final int b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int n2) {
            this.a = new AlertController.a((Context)new ContextThemeWrapper(context, b.a(context, n2)));
            this.b = n2;
        }

        public Context a() {
            return this.a.a;
        }

        public a a(int n2) {
            this.a.f = this.a.a.getText(n2);
            return this;
        }

        public a a(int n2, DialogInterface.OnClickListener onClickListener) {
            this.a.i = this.a.a.getText(n2);
            this.a.k = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a a(Drawable drawable2) {
            this.a.d = drawable2;
            return this;
        }

        public a a(View view) {
            this.a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.a.w = listAdapter;
            this.a.x = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.i = charSequence;
            this.a.k = onClickListener;
            return this;
        }

        public a b(int n2) {
            this.a.h = this.a.a.getText(n2);
            return this;
        }

        public a b(int n2, DialogInterface.OnClickListener onClickListener) {
            this.a.l = this.a.a.getText(n2);
            this.a.n = onClickListener;
            return this;
        }

        public a b(View view) {
            this.a.z = view;
            this.a.y = 0;
            this.a.E = false;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.l = charSequence;
            this.a.n = onClickListener;
            return this;
        }

        public b b() {
            b b2 = new b(this.a.a, this.b);
            this.a.a(b2.a);
            b2.setCancelable(this.a.r);
            if (this.a.r) {
                b2.setCanceledOnTouchOutside(true);
            }
            b2.setOnCancelListener(this.a.s);
            b2.setOnDismissListener(this.a.t);
            if (this.a.u != null) {
                b2.setOnKeyListener(this.a.u);
            }
            return b2;
        }
    }

}

