/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.g;

import c.a.g.a;
import c.a.g.b;
import c.a.g.c;
import c.a.g.d;
import c.a.i.e;
import c.x;
import c.y;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class f {
    private static final f a = f.b();
    private static final Logger b = Logger.getLogger(x.class.getName());

    public static List<String> a(List<y> list) {
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            y y2 = list.get(i2);
            if (y2 == y.a) continue;
            arrayList.add(y2.toString());
        }
        return arrayList;
    }

    private static f b() {
        f f2 = a.a();
        if (f2 != null) {
            return f2;
        }
        if (f.d() && (f2 = b.b()) != null) {
            return f2;
        }
        f2 = c.b();
        if (f2 != null) {
            return f2;
        }
        f2 = d.b();
        if (f2 != null) {
            return f2;
        }
        return new f();
    }

    static byte[] b(List<y> list) {
        d.c c2 = new d.c();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            y y2 = list.get(i2);
            if (y2 == y.a) continue;
            c2.b(y2.toString().length());
            c2.a(y2.toString());
        }
        return c2.r();
    }

    public static f c() {
        return a;
    }

    public static boolean d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public c.a.i.c a(X509TrustManager x509TrustManager) {
        return new c.a.i.a(this.b(x509TrustManager));
    }

    public Object a(String string2) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(string2);
        }
        return null;
    }

    @Nullable
    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(int n2, String string2, Throwable throwable) {
        Level level = n2 == 5 ? Level.WARNING : Level.INFO;
        b.log(level, string2, throwable);
    }

    public void a(String string2, Object object) {
        CharSequence charSequence = string2;
        if (object == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        this.a(5, (String)charSequence, (Throwable)object);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int n2) {
        socket.connect(inetSocketAddress, n2);
    }

    public void a(SSLSocket sSLSocket, String string2, List<y> list) {
    }

    public e b(X509TrustManager x509TrustManager) {
        return new c.a.i.b(x509TrustManager.getAcceptedIssuers());
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String string2) {
        return true;
    }

    public SSLContext x_() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            return sSLContext;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalStateException("No TLS provider", noSuchAlgorithmException);
        }
    }
}

