/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.g;

import c.a.c;
import c.a.g.f;
import c.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class d
extends f {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    d(Method method, Method method2, Method method3, Class<?> class_, Class<?> class_2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = class_;
        this.e = class_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static f b() {
        try {
            Class<?> class_ = Class.forName("org.eclipse.jetty.alpn.ALPN");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("org.eclipse.jetty.alpn.ALPN");
            stringBuilder.append("$Provider");
            Class<?> class_2 = Class.forName(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("org.eclipse.jetty.alpn.ALPN");
            stringBuilder2.append("$ClientProvider");
            Class<?> class_3 = Class.forName(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("org.eclipse.jetty.alpn.ALPN");
            stringBuilder3.append("$ServerProvider");
            Class<?> class_4 = Class.forName(stringBuilder3.toString());
            return new d(class_.getMethod("put", SSLSocket.class, class_2), class_.getMethod("get", SSLSocket.class), class_.getMethod("remove", SSLSocket.class), class_3, class_4);
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            return null;
        }
    }

    @Nullable
    @Override
    public String a(SSLSocket object) {
        block5 : {
            block4 : {
                object = (a)Proxy.getInvocationHandler(this.b.invoke(null, object));
                if (((a)object).a || ((a)object).b != null) break block4;
                f.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (!((a)object).a) break block5;
            return null;
        }
        try {
            object = ((a)object).b;
            return object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw c.a("unable to get selected protocol", reflectiveOperationException);
        }
    }

    @Override
    public void a(SSLSocket sSLSocket, String object, List<y> object2) {
        Object object3 = d.a(object2);
        try {
            object = f.class.getClassLoader();
            object2 = this.d;
            Class<?> class_ = this.e;
            object3 = new a((List<String>)object3);
            object = Proxy.newProxyInstance((ClassLoader)object, new Class[]{object2, class_}, (InvocationHandler)object3);
            this.a.invoke(null, sSLSocket, object);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw c.a("unable to set alpn", reflectiveOperationException);
        }
    }

    @Override
    public void b(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, sSLSocket);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw c.a("unable to remove alpn", reflectiveOperationException);
        }
    }

    private static class a
    implements InvocationHandler {
        boolean a;
        String b;
        private final List<String> c;

        a(List<String> list) {
            this.c = list;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public Object invoke(Object object, Method method, Object[] arrobject) {
            void var1_7;
            String string2;
            block8 : {
                void var2_10;
                void var1_4;
                List list;
                void var3_11;
                int n2;
                String string3 = var2_10.getName();
                Class<?> class_ = var2_10.getReturnType();
                void var1_2 = var3_11;
                if (var3_11 == null) {
                    String[] arrstring = c.b;
                }
                if (string3.equals("supports") && Boolean.TYPE == class_) {
                    return true;
                }
                if (string3.equals("unsupported") && Void.TYPE == class_) {
                    this.a = true;
                    return null;
                }
                if (string3.equals("protocols") && ((void)var1_4).length == 0) {
                    return this.c;
                }
                if ((string3.equals("selectProtocol") || string3.equals("select")) && String.class == class_ && ((void)var1_4).length == 1 && var1_4[0] instanceof List) {
                    list = (List)var1_4[0];
                    n2 = list.size();
                } else {
                    if ((string3.equals("protocolSelected") || string3.equals("selected")) && ((void)var1_4).length == 1) {
                        this.b = (String)var1_4[0];
                        return null;
                    }
                    return var2_10.invoke(this, (Object[])var1_4);
                }
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!this.c.contains(list.get(i2))) continue;
                    Object e2 = list.get(i2);
                    break block8;
                }
                String string4 = this.c.get(0);
            }
            this.b = string2 = (String)var1_7;
            return string2;
        }
    }

}

