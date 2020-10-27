package p042j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: j.g */
public interface C2071g extends C2090x, WritableByteChannel {
    /* renamed from: a */
    long mo29135a(C1016z zVar) throws IOException;

    /* renamed from: a */
    C2071g mo29137a(C2073i iVar) throws IOException;

    /* renamed from: a */
    C2071g mo29138a(String str) throws IOException;

    /* renamed from: c */
    C2071g mo29151c(long j) throws IOException;

    /* renamed from: f */
    C2071g mo29158f() throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    C2071g mo29161g(long j) throws IOException;

    C2068f getBuffer();

    C2071g write(byte[] bArr) throws IOException;

    C2071g write(byte[] bArr, int i, int i2) throws IOException;

    C2071g writeByte(int i) throws IOException;

    C2071g writeInt(int i) throws IOException;

    C2071g writeShort(int i) throws IOException;
}
