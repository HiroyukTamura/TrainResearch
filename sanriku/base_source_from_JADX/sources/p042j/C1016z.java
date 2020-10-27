package p042j;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: j.z */
public interface C1016z extends Closeable {
    void close() throws IOException;

    long read(C2068f fVar, long j) throws IOException;

    C2057A timeout();
}
