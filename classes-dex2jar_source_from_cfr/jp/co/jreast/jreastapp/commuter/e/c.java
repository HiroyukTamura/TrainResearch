/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.VibrationEffect
 *  android.os.Vibrator
 */
package jp.co.jreast.jreastapp.commuter.e;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/device/VibrationService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "vibrate", "", "mills", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c {
    private final Context a;

    public c(Context context) {
        j.b((Object)context, "context");
        this.a = context;
    }

    public final void a(long l2) {
        Object object = this.a.getSystemService("vibrator");
        if (object != null) {
            object = (Vibrator)object;
            if (Build.VERSION.SDK_INT >= 26) {
                object.vibrate(VibrationEffect.createOneShot((long)l2, (int)-1));
                return;
            }
            object.vibrate(new long[]{0L, l2}, -1);
            return;
        }
        throw new t("null cannot be cast to non-null type android.os.Vibrator");
    }
}

