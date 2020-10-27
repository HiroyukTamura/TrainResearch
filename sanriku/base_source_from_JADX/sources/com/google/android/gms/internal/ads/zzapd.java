package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzapd {
    private static final Object lock = new Object();
    @VisibleForTesting
    private static boolean zzdjn = false;
    @VisibleForTesting
    private static boolean zzyw = false;
    @VisibleForTesting
    private zzdli zzdjo;

    @VisibleForTesting
    private final void zzp(Context context) {
        synchronized (lock) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue() && !zzdjn) {
                try {
                    zzdjn = true;
                    this.zzdjo = (zzdli) zzazv.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzapc.zzbvh);
                } catch (zzazx e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
            return null;
        }
        try {
            zzp(context);
            String valueOf = String.valueOf(this.zzdjo.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                    if (zzyw) {
                        try {
                            return this.zzdjo.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzazw.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                if (zzyw) {
                    try {
                        this.zzdjo.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzazw.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                if (zzyw) {
                    try {
                        this.zzdjo.zzab(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzazw.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                if (zzyw) {
                    try {
                        this.zzdjo.zzac(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzazw.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                if (zzyw) {
                    try {
                        this.zzdjo.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzazw.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final boolean zzo(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue()) {
                return false;
            }
            if (zzyw) {
                return true;
            }
            try {
                zzp(context);
                boolean zzau = this.zzdjo.zzau(ObjectWrapper.wrap(context));
                zzyw = zzau;
                return zzau;
            } catch (RemoteException e) {
                e = e;
                zzazw.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzazw.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }
}
