// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.content.Intent;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.v4.util.ArrayMap;
import android.os.Bundle;
import java.util.Map;
import java.lang.ref.WeakReference;
import android.app.Activity;
import java.util.WeakHashMap;
import android.app.Fragment;

public final class zzbdu extends Fragment implements zzbdt
{
    private static WeakHashMap<Activity, WeakReference<zzbdu>> zzaEH;
    private int zzLe;
    private Map<String, zzbds> zzaEI;
    private Bundle zzaEJ;
    
    static {
        zzbdu.zzaEH = new WeakHashMap<Activity, WeakReference<zzbdu>>();
    }
    
    public zzbdu() {
        this.zzaEI = new ArrayMap<String, zzbds>();
        this.zzLe = 0;
    }
    
    public static zzbdu zzo(final Activity activity) {
        final WeakReference<zzbdu> weakReference = zzbdu.zzaEH.get(activity);
        if (weakReference != null) {
            final zzbdu zzbdu = weakReference.get();
            if (zzbdu != null) {
                return zzbdu;
            }
        }
        try {
            final zzbdu zzbdu2 = (zzbdu)activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            zzbdu referent = null;
            Label_0080: {
                if (zzbdu2 != null) {
                    referent = zzbdu2;
                    if (!zzbdu2.isRemoving()) {
                        break Label_0080;
                    }
                }
                referent = new zzbdu();
                activity.getFragmentManager().beginTransaction().add((Fragment)referent, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzbdu.zzaEH.put(activity, new WeakReference<zzbdu>(referent));
            return referent;
        }
        catch (ClassCastException cause) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", cause);
        }
    }
    
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().dump(s, fileDescriptor, printWriter, array);
        }
    }
    
    public final void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onActivityResult(n, n2, intent);
        }
    }
    
    public final void onCreate(final Bundle zzaEJ) {
        super.onCreate(zzaEJ);
        this.zzLe = 1;
        this.zzaEJ = zzaEJ;
        for (final Map.Entry<String, zzbds> entry : this.zzaEI.entrySet()) {
            final zzbds zzbds = entry.getValue();
            Bundle bundle;
            if (zzaEJ != null) {
                bundle = zzaEJ.getBundle((String)entry.getKey());
            }
            else {
                bundle = null;
            }
            zzbds.onCreate(bundle);
        }
    }
    
    public final void onDestroy() {
        super.onDestroy();
        this.zzLe = 5;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    public final void onResume() {
        super.onResume();
        this.zzLe = 3;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onResume();
        }
    }
    
    public final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (final Map.Entry<String, zzbds> entry : this.zzaEI.entrySet()) {
                final Bundle bundle2 = new Bundle();
                entry.getValue().onSaveInstanceState(bundle2);
                bundle.putBundle((String)entry.getKey(), bundle2);
            }
        }
    }
    
    public final void onStart() {
        super.onStart();
        this.zzLe = 2;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }
    
    public final void onStop() {
        super.onStop();
        this.zzLe = 4;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
    
    public final <T extends zzbds> T zza(final String s, final Class<T> clazz) {
        return clazz.cast(this.zzaEI.get(s));
    }
    
    public final void zza(final String s, @NonNull final zzbds zzbds) {
        if (!this.zzaEI.containsKey(s)) {
            this.zzaEI.put(s, zzbds);
            if (this.zzLe > 0) {
                new Handler(Looper.getMainLooper()).post((Runnable)new zzbdv(this, zzbds, s));
            }
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(s).length() + 59).append("LifecycleCallback with tag ").append(s).append(" already added to this fragment.").toString());
    }
    
    public final Activity zzqF() {
        return this.getActivity();
    }
}
