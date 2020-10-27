package p009e.p028d.p061c.p062a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.browser.trusted.TrustedWebActivityService;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p009e.p028d.p061c.p062a.p063g.C1566a;

/* renamed from: e.d.c.a.e */
public class C1562e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f1822a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public final String f1823b;

    /* renamed from: c */
    private final int f1824c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f1825d = 96375;
    @Nullable

    /* renamed from: e */
    private C1564b f1826e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public CustomTabsSession f1827f;

    /* renamed from: g */
    private boolean f1828g;

    /* renamed from: e.d.c.a.e$b */
    private class C1564b extends CustomTabsServiceConnection {

        /* renamed from: a */
        private Runnable f1829a;

        /* renamed from: b */
        private Runnable f1830b;

        /* synthetic */ C1564b(C1563a aVar) {
        }

        /* renamed from: a */
        static /* synthetic */ void m2192a(C1564b bVar, Runnable runnable, Runnable runnable2) {
            bVar.f1829a = runnable;
            bVar.f1830b = runnable2;
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Runnable runnable;
            if (!C1561d.m2177a(C1562e.this.f1822a.getPackageManager(), C1562e.this.f1823b)) {
                customTabsClient.warmup(0);
            }
            C1562e eVar = C1562e.this;
            CustomTabsSession unused = eVar.f1827f = customTabsClient.newSession((CustomTabsCallback) null, eVar.f1825d);
            if (!(C1562e.this.f1827f == null || (runnable = this.f1829a) == null) || (C1562e.this.f1827f == null && (runnable = this.f1830b) != null)) {
                runnable.run();
            }
            this.f1829a = null;
            this.f1830b = null;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            CustomTabsSession unused = C1562e.this.f1827f = null;
        }
    }

    public C1562e(Context context) {
        C1565f fVar;
        int i;
        this.f1822a = context;
        PackageManager packageManager = context.getPackageManager();
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.parse("http://"));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(data, 65536);
        if (Build.VERSION.SDK_INT >= 23) {
            queryIntentActivities.addAll(packageManager.queryIntentActivities(data, 131072));
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 64);
        HashMap hashMap = new HashMap();
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            String str = next.serviceInfo.packageName;
            if (C1561d.m2179b(packageManager, str)) {
                i = 0;
            } else {
                IntentFilter intentFilter = next.filter;
                if (intentFilter != null && intentFilter.hasCategory(CustomTabsService.TRUSTED_WEB_ACTIVITY_CATEGORY)) {
                    i2 = 1;
                }
                i = Integer.valueOf(i2 ^ 1);
            }
            hashMap.put(str, i);
        }
        Iterator<ResolveInfo> it2 = queryIntentActivities.iterator();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (it2.hasNext()) {
                String str4 = it2.next().activityInfo.packageName;
                int intValue = hashMap.containsKey(str4) ? ((Integer) hashMap.get(str4)).intValue() : 2;
                if (intValue == 0) {
                    Log.d("TWAProviderPicker", "Found TWA provider, finishing search: " + str4);
                    fVar = new C1565f(0, str4);
                    break;
                } else if (intValue == 1) {
                    Log.d("TWAProviderPicker", "Found Custom Tabs provider: " + str4);
                    if (str2 == null) {
                        str2 = str4;
                    }
                } else if (intValue == 2) {
                    Log.d("TWAProviderPicker", "Found browser: " + str4);
                    if (str3 == null) {
                        str3 = str4;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                if (str2 != null) {
                    sb.append("Found no TWA providers, using first Custom Tabs provider: ");
                    sb.append(str2);
                    Log.d("TWAProviderPicker", sb.toString());
                    fVar = new C1565f(1, str2);
                } else {
                    sb.append("Found no TWA providers, using first browser: ");
                    sb.append(str3);
                    Log.d("TWAProviderPicker", sb.toString());
                    fVar = new C1565f(2, str3);
                }
            }
        }
        this.f1823b = fVar.f1833b;
        this.f1824c = fVar.f1832a;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void mo27329a(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable Runnable runnable) {
        CustomTabsIntent buildCustomTabsIntent = trustedWebActivityIntentBuilder.buildCustomTabsIntent();
        String str = this.f1823b;
        if (str != null) {
            buildCustomTabsIntent.intent.setPackage(str);
        }
        buildCustomTabsIntent.launchUrl(this.f1822a, trustedWebActivityIntentBuilder.getUrl());
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void mo27331b(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable Runnable runnable) {
        Log.d("TwaLauncher", "Launching Trusted Web Activity.");
        ContextCompat.startActivity(this.f1822a, trustedWebActivityIntentBuilder.build(this.f1827f), (Bundle) null);
        TrustedWebActivityService.setVerifiedProvider(this.f1822a, this.f1823b);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public void mo27327a() {
        C1564b bVar = this.f1826e;
        if (bVar != null) {
            this.f1822a.unbindService(bVar);
        }
        this.f1828g = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo27328a(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, C1566a aVar, Runnable runnable) {
        CustomTabsSession customTabsSession = this.f1827f;
        if (customTabsSession == null) {
            throw new IllegalStateException("mSession is null in launchWhenSessionEstablished");
        } else if (aVar != null) {
            aVar.mo27333a(trustedWebActivityIntentBuilder, customTabsSession, new C1560c(this, trustedWebActivityIntentBuilder, runnable));
        } else {
            mo27331b(trustedWebActivityIntentBuilder, runnable);
        }
    }

    /* renamed from: b */
    public void mo27330b(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable C1566a aVar, @Nullable Runnable runnable) {
        if (this.f1828g) {
            throw new IllegalStateException("TwaLauncher already destroyed");
        } else if (this.f1824c == 0) {
            if (aVar != null) {
                aVar.mo27334a(this.f1823b, trustedWebActivityIntentBuilder);
            }
            C1558a aVar2 = new C1558a(this, trustedWebActivityIntentBuilder, aVar, runnable);
            if (this.f1827f != null) {
                aVar2.run();
                return;
            }
            C1559b bVar = new C1559b(this, trustedWebActivityIntentBuilder, runnable);
            if (this.f1826e == null) {
                this.f1826e = new C1564b((C1563a) null);
            }
            C1564b.m2192a(this.f1826e, aVar2, bVar);
            CustomTabsClient.bindCustomTabsService(this.f1822a, this.f1823b, this.f1826e);
        } else {
            mo27329a(trustedWebActivityIntentBuilder, runnable);
        }
    }
}
