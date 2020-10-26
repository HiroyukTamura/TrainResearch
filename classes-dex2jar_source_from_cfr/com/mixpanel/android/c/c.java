/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.net.Uri$Builder
 */
package com.mixpanel.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.mixpanel.android.c.f;
import com.mixpanel.android.c.h;
import com.mixpanel.android.c.i;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class c
implements i {
    private static boolean a;

    private boolean a(h h2) {
        if (h2 != null) {
            try {
                boolean bl2 = h2.a();
                if (bl2) {
                    return true;
                }
            }
            catch (Exception exception) {
                f.a("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", exception);
            }
        }
        return false;
    }

    private static byte[] a(InputStream inputStream) {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[8192];
        while ((n2 = inputStream.read(arrby, 0, arrby.length)) != -1) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void a() {
        new Thread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                boolean bl2;
                block5 : {
                    block4 : {
                        block3 : {
                            try {
                                InetAddress inetAddress = InetAddress.getByName("api.mixpanel.com");
                                InetAddress inetAddress2 = InetAddress.getByName("decide.mixpanel.com");
                                if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress() && !inetAddress2.isLoopbackAddress() && !inetAddress2.isAnyLocalAddress()) break block3;
                                break block4;
                            }
                            catch (Exception exception) {
                                return;
                            }
                        }
                        bl2 = false;
                        break block5;
                    }
                    bl2 = true;
                }
                a = bl2;
                if (a) {
                    f.a("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
                }
            }
        }).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"MissingPermission"})
    @Override
    public boolean a(Context object, h object2) {
        if (a) {
            return false;
        }
        if (this.a((h)object2)) {
            return false;
        }
        try {
            object = ((ConnectivityManager)object.getSystemService("connectivity")).getActiveNetworkInfo();
            if (object == null) {
                f.a("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
                return true;
            }
            boolean bl2 = object.isConnectedOrConnecting();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("ConnectivityManager says we ");
            object = bl2 ? "are" : "are not";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" online");
            f.a("MixpanelAPI.Message", ((StringBuilder)object2).toString());
            return bl2;
        }
        catch (SecurityException securityException) {}
        f.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] a(String var1_1, Map<String, Object> var2_3, SSLSocketFactory var3_13) {
        block71 : {
            block69 : {
                block70 : {
                    block72 : {
                        block68 : {
                            var7_31 = new StringBuilder();
                            var7_31.append("Attempting request to ");
                            var7_31.append((String)var1_1 /* !! */ );
                            f.a("MixpanelAPI.Message", var7_31.toString());
                            var4_34 = 0;
                            var14_35 = null;
                            var15_36 = null;
                            var10_37 = null;
                            var5_40 = false;
lbl10: // 4 sources:
                            while (var4_34 < 3 && !var5_40) {
                                var7_31 = (HttpURLConnection)new URL((String)var1_1 /* !! */ ).openConnection();
                                if (var3_26 /* !! */  == null) ** GOTO lbl17
                                if (var7_31 instanceof HttpsURLConnection) {
                                    ((HttpsURLConnection)var7_31).setSSLSocketFactory((SSLSocketFactory)var3_26 /* !! */ );
                                }
lbl17: // 4 sources:
                                var7_31.setConnectTimeout(2000);
                                var7_31.setReadTimeout(30000);
                                if (var2_16 == null) break block68;
                                var8_42 = new Uri.Builder();
                                for (Map.Entry var11_51 : var2_16.entrySet()) {
                                    var8_42.appendQueryParameter((String)var11_51.getKey(), var11_51.getValue().toString());
                                }
                                var9_46 = var8_42.build().getEncodedQuery();
                                var7_31.setFixedLengthStreamingMode(var9_46.getBytes().length);
                                var7_31.setDoOutput(true);
                                var7_31.setRequestMethod("POST");
                                var8_42 = var7_31.getOutputStream();
                                var12_61 = new BufferedOutputStream((OutputStream)var8_42);
                                var12_61.write(var9_46.getBytes("UTF-8"));
                                var12_61.flush();
                                var12_61.close();
                                var8_42.close();
                                break block68;
                                catch (Throwable var3_27) {
                                    var1_2 = null;
                                    var2_16 = var12_61;
                                    ** GOTO lbl160
                                }
                                catch (IOException var2_17) {
                                    var3_26 /* !! */  = null;
                                    var1_3 = var12_61;
                                    break block69;
                                }
                            }
                            break block72;
lbl47: // 1 sources:
                            do {
                                var9_46 = null;
                                var13_62 = var10_37;
                                var11_52 = var7_31;
                                var7_31 = var9_46;
                                var9_46 = var8_42;
                                var8_42 = var12_61;
                                ** GOTO lbl133
                                break;
                            } while (true);
                            catch (Throwable var2_18) {
                                var1_4 = null;
                                var3_26 /* !! */  = var14_35;
                                ** GOTO lbl163
                            }
                            catch (IOException var2_19) {
                                var1_5 /* !! */  = var3_26 /* !! */  = null;
                                break block69;
                            }
lbl62: // 1 sources:
                            do {
                                var12_61 = var9_46 = null;
                                var13_62 = var10_37;
                                var11_53 = var7_31;
                                var7_31 = var9_46;
                                var9_46 = var8_42;
                                var8_42 = var12_61;
                                ** GOTO lbl133
                                break;
                            } while (true);
                        }
                        var8_42 = var7_31.getInputStream();
                        try {
                            var9_46 = c.a((InputStream)var8_42);
                            var8_42.close();
                            if (var7_31 != null) {
                                var7_31.disconnect();
                            }
                            var5_40 = true;
                            var10_37 = var9_46;
                            ** GOTO lbl10
lbl83: // 1 sources:
                            do {
                                var10_37 = null;
                                var13_62 = var9_46;
                                var9_46 = var10_37;
                                var11_54 = var7_31;
                                var7_31 = var8_42;
                                var8_42 = var10_37;
                                ** GOTO lbl133
                                break;
                            } while (true);
                        }
                        catch (Throwable var2_20) {
                            var9_46 = null;
                            var3_26 /* !! */  = var14_35;
                            var1_6 = var8_42;
                            var8_42 = var9_46;
                            ** GOTO lbl163
                        }
                        catch (IOException var2_21) {
                            var3_26 /* !! */  = var8_42;
                            break block70;
                        }
lbl100: // 1 sources:
                        do {
                            var9_46 = null;
                            var11_55 = var7_31;
                            var7_31 = var8_42;
                            ** GOTO lbl131
                            break;
                        } while (true);
                        catch (Throwable var2_22) {
                            var7_31 = null;
lbl107: // 2 sources:
                            do {
                                var1_7 = null;
                                var8_42 = null;
                                var3_26 /* !! */  = var14_35;
                                ** GOTO lbl163
                                break;
                            } while (true);
                        }
                        catch (IOException var2_23) {
                            var8_42 = var9_46 = null;
                            var3_26 /* !! */  = var8_42;
                            var7_31 = var15_36;
lbl116: // 2 sources:
                            do {
                                try {
                                    if (var7_31.getResponseCode() >= 500 && var7_31.getResponseCode() <= 599) {
                                        throw new i.a("Service Unavailable", var7_31.getHeaderField("Retry-After"));
                                    }
                                    throw var2_16;
                                }
                                catch (Throwable var10_39) {
                                    var1_9 = var9_46;
                                    var2_16 = var3_26 /* !! */ ;
                                    var3_26 /* !! */  = var10_39;
                                    ** GOTO lbl160
                                }
                                break;
                            } while (true);
                        }
lbl126: // 1 sources:
                        do {
                            var11_56 = null;
lbl128: // 2 sources:
                            do {
                                var7_31 = null;
                                var9_46 = null;
lbl131: // 2 sources:
                                var8_42 = var9_46;
                                var13_62 = var10_37;
lbl133: // 4 sources:
                                try {
                                    f.b("MixpanelAPI.Message", "Failure to connect, likely caused by a known issue with Android lib. Retrying.");
                                }
                                catch (Throwable var3_28) {
                                    var2_16 = var8_42;
                                    var8_42 = var9_46;
                                    var1_10 = var7_31;
                                    var7_31 = var11_59;
                                }
                                var6_41 = var4_34 + 1;
                                if (var8_42 != null) {
                                    var8_42.close();
                                }
lbl139: // 4 sources:
                                do {
                                    if (var9_46 != null) {
                                        var9_46.close();
                                    }
lbl143: // 4 sources:
                                    do {
                                        if (var7_31 != null) {
                                            var7_31.close();
                                        }
lbl147: // 4 sources:
                                        do {
                                            var4_34 = var6_41;
                                            var10_37 = var13_62;
                                            if (var11_59 == null) ** GOTO lbl10
                                            var11_59.disconnect();
                                            var4_34 = var6_41;
                                            var10_37 = var13_62;
                                            ** GOTO lbl10
                                            break;
                                        } while (true);
                                        break;
                                    } while (true);
                                    break;
                                } while (true);
lbl160: // 3 sources:
                                var9_46 = var2_16;
                                var2_16 = var3_26 /* !! */ ;
                                var3_26 /* !! */  = var9_46;
lbl163: // 4 sources:
                                if (var3_26 /* !! */  != null) {
                                    var3_26 /* !! */ .close();
                                }
lbl166: // 4 sources:
                                do {
                                    if (var8_42 != null) {
                                        var8_42.close();
                                    }
lbl170: // 4 sources:
                                    do {
                                        if (var1_12 != null) {
                                            var1_12.close();
                                        }
lbl174: // 4 sources:
                                        do {
                                            if (var7_31 != null) {
                                                var7_31.disconnect();
                                            }
                                            throw var2_16;
                                            break;
                                        } while (true);
                                        break;
                                    } while (true);
                                    break;
                                } while (true);
                                break;
                            } while (true);
                            break;
                        } while (true);
                    }
                    if (var4_34 >= 3) {
                        f.a("MixpanelAPI.Message", "Could not connect to Mixpanel service after three retries.");
                    }
                    return var10_37;
                    catch (EOFException var7_32) {
                        ** continue;
                    }
                    catch (EOFException var8_43) {
                        break block71;
                    }
                    catch (EOFException var9_48) {
                        ** continue;
                    }
                    catch (EOFException var9_47) {
                        ** continue;
                    }
                    {
                        catch (EOFException var9_49) {
                            ** continue;
                        }
                        catch (EOFException var10_38) {
                            ** continue;
                        }
                    }
                    catch (IOException var8_44) {
                        ** continue;
                    }
                    catch (IOException var8_45) {
                        ** continue;
                    }
                    catch (IOException var7_33) {
                        ** continue;
                    }
                    catch (IOException var3_29) {
                        ** continue;
                    }
                    catch (IOException var3_30) {
                        ** continue;
                    }
                    catch (IOException var1_13) {
                        ** continue;
                    }
                    catch (Throwable var2_24) {
                        ** continue;
                    }
                    catch (IOException var2_25) {
                        var3_26 /* !! */  = null;
                    }
                }
                var8_42 = null;
                var1_14 = null;
            }
            var9_46 = var3_26 /* !! */ ;
            var3_26 /* !! */  = var1_15;
            ** while (true)
        }
        var11_60 = var7_31;
        ** while (true)
    }

}

