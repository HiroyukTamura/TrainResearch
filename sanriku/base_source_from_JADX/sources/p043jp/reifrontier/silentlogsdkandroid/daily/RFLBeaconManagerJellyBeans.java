package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
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

@RequiresApi(18)
@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManagerJellyBeans;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getContext", "()Landroid/content/Context;", "onEnterAdTrigger", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "triggerId", "", "getOnEnterAdTrigger", "()Lkotlin/jvm/functions/Function1;", "setOnEnterAdTrigger", "(Lkotlin/jvm/functions/Function1;)V", "scanCallback", "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "scanTarget", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "createScanCallback", "startMonitoring", "adTrigger", "stopAllMonitoring", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerJellyBeans */
public final class RFLBeaconManagerJellyBeans implements RFLBeaconManager {

    /* renamed from: a */
    private Function1<? super Integer, Unit> f3055a;

    /* renamed from: b */
    private final BluetoothAdapter f3056b;

    /* renamed from: c */
    private BluetoothAdapter.LeScanCallback f3057c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<RFLAdTrigger> f3058d = new ArrayList();

    /* renamed from: e */
    private final Context f3059e;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerJellyBeans$a */
    static final class C2139a implements BluetoothAdapter.LeScanCallback {

        /* renamed from: a */
        final /* synthetic */ RFLBeaconManagerJellyBeans f3060a;

        C2139a(RFLBeaconManagerJellyBeans rFLBeaconManagerJellyBeans) {
            this.f3060a = rFLBeaconManagerJellyBeans;
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            Object obj;
            String parseIBeaconUUID = this.f3060a.parseIBeaconUUID(bArr);
            Iterator it = this.f3060a.f3058d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((RFLAdTrigger) obj).getTriggerUuid(), (Object) parseIBeaconUUID)) {
                    break;
                }
            }
            RFLAdTrigger rFLAdTrigger = (RFLAdTrigger) obj;
            if (rFLAdTrigger != null) {
                C1122a.m1596a(C0681a.m320a("[SilentLog] Beacon::DEBUG find!! ", parseIBeaconUUID), new Object[0]);
                Function1<Integer, Unit> onEnterAdTrigger = this.f3060a.getOnEnterAdTrigger();
                if (onEnterAdTrigger != null) {
                    Unit invoke = onEnterAdTrigger.invoke(Integer.valueOf(rFLAdTrigger.getTriggerId()));
                }
            }
        }
    }

    public RFLBeaconManagerJellyBeans(Context context) {
        BluetoothAdapter bluetoothAdapter;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f3059e = context;
        if (!hasBluetoothPermission(this.f3059e)) {
            C1122a.m1600c("[SilentLogSDK] Info::denied bluetooth permission", new Object[0]);
            bluetoothAdapter = null;
        } else {
            Object systemService = this.f3059e.getSystemService("bluetooth");
            if (systemService != null) {
                bluetoothAdapter = ((BluetoothManager) systemService).getAdapter();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            }
        }
        this.f3056b = bluetoothAdapter;
    }

    /* renamed from: a */
    private final BluetoothAdapter.LeScanCallback m3677a() {
        return new C2139a(this);
    }

    public final Context getContext() {
        return this.f3059e;
    }

    public Function1<Integer, Unit> getOnEnterAdTrigger() {
        return this.f3055a;
    }

    public boolean hasBluetoothPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return RFLBeaconManager.DefaultImpls.hasBluetoothPermission(this, context);
    }

    public String parseIBeaconUUID(byte[] bArr) {
        return RFLBeaconManager.DefaultImpls.parseIBeaconUUID(this, bArr);
    }

    public void setOnEnterAdTrigger(Function1<? super Integer, Unit> function1) {
        this.f3055a = function1;
    }

    public void startMonitoring(RFLAdTrigger rFLAdTrigger) {
        T t;
        boolean z;
        Intrinsics.checkParameterIsNotNull(rFLAdTrigger, "adTrigger");
        if (this.f3056b != null) {
            StringBuilder a = C0681a.m330a("Start monitoring in background ");
            a.append(rFLAdTrigger.getTriggerId());
            a.append(' ');
            a.append(rFLAdTrigger.getTriggerUuid());
            C1122a.m1596a(a.toString(), new Object[0]);
            Iterator<T> it = this.f3058d.iterator();
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
                this.f3058d.add(rFLAdTrigger);
            }
            if (this.f3057c == null) {
                BluetoothAdapter.LeScanCallback a2 = m3677a();
                this.f3057c = a2;
                this.f3056b.startLeScan(a2);
            }
        }
    }

    public void stopAllMonitoring() {
        if (this.f3056b != null) {
            C1122a.m1596a("Stop monitoring in background", new Object[0]);
            this.f3058d.clear();
            BluetoothAdapter.LeScanCallback leScanCallback = this.f3057c;
            if (leScanCallback != null) {
                this.f3056b.stopLeScan(leScanCallback);
            }
            this.f3057c = null;
        }
    }
}
