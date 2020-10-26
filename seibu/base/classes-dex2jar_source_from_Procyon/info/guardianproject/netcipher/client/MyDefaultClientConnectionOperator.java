// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import java.io.IOException;
import java.net.Socket;
import ch.boye.httpclientandroidlib.conn.scheme.SocketFactory;
import ch.boye.httpclientandroidlib.conn.scheme.Scheme;
import java.net.ConnectException;
import ch.boye.httpclientandroidlib.conn.HttpHostConnectException;
import ch.boye.httpclientandroidlib.params.HttpParams;
import ch.boye.httpclientandroidlib.protocol.HttpContext;
import java.net.InetAddress;
import ch.boye.httpclientandroidlib.HttpHost;
import ch.boye.httpclientandroidlib.conn.OperatedClientConnection;
import ch.boye.httpclientandroidlib.conn.scheme.SchemeRegistry;
import ch.boye.httpclientandroidlib.impl.conn.DefaultClientConnectionOperator;

public class MyDefaultClientConnectionOperator extends DefaultClientConnectionOperator
{
    public MyDefaultClientConnectionOperator(final SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }
    
    public void openConnection(final OperatedClientConnection operatedClientConnection, final HttpHost httpHost, final InetAddress inetAddress, final HttpContext httpContext, final HttpParams httpParams) throws IOException {
        if (operatedClientConnection == null) {
            throw new IllegalArgumentException("Connection must not be null.");
        }
        if (httpHost == null) {
            throw new IllegalArgumentException("Target host must not be null.");
        }
        if (httpParams == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        if (operatedClientConnection.isOpen()) {
            throw new IllegalArgumentException("Connection must not be open.");
        }
        final Scheme scheme = this.schemeRegistry.getScheme(httpHost.getSchemeName());
        final SocketFactory socketFactory = scheme.getSocketFactory();
        final Socket socket = socketFactory.createSocket();
        operatedClientConnection.opening(socket, httpHost);
        try {
            final Socket connectSocket = socketFactory.connectSocket(socket, httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), inetAddress, 0, httpParams);
            Socket socket2 = socket;
            if (socket != connectSocket) {
                socket2 = connectSocket;
                operatedClientConnection.opening(socket2, httpHost);
            }
            this.prepareSocket(socket2, httpContext, httpParams);
            operatedClientConnection.openCompleted(socketFactory.isSecure(socket2), httpParams);
        }
        catch (ConnectException ex) {
            throw new HttpHostConnectException(httpHost, ex);
        }
    }
}
