// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import java.util.List;
import java.util.ArrayList;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.zzbn;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.zzbq;
import java.util.HashMap;
import com.google.android.gms.internal.ek;
import java.util.Map;
import android.content.Context;

public class Container
{
    private final Context mContext;
    private Map<String, FunctionCallTagCallback> zzbDA;
    private volatile long zzbDB;
    private volatile String zzbDC;
    private final String zzbDw;
    private final DataLayer zzbDx;
    private zzfc zzbDy;
    private Map<String, FunctionCallMacroCallback> zzbDz;
    
    Container(final Context mContext, final DataLayer zzbDx, final String zzbDw, final long n, final ek ek) {
        this.zzbDz = new HashMap<String, FunctionCallMacroCallback>();
        this.zzbDA = new HashMap<String, FunctionCallTagCallback>();
        this.zzbDC = "";
        this.mContext = mContext;
        this.zzbDx = zzbDx;
        this.zzbDw = zzbDw;
        this.zzbDB = 0L;
        this.zza(ek);
    }
    
    Container(Context context, final DataLayer zzbDx, final String zzbDw, final long zzbDB, final zzbq zzbq) {
        this.zzbDz = new HashMap<String, FunctionCallMacroCallback>();
        this.zzbDA = new HashMap<String, FunctionCallTagCallback>();
        this.zzbDC = "";
        this.mContext = context;
        this.zzbDx = zzbDx;
        this.zzbDw = zzbDw;
        this.zzbDB = zzbDB;
        context = (Context)zzbq.zzlB;
        if (context == null) {
            throw new NullPointerException();
        }
        while (true) {
            try {
                this.zza(eg.zza((zzbn)context));
                if (zzbq.zzlA != null) {
                    this.zza(zzbq.zzlA);
                }
            }
            catch (eo eo) {
                context = (Context)String.valueOf(context);
                final String value = String.valueOf(eo.toString());
                zzdj.e(new StringBuilder(String.valueOf(context).length() + 46 + String.valueOf(value).length()).append("Not loading resource: ").append((String)context).append(" because it is invalid: ").append(value).toString());
                continue;
            }
            break;
        }
    }
    
    private final zzfc zzAJ() {
        synchronized (this) {
            return this.zzbDy;
        }
    }
    
