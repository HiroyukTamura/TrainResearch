// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import ch.boye.httpclientandroidlib.conn.ClientConnectionOperator;
import ch.boye.httpclientandroidlib.conn.scheme.SchemeRegistry;
import ch.boye.httpclientandroidlib.params.HttpParams;
import ch.boye.httpclientandroidlib.impl.conn.tsccm.ThreadSafeClientConnManager;

public class MyThreadSafeClientConnManager extends ThreadSafeClientConnManager
{
    public MyThreadSafeClientConnManager(final HttpParams httpParams, final SchemeRegistry schemeRegistry) {
        super(httpParams, schemeRegistry);
    }
    
    protected ClientConnectionOperator createConnectionOperator(final SchemeRegistry schemeRegistry) {
        return (ClientConnectionOperator)new MyDefaultClientConnectionOperator(schemeRegistry);
    }
}
