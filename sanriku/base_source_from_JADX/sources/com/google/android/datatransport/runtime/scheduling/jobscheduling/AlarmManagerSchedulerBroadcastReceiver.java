package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.C0909p;
import p009e.p028d.p030b.p031a.p032i.p039x.C0973a;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    static /* synthetic */ void m226a() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        C0909p.m1240a(context);
        C0903k.C0904a d = C0903k.m1231d();
        d.mo20327a(queryParameter);
        d.mo20326a(C0973a.m1373a(intValue));
        if (queryParameter2 != null) {
            d.mo20328a(Base64.decode(queryParameter2, 0));
        }
        C0909p.m1241b().mo20350a().mo9577a(d.mo20329a(), i, C0630b.m229a());
    }
}
