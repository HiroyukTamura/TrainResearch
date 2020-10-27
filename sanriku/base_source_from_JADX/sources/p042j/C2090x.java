package p042j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: j.x */
public interface C2090x extends Closeable, Flushable {
    /* renamed from: a */
    void mo27647a(C2068f fVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    C2057A timeout();
}
