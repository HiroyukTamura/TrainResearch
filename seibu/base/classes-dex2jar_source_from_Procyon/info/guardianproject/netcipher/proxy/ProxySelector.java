// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.proxy;

import java.util.List;
import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;

public class ProxySelector extends java.net.ProxySelector
{
    private ArrayList<Proxy> listProxies;
    
    public ProxySelector() {
        this.listProxies = new ArrayList<Proxy>();
    }
    
    public void addProxy(final Proxy.Type type, final String hostname, final int port) {
        this.listProxies.add(new Proxy(type, new InetSocketAddress(hostname, port)));
    }
    
    @Override
    public void connectFailed(final URI uri, final SocketAddress socketAddress, final IOException ex) {
        Log.w("ProxySelector", "could not connect to " + socketAddress.toString() + ": " + ex.getMessage());
    }
    
    @Override
    public List<Proxy> select(final URI uri) {
        return this.listProxies;
    }
}
