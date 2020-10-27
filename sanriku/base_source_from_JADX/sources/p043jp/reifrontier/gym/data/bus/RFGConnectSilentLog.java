package p043jp.reifrontier.gym.data.bus;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/data/bus/RFGConnectSilentLog;", "", "connect", "", "userId", "", "(ZLjava/lang/String;)V", "getConnect", "()Z", "getUserId", "()Ljava/lang/String;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.bus.RFGConnectSilentLog */
public final class RFGConnectSilentLog {
    private final boolean connect;
    private final String userId;

    public RFGConnectSilentLog(boolean z, String str) {
        this.connect = z;
        this.userId = str;
    }

    public final boolean getConnect() {
        return this.connect;
    }

    public final String getUserId() {
        return this.userId;
    }
}
