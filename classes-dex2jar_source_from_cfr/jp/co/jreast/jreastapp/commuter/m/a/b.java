/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m.a;

import d.d;
import d.e;
import d.l;
import java.io.File;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;", "", "()V", "bufferSink", "Lokio/BufferedSink;", "file", "Ljava/io/File;", "bufferSource", "Lokio/BufferedSource;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    public final d a(File object) {
        j.b(object, "file");
        object = l.a(l.b((File)object));
        j.a(object, "Okio.buffer(Okio.sink(file))");
        return object;
    }

    public final e b(File object) {
        j.b(object, "file");
        object = l.a(l.a((File)object));
        j.a(object, "Okio.buffer(Okio.source(file))");
        return object;
    }
}

