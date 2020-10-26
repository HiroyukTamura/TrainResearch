// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

interface zzk<TResult>
{
    void cancel();
    
    void onComplete(@NonNull final Task<TResult> p0);
}
