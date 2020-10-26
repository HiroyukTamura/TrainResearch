// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.web;

import android.net.Uri;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import org.apache.http.HttpHost;
import android.webkit.WebView;
import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import android.util.ArrayMap;
import java.lang.reflect.Constructor;
import android.os.Parcelable;
import java.lang.reflect.Method;
import android.util.Log;
import android.os.Build$VERSION;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.Activity;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.net.Socket;
import android.content.Context;
import java.lang.reflect.Field;

public class WebkitProxy
{
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8118;
    private static final int DEFAULT_SOCKS_PORT = 9050;
    private static final int REQUEST_CODE = 0;
    private static final String TAG = "OrbotHelpher";
    
    private static Object getDeclaredField(final Object obj, final String name) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Field declaredField = obj.getClass().getDeclaredField(name);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
    
    private static Object getFieldValueSafely(final Field field, Object value) throws IllegalArgumentException, IllegalAccessException {
        final boolean accessible = field.isAccessible();
        field.setAccessible(true);
        value = field.get(value);
        field.setAccessible(accessible);
        return value;
    }
    
    public static Object getRequestQueue(final Context context) throws Exception {
        final Object o = null;
        final Class<?> forName = Class.forName("android.webkit.Network");
        Object declaredField = o;
        if (forName != null) {
            final Object invokeMethod = invokeMethod(forName, "getInstance", new Object[] { context }, Context.class);
            declaredField = o;
            if (invokeMethod != null) {
                declaredField = getDeclaredField(invokeMethod, "mRequestQueue");
            }
        }
        return declaredField;
    }
    
    public static Socket getSocket(final Context context) throws IOException {
        return getSocket(context, "localhost", 9050);
    }
    
