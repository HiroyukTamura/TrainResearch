package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(19)
public final class zzcfo {
    @Nullable
    private PopupWindow zzfxm;
    @Nullable
    private Context zzvf;

    private static PopupWindow zzd(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzazw.zzed("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void zzamy() {
        Context context = this.zzvf;
        if (context != null && this.zzfxm != null) {
            if ((!(context instanceof Activity) || !((Activity) context).isDestroyed()) && this.zzfxm.isShowing()) {
                this.zzfxm.dismiss();
            }
            this.zzvf = null;
            this.zzfxm = null;
        }
    }

    public final void zzc(Context context, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            PopupWindow zzd = zzd(context, view);
            this.zzfxm = zzd;
            if (zzd == null) {
                context = null;
            }
            this.zzvf = context;
        }
    }
}
