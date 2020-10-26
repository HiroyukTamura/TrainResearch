/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.e;

import java.util.Arrays;
import jp.a.a;
import jp.co.jreast.jreastapp.commuter.e.b;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/device/AudioWaveBeaconService;", "", "ssTouchManager", "Ljp/sstouch/SSTouchManager;", "(Ljp/sstouch/SSTouchManager;)V", "isChecking", "", "setListener", "", "listener", "Ljp/co/jreast/jreastapp/commuter/device/CommuterSSTouchManagerListener;", "startCheckBeacon", "stopCheckBeacon", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    public static final a a = new a(null);
    private final jp.a.a b;

    public a(jp.a.a a2) {
        j.b(a2, "ssTouchManager");
        this.b = a2;
    }

    public final void a() {
        this.b.a(a.a.b);
    }

    public final void a(b b2) {
        j.b(b2, "listener");
        this.b.a(b2);
    }

    public final void b() {
        this.b.b();
    }

    public final boolean c() {
        return this.b.a() == a.h.c;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/device/AudioWaveBeaconService$Companion;", "", "()V", "getTerminalIdFromServiceId", "", "serviceId", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final String a(int n2) {
            Object object = y.a;
            object = new Object[]{"D", (byte)(n2 >> 20), n2 & 1048575};
            object = String.format("%s%01X%06d", Arrays.copyOf(object, ((Object[])object).length));
            j.a(object, "java.lang.String.format(format, *args)");
            return object;
        }
    }

}

