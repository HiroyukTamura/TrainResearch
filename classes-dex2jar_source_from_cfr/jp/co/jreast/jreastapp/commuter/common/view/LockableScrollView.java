/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.widget.ScrollView
 */
package jp.co.jreast.jreastapp.commuter.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/view/LockableScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mScrollable", "", "isScrollable", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onTouchEvent", "setScrollingEnabled", "", "enabled", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class LockableScrollView
extends ScrollView {
    private boolean a;

    public LockableScrollView(Context context) {
        j.b((Object)context, "context");
        super(context);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        j.b((Object)context, "context");
        j.b((Object)attributeSet, "attrs");
        super(context, attributeSet);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int n2) {
        j.b((Object)context, "context");
        j.b((Object)attributeSet, "attrs");
        super(context, attributeSet, n2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        j.b((Object)motionEvent, "ev");
        if (!this.a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        j.b((Object)keyEvent, "event");
        return false;
    }

    public boolean onKeyUp(int n2, KeyEvent keyEvent) {
        j.b((Object)keyEvent, "event");
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j.b((Object)motionEvent, "ev");
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.a) return this.a;
        return super.onTouchEvent(motionEvent);
    }

    public final void setScrollingEnabled(boolean bl2) {
        this.a = bl2;
    }
}

