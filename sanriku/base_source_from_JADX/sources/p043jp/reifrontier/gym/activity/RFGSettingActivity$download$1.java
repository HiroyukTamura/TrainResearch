package p043jp.reifrontier.gym.activity;

import java.util.Date;
import kotlin.Metadata;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "dailyResult", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$download$1 */
final class RFGSettingActivity$download$1<T> implements C1741d<String> {
    final /* synthetic */ Date $date;
    final /* synthetic */ RFGSettingActivity this$0;

    RFGSettingActivity$download$1(RFGSettingActivity rFGSettingActivity, Date date) {
        this.this$0 = rFGSettingActivity;
        this.$date = date;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0081, code lost:
        if (r6 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
        if (r6 == null) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.String r6) {
        /*
            r5 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            jp.reifrontier.gym.activity.RFGSettingActivity$download$1$turnsType$1 r1 = new jp.reifrontier.gym.activity.RFGSettingActivity$download$1$turnsType$1
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r6 = r0.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r1)
            jp.reifrontier.gym.domain.silentlog.RFGDaily r6 = (p043jp.reifrontier.gym.domain.silentlog.RFGDaily) r6
            io.realm.RealmList r0 = new io.realm.RealmList
            r0.<init>()
            r1 = 0
            if (r6 == 0) goto L_0x0084
            java.util.List r2 = r6.getSegments()
            java.util.Iterator r2 = r2.iterator()
        L_0x0024:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r2.next()
            jp.reifrontier.gym.domain.silentlog.RFGSegment r3 = (p043jp.reifrontier.gym.domain.silentlog.RFGSegment) r3
            java.util.List r3 = r3.getActivities()
            java.util.Iterator r3 = r3.iterator()
        L_0x0038:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0024
            java.lang.Object r4 = r3.next()
            jp.reifrontier.gym.domain.silentlog.RFGActivity r4 = (p043jp.reifrontier.gym.domain.silentlog.RFGActivity) r4
            r0.add(r4)
            goto L_0x0038
        L_0x0048:
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x00c5
            jp.reifrontier.gym.domain.silentlog.RFGDay r2 = new jp.reifrontier.gym.domain.silentlog.RFGDay
            r2.<init>()
            java.lang.String r6 = r6.getDate()
            r2.setDate(r6)
            r2.setActivites(r0)
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x0068
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0068:
            r6.beginTransaction()
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0076:
            io.realm.ImportFlag[] r0 = new p041io.realm.ImportFlag[r1]
            r6.copyToRealmOrUpdate(r2, (p041io.realm.ImportFlag[]) r0)
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x00c2
            goto L_0x00bf
        L_0x0084:
            java.util.Date r6 = r5.$date
            r2 = 2
            r3 = 0
            java.lang.String r4 = "yyyyMMdd'T'HHmmssZ"
            java.lang.String r6 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r6, r4, r3, r2, r3)
            jp.reifrontier.gym.domain.silentlog.RFGDay r2 = new jp.reifrontier.gym.domain.silentlog.RFGDay
            r2.<init>()
            r2.setDate(r6)
            r2.setActivites(r0)
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x00a4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a4:
            r6.beginTransaction()
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x00b2
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b2:
            io.realm.ImportFlag[] r0 = new p041io.realm.ImportFlag[r1]
            r6.copyToRealmOrUpdate(r2, (p041io.realm.ImportFlag[]) r0)
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            io.realm.Realm r6 = r6.mRealm
            if (r6 != 0) goto L_0x00c2
        L_0x00bf:
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00c2:
            r6.commitTransaction()
        L_0x00c5:
            jp.reifrontier.gym.activity.RFGSettingActivity r6 = r5.this$0
            r6.download()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGSettingActivity$download$1.accept(java.lang.String):void");
    }
}
