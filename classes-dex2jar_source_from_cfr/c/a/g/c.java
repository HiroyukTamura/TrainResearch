/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.g;

import c.a.g.f;
import c.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class c
extends f {
    final Method a;
    final Method b;

    c(Method method, Method method2) {
        this.a = method;
        this.b = method2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static c b() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    @Nullable
    @Override
    public String a(SSLSocket object) {
        block3 : {
            object = (String)this.b.invoke(object, new Object[0]);
            if (object == null) break block3;
            try {
                boolean bl2 = ((String)object).equals("");
                if (bl2) break block3;
                return object;
            }
            catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
                throw c.a.c.a("unable to get selected protocols", reflectiveOperationException);
            }
        }
        return null;
    }

    @Override
    public void a(SSLSocket sSLSocket, String object, List<y> list) {
        try {
            object = sSLSocket.getSSLParameters();
            list = c.a(list);
            this.a.invoke(object, new Object[]{list.toArray(new String[list.size()])});
            sSLSocket.setSSLParameters((SSLParameters)object);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw c.a.c.a("unable to set ssl parameters", reflectiveOperationException);
        }
    }
}

