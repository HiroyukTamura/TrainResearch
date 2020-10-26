// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import java.util.List;
import android.util.Log;
import java.util.regex.Pattern;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLSession;
import java.io.OutputStream;
import java.net.SocketException;
import java.io.InputStream;
import java.nio.channels.SocketChannel;
import java.net.SocketAddress;
import javax.net.ssl.HandshakeCompletedListener;
import java.net.InetAddress;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class TlsOnlySocketFactory extends SSLSocketFactory
{
    private static final String TAG = "TlsOnlySocketFactory";
    private final boolean compatible;
    private final SSLSocketFactory delegate;
    
    public TlsOnlySocketFactory() {
        this.delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
        this.compatible = false;
    }
    
    public TlsOnlySocketFactory(final SSLSocketFactory delegate) {
        this.delegate = delegate;
        this.compatible = false;
    }
    
    public TlsOnlySocketFactory(final SSLSocketFactory delegate, final boolean compatible) {
        this.delegate = delegate;
        this.compatible = compatible;
    }
    
    private Socket makeSocketSafe(final Socket socket) {
        Socket socket2 = socket;
        if (socket instanceof SSLSocket) {
            socket2 = new TlsOnlySSLSocket((SSLSocket)socket, this.compatible);
        }
        return socket2;
    }
    
    @Override
    public Socket createSocket(final String s, final int n) throws IOException {
        return this.makeSocketSafe(this.delegate.createSocket(s, n));
    }
    
    @Override
    public Socket createSocket(final String s, final int n, final InetAddress inetAddress, final int n2) throws IOException {
        return this.makeSocketSafe(this.delegate.createSocket(s, n, inetAddress, n2));
    }
    
    @Override
    public Socket createSocket(final InetAddress inetAddress, final int n) throws IOException {
        return this.makeSocketSafe(this.delegate.createSocket(inetAddress, n));
    }
    
    @Override
    public Socket createSocket(final InetAddress inetAddress, final int n, final InetAddress inetAddress2, final int n2) throws IOException {
        return this.makeSocketSafe(this.delegate.createSocket(inetAddress, n, inetAddress2, n2));
    }
    
    @Override
    public Socket createSocket(final Socket socket, final String s, final int n, final boolean b) throws IOException {
        return this.makeSocketSafe(this.delegate.createSocket(socket, s, n, b));
    }
    
    @Override
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }
    
    @Override
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }
    
    public class DelegateSSLSocket extends SSLSocket
    {
        protected final SSLSocket delegate;
        
        DelegateSSLSocket(final SSLSocket delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public void addHandshakeCompletedListener(final HandshakeCompletedListener handshakeCompletedListener) {
            this.delegate.addHandshakeCompletedListener(handshakeCompletedListener);
        }
        
        @Override
        public void bind(final SocketAddress bindpoint) throws IOException {
            this.delegate.bind(bindpoint);
        }
        
        @Override
        public void close() throws IOException {
            synchronized (this) {
                this.delegate.close();
            }
        }
        
        @Override
        public void connect(final SocketAddress endpoint) throws IOException {
            this.delegate.connect(endpoint);
        }
        
        @Override
        public void connect(final SocketAddress endpoint, final int timeout) throws IOException {
            this.delegate.connect(endpoint, timeout);
        }
        
        @Override
        public boolean equals(final Object obj) {
            return this.delegate.equals(obj);
        }
        
        @Override
        public SocketChannel getChannel() {
            return this.delegate.getChannel();
        }
        
        @Override
        public boolean getEnableSessionCreation() {
            return this.delegate.getEnableSessionCreation();
        }
        
        @Override
        public String[] getEnabledCipherSuites() {
            return this.delegate.getEnabledCipherSuites();
        }
        
        @Override
        public String[] getEnabledProtocols() {
            return this.delegate.getEnabledProtocols();
        }
        
        @Override
        public InetAddress getInetAddress() {
            return this.delegate.getInetAddress();
        }
        
        @Override
        public InputStream getInputStream() throws IOException {
            return this.delegate.getInputStream();
        }
        
        @Override
        public boolean getKeepAlive() throws SocketException {
            return this.delegate.getKeepAlive();
        }
        
        @Override
        public InetAddress getLocalAddress() {
            return this.delegate.getLocalAddress();
        }
        
        @Override
        public int getLocalPort() {
            return this.delegate.getLocalPort();
        }
        
        @Override
        public SocketAddress getLocalSocketAddress() {
            return this.delegate.getLocalSocketAddress();
        }
        
        @Override
        public boolean getNeedClientAuth() {
            return this.delegate.getNeedClientAuth();
        }
        
        @Override
        public boolean getOOBInline() throws SocketException {
            return this.delegate.getOOBInline();
        }
        
        @Override
        public OutputStream getOutputStream() throws IOException {
            return this.delegate.getOutputStream();
        }
        
        @Override
        public int getPort() {
            return this.delegate.getPort();
        }
        
        @Override
        public int getReceiveBufferSize() throws SocketException {
            synchronized (this) {
                return this.delegate.getReceiveBufferSize();
            }
        }
        
        @Override
        public SocketAddress getRemoteSocketAddress() {
            return this.delegate.getRemoteSocketAddress();
        }
        
        @Override
        public boolean getReuseAddress() throws SocketException {
            return this.delegate.getReuseAddress();
        }
        
        @Override
        public int getSendBufferSize() throws SocketException {
            synchronized (this) {
                return this.delegate.getSendBufferSize();
            }
        }
        
        @Override
        public SSLSession getSession() {
            return this.delegate.getSession();
        }
        
        @Override
        public int getSoLinger() throws SocketException {
            return this.delegate.getSoLinger();
        }
        
        @Override
        public int getSoTimeout() throws SocketException {
            synchronized (this) {
                return this.delegate.getSoTimeout();
            }
        }
        
        @Override
        public String[] getSupportedCipherSuites() {
            return this.delegate.getSupportedCipherSuites();
        }
        
        @Override
        public String[] getSupportedProtocols() {
            return this.delegate.getSupportedProtocols();
        }
        
        @Override
        public boolean getTcpNoDelay() throws SocketException {
            return this.delegate.getTcpNoDelay();
        }
        
        @Override
        public int getTrafficClass() throws SocketException {
            return this.delegate.getTrafficClass();
        }
        
        @Override
        public boolean getUseClientMode() {
            return this.delegate.getUseClientMode();
        }
        
        @Override
        public boolean getWantClientAuth() {
            return this.delegate.getWantClientAuth();
        }
        
        @Override
        public boolean isBound() {
            return this.delegate.isBound();
        }
        
        @Override
        public boolean isClosed() {
            return this.delegate.isClosed();
        }
        
        @Override
        public boolean isConnected() {
            return this.delegate.isConnected();
        }
        
        @Override
        public boolean isInputShutdown() {
            return this.delegate.isInputShutdown();
        }
        
        @Override
        public boolean isOutputShutdown() {
            return this.delegate.isOutputShutdown();
        }
        
        @Override
        public void removeHandshakeCompletedListener(final HandshakeCompletedListener handshakeCompletedListener) {
            this.delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
        }
        
        @Override
        public void sendUrgentData(final int data) throws IOException {
            this.delegate.sendUrgentData(data);
        }
        
        @Override
        public void setEnableSessionCreation(final boolean enableSessionCreation) {
            this.delegate.setEnableSessionCreation(enableSessionCreation);
        }
        
        @Override
        public void setEnabledCipherSuites(final String[] enabledCipherSuites) {
            this.delegate.setEnabledCipherSuites(enabledCipherSuites);
        }
        
        @Override
        public void setEnabledProtocols(final String[] enabledProtocols) {
            this.delegate.setEnabledProtocols(enabledProtocols);
        }
        
        @Override
        public void setKeepAlive(final boolean keepAlive) throws SocketException {
            this.delegate.setKeepAlive(keepAlive);
        }
        
        @Override
        public void setNeedClientAuth(final boolean needClientAuth) {
            this.delegate.setNeedClientAuth(needClientAuth);
        }
        
        @Override
        public void setOOBInline(final boolean oobInline) throws SocketException {
            this.delegate.setOOBInline(oobInline);
        }
        
        @Override
        public void setPerformancePreferences(final int connectionTime, final int latency, final int bandwidth) {
            this.delegate.setPerformancePreferences(connectionTime, latency, bandwidth);
        }
        
        @Override
        public void setReceiveBufferSize(final int receiveBufferSize) throws SocketException {
            synchronized (this) {
                this.delegate.setReceiveBufferSize(receiveBufferSize);
            }
        }
        
        @Override
        public void setReuseAddress(final boolean reuseAddress) throws SocketException {
            this.delegate.setReuseAddress(reuseAddress);
        }
        
        @Override
        public void setSendBufferSize(final int sendBufferSize) throws SocketException {
            synchronized (this) {
                this.delegate.setSendBufferSize(sendBufferSize);
            }
        }
        
        @Override
        public void setSoLinger(final boolean on, final int linger) throws SocketException {
            this.delegate.setSoLinger(on, linger);
        }
        
        @Override
        public void setSoTimeout(final int soTimeout) throws SocketException {
            synchronized (this) {
                this.delegate.setSoTimeout(soTimeout);
            }
        }
        
        @Override
        public void setTcpNoDelay(final boolean tcpNoDelay) throws SocketException {
            this.delegate.setTcpNoDelay(tcpNoDelay);
        }
        
        @Override
        public void setTrafficClass(final int trafficClass) throws SocketException {
            this.delegate.setTrafficClass(trafficClass);
        }
        
        @Override
        public void setUseClientMode(final boolean useClientMode) {
            this.delegate.setUseClientMode(useClientMode);
        }
        
        @Override
        public void setWantClientAuth(final boolean wantClientAuth) {
            this.delegate.setWantClientAuth(wantClientAuth);
        }
        
        @Override
        public void shutdownInput() throws IOException {
            this.delegate.shutdownInput();
        }
        
        @Override
        public void shutdownOutput() throws IOException {
            this.delegate.shutdownOutput();
        }
        
        @Override
        public void startHandshake() throws IOException {
            this.delegate.startHandshake();
        }
        
        @Override
        public String toString() {
            return this.delegate.toString();
        }
    }
    
    private class TlsOnlySSLSocket extends DelegateSSLSocket
    {
        final boolean compatible;
        
        private TlsOnlySSLSocket(final SSLSocket sslSocket, final boolean compatible) {
            super(sslSocket);
            this.compatible = compatible;
            if (compatible) {
                final ArrayList list = new ArrayList((Collection<? extends E>)Arrays.asList(sslSocket.getEnabledProtocols()));
                list.remove("SSLv2");
                list.remove("SSLv3");
                super.setEnabledProtocols(list.toArray(new String[list.size()]));
                final ArrayList<String> list2 = new ArrayList<String>(10);
                final Pattern compile = Pattern.compile(".*(EXPORT|NULL).*");
                final String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
                for (int length = enabledCipherSuites.length, i = 0; i < length; ++i) {
                    final String s = enabledCipherSuites[i];
                    if (!compile.matcher(s).matches()) {
                        list2.add(s);
                    }
                }
                super.setEnabledCipherSuites(list2.toArray(new String[list2.size()]));
                return;
            }
            final ArrayList list3 = new ArrayList((Collection<? extends E>)Arrays.asList(sslSocket.getSupportedProtocols()));
            list3.remove("SSLv2");
            list3.remove("SSLv3");
            super.setEnabledProtocols(list3.toArray(new String[list3.size()]));
            final ArrayList<String> list4 = new ArrayList<String>(10);
            final Pattern compile2 = Pattern.compile(".*(_DES|DH_|DSS|EXPORT|MD5|NULL|RC4).*");
            final String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
            for (int length2 = supportedCipherSuites.length, j = 0; j < length2; ++j) {
                final String s2 = supportedCipherSuites[j];
                if (!compile2.matcher(s2).matches()) {
                    list4.add(s2);
                }
            }
            super.setEnabledCipherSuites(list4.toArray(new String[list4.size()]));
        }
        
        @Override
        public void setEnabledProtocols(final String[] array) {
            String[] enabledProtocols = array;
            if (array != null) {
                enabledProtocols = array;
                if (array.length == 1) {
                    enabledProtocols = array;
                    if ("SSLv3".equals(array[0])) {
                        List<String> c;
                        if (this.compatible) {
                            c = Arrays.asList(this.delegate.getEnabledProtocols());
                        }
                        else {
                            c = Arrays.asList(this.delegate.getSupportedProtocols());
                        }
                        final ArrayList obj = new ArrayList(c);
                        if (obj.size() > 1) {
                            obj.remove("SSLv2");
                            obj.remove("SSLv3");
                        }
                        else {
                            Log.w("TlsOnlySocketFactory", "SSL stuck with protocol available for " + String.valueOf(obj));
                        }
                        enabledProtocols = (String[])obj.toArray((Object[])new String[obj.size()]);
                    }
                }
            }
            super.setEnabledProtocols(enabledProtocols);
        }
    }
}
