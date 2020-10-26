// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzfw implements zzfy
{
    @Override
    public final HttpURLConnection zzc(final URL url) throws IOException {
        return (HttpURLConnection)url.openConnection();
    }
}
