package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p009e.p028d.p030b.p031a.p032i.p039x.C0973a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.a */
public class C0629a implements C0653s {

    /* renamed from: a */
    private final Context f283a;

    /* renamed from: b */
    private final C0940c f284b;

    /* renamed from: c */
    private AlarmManager f285c;

    /* renamed from: d */
    private final C0637g f286d;

    /* renamed from: e */
    private final C0968a f287e;

    public C0629a(Context context, C0940c cVar, C0968a aVar, C0637g gVar) {
        this.f283a = context;
        this.f284b = cVar;
        this.f285c = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f287e = aVar;
        this.f286d = gVar;
    }

    /* renamed from: a */
    public void mo9552a(C0903k kVar, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", kVar.mo20321a());
        builder.appendQueryParameter("priority", String.valueOf(C0973a.m1372a(kVar.mo20323c())));
        if (kVar.mo20322b() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(kVar.mo20322b(), 0));
        }
        Intent intent = new Intent(this.f283a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (PendingIntent.getBroadcast(this.f283a, 0, intent, 536870912) != null) {
            C0913a.m1249a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", (Object) kVar);
            return;
        }
        long b = this.f284b.mo20362b(kVar);
        long a = this.f286d.mo9570a(kVar.mo20323c(), b, i);
        C0913a.m1251a("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", kVar, Long.valueOf(a), Long.valueOf(b), Integer.valueOf(i));
        this.f285c.set(3, this.f287e.mo20396a() + a, PendingIntent.getBroadcast(this.f283a, 0, intent, 0));
    }
}
