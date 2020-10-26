// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException
{
    private final int zzakt;
    
    public GooglePlayServicesRepairableException(final int zzakt, final String s, final Intent intent) {
        super(s, intent);
        this.zzakt = zzakt;
    }
    
    public int getConnectionStatusCode() {
        return this.zzakt;
    }
}