    private final void zza(final ek ek) {
        this.zzbDC = ek.getVersion();
        final String zzbDC = this.zzbDC;
        zzei.zzBD().zzBE().equals(zzei.zza.zzbFL);
        this.zza(new zzfc(this.mContext, ek, this.zzbDx, new zza((zzu)null), new zzb((zzu)null), new zzdr()));
        if (this.getBoolean("_gtm.loadEventEnabled")) {
            this.zzbDx.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbDw));
        }
    }
    
    private final void zza(final zzfc zzbDy) {
        synchronized (this) {
            this.zzbDy = zzbDy;
        }
    }
    
    private final void zza(final zzbp[] array) {
        final ArrayList<zzbp> list = new ArrayList<zzbp>();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        this.zzAJ().zzL(list);
    }
    
    public boolean getBoolean(String value) {
        final zzfc zzAJ = this.zzAJ();
        if (zzAJ == null) {
            zzdj.e("getBoolean called for closed container.");
            return zzgk.zzCe();
        }
        try {
            return zzgk.zzf(zzAJ.zzfs(value).getObject());
        }
        catch (Exception ex) {
            value = String.valueOf(ex.getMessage());
            zzdj.e(new StringBuilder(String.valueOf(value).length() + 66).append("Calling getBoolean() threw an exception: ").append(value).append(" Returning default value.").toString());
            return zzgk.zzCe();
        }
    }
    
    public String getContainerId() {
        return this.zzbDw;
    }
    
    public double getDouble(String value) {
        final zzfc zzAJ = this.zzAJ();
        if (zzAJ == null) {
            zzdj.e("getDouble called for closed container.");
            return zzgk.zzCd();
        }
        try {
            return zzgk.zze(zzAJ.zzfs(value).getObject());
        }
        catch (Exception ex) {
            value = String.valueOf(ex.getMessage());
            zzdj.e(new StringBuilder(String.valueOf(value).length() + 65).append("Calling getDouble() threw an exception: ").append(value).append(" Returning default value.").toString());
            return zzgk.zzCd();
        }
    }
    
    public long getLastRefreshTime() {
        return this.zzbDB;
    }
    
    public long getLong(String value) {
        final zzfc zzAJ = this.zzAJ();
        if (zzAJ == null) {
            zzdj.e("getLong called for closed container.");
            return zzgk.zzCc();
        }
        try {
            return zzgk.zzd(zzAJ.zzfs(value).getObject());
        }
        catch (Exception ex) {
            value = String.valueOf(ex.getMessage());
            zzdj.e(new StringBuilder(String.valueOf(value).length() + 63).append("Calling getLong() threw an exception: ").append(value).append(" Returning default value.").toString());
            return zzgk.zzCc();
        }
    }
    
    public String getString(String s) {
        final zzfc zzAJ = this.zzAJ();
        if (zzAJ == null) {
            zzdj.e("getString called for closed container.");
            return zzgk.zzCg();
        }
        try {
            s = zzgk.zzb(zzAJ.zzfs(s).getObject());
            return s;
        }
        catch (Exception ex) {
            s = String.valueOf(ex.getMessage());
            zzdj.e(new StringBuilder(String.valueOf(s).length() + 65).append("Calling getString() threw an exception: ").append(s).append(" Returning default value.").toString());
            return zzgk.zzCg();
        }
    }
    
    public boolean isDefault() {
        return this.getLastRefreshTime() == 0L;
    }
    
    public void registerFunctionCallMacroCallback(final String s, final FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbDz) {
            this.zzbDz.put(s, functionCallMacroCallback);
        }
    }
    
    public void registerFunctionCallTagCallback(final String s, final FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbDA) {
            this.zzbDA.put(s, functionCallTagCallback);
        }
    }
    
    final void release() {
        this.zzbDy = null;
    }
    
    public void unregisterFunctionCallMacroCallback(final String s) {
        synchronized (this.zzbDz) {
            this.zzbDz.remove(s);
        }
    }
    
    public void unregisterFunctionCallTagCallback(final String s) {
        synchronized (this.zzbDA) {
            this.zzbDA.remove(s);
        }
    }
    
    public final String zzAI() {
        return this.zzbDC;
    }
    
    final FunctionCallMacroCallback zzeX(final String s) {
        synchronized (this.zzbDz) {
            return this.zzbDz.get(s);
        }
    }
    
    public final FunctionCallTagCallback zzeY(final String s) {
        synchronized (this.zzbDA) {
            return this.zzbDA.get(s);
        }
    }
    
    public final void zzeZ(final String s) {
        this.zzAJ().zzeZ(s);
    }
    
    public interface FunctionCallMacroCallback
    {
        Object getValue(final String p0, final Map<String, Object> p1);
    }
    
    public interface FunctionCallTagCallback
    {
        void execute(final String p0, final Map<String, Object> p1);
    }
    
    final class zza implements zzan
    {
        private zza() {
        }
        
        @Override
        public final Object zzd(final String s, final Map<String, Object> map) {
            final FunctionCallMacroCallback zzeX = Container.this.zzeX(s);
            if (zzeX == null) {
                return null;
            }
            return zzeX.getValue(s, map);
        }
    }
    
    final class zzb implements zzan
    {
        private zzb() {
        }
        
        @Override
        public final Object zzd(final String s, final Map<String, Object> map) {
            final FunctionCallTagCallback zzeY = Container.this.zzeY(s);
            if (zzeY != null) {
                zzeY.execute(s, map);
            }
            return zzgk.zzCg();
        }
    }
}
