/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 */
package com.mixpanel.android.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.c.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class x {
    private static x h;
    private static final Object i;
    private final Context a;
    private final Boolean b;
    private final Boolean c;
    private final DisplayMetrics d;
    private final String e;
    private final Integer f;
    private final String g;

    static {
        i = new Object();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private x(Context var1_1) {
        block14 : {
            block15 : {
                block13 : {
                    block12 : {
                        super();
                        this.a = var1_1;
                        var6_4 = this.a.getPackageManager();
                        var5_5 = null;
                        try {
                            var4_6 = var6_4.getPackageInfo(this.a.getPackageName(), 0);
                            var3_11 = var4_6.versionName;
                        }
                        catch (PackageManager.NameNotFoundException var3_12) {}
                        try {
                            var4_7 = var4_6.versionCode;
                            break block12;
                        }
                        catch (PackageManager.NameNotFoundException var4_8) {}
                        var3_11 = null;
                        f.d("MixpanelAPI.SysInfo", "System information constructed with a context that apparently doesn't exist.");
                        var4_9 = null;
                    }
                    var7_14 = var1_1.getApplicationInfo();
                    var2_15 = var7_14.labelRes;
                    this.e = var3_11;
                    this.f = var4_10;
                    var1_1 = var2_15 == 0 ? (var7_14.nonLocalizedLabel == null ? "Misc" : var7_14.nonLocalizedLabel.toString()) : var1_1.getString(var2_15);
                    this.g = var1_1;
                    var1_1 = var6_4.getClass();
                    try {
                        var3_11 = var1_1.getMethod("hasSystemFeature", new Class[]{String.class});
                        break block13;
                    }
                    catch (NoSuchMethodException var1_2) {}
                    var3_11 = null;
                }
                if (var3_11 != null) {
                    var1_1 = (Boolean)var3_11.invoke((Object)var6_4, new Object[]{"android.hardware.nfc"});
                    var3_11 = (Boolean)var3_11.invoke((Object)var6_4, new Object[]{"android.hardware.telephony"});
                    ** GOTO lbl47
                } else {
                    var1_1 = null;
                    var3_11 = var5_5;
                }
                break block14;
                catch (IllegalAccessException | InvocationTargetException var1_3) {}
                var1_1 = null;
                break block15;
                catch (IllegalAccessException | InvocationTargetException var3_13) {}
            }
            f.d("MixpanelAPI.SysInfo", "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
            var3_11 = var5_5;
        }
        this.b = var1_1;
        this.c = var3_11;
        this.d = new DisplayMetrics();
        ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(this.d);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static x a(Context context) {
        Object object = i;
        synchronized (object) {
            if (h == null) {
                h = new x(context.getApplicationContext());
            }
            return h;
        }
    }

    public String a() {
        return this.e;
    }

    public Integer b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.c;
    }

    public DisplayMetrics f() {
        return this.d;
    }

    public String g() {
        TelephonyManager telephonyManager = (TelephonyManager)this.a.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    @SuppressLint(value={"MissingPermission"})
    public Boolean h() {
        if (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            NetworkInfo networkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean bl2 = true;
            if (networkInfo == null || networkInfo.getType() != 1 || !networkInfo.isConnected()) {
                bl2 = false;
            }
            return bl2;
        }
        return null;
    }

    @SuppressLint(value={"MissingPermission"})
    public Boolean i() {
        Boolean bl2;
        block3 : {
            boolean bl3;
            Boolean bl4;
            bl2 = bl4 = null;
            if (this.a.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.a.getPackageName()) != 0) break block3;
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bl2 = bl4;
            if (bluetoothAdapter == null) break block3;
            try {
                bl3 = bluetoothAdapter.isEnabled();
            }
            catch (NoClassDefFoundError | SecurityException throwable) {
                return null;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public String j() {
        String string2 = "none";
        if (Build.VERSION.SDK_INT >= 18 && this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            string2 = "classic";
        }
        return string2;
    }
}

