/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.database.DataSetObserver
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.d;

public class ActivityChooserView
extends ViewGroup {
    final a a;
    final FrameLayout b;
    final FrameLayout c;
    androidx.core.h.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ac n;
    private boolean o;
    private int p;

    void a(int n2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public boolean a() {
        if (!this.c()) {
            if (!this.o) {
                return false;
            }
            this.g = false;
            this.a(this.h);
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.c()) {
            this.getListPopupWindow().c();
            ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.m);
            }
        }
        return true;
    }

    public boolean c() {
        return this.getListPopupWindow().d();
    }

    public d getDataModel() {
        return this.a.d();
    }

    ac getListPopupWindow() {
        if (this.n == null) {
            this.n = new ac(this.getContext());
            this.n.a((ListAdapter)this.a);
            this.n.b((View)this);
            this.n.a(true);
            this.n.a(this.i);
            this.n.a(this.i);
        }
        return this.n;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d d2 = this.a.d();
        if (d2 != null) {
            d2.registerObserver((Object)this.e);
        }
        this.o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d d2 = this.a.d();
        if (d2 != null) {
            d2.unregisterObserver((Object)this.e);
        }
        if ((d2 = this.getViewTreeObserver()).isAlive()) {
            d2.removeGlobalOnLayoutListener(this.m);
        }
        if (this.c()) {
            this.b();
        }
        this.o = false;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        this.j.layout(0, 0, n4 - n2, n5 - n3);
        if (!this.c()) {
            this.b();
        }
    }

    protected void onMeasure(int n2, int n3) {
        View view = this.j;
        int n4 = n3;
        if (this.c.getVisibility() != 0) {
            n4 = View.MeasureSpec.makeMeasureSpec((int)View.MeasureSpec.getSize((int)n3), (int)1073741824);
        }
        this.measureChild(view, n2, n4);
        this.setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(d d2) {
        this.a.a(d2);
        if (this.c()) {
            this.b();
            this.a();
        }
    }

    public void setDefaultActionButtonContentDescription(int n2) {
        this.p = n2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int n2) {
        String string2 = this.getContext().getString(n2);
        this.k.setContentDescription((CharSequence)string2);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable2) {
        this.k.setImageDrawable(drawable2);
    }

    public void setInitialActivityCount(int n2) {
        this.h = n2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setProvider(androidx.core.h.b b2) {
        this.d = b2;
    }

    public static class InnerLayout
    extends LinearLayout {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context object, AttributeSet attributeSet) {
            super((Context)object, attributeSet);
            object = ao.a((Context)object, attributeSet, a);
            this.setBackgroundDrawable(((ao)object).a(0));
            ((ao)object).a();
        }
    }

    private class a
    extends BaseAdapter {
        final /* synthetic */ ActivityChooserView a;
        private d b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public int a() {
            int n2 = this.c;
            this.c = Integer.MAX_VALUE;
            int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            int n5 = this.getCount();
            View view = null;
            int n6 = 0;
            for (int i2 = 0; i2 < n5; ++i2) {
                view = this.getView(i2, view, null);
                view.measure(n3, n4);
                n6 = Math.max(n6, view.getMeasuredWidth());
            }
            this.c = n2;
            return n6;
        }

        public void a(int n2) {
            if (this.c != n2) {
                this.c = n2;
                this.notifyDataSetChanged();
            }
        }

        public void a(d d2) {
            d d3 = this.a.a.d();
            if (d3 != null && this.a.isShown()) {
                d3.unregisterObserver((Object)this.a.e);
            }
            this.b = d2;
            if (d2 != null && this.a.isShown()) {
                d2.registerObserver((Object)this.a.e);
            }
            this.notifyDataSetChanged();
        }

        public void a(boolean bl2) {
            if (this.f != bl2) {
                this.f = bl2;
                this.notifyDataSetChanged();
            }
        }

        public void a(boolean bl2, boolean bl3) {
            if (this.d != bl2 || this.e != bl3) {
                this.d = bl2;
                this.e = bl3;
                this.notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.b.b();
        }

        public int c() {
            return this.b.a();
        }

        public d d() {
            return this.b;
        }

        public boolean e() {
            return this.d;
        }

        public int getCount() {
            int n2;
            int n3 = n2 = this.b.a();
            if (!this.d) {
                n3 = n2;
                if (this.b.b() != null) {
                    n3 = n2 - 1;
                }
            }
            n3 = n2 = Math.min(n3, this.c);
            if (this.f) {
                n3 = n2 + 1;
            }
            return n3;
        }

        public Object getItem(int n2) {
            switch (this.getItemViewType(n2)) {
                default: {
                    throw new IllegalArgumentException();
                }
                case 1: {
                    return null;
                }
                case 0: 
            }
            int n3 = n2;
            if (!this.d) {
                n3 = n2;
                if (this.b.b() != null) {
                    n3 = n2 + 1;
                }
            }
            return this.b.a(n3);
        }

        public long getItemId(int n2) {
            return n2;
        }

        public int getItemViewType(int n2) {
            return this.f && n2 == this.getCount() - 1;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public View getView(int n2, View view, ViewGroup viewGroup) {
            View view2;
            block10 : {
                block9 : {
                    switch (this.getItemViewType(n2)) {
                        default: {
                            throw new IllegalArgumentException();
                        }
                        case 1: {
                            View view3;
                            if (view != null) {
                                view3 = view;
                                if (view.getId() == 1) return view3;
                            }
                            view3 = LayoutInflater.from((Context)this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                            view3.setId(1);
                            ((TextView)view3.findViewById(a.f.title)).setText((CharSequence)this.a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                            return view3;
                        }
                        case 0: 
                    }
                    if (view == null) break block9;
                    view2 = view;
                    if (view.getId() == a.f.list_item) break block10;
                }
                view2 = LayoutInflater.from((Context)this.a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            view = this.a.getContext().getPackageManager();
            viewGroup = (ImageView)view2.findViewById(a.f.icon);
            ResolveInfo resolveInfo = (ResolveInfo)this.getItem(n2);
            viewGroup.setImageDrawable(resolveInfo.loadIcon((PackageManager)view));
            ((TextView)view2.findViewById(a.f.title)).setText(resolveInfo.loadLabel((PackageManager)view));
            if (this.d && n2 == 0 && this.e) {
                view2.setActivated(true);
                return view2;
            }
            view2.setActivated(false);
            return view2;
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b
    implements View.OnClickListener,
    View.OnLongClickListener,
    AdapterView.OnItemClickListener,
    PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView a;

        private void a() {
            if (this.a.f != null) {
                this.a.f.onDismiss();
            }
        }

        public void onClick(View view) {
            block7 : {
                block6 : {
                    block5 : {
                        if (view != this.a.c) break block5;
                        this.a.b();
                        view = this.a.a.b();
                        int n2 = this.a.a.d().a((ResolveInfo)view);
                        view = this.a.a.d().b(n2);
                        if (view != null) {
                            view.addFlags(524288);
                            this.a.getContext().startActivity((Intent)view);
                            return;
                        }
                        break block6;
                    }
                    if (view != this.a.b) break block7;
                    this.a.g = false;
                    this.a.a(this.a.h);
                }
                return;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            this.a();
            if (this.a.d != null) {
                this.a.d.a(false);
            }
        }

        public void onItemClick(AdapterView<?> intent, View view, int n2, long l2) {
            switch (((a)intent.getAdapter()).getItemViewType(n2)) {
                default: {
                    throw new IllegalArgumentException();
                }
                case 1: {
                    this.a.a(Integer.MAX_VALUE);
                    return;
                }
                case 0: 
            }
            this.a.b();
            if (this.a.g) {
                if (n2 > 0) {
                    this.a.a.d().c(n2);
                    return;
                }
            } else {
                if (!this.a.a.e()) {
                    ++n2;
                }
                intent = this.a.a.d().b(n2);
                if (intent != null) {
                    intent.addFlags(524288);
                    this.a.getContext().startActivity(intent);
                }
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.a.c) {
                if (this.a.a.getCount() > 0) {
                    this.a.g = true;
                    this.a.a(this.a.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

}

