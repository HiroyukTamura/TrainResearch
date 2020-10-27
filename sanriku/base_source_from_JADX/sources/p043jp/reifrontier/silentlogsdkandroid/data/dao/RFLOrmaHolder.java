package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p015c.p016a.p017a.p018a.C0693a;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.OrmaDatabase;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ORMA", "Ljp/reifrontier/silentlogsdkandroid/domain/db/OrmaDatabase;", "ORMA$annotations", "()V", "getORMA", "()Ljp/reifrontier/silentlogsdkandroid/domain/db/OrmaDatabase;", "deleteAll", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder */
public class RFLOrmaHolder {

    /* renamed from: a */
    private final OrmaDatabase f3336a;

    public RFLOrmaHolder(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        OrmaDatabase build = ((OrmaDatabase.Builder) ((OrmaDatabase.Builder) ((OrmaDatabase.Builder) OrmaDatabase.builder(context).writeOnMainThread(C0693a.FATAL)).readOnMainThread(C0693a.FATAL)).trace(false)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OrmaDatabase.builder(cli…lse)\n            .build()");
        this.f3336a = build;
    }

    public static /* synthetic */ void ORMA$annotations() {
    }

    public final void deleteAll() {
        getORMA().deleteAll();
    }

    public OrmaDatabase getORMA() {
        return this.f3336a;
    }
}
