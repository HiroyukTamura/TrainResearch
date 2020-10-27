package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.List;
import kotlin.Metadata;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, mo21739d2 = {"jp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManagerLollipop$createScanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop$createScanCallback$1 */
public final class RFLBeaconManagerLollipop$createScanCallback$1 extends ScanCallback {

    /* renamed from: a */
    final /* synthetic */ RFLBeaconManagerLollipop f3067a;

    RFLBeaconManagerLollipop$createScanCallback$1(RFLBeaconManagerLollipop rFLBeaconManagerLollipop) {
        this.f3067a = rFLBeaconManagerLollipop;
    }

    public void onBatchScanResults(List<ScanResult> list) {
    }

    public void onScanFailed(int i) {
        C1122a.m1599b("[SilentLog] Beacon::ERROR onScanFailed(errorCode: " + i + ')', new Object[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r5 = r5.getScanRecord();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScanResult(int r4, android.bluetooth.le.ScanResult r5) {
        /*
            r3 = this;
            jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop r4 = r3.f3067a
            r0 = 0
            if (r5 == 0) goto L_0x0010
            android.bluetooth.le.ScanRecord r5 = r5.getScanRecord()
            if (r5 == 0) goto L_0x0010
            byte[] r5 = r5.getBytes()
            goto L_0x0011
        L_0x0010:
            r5 = r0
        L_0x0011:
            java.lang.String r4 = r4.parseIBeaconUUID(r5)
            jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop r5 = r3.f3067a
            java.util.List r5 = r5.f3065e
            java.util.Iterator r5 = r5.iterator()
        L_0x001f:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r5.next()
            r2 = r1
            jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger r2 = (p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger) r2
            java.lang.String r2 = r2.getTriggerUuid()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x001f
            r0 = r1
        L_0x0037:
            jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger r0 = (p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger) r0
            if (r0 == 0) goto L_0x005d
            java.lang.String r5 = "[SilentLog] Beacon::DEBUG find!! "
            java.lang.String r4 = p009e.p010a.p011a.p012a.C0681a.m320a((java.lang.String) r5, (java.lang.String) r4)
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            p048l.p049a.C1122a.m1596a(r4, r5)
            jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop r4 = r3.f3067a
            kotlin.jvm.functions.Function1 r4 = r4.getOnEnterAdTrigger()
            if (r4 == 0) goto L_0x005d
            int r5 = r0.getTriggerId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r4.invoke(r5)
            kotlin.Unit r4 = (kotlin.Unit) r4
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop$createScanCallback$1.onScanResult(int, android.bluetooth.le.ScanResult):void");
    }
}
