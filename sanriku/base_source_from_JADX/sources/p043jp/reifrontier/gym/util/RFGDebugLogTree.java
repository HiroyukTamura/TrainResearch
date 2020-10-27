package p043jp.reifrontier.gym.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/util/RFGDebugLogTree;", "Ltimber/log/Timber$DebugTree;", "()V", "log", "", "priority", "", "tag", "", "message", "throwable", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.RFGDebugLogTree */
public final class RFGDebugLogTree extends C1122a.C1124b {
    /* access modifiers changed from: protected */
    public void log(int i, String str, String str2, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str2, "message");
    }
}
