package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.tagmanager.zzeh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public class Container {
    private final String zzaec;
    private final DataLayer zzaed;
    private zzfb zzaee;
    private Map<String, FunctionCallMacroCallback> zzaef = new HashMap();
    private Map<String, FunctionCallTagCallback> zzaeg = new HashMap();
    private volatile long zzaeh;
    private volatile String zzaei = "";
    private final Context zzrm;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    class zza implements zzan {
        private zza() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzal = Container.this.zzal(str);
            if (zzal == null) {
                return null;
            }
            return zzal.getValue(str, map);
        }
    }

    class zzb implements zzan {
        private zzb() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzam = Container.this.zzam(str);
            if (zzam != null) {
                zzam.execute(str, map);
            }
            return zzgj.zzkb();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzk zzk) {
        this.zzrm = context;
        this.zzaed = dataLayer;
        this.zzaec = str;
        this.zzaeh = j;
        zzi zzi = zzk.zzqk;
        if (zzi != null) {
            try {
                zza(zzor.zza(zzi));
            } catch (zzoz e) {
                String valueOf = String.valueOf(zzi);
                String exc = e.toString();
                StringBuilder sb = new StringBuilder(C0681a.m336b(exc, valueOf.length() + 46));
                sb.append("Not loading resource: ");
                sb.append(valueOf);
                sb.append(" because it is invalid: ");
                sb.append(exc);
                zzdi.zzav(sb.toString());
            }
            zzj[] zzjArr = zzk.zzqj;
            if (zzjArr != null) {
                ArrayList arrayList = new ArrayList();
                for (zzj add : zzjArr) {
                    arrayList.add(add);
                }
                zzhb().zze(arrayList);
                return;
            }
            return;
        }
        throw null;
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzov zzov) {
        this.zzrm = context;
        this.zzaed = dataLayer;
        this.zzaec = str;
        this.zzaeh = 0;
        zza(zzov);
    }

    private final void zza(zzov zzov) {
        this.zzaei = zzov.getVersion();
        zzeh.zziy().zziz().equals(zzeh.zza.CONTAINER_DEBUG);
        zzov zzov2 = zzov;
        zza(new zzfb(this.zzrm, zzov2, this.zzaed, new zza(), new zzb(), new zzdq()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzaed.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzaec));
        }
    }

    private final synchronized void zza(zzfb zzfb) {
        this.zzaee = zzfb;
    }

    private final synchronized zzfb zzhb() {
        return this.zzaee;
    }

    public boolean getBoolean(String str) {
        String str2;
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            str2 = "getBoolean called for closed container.";
        } else {
            try {
                return zzgj.zzg(zzhb.zzbj(str).getObject()).booleanValue();
            } catch (Exception e) {
                String message = e.getMessage();
                str2 = C0681a.m313a(C0681a.m336b(message, 66), "Calling getBoolean() threw an exception: ", message, " Returning default value.");
            }
        }
        zzdi.zzav(str2);
        return zzgj.zzjz().booleanValue();
    }

    public String getContainerId() {
        return this.zzaec;
    }

    public double getDouble(String str) {
        String str2;
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            str2 = "getDouble called for closed container.";
        } else {
            try {
                return zzgj.zzf(zzhb.zzbj(str).getObject()).doubleValue();
            } catch (Exception e) {
                String message = e.getMessage();
                str2 = C0681a.m313a(C0681a.m336b(message, 65), "Calling getDouble() threw an exception: ", message, " Returning default value.");
            }
        }
        zzdi.zzav(str2);
        return zzgj.zzjy().doubleValue();
    }

    public long getLastRefreshTime() {
        return this.zzaeh;
    }

    public long getLong(String str) {
        String str2;
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            str2 = "getLong called for closed container.";
        } else {
            try {
                return zzgj.zze(zzhb.zzbj(str).getObject()).longValue();
            } catch (Exception e) {
                String message = e.getMessage();
                str2 = C0681a.m313a(C0681a.m336b(message, 63), "Calling getLong() threw an exception: ", message, " Returning default value.");
            }
        }
        zzdi.zzav(str2);
        return zzgj.zzjx().longValue();
    }

    public String getString(String str) {
        String str2;
        zzfb zzhb = zzhb();
        if (zzhb == null) {
            str2 = "getString called for closed container.";
        } else {
            try {
                return zzgj.zzc(zzhb.zzbj(str).getObject());
            } catch (Exception e) {
                String message = e.getMessage();
                str2 = C0681a.m313a(C0681a.m336b(message, 65), "Calling getString() threw an exception: ", message, " Returning default value.");
            }
        }
        zzdi.zzav(str2);
        return zzgj.zzkb();
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback != null) {
            synchronized (this.zzaef) {
                this.zzaef.put(str, functionCallMacroCallback);
            }
            return;
        }
        throw new NullPointerException("Macro handler must be non-null");
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback != null) {
            synchronized (this.zzaeg) {
                this.zzaeg.put(str, functionCallTagCallback);
            }
            return;
        }
        throw new NullPointerException("Tag callback must be non-null");
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        this.zzaee = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzaef) {
            this.zzaef.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzaeg) {
            this.zzaeg.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final FunctionCallMacroCallback zzal(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaef) {
            functionCallMacroCallback = this.zzaef.get(str);
        }
        return functionCallMacroCallback;
    }

    @VisibleForTesting
    public final FunctionCallTagCallback zzam(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaeg) {
            functionCallTagCallback = this.zzaeg.get(str);
        }
        return functionCallTagCallback;
    }

    @VisibleForTesting
    public final void zzan(String str) {
        zzhb().zzan(str);
    }

    @VisibleForTesting
    public final String zzha() {
        return this.zzaei;
    }
}
