package p040i.p103M.p105d;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p040i.p103M.p106e.C1784a;
import p040i.p103M.p106e.C1787d;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p111j.C1873b;
import p042j.C1016z;
import p042j.C2071g;
import p042j.C2084s;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J!\u0010;\u001a\u0002092\n\u0010<\u001a\u00060=R\u00020\u00002\u0006\u0010>\u001a\u00020\u0010H\u0000¢\u0006\u0002\b?J\u0006\u0010@\u001a\u000209J \u0010A\u001a\b\u0018\u00010=R\u00020\u00002\u0006\u0010B\u001a\u00020(2\b\b\u0002\u0010C\u001a\u00020\u000bH\u0007J\u0006\u0010D\u001a\u000209J\b\u0010E\u001a\u000209H\u0016J\u0017\u0010F\u001a\b\u0018\u00010GR\u00020\u00002\u0006\u0010B\u001a\u00020(H\u0002J\u0006\u0010H\u001a\u000209J\u0006\u0010I\u001a\u00020\u0010J\b\u0010J\u001a\u00020\u0010H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u000209H\u0002J\b\u0010M\u001a\u000209H\u0002J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020(H\u0002J\r\u0010P\u001a\u000209H\u0000¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u00102\u0006\u0010B\u001a\u00020(J\u0019\u0010S\u001a\u00020\u00102\n\u0010T\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020\u0010H\u0002J\u0006\u00105\u001a\u00020\u000bJ\u0010\u0010W\u001a\f\u0012\b\u0012\u00060GR\u00020\u00000XJ\u0006\u0010Y\u001a\u000209J\u0010\u0010Z\u001a\u0002092\u0006\u0010B\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020\u00000'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R&\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006_"}, mo21739d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "removeOldestEntry", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.d.e */
public final class C1775e implements Closeable, Flushable {
    @JvmField

    /* renamed from: A */
    public static final String f2246A = f2246A;
    @JvmField

    /* renamed from: B */
    public static final String f2247B = f2247B;
    @JvmField

    /* renamed from: x */
    public static final Regex f2248x = new Regex("[a-z0-9_-]{1,120}");
    @JvmField

    /* renamed from: y */
    public static final String f2249y = f2249y;
    @JvmField

    /* renamed from: z */
    public static final String f2250z = f2250z;

    /* renamed from: a */
    private long f2251a;

    /* renamed from: b */
    private final File f2252b;

    /* renamed from: c */
    private final File f2253c;

    /* renamed from: d */
    private final File f2254d;

    /* renamed from: e */
    private long f2255e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2071g f2256f;

    /* renamed from: g */
    private final LinkedHashMap<String, C1778b> f2257g = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f2258h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f2259i;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2260l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2261m;

    /* renamed from: n */
    private boolean f2262n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f2263o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f2264p;

    /* renamed from: q */
    private long f2265q;

    /* renamed from: r */
    private final C1787d f2266r;

    /* renamed from: s */
    private final C1780d f2267s;

    /* renamed from: t */
    private final C1873b f2268t;

    /* renamed from: u */
    private final File f2269u;

    /* renamed from: v */
    private final int f2270v;

    /* renamed from: w */
    private final int f2271w;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, mo21739d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.M.d.e$a */
    public final class C1776a {

        /* renamed from: a */
        private final boolean[] f2272a;

        /* renamed from: b */
        private boolean f2273b;

        /* renamed from: c */
        private final C1778b f2274c;

        /* renamed from: d */
        final /* synthetic */ C1775e f2275d;

        /* renamed from: i.M.d.e$a$a */
        static final class C1777a extends Lambda implements Function1<IOException, Unit> {

            /* renamed from: a */
            final /* synthetic */ C1776a f2276a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1777a(C1776a aVar, int i) {
                super(1);
                this.f2276a = aVar;
            }

            /* renamed from: a */
            public final void mo27625a(IOException iOException) {
                Intrinsics.checkParameterIsNotNull(iOException, "it");
                synchronized (this.f2276a.f2275d) {
                    this.f2276a.mo27622c();
                    Unit unit = Unit.INSTANCE;
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo27625a((IOException) obj);
                return Unit.INSTANCE;
            }
        }

        public C1776a(C1775e eVar, C1778b bVar) {
            Intrinsics.checkParameterIsNotNull(bVar, "entry");
            this.f2275d = eVar;
            this.f2274c = bVar;
            this.f2272a = bVar.mo27639g() ? null : new boolean[eVar.mo27615l()];
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:24|25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r5 = p042j.C2080p.m3579a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
            return r5;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x004f */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p042j.C2090x mo27619a(int r5) {
            /*
                r4 = this;
                i.M.d.e r0 = r4.f2275d
                monitor-enter(r0)
                boolean r1 = r4.f2273b     // Catch:{ all -> 0x0061 }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x0055
                i.M.d.e$b r1 = r4.f2274c     // Catch:{ all -> 0x0061 }
                i.M.d.e$a r1 = r1.mo27633b()     // Catch:{ all -> 0x0061 }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)     // Catch:{ all -> 0x0061 }
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x001c
                j.x r5 = p042j.C2080p.m3579a()     // Catch:{ all -> 0x0061 }
                monitor-exit(r0)
                return r5
            L_0x001c:
                i.M.d.e$b r1 = r4.f2274c     // Catch:{ all -> 0x0061 }
                boolean r1 = r1.mo27639g()     // Catch:{ all -> 0x0061 }
                if (r1 != 0) goto L_0x002d
                boolean[] r1 = r4.f2272a     // Catch:{ all -> 0x0061 }
                if (r1 != 0) goto L_0x002b
                kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0061 }
            L_0x002b:
                r1[r5] = r2     // Catch:{ all -> 0x0061 }
            L_0x002d:
                i.M.d.e$b r1 = r4.f2274c     // Catch:{ all -> 0x0061 }
                java.util.List r1 = r1.mo27635c()     // Catch:{ all -> 0x0061 }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0061 }
                java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x0061 }
                i.M.d.e r2 = r4.f2275d     // Catch:{ FileNotFoundException -> 0x004f }
                i.M.j.b r2 = r2.mo27614i()     // Catch:{ FileNotFoundException -> 0x004f }
                j.x r1 = r2.mo27956b(r1)     // Catch:{ FileNotFoundException -> 0x004f }
                i.M.d.g r2 = new i.M.d.g     // Catch:{ all -> 0x0061 }
                i.M.d.e$a$a r3 = new i.M.d.e$a$a     // Catch:{ all -> 0x0061 }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x0061 }
                r2.<init>(r1, r3)     // Catch:{ all -> 0x0061 }
                monitor-exit(r0)
                return r2
            L_0x004f:
                j.x r5 = p042j.C2080p.m3579a()     // Catch:{ all -> 0x0061 }
                monitor-exit(r0)
                return r5
            L_0x0055:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0061 }
                r1.<init>(r5)     // Catch:{ all -> 0x0061 }
                throw r1     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.C1776a.mo27619a(int):j.x");
        }

        /* renamed from: a */
        public final void mo27620a() throws IOException {
            synchronized (this.f2275d) {
                if (!this.f2273b) {
                    if (Intrinsics.areEqual((Object) this.f2274c.mo27633b(), (Object) this)) {
                        this.f2275d.mo27606a(this, false);
                    }
                    this.f2273b = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        /* renamed from: b */
        public final void mo27621b() throws IOException {
            synchronized (this.f2275d) {
                if (!this.f2273b) {
                    if (Intrinsics.areEqual((Object) this.f2274c.mo27633b(), (Object) this)) {
                        this.f2275d.mo27606a(this, true);
                    }
                    this.f2273b = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        /* renamed from: c */
        public final void mo27622c() {
            if (!Intrinsics.areEqual((Object) this.f2274c.mo27633b(), (Object) this)) {
                return;
            }
            if (this.f2275d.f2260l) {
                this.f2275d.mo27606a(this, false);
            } else {
                this.f2274c.mo27634b(true);
            }
        }

        /* renamed from: d */
        public final C1778b mo27623d() {
            return this.f2274c;
        }

        /* renamed from: e */
        public final boolean[] mo27624e() {
            return this.f2272a;
        }
    }

    /* renamed from: i.M.d.e$b */
    public final class C1778b {

        /* renamed from: a */
        private final long[] f2277a;

        /* renamed from: b */
        private final List<File> f2278b = new ArrayList();

        /* renamed from: c */
        private final List<File> f2279c = new ArrayList();

        /* renamed from: d */
        private boolean f2280d;

        /* renamed from: e */
        private boolean f2281e;

        /* renamed from: f */
        private C1776a f2282f;

        /* renamed from: g */
        private int f2283g;

        /* renamed from: h */
        private long f2284h;

        /* renamed from: i */
        private final String f2285i;

        /* renamed from: j */
        final /* synthetic */ C1775e f2286j;

        public C1778b(C1775e eVar, String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            this.f2286j = eVar;
            this.f2285i = str;
            this.f2277a = new long[eVar.mo27615l()];
            StringBuilder sb = new StringBuilder(this.f2285i);
            sb.append('.');
            int length = sb.length();
            int l = eVar.mo27615l();
            for (int i = 0; i < l; i++) {
                sb.append(i);
                this.f2278b.add(new File(eVar.mo27613h(), sb.toString()));
                sb.append(".tmp");
                this.f2279c.add(new File(eVar.mo27613h(), sb.toString()));
                sb.setLength(length);
            }
        }

        /* renamed from: a */
        public final List<File> mo27626a() {
            return this.f2278b;
        }

        /* renamed from: a */
        public final void mo27627a(int i) {
            this.f2283g = i;
        }

        /* renamed from: a */
        public final void mo27628a(long j) {
            this.f2284h = j;
        }

        /* renamed from: a */
        public final void mo27629a(C1776a aVar) {
            this.f2282f = aVar;
        }

        /* renamed from: a */
        public final void mo27630a(C2071g gVar) throws IOException {
            Intrinsics.checkParameterIsNotNull(gVar, "writer");
            for (long g : this.f2277a) {
                gVar.writeByte(32).mo29161g(g);
            }
        }

        /* renamed from: a */
        public final void mo27631a(List<String> list) throws IOException {
            Intrinsics.checkParameterIsNotNull(list, "strings");
            if (list.size() == this.f2286j.mo27615l()) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.f2277a[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + list);
                }
            } else {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        /* renamed from: a */
        public final void mo27632a(boolean z) {
            this.f2280d = z;
        }

        /* renamed from: b */
        public final C1776a mo27633b() {
            return this.f2282f;
        }

        /* renamed from: b */
        public final void mo27634b(boolean z) {
            this.f2281e = z;
        }

        /* renamed from: c */
        public final List<File> mo27635c() {
            return this.f2279c;
        }

        /* renamed from: d */
        public final String mo27636d() {
            return this.f2285i;
        }

        /* renamed from: e */
        public final long[] mo27637e() {
            return this.f2277a;
        }

        /* renamed from: f */
        public final int mo27638f() {
            return this.f2283g;
        }

        /* renamed from: g */
        public final boolean mo27639g() {
            return this.f2280d;
        }

        /* renamed from: h */
        public final long mo27640h() {
            return this.f2284h;
        }

        /* renamed from: i */
        public final boolean mo27641i() {
            return this.f2281e;
        }

        /* renamed from: j */
        public final C1779c mo27642j() {
            C1775e eVar = this.f2286j;
            if (C1764b.f2219g && !Thread.holdsLock(eVar)) {
                StringBuilder a = C0681a.m330a("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                a.append(currentThread.getName());
                a.append(" MUST hold lock on ");
                a.append(eVar);
                throw new AssertionError(a.toString());
            } else if (!this.f2280d) {
                return null;
            } else {
                if (!this.f2286j.f2260l && (this.f2282f != null || this.f2281e)) {
                    return null;
                }
                ArrayList<C1016z> arrayList = new ArrayList<>();
                long[] jArr = (long[]) this.f2277a.clone();
                try {
                    int l = this.f2286j.mo27615l();
                    for (int i = 0; i < l; i++) {
                        C1016z a2 = this.f2286j.mo27614i().mo27954a(this.f2278b.get(i));
                        if (!this.f2286j.f2260l) {
                            this.f2283g++;
                            a2 = new C1782f(this, a2, a2);
                        }
                        arrayList.add(a2);
                    }
                    return new C1779c(this.f2286j, this.f2285i, this.f2284h, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (C1016z a3 : arrayList) {
                        C1764b.m2629a((Closeable) a3);
                    }
                    try {
                        this.f2286j.mo27607a(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }
    }

    /* renamed from: i.M.d.e$c */
    public final class C1779c implements Closeable {

        /* renamed from: a */
        private final String f2287a;

        /* renamed from: b */
        private final long f2288b;

        /* renamed from: c */
        private final List<C1016z> f2289c;

        /* renamed from: d */
        final /* synthetic */ C1775e f2290d;

        public C1779c(C1775e eVar, String str, long j, List<? extends C1016z> list, long[] jArr) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            Intrinsics.checkParameterIsNotNull(list, "sources");
            Intrinsics.checkParameterIsNotNull(jArr, "lengths");
            this.f2290d = eVar;
            this.f2287a = str;
            this.f2288b = j;
            this.f2289c = list;
        }

        /* renamed from: a */
        public final C1016z mo27643a(int i) {
            return this.f2289c.get(i);
        }

        public void close() {
            for (C1016z a : this.f2289c) {
                C1764b.m2629a((Closeable) a);
            }
        }

        /* renamed from: d */
        public final C1776a mo27645d() throws IOException {
            return this.f2290d.mo27605a(this.f2287a, this.f2288b);
        }
    }

    /* renamed from: i.M.d.e$d */
    public static final class C1780d extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1775e f2291e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1780d(C1775e eVar, String str) {
            super(str, true);
            this.f2291e = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            p040i.p103M.p105d.C1775e.m2661b(r6.f2291e, true);
            r1 = r6.f2291e;
            r4 = p042j.C2080p.m3579a();
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, "$this$buffer");
            p040i.p103M.p105d.C1775e.m2658a(r1, (p042j.C2071g) new p042j.C2084s(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0036 */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo27646e() {
            /*
                r6 = this;
                i.M.d.e r0 = r6.f2291e
                monitor-enter(r0)
                i.M.d.e r1 = r6.f2291e     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.f2261m     // Catch:{ all -> 0x0052 }
                r2 = -1
                if (r1 == 0) goto L_0x0050
                i.M.d.e r1 = r6.f2291e     // Catch:{ all -> 0x0052 }
                boolean r1 = r1.mo27611d()     // Catch:{ all -> 0x0052 }
                if (r1 == 0) goto L_0x0016
                goto L_0x0050
            L_0x0016:
                r1 = 1
                i.M.d.e r4 = r6.f2291e     // Catch:{ IOException -> 0x001d }
                r4.mo27618q()     // Catch:{ IOException -> 0x001d }
                goto L_0x0022
            L_0x001d:
                i.M.d.e r4 = r6.f2291e     // Catch:{ all -> 0x0052 }
                r4.f2263o = r1     // Catch:{ all -> 0x0052 }
            L_0x0022:
                i.M.d.e r4 = r6.f2291e     // Catch:{ IOException -> 0x0036 }
                boolean r4 = r4.m2668s()     // Catch:{ IOException -> 0x0036 }
                if (r4 == 0) goto L_0x004e
                i.M.d.e r4 = r6.f2291e     // Catch:{ IOException -> 0x0036 }
                r4.mo27617p()     // Catch:{ IOException -> 0x0036 }
                i.M.d.e r4 = r6.f2291e     // Catch:{ IOException -> 0x0036 }
                r5 = 0
                r4.f2258h = r5     // Catch:{ IOException -> 0x0036 }
                goto L_0x004e
            L_0x0036:
                i.M.d.e r4 = r6.f2291e     // Catch:{ all -> 0x0052 }
                r4.f2264p = r1     // Catch:{ all -> 0x0052 }
                i.M.d.e r1 = r6.f2291e     // Catch:{ all -> 0x0052 }
                j.x r4 = p042j.C2080p.m3579a()     // Catch:{ all -> 0x0052 }
                java.lang.String r5 = "$this$buffer"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r5)     // Catch:{ all -> 0x0052 }
                j.s r5 = new j.s     // Catch:{ all -> 0x0052 }
                r5.<init>(r4)     // Catch:{ all -> 0x0052 }
                r1.f2256f = r5     // Catch:{ all -> 0x0052 }
            L_0x004e:
                monitor-exit(r0)
                return r2
            L_0x0050:
                monitor-exit(r0)
                return r2
            L_0x0052:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.C1780d.mo27646e():long");
        }
    }

    /* renamed from: i.M.d.e$e */
    static final class C1781e extends Lambda implements Function1<IOException, Unit> {

        /* renamed from: a */
        final /* synthetic */ C1775e f2292a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1781e(C1775e eVar) {
            super(1);
            this.f2292a = eVar;
        }

        public Object invoke(Object obj) {
            Intrinsics.checkParameterIsNotNull((IOException) obj, "it");
            C1775e eVar = this.f2292a;
            if (!C1764b.f2219g || Thread.holdsLock(eVar)) {
                this.f2292a.f2259i = true;
                return Unit.INSTANCE;
            }
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST hold lock on ");
            a.append(eVar);
            throw new AssertionError(a.toString());
        }
    }

    public C1775e(C1873b bVar, File file, int i, int i2, long j, C1788e eVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "fileSystem");
        Intrinsics.checkParameterIsNotNull(file, "directory");
        Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
        this.f2268t = bVar;
        this.f2269u = file;
        this.f2270v = i;
        this.f2271w = i2;
        this.f2251a = j;
        boolean z = true;
        this.f2266r = eVar.mo27675d();
        this.f2267s = new C1780d(this, C0681a.m324a(new StringBuilder(), C1764b.f2220h, " Cache"));
        if (j > 0) {
            if (this.f2271w <= 0 ? false : z) {
                this.f2252b = new File(this.f2269u, "journal");
                this.f2253c = new File(this.f2269u, "journal.tmp");
                this.f2254d = new File(this.f2269u, "journal.bkp");
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    /* renamed from: a */
    public static /* synthetic */ C1776a m2656a(C1775e eVar, String str, long j, int i) throws IOException {
        if ((i & 2) != 0) {
            j = -1;
        }
        return eVar.mo27605a(str, j);
    }

    /* renamed from: d */
    private final void m2665d(String str) throws IOException {
        String str2;
        String str3 = str;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                if (str3 != null) {
                    str2 = str3.substring(i);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
                    if (indexOf$default == f2246A.length() && StringsKt__StringsJVMKt.startsWith$default(str3, f2246A, false, 2, (Object) null)) {
                        this.f2257g.remove(str2);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str3 != null) {
                str2 = str3.substring(i, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            C1778b bVar = this.f2257g.get(str2);
            if (bVar == null) {
                bVar = new C1778b(this, str2);
                this.f2257g.put(str2, bVar);
            }
            if (indexOf$default2 != -1 && indexOf$default == f2249y.length() && StringsKt__StringsJVMKt.startsWith$default(str3, f2249y, false, 2, (Object) null)) {
                int i2 = indexOf$default2 + 1;
                if (str3 != null) {
                    String substring = str3.substring(i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                    bVar.mo27632a(true);
                    bVar.mo27629a((C1776a) null);
                    bVar.mo27631a((List<String>) split$default);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else if (indexOf$default2 == -1 && indexOf$default == f2250z.length() && StringsKt__StringsJVMKt.startsWith$default(str3, f2250z, false, 2, (Object) null)) {
                bVar.mo27629a(new C1776a(this, bVar));
            } else if (indexOf$default2 != -1 || indexOf$default != f2247B.length() || !StringsKt__StringsJVMKt.startsWith$default(str3, f2247B, false, 2, (Object) null)) {
                throw new IOException(C0681a.m320a("unexpected journal line: ", str3));
            }
        } else {
            throw new IOException(C0681a.m320a("unexpected journal line: ", str3));
        }
    }

    /* renamed from: e */
    private final void m2666e(String str) {
        if (!f2248x.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Typography.quote).toString());
        }
    }

    /* renamed from: r */
    private final synchronized void m2667r() {
        if (!(!this.f2262n)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public final boolean m2668s() {
        int i = this.f2258h;
        return i >= 2000 && i >= this.f2257g.size();
    }

    /* renamed from: t */
    private final C2071g m2669t() throws FileNotFoundException {
        C1783g gVar = new C1783g(this.f2268t.mo27960f(this.f2252b), new C1781e(this));
        Intrinsics.checkParameterIsNotNull(gVar, "$this$buffer");
        return new C2084s(gVar);
    }

    /* renamed from: u */
    private final void m2670u() throws IOException {
        this.f2268t.mo27959e(this.f2253c);
        Iterator<C1778b> it = this.f2257g.values().iterator();
        while (it.hasNext()) {
            C1778b next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "i.next()");
            C1778b bVar = next;
            int i = 0;
            if (bVar.mo27633b() == null) {
                int i2 = this.f2271w;
                while (i < i2) {
                    this.f2255e += bVar.mo27637e()[i];
                    i++;
                }
            } else {
                bVar.mo27629a((C1776a) null);
                int i3 = this.f2271w;
                while (i < i3) {
                    this.f2268t.mo27959e(bVar.mo27626a().get(i));
                    this.f2268t.mo27959e(bVar.mo27635c().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|(1:21)(1:22)|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r9.f2258h = r7 - r9.f2257g.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r1.mo29152c() == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        mo27617p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r9.f2256f = m2669t();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r1, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0064 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0064=Splitter:B:18:0x0064, B:26:0x0084=Splitter:B:26:0x0084} */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2671v() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            i.M.j.b r1 = r9.f2268t
            java.io.File r2 = r9.f2252b
            j.z r1 = r1.mo27954a(r2)
            j.h r1 = p042j.C2080p.m3578a((p042j.C1016z) r1)
            java.lang.String r2 = r1.mo29171k()     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = r1.mo29171k()     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = r1.mo29171k()     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = r1.mo29171k()     // Catch:{ all -> 0x00b2 }
            java.lang.String r6 = r1.mo29171k()     // Catch:{ all -> 0x00b2 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)     // Catch:{ all -> 0x00b2 }
            r8 = 1
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0084
            java.lang.String r7 = "1"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)     // Catch:{ all -> 0x00b2 }
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0084
            int r7 = r9.f2270v     // Catch:{ all -> 0x00b2 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00b2 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)     // Catch:{ all -> 0x00b2 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0084
            int r4 = r9.f2271w     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00b2 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x00b2 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0084
            int r4 = r6.length()     // Catch:{ all -> 0x00b2 }
            r7 = 0
            if (r4 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 != 0) goto L_0x0084
        L_0x005a:
            java.lang.String r0 = r1.mo29171k()     // Catch:{ EOFException -> 0x0064 }
            r9.m2665d(r0)     // Catch:{ EOFException -> 0x0064 }
            int r7 = r7 + 1
            goto L_0x005a
        L_0x0064:
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r0 = r9.f2257g     // Catch:{ all -> 0x00b2 }
            int r0 = r0.size()     // Catch:{ all -> 0x00b2 }
            int r7 = r7 - r0
            r9.f2258h = r7     // Catch:{ all -> 0x00b2 }
            boolean r0 = r1.mo29152c()     // Catch:{ all -> 0x00b2 }
            if (r0 != 0) goto L_0x0077
            r9.mo27617p()     // Catch:{ all -> 0x00b2 }
            goto L_0x007d
        L_0x0077:
            j.g r0 = r9.m2669t()     // Catch:{ all -> 0x00b2 }
            r9.f2256f = r0     // Catch:{ all -> 0x00b2 }
        L_0x007d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b2 }
            r0 = 0
            kotlin.p045io.CloseableKt.closeFinally(r1, r0)
            return
        L_0x0084:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00b2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r7.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00b2 }
            r7.append(r2)     // Catch:{ all -> 0x00b2 }
            r7.append(r0)     // Catch:{ all -> 0x00b2 }
            r7.append(r3)     // Catch:{ all -> 0x00b2 }
            r7.append(r0)     // Catch:{ all -> 0x00b2 }
            r7.append(r5)     // Catch:{ all -> 0x00b2 }
            r7.append(r0)     // Catch:{ all -> 0x00b2 }
            r7.append(r6)     // Catch:{ all -> 0x00b2 }
            r0 = 93
            r7.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00b2 }
            r4.<init>(r0)     // Catch:{ all -> 0x00b2 }
            throw r4     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r2 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r1, r0)
            goto L_0x00ba
        L_0x00b9:
            throw r2
        L_0x00ba:
            goto L_0x00b9
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.m2671v():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        return null;
     */
    @kotlin.jvm.JvmOverloads
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized p040i.p103M.p105d.C1775e.C1776a mo27605a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)     // Catch:{ all -> 0x0090 }
            r5.mo27616o()     // Catch:{ all -> 0x0090 }
            r5.m2667r()     // Catch:{ all -> 0x0090 }
            r5.m2666e(r6)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r0 = r5.f2257g     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0090 }
            i.M.d.e$b r0 = (p040i.p103M.p105d.C1775e.C1778b) r0     // Catch:{ all -> 0x0090 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            long r1 = r0.mo27640h()     // Catch:{ all -> 0x0090 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r5)
            return r3
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            i.M.d.e$a r7 = r0.mo27633b()     // Catch:{ all -> 0x0090 }
            goto L_0x0032
        L_0x0031:
            r7 = r3
        L_0x0032:
            if (r7 == 0) goto L_0x0036
            monitor-exit(r5)
            return r3
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            int r7 = r0.mo27638f()     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0040
            monitor-exit(r5)
            return r3
        L_0x0040:
            boolean r7 = r5.f2263o     // Catch:{ all -> 0x0090 }
            if (r7 != 0) goto L_0x0084
            boolean r7 = r5.f2264p     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0049
            goto L_0x0084
        L_0x0049:
            j.g r7 = r5.f2256f     // Catch:{ all -> 0x0090 }
            if (r7 != 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0090 }
        L_0x0050:
            java.lang.String r8 = f2250z     // Catch:{ all -> 0x0090 }
            j.g r8 = r7.mo29138a((java.lang.String) r8)     // Catch:{ all -> 0x0090 }
            r1 = 32
            j.g r8 = r8.writeByte(r1)     // Catch:{ all -> 0x0090 }
            j.g r8 = r8.mo29138a((java.lang.String) r6)     // Catch:{ all -> 0x0090 }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x0090 }
            r7.flush()     // Catch:{ all -> 0x0090 }
            boolean r7 = r5.f2259i     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x006e
            monitor-exit(r5)
            return r3
        L_0x006e:
            if (r0 != 0) goto L_0x007a
            i.M.d.e$b r0 = new i.M.d.e$b     // Catch:{ all -> 0x0090 }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r7 = r5.f2257g     // Catch:{ all -> 0x0090 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0090 }
        L_0x007a:
            i.M.d.e$a r6 = new i.M.d.e$a     // Catch:{ all -> 0x0090 }
            r6.<init>(r5, r0)     // Catch:{ all -> 0x0090 }
            r0.mo27629a((p040i.p103M.p105d.C1775e.C1776a) r6)     // Catch:{ all -> 0x0090 }
            monitor-exit(r5)
            return r6
        L_0x0084:
            i.M.e.d r6 = r5.f2266r     // Catch:{ all -> 0x0090 }
            i.M.d.e$d r7 = r5.f2267s     // Catch:{ all -> 0x0090 }
            r0 = 0
            r8 = 2
            p040i.p103M.p106e.C1787d.m2722a(r6, r7, r0, r8)     // Catch:{ all -> 0x0090 }
            monitor-exit(r5)
            return r3
        L_0x0090:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27605a(java.lang.String, long):i.M.d.e$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0138, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo27606a(p040i.p103M.p105d.C1775e.C1776a r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)     // Catch:{ all -> 0x0145 }
            i.M.d.e$b r0 = r9.mo27623d()     // Catch:{ all -> 0x0145 }
            i.M.d.e$a r1 = r0.mo27633b()     // Catch:{ all -> 0x0145 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0145 }
            if (r1 == 0) goto L_0x0139
            r1 = 0
            if (r10 == 0) goto L_0x0063
            boolean r2 = r0.mo27639g()     // Catch:{ all -> 0x0145 }
            if (r2 != 0) goto L_0x0063
            int r2 = r8.f2271w     // Catch:{ all -> 0x0145 }
            r3 = 0
        L_0x0020:
            if (r3 >= r2) goto L_0x0063
            boolean[] r4 = r9.mo27624e()     // Catch:{ all -> 0x0145 }
            if (r4 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0145 }
        L_0x002b:
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0145 }
            if (r4 == 0) goto L_0x0049
            i.M.j.b r4 = r8.f2268t     // Catch:{ all -> 0x0145 }
            java.util.List r5 = r0.mo27635c()     // Catch:{ all -> 0x0145 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0145 }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x0145 }
            boolean r4 = r4.mo27958d(r5)     // Catch:{ all -> 0x0145 }
            if (r4 != 0) goto L_0x0046
            r9.mo27620a()     // Catch:{ all -> 0x0145 }
            monitor-exit(r8)
            return
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0049:
            r9.mo27620a()     // Catch:{ all -> 0x0145 }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0145 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0145 }
            r10.<init>()     // Catch:{ all -> 0x0145 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r10.append(r0)     // Catch:{ all -> 0x0145 }
            r10.append(r3)     // Catch:{ all -> 0x0145 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0145 }
            r9.<init>(r10)     // Catch:{ all -> 0x0145 }
            throw r9     // Catch:{ all -> 0x0145 }
        L_0x0063:
            int r9 = r8.f2271w     // Catch:{ all -> 0x0145 }
        L_0x0065:
            if (r1 >= r9) goto L_0x00b1
            java.util.List r2 = r0.mo27635c()     // Catch:{ all -> 0x0145 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0145 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0145 }
            if (r10 == 0) goto L_0x00a9
            boolean r3 = r0.mo27641i()     // Catch:{ all -> 0x0145 }
            if (r3 != 0) goto L_0x00a9
            i.M.j.b r3 = r8.f2268t     // Catch:{ all -> 0x0145 }
            boolean r3 = r3.mo27958d(r2)     // Catch:{ all -> 0x0145 }
            if (r3 == 0) goto L_0x00ae
            java.util.List r3 = r0.mo27626a()     // Catch:{ all -> 0x0145 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0145 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0145 }
            i.M.j.b r4 = r8.f2268t     // Catch:{ all -> 0x0145 }
            r4.mo27955a(r2, r3)     // Catch:{ all -> 0x0145 }
            long[] r2 = r0.mo27637e()     // Catch:{ all -> 0x0145 }
            r4 = r2[r1]     // Catch:{ all -> 0x0145 }
            i.M.j.b r2 = r8.f2268t     // Catch:{ all -> 0x0145 }
            long r2 = r2.mo27961g(r3)     // Catch:{ all -> 0x0145 }
            long[] r6 = r0.mo27637e()     // Catch:{ all -> 0x0145 }
            r6[r1] = r2     // Catch:{ all -> 0x0145 }
            long r6 = r8.f2255e     // Catch:{ all -> 0x0145 }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.f2255e = r6     // Catch:{ all -> 0x0145 }
            goto L_0x00ae
        L_0x00a9:
            i.M.j.b r3 = r8.f2268t     // Catch:{ all -> 0x0145 }
            r3.mo27959e(r2)     // Catch:{ all -> 0x0145 }
        L_0x00ae:
            int r1 = r1 + 1
            goto L_0x0065
        L_0x00b1:
            r9 = 0
            r0.mo27629a((p040i.p103M.p105d.C1775e.C1776a) r9)     // Catch:{ all -> 0x0145 }
            boolean r9 = r0.mo27641i()     // Catch:{ all -> 0x0145 }
            if (r9 == 0) goto L_0x00c0
            r8.mo27607a((p040i.p103M.p105d.C1775e.C1778b) r0)     // Catch:{ all -> 0x0145 }
            monitor-exit(r8)
            return
        L_0x00c0:
            int r9 = r8.f2258h     // Catch:{ all -> 0x0145 }
            r1 = 1
            int r9 = r9 + r1
            r8.f2258h = r9     // Catch:{ all -> 0x0145 }
            j.g r9 = r8.f2256f     // Catch:{ all -> 0x0145 }
            if (r9 != 0) goto L_0x00cd
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0145 }
        L_0x00cd:
            boolean r2 = r0.mo27639g()     // Catch:{ all -> 0x0145 }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00f7
            if (r10 == 0) goto L_0x00da
            goto L_0x00f7
        L_0x00da:
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r10 = r8.f2257g     // Catch:{ all -> 0x0145 }
            java.lang.String r1 = r0.mo27636d()     // Catch:{ all -> 0x0145 }
            r10.remove(r1)     // Catch:{ all -> 0x0145 }
            java.lang.String r10 = f2246A     // Catch:{ all -> 0x0145 }
            j.g r10 = r9.mo29138a((java.lang.String) r10)     // Catch:{ all -> 0x0145 }
            r10.writeByte(r4)     // Catch:{ all -> 0x0145 }
            java.lang.String r10 = r0.mo27636d()     // Catch:{ all -> 0x0145 }
            r9.mo29138a((java.lang.String) r10)     // Catch:{ all -> 0x0145 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0145 }
            goto L_0x011c
        L_0x00f7:
            r0.mo27632a((boolean) r1)     // Catch:{ all -> 0x0145 }
            java.lang.String r1 = f2249y     // Catch:{ all -> 0x0145 }
            j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0145 }
            r1.writeByte(r4)     // Catch:{ all -> 0x0145 }
            java.lang.String r1 = r0.mo27636d()     // Catch:{ all -> 0x0145 }
            r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0145 }
            r0.mo27630a((p042j.C2071g) r9)     // Catch:{ all -> 0x0145 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0145 }
            if (r10 == 0) goto L_0x011c
            long r1 = r8.f2265q     // Catch:{ all -> 0x0145 }
            r3 = 1
            long r3 = r3 + r1
            r8.f2265q = r3     // Catch:{ all -> 0x0145 }
            r0.mo27628a((long) r1)     // Catch:{ all -> 0x0145 }
        L_0x011c:
            r9.flush()     // Catch:{ all -> 0x0145 }
            long r9 = r8.f2255e     // Catch:{ all -> 0x0145 }
            long r0 = r8.f2251a     // Catch:{ all -> 0x0145 }
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x012d
            boolean r9 = r8.m2668s()     // Catch:{ all -> 0x0145 }
            if (r9 == 0) goto L_0x0137
        L_0x012d:
            i.M.e.d r9 = r8.f2266r     // Catch:{ all -> 0x0145 }
            i.M.d.e$d r10 = r8.f2267s     // Catch:{ all -> 0x0145 }
            r0 = 0
            r2 = 2
            p040i.p103M.p106e.C1787d.m2722a(r9, r10, r0, r2)     // Catch:{ all -> 0x0145 }
        L_0x0137:
            monitor-exit(r8)
            return
        L_0x0139:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0145 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0145 }
            r10.<init>(r9)     // Catch:{ all -> 0x0145 }
            throw r10     // Catch:{ all -> 0x0145 }
        L_0x0145:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0149
        L_0x0148:
            throw r9
        L_0x0149:
            goto L_0x0148
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27606a(i.M.d.e$a, boolean):void");
    }

    /* renamed from: a */
    public final boolean mo27607a(C1778b bVar) throws IOException {
        C2071g gVar;
        Intrinsics.checkParameterIsNotNull(bVar, "entry");
        if (!this.f2260l) {
            if (bVar.mo27638f() > 0 && (gVar = this.f2256f) != null) {
                gVar.mo29138a(f2250z);
                gVar.writeByte(32);
                gVar.mo29138a(bVar.mo27636d());
                gVar.writeByte(10);
                gVar.flush();
            }
            if (bVar.mo27638f() > 0 || bVar.mo27633b() != null) {
                bVar.mo27634b(true);
                return true;
            }
        }
        C1776a b = bVar.mo27633b();
        if (b != null) {
            b.mo27622c();
        }
        int i = this.f2271w;
        for (int i2 = 0; i2 < i; i2++) {
            this.f2268t.mo27959e(bVar.mo27626a().get(i2));
            this.f2255e -= bVar.mo27637e()[i2];
            bVar.mo27637e()[i2] = 0;
        }
        this.f2258h++;
        C2071g gVar2 = this.f2256f;
        if (gVar2 != null) {
            gVar2.mo29138a(f2246A);
            gVar2.writeByte(32);
            gVar2.mo29138a(bVar.mo27636d());
            gVar2.writeByte(10);
        }
        this.f2257g.remove(bVar.mo27636d());
        if (m2668s()) {
            C1787d.m2722a(this.f2266r, this.f2267s, 0, 2);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        return r0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized p040i.p103M.p105d.C1775e.C1779c mo27608b(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)     // Catch:{ all -> 0x005d }
            r5.mo27616o()     // Catch:{ all -> 0x005d }
            r5.m2667r()     // Catch:{ all -> 0x005d }
            r5.m2666e(r6)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r0 = r5.f2257g     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            i.M.d.e$b r0 = (p040i.p103M.p105d.C1775e.C1778b) r0     // Catch:{ all -> 0x005d }
            r1 = 0
            if (r0 == 0) goto L_0x005b
            java.lang.String r2 = "lruEntries[key] ?: return null"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)     // Catch:{ all -> 0x005d }
            i.M.d.e$c r0 = r0.mo27642j()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0059
            int r1 = r5.f2258h     // Catch:{ all -> 0x005d }
            int r1 = r1 + 1
            r5.f2258h = r1     // Catch:{ all -> 0x005d }
            j.g r1 = r5.f2256f     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0032
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x005d }
        L_0x0032:
            java.lang.String r2 = f2247B     // Catch:{ all -> 0x005d }
            j.g r1 = r1.mo29138a((java.lang.String) r2)     // Catch:{ all -> 0x005d }
            r2 = 32
            j.g r1 = r1.writeByte(r2)     // Catch:{ all -> 0x005d }
            j.g r6 = r1.mo29138a((java.lang.String) r6)     // Catch:{ all -> 0x005d }
            r1 = 10
            r6.writeByte(r1)     // Catch:{ all -> 0x005d }
            boolean r6 = r5.m2668s()     // Catch:{ all -> 0x005d }
            if (r6 == 0) goto L_0x0057
            i.M.e.d r6 = r5.f2266r     // Catch:{ all -> 0x005d }
            i.M.d.e$d r1 = r5.f2267s     // Catch:{ all -> 0x005d }
            r2 = 0
            r4 = 2
            p040i.p103M.p106e.C1787d.m2722a(r6, r1, r2, r4)     // Catch:{ all -> 0x005d }
        L_0x0057:
            monitor-exit(r5)
            return r0
        L_0x0059:
            monitor-exit(r5)
            return r1
        L_0x005b:
            monitor-exit(r5)
            return r1
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27608b(java.lang.String):i.M.d.e$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        return true;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo27609c(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)     // Catch:{ all -> 0x0031 }
            r6.mo27616o()     // Catch:{ all -> 0x0031 }
            r6.m2667r()     // Catch:{ all -> 0x0031 }
            r6.m2666e(r7)     // Catch:{ all -> 0x0031 }
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r0 = r6.f2257g     // Catch:{ all -> 0x0031 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0031 }
            i.M.d.e$b r7 = (p040i.p103M.p105d.C1775e.C1778b) r7     // Catch:{ all -> 0x0031 }
            r0 = 0
            if (r7 == 0) goto L_0x002f
            java.lang.String r1 = "lruEntries[key] ?: return false"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)     // Catch:{ all -> 0x0031 }
            r6.mo27607a((p040i.p103M.p105d.C1775e.C1778b) r7)     // Catch:{ all -> 0x0031 }
            r7 = 1
            long r1 = r6.f2255e     // Catch:{ all -> 0x0031 }
            long r3 = r6.f2251a     // Catch:{ all -> 0x0031 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002d
            r6.f2263o = r0     // Catch:{ all -> 0x0031 }
        L_0x002d:
            monitor-exit(r6)
            return r7
        L_0x002f:
            monitor-exit(r6)
            return r0
        L_0x0031:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27609c(java.lang.String):boolean");
    }

    public synchronized void close() throws IOException {
        C1776a b;
        if (this.f2261m) {
            if (!this.f2262n) {
                Collection<C1778b> values = this.f2257g.values();
                Intrinsics.checkExpressionValueIsNotNull(values, "lruEntries.values");
                Object[] array = values.toArray(new C1778b[0]);
                if (array != null) {
                    for (C1778b bVar : (C1778b[]) array) {
                        if (!(bVar.mo27633b() == null || (b = bVar.mo27633b()) == null)) {
                            b.mo27622c();
                        }
                    }
                    mo27618q();
                    C2071g gVar = this.f2256f;
                    if (gVar == null) {
                        Intrinsics.throwNpe();
                    }
                    gVar.close();
                    this.f2256f = null;
                    this.f2262n = true;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.f2262n = true;
    }

    /* renamed from: d */
    public final boolean mo27611d() {
        return this.f2262n;
    }

    public synchronized void flush() throws IOException {
        if (this.f2261m) {
            m2667r();
            mo27618q();
            C2071g gVar = this.f2256f;
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            gVar.flush();
        }
    }

    /* renamed from: h */
    public final File mo27613h() {
        return this.f2269u;
    }

    /* renamed from: i */
    public final C1873b mo27614i() {
        return this.f2268t;
    }

    /* renamed from: l */
    public final int mo27615l() {
        return this.f2271w;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r6 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r2, (java.lang.Throwable) null);
        r0.mo27959e(r1);
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0082 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo27616o() throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = p040i.p103M.C1764b.f2219g     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0038
            boolean r0 = java.lang.Thread.holdsLock(r7)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x000c
            goto L_0x0038
        L_0x000c:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r1.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = "Thread "
            r1.append(r2)     // Catch:{ all -> 0x00ee }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x00ee }
            r1.append(r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = " MUST hold lock on "
            r1.append(r2)     // Catch:{ all -> 0x00ee }
            r1.append(r7)     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ee }
            r0.<init>(r1)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x0038:
            boolean r0 = r7.f2261m     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x003e
            monitor-exit(r7)
            return
        L_0x003e:
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2254d     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.mo27958d(r1)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0063
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2252b     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.mo27958d(r1)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x005a
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2254d     // Catch:{ all -> 0x00ee }
            r0.mo27959e(r1)     // Catch:{ all -> 0x00ee }
            goto L_0x0063
        L_0x005a:
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2254d     // Catch:{ all -> 0x00ee }
            java.io.File r2 = r7.f2252b     // Catch:{ all -> 0x00ee }
            r0.mo27955a(r1, r2)     // Catch:{ all -> 0x00ee }
        L_0x0063:
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2254d     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = "$this$isCivilized"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = "file"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)     // Catch:{ all -> 0x00ee }
            j.x r2 = r0.mo27956b(r1)     // Catch:{ all -> 0x00ee }
            r3 = 0
            r4 = 0
            r5 = 1
            r0.mo27959e(r1)     // Catch:{  }
            kotlin.p045io.CloseableKt.closeFinally(r2, r3)     // Catch:{ IOException -> 0x0082 }
            r0 = 1
            goto L_0x008b
        L_0x0080:
            r0 = move-exception
            goto L_0x00e8
        L_0x0082:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0080 }
            kotlin.p045io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x00ee }
            r0.mo27959e(r1)     // Catch:{ all -> 0x00ee }
            r0 = 0
        L_0x008b:
            r7.f2260l = r0     // Catch:{ all -> 0x00ee }
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00ee }
            java.io.File r1 = r7.f2252b     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.mo27958d(r1)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00e1
            r7.m2671v()     // Catch:{ IOException -> 0x00a1 }
            r7.m2670u()     // Catch:{ IOException -> 0x00a1 }
            r7.f2261m = r5     // Catch:{ IOException -> 0x00a1 }
            monitor-exit(r7)
            return
        L_0x00a1:
            r0 = move-exception
            i.M.k.h$a r1 = p040i.p103M.p112k.C1890h.f2683c     // Catch:{ all -> 0x00ee }
            i.M.k.h r1 = p040i.p103M.p112k.C1890h.f2681a     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r2.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = "DiskLruCache "
            r2.append(r3)     // Catch:{ all -> 0x00ee }
            java.io.File r3 = r7.f2269u     // Catch:{ all -> 0x00ee }
            r2.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = " is corrupt: "
            r2.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00ee }
            r2.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = ", removing"
            r2.append(r3)     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ee }
            r3 = 5
            r1.mo27964a((java.lang.String) r2, (int) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x00ee }
            r7.close()     // Catch:{ all -> 0x00dd }
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00dd }
            java.io.File r1 = r7.f2269u     // Catch:{ all -> 0x00dd }
            r0.mo27957c(r1)     // Catch:{ all -> 0x00dd }
            r7.f2262n = r4     // Catch:{ all -> 0x00ee }
            goto L_0x00e1
        L_0x00dd:
            r0 = move-exception
            r7.f2262n = r4     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x00e1:
            r7.mo27617p()     // Catch:{ all -> 0x00ee }
            r7.f2261m = r5     // Catch:{ all -> 0x00ee }
            monitor-exit(r7)
            return
        L_0x00e8:
            throw r0     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r1 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x00ee }
            throw r1     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27616o():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bd, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c1, code lost:
        throw r2;
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo27617p() throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            j.g r0 = r7.f2256f     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00c2 }
        L_0x0008:
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00c2 }
            java.io.File r1 = r7.f2253c     // Catch:{ all -> 0x00c2 }
            j.x r0 = r0.mo27956b(r1)     // Catch:{ all -> 0x00c2 }
            j.g r0 = p042j.C2080p.m3577a((p042j.C2090x) r0)     // Catch:{ all -> 0x00c2 }
            r1 = 0
            java.lang.String r2 = "libcore.io.DiskLruCache"
            j.g r2 = r0.mo29138a((java.lang.String) r2)     // Catch:{ all -> 0x00bb }
            r3 = 10
            r2.writeByte(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "1"
            j.g r2 = r0.mo29138a((java.lang.String) r2)     // Catch:{ all -> 0x00bb }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bb }
            int r2 = r7.f2270v     // Catch:{ all -> 0x00bb }
            long r4 = (long) r2     // Catch:{ all -> 0x00bb }
            j.g r2 = r0.mo29161g(r4)     // Catch:{ all -> 0x00bb }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bb }
            int r2 = r7.f2271w     // Catch:{ all -> 0x00bb }
            long r4 = (long) r2     // Catch:{ all -> 0x00bb }
            j.g r2 = r0.mo29161g(r4)     // Catch:{ all -> 0x00bb }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bb }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bb }
            java.util.LinkedHashMap<java.lang.String, i.M.d.e$b> r2 = r7.f2257g     // Catch:{ all -> 0x00bb }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00bb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00bb }
        L_0x004a:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00bb }
            i.M.d.e$b r4 = (p040i.p103M.p105d.C1775e.C1778b) r4     // Catch:{ all -> 0x00bb }
            i.M.d.e$a r5 = r4.mo27633b()     // Catch:{ all -> 0x00bb }
            r6 = 32
            if (r5 == 0) goto L_0x0072
            java.lang.String r5 = f2250z     // Catch:{ all -> 0x00bb }
            j.g r5 = r0.mo29138a((java.lang.String) r5)     // Catch:{ all -> 0x00bb }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = r4.mo27636d()     // Catch:{ all -> 0x00bb }
            r0.mo29138a((java.lang.String) r4)     // Catch:{ all -> 0x00bb }
        L_0x006e:
            r0.writeByte(r3)     // Catch:{ all -> 0x00bb }
            goto L_0x004a
        L_0x0072:
            java.lang.String r5 = f2249y     // Catch:{ all -> 0x00bb }
            j.g r5 = r0.mo29138a((java.lang.String) r5)     // Catch:{ all -> 0x00bb }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = r4.mo27636d()     // Catch:{ all -> 0x00bb }
            r0.mo29138a((java.lang.String) r5)     // Catch:{ all -> 0x00bb }
            r4.mo27630a((p042j.C2071g) r0)     // Catch:{ all -> 0x00bb }
            goto L_0x006e
        L_0x0086:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bb }
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00c2 }
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00c2 }
            java.io.File r1 = r7.f2252b     // Catch:{ all -> 0x00c2 }
            boolean r0 = r0.mo27958d(r1)     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x009e
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00c2 }
            java.io.File r1 = r7.f2252b     // Catch:{ all -> 0x00c2 }
            java.io.File r2 = r7.f2254d     // Catch:{ all -> 0x00c2 }
            r0.mo27955a(r1, r2)     // Catch:{ all -> 0x00c2 }
        L_0x009e:
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00c2 }
            java.io.File r1 = r7.f2253c     // Catch:{ all -> 0x00c2 }
            java.io.File r2 = r7.f2252b     // Catch:{ all -> 0x00c2 }
            r0.mo27955a(r1, r2)     // Catch:{ all -> 0x00c2 }
            i.M.j.b r0 = r7.f2268t     // Catch:{ all -> 0x00c2 }
            java.io.File r1 = r7.f2254d     // Catch:{ all -> 0x00c2 }
            r0.mo27959e(r1)     // Catch:{ all -> 0x00c2 }
            j.g r0 = r7.m2669t()     // Catch:{ all -> 0x00c2 }
            r7.f2256f = r0     // Catch:{ all -> 0x00c2 }
            r0 = 0
            r7.f2259i = r0     // Catch:{ all -> 0x00c2 }
            r7.f2264p = r0     // Catch:{ all -> 0x00c2 }
            monitor-exit(r7)
            return
        L_0x00bb:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r2 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00c2 }
            throw r2     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x00c6
        L_0x00c5:
            throw r0
        L_0x00c6:
            goto L_0x00c5
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1775e.mo27617p():void");
    }

    /* renamed from: q */
    public final void mo27618q() throws IOException {
        boolean z;
        do {
            z = false;
            if (this.f2255e > this.f2251a) {
                Iterator<C1778b> it = this.f2257g.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1778b next = it.next();
                    if (!next.mo27641i()) {
                        Intrinsics.checkExpressionValueIsNotNull(next, "toEvict");
                        mo27607a(next);
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                this.f2263o = false;
                return;
            }
        } while (z);
    }
}
