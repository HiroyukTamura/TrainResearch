package kotlinx.coroutines.p130u0;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.C2564s;

/* renamed from: kotlinx.coroutines.u0.k */
public final class C2603k {
    @JvmField

    /* renamed from: a */
    public static final long f4268a = C2564s.m4467a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    @JvmField

    /* renamed from: b */
    public static final int f4269b = C2564s.m4465a("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.coerceAtLeast(C2564s.m4464a(), 2), 1, 0, 8, (Object) null);
    @JvmField

    /* renamed from: c */
    public static final int f4270c = C2564s.m4465a("kotlinx.coroutines.scheduler.max.pool.size", RangesKt___RangesKt.coerceIn(C2564s.m4464a() * 128, f4269b, 2097150), 0, 2097150, 4, (Object) null);
    @JvmField

    /* renamed from: d */
    public static final long f4271d = TimeUnit.SECONDS.toNanos(C2564s.m4467a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    @JvmField

    /* renamed from: e */
    public static C2604l f4272e = C2598f.f4263a;

    static {
        C2564s.m4465a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    }
}
