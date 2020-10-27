package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.C0909p;
import p009e.p028d.p030b.p031a.p032i.p039x.C0973a;

@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C0909p.m1240a(getApplicationContext());
        C0903k.C0904a d = C0903k.m1231d();
        d.mo20327a(string);
        d.mo20326a(C0973a.m1373a(i));
        if (string2 != null) {
            d.mo20328a(Base64.decode(string2, 0));
        }
        C0909p.m1241b().mo20350a().mo9577a(d.mo20329a(), i2, C0636f.m240a(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
