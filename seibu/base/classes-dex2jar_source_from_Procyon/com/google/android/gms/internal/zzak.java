// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.HttpClient;

public final class zzak implements zzan
{
    private HttpClient zzaA;
    
    public zzak(final HttpClient zzaA) {
        this.zzaA = zzaA;
    }
    
    private static void zza(final HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, final zzp<?> zzp) throws zza {
        final byte[] zzg = zzp.zzg();
        if (zzg != null) {
            httpEntityEnclosingRequestBase.setEntity((HttpEntity)new ByteArrayEntity(zzg));
        }
    }
    
    private static void zza(final HttpUriRequest httpUriRequest, final Map<String, String> map) {
        for (final String s : map.keySet()) {
            httpUriRequest.setHeader(s, (String)map.get(s));
        }
    }
    
    @Override
    public final HttpResponse zza(final zzp<?> zzp, final Map<String, String> map) throws IOException, zza {
        Object o = null;
        switch (zzp.getMethod()) {
            default: {
                throw new IllegalStateException("Unknown request method.");
            }
            case -1: {
                o = new HttpGet(zzp.getUrl());
                break;
            }
            case 0: {
                o = new HttpGet(zzp.getUrl());
                break;
            }
            case 3: {
                o = new HttpDelete(zzp.getUrl());
                break;
            }
            case 1: {
                o = new HttpPost(zzp.getUrl());
                ((HttpPost)o).addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase)o, zzp);
                break;
            }
            case 2: {
                o = new HttpPut(zzp.getUrl());
                ((HttpPut)o).addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase)o, zzp);
                break;
            }
            case 4: {
                o = new HttpHead(zzp.getUrl());
                break;
            }
            case 5: {
                o = new HttpOptions(zzp.getUrl());
                break;
            }
            case 6: {
                o = new HttpTrace(zzp.getUrl());
                break;
            }
            case 7: {
                o = new zzal(zzp.getUrl());
                ((zzal)o).addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase)o, zzp);
                break;
            }
        }
        zza((HttpUriRequest)o, map);
        zza((HttpUriRequest)o, zzp.getHeaders());
        final HttpParams params = ((HttpUriRequest)o).getParams();
        final int zzi = zzp.zzi();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzi);
        return this.zzaA.execute((HttpUriRequest)o);
    }
}