    public static Socket getSocket(final Context context, final String hostname, final int port) throws IOException {
        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress(hostname, port), 10000);
        return socket;
    }
    
    public static AlertDialog initOrbot(final Activity activity, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final CharSequence charSequence4, final CharSequence charSequence5) {
        final Intent intent = new Intent("org.torproject.android.START_TOR");
        intent.addCategory("android.intent.category.DEFAULT");
        try {
            activity.startActivityForResult(intent, 0);
            return null;
        }
        catch (ActivityNotFoundException ex) {
            return showDownloadDialog(activity, charSequence, charSequence2, charSequence3, charSequence4);
        }
    }
    
    private static Object invokeMethod(final Object o, final String s, final Object[] args, final Class... parameterTypes) throws Exception {
        Class<?> class1;
        if (o instanceof Class) {
            class1 = (Class<?>)o;
        }
        else {
            class1 = o.getClass();
        }
        if (parameterTypes != null) {
            return class1.getMethod(s, (Class<?>[])parameterTypes).invoke(o, args);
        }
        return class1.getMethod(s, (Class<?>[])new Class[0]).invoke(o, new Object[0]);
    }
    
    @TargetApi(19)
    public static boolean resetKitKatProxy(final String s, final Context context) {
        return setKitKatProxy(s, context, null, 0);
    }
    
    @TargetApi(21)
    public static boolean resetLollipopProxy(final String s, final Context context) {
        return setWebkitProxyLollipop(context, null, 0);
    }
    
    public static void resetProxy(final String s, final Context context) throws Exception {
        System.clearProperty("http.proxyHost");
        System.clearProperty("http.proxyPort");
        System.clearProperty("https.proxyHost");
        System.clearProperty("https.proxyPort");
        if (Build$VERSION.SDK_INT < 14) {
            resetProxyForGingerBread(context);
            return;
        }
        if (Build$VERSION.SDK_INT < 19) {
            resetProxyForICS();
            return;
        }
        resetKitKatProxy(s, context);
    }
    
    private static void resetProxyForGingerBread(final Context context) throws Exception {
        final Object requestQueue = getRequestQueue(context);
        if (requestQueue != null) {
            setDeclaredField(requestQueue, "mProxyHost", null);
        }
    }
    
    private static void resetProxyForICS() throws Exception {
        try {
            final Class<?> forName = Class.forName("android.webkit.WebViewCore");
            final Class<?> forName2 = Class.forName("android.net.ProxyProperties");
            if (forName != null && forName2 != null) {
                final Method declaredMethod = forName.getDeclaredMethod("sendStaticMessage", Integer.TYPE, Object.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, 193, null);
                }
            }
        }
        catch (Exception ex) {
            Log.e("ProxySettings", "Exception setting WebKit proxy through android.net.ProxyProperties: " + ex.toString());
            throw ex;
        }
        catch (Error error) {
            Log.e("ProxySettings", "Exception setting WebKit proxy through android.webkit.Network: " + error.toString());
            throw error;
        }
    }
    
    private static boolean sendProxyChangedIntent(final Context context, final String s, final int i) {
        try {
            final Class<?> forName = Class.forName("android.net.ProxyProperties");
            if (forName != null) {
                final Constructor<?> constructor = forName.getConstructor(String.class, Integer.TYPE, String.class);
                if (constructor != null) {
                    constructor.setAccessible(true);
                    final Object instance = constructor.newInstance(s, i, null);
                    final Intent intent = new Intent("android.intent.action.PROXY_CHANGE");
                    intent.putExtra("proxy", (Parcelable)instance);
                    context.sendBroadcast(intent);
                }
            }
            return false;
        }
        catch (Exception ex) {
            Log.e("ProxySettings", "Exception sending Intent ", (Throwable)ex);
            return false;
        }
        catch (Error error) {
            Log.e("ProxySettings", "Exception sending Intent ", (Throwable)error);
            return false;
        }
    }
    
    private static void setDeclaredField(final Object obj, final String name, final Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Field declaredField = obj.getClass().getDeclaredField(name);
        declaredField.setAccessible(true);
        declaredField.set(obj, value);
    }
    
    @TargetApi(19)
    private static boolean setKitKatProxy(final String className, final Context obj, final String s, final int i) {
        if (s != null) {
            System.setProperty("http.proxyHost", s);
            System.setProperty("http.proxyPort", i + "");
            System.setProperty("https.proxyHost", s);
            System.setProperty("https.proxyPort", i + "");
        }
        try {
            final Field field = Class.forName(className).getField("mLoadedApk");
            field.setAccessible(true);
            final Object value = field.get(obj);
            final Field declaredField = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
            declaredField.setAccessible(true);
            final Iterator iterator = ((ArrayMap)declaredField.get(value)).values().iterator();
            while (iterator.hasNext()) {
                for (final Object next : iterator.next().keySet()) {
                    final Class<?> class1 = next.getClass();
                    if (class1.getName().contains("ProxyChangeListener")) {
                        final Method declaredMethod = class1.getDeclaredMethod("onReceive", Context.class, Intent.class);
                        final Intent intent = new Intent("android.intent.action.PROXY_CHANGE");
                        if (s != null) {
                            final Constructor<?> constructor = Class.forName("android.net.ProxyProperties").getConstructor(String.class, Integer.TYPE, String.class);
                            constructor.setAccessible(true);
                            intent.putExtra("proxy", (Parcelable)constructor.newInstance(s, i, null));
                        }
                        declaredMethod.invoke(next, obj, intent);
                    }
                }
            }
            goto Label_0379;
        }
        catch (ClassNotFoundException ex) {
            final StringWriter out = new StringWriter();
            ex.printStackTrace(new PrintWriter(out));
            final String string = out.toString();
            Log.v("OrbotHelpher", ex.getMessage());
            Log.v("OrbotHelpher", string);
        }
        catch (NoSuchFieldException ex2) {
            final StringWriter out2 = new StringWriter();
            ex2.printStackTrace(new PrintWriter(out2));
            final String string2 = out2.toString();
            Log.v("OrbotHelpher", ex2.getMessage());
            Log.v("OrbotHelpher", string2);
            goto Label_0377;
        }
        catch (IllegalAccessException ex3) {
            final StringWriter out3 = new StringWriter();
            ex3.printStackTrace(new PrintWriter(out3));
            final String string3 = out3.toString();
            Log.v("OrbotHelpher", ex3.getMessage());
            Log.v("OrbotHelpher", string3);
            goto Label_0377;
        }
        catch (IllegalArgumentException ex4) {
            final StringWriter out4 = new StringWriter();
            ex4.printStackTrace(new PrintWriter(out4));
            final String string4 = out4.toString();
            Log.v("OrbotHelpher", ex4.getMessage());
            Log.v("OrbotHelpher", string4);
            goto Label_0377;
        }
        catch (NoSuchMethodException ex5) {
            final StringWriter out5 = new StringWriter();
            ex5.printStackTrace(new PrintWriter(out5));
            final String string5 = out5.toString();
            Log.v("OrbotHelpher", ex5.getMessage());
            Log.v("OrbotHelpher", string5);
            goto Label_0377;
        }
        catch (InvocationTargetException ex6) {
            final StringWriter out6 = new StringWriter();
            ex6.printStackTrace(new PrintWriter(out6));
            final String string6 = out6.toString();
            Log.v("OrbotHelpher", ex6.getMessage());
            Log.v("OrbotHelpher", string6);
            goto Label_0377;
        }
        catch (InstantiationException ex7) {
            final StringWriter out7 = new StringWriter();
            ex7.printStackTrace(new PrintWriter(out7));
            final String string7 = out7.toString();
            Log.v("OrbotHelpher", ex7.getMessage());
            Log.v("OrbotHelpher", string7);
            goto Label_0377;
        }
    }
    
    public static boolean setProxy(final String s, final Context context, final WebView webView, final String s2, final int n) throws Exception {
        setSystemProperties(s2, n);
        boolean setKitKatProxy = false;
        if (Build$VERSION.SDK_INT < 13) {
            setProxyUpToHC(webView, s2, n);
        }
        else {
            if (Build$VERSION.SDK_INT < 19) {
                return setWebkitProxyICS(context, s2, n);
            }
            if (Build$VERSION.SDK_INT < 20) {
                if (!(setKitKatProxy = setKitKatProxy(s, context, s2, n))) {
                    return setWebkitProxyICS(context, s2, n);
                }
            }
            else if (Build$VERSION.SDK_INT >= 21) {
                return setWebkitProxyLollipop(context, s2, n);
            }
        }
        return setKitKatProxy;
    }
    
    private static boolean setProxyUpToHC(final WebView p0, final String p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc_w           "Setting proxy with <= 3.2 API."
        //     5: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //     8: pop            
        //     9: new             Lorg/apache/http/HttpHost;
        //    12: dup            
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokespecial   org/apache/http/HttpHost.<init>:(Ljava/lang/String;I)V
        //    18: astore_1       
        //    19: ldc             "android.webkit.Network"
        //    21: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    24: astore          4
        //    26: aload           4
        //    28: ifnonnull       42
        //    31: ldc             "OrbotHelpher"
        //    33: ldc_w           "failed to get class for android.webkit.Network"
        //    36: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    39: pop            
        //    40: iconst_0       
        //    41: ireturn        
        //    42: aload           4
        //    44: ldc             "getInstance"
        //    46: iconst_1       
        //    47: anewarray       Ljava/lang/Class;
        //    50: dup            
        //    51: iconst_0       
        //    52: ldc             Landroid/content/Context;.class
        //    54: aastore        
        //    55: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    58: astore          5
        //    60: aload           5
        //    62: ifnonnull       74
        //    65: ldc             "OrbotHelpher"
        //    67: ldc_w           "failed to get getInstance method"
        //    70: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    73: pop            
        //    74: aload           5
        //    76: aload           4
        //    78: iconst_1       
        //    79: anewarray       Ljava/lang/Object;
        //    82: dup            
        //    83: iconst_0       
        //    84: aload_0        
        //    85: invokevirtual   android/webkit/WebView.getContext:()Landroid/content/Context;
        //    88: aastore        
        //    89: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    92: astore_0       
        //    93: aload_0        
        //    94: ifnonnull       137
        //    97: ldc             "OrbotHelpher"
        //    99: ldc_w           "error getting network: network is null"
        //   102: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   105: pop            
        //   106: iconst_0       
        //   107: ireturn        
        //   108: astore_0       
        //   109: ldc             "OrbotHelpher"
        //   111: new             Ljava/lang/StringBuilder;
        //   114: dup            
        //   115: invokespecial   java/lang/StringBuilder.<init>:()V
        //   118: ldc_w           "error getting network: "
        //   121: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: aload_0        
        //   125: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   128: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   131: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   134: pop            
        //   135: iconst_0       
        //   136: ireturn        
        //   137: aload           4
        //   139: ldc             "mRequestQueue"
        //   141: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   144: aload_0        
        //   145: invokestatic    info/guardianproject/netcipher/web/WebkitProxy.getFieldValueSafely:(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
        //   148: astore          4
        //   150: aload           4
        //   152: ifnonnull       178
        //   155: ldc             "OrbotHelpher"
        //   157: ldc_w           "Request queue is null"
        //   160: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   163: pop            
        //   164: iconst_0       
        //   165: ireturn        
        //   166: astore_0       
        //   167: ldc             "OrbotHelpher"
        //   169: ldc_w           "error getting field value"
        //   172: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   175: pop            
        //   176: iconst_0       
        //   177: ireturn        
        //   178: ldc_w           "android.net.http.RequestQueue"
        //   181: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   184: ldc             "mProxyHost"
        //   186: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   189: astore_0       
        //   190: aload_0        
        //   191: invokevirtual   java/lang/reflect/Field.isAccessible:()Z
        //   194: istore_3       
        //   195: aload_0        
        //   196: iconst_1       
        //   197: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //   200: aload_0        
        //   201: aload           4
        //   203: aload_1        
        //   204: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   207: aload_0        
        //   208: iload_3        
        //   209: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //   212: ldc             "OrbotHelpher"
        //   214: ldc_w           "Setting proxy with <= 3.2 API successful!"
        //   217: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   220: pop            
        //   221: iconst_1       
        //   222: ireturn        
        //   223: astore_0       
        //   224: ldc             "OrbotHelpher"
        //   226: ldc_w           "error getting proxy host field"
        //   229: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   232: pop            
        //   233: iconst_0       
        //   234: ireturn        
        //   235: astore_1       
        //   236: ldc             "OrbotHelpher"
        //   238: ldc_w           "error setting proxy host"
        //   241: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   244: pop            
        //   245: aload_0        
        //   246: iload_3        
        //   247: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //   250: goto            212
        //   253: astore_1       
        //   254: aload_0        
        //   255: iload_3        
        //   256: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //   259: aload_1        
        //   260: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     26     108    137    Ljava/lang/Exception;
        //  31     40     108    137    Ljava/lang/Exception;
        //  42     60     108    137    Ljava/lang/Exception;
        //  65     74     108    137    Ljava/lang/Exception;
        //  74     93     108    137    Ljava/lang/Exception;
        //  137    150    166    178    Ljava/lang/Exception;
        //  178    190    223    235    Ljava/lang/Exception;
        //  195    207    235    253    Ljava/lang/Exception;
        //  195    207    253    261    Any
        //  236    245    253    261    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0212:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void setSystemProperties(final String value, final int i) {
        System.setProperty("proxyHost", value);
        System.setProperty("proxyPort", i + "");
        System.setProperty("http.proxyHost", value);
        System.setProperty("http.proxyPort", i + "");
        System.setProperty("https.proxyHost", value);
        System.setProperty("https.proxyPort", i + "");
        System.setProperty("socks.proxyHost", value);
        System.setProperty("socks.proxyPort", "9050");
        System.setProperty("socksProxyHost", value);
        System.setProperty("socksProxyPort", "9050");
    }
    
    private static boolean setWebkitProxyGingerbread(final Context context, final String s, final int n) throws Exception {
        final Object requestQueue = getRequestQueue(context);
        if (requestQueue != null) {
            setDeclaredField(requestQueue, "mProxyHost", new HttpHost(s, n, "http"));
            return true;
        }
        return false;
    }
    
    private static boolean setWebkitProxyICS(final Context context, final String s, final int i) {
        try {
            final Class<?> forName = Class.forName("android.webkit.WebViewCore");
            final Class<?> forName2 = Class.forName("android.net.ProxyProperties");
            if (forName == null || forName2 == null) {
                goto Label_0161;
            }
            final Method declaredMethod = forName.getDeclaredMethod("sendStaticMessage", Integer.TYPE, Object.class);
            final Constructor<?> constructor = forName2.getConstructor(String.class, Integer.TYPE, String.class);
            if (declaredMethod != null && constructor != null) {
                declaredMethod.setAccessible(true);
                constructor.setAccessible(true);
                declaredMethod.invoke(null, 193, constructor.newInstance(s, i, null));
                return true;
            }
            goto Label_0161;
        }
        catch (Exception ex) {
            Log.e("ProxySettings", "Exception setting WebKit proxy through android.net.ProxyProperties: " + ex.toString());
        }
        catch (Error error) {
            Log.e("ProxySettings", "Exception setting WebKit proxy through android.webkit.Network: " + error.toString());
            goto Label_0161;
        }
    }
    
    @TargetApi(21)
    private static boolean setWebkitProxyLollipop(final Context obj, final String s, final int n) {
        System.setProperty("http.proxyHost", s);
        System.setProperty("http.proxyPort", n + "");
        System.setProperty("https.proxyHost", s);
        System.setProperty("https.proxyPort", n + "");
        try {
            final Field declaredField = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
            declaredField.setAccessible(true);
            final Object value = declaredField.get(obj);
            final Field declaredField2 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
            declaredField2.setAccessible(true);
            final Iterator iterator = ((ArrayMap)declaredField2.get(value)).values().iterator();
            while (iterator.hasNext()) {
                for (final Object next : iterator.next().keySet()) {
                    final Class<?> class1 = next.getClass();
                    if (class1.getName().contains("ProxyChangeListener")) {
                        class1.getDeclaredMethod("onReceive", Context.class, Intent.class).invoke(next, obj, new Intent("android.intent.action.PROXY_CHANGE"));
                    }
                }
            }
            goto Label_0274;
        }
        catch (ClassNotFoundException ex) {
            Log.d("ProxySettings", "Exception setting WebKit proxy on Lollipop through ProxyChangeListener: " + ex.toString());
        }
        catch (NoSuchFieldException ex2) {
            Log.d("ProxySettings", "Exception setting WebKit proxy on Lollipop through ProxyChangeListener: " + ex2.toString());
            goto Label_0272;
        }
        catch (IllegalAccessException ex3) {
            Log.d("ProxySettings", "Exception setting WebKit proxy on Lollipop through ProxyChangeListener: " + ex3.toString());
            goto Label_0272;
        }
        catch (NoSuchMethodException ex4) {
            Log.d("ProxySettings", "Exception setting WebKit proxy on Lollipop through ProxyChangeListener: " + ex4.toString());
            goto Label_0272;
        }
        catch (InvocationTargetException ex5) {
            Log.d("ProxySettings", "Exception setting WebKit proxy on Lollipop through ProxyChangeListener: " + ex5.toString());
            goto Label_0272;
        }
    }
    
    private static AlertDialog showDownloadDialog(final Activity activity, final CharSequence title, final CharSequence message, final CharSequence charSequence, final CharSequence charSequence2) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
        alertDialog$Builder.setTitle(title);
        alertDialog$Builder.setMessage(message);
        alertDialog$Builder.setPositiveButton(charSequence, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:org.torproject.android")));
            }
        });
        alertDialog$Builder.setNegativeButton(charSequence2, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
            }
        });
        return alertDialog$Builder.show();
    }
}
