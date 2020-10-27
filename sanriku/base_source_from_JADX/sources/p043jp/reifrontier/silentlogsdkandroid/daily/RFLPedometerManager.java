package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.bus.ActiveMode;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\tJ\b\u0010-\u001a\u00020$H\u0002J\u0006\u0010.\u001a\u00020$J\u0006\u0010/\u001a\u00020$J\u0018\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u001a\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0006\u00107\u001a\u00020$J\u0006\u00108\u001a\u00020$J\b\u00109\u001a\u00020$H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;", "Landroid/hardware/SensorEventListener;", "()V", "accelerationMeters", "Ljava/util/ArrayList;", "", "activeModeStartTime", "", "calcStep", "", "calcStepZeroStartTime", "currentStep", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus", "(Lorg/greenrobot/eventbus/EventBus;)V", "isActiveMode", "", "reachCount", "sensorAccelerometer", "Landroid/hardware/Sensor;", "sensorGyro", "sensorManager", "Landroid/hardware/SensorManager;", "stepFlag", "stepTimestamp", "thresholdReachTime", "activeSwitch", "", "activeSwitch2", "build", "context", "Landroid/content/Context;", "checkPedometer", "event", "Landroid/hardware/SensorEvent;", "currentSteps", "didUpdatePedometer", "forceStopActiveMode", "forceStopActiveModeIfNeed", "lowPass", "input", "output", "onAccuracyChanged", "sensor", "accuracy", "onSensorChanged", "release", "resetCurrentSteps", "stepZeroIfNeed", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager */
public final class RFLPedometerManager implements SensorEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private SensorManager f3212a;

    /* renamed from: b */
    private Sensor f3213b;

    /* renamed from: c */
    private final ArrayList<float[]> f3214c = new ArrayList<>();

    /* renamed from: d */
    private boolean f3215d;
    public RFLDataLogger dataLogger;

    /* renamed from: e */
    private long f3216e;
    public C1126c eventBus;

    /* renamed from: f */
    private long f3217f;

    /* renamed from: g */
    private long f3218g;

    /* renamed from: h */
    private int f3219h;

    /* renamed from: i */
    private int f3220i;

    /* renamed from: j */
    private boolean f3221j;

    /* renamed from: k */
    private long f3222k;

    /* renamed from: l */
    private int f3223l;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager$Companion;", "", "()V", "ALPHA", "", "MAX_LAG", "", "MIN_LAG1", "MIN_LAG2", "RESET_STEP_DELAY_TIME", "SI2G", "STEP_DOWN_THRESHOLD", "STEP_RANGE_THRESHOLD_TIME", "STEP_UP_THRESHOLD", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFLPedometerManager() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final void m3750a() {
        C1126c cVar;
        ActiveMode activeMode;
        this.f3219h++;
        m3754c();
        int i = this.f3220i + 1;
        this.f3220i = i;
        C1122a.m1596a("activeSwitch2 calcStep:%s", Integer.valueOf(i));
        if (this.f3222k == 0) {
            this.f3222k = System.currentTimeMillis();
        }
        if (this.f3220i > 29) {
            long currentTimeMillis = System.currentTimeMillis() - (this.f3222k + 30000);
            if (currentTimeMillis > 0) {
                this.f3222k = 0;
                this.f3223l = 0;
                this.f3220i = 0;
                if (currentTimeMillis < 20000) {
                    if (!this.f3221j) {
                        this.f3217f = System.currentTimeMillis();
                        C1122a.m1600c("[SilentLogSDK] Info::Active Mode On", new Object[0]);
                        cVar = this.eventBus;
                        if (cVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
                        }
                        activeMode = new ActiveMode(true);
                        cVar.mo21903a((Object) activeMode);
                        this.f3221j = true;
                    }
                }
            } else {
                int i2 = this.f3223l + 1;
                this.f3223l = i2;
                this.f3220i = 0;
                C1122a.m1596a("Active Reach :%s", Integer.valueOf(i2));
                this.f3222k = 0;
                if (this.f3223l > 2) {
                    if (this.f3221j) {
                        this.f3223l = 0;
                    } else {
                        this.f3217f = System.currentTimeMillis();
                        C1122a.m1600c("[SilentLogSDK] Info::Active Mode On", new Object[0]);
                        cVar = this.eventBus;
                        if (cVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
                        }
                        activeMode = new ActiveMode(true);
                        cVar.mo21903a((Object) activeMode);
                        this.f3221j = true;
                    }
                }
            }
            this.f3217f = System.currentTimeMillis();
        }
        this.f3218g = System.currentTimeMillis();
    }

    /* renamed from: a */
    private final void m3751a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.f3214c.isEmpty()) {
            float[] fArr2 = sensorEvent.values;
            Intrinsics.checkExpressionValueIsNotNull(fArr2, "event.values");
            fArr = Arrays.copyOf(fArr2, fArr2.length);
            Intrinsics.checkExpressionValueIsNotNull(fArr, "java.util.Arrays.copyOf(this, size)");
        } else {
            float[] fArr3 = sensorEvent.values;
            Intrinsics.checkExpressionValueIsNotNull(fArr3, "event.values");
            float[] copyOf = Arrays.copyOf(fArr3, fArr3.length);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
            float[] fArr4 = (float[]) CollectionsKt___CollectionsKt.last(this.f3214c);
            float[] copyOf2 = Arrays.copyOf(fArr4, fArr4.length);
            Intrinsics.checkExpressionValueIsNotNull(copyOf2, "java.util.Arrays.copyOf(this, size)");
            fArr = m3752a(copyOf, copyOf2);
        }
        this.f3214c.add(fArr);
        int size = this.f3214c.size();
        if (size >= 3) {
            float[] fArr5 = this.f3214c.get(size - 1);
            Intrinsics.checkExpressionValueIsNotNull(fArr5, "accelerationMeters[size - 1]");
            float[] fArr6 = fArr5;
            float[] fArr7 = this.f3214c.get(size - 2);
            Intrinsics.checkExpressionValueIsNotNull(fArr7, "accelerationMeters[size - 2]");
            float[] fArr8 = fArr7;
            float[] fArr9 = this.f3214c.get(size - 3);
            Intrinsics.checkExpressionValueIsNotNull(fArr9, "accelerationMeters[size - 3]");
            float[] fArr10 = fArr9;
            float f = fArr6[1] * fArr6[1];
            float f2 = fArr6[2] * fArr6[2];
            float f3 = (fArr8[1] * fArr8[1]) + (fArr8[0] * fArr8[0]);
            float f4 = (fArr10[1] * fArr10[1]) + (fArr10[0] * fArr10[0]);
            float sqrt = (((((float) 2) * (((float) Math.sqrt((double) ((fArr8[2] * fArr8[2]) + f3))) * 0.1019f)) + (((float) 3) * (((float) Math.sqrt((double) (f2 + (f + (fArr6[0] * fArr6[0]))))) * 0.1019f))) + (((float) Math.sqrt((double) ((fArr10[2] * fArr10[2]) + f4))) * 0.1019f)) / ((float) 6);
            long j = sensorEvent.timestamp - this.f3216e;
            this.f3214c.remove(0);
            if (!this.f3215d) {
                if (j > 220000000 && sqrt > 1.16f) {
                    this.f3215d = true;
                    this.f3216e = sensorEvent.timestamp;
                }
            } else if (j >= 1000000000) {
                this.f3215d = false;
                this.f3216e = 0;
            } else if (j > 200000000 && sqrt < 0.96f) {
                m3753b();
                this.f3215d = false;
                this.f3216e = sensorEvent.timestamp;
            }
        }
    }

    /* renamed from: a */
    private final float[] m3752a(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = C0681a.m301a(fArr[i], fArr2[i], 0.9f, fArr2[i]);
        }
        return fArr2;
    }

    /* renamed from: b */
    private final void m3753b() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        rFLDataLogger.insertPedometer(new Date()).mo27431a();
        m3750a();
    }

    /* renamed from: c */
    private final void m3754c() {
        if (this.f3218g != 0 && System.currentTimeMillis() - this.f3218g >= 20000) {
            this.f3220i = 0;
            this.f3223l = 0;
            this.f3222k = 0;
            forceStopActiveModeIfNeed();
        }
    }

    public final void build(Context context) {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        SensorManager sensorManager3 = (SensorManager) context.getSystemService("sensor");
        this.f3212a = sensorManager3;
        List<Sensor> list = null;
        List<Sensor> sensorList = sensorManager3 != null ? sensorManager3.getSensorList(1) : null;
        if (sensorList == null || sensorList.size() != 0) {
            SensorManager sensorManager4 = this.f3212a;
            this.f3213b = sensorManager4 != null ? sensorManager4.getDefaultSensor(1) : null;
        }
        SensorManager sensorManager5 = this.f3212a;
        if (sensorManager5 != null) {
            list = sensorManager5.getSensorList(4);
        }
        if ((list == null || list.size() != 0) && (sensorManager2 = this.f3212a) != null) {
            sensorManager2.getDefaultSensor(4);
        }
        Sensor sensor = this.f3213b;
        if (sensor != null && (sensorManager = this.f3212a) != null) {
            sensorManager.registerListener(this, sensor, 2);
        }
    }

    public final int currentSteps() {
        return this.f3219h;
    }

    public final void forceStopActiveMode() {
    }

    public final void forceStopActiveModeIfNeed() {
        if (this.f3221j) {
            long currentTimeMillis = System.currentTimeMillis() - this.f3217f;
            int i = (currentTimeMillis > ((long) 180000) ? 1 : (currentTimeMillis == ((long) 180000) ? 0 : -1));
            StringBuilder sb = new StringBuilder();
            if (i <= 0) {
                sb.append("---- forceStopActiveModeIfNeed NO ---- ");
                sb.append(currentTimeMillis / ((long) 1000));
                C1122a.m1596a(sb.toString(), new Object[0]);
                return;
            }
            sb.append("[SilentLogSDK] Info::Active Mode Off with Interval ");
            sb.append(currentTimeMillis / ((long) 1000));
            C1122a.m1600c(sb.toString(), new Object[0]);
            this.f3220i = 0;
            this.f3223l = 0;
            this.f3222k = 0;
            this.f3221j = false;
            C1126c cVar = this.eventBus;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventBus");
            }
            cVar.mo21903a((Object) new ActiveMode(false));
        }
    }

    public final RFLDataLogger getDataLogger() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final C1126c getEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkParameterIsNotNull(sensorEvent, "event");
        Sensor sensor = sensorEvent.sensor;
        Intrinsics.checkExpressionValueIsNotNull(sensor, "event.sensor");
        if (sensor.getType() == 1) {
            m3751a(sensorEvent);
        }
    }

    public final void release() {
        SensorManager sensorManager = this.f3212a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f3215d = false;
        this.f3216e = 0;
        this.f3217f = 0;
        this.f3218g = 0;
        this.f3219h = 0;
        this.f3220i = 0;
        this.f3221j = false;
        this.f3222k = 0;
        this.f3223l = 0;
    }

    public final void resetCurrentSteps() {
        this.f3219h = 0;
        this.f3220i = 0;
        this.f3223l = 0;
    }

    public final void setDataLogger(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    public final void setEventBus(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }
}
