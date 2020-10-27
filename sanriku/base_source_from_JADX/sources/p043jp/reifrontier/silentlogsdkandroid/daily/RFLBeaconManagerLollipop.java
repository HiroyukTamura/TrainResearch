package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.content.Context;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;
import p048l.p049a.C1122a;

@RequiresApi(21)
@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001aH\u0017J\b\u0010\u001e\u001a\u00020\u0011H\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManagerLollipop;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothLeScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "getContext", "()Landroid/content/Context;", "onEnterAdTrigger", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "triggerId", "", "getOnEnterAdTrigger", "()Lkotlin/jvm/functions/Function1;", "setOnEnterAdTrigger", "(Lkotlin/jvm/functions/Function1;)V", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "scanTarget", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "createScanCallback", "startMonitoring", "adTrigger", "stopAllMonitoring", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop */
public final class RFLBeaconManagerLollipop implements RFLBeaconManager {

    /* renamed from: a */
    private Function1<? super Integer, Unit> f3061a;

    /* renamed from: b */
    private final BluetoothAdapter f3062b;

    /* renamed from: c */
    private final BluetoothLeScanner f3063c;

    /* renamed from: d */
    private ScanCallback f3064d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<RFLAdTrigger> f3065e = new ArrayList();

    /* renamed from: f */
    private final Context f3066f;

    public RFLBeaconManagerLollipop(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f3066f = context;
        if (!hasBluetoothPermission(this.f3066f)) {
            C1122a.m1600c("[SilentLogSDK] Info::denied bluetooth permission", new Object[0]);
            this.f3062b = null;
            this.f3063c = null;
            return;
        }
        Object systemService = this.f3066f.getSystemService("bluetooth");
        if (systemService != null) {
            BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
            this.f3062b = adapter;
            Intrinsics.checkExpressionValueIsNotNull(adapter, "bluetoothAdapter");
            BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
            this.f3063c = bluetoothLeScanner;
            if (bluetoothLeScanner == null) {
                C1122a.m1600c("[SilentLogSDK] Info::BluetoothLeScanner is null", new Object[0]);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    /* renamed from: a */
    private final ScanCallback m3678a() {
        return new RFLBeaconManagerLollipop$createScanCallback$1(this);
    }

    public final Context getContext() {
        return this.f3066f;
    }

    public Function1<Integer, Unit> getOnEnterAdTrigger() {
        return this.f3061a;
    }

    public boolean hasBluetoothPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return RFLBeaconManager.DefaultImpls.hasBluetoothPermission(this, context);
    }

    public String parseIBeaconUUID(byte[] bArr) {
        return RFLBeaconManager.DefaultImpls.parseIBeaconUUID(this, bArr);
    }

    public void setOnEnterAdTrigger(Function1<? super Integer, Unit> function1) {
        this.f3061a = function1;
    }

    @SuppressLint({"MissingPermission"})
    public void startMonitoring(RFLAdTrigger rFLAdTrigger) {
        T t;
        boolean z;
        Intrinsics.checkParameterIsNotNull(rFLAdTrigger, "adTrigger");
        if (this.f3063c != null) {
            StringBuilder a = C0681a.m330a("Start monitoring in background ");
            a.append(rFLAdTrigger.getTriggerId());
            a.append(' ');
            a.append(rFLAdTrigger.getTriggerUuid());
            C1122a.m1596a(a.toString(), new Object[0]);
            Iterator<T> it = this.f3065e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((RFLAdTrigger) t).getTriggerId() == rFLAdTrigger.getTriggerId()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (((RFLAdTrigger) t) == null) {
                this.f3065e.add(rFLAdTrigger);
            }
            if (this.f3064d == null) {
                ScanCallback a2 = m3678a();
                this.f3064d = a2;
                this.f3063c.startScan(a2);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void stopAllMonitoring() {
        if (this.f3063c != null) {
            C1122a.m1596a("Stop monitoring in background", new Object[0]);
            this.f3065e.clear();
            ScanCallback scanCallback = this.f3064d;
            if (scanCallback != null) {
                this.f3063c.stopScan(scanCallback);
            }
            this.f3064d = null;
        }
    }
}
