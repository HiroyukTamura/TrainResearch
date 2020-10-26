// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.firebase.FirebaseOptions;
import android.support.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Set;
import android.support.annotation.Nullable;
import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public final class aac
{
    private static final AtomicReference<aac> zzbVi;
    
    static {
        zzbVi = new AtomicReference<aac>();
    }
    
    private aac(final Context context) {
    }
    
    @Nullable
    public static aac zzJZ() {
        return aac.zzbVi.get();
    }
    
    public static Set<String> zzKa() {
        return Collections.emptySet();
    }
    
    public static aac zzbL(final Context context) {
        aac.zzbVi.compareAndSet(null, new aac(context));
        return aac.zzbVi.get();
    }
    
    public static void zze(@NonNull final FirebaseApp firebaseApp) {
    }
    
    public static FirebaseOptions zzhq(@NonNull final String s) {
        return null;
    }
}
