// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote;

import android.content.Context;

public final class SSLRequestFactory_ extends SSLRequestFactory
{
    private Context context_;
    
    private SSLRequestFactory_(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
    
    public static SSLRequestFactory_ getInstance_(final Context context) {
        return new SSLRequestFactory_(context);
    }
    
    private void init_() {
        this.init();
    }
    
    public void rebind(final Context context_) {
        this.context_ = context_;
        this.init_();
    }
}
