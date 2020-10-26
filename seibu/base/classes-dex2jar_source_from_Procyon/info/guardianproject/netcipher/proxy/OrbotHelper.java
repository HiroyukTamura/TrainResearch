// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.proxy;

import android.app.Activity;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Iterator;
import java.util.List;
import android.util.Log;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.net.Uri;
import android.content.Intent;
import android.content.Context;

public class OrbotHelper
{
    public static final String ACTION_REQUEST_HS = "org.torproject.android.REQUEST_HS_PORT";
    public static final String ACTION_START = "org.torproject.android.intent.action.START";
    public static final String ACTION_START_TOR = "org.torproject.android.START_TOR";
    public static final String ACTION_STATUS = "org.torproject.android.intent.action.STATUS";
    public static final String EXTRA_PACKAGE_NAME = "org.torproject.android.intent.extra.PACKAGE_NAME";
    public static final String EXTRA_STATUS = "org.torproject.android.intent.extra.STATUS";
    private static final String FDROID_PACKAGE_NAME = "org.fdroid.fdroid";
    public static final int HS_REQUEST_CODE = 9999;
    public static final String ORBOT_FDROID_URI = "https://f-droid.org/repository/browse/?fdid=org.torproject.android";
    public static final String ORBOT_MARKET_URI = "market://details?id=org.torproject.android";
    public static final String ORBOT_PACKAGE_NAME = "org.torproject.android";
    public static final String ORBOT_PLAY_URI = "https://play.google.com/store/apps/details?id=org.torproject.android";
    private static final String PLAY_PACKAGE_NAME = "com.android.vending";
    private static final int REQUEST_CODE_STATUS = 100;
    public static final int START_TOR_RESULT = 1208455732;
    public static final String STATUS_OFF = "OFF";
    public static final String STATUS_ON = "ON";
    public static final String STATUS_STARTING = "STARTING";
    public static final String STATUS_STARTS_DISABLED = "STARTS_DISABLED";
    public static final String STATUS_STOPPING = "STOPPING";
    
    private OrbotHelper() {
    }
    
    public static Intent getOrbotInstallIntent(final Context context) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=org.torproject.android"));
        final List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        final String s = null;
        final Iterator<ResolveInfo> iterator = queryIntentActivities.iterator();
        while (true) {
            ResolveInfo resolveInfo;
            do {
                final String packageName = s;
                if (iterator.hasNext()) {
                    resolveInfo = iterator.next();
                    Log.i("OrbotHelper", "market: " + resolveInfo.activityInfo.packageName);
                }
                else {
                    if (packageName == null) {
                        intent.setData(Uri.parse("https://f-droid.org/repository/browse/?fdid=org.torproject.android"));
                        return intent;
                    }
                    intent.setPackage(packageName);
                    return intent;
                }
            } while (!TextUtils.equals((CharSequence)resolveInfo.activityInfo.packageName, (CharSequence)"org.fdroid.fdroid") && !TextUtils.equals((CharSequence)resolveInfo.activityInfo.packageName, (CharSequence)"com.android.vending"));
            final String packageName = resolveInfo.activityInfo.packageName;
            continue;
        }
    }
    
    public static Intent getOrbotStartIntent() {
        final Intent intent = new Intent("org.torproject.android.intent.action.START");
        intent.setPackage("org.torproject.android");
        return intent;
    }
    
    public static Intent getShowOrbotStartIntent() {
        final Intent intent = new Intent("org.torproject.android.START_TOR");
        intent.setPackage("org.torproject.android");
        intent.addFlags(268435456);
        return intent;
    }
    
    private static boolean isAppInstalled(final Context context, final String s) {
        try {
            context.getPackageManager().getPackageInfo(s, 1);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    public static boolean isOrbotInstalled(final Context context) {
        return isAppInstalled(context, "org.torproject.android");
    }
    
    public static boolean isOrbotRunning(final Context context) {
        return TorServiceUtils.findProcessId(context) != -1;
    }
    
    public static void requestHiddenServiceOnPort(final Activity activity, final int n) {
        final Intent intent = new Intent("org.torproject.android.REQUEST_HS_PORT");
        intent.setPackage("org.torproject.android");
        intent.putExtra("hs_port", n);
        activity.startActivityForResult(intent, 9999);
    }
    
    public static boolean requestShowOrbotStart(final Activity activity) {
        if (isOrbotInstalled((Context)activity) && !isOrbotRunning((Context)activity)) {
            activity.startActivityForResult(getShowOrbotStartIntent(), 1208455732);
            return true;
        }
        return false;
    }
    
    public static boolean requestStartTor(final Context context) {
        if (isOrbotInstalled(context)) {
            Log.i("OrbotHelper", "requestStartTor " + context.getPackageName());
            final Intent orbotStartIntent = getOrbotStartIntent();
            orbotStartIntent.putExtra("org.torproject.android.intent.extra.PACKAGE_NAME", context.getPackageName());
            context.sendBroadcast(orbotStartIntent);
            return true;
        }
        return false;
    }
}
