// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;

public final class zzaot extends zzamh
{
    private boolean zzadF;
    private String zzaeH;
    private String zzaeI;
    private int zzagX;
    protected int zzahZ;
    protected boolean zzaiP;
    private boolean zzaiQ;
    
    public zzaot(final zzamj zzamj) {
        super(zzamj);
    }
    
    @Override
    protected final void zzjD() {
        zzanw zzanw;
        while (true) {
            final Context context = this.getContext();
            ApplicationInfo applicationInfo;
            while (true) {
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
                    if (applicationInfo == null) {
                        this.zzbr("Couldn't get ApplicationInfo to load global config");
                        return;
                    }
                }
                catch (PackageManager$NameNotFoundException ex) {
                    this.zzd("PackageManager doesn't know about the app package", ex);
                    applicationInfo = null;
                    continue;
                }
                break;
            }
            final Bundle metaData = applicationInfo.metaData;
            if (metaData == null) {
                return;
            }
            final int int1 = metaData.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (int1 <= 0) {
                return;
            }
            zzanw = new zzanu(this.zzkp()).zzP(int1);
            if (zzanw == null) {
                return;
            }
            this.zzbo("Loading global XML config values");
            int n;
            if (zzanw.zzaeH != null) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (n != 0) {
                this.zzb("XML config - app name", this.zzaeH = zzanw.zzaeH);
            }
            int n2;
            if (zzanw.zzaeI != null) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            if (n2 != 0) {
                this.zzb("XML config - app version", this.zzaeI = zzanw.zzaeI);
            }
            int n3;
            if (zzanw.zzahY != null) {
                n3 = 1;
            }
            else {
                n3 = 0;
            }
            if (n3 != 0) {
                final String lowerCase = zzanw.zzahY.toLowerCase();
                int n4;
                if ("verbose".equals(lowerCase)) {
                    n4 = 0;
                }
                else if ("info".equals(lowerCase)) {
                    n4 = 1;
                }
                else if ("warning".equals(lowerCase)) {
                    n4 = 2;
                }
                else if ("error".equals(lowerCase)) {
                    n4 = 3;
                }
                else {
                    n4 = -1;
                }
                if (n4 >= 0) {
                    this.zzagX = n4;
                    this.zza("XML config - log level", n4);
                }
            }
            int n5;
            if (zzanw.zzahZ >= 0) {
                n5 = 1;
            }
            else {
                n5 = 0;
            }
            if (n5 != 0) {
                final int zzahZ = zzanw.zzahZ;
                this.zzahZ = zzahZ;
                this.zzaiP = true;
                this.zzb("XML config - dispatch period (sec)", zzahZ);
            }
            if (zzanw.zzaia != -1) {
                break;
            }
            return;
        }
        final boolean b = zzanw.zzaia == 1;
        this.zzadF = b;
        this.zzaiQ = true;
        this.zzb("XML config - dry run", b);
    }
    
    public final String zzjG() {
        this.zzkD();
        return this.zzaeH;
    }
    
    public final String zzjH() {
        this.zzkD();
        return this.zzaeI;
    }
    
    public final boolean zzmg() {
        this.zzkD();
        return false;
    }
    
    public final boolean zzmh() {
        this.zzkD();
        return this.zzaiQ;
    }
    
    public final boolean zzmi() {
        this.zzkD();
        return this.zzadF;
    }
}
