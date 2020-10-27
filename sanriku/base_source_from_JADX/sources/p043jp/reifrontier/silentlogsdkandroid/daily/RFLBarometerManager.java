package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\r\u0010\u001c\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u00020\u0010H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;", "Landroid/hardware/SensorEventListener;", "()V", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "hasStartBarometer", "", "sensorManager", "Landroid/hardware/SensorManager;", "sensorPressure", "Landroid/hardware/Sensor;", "checkBarometer", "", "event", "Landroid/hardware/SensorEvent;", "initialize", "context", "Landroid/content/Context;", "initialize$silentlogsdkandroid_release", "onAccuracyChanged", "sensor", "accuracy", "", "onSensorChanged", "release", "release$silentlogsdkandroid_release", "startUpdate", "startUpdate$silentlogsdkandroid_release", "stopUpdate", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager */
public final class RFLBarometerManager implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f3051a;

    /* renamed from: b */
    private Sensor f3052b;

    /* renamed from: c */
    private boolean f3053c;
    public RFLDataLogger dataLogger;

    public RFLBarometerManager() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final void m3675a() {
        if (this.f3052b != null && this.f3053c) {
            this.f3053c = false;
            SensorManager sensorManager = this.f3051a;
            if (sensorManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
            }
            sensorManager.unregisterListener(this, this.f3052b);
        }
    }

    /* renamed from: a */
    private final void m3676a(SensorEvent sensorEvent) {
        RFLBarometer rFLBarometer = new RFLBarometer((double) sensorEvent.values[0], (int) Math.floor((double) (System.currentTimeMillis() / ((long) 1000))));
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        rFLDataLogger.insertBarometer(rFLBarometer).mo27431a();
    }

    public final RFLDataLogger getDataLogger$silentlogsdkandroid_release() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final void initialize$silentlogsdkandroid_release(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f3051a = sensorManager;
            this.f3053c = false;
            List<Sensor> sensorList = sensorManager.getSensorList(6);
            if (sensorList == null || sensorList.size() != 0) {
                SensorManager sensorManager2 = this.f3051a;
                if (sensorManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
                }
                this.f3052b = sensorManager2.getDefaultSensor(6);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.f3053c) {
            this.f3053c = true;
            if (sensorEvent == null) {
                Intrinsics.throwNpe();
            }
            Sensor sensor = sensorEvent.sensor;
            Intrinsics.checkExpressionValueIsNotNull(sensor, "event!!.sensor");
            if (sensor.getType() == 6) {
                m3676a(sensorEvent);
            }
            m3675a();
        }
    }

    public final void release$silentlogsdkandroid_release() {
        m3675a();
        this.f3053c = false;
    }

    public final void setDataLogger$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    public final void startUpdate$silentlogsdkandroid_release() {
        if (RFLSharedHolder.INSTANCE.isEnableAltitudePrediction() && this.f3052b != null && !this.f3053c) {
            SensorManager sensorManager = this.f3051a;
            if (sensorManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
            }
            sensorManager.registerListener(this, this.f3052b, 3);
        }
    }
}
