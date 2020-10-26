/*
 * Decompiled with CFR 0.139.
 */
package c;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface o {
    public static final o a = new o(){

        @Override
        public List<InetAddress> a(String object) {
            if (object != null) {
                try {
                    List<InetAddress> list = Arrays.asList(InetAddress.getAllByName((String)object));
                    return list;
                }
                catch (NullPointerException nullPointerException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Broken system behaviour for dns lookup of ");
                    stringBuilder.append((String)object);
                    object = new UnknownHostException(stringBuilder.toString());
                    ((Throwable)object).initCause(nullPointerException);
                    throw object;
                }
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    public List<InetAddress> a(String var1);

}

