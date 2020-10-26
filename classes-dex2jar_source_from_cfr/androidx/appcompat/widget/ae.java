/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.transition.Transition
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.y;
import java.lang.reflect.Method;

public class ae
extends ac
implements ad {
    private static Method a;
    private ad b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        Log.i((String)"MenuPopupWindow", (String)"Could not find method setTouchModal() on PopupWindow. Oh well.");
    }

    public ae(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
    }

    @Override
    y a(Context object, boolean bl2) {
        object = new a((Context)object, bl2);
        ((a)((Object)object)).setHoverListener(this);
        return object;
    }

    @Override
    public void a(h h2, MenuItem menuItem) {
        if (this.b != null) {
            this.b.a(h2, menuItem);
        }
    }

    public void a(ad ad2) {
        this.b = ad2;
    }

    public void a(Object object) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition)object);
        }
    }

    @Override
    public void b(h h2, MenuItem menuItem) {
        if (this.b != null) {
            this.b.b(h2, menuItem);
        }
    }

    public void b(Object object) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(boolean bl2) {
        if (a != null) {
            try {
                a.invoke((Object)this.g, bl2);
                return;
            }
            catch (Exception exception) {}
            Log.i((String)"MenuPopupWindow", (String)"Could not invoke setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public static class a
    extends y {
        final int b;
        final int c;
        private ad d;
        private MenuItem e;

        public a(Context context, boolean bl2) {
            super(context, bl2);
            context = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == context.getLayoutDirection()) {
                this.b = 21;
                this.c = 22;
                return;
            }
            this.b = 22;
            this.c = 21;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.d != null) {
                void var4_11;
                void var4_5;
                int n2;
                MenuItem menuItem;
                ListAdapter listAdapter = this.getAdapter();
                if (listAdapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)listAdapter;
                    n2 = headerViewListAdapter.getHeadersCount();
                    ListAdapter listAdapter2 = headerViewListAdapter.getWrappedAdapter();
                } else {
                    n2 = 0;
                }
                Object object = (g)var4_5;
                MenuItem menuItem2 = menuItem = null;
                if (motionEvent.getAction() != 10) {
                    int n3 = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
                    MenuItem menuItem3 = menuItem;
                    if (n3 != -1) {
                        n2 = n3 - n2;
                        MenuItem menuItem4 = menuItem;
                        if (n2 >= 0) {
                            MenuItem menuItem5 = menuItem;
                            if (n2 < ((g)((Object)object)).getCount()) {
                                j j2 = ((g)((Object)object)).a(n2);
                            }
                        }
                    }
                }
                if ((menuItem = this.e) != var4_11) {
                    object = ((g)((Object)object)).a();
                    if (menuItem != null) {
                        this.d.a((h)object, menuItem);
                    }
                    this.e = var4_11;
                    if (var4_11 != null) {
                        this.d.b((h)object, (MenuItem)var4_11);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int n2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
            if (listMenuItemView != null && n2 == this.b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    this.performItemClick((View)listMenuItemView, this.getSelectedItemPosition(), this.getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && n2 == this.c) {
                this.setSelection(-1);
                ((g)this.getAdapter()).a().a(false);
                return true;
            }
            return super.onKeyDown(n2, keyEvent);
        }

        public void setHoverListener(ad ad2) {
            this.d = ad2;
        }
    }

}

