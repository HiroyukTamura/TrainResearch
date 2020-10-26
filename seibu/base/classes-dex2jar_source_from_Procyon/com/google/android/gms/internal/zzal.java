// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class zzal extends HttpEntityEnclosingRequestBase
{
    public zzal() {
    }
    
    public zzal(final String str) {
        this.setURI(URI.create(str));
    }
    
    public final String getMethod() {
        return "PATCH";
    }
}
