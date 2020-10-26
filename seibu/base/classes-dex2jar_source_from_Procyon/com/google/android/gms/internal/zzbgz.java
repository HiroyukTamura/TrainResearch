// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Process;
import android.os.Binder;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import com.google.android.gms.common.util.zzq;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.Context;

public final class zzbgz
{
    private Context mContext;
    
    public zzbgz(final Context mContext) {
        this.mContext = mContext;
    }
    
    public final int checkCallingOrSelfPermission(final String s) {
        return this.mContext.checkCallingOrSelfPermission(s);
    }
    
    public final int checkPermission(final String s, final String s2) {
        return this.mContext.getPackageManager().checkPermission(s, s2);
    }
    
    public final ApplicationInfo getApplicationInfo(final String s, final int n) throws PackageManager$NameNotFoundException {
        return this.mContext.getPackageManager().getApplicationInfo(s, n);
    }
    
    public final PackageInfo getPackageInfo(final String s, final int n) throws PackageManager$NameNotFoundException {
        return this.mContext.getPackageManager().getPackageInfo(s, n);
    }
    
    public final String[] getPackagesForUid(final int n) {
        return this.mContext.getPackageManager().getPackagesForUid(n);
    }
    
    public final CharSequence zzcM(final String s) throws PackageManager$NameNotFoundException {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(s, 0));
    }
    
    @TargetApi(19)
    public final boolean zzf(int n, final String s) {
        final boolean b = false;
        Label_0030: {
            if (!zzq.zzsc()) {
                break Label_0030;
            }
            try {
                ((AppOpsManager)this.mContext.getSystemService("appops")).checkPackage(n, s);
                boolean b2 = true;
                Label_0028: {
                    return b2;
                }
                // iftrue(Label_0028:, n >= packagesForUid.length)
                // iftrue(Label_0028:, packagesForUid == null)
                // iftrue(Label_0083:, !s.equals((Object)packagesForUid[n]))
                while (true) {
                    while (true) {
                        b2 = b;
                        Block_4: {
                            Block_5: {
                                break Block_5;
                                b2 = b;
                                break Block_4;
                            }
                            return true;
                            Label_0083:
                            ++n;
                            continue;
                        }
                        n = 0;
                        continue;
                    }
                    final String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(n);
                    b2 = b;
                    continue;
                }
            }
            // iftrue(Label_0028:, s == null)
            catch (SecurityException ex) {
                return false;
            }
        }
    }
    
    public final boolean zzsl() {
        return Binder.getCallingUid() == Process.myUid() && zzbgy.zzaN(this.mContext);
    }
}
