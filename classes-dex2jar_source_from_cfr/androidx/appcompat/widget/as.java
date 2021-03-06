/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.a;

class as {
    private final Context a;
    private final View b;
    private final TextView c;
    private final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
    private final Rect e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    as(Context context) {
        this.a = context;
        this.b = LayoutInflater.from((Context)this.a).inflate(a.g.abc_tooltip, null);
        this.c = (TextView)this.b.findViewById(a.f.message);
        this.d.setTitle((CharSequence)this.getClass().getSimpleName());
        this.d.packageName = this.a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = a.i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    private static View a(View view) {
        View view2 = view.getRootView();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams && ((WindowManager.LayoutParams)layoutParams).type == 2) {
            return view2;
        }
        view = view.getContext();
        while (view instanceof ContextWrapper) {
            if (view instanceof Activity) {
                return ((Activity)view).getWindow().getDecorView();
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return view2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(View arrn, int n2, int n3, boolean bl2, WindowManager.LayoutParams layoutParams) {
        int n4;
        layoutParams.token = arrn.getApplicationWindowToken();
        int n5 = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
        if (arrn.getWidth() < n5) {
            n2 = arrn.getWidth() / 2;
        }
        if (arrn.getHeight() >= n5) {
            n4 = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
            n5 = n3 + n4;
            n4 = n3 - n4;
            n3 = n5;
            n5 = n4;
        } else {
            n3 = arrn.getHeight();
            n5 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.a.getResources();
        n4 = bl2 ? a.d.tooltip_y_offset_touch : a.d.tooltip_y_offset_non_touch;
        int n6 = resources.getDimensionPixelOffset(n4);
        resources = as.a((View)arrn);
        if (resources == null) {
            Log.e((String)"TooltipPopup", (String)"Cannot find app view");
            return;
        }
        resources.getWindowVisibleDisplayFrame(this.e);
        if (this.e.left < 0 && this.e.top < 0) {
            Resources resources2 = this.a.getResources();
            n4 = resources2.getIdentifier("status_bar_height", "dimen", "android");
            n4 = n4 != 0 ? resources2.getDimensionPixelSize(n4) : 0;
            resources2 = resources2.getDisplayMetrics();
            this.e.set(0, n4, resources2.widthPixels, resources2.heightPixels);
        }
        resources.getLocationOnScreen(this.g);
        arrn.getLocationOnScreen(this.f);
        arrn = this.f;
        arrn[0] = arrn[0] - this.g[0];
        arrn = this.f;
        arrn[1] = arrn[1] - this.g[1];
        layoutParams.x = this.f[0] + n2 - resources.getWidth() / 2;
        n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        this.b.measure(n2, n2);
        n2 = this.b.getMeasuredHeight();
        n5 = this.f[1] + n5 - n6 - n2;
        n3 = this.f[1] + n3 + n6;
        if (bl2 ? n5 >= 0 : n2 + n3 > this.e.height()) {
            layoutParams.y = n5;
            return;
        }
        layoutParams.y = n3;
    }

    void a() {
        if (!this.b()) {
            return;
        }
        ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
    }

    void a(View view, int n2, int n3, boolean bl2, CharSequence charSequence) {
        if (this.b()) {
            this.a();
        }
        this.c.setText(charSequence);
        this.a(view, n2, n3, bl2, this.d);
        ((WindowManager)this.a.getSystemService("window")).addView(this.b, (ViewGroup.LayoutParams)this.d);
    }

    boolean b() {
        return this.b.getParent() != null;
    }
}

