// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.os.SystemClock;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

public final class zzbfg extends Drawable implements Drawable$Callback
{
    private int mFrom;
    private int zzaGA;
    private boolean zzaGj;
    private int zzaGo;
    private int zzaGp;
    private int zzaGq;
    private int zzaGr;
    private int zzaGs;
    private boolean zzaGt;
    private zzbfk zzaGu;
    private Drawable zzaGv;
    private Drawable zzaGw;
    private boolean zzaGx;
    private boolean zzaGy;
    private boolean zzaGz;
    private long zzagZ;
    
    public zzbfg(Drawable zzqX, final Drawable drawable) {
        this(null);
        Drawable zzqX2 = zzqX;
        if (zzqX == null) {
            zzqX2 = zzbfi.zzaGB;
        }
        (this.zzaGv = zzqX2).setCallback((Drawable$Callback)this);
        final zzbfk zzaGu = this.zzaGu;
        zzaGu.zzaGD |= zzqX2.getChangingConfigurations();
        if ((zzqX = drawable) == null) {
            zzqX = zzbfi.zzaGB;
        }
        (this.zzaGw = zzqX).setCallback((Drawable$Callback)this);
        final zzbfk zzaGu2 = this.zzaGu;
        zzaGu2.zzaGD |= zzqX.getChangingConfigurations();
    }
    
    zzbfg(final zzbfk zzbfk) {
        this.zzaGo = 0;
        this.zzaGq = 255;
        this.zzaGs = 0;
        this.zzaGj = true;
        this.zzaGu = new zzbfk(zzbfk);
    }
    
    private final boolean canConstantState() {
        if (!this.zzaGx) {
            this.zzaGy = (this.zzaGv.getConstantState() != null && this.zzaGw.getConstantState() != null);
            this.zzaGx = true;
        }
        return this.zzaGy;
    }
    
    public final void draw(final Canvas canvas) {
        final int n = 1;
        int n2 = 1;
        final int n3 = 0;
        switch (this.zzaGo) {
            case 1: {
                this.zzagZ = SystemClock.uptimeMillis();
                this.zzaGo = 2;
                n2 = n3;
                break;
            }
            case 2: {
                if (this.zzagZ >= 0L) {
                    final float a = (SystemClock.uptimeMillis() - this.zzagZ) / (float)this.zzaGr;
                    if (a >= 1.0f) {
                        n2 = n;
                    }
                    else {
                        n2 = 0;
                    }
                    if (n2 != 0) {
                        this.zzaGo = 0;
                    }
                    this.zzaGs = (int)(Math.min(a, 1.0f) * this.zzaGp + 0.0f);
                    break;
                }
                break;
            }
        }
        final int zzaGs = this.zzaGs;
        final boolean zzaGj = this.zzaGj;
        final Drawable zzaGv = this.zzaGv;
        final Drawable zzaGw = this.zzaGw;
        if (n2 != 0) {
            if (!zzaGj || zzaGs == 0) {
                zzaGv.draw(canvas);
            }
            if (zzaGs == this.zzaGq) {
                zzaGw.setAlpha(this.zzaGq);
                zzaGw.draw(canvas);
            }
            return;
        }
        if (zzaGj) {
            zzaGv.setAlpha(this.zzaGq - zzaGs);
        }
        zzaGv.draw(canvas);
        if (zzaGj) {
            zzaGv.setAlpha(this.zzaGq);
        }
        if (zzaGs > 0) {
            zzaGw.setAlpha(zzaGs);
            zzaGw.draw(canvas);
            zzaGw.setAlpha(this.zzaGq);
        }
        this.invalidateSelf();
    }
    
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzaGu.mChangingConfigurations | this.zzaGu.zzaGD;
    }
    
    public final Drawable$ConstantState getConstantState() {
        if (this.canConstantState()) {
            this.zzaGu.mChangingConfigurations = this.getChangingConfigurations();
            return this.zzaGu;
        }
        return null;
    }
    
    public final int getIntrinsicHeight() {
        return Math.max(this.zzaGv.getIntrinsicHeight(), this.zzaGw.getIntrinsicHeight());
    }
    
    public final int getIntrinsicWidth() {
        return Math.max(this.zzaGv.getIntrinsicWidth(), this.zzaGw.getIntrinsicWidth());
    }
    
    public final int getOpacity() {
        if (!this.zzaGz) {
            this.zzaGA = Drawable.resolveOpacity(this.zzaGv.getOpacity(), this.zzaGw.getOpacity());
            this.zzaGz = true;
        }
        return this.zzaGA;
    }
    
    public final void invalidateDrawable(final Drawable drawable) {
        final Drawable$Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }
    
    public final Drawable mutate() {
        if (!this.zzaGt && super.mutate() == this) {
            if (!this.canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzaGv.mutate();
            this.zzaGw.mutate();
            this.zzaGt = true;
        }
        return this;
    }
    
    protected final void onBoundsChange(final Rect rect) {
        this.zzaGv.setBounds(rect);
        this.zzaGw.setBounds(rect);
    }
    
    public final void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        final Drawable$Callback callback = this.getCallback();
        if (callback != null) {
            callback.scheduleDrawable((Drawable)this, runnable, n);
        }
    }
    
    public final void setAlpha(final int n) {
        if (this.zzaGs == this.zzaGq) {
            this.zzaGs = n;
        }
        this.zzaGq = n;
        this.invalidateSelf();
    }
    
    public final void setColorFilter(final ColorFilter colorFilter) {
        this.zzaGv.setColorFilter(colorFilter);
        this.zzaGw.setColorFilter(colorFilter);
    }
    
    public final void startTransition(final int n) {
        this.mFrom = 0;
        this.zzaGp = this.zzaGq;
        this.zzaGs = 0;
        this.zzaGr = 250;
        this.zzaGo = 1;
        this.invalidateSelf();
    }
    
    public final void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        final Drawable$Callback callback = this.getCallback();
        if (callback != null) {
            callback.unscheduleDrawable((Drawable)this, runnable);
        }
    }
    
    public final Drawable zzqW() {
        return this.zzaGw;
    }
}
