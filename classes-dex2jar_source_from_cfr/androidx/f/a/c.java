/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.Window
 */
package androidx.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.f.a.h;
import androidx.f.a.i;
import androidx.f.a.p;

public class c
extends d
implements DialogInterface.OnCancelListener,
DialogInterface.OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public void a() {
        this.a(false);
    }

    public void a(Dialog dialog, int n2) {
        switch (n2) {
            default: {
                return;
            }
            case 3: {
                dialog.getWindow().addFlags(24);
            }
            case 1: 
            case 2: 
        }
        dialog.requestWindowFeature(1);
    }

    @Override
    public void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        boolean bl2 = this.I == 0;
        this.d = bl2;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public void a(i object, String string2) {
        this.h = false;
        this.i = true;
        object = ((i)object).a();
        ((p)object).a(this, string2);
        ((p)object).d();
    }

    void a(boolean bl2) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i = false;
        if (this.f != null) {
            this.f.dismiss();
        }
        this.g = true;
        if (this.e >= 0) {
            this.r().a(this.e, 1);
            this.e = -1;
            return;
        }
        p p2 = this.r().a();
        p2.a(this);
        if (bl2) {
            p2.e();
            return;
        }
        p2.d();
    }

    public Dialog b() {
        return this.f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = this.c(bundle);
        if (this.f != null) {
            this.a(this.f, this.a);
            bundle = this.f.getContext();
            do {
                return (LayoutInflater)bundle.getSystemService("layout_inflater");
                break;
            } while (true);
        }
        bundle = this.C.g();
        return (LayoutInflater)bundle.getSystemService("layout_inflater");
    }

    public int c() {
        return this.b;
    }

    public Dialog c(Bundle bundle) {
        return new Dialog((Context)this.o(), this.c());
    }

    @Override
    public void d() {
        super.d();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    @Override
    public void d(Bundle bundle) {
        super.d(bundle);
        if (!this.d) {
            return;
        }
        Object object = this.y();
        if (object != null) {
            if (object.getParent() == null) {
                this.f.setContentView(object);
            } else {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
        if ((object = this.o()) != null) {
            this.f.setOwnerActivity((Activity)object);
        }
        this.f.setCancelable(this.c);
        this.f.setOnCancelListener((DialogInterface.OnCancelListener)this);
        this.f.setOnDismissListener((DialogInterface.OnDismissListener)this);
        if (bundle != null && (bundle = bundle.getBundle("android:savedDialogState")) != null) {
            this.f.onRestoreInstanceState(bundle);
        }
    }

    @Override
    public void e() {
        super.e();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    @Override
    public void e(Bundle bundle) {
        Bundle bundle2;
        super.e(bundle);
        if (this.f != null && (bundle2 = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundle2);
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    @Override
    public void f() {
        super.f();
        if (this.f != null) {
            this.f.hide();
        }
    }

    @Override
    public void h() {
        super.h();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            this.a(true);
        }
    }
}

