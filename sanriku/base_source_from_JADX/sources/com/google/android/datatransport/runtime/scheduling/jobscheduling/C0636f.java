package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.f */
final /* synthetic */ class C0636f implements Runnable {

    /* renamed from: a */
    private final JobInfoSchedulerService f300a;

    /* renamed from: b */
    private final JobParameters f301b;

    private C0636f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f300a = jobInfoSchedulerService;
        this.f301b = jobParameters;
    }

    /* renamed from: a */
    public static Runnable m240a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new C0636f(jobInfoSchedulerService, jobParameters);
    }

    public void run() {
        this.f300a.jobFinished(this.f301b, false);
    }
}
