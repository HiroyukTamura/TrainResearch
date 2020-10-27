package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzbo;
import com.google.android.gms.internal.ads.zzbv;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzdm implements zzdj {
    protected static volatile zzeo zzvp;
    protected MotionEvent zzwh;
    protected LinkedList<MotionEvent> zzwi = new LinkedList<>();
    protected long zzwj = 0;
    protected long zzwk = 0;
    protected long zzwl = 0;
    protected long zzwm = 0;
    protected long zzwn = 0;
    protected long zzwo = 0;
    protected long zzwp = 0;
    protected double zzwq;
    private double zzwr;
    private double zzws;
    protected float zzwt;
    protected float zzwu;
    protected float zzwv;
    protected float zzww;
    private boolean zzwx = false;
    protected boolean zzwy = false;
    protected DisplayMetrics zzwz;

    protected zzdm(Context context) {
        try {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcoa)).booleanValue()) {
                zzcn.zzbp();
            } else {
                zzer.zzb(zzvp);
            }
            this.zzwz = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdh zzdh;
        int i2;
        Context context2 = context;
        int i3 = i;
        View view2 = view;
        Activity activity2 = activity;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcnp)).booleanValue();
        zzbv.zza.C2654zza zza = null;
        if (booleanValue) {
            zzdh = zzvp != null ? zzvp.zzcm() : null;
            str2 = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcoa)).booleanValue() ? "be" : "te";
        } else {
            zzdh = null;
            str2 = null;
        }
        try {
            if (i3 == zzcm.zznd) {
                zza = zzc(context2, view2, activity2);
                this.zzwx = true;
                i2 = 1002;
            } else if (i3 == zzcm.zznc) {
                zza = zzb(context2, view2, activity2);
                i2 = PointerIconCompat.TYPE_TEXT;
            } else {
                zza = zza(context2, (zzbo.zza) null);
                i2 = 1000;
            }
            if (booleanValue && zzdh != null) {
                zzdh.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            Exception exc = e;
            if (booleanValue && zzdh != null) {
                zzdh.zza(i3 == zzcm.zznd ? PointerIconCompat.TYPE_HELP : i3 == zzcm.zznc ? PointerIconCompat.TYPE_VERTICAL_TEXT : i3 == zzcm.zznb ? 1001 : -1, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zza != null) {
            try {
                if (((zzbv.zza) ((zzecd) zza.zzbet())).zzbex() != 0) {
                    String zzj = zzcn.zzj((zzbv.zza) ((zzecd) zza.zzbet()), str);
                    if (!booleanValue || zzdh == null) {
                        return zzj;
                    }
                    zzdh.zza(i3 == zzcm.zznd ? PointerIconCompat.TYPE_CELL : i3 == zzcm.zznc ? PointerIconCompat.TYPE_ALIAS : i3 == zzcm.zznb ? PointerIconCompat.TYPE_WAIT : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e2) {
                Exception exc2 = e2;
                String num = Integer.toString(7);
                if (!booleanValue || zzdh == null) {
                    return num;
                }
                zzdh.zza(i3 == zzcm.zznd ? PointerIconCompat.TYPE_CROSSHAIR : i3 == zzcm.zznc ? PointerIconCompat.TYPE_COPY : i3 == zzcm.zznb ? 1005 : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2, exc2);
                return num;
            }
        }
        return Integer.toString(5);
    }

    private final void zzca() {
        this.zzwn = 0;
        this.zzwj = 0;
        this.zzwk = 0;
        this.zzwl = 0;
        this.zzwm = 0;
        this.zzwo = 0;
        this.zzwp = 0;
        if (this.zzwi.size() > 0) {
            Iterator it = this.zzwi.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzwi.clear();
        } else {
            MotionEvent motionEvent = this.zzwh;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwh = null;
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzeh;

    /* access modifiers changed from: protected */
    public abstract zzbv.zza.C2654zza zza(Context context, zzbo.zza zza);

    public String zza(Context context, View view, Activity activity) {
        return zza(context, (String) null, zzcm.zznc, view, activity, (byte[]) null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzcm.zznd, view, activity, (byte[]) null);
    }

    public void zza(int i, int i2, int i3) {
        MotionEvent motionEvent;
        if (this.zzwh != null) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnn)).booleanValue()) {
                zzca();
            } else {
                this.zzwh.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzwz;
        if (displayMetrics != null) {
            float f = displayMetrics.density;
            motionEvent = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * f, ((float) i2) * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            motionEvent = null;
        }
        this.zzwh = motionEvent;
        this.zzwy = false;
    }

    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzwx) {
            zzca();
            this.zzwx = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwq = 0.0d;
            this.zzwr = (double) motionEvent.getRawX();
            this.zzws = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.zzwr;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.zzws;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.zzwq = Math.sqrt((d4 * d4) + (d2 * d2)) + this.zzwq;
            this.zzwr = rawX;
            this.zzws = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzwt = motionEvent.getX();
            this.zzwu = motionEvent.getY();
            this.zzwv = motionEvent.getRawX();
            this.zzww = motionEvent.getRawY();
            this.zzwj++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzwh = obtain;
            this.zzwi.add(obtain);
            if (this.zzwi.size() > 6) {
                this.zzwi.remove().recycle();
            }
            this.zzwl++;
            this.zzwn = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzwk += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzeu zzb = zzb(motionEvent);
                if ((zzb == null || zzb.zzzf == null || zzb.zzzi == null) ? false : true) {
                    this.zzwo = zzb.zzzf.longValue() + zzb.zzzi.longValue() + this.zzwo;
                }
                if (!(this.zzwz == null || zzb == null || zzb.zzzg == null || zzb.zzzj == null)) {
                    z = true;
                }
                if (z) {
                    this.zzwp = zzb.zzzg.longValue() + zzb.zzzj.longValue() + this.zzwp;
                }
            } catch (zzeh unused) {
            }
        } else if (action2 == 3) {
            this.zzwm++;
        }
        this.zzwy = true;
    }

    /* access modifiers changed from: protected */
    public abstract zzbv.zza.C2654zza zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzeu zzb(MotionEvent motionEvent) throws zzeh;

    public String zzb(Context context) {
        if (zzet.isMainThread()) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcoc)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, (String) null, zzcm.zznb, (View) null, (Activity) null, (byte[]) null);
    }

    public void zzb(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract zzbv.zza.C2654zza zzc(Context context, View view, Activity activity);
}
