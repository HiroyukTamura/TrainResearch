// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.Activity;
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
import android.support.v4.app.FragmentActivity;
import java.util.WeakHashMap;
import android.support.v4.app.Fragment;

public final class zzbeo extends Fragment implements zzbdt
{
    private static WeakHashMap<FragmentActivity, WeakReference<zzbeo>> zzaEH;
    private int zzLe;
    private Map<String, zzbds> zzaEI;
    private Bundle zzaEJ;
    
    static {
        zzbeo.zzaEH = new WeakHashMap<FragmentActivity, WeakReference<zzbeo>>();
    }
    
    public zzbeo() {
        this.zzaEI = new ArrayMap<String, zzbds>();
        this.zzLe = 0;
    }
    
    public static zzbeo zza(final FragmentActivity fragmentActivity) {
        final WeakReference<zzbeo> weakReference = zzbeo.zzaEH.get(fragmentActivity);
        if (weakReference != null) {
            final zzbeo zzbeo = weakReference.get();
            if (zzbeo != null) {
                return zzbeo;
            }
        }
        try {
            final zzbeo zzbeo2 = (zzbeo)fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            zzbeo referent = null;
            Label_0080: {
                if (zzbeo2 != null) {
                    referent = zzbeo2;
                    if (!zzbeo2.isRemoving()) {
                        break Label_0080;
                    }
                }
                referent = new zzbeo();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(referent, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzbeo.zzaEH.put(fragmentActivity, new WeakReference<zzbeo>(referent));
            return referent;
        }
        catch (ClassCastException cause) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", cause);
        }
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().dump(s, fileDescriptor, printWriter, array);
        }
    }
    
    @Override
    public final void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onActivityResult(n, n2, intent);
        }
    }
    
    @Override
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
    
    @Override
    public final void onDestroy() {
        super.onDestroy();
        this.zzLe = 5;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    @Override
    public final void onResume() {
        super.onResume();
        this.zzLe = 3;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onResume();
        }
    }
    
    @Override
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
    
    @Override
    public final void onStart() {
        super.onStart();
        this.zzLe = 2;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }
    
    @Override
    public final void onStop() {
        super.onStop();
        this.zzLe = 4;
        final Iterator<zzbds> iterator = this.zzaEI.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
    
    @Override
    public final <T extends zzbds> T zza(final String s, final Class<T> clazz) {
        return clazz.cast(this.zzaEI.get(s));
    }
    
    @Override
    public final void zza(final String s, @NonNull final zzbds zzbds) {
        if (!this.zzaEI.containsKey(s)) {
            this.zzaEI.put(s, zzbds);
            if (this.zzLe > 0) {
                new Handler(Looper.getMainLooper()).post((Runnable)new zzbep(this, zzbds, s));
            }
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(s).length() + 59).append("LifecycleCallback with tag ").append(s).append(" already added to this fragment.").toString());
    }
}
