package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzbcq extends SSLSocketFactory {
    private SSLSocketFactory zzefj = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzbcn zzefk;

    zzbcq(zzbcn zzbcn) {
        this.zzefk = zzbcn;
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (this.zzefk.zzefc > 0) {
            socket.setReceiveBufferSize(this.zzefk.zzefc);
        }
        this.zzefk.zza(socket);
        return socket;
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return zzb(this.zzefj.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zzb(this.zzefj.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zzb(this.zzefj.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zzb(this.zzefj.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zzb(this.zzefj.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzefj.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzefj.getSupportedCipherSuites();
    }
}
