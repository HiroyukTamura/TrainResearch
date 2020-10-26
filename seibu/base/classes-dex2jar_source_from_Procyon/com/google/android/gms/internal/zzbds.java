// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.MainThread;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.app.Activity;

public class zzbds
{
    protected final zzbdt zzaEG;
    
    protected zzbds(final zzbdt zzaEG) {
        this.zzaEG = zzaEG;
    }
    
    protected static zzbdt zzb(final zzbdr zzbdr) {
        if (zzbdr.zzqC()) {
            return zzbeo.zza(zzbdr.zzqE());
        }
        return zzbdu.zzo(zzbdr.zzqD());
    }
    
    public static zzbdt zzn(final Activity activity) {
        return zzb(new zzbdr(activity));
    }
    
    @MainThread
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    public final Activity getActivity() {
        return this.zzaEG.zzqF();
    }
    
    @MainThread
    public void onActivityResult(final int n, final int n2, final Intent intent) {
    }
    
    @MainThread
    public void onCreate(final Bundle bundle) {
    }
    
    @MainThread
    public void onDestroy() {
    }
    
    @MainThread
    public void onResume() {
    }
    
    @MainThread
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    @MainThread
    public void onStart() {
    }
    
    @MainThread
    public void onStop() {
    }
}
