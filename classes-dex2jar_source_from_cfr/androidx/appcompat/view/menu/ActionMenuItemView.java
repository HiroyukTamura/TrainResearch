/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.aa;

public class ActionMenuItemView
extends AppCompatTextView
implements View.OnClickListener,
p.a,
ActionMenuView.a {
    j a;
    h.b b;
    b c;
    private CharSequence e;
    private Drawable f;
    private aa g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        Resources resources = context.getResources();
        this.h = this.e();
        context = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, n2, 0);
        this.j = context.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.l = (int)(resources.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener((View.OnClickListener)this);
        this.k = -1;
        this.setSaveEnabled(false);
    }

    private boolean e() {
        Configuration configuration = this.getContext().getResources().getConfiguration();
        int n2 = configuration.screenWidthDp;
        int n3 = configuration.screenHeightDp;
        return n2 >= 480 || n2 >= 640 && n3 >= 480 || configuration.orientation == 2;
        {
        }
    }

    /*
     * Exception decompiling
     */
    private void f() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:226)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:576)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void a(j j2, int n2) {
        this.a = j2;
        this.setIcon(j2.getIcon());
        this.setTitle(j2.a(this));
        this.setId(j2.getItemId());
        n2 = j2.isVisible() ? 0 : 8;
        this.setVisibility(n2);
        this.setEnabled(j2.isEnabled());
        if (j2.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    @Override
    public boolean a() {
        return true;
    }

    public boolean b() {
        return TextUtils.isEmpty((CharSequence)this.getText()) ^ true;
    }

    @Override
    public boolean c() {
        return this.b() && this.a.getIcon() == null;
    }

    @Override
    public boolean d() {
        return this.b();
    }

    @Override
    public j getItemData() {
        return this.a;
    }

    public void onClick(View view) {
        if (this.b != null) {
            this.b.a(this.a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = this.e();
        this.f();
    }

    @Override
    protected void onMeasure(int n2, int n3) {
        boolean bl2 = this.b();
        if (bl2 && this.k >= 0) {
            super.setPadding(this.k, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        super.onMeasure(n2, n3);
        int n4 = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        int n5 = this.getMeasuredWidth();
        n2 = n4 == Integer.MIN_VALUE ? Math.min(n2, this.j) : this.j;
        if (n4 != 1073741824 && this.j > 0 && n5 < n2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824), n3);
        }
        if (!bl2 && this.f != null) {
            super.setPadding((this.getMeasuredWidth() - this.f.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a.hasSubMenu() && this.g != null && this.g.onTouch((View)this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean bl2) {
    }

    public void setChecked(boolean bl2) {
    }

    public void setExpandedFormat(boolean bl2) {
        if (this.i != bl2) {
            this.i = bl2;
            if (this.a != null) {
                this.a.h();
            }
        }
    }

    public void setIcon(Drawable drawable2) {
        this.f = drawable2;
        if (drawable2 != null) {
            float f2;
            int n2 = drawable2.getIntrinsicWidth();
            int n3 = drawable2.getIntrinsicHeight();
            int n4 = n2;
            int n5 = n3;
            if (n2 > this.l) {
                f2 = (float)this.l / (float)n2;
                n4 = this.l;
                n5 = (int)((float)n3 * f2);
            }
            n2 = n4;
            n3 = n5;
            if (n5 > this.l) {
                f2 = (float)this.l / (float)n5;
                n3 = this.l;
                n2 = (int)((float)n4 * f2);
            }
            drawable2.setBounds(0, 0, n2, n3);
        }
        this.setCompoundDrawables(drawable2, null, null, null);
        this.f();
    }

    public void setItemInvoker(h.b b2) {
        this.b = b2;
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
        this.k = n2;
        super.setPadding(n2, n3, n4, n5);
    }

    public void setPopupCallback(b b2) {
        this.c = b2;
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f();
    }

    private class a
    extends aa {
        public a() {
            super((View)ActionMenuItemView.this);
        }

        @Override
        public s a() {
            if (ActionMenuItemView.this.c != null) {
                return ActionMenuItemView.this.c.a();
            }
            return null;
        }

        @Override
        protected boolean b() {
            boolean bl2;
            Object object = ActionMenuItemView.this.b;
            boolean bl3 = bl2 = false;
            if (object != null) {
                bl3 = bl2;
                if (ActionMenuItemView.this.b.a(ActionMenuItemView.this.a)) {
                    object = this.a();
                    bl3 = bl2;
                    if (object != null) {
                        bl3 = bl2;
                        if (object.d()) {
                            bl3 = true;
                        }
                    }
                }
            }
            return bl3;
        }
    }

    public static abstract class b {
        public abstract s a();
    }

}

