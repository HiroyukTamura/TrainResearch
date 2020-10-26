/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package g.a;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    static volatile b[] a;
    private static final b[] b;
    private static final List<b> c;
    private static final b d;

    static {
        b = new b[0];
        c = new ArrayList<b>();
        a = b;
        d = new b(){

            @Override
            protected void a(int n2, String string2, String string3, Throwable throwable) {
                throw new AssertionError((Object)"Missing override for log method.");
            }

            @Override
            public /* varargs */ void a(String string2, Object ... arrobject) {
                b[] arrb = a.a;
                int n2 = arrb.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrb[i2].a(string2, arrobject);
                }
            }
        };
    }

    public static b a(String string2) {
        b[] arrb = a;
        int n2 = arrb.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrb[i2].a.set(string2);
        }
        return d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(b b2) {
        if (b2 == null) {
            throw new NullPointerException("tree == null");
        }
        if (b2 != d) {
            List<b> list = c;
            synchronized (list) {
                c.add(b2);
                a = c.toArray(new b[c.size()]);
                return;
            }
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    public static class a
    extends b {
        private static final Pattern b = Pattern.compile("(\\$\\d+)+$");

        @Override
        final String a() {
            StackTraceElement[] arrstackTraceElement = super.a();
            if (arrstackTraceElement != null) {
                return arrstackTraceElement;
            }
            arrstackTraceElement = new Throwable().getStackTrace();
            if (arrstackTraceElement.length > 5) {
                return this.a(arrstackTraceElement[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        protected String a(StackTraceElement object) {
            Object object2 = b.matcher((CharSequence)(object = ((StackTraceElement)object).getClassName()));
            if (((Matcher)object2).find()) {
                object = ((Matcher)object2).replaceAll("");
            }
            object = object2 = ((String)object).substring(((String)object).lastIndexOf(46) + 1);
            if (((String)object2).length() > 23) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return object2;
                }
                object = ((String)object2).substring(0, 23);
            }
            return object;
        }

        @Override
        protected void a(int n2, String string2, String string3, Throwable object) {
            if (string3.length() < 4000) {
                if (n2 == 7) {
                    Log.wtf((String)string2, (String)string3);
                    return;
                }
                Log.println((int)n2, (String)string2, (String)string3);
                return;
            }
            int n3 = 0;
            int n4 = string3.length();
            block0 : while (n3 < n4) {
                int n5 = string3.indexOf(10, n3);
                if (n5 == -1) {
                    n5 = n4;
                }
                do {
                    int n6 = Math.min(n5, n3 + 4000);
                    object = string3.substring(n3, n6);
                    if (n2 == 7) {
                        Log.wtf((String)string2, (String)object);
                    } else {
                        Log.println((int)n2, (String)string2, (String)object);
                    }
                    if (n6 >= n5) {
                        n3 = n6 + 1;
                        continue block0;
                    }
                    n3 = n6;
                } while (true);
            }
        }
    }

    public static abstract class b {
        final ThreadLocal<String> a = new ThreadLocal();

        private String a(Throwable throwable) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            throwable.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private /* varargs */ void a(int n2, Throwable throwable, String string2, Object ... object) {
            String string3 = this.a();
            if (!this.a(string3, n2)) {
                return;
            }
            String string4 = string2;
            if (string2 != null) {
                string4 = string2;
                if (string2.length() == 0) {
                    string4 = null;
                }
            }
            if (string4 == null) {
                if (throwable == null) {
                    return;
                }
                object = this.a(throwable);
            } else {
                string2 = string4;
                if (object != null) {
                    string2 = string4;
                    if (((Object[])object).length > 0) {
                        string2 = this.b(string4, (Object[])object);
                    }
                }
                object = string2;
                if (throwable != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append("\n");
                    ((StringBuilder)object).append(this.a(throwable));
                    object = ((StringBuilder)object).toString();
                }
            }
            this.a(n2, string3, (String)object, throwable);
        }

        String a() {
            String string2 = this.a.get();
            if (string2 != null) {
                this.a.remove();
            }
            return string2;
        }

        protected abstract void a(int var1, String var2, String var3, Throwable var4);

        public /* varargs */ void a(String string2, Object ... arrobject) {
            this.a(3, null, string2, arrobject);
        }

        @Deprecated
        protected boolean a(int n2) {
            return true;
        }

        protected boolean a(String string2, int n2) {
            return this.a(n2);
        }

        protected String b(String string2, Object[] arrobject) {
            return String.format(string2, arrobject);
        }
    }

}

