/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  javax.annotation.Nullable
 */
package c.a.g;

import android.os.Build;
import android.util.Log;
import c.a.g.e;
import c.a.g.f;
import c.y;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class a
extends f {
    private final Class<?> a;
    private final e<Socket> b;
    private final e<Socket> c;
    private final e<Socket> d;
    private final e<Socket> e;
    private final c f = c.a();

    a(Class<?> class_, e<Socket> e2, e<Socket> e3, e<Socket> e4, e<Socket> e5) {
        this.a = class_;
        this.b = e2;
        this.c = e3;
        this.d = e4;
        this.e = e5;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static f a() {
        block4 : {
            try {
                var0 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                ** GOTO lbl7
            }
            catch (ClassNotFoundException var0_1) {}
            try {
                var0 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
lbl7: // 2 sources:
                var3_3 = new e<Socket>(null, "setUseSessionTickets", new Class[]{Boolean.TYPE});
                var4_4 = new e<Socket>(null, "setHostname", new Class[]{String.class});
                if (!a.b()) break block4;
                var1_5 = new e<Socket>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                var2_6 = new e<T>(null, "setAlpnProtocols", new Class[]{byte[].class});
                return new a((Class<?>)var0, var3_3, var4_4, var1_5, (e<Socket>)var2_7);
            }
            catch (ClassNotFoundException var0_2) {
                return null;
            }
        }
        var2_8 = var1_5 = null;
        return new a((Class<?>)var0, var3_3, var4_4, var1_5, (e<Socket>)var2_7);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string2, Class<?> class_, Object object) {
        try {
            return (Boolean)class_.getMethod("isCleartextTrafficPermitted", String.class).invoke(object, string2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return this.b(string2, class_, object);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean b() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b(String string2, Class<?> class_, Object object) {
        try {
            return (Boolean)class_.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(object, new Object[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return super.b(string2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public c.a.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> class_ = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(class_.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), class_.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        }
        catch (Exception exception) {
            return super.a(x509TrustManager);
        }
    }

    @Override
    public Object a(String string2) {
        return this.f.a(string2);
    }

    @Nullable
    @Override
    public String a(SSLSocket object) {
        byte[] arrby = this.d;
        Object var2_3 = null;
        if (arrby == null) {
            return null;
        }
        if (!this.d.a((Socket)object)) {
            return null;
        }
        arrby = (byte[])this.d.d((Socket)object, new Object[0]);
        object = var2_3;
        if (arrby != null) {
            object = new String(arrby, c.a.c.e);
        }
        return object;
    }

    @Override
    public void a(int n2, String string2, Throwable throwable) {
        int n3 = 5;
        if (n2 != 5) {
            n3 = 3;
        }
        CharSequence charSequence = string2;
        if (throwable != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append('\n');
            ((StringBuilder)charSequence).append(Log.getStackTraceString((Throwable)throwable));
            charSequence = ((StringBuilder)charSequence).toString();
        }
        n2 = 0;
        int n4 = ((String)charSequence).length();
        block0 : while (n2 < n4) {
            int n5 = ((String)charSequence).indexOf(10, n2);
            if (n5 == -1) {
                n5 = n4;
            }
            do {
                int n6 = Math.min(n5, n2 + 4000);
                Log.println((int)n3, (String)"OkHttp", (String)((String)charSequence).substring(n2, n6));
                if (n6 >= n5) {
                    n2 = n6 + 1;
                    continue block0;
                }
                n2 = n6;
            } while (true);
        }
    }

    @Override
    public void a(String string2, Object object) {
        if (!this.f.a(object)) {
            this.a(5, string2, null);
        }
    }

    @Override
    public void a(Socket socket, InetSocketAddress serializable, int n2) {
        try {
            socket.connect((SocketAddress)serializable, n2);
            return;
        }
        catch (ClassCastException classCastException) {
            if (Build.VERSION.SDK_INT == 26) {
                serializable = new IOException("Exception in connect");
                ((Throwable)serializable).initCause(classCastException);
                throw serializable;
            }
            throw classCastException;
        }
        catch (SecurityException securityException) {
            serializable = new IOException("Exception in connect");
            ((Throwable)serializable).initCause(securityException);
            throw serializable;
        }
        catch (AssertionError assertionError) {
            if (c.a.c.a(assertionError)) {
                throw new IOException((Throwable)((Object)assertionError));
            }
            throw assertionError;
        }
    }

    @Override
    public void a(SSLSocket sSLSocket, String arrby, List<y> list) {
        if (arrby != null) {
            this.b.b(sSLSocket, true);
            this.c.b(sSLSocket, new Object[]{arrby});
        }
        if (this.e != null && this.e.a(sSLSocket)) {
            arrby = a.b(list);
            this.e.d(sSLSocket, new Object[]{arrby});
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public c.a.i.e b(X509TrustManager x509TrustManager) {
        try {
            Method method = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            return new b(x509TrustManager, method);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return super.b(x509TrustManager);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean b(String string2) {
        try {
            Class<?> class_ = Class.forName("android.security.NetworkSecurityPolicy");
            return this.a(string2, class_, class_.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            throw c.a.c.a("unable to determine cleartext support", exception);
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            return super.b(string2);
        }
    }

    static final class a
    extends c.a.i.c {
        private final Object a;
        private final Method b;

        a(Object object, Method method) {
            this.a = object;
            this.b = method;
        }

        @Override
        public List<Certificate> a(List<Certificate> object, String object2) {
            try {
                object = object.toArray(new X509Certificate[object.size()]);
                object = (List)this.b.invoke(this.a, object, "RSA", object2);
                return object;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError(illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                object2 = new SSLPeerUnverifiedException(invocationTargetException.getMessage());
                ((Throwable)object2).initCause(invocationTargetException);
                throw object2;
            }
        }

        public boolean equals(Object object) {
            return object instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class b
    implements c.a.i.e {
        private final X509TrustManager a;
        private final Method b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        @Override
        public X509Certificate a(X509Certificate object) {
            block4 : {
                object = (TrustAnchor)this.b.invoke(this.a, object);
                if (object == null) break block4;
                try {
                    object = ((TrustAnchor)object).getTrustedCert();
                    return object;
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw c.a.c.a("unable to get issues and signature", illegalAccessException);
                }
                catch (InvocationTargetException invocationTargetException) {
                    return null;
                }
            }
            return null;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof b)) {
                return false;
            }
            object = (b)object;
            return this.a.equals(((b)object).a) && this.b.equals(((b)object).b);
        }

        public int hashCode() {
            return this.a.hashCode() + this.b.hashCode() * 31;
        }
    }

    static final class c {
        private final Method a;
        private final Method b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        static c a() {
            void var2_9;
            void var1_5;
            Method method = null;
            try {
                Class<?> class_ = Class.forName("dalvik.system.CloseGuard");
                Method method2 = class_.getMethod("get", new Class[0]);
                Method method3 = class_.getMethod("open", String.class);
                Method method4 = class_.getMethod("warnIfOpen", new Class[0]);
                method = method2;
                return new c(method, (Method)var2_9, (Method)var1_5);
            }
            catch (Exception exception) {
                return new c(method, (Method)var2_9, (Method)var1_5);
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        Object a(String string2) {
            if (this.a == null) return null;
            try {
                Object object = this.a.invoke(null, new Object[0]);
                this.b.invoke(object, string2);
                return object;
            }
            catch (Exception exception) {
                return null;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean a(Object object) {
            boolean bl2 = false;
            if (object == null) return bl2;
            try {
                this.c.invoke(object, new Object[0]);
                return true;
            }
            catch (Exception exception) {
                return false;
            }
        }
    }

}

