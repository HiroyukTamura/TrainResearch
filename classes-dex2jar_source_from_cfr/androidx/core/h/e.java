/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.KeyEvent$Callback
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 */
package androidx.core.h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.h.t;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e {
    private static boolean a = false;
    private static Method b;
    private static boolean c = false;
    private static Field d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static DialogInterface.OnKeyListener a(Dialog dialog) {
        if (!c) {
            try {
                d = Dialog.class.getDeclaredField("mOnKeyListener");
                d.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            c = true;
        }
        if (d == null) return null;
        try {
            return (DialogInterface.OnKeyListener)d.get((Object)dialog);
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!a) {
            try {
                b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            a = true;
        }
        if (b == null) {
            return false;
        }
        try {
            return (Boolean)b.invoke((Object)actionBar, new Object[]{keyEvent});
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private static boolean a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Object object = activity.getWindow();
        if (object.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && e.a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (object.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (t.b((View)(object = object.getDecorView()), keyEvent)) {
            return true;
        }
        object = object != null ? object.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)activity, (KeyEvent.DispatcherState)object, (Object)activity);
    }

    private static boolean a(Dialog dialog, KeyEvent keyEvent) {
        Object object = e.a(dialog);
        if (object != null && object.onKey((DialogInterface)dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        object = dialog.getWindow();
        if (object.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (t.b((View)(object = object.getDecorView()), keyEvent)) {
            return true;
        }
        object = object != null ? object.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)dialog, (KeyEvent.DispatcherState)object, (Object)dialog);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return t.a(view, keyEvent);
    }

    public static boolean a(a a2, View view, Window.Callback callback, KeyEvent keyEvent) {
        boolean bl2 = false;
        if (a2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return a2.a(keyEvent);
        }
        if (callback instanceof Activity) {
            return e.a((Activity)callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return e.a((Dialog)callback, keyEvent);
        }
        if (view != null && t.b(view, keyEvent) || a2.a(keyEvent)) {
            bl2 = true;
        }
        return bl2;
    }

    public static interface a {
        public boolean a(KeyEvent var1);
    }

}

