// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

public interface Freezable<T>
{
    T freeze();
    
    boolean isDataValid();
}
