package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import androidx.annotation.RequiresApi;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;

@RequiresApi(api = 21)
/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.e */
public class C0635e implements C0653s {

    /* renamed from: a */
    private final Context f297a;

    /* renamed from: b */
    private final C0940c f298b;

    /* renamed from: c */
    private final C0637g f299c;

    public C0635e(Context context, C0940c cVar, C0637g gVar) {
        this.f297a = context;
        this.f298b = cVar;
        this.f299c = gVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0092, code lost:
        r7 = false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9552a(p009e.p028d.p030b.p031a.p032i.C0903k r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            android.content.ComponentName r3 = new android.content.ComponentName
            android.content.Context r4 = r0.f297a
            java.lang.Class<com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService> r5 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.class
            r3.<init>(r4, r5)
            android.content.Context r4 = r0.f297a
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.app.job.JobScheduler r4 = (android.app.job.JobScheduler) r4
            java.util.zip.Adler32 r5 = new java.util.zip.Adler32
            r5.<init>()
            android.content.Context r6 = r0.f297a
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r7)
            byte[] r6 = r6.getBytes(r8)
            r5.update(r6)
            java.lang.String r6 = r18.mo20321a()
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)
            byte[] r6 = r6.getBytes(r7)
            r5.update(r6)
            r6 = 4
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r6)
            e.d.b.a.d r8 = r18.mo20323c()
            int r8 = p009e.p028d.p030b.p031a.p032i.p039x.C0973a.m1372a((p009e.p028d.p030b.p031a.C0877d) r8)
            java.nio.ByteBuffer r7 = r7.putInt(r8)
            byte[] r7 = r7.array()
            r5.update(r7)
            byte[] r7 = r18.mo20322b()
            if (r7 == 0) goto L_0x0065
            byte[] r7 = r18.mo20322b()
            r5.update(r7)
        L_0x0065:
            long r7 = r5.getValue()
            int r5 = (int) r7
            java.util.List r7 = r4.getAllPendingJobs()
            java.util.Iterator r7 = r7.iterator()
        L_0x0072:
            boolean r8 = r7.hasNext()
            java.lang.String r9 = "attemptNumber"
            if (r8 == 0) goto L_0x0092
            java.lang.Object r8 = r7.next()
            android.app.job.JobInfo r8 = (android.app.job.JobInfo) r8
            android.os.PersistableBundle r12 = r8.getExtras()
            int r12 = r12.getInt(r9)
            int r8 = r8.getId()
            if (r8 != r5) goto L_0x0072
            if (r12 < r2) goto L_0x0092
            r7 = 1
            goto L_0x0093
        L_0x0092:
            r7 = 0
        L_0x0093:
            java.lang.String r8 = "JobInfoScheduler"
            if (r7 == 0) goto L_0x009d
            java.lang.String r2 = "Upload for context %s is already scheduled. Returning..."
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1249a((java.lang.String) r8, (java.lang.String) r2, (java.lang.Object) r1)
            return
        L_0x009d:
            e.d.b.a.i.u.h.c r7 = r0.f298b
            long r12 = r7.mo20362b((p009e.p028d.p030b.p031a.p032i.C0903k) r1)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g r7 = r0.f299c
            android.app.job.JobInfo$Builder r14 = new android.app.job.JobInfo$Builder
            r14.<init>(r5, r3)
            e.d.b.a.d r3 = r18.mo20323c()
            long r10 = r7.mo9570a(r3, r12, r2)
            r14.setMinimumLatency(r10)
            java.util.Map r7 = r7.mo9555b()
            java.lang.Object r3 = r7.get(r3)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g$b r3 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g.C0639b) r3
            java.util.Set r3 = r3.mo9560b()
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g$c r7 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g.C0641c.NETWORK_UNMETERED
            boolean r7 = r3.contains(r7)
            r10 = 2
            if (r7 == 0) goto L_0x00d1
            r14.setRequiredNetworkType(r10)
            r7 = 1
            goto L_0x00d5
        L_0x00d1:
            r7 = 1
            r14.setRequiredNetworkType(r7)
        L_0x00d5:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g$c r11 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g.C0641c.DEVICE_CHARGING
            boolean r11 = r3.contains(r11)
            if (r11 == 0) goto L_0x00e0
            r14.setRequiresCharging(r7)
        L_0x00e0:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g$c r11 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g.C0641c.DEVICE_IDLE
            boolean r3 = r3.contains(r11)
            if (r3 == 0) goto L_0x00eb
            r14.setRequiresDeviceIdle(r7)
        L_0x00eb:
            android.os.PersistableBundle r3 = new android.os.PersistableBundle
            r3.<init>()
            r3.putInt(r9, r2)
            java.lang.String r7 = r18.mo20321a()
            java.lang.String r9 = "backendName"
            r3.putString(r9, r7)
            e.d.b.a.d r7 = r18.mo20323c()
            int r7 = p009e.p028d.p030b.p031a.p032i.p039x.C0973a.m1372a((p009e.p028d.p030b.p031a.C0877d) r7)
            java.lang.String r9 = "priority"
            r3.putInt(r9, r7)
            byte[] r7 = r18.mo20322b()
            if (r7 == 0) goto L_0x011e
            byte[] r7 = r18.mo20322b()
            r9 = 0
            java.lang.String r7 = android.util.Base64.encodeToString(r7, r9)
            java.lang.String r11 = "extras"
            r3.putString(r11, r7)
            goto L_0x011f
        L_0x011e:
            r9 = 0
        L_0x011f:
            r14.setExtras(r3)
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r9] = r1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7 = 1
            r3[r7] = r5
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g r5 = r0.f299c
            e.d.b.a.d r1 = r18.mo20323c()
            long r15 = r5.mo9570a(r1, r12, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r15)
            r3[r10] = r1
            r1 = 3
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            r3[r1] = r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            r3[r6] = r1
            java.lang.String r1 = "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d"
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1251a((java.lang.String) r8, (java.lang.String) r1, (java.lang.Object[]) r3)
            android.app.job.JobInfo r1 = r14.build()
            r4.schedule(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.C0635e.mo9552a(e.d.b.a.i.k, int):void");
    }
}
