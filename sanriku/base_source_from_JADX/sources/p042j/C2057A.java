package p042j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\bJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo21739d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", "other", "block", "Lkotlin/Function0;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.A */
public class C2057A {
    @JvmField

    /* renamed from: d */
    public static final C2057A f2872d = new C2058a();

    /* renamed from: a */
    private boolean f2873a;

    /* renamed from: b */
    private long f2874b;

    /* renamed from: c */
    private long f2875c;

    /* renamed from: j.A$a */
    public static final class C2058a extends C2057A {
        C2058a() {
        }

        /* renamed from: a */
        public C2057A mo29119a(long j) {
            return this;
        }

        /* renamed from: a */
        public C2057A mo29120a(long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            return this;
        }

        /* renamed from: e */
        public void mo29124e() {
        }
    }

    /* renamed from: a */
    public C2057A mo29118a() {
        this.f2873a = false;
        return this;
    }

    /* renamed from: a */
    public C2057A mo29119a(long j) {
        this.f2873a = true;
        this.f2874b = j;
        return this;
    }

    /* renamed from: a */
    public C2057A mo29120a(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        if (j >= 0) {
            this.f2875c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(C0681a.m318a("timeout < 0: ", j).toString());
    }

    /* renamed from: b */
    public C2057A mo29121b() {
        this.f2875c = 0;
        return this;
    }

    /* renamed from: c */
    public long mo29122c() {
        if (this.f2873a) {
            return this.f2874b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    /* renamed from: d */
    public boolean mo29123d() {
        return this.f2873a;
    }

    /* renamed from: e */
    public void mo29124e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f2873a && this.f2874b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* renamed from: f */
    public long mo29125f() {
        return this.f2875c;
    }
}
