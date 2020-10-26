// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Intent;
import android.content.Context;
import android.view.View$OnClickListener;
import android.widget.Button;
import com.google.android.gms.common.zze;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.GoogleApiAvailability;
import android.widget.FrameLayout;
import java.util.LinkedList;
import android.os.Bundle;

public abstract class zza<T extends LifecycleDelegate>
{
    private T zzaSr;
    private Bundle zzaSs;
    private LinkedList<zzi> zzaSt;
    private final zzo<T> zzaSu;
    
    public zza() {
        this.zzaSu = (zzo<T>)new zzb(this);
    }
    
    private final void zza(final Bundle bundle, final zzi e) {
        if (this.zzaSr != null) {
            e.zzb(this.zzaSr);
            return;
        }
        if (this.zzaSt == null) {
            this.zzaSt = new LinkedList<zzi>();
        }
        this.zzaSt.add(e);
        if (bundle != null) {
            if (this.zzaSs == null) {
                this.zzaSs = (Bundle)bundle.clone();
            }
            else {
                this.zzaSs.putAll(bundle);
            }
        }
        this.zza(this.zzaSu);
    }
    
    private final void zzaR(final int n) {
        while (!this.zzaSt.isEmpty() && this.zzaSt.getLast().getState() >= n) {
            this.zzaSt.removeLast();
        }
    }
    
    public static void zzb(final FrameLayout frameLayout) {
        final GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        final Context context = frameLayout.getContext();
        final int googlePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        final String zzi = zzs.zzi(context, googlePlayServicesAvailable);
        final String zzk = zzs.zzk(context, googlePlayServicesAvailable);
        final LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
        frameLayout.addView((View)linearLayout);
        final TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
        textView.setText((CharSequence)zzi);
        linearLayout.addView((View)textView);
        final Intent zza = zze.zza(context, googlePlayServicesAvailable, null);
        if (zza != null) {
            final Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
            button.setText((CharSequence)zzk);
            linearLayout.addView((View)button);
            button.setOnClickListener((View$OnClickListener)new zzf(context, zza));
        }
    }
    
    public final void onCreate(final Bundle bundle) {
        this.zza(bundle, new zzd(this, bundle));
    }
    
    public final View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        this.zza(bundle, new com.google.android.gms.dynamic.zze(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zzaSr == null) {
            this.zza(frameLayout);
        }
        return (View)frameLayout;
    }
    
    public final void onDestroy() {
        if (this.zzaSr != null) {
            this.zzaSr.onDestroy();
            return;
        }
        this.zzaR(1);
    }
    
    public final void onDestroyView() {
        if (this.zzaSr != null) {
            this.zzaSr.onDestroyView();
            return;
        }
        this.zzaR(2);
    }
    
    public final void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        this.zza(bundle2, new zzc(this, activity, bundle, bundle2));
    }
    
    public final void onLowMemory() {
        if (this.zzaSr != null) {
            this.zzaSr.onLowMemory();
        }
    }
    
    public final void onPause() {
        if (this.zzaSr != null) {
            this.zzaSr.onPause();
            return;
        }
        this.zzaR(5);
    }
    
    public final void onResume() {
        this.zza(null, new zzh(this));
    }
    
    public final void onSaveInstanceState(final Bundle bundle) {
        if (this.zzaSr != null) {
            this.zzaSr.onSaveInstanceState(bundle);
        }
        else if (this.zzaSs != null) {
            bundle.putAll(this.zzaSs);
        }
    }
    
    public final void onStart() {
        this.zza(null, new zzg(this));
    }
    
    public final void onStop() {
        if (this.zzaSr != null) {
            this.zzaSr.onStop();
            return;
        }
        this.zzaR(4);
    }
    
    protected void zza(final FrameLayout frameLayout) {
        final GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        final Context context = frameLayout.getContext();
        final int googlePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        final String zzi = zzs.zzi(context, googlePlayServicesAvailable);
        final String zzk = zzs.zzk(context, googlePlayServicesAvailable);
        final LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
        frameLayout.addView((View)linearLayout);
        final TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
        textView.setText((CharSequence)zzi);
        linearLayout.addView((View)textView);
        final Intent zza = zze.zza(context, googlePlayServicesAvailable, null);
        if (zza != null) {
            final Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2));
            button.setText((CharSequence)zzk);
            linearLayout.addView((View)button);
            button.setOnClickListener((View$OnClickListener)new zzf(context, zza));
        }
    }
    
    protected abstract void zza(final zzo<T> p0);
    
    public final T zztx() {
        return this.zzaSr;
    }
}
