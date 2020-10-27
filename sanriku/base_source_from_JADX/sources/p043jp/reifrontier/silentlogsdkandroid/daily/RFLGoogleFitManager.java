package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.HistoryClient;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J[\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u0018J\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u001f2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016J&\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0016\u0010%\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0002JS\u0010(\u001a\u00020\r2K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u0018J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0018\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020$0\u00122\u0006\u0010/\u001a\u000200H\u0002Je\u00102\u001a\u00020\r2K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u00064"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fitnessOptions", "Lcom/google/android/gms/fitness/FitnessOptions;", "historyClient", "Lcom/google/android/gms/fitness/HistoryClient;", "isConnected", "", "()Z", "connect", "", "disconnect", "getAllBucketsSteps", "", "buckets", "", "Lcom/google/android/gms/fitness/data/Bucket;", "getDailyStepCount", "targetDate", "Ljava/util/Date;", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", "date", "steps", "getMinuteRangeStepCount", "", "", "startTime", "endTime", "getRangeStepCount", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager$StepCount;", "getSteps", "dataSets", "Lcom/google/android/gms/fitness/data/DataSet;", "getTodayStepCount", "queryFitnessData", "Lcom/google/android/gms/fitness/request/DataReadRequest;", "start", "end", "queryFitnessDataMinute", "readResult", "dataReadResponse", "Lcom/google/android/gms/fitness/result/DataReadResponse;", "readResultByBucket", "sendResultStepCount", "StepCount", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager */
public final class RFLGoogleFitManager {

    /* renamed from: a */
    private final FitnessOptions f3192a;

    /* renamed from: b */
    private HistoryClient f3193b;

    /* renamed from: c */
    private final Context f3194c;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager$StepCount;", "", "startTime", "Ljava/util/Date;", "endTime", "steps", "", "(Ljava/util/Date;Ljava/util/Date;I)V", "getEndTime", "()Ljava/util/Date;", "getStartTime", "getSteps", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager$StepCount */
    public static final class StepCount {

        /* renamed from: a */
        private final Date f3195a;

        /* renamed from: b */
        private final Date f3196b;

        /* renamed from: c */
        private final int f3197c;

        public StepCount(Date date, Date date2, int i) {
            Intrinsics.checkParameterIsNotNull(date, "startTime");
            Intrinsics.checkParameterIsNotNull(date2, "endTime");
            this.f3195a = date;
            this.f3196b = date2;
            this.f3197c = i;
        }

        public static /* synthetic */ StepCount copy$default(StepCount stepCount, Date date, Date date2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                date = stepCount.f3195a;
            }
            if ((i2 & 2) != 0) {
                date2 = stepCount.f3196b;
            }
            if ((i2 & 4) != 0) {
                i = stepCount.f3197c;
            }
            return stepCount.copy(date, date2, i);
        }

        public final Date component1() {
            return this.f3195a;
        }

        public final Date component2() {
            return this.f3196b;
        }

        public final int component3() {
            return this.f3197c;
        }

        public final StepCount copy(Date date, Date date2, int i) {
            Intrinsics.checkParameterIsNotNull(date, "startTime");
            Intrinsics.checkParameterIsNotNull(date2, "endTime");
            return new StepCount(date, date2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StepCount)) {
                return false;
            }
            StepCount stepCount = (StepCount) obj;
            return Intrinsics.areEqual((Object) this.f3195a, (Object) stepCount.f3195a) && Intrinsics.areEqual((Object) this.f3196b, (Object) stepCount.f3196b) && this.f3197c == stepCount.f3197c;
        }

        public final Date getEndTime() {
            return this.f3196b;
        }

        public final Date getStartTime() {
            return this.f3195a;
        }

        public final int getSteps() {
            return this.f3197c;
        }

        public int hashCode() {
            Date date = this.f3195a;
            int i = 0;
            int hashCode = (date != null ? date.hashCode() : 0) * 31;
            Date date2 = this.f3196b;
            if (date2 != null) {
                i = date2.hashCode();
            }
            return ((hashCode + i) * 31) + this.f3197c;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("StepCount(startTime=");
            a.append(this.f3195a);
            a.append(", endTime=");
            a.append(this.f3196b);
            a.append(", steps=");
            return C0681a.m322a(a, this.f3197c, ")");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager$a */
    static final class C2191a<TResult> implements OnSuccessListener<DataReadResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLGoogleFitManager f3198a;

        /* renamed from: b */
        final /* synthetic */ Function3 f3199b;

        /* renamed from: c */
        final /* synthetic */ Date f3200c;

        C2191a(RFLGoogleFitManager rFLGoogleFitManager, Function3 function3, Date date) {
            this.f3198a = rFLGoogleFitManager;
            this.f3199b = function3;
            this.f3200c = date;
        }

        /* renamed from: a */
        public final void onSuccess(DataReadResponse dataReadResponse) {
            RFLGoogleFitManager rFLGoogleFitManager = this.f3198a;
            Intrinsics.checkExpressionValueIsNotNull(dataReadResponse, "dataReadResponse");
            this.f3198a.m3743a((Function3<? super Boolean, ? super Date, ? super Integer, Unit>) this.f3199b, this.f3200c, rFLGoogleFitManager.m3739a(dataReadResponse));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager$b */
    static final class C2192b implements OnFailureListener {

        /* renamed from: a */
        final /* synthetic */ RFLGoogleFitManager f3201a;

        /* renamed from: b */
        final /* synthetic */ Function3 f3202b;

        /* renamed from: c */
        final /* synthetic */ Date f3203c;

        C2192b(RFLGoogleFitManager rFLGoogleFitManager, Function3 function3, Date date) {
            this.f3201a = rFLGoogleFitManager;
            this.f3202b = function3;
            this.f3203c = date;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkParameterIsNotNull(exc, "it");
            C1122a.m1599b("HistoryClient.readData error " + exc.getLocalizedMessage(), new Object[0]);
            this.f3201a.m3743a((Function3<? super Boolean, ? super Date, ? super Integer, Unit>) this.f3202b, this.f3203c, -1);
        }
    }

    public RFLGoogleFitManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f3194c = context;
        FitnessOptions build = FitnessOptions.builder().addDataType(DataType.TYPE_STEP_COUNT_DELTA).addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "FitnessOptions.builder()…LTA)\n            .build()");
        this.f3192a = build;
        C1122a.m1596a("init call", new Object[0]);
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m3739a(DataReadResponse dataReadResponse) {
        List<Bucket> buckets = dataReadResponse.getBuckets();
        Intrinsics.checkExpressionValueIsNotNull(buckets, "dataReadResponse.buckets");
        if (!buckets.isEmpty()) {
            List<Bucket> buckets2 = dataReadResponse.getBuckets();
            Intrinsics.checkExpressionValueIsNotNull(buckets2, "dataReadResponse.buckets");
            return m3740a((List<? extends Bucket>) buckets2);
        }
        List<DataSet> dataSets = dataReadResponse.getDataSets();
        Intrinsics.checkExpressionValueIsNotNull(dataSets, "dataReadResponse.dataSets");
        return m3744b(dataSets);
    }

    /* renamed from: a */
    private final int m3740a(List<? extends Bucket> list) {
        int i = -1;
        for (Bucket dataSets : list) {
            List<DataSet> dataSets2 = dataSets.getDataSets();
            Intrinsics.checkExpressionValueIsNotNull(dataSets2, "bucket.dataSets");
            int b = m3744b(dataSets2);
            if (b >= 0) {
                i = i < 0 ? b : i + b;
            }
        }
        return i;
    }

    /* renamed from: a */
    private final DataReadRequest m3741a(Date date, Date date2) {
        DataReadRequest build = new DataReadRequest.Builder().aggregate(new DataSource.Builder().setDataType(DataType.TYPE_STEP_COUNT_DELTA).setType(1).setStreamName("estimated_steps").setAppPackageName("com.google.android.gms").build(), DataType.AGGREGATE_STEP_COUNT_DELTA).bucketByTime(1, TimeUnit.DAYS).setTimeRange(RFLDailyUtilsKt.millisecond(date), RFLDailyUtilsKt.millisecond(date2), TimeUnit.MILLISECONDS).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "DataReadRequest.Builder(…\n                .build()");
        return build;
    }

    /* renamed from: a */
    private final List<StepCount> m3742a(HistoryClient historyClient, Date date, Date date2) {
        DataReadResponse dataReadResponse = (DataReadResponse) Tasks.await(historyClient.readData(m3745b(date, date2)));
        Intrinsics.checkExpressionValueIsNotNull(dataReadResponse, "dataReadResponse");
        return m3746b(dataReadResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m3743a(Function3<? super Boolean, ? super Date, ? super Integer, Unit> function3, Date date, int i) {
        if (i < 0) {
            function3.invoke(false, date, -1);
        } else {
            function3.invoke(true, date, Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    private final int m3744b(List<DataSet> list) {
        int i = 0;
        if (list.isEmpty()) {
            C1122a.m1596a("no data.", new Object[0]);
            return -1;
        }
        for (DataSet dataPoints : list) {
            for (DataPoint next : dataPoints.getDataPoints()) {
                Intrinsics.checkExpressionValueIsNotNull(next, "dataPoint");
                DataType dataType = next.getDataType();
                Intrinsics.checkExpressionValueIsNotNull(dataType, "dataPoint.dataType");
                for (Field next2 : dataType.getFields()) {
                    if (Intrinsics.areEqual((Object) next2, (Object) Field.FIELD_STEPS)) {
                        i += next.getValue(next2).asInt();
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    private final DataReadRequest m3745b(Date date, Date date2) {
        DataReadRequest build = new DataReadRequest.Builder().aggregate(new DataSource.Builder().setDataType(DataType.TYPE_STEP_COUNT_DELTA).setType(1).setStreamName("estimated_steps").setAppPackageName("com.google.android.gms").build(), DataType.AGGREGATE_STEP_COUNT_DELTA).bucketByTime(1, TimeUnit.MINUTES).setTimeRange(RFLDailyUtilsKt.millisecond(date), RFLDailyUtilsKt.millisecond(date2), TimeUnit.MILLISECONDS).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "DataReadRequest.Builder(…\n                .build()");
        return build;
    }

    /* renamed from: b */
    private final List<StepCount> m3746b(DataReadResponse dataReadResponse) {
        if (dataReadResponse.getBuckets().isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Bucket next : dataReadResponse.getBuckets()) {
            Date date = new Date(next.getStartTime(TimeUnit.MILLISECONDS));
            Date date2 = new Date(next.getEndTime(TimeUnit.MILLISECONDS));
            Intrinsics.checkExpressionValueIsNotNull(next, "bucket");
            List<DataSet> dataSets = next.getDataSets();
            Intrinsics.checkExpressionValueIsNotNull(dataSets, "bucket.dataSets");
            arrayList.add(new StepCount(date, date2, m3744b(dataSets)));
        }
        return arrayList;
    }

    public final void connect() {
        GoogleSignInAccount lastSignedInAccount;
        if (this.f3193b == null && (lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(this.f3194c)) != null) {
            Intrinsics.checkExpressionValueIsNotNull(lastSignedInAccount, "GoogleSignIn.getLastSign…(clientContext) ?: return");
            if (GoogleSignIn.hasPermissions(lastSignedInAccount, (GoogleSignInOptionsExtension) this.f3192a)) {
                this.f3193b = Fitness.getHistoryClient(this.f3194c, lastSignedInAccount);
            }
        }
    }

    public final void disconnect() {
        this.f3193b = null;
    }

    public final void getDailyStepCount(Date date, Function3<? super Boolean, ? super Date, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(function3, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        HistoryClient historyClient = this.f3193b;
        if (historyClient != null) {
            historyClient.readData(m3741a(RFLDailyUtilsKt.start(date), RFLDailyUtilsKt.end(date))).addOnSuccessListener(new C2191a(this, function3, date)).addOnFailureListener(new C2192b(this, function3, date));
            return;
        }
        C1122a.m1601d("getDailyStepCount() called. but Google Fit API has not permission.", new Object[0]);
        m3743a(function3, date, -1);
    }

    public final Map<Long, Integer> getMinuteRangeStepCount(Date date, Date date2) {
        Intrinsics.checkParameterIsNotNull(date, "startTime");
        Intrinsics.checkParameterIsNotNull(date2, "endTime");
        HashMap hashMap = new HashMap();
        HistoryClient historyClient = this.f3193b;
        if (historyClient != null) {
            for (StepCount next : m3742a(historyClient, date, date2)) {
                StringBuilder a = C0681a.m330a("getMinuteRangeStepCount ");
                a.append(next.getSteps());
                a.append(" from:");
                a.append(next.getStartTime());
                a.append(" to:");
                a.append(next.getEndTime());
                C1122a.m1596a(a.toString(), new Object[0]);
                Calendar instance = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "start");
                instance.setTime(next.getStartTime());
                instance.set(13, 0);
                instance.set(14, 0);
                hashMap.put(Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(next.getSteps()));
            }
            return hashMap;
        }
        C1122a.m1601d("getDailyStepCount() called. but Google Fit API has not permission.", new Object[0]);
        return hashMap;
    }

    public final void getTodayStepCount(Function3<? super Boolean, ? super Date, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Date date = new Date();
        if (!isConnected()) {
            C1122a.m1601d("getTodayStepCount() called. but Google Fit API has not permission.", new Object[0]);
            m3743a(function3, date, -1);
            return;
        }
        getDailyStepCount(date, function3);
    }

    public final boolean isConnected() {
        return this.f3193b != null;
    }
}
