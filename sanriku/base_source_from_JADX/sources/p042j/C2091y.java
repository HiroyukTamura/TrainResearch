package p042j;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.y */
final class C2091y extends C2062b {

    /* renamed from: l */
    private final Logger f2936l = Logger.getLogger("okio.Okio");

    /* renamed from: m */
    private final Socket f2937m;

    public C2091y(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        this.f2937m = socket;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo27919a(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27739i() {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close timed out socket "
            java.net.Socket r1 = r5.f2937m     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
            r1.close()     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
            goto L_0x0033
        L_0x0008:
            r1 = move-exception
            boolean r2 = p042j.C2080p.m3584a((java.lang.AssertionError) r1)
            if (r2 == 0) goto L_0x0019
            java.util.logging.Logger r2 = r5.f2936l
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x0024
        L_0x0019:
            throw r1
        L_0x001a:
            r1 = move-exception
            java.util.logging.Logger r2 = r5.f2936l
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x0024:
            r4.append(r0)
            java.net.Socket r0 = r5.f2937m
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.log(r3, r0, r1)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2091y.mo27739i():void");
    }
}
