/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.util.Base64
 *  android.util.Log
 */
package jp.co.jreast.jreastapp.commuter.s;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b {
    private static final String a = "b";
    private static final Object b = new Object();
    private static b c;
    private Cipher d;
    private Cipher e;

    static {
        a.a();
    }

    private b() {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("0A1B2C3D4E85F697".getBytes(Charset.defaultCharset()), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec("6F0E1D29C3B47A58".getBytes(Charset.defaultCharset()));
            this.d = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.d.init(2, (Key)secretKeySpec, ivParameterSpec);
            this.e = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.e.init(1, (Key)secretKeySpec, ivParameterSpec);
            return;
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(String string2) {
        Object object = b;
        synchronized (object) {
            try {
                try {
                    return new String(b.b().d.doFinal(Base64.decode((String)string2, (int)2)), Charset.defaultCharset());
                }
                catch (Exception exception) {
                    throw new IllegalStateException(exception);
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(byte[] object) {
        Object object2 = b;
        synchronized (object2) {
            if (object == null) return "";
            try {
                int n2 = ((byte[])object).length;
                if (n2 != 0) {
                    try {
                        return Base64.encodeToString((byte[])b.b().e.doFinal((byte[])object), (int)2);
                    }
                    catch (Exception exception) {
                        throw new IllegalStateException(exception);
                    }
                }
                return "";
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(String string2) {
        Object object = b;
        synchronized (object) {
            return b.a(string2.getBytes(Charset.defaultCharset()));
        }
    }

    private static b b() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    public static final class jp.co.jreast.jreastapp.commuter.s.b$a {
        private static final byte[] a = jp.co.jreast.jreastapp.commuter.s.b$a.g();

        private jp.co.jreast.jreastapp.commuter.s.b$a() {
        }

        public static void a() {
            jp.co.jreast.jreastapp.commuter.s.b$a.c();
            jp.co.jreast.jreastapp.commuter.s.b$a.d();
        }

        private static void c() {
            if (Build.VERSION.SDK_INT >= 16) {
                int n2;
                block5 : {
                    if (Build.VERSION.SDK_INT > 18) {
                        return;
                    }
                    try {
                        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", byte[].class).invoke(null, new Object[]{jp.co.jreast.jreastapp.commuter.s.b$a.e()});
                        n2 = (Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", String.class, Long.TYPE).invoke(null, "/dev/urandom", 1024);
                        if (n2 != 1024) break block5;
                        return;
                    }
                    catch (Exception exception) {
                        throw new SecurityException("Failed to seed OpenSSL PRNG", exception);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected number of bytes read from Linux PRNG: ");
                stringBuilder.append(n2);
                throw new IOException(stringBuilder.toString());
            }
        }

        private static void d() {
            block5 : {
                String string2;
                StringBuilder stringBuilder;
                if (Build.VERSION.SDK_INT > 18) {
                    return;
                }
                Object object = Security.getProviders("SecureRandom.SHA1PRNG");
                if (object == null || ((Provider[])object).length < 1 || !b.class.equals(object[0].getClass())) {
                    Security.insertProviderAt(new b(), 1);
                }
                if (!b.class.equals(((SecureRandom)(object = new SecureRandom())).getProvider().getClass())) {
                    string2 = a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("new SecureRandom() backed by wrong Provider: ");
                    stringBuilder.append(((SecureRandom)object).getProvider().getClass());
                    Log.e((String)string2, (String)stringBuilder.toString());
                }
                try {
                    object = SecureRandom.getInstance("SHA1PRNG");
                    if (b.class.equals(((SecureRandom)object).getProvider().getClass())) break block5;
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    throw new SecurityException("SHA1PRNG not available", noSuchAlgorithmException);
                }
                string2 = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: ");
                stringBuilder.append(((SecureRandom)object).getProvider().getClass());
                Log.e((String)string2, (String)stringBuilder.toString());
            }
        }

        private static byte[] e() {
            try {
                byte[] arrby = new byte[]();
                DataOutputStream dataOutputStream = new DataOutputStream((OutputStream)arrby);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(a);
                dataOutputStream.close();
                arrby = arrby.toByteArray();
                return arrby;
            }
            catch (IOException iOException) {
                throw new SecurityException("Failed to generate seed", iOException);
            }
        }

        private static String f() {
            try {
                String string2 = (String)Build.class.getField("SERIAL").get(null);
                return string2;
            }
            catch (Exception exception) {
                return null;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private static byte[] g() {
            byte[] arrby = new byte[]();
            String string2 = Build.FINGERPRINT;
            if (string2 != null) {
                arrby.append(string2);
            }
            if ((string2 = jp.co.jreast.jreastapp.commuter.s.b$a.f()) != null) {
                arrby.append(string2);
            }
            try {
                return arrby.toString().getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }

        public static class a
        extends SecureRandomSpi {
            private static final File a = new File("/dev/urandom");
            private static final Object b = new Object();
            private static DataInputStream c;
            private static OutputStream d;
            private boolean e;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private DataInputStream a() {
                Object object = b;
                synchronized (object) {
                    DataInputStream dataInputStream = c;
                    if (dataInputStream != null) return c;
                    try {
                        c = new DataInputStream(new FileInputStream(a));
                        return c;
                    }
                    catch (IOException iOException) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to open ");
                        stringBuilder.append(a);
                        stringBuilder.append(" for reading");
                        throw new SecurityException(stringBuilder.toString(), iOException);
                    }
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private OutputStream b() {
                Object object = b;
                synchronized (object) {
                    if (d != null) return d;
                    d = new FileOutputStream(a);
                    return d;
                }
            }

            @Override
            protected byte[] engineGenerateSeed(int n2) {
                byte[] arrby = new byte[n2];
                this.engineNextBytes(arrby);
                return arrby;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            protected void engineNextBytes(byte[] arrby) {
                DataInputStream dataInputStream;
                Object object;
                if (!this.e) {
                    this.engineSetSeed(jp.co.jreast.jreastapp.commuter.s.b$a.e());
                }
                try {
                    object = b;
                    // MONITORENTER : object
                    dataInputStream = this.a();
                }
                catch (IOException iOException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Failed to read from ");
                    ((StringBuilder)object).append(a);
                    throw new SecurityException(((StringBuilder)object).toString(), iOException);
                }
                dataInputStream.readFully(arrby);
                // MONITOREXIT : dataInputStream
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            protected void engineSetSeed(byte[] arrby) {
                block9 : {
                    Object object = b;
                    // MONITORENTER : object
                    OutputStream outputStream = this.b();
                    // MONITOREXIT : object
                    try {
                        outputStream.write(arrby);
                        outputStream.flush();
                        break block9;
                    }
                    catch (Throwable throwable) {}
                    this.e = true;
                    throw throwable;
                    catch (IOException iOException) {}
                    String string2 = jp.co.jreast.jreastapp.commuter.s.b$a.class.getSimpleName();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Failed to mix seed into ");
                    ((StringBuilder)object).append(a);
                    Log.w((String)string2, (String)((StringBuilder)object).toString());
                }
                this.e = true;
            }
        }

        private static class b
        extends Provider {
            public b() {
                super("LinuxPRNG", 1.0, "A Linux-specific random number provider that uses /dev/urandom");
                this.put("SecureRandom.SHA1PRNG", a.class.getName());
                this.put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
        }

    }

}

