package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0702i;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.p027t.C0854c;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p078g.p079a.C1696b;
import p078g.p079a.C1714r;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p085e.p086a.C1609b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase */
public class OrmaDatabase {
    public static final List<C0707k<?>> SCHEMAS = Arrays.asList(new C0707k[]{RFLEntityTrackPoint_Schema.INSTANCE, RFLEntityDailyTag_Schema.INSTANCE, RFLEntityPedometer_Schema.INSTANCE, RFLEntityTag_Schema.INSTANCE, RFLEntityTP_Schema.INSTANCE, RFLEntityForecast_Schema.INSTANCE, RFLEntityBarometer_Schema.INSTANCE, RFLEntityDaily_Schema.INSTANCE, RFLEntityWeather_Schema.INSTANCE, RFLEntityActivity_Schema.INSTANCE, RFLEntityAdjustTrackPoint_Schema.INSTANCE});
    public static String SCHEMA_HASH = "CC8161BF831AE38A176162ECEA44386C6F71F5AB97EAD7DB2717785DDA8E19A4";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0855d f3582a;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$Builder */
    public static class Builder extends C0702i<Builder> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        public OrmaDatabase build() {
            return new OrmaDatabase(new C0855d(fillDefaults(), OrmaDatabase.SCHEMAS));
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String getSchemaHash() {
            return OrmaDatabase.SCHEMA_HASH;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$a */
    class C2289a implements Callable<C0854c<RFLEntityDaily>> {

        /* renamed from: a */
        final /* synthetic */ int f3583a;

        /* renamed from: b */
        final /* synthetic */ boolean f3584b;

        C2289a(int i, boolean z) {
            this.f3583a = i;
            this.f3584b = z;
        }

        public C0854c<RFLEntityDaily> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityDaily_Schema.INSTANCE, this.f3583a, this.f3584b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$b */
    class C2290b implements Callable<C0854c<RFLEntityWeather>> {

        /* renamed from: a */
        final /* synthetic */ int f3586a;

        /* renamed from: b */
        final /* synthetic */ boolean f3587b;

        C2290b(int i, boolean z) {
            this.f3586a = i;
            this.f3587b = z;
        }

        public C0854c<RFLEntityWeather> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityWeather_Schema.INSTANCE, this.f3586a, this.f3587b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$c */
    class C2291c implements Callable<C0854c<RFLEntityActivity>> {

        /* renamed from: a */
        final /* synthetic */ int f3589a;

        /* renamed from: b */
        final /* synthetic */ boolean f3590b;

        C2291c(int i, boolean z) {
            this.f3589a = i;
            this.f3590b = z;
        }

        public C0854c<RFLEntityActivity> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityActivity_Schema.INSTANCE, this.f3589a, this.f3590b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$d */
    class C2292d implements Callable<C0854c<RFLEntityAdjustTrackPoint>> {

        /* renamed from: a */
        final /* synthetic */ int f3592a;

        /* renamed from: b */
        final /* synthetic */ boolean f3593b;

        C2292d(int i, boolean z) {
            this.f3592a = i;
            this.f3593b = z;
        }

        public C0854c<RFLEntityAdjustTrackPoint> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE, this.f3592a, this.f3593b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$e */
    class C2293e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f3595a;

        C2293e(Runnable runnable) {
            this.f3595a = runnable;
        }

        public void run() {
            OrmaDatabase.this.transactionSync(this.f3595a);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$f */
    class C2294f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f3597a;

        C2294f(Runnable runnable) {
            this.f3597a = runnable;
        }

        public void run() {
            OrmaDatabase.this.transactionNonExclusiveSync(this.f3597a);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$g */
    class C2295g implements Callable<C0854c<RFLEntityTrackPoint>> {

        /* renamed from: a */
        final /* synthetic */ int f3599a;

        /* renamed from: b */
        final /* synthetic */ boolean f3600b;

        C2295g(int i, boolean z) {
            this.f3599a = i;
            this.f3600b = z;
        }

        public C0854c<RFLEntityTrackPoint> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE, this.f3599a, this.f3600b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$h */
    class C2296h implements Callable<C0854c<RFLEntityDailyTag>> {

        /* renamed from: a */
        final /* synthetic */ int f3602a;

        /* renamed from: b */
        final /* synthetic */ boolean f3603b;

        C2296h(int i, boolean z) {
            this.f3602a = i;
            this.f3603b = z;
        }

        public C0854c<RFLEntityDailyTag> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityDailyTag_Schema.INSTANCE, this.f3602a, this.f3603b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$i */
    class C2297i implements Callable<C0854c<RFLEntityPedometer>> {

        /* renamed from: a */
        final /* synthetic */ int f3605a;

        /* renamed from: b */
        final /* synthetic */ boolean f3606b;

        C2297i(int i, boolean z) {
            this.f3605a = i;
            this.f3606b = z;
        }

        public C0854c<RFLEntityPedometer> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityPedometer_Schema.INSTANCE, this.f3605a, this.f3606b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$j */
    class C2298j implements Callable<C0854c<RFLEntityTag>> {

        /* renamed from: a */
        final /* synthetic */ int f3608a;

        /* renamed from: b */
        final /* synthetic */ boolean f3609b;

        C2298j(int i, boolean z) {
            this.f3608a = i;
            this.f3609b = z;
        }

        public C0854c<RFLEntityTag> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityTag_Schema.INSTANCE, this.f3608a, this.f3609b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$k */
    class C2299k implements Callable<C0854c<RFLEntityTP>> {

        /* renamed from: a */
        final /* synthetic */ int f3611a;

        /* renamed from: b */
        final /* synthetic */ boolean f3612b;

        C2299k(int i, boolean z) {
            this.f3611a = i;
            this.f3612b = z;
        }

        public C0854c<RFLEntityTP> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityTP_Schema.INSTANCE, this.f3611a, this.f3612b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$l */
    class C2300l implements Callable<C0854c<RFLEntityForecast>> {

        /* renamed from: a */
        final /* synthetic */ int f3614a;

        /* renamed from: b */
        final /* synthetic */ boolean f3615b;

        C2300l(int i, boolean z) {
            this.f3614a = i;
            this.f3615b = z;
        }

        public C0854c<RFLEntityForecast> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityForecast_Schema.INSTANCE, this.f3614a, this.f3615b);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.OrmaDatabase$m */
    class C2301m implements Callable<C0854c<RFLEntityBarometer>> {

        /* renamed from: a */
        final /* synthetic */ int f3617a;

        /* renamed from: b */
        final /* synthetic */ boolean f3618b;

        C2301m(int i, boolean z) {
            this.f3617a = i;
            this.f3618b = z;
        }

        public C0854c<RFLEntityBarometer> call() {
            return new C0854c<>(OrmaDatabase.this.f3582a, RFLEntityBarometer_Schema.INSTANCE, this.f3617a, this.f3618b);
        }
    }

    public OrmaDatabase(@NonNull C0855d dVar) {
        this.f3582a = dVar;
    }

    public static Builder builder(@NonNull Context context) {
        return new Builder(context);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityActivity createRFLEntityActivity(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityActivity> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityActivity_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityActivity) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityActivity(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f, e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint createRFLEntityAdjustTrackPoint(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityAdjustTrackPoint) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityAdjustTrackPoint(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f, e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer createRFLEntityBarometer(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityBarometer(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily createRFLEntityDaily(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityDaily(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag createRFLEntityDailyTag(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityDailyTag(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast createRFLEntityForecast(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityForecast(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityPedometer createRFLEntityPedometer(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityPedometer> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityPedometer_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityPedometer) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityPedometer(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP createRFLEntityTP(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityTP(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag createRFLEntityTag(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityTag(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint createRFLEntityTrackPoint(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityTrackPoint(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [e.c.a.a.a.f<jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather>, e.c.a.a.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityWeather createRFLEntityWeather(@androidx.annotation.NonNull p009e.p015c.p016a.p017a.p018a.C0698f<p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityWeather> r3) {
        /*
            r2 = this;
            e.c.a.a.a.t.d r0 = r2.f3582a
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema r1 = p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityWeather_Schema.INSTANCE
            java.lang.Object r3 = r0.mo19805a(r1, r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityWeather) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase.createRFLEntityWeather(e.c.a.a.a.f):jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather");
    }

    public void deleteAll() {
        this.f3582a.mo19813d();
    }

    @WorkerThread
    @NonNull
    public RFLEntityActivity_Deleter deleteFromRFLEntityActivity() {
        return new RFLEntityActivity_Deleter(this.f3582a, RFLEntityActivity_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityAdjustTrackPoint_Deleter deleteFromRFLEntityAdjustTrackPoint() {
        return new RFLEntityAdjustTrackPoint_Deleter(this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityBarometer_Deleter deleteFromRFLEntityBarometer() {
        return new RFLEntityBarometer_Deleter(this.f3582a, RFLEntityBarometer_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityDaily_Deleter deleteFromRFLEntityDaily() {
        return new RFLEntityDaily_Deleter(this.f3582a, RFLEntityDaily_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityDailyTag_Deleter deleteFromRFLEntityDailyTag() {
        return new RFLEntityDailyTag_Deleter(this.f3582a, RFLEntityDailyTag_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityForecast_Deleter deleteFromRFLEntityForecast() {
        return new RFLEntityForecast_Deleter(this.f3582a, RFLEntityForecast_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityPedometer_Deleter deleteFromRFLEntityPedometer() {
        return new RFLEntityPedometer_Deleter(this.f3582a, RFLEntityPedometer_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTP_Deleter deleteFromRFLEntityTP() {
        return new RFLEntityTP_Deleter(this.f3582a, RFLEntityTP_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTag_Deleter deleteFromRFLEntityTag() {
        return new RFLEntityTag_Deleter(this.f3582a, RFLEntityTag_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTrackPoint_Deleter deleteFromRFLEntityTrackPoint() {
        return new RFLEntityTrackPoint_Deleter(this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityWeather_Deleter deleteFromRFLEntityWeather() {
        return new RFLEntityWeather_Deleter(this.f3582a, RFLEntityWeather_Schema.INSTANCE);
    }

    @NonNull
    public C0855d getConnection() {
        return this.f3582a;
    }

    @NonNull
    public List<C0707k<?>> getSchemas() {
        return SCHEMAS;
    }

    @WorkerThread
    public long insertIntoRFLEntityActivity(@NonNull RFLEntityActivity rFLEntityActivity) {
        return prepareInsertIntoRFLEntityActivity().mo19797b(rFLEntityActivity);
    }

    @WorkerThread
    public long insertIntoRFLEntityAdjustTrackPoint(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
        return prepareInsertIntoRFLEntityAdjustTrackPoint().mo19797b(rFLEntityAdjustTrackPoint);
    }

    @WorkerThread
    public long insertIntoRFLEntityBarometer(@NonNull RFLEntityBarometer rFLEntityBarometer) {
        return prepareInsertIntoRFLEntityBarometer().mo19797b(rFLEntityBarometer);
    }

    @WorkerThread
    public long insertIntoRFLEntityDaily(@NonNull RFLEntityDaily rFLEntityDaily) {
        return prepareInsertIntoRFLEntityDaily().mo19797b(rFLEntityDaily);
    }

    @WorkerThread
    public long insertIntoRFLEntityDailyTag(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
        return prepareInsertIntoRFLEntityDailyTag().mo19797b(rFLEntityDailyTag);
    }

    @WorkerThread
    public long insertIntoRFLEntityForecast(@NonNull RFLEntityForecast rFLEntityForecast) {
        return prepareInsertIntoRFLEntityForecast().mo19797b(rFLEntityForecast);
    }

    @WorkerThread
    public long insertIntoRFLEntityPedometer(@NonNull RFLEntityPedometer rFLEntityPedometer) {
        return prepareInsertIntoRFLEntityPedometer().mo19797b(rFLEntityPedometer);
    }

    @WorkerThread
    public long insertIntoRFLEntityTP(@NonNull RFLEntityTP rFLEntityTP) {
        return prepareInsertIntoRFLEntityTP().mo19797b(rFLEntityTP);
    }

    @WorkerThread
    public long insertIntoRFLEntityTag(@NonNull RFLEntityTag rFLEntityTag) {
        return prepareInsertIntoRFLEntityTag().mo19797b(rFLEntityTag);
    }

    @WorkerThread
    public long insertIntoRFLEntityTrackPoint(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
        return prepareInsertIntoRFLEntityTrackPoint().mo19797b(rFLEntityTrackPoint);
    }

    @WorkerThread
    public long insertIntoRFLEntityWeather(@NonNull RFLEntityWeather rFLEntityWeather) {
        return prepareInsertIntoRFLEntityWeather().mo19797b(rFLEntityWeather);
    }

    public void migrate() {
        this.f3582a.mo19816l();
    }

    @NonNull
    public RFLEntityActivity newRFLEntityActivityFromCursor(@NonNull Cursor cursor) {
        return RFLEntityActivity_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityAdjustTrackPoint newRFLEntityAdjustTrackPointFromCursor(@NonNull Cursor cursor) {
        return RFLEntityAdjustTrackPoint_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityBarometer newRFLEntityBarometerFromCursor(@NonNull Cursor cursor) {
        return RFLEntityBarometer_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityDaily newRFLEntityDailyFromCursor(@NonNull Cursor cursor) {
        return RFLEntityDaily_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityDailyTag newRFLEntityDailyTagFromCursor(@NonNull Cursor cursor) {
        return RFLEntityDailyTag_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityForecast newRFLEntityForecastFromCursor(@NonNull Cursor cursor) {
        return RFLEntityForecast_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityPedometer newRFLEntityPedometerFromCursor(@NonNull Cursor cursor) {
        return RFLEntityPedometer_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityTP newRFLEntityTPFromCursor(@NonNull Cursor cursor) {
        return RFLEntityTP_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityTag newRFLEntityTagFromCursor(@NonNull Cursor cursor) {
        return RFLEntityTag_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityTrackPoint newRFLEntityTrackPointFromCursor(@NonNull Cursor cursor) {
        return RFLEntityTrackPoint_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @NonNull
    public RFLEntityWeather newRFLEntityWeatherFromCursor(@NonNull Cursor cursor) {
        return RFLEntityWeather_Schema.INSTANCE.newModelFromCursor((C0700h) this.f3582a, cursor, 0);
    }

    @WorkerThread
    public C0854c<RFLEntityActivity> prepareInsertIntoRFLEntityActivity() {
        return prepareInsertIntoRFLEntityActivity(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityActivity> prepareInsertIntoRFLEntityActivity(int i) {
        return prepareInsertIntoRFLEntityActivity(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityActivity> prepareInsertIntoRFLEntityActivity(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityActivity_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityActivity>> prepareInsertIntoRFLEntityActivityAsSingle() {
        return prepareInsertIntoRFLEntityActivityAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityActivity>> prepareInsertIntoRFLEntityActivityAsSingle(int i) {
        return prepareInsertIntoRFLEntityActivityAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityActivity>> prepareInsertIntoRFLEntityActivityAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2291c(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityAdjustTrackPoint> prepareInsertIntoRFLEntityAdjustTrackPoint() {
        return prepareInsertIntoRFLEntityAdjustTrackPoint(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityAdjustTrackPoint> prepareInsertIntoRFLEntityAdjustTrackPoint(int i) {
        return prepareInsertIntoRFLEntityAdjustTrackPoint(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityAdjustTrackPoint> prepareInsertIntoRFLEntityAdjustTrackPoint(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityAdjustTrackPoint>> prepareInsertIntoRFLEntityAdjustTrackPointAsSingle() {
        return prepareInsertIntoRFLEntityAdjustTrackPointAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityAdjustTrackPoint>> prepareInsertIntoRFLEntityAdjustTrackPointAsSingle(int i) {
        return prepareInsertIntoRFLEntityAdjustTrackPointAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityAdjustTrackPoint>> prepareInsertIntoRFLEntityAdjustTrackPointAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2292d(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityBarometer> prepareInsertIntoRFLEntityBarometer() {
        return prepareInsertIntoRFLEntityBarometer(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityBarometer> prepareInsertIntoRFLEntityBarometer(int i) {
        return prepareInsertIntoRFLEntityBarometer(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityBarometer> prepareInsertIntoRFLEntityBarometer(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityBarometer_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityBarometer>> prepareInsertIntoRFLEntityBarometerAsSingle() {
        return prepareInsertIntoRFLEntityBarometerAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityBarometer>> prepareInsertIntoRFLEntityBarometerAsSingle(int i) {
        return prepareInsertIntoRFLEntityBarometerAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityBarometer>> prepareInsertIntoRFLEntityBarometerAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2301m(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityDaily> prepareInsertIntoRFLEntityDaily() {
        return prepareInsertIntoRFLEntityDaily(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityDaily> prepareInsertIntoRFLEntityDaily(int i) {
        return prepareInsertIntoRFLEntityDaily(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityDaily> prepareInsertIntoRFLEntityDaily(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityDaily_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDaily>> prepareInsertIntoRFLEntityDailyAsSingle() {
        return prepareInsertIntoRFLEntityDailyAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDaily>> prepareInsertIntoRFLEntityDailyAsSingle(int i) {
        return prepareInsertIntoRFLEntityDailyAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDaily>> prepareInsertIntoRFLEntityDailyAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2289a(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityDailyTag> prepareInsertIntoRFLEntityDailyTag() {
        return prepareInsertIntoRFLEntityDailyTag(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityDailyTag> prepareInsertIntoRFLEntityDailyTag(int i) {
        return prepareInsertIntoRFLEntityDailyTag(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityDailyTag> prepareInsertIntoRFLEntityDailyTag(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityDailyTag_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDailyTag>> prepareInsertIntoRFLEntityDailyTagAsSingle() {
        return prepareInsertIntoRFLEntityDailyTagAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDailyTag>> prepareInsertIntoRFLEntityDailyTagAsSingle(int i) {
        return prepareInsertIntoRFLEntityDailyTagAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityDailyTag>> prepareInsertIntoRFLEntityDailyTagAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2296h(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityForecast> prepareInsertIntoRFLEntityForecast() {
        return prepareInsertIntoRFLEntityForecast(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityForecast> prepareInsertIntoRFLEntityForecast(int i) {
        return prepareInsertIntoRFLEntityForecast(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityForecast> prepareInsertIntoRFLEntityForecast(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityForecast_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityForecast>> prepareInsertIntoRFLEntityForecastAsSingle() {
        return prepareInsertIntoRFLEntityForecastAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityForecast>> prepareInsertIntoRFLEntityForecastAsSingle(int i) {
        return prepareInsertIntoRFLEntityForecastAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityForecast>> prepareInsertIntoRFLEntityForecastAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2300l(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityPedometer> prepareInsertIntoRFLEntityPedometer() {
        return prepareInsertIntoRFLEntityPedometer(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityPedometer> prepareInsertIntoRFLEntityPedometer(int i) {
        return prepareInsertIntoRFLEntityPedometer(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityPedometer> prepareInsertIntoRFLEntityPedometer(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityPedometer_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityPedometer>> prepareInsertIntoRFLEntityPedometerAsSingle() {
        return prepareInsertIntoRFLEntityPedometerAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityPedometer>> prepareInsertIntoRFLEntityPedometerAsSingle(int i) {
        return prepareInsertIntoRFLEntityPedometerAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityPedometer>> prepareInsertIntoRFLEntityPedometerAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2297i(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityTP> prepareInsertIntoRFLEntityTP() {
        return prepareInsertIntoRFLEntityTP(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTP> prepareInsertIntoRFLEntityTP(int i) {
        return prepareInsertIntoRFLEntityTP(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTP> prepareInsertIntoRFLEntityTP(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityTP_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTP>> prepareInsertIntoRFLEntityTPAsSingle() {
        return prepareInsertIntoRFLEntityTPAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTP>> prepareInsertIntoRFLEntityTPAsSingle(int i) {
        return prepareInsertIntoRFLEntityTPAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTP>> prepareInsertIntoRFLEntityTPAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2299k(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityTag> prepareInsertIntoRFLEntityTag() {
        return prepareInsertIntoRFLEntityTag(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTag> prepareInsertIntoRFLEntityTag(int i) {
        return prepareInsertIntoRFLEntityTag(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTag> prepareInsertIntoRFLEntityTag(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityTag_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTag>> prepareInsertIntoRFLEntityTagAsSingle() {
        return prepareInsertIntoRFLEntityTagAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTag>> prepareInsertIntoRFLEntityTagAsSingle(int i) {
        return prepareInsertIntoRFLEntityTagAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTag>> prepareInsertIntoRFLEntityTagAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2298j(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityTrackPoint> prepareInsertIntoRFLEntityTrackPoint() {
        return prepareInsertIntoRFLEntityTrackPoint(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTrackPoint> prepareInsertIntoRFLEntityTrackPoint(int i) {
        return prepareInsertIntoRFLEntityTrackPoint(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityTrackPoint> prepareInsertIntoRFLEntityTrackPoint(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTrackPoint>> prepareInsertIntoRFLEntityTrackPointAsSingle() {
        return prepareInsertIntoRFLEntityTrackPointAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTrackPoint>> prepareInsertIntoRFLEntityTrackPointAsSingle(int i) {
        return prepareInsertIntoRFLEntityTrackPointAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityTrackPoint>> prepareInsertIntoRFLEntityTrackPointAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2295g(i, z));
    }

    @WorkerThread
    public C0854c<RFLEntityWeather> prepareInsertIntoRFLEntityWeather() {
        return prepareInsertIntoRFLEntityWeather(0, true);
    }

    @WorkerThread
    public C0854c<RFLEntityWeather> prepareInsertIntoRFLEntityWeather(int i) {
        return prepareInsertIntoRFLEntityWeather(i, true);
    }

    @WorkerThread
    public C0854c<RFLEntityWeather> prepareInsertIntoRFLEntityWeather(int i, boolean z) {
        return new C0854c<>(this.f3582a, RFLEntityWeather_Schema.INSTANCE, i, z);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityWeather>> prepareInsertIntoRFLEntityWeatherAsSingle() {
        return prepareInsertIntoRFLEntityWeatherAsSingle(0, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityWeather>> prepareInsertIntoRFLEntityWeatherAsSingle(int i) {
        return prepareInsertIntoRFLEntityWeatherAsSingle(i, true);
    }

    @CheckResult
    public C1714r<C0854c<RFLEntityWeather>> prepareInsertIntoRFLEntityWeatherAsSingle(int i, boolean z) {
        return C1714r.m2413a(new C2290b(i, z));
    }

    @NonNull
    public RFLEntityActivity_Relation relationOfRFLEntityActivity() {
        return new RFLEntityActivity_Relation(this.f3582a, RFLEntityActivity_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Relation relationOfRFLEntityAdjustTrackPoint() {
        return new RFLEntityAdjustTrackPoint_Relation(this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityBarometer_Relation relationOfRFLEntityBarometer() {
        return new RFLEntityBarometer_Relation(this.f3582a, RFLEntityBarometer_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityDaily_Relation relationOfRFLEntityDaily() {
        return new RFLEntityDaily_Relation(this.f3582a, RFLEntityDaily_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityDailyTag_Relation relationOfRFLEntityDailyTag() {
        return new RFLEntityDailyTag_Relation(this.f3582a, RFLEntityDailyTag_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityForecast_Relation relationOfRFLEntityForecast() {
        return new RFLEntityForecast_Relation(this.f3582a, RFLEntityForecast_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityPedometer_Relation relationOfRFLEntityPedometer() {
        return new RFLEntityPedometer_Relation(this.f3582a, RFLEntityPedometer_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTP_Relation relationOfRFLEntityTP() {
        return new RFLEntityTP_Relation(this.f3582a, RFLEntityTP_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTag_Relation relationOfRFLEntityTag() {
        return new RFLEntityTag_Relation(this.f3582a, RFLEntityTag_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTrackPoint_Relation relationOfRFLEntityTrackPoint() {
        return new RFLEntityTrackPoint_Relation(this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityWeather_Relation relationOfRFLEntityWeather() {
        return new RFLEntityWeather_Relation(this.f3582a, RFLEntityWeather_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityActivity_Selector selectFromRFLEntityActivity() {
        return new RFLEntityActivity_Selector(this.f3582a, RFLEntityActivity_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Selector selectFromRFLEntityAdjustTrackPoint() {
        return new RFLEntityAdjustTrackPoint_Selector(this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityBarometer_Selector selectFromRFLEntityBarometer() {
        return new RFLEntityBarometer_Selector(this.f3582a, RFLEntityBarometer_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityDaily_Selector selectFromRFLEntityDaily() {
        return new RFLEntityDaily_Selector(this.f3582a, RFLEntityDaily_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityDailyTag_Selector selectFromRFLEntityDailyTag() {
        return new RFLEntityDailyTag_Selector(this.f3582a, RFLEntityDailyTag_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityForecast_Selector selectFromRFLEntityForecast() {
        return new RFLEntityForecast_Selector(this.f3582a, RFLEntityForecast_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityPedometer_Selector selectFromRFLEntityPedometer() {
        return new RFLEntityPedometer_Selector(this.f3582a, RFLEntityPedometer_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTP_Selector selectFromRFLEntityTP() {
        return new RFLEntityTP_Selector(this.f3582a, RFLEntityTP_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTag_Selector selectFromRFLEntityTag() {
        return new RFLEntityTag_Selector(this.f3582a, RFLEntityTag_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityTrackPoint_Selector selectFromRFLEntityTrackPoint() {
        return new RFLEntityTrackPoint_Selector(this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE);
    }

    @NonNull
    public RFLEntityWeather_Selector selectFromRFLEntityWeather() {
        return new RFLEntityWeather_Selector(this.f3582a, RFLEntityWeather_Schema.INSTANCE);
    }

    @CheckResult
    public C1696b transactionAsCompletable(@NonNull Runnable runnable) {
        C2293e eVar = new C2293e(runnable);
        C1599b.m2241a(eVar, "run is null");
        return new C1609b(eVar);
    }

    @CheckResult
    public C1696b transactionNonExclusiveAsCompletable(@NonNull Runnable runnable) {
        C2294f fVar = new C2294f(runnable);
        C1599b.m2241a(fVar, "run is null");
        return new C1609b(fVar);
    }

    public void transactionNonExclusiveSync(@NonNull Runnable runnable) {
        this.f3582a.mo19810a(runnable);
    }

    @WorkerThread
    public void transactionSync(@NonNull Runnable runnable) {
        this.f3582a.mo19811b(runnable);
    }

    @WorkerThread
    @NonNull
    public RFLEntityActivity_Updater updateRFLEntityActivity() {
        return new RFLEntityActivity_Updater(this.f3582a, RFLEntityActivity_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityAdjustTrackPoint_Updater updateRFLEntityAdjustTrackPoint() {
        return new RFLEntityAdjustTrackPoint_Updater(this.f3582a, RFLEntityAdjustTrackPoint_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityBarometer_Updater updateRFLEntityBarometer() {
        return new RFLEntityBarometer_Updater(this.f3582a, RFLEntityBarometer_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityDaily_Updater updateRFLEntityDaily() {
        return new RFLEntityDaily_Updater(this.f3582a, RFLEntityDaily_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityDailyTag_Updater updateRFLEntityDailyTag() {
        return new RFLEntityDailyTag_Updater(this.f3582a, RFLEntityDailyTag_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityForecast_Updater updateRFLEntityForecast() {
        return new RFLEntityForecast_Updater(this.f3582a, RFLEntityForecast_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityPedometer_Updater updateRFLEntityPedometer() {
        return new RFLEntityPedometer_Updater(this.f3582a, RFLEntityPedometer_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTP_Updater updateRFLEntityTP() {
        return new RFLEntityTP_Updater(this.f3582a, RFLEntityTP_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTag_Updater updateRFLEntityTag() {
        return new RFLEntityTag_Updater(this.f3582a, RFLEntityTag_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityTrackPoint_Updater updateRFLEntityTrackPoint() {
        return new RFLEntityTrackPoint_Updater(this.f3582a, RFLEntityTrackPoint_Schema.INSTANCE);
    }

    @WorkerThread
    @NonNull
    public RFLEntityWeather_Updater updateRFLEntityWeather() {
        return new RFLEntityWeather_Updater(this.f3582a, RFLEntityWeather_Schema.INSTANCE);
    }
}
