// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import java.util.Collections;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class zzr
{
    public final Set<Scope> zzame;
    
    public zzr(final Set<Scope> s) {
        zzbo.zzu(s);
        this.zzame = Collections.unmodifiableSet((Set<? extends Scope>)s);
    }
}
