// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

final class zzcjk
{
    final String mAppId;
    final String mName;
    final String mOrigin;
    final Object mValue;
    final long zzbuC;
    
    zzcjk(final String mAppId, final String mOrigin, final String mName, final long zzbuC, final Object mValue) {
        zzbo.zzcF(mAppId);
        zzbo.zzcF(mName);
        zzbo.zzu(mValue);
        this.mAppId = mAppId;
        this.mOrigin = mOrigin;
        this.mName = mName;
        this.zzbuC = zzbuC;
        this.mValue = mValue;
    }
}
