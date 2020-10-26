// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception
{
    private final Intent mIntent;
    
    public UserRecoverableException(final String message, final Intent mIntent) {
        super(message);
        this.mIntent = mIntent;
    }
    
    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}