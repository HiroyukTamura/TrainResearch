package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzvj;

public final class zzq extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdlb;
    private final zzy zzdlc;

    public zzq(Context context, zzp zzp, @Nullable zzy zzy) {
        super(context);
        this.zzdlc = zzy;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zzdlb = imageButton;
        imageButton.setImageResource(17301527);
        this.zzdlb.setBackgroundColor(0);
        this.zzdlb.setOnClickListener(this);
        ImageButton imageButton2 = this.zzdlb;
        zzvj.zzpr();
        int zzc = zzazm.zzc(context, zzp.paddingLeft);
        zzvj.zzpr();
        int zzc2 = zzazm.zzc(context, 0);
        zzvj.zzpr();
        int zzc3 = zzazm.zzc(context, zzp.paddingRight);
        zzvj.zzpr();
        imageButton2.setPadding(zzc, zzc2, zzc3, zzazm.zzc(context, zzp.paddingBottom));
        this.zzdlb.setContentDescription("Interstitial close button");
        ImageButton imageButton3 = this.zzdlb;
        zzvj.zzpr();
        int zzc4 = zzazm.zzc(context, zzp.size + zzp.paddingLeft + zzp.paddingRight);
        zzvj.zzpr();
        addView(imageButton3, new FrameLayout.LayoutParams(zzc4, zzazm.zzc(context, zzp.size + zzp.paddingBottom), 17));
    }

    public final void onClick(View view) {
        zzy zzy = this.zzdlc;
        if (zzy != null) {
            zzy.zzug();
        }
    }

    public final void zzal(boolean z) {
        ImageButton imageButton;
        int i;
        if (z) {
            imageButton = this.zzdlb;
            i = 8;
        } else {
            imageButton = this.zzdlb;
            i = 0;
        }
        imageButton.setVisibility(i);
    }
}
