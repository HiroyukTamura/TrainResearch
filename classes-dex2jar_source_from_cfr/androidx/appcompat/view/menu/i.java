/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.Drawable
 *  android.os.IBinder
 *  android.view.KeyEvent
 *  android.view.KeyEvent$DispatcherState
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ListAdapter
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;

class i
implements DialogInterface.OnClickListener,
DialogInterface.OnDismissListener,
DialogInterface.OnKeyListener,
o.a {
    f a;
    private h b;
    private b c;
    private o.a d;

    public i(h h2) {
        this.b = h2;
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        h h2 = this.b;
        b.a a2 = new b.a(h2.f());
        this.a = new f(a2.a(), a.g.abc_list_menu_item_layout);
        this.a.a(this);
        this.b.a(this.a);
        a2.a(this.a.a(), (DialogInterface.OnClickListener)this);
        View view = h2.p();
        if (view != null) {
            a2.a(view);
        } else {
            a2.a(h2.o()).a(h2.n());
        }
        a2.a(this);
        this.c = a2.b();
        this.c.setOnDismissListener((DialogInterface.OnDismissListener)this);
        h2 = this.c.getWindow().getAttributes();
        ((WindowManager.LayoutParams)h2).type = 1003;
        if (iBinder != null) {
            ((WindowManager.LayoutParams)h2).token = iBinder;
        }
        ((WindowManager.LayoutParams)h2).flags |= 131072;
        this.c.show();
    }

    @Override
    public void a(h h2, boolean bl2) {
        if (bl2 || h2 == this.b) {
            this.a();
        }
        if (this.d != null) {
            this.d.a(h2, bl2);
        }
    }

    @Override
    public boolean a(h h2) {
        if (this.d != null) {
            return this.d.a(h2);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.b.a((j)this.a.a().getItem(n2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int n2, KeyEvent keyEvent) {
        if (n2 == 82 || n2 == 4) {
            Window window;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                dialogInterface = this.c.getWindow();
                if (dialogInterface != null && (dialogInterface = dialogInterface.getDecorView()) != null && (dialogInterface = dialogInterface.getKeyDispatcherState()) != null) {
                    dialogInterface.startTracking(keyEvent, (Object)this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (window = window.getDecorView()) != null && (window = window.getKeyDispatcherState()) != null && window.isTracking(keyEvent)) {
                this.b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(n2, keyEvent, 0);
    }
}

