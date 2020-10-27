package p042j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: j.h */
public interface C2072h extends C1016z, ReadableByteChannel {
    /* renamed from: a */
    int mo29132a(C2081q qVar) throws IOException;

    /* renamed from: a */
    long mo29134a(C2090x xVar) throws IOException;

    /* renamed from: a */
    C2073i mo29142a(long j) throws IOException;

    /* renamed from: a */
    String mo29144a(Charset charset) throws IOException;

    /* renamed from: a */
    boolean mo29145a(long j, C2073i iVar) throws IOException;

    /* renamed from: b */
    String mo29148b(long j) throws IOException;

    /* renamed from: b */
    byte[] mo29149b() throws IOException;

    /* renamed from: c */
    boolean mo29152c() throws IOException;

    /* renamed from: d */
    boolean mo29155d(long j) throws IOException;

    /* renamed from: e */
    byte[] mo29156e(long j) throws IOException;

    /* renamed from: f */
    void mo29159f(long j) throws IOException;

    /* renamed from: g */
    long mo29160g() throws IOException;

    C2068f getBuffer();

    /* renamed from: j */
    C2073i mo29169j() throws IOException;

    /* renamed from: k */
    String mo29171k() throws IOException;

    /* renamed from: m */
    long mo29173m() throws IOException;

    /* renamed from: n */
    InputStream mo29174n();

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}
