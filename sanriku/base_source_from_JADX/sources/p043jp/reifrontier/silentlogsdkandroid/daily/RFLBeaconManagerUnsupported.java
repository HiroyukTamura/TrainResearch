package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManagerUnsupported;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "()V", "onEnterAdTrigger", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "triggerId", "", "getOnEnterAdTrigger", "()Lkotlin/jvm/functions/Function1;", "setOnEnterAdTrigger", "(Lkotlin/jvm/functions/Function1;)V", "startMonitoring", "adTrigger", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "stopAllMonitoring", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerUnsupported */
public final class RFLBeaconManagerUnsupported implements RFLBeaconManager {

    /* renamed from: a */
    private Function1<? super Integer, Unit> f3068a;

    public Function1<Integer, Unit> getOnEnterAdTrigger() {
        return this.f3068a;
    }

    public boolean hasBluetoothPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return RFLBeaconManager.DefaultImpls.hasBluetoothPermission(this, context);
    }

    public String parseIBeaconUUID(byte[] bArr) {
        return RFLBeaconManager.DefaultImpls.parseIBeaconUUID(this, bArr);
    }

    public void setOnEnterAdTrigger(Function1<? super Integer, Unit> function1) {
        this.f3068a = function1;
    }

    public void startMonitoring(RFLAdTrigger rFLAdTrigger) {
        Intrinsics.checkParameterIsNotNull(rFLAdTrigger, "adTrigger");
        C1122a.m1596a("[SilentLogSDK]::Debug Beacon Unsupported", new Object[0]);
    }

    public void stopAllMonitoring() {
        C1122a.m1596a("[SilentLogSDK]::Debug Beacon Unsupported", new Object[0]);
    }
}
