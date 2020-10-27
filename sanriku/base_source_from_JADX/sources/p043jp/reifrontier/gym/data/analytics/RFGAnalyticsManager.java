package p043jp.reifrontier.gym.data.analytics;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.RFGApp;
import p043jp.reifrontier.gym.RFGDef;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/data/analytics/RFGAnalyticsManager;", "", "()V", "UNDEFINED_ACTION", "", "UNDEFINED_CATEGORY", "sAnalytics", "Lcom/google/android/gms/analytics/GoogleAnalytics;", "sTracker", "Lcom/google/android/gms/analytics/Tracker;", "initialize", "", "context", "Landroid/content/Context;", "sendEvent", "category", "action", "label", "sendScreen", "screen", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.analytics.RFGAnalyticsManager */
public final class RFGAnalyticsManager {
    public static final RFGAnalyticsManager INSTANCE = new RFGAnalyticsManager();
    public static final String UNDEFINED_ACTION = "999z";
    public static final String UNDEFINED_CATEGORY = "999";
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    private RFGAnalyticsManager() {
    }

    public static /* synthetic */ void sendEvent$default(RFGAnalyticsManager rFGAnalyticsManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        rFGAnalyticsManager.sendEvent(str, str2, str3);
    }

    public final void initialize(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (BuildConfig.GGL_TRACKING_ID.length() > 0) {
            GoogleAnalytics instance = GoogleAnalytics.getInstance(context);
            sAnalytics = instance;
            if (instance != null) {
                instance.setAppOptOut(false);
                sTracker = instance.newTracker(BuildConfig.GGL_TRACKING_ID);
            }
        }
    }

    public final void sendEvent(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "category");
        Intrinsics.checkParameterIsNotNull(str2, "action");
        Tracker tracker = sTracker;
        if (tracker != null) {
            RFGDef.Info info = RFGDef.Info.INSTANCE;
            int stringId = info.getStringId('g' + str);
            RFGDef.Info info2 = RFGDef.Info.INSTANCE;
            int stringId2 = info2.getStringId('g' + str2);
            if (stringId != -1 && stringId2 != -1) {
                String string = RFGApp.Companion.applicationContext().getString(stringId);
                Intrinsics.checkExpressionValueIsNotNull(string, "RFGApp.applicationContext().getString(categoryId)");
                String string2 = RFGApp.Companion.applicationContext().getString(stringId2);
                Intrinsics.checkExpressionValueIsNotNull(string2, "RFGApp.applicationContext().getString(actionId)");
                HitBuilders.EventBuilder action = new HitBuilders.EventBuilder().setCategory(string).setAction(string2);
                if (str3 != null) {
                    action.setLabel(str3);
                }
                C1122a.m1596a("[Gym]::Debug GA category:" + string + ", action:" + string2 + ", label:" + str3, new Object[0]);
                tracker.send(action.build());
            }
        }
    }

    public final void sendScreen(String str) {
        Intrinsics.checkParameterIsNotNull(str, "screen");
        Tracker tracker = sTracker;
        if (tracker != null) {
            RFGDef.Info info = RFGDef.Info.INSTANCE;
            int stringId = info.getStringId('g' + str);
            if (stringId != -1) {
                String string = RFGApp.Companion.applicationContext().getString(stringId);
                Intrinsics.checkExpressionValueIsNotNull(string, "RFGApp.applicationContext().getString(screenId)");
                C1122a.m1596a(C0681a.m320a("[Gym]::Debug GA screen:", string), new Object[0]);
                tracker.setScreenName(string);
                tracker.send(new HitBuilders.ScreenViewBuilder().build());
            }
        }
    }
}
