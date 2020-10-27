package p009e.p015c.p016a.p017a.p018a;

import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p009e.p015c.p016a.p017a.p018a.C0702i;
import p009e.p015c.p016a.p017a.p018a.p019n.C0712b;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p024s.C0734d;
import p009e.p015c.p016a.p017a.p018a.p024s.C0737e;
import p009e.p015c.p016a.p017a.p018a.p024s.C0739g;
import p009e.p015c.p016a.p017a.p018a.p024s.C0745l;

/* renamed from: e.c.a.a.a.i */
public abstract class C0702i<T extends C0702i<?>> {
    @NonNull
    final Context context;
    @NonNull
    C0712b databaseProvider;
    final boolean debug;
    boolean foreignKeys = true;
    @Nullable
    C0737e migrationEngine;
    @Nullable
    String name;
    @Nullable
    C0739g.C0740a ormaMigrationBuilder = null;
    @NonNull
    C0693a readOnMainThread;
    boolean trace;
    @Nullable
    C0745l traceListener;
    boolean tryParsingSql;
    boolean wal = true;
    @NonNull
    C0693a writeOnMainThread;

    public C0702i(@NonNull Context context2) {
        C0693a aVar;
        this.context = context2.getApplicationContext();
        this.debug = extractDebuggable(context2);
        this.name = getDefaultDatabaseName(context2);
        this.databaseProvider = new C0714d.C0716b();
        boolean z = this.debug;
        this.trace = z;
        this.tryParsingSql = z;
        if (z) {
            this.readOnMainThread = C0693a.WARNING;
            aVar = C0693a.FATAL;
        } else {
            aVar = C0693a.NONE;
            this.readOnMainThread = aVar;
        }
        this.writeOnMainThread = aVar;
    }

    static boolean extractDebuggable(Context context2) {
        return (context2.getApplicationInfo().flags & 2) == 2;
    }

    @NonNull
    public static String getDefaultDatabaseName(@NonNull Context context2) {
        return context2.getPackageName() + ".orma.db";
    }

    @NonNull
    private C0739g.C0740a prepareOrmaMigrationBuilder() {
        if (this.migrationEngine == null) {
            if (this.ormaMigrationBuilder == null) {
                this.ormaMigrationBuilder = C0739g.m423c(this.context);
            }
            return this.ormaMigrationBuilder;
        }
        throw new IllegalArgumentException("migrationEngine is already set");
    }

    /* access modifiers changed from: protected */
    public T fillDefaults() {
        if (this.migrationEngine == null) {
            C0739g.C0740a prepareOrmaMigrationBuilder = prepareOrmaMigrationBuilder();
            prepareOrmaMigrationBuilder.mo19963a(this.traceListener);
            prepareOrmaMigrationBuilder.mo19964a(getSchemaHash());
            this.migrationEngine = prepareOrmaMigrationBuilder.mo19965a();
        }
        return this;
    }

    public T foreignKeys(boolean z) {
        this.foreignKeys = z;
        return this;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String getSchemaHash();

    public T migrationEngine(@NonNull C0737e eVar) {
        if (this.ormaMigrationBuilder == null) {
            this.migrationEngine = eVar;
            return this;
        }
        throw new IllegalArgumentException("migrationEngine is already installed via fields like migrationStep()");
    }

    public T migrationStep(@IntRange(from = 1) int i, @NonNull C0734d.C0736b bVar) {
        prepareOrmaMigrationBuilder().mo19962a(i, bVar);
        return this;
    }

    public T migrationTraceListener(@NonNull C0745l lVar) {
        prepareOrmaMigrationBuilder().mo19963a(lVar);
        return this;
    }

    public T name(@Nullable String str) {
        this.name = str;
        return this;
    }

    public T provider(@NonNull C0712b bVar) {
        this.databaseProvider = bVar;
        return this;
    }

    public T readOnMainThread(C0693a aVar) {
        this.readOnMainThread = aVar;
        return this;
    }

    public T trace(boolean z) {
        this.trace = z;
        return this;
    }

    public T tryParsingSql(boolean z) {
        this.tryParsingSql = z;
        return this;
    }

    public T versionForManualStepMigration(@IntRange(from = 1) int i) {
        prepareOrmaMigrationBuilder().mo19961a(i);
        return this;
    }

    public T writeAheadLogging(boolean z) {
        this.wal = z;
        return this;
    }

    public T writeOnMainThread(C0693a aVar) {
        this.writeOnMainThread = aVar;
        return this;
    }
}
