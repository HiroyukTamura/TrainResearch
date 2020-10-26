/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.f.q;

public class k
extends IOException {
    private q a = null;

    public k(String string2) {
        super(string2);
    }

    static k b() {
        return new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static k c() {
        return new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static k d() {
        return new k("CodedInputStream encountered a malformed varint.");
    }

    static k e() {
        return new k("Protocol message contained an invalid tag (zero).");
    }

    static k f() {
        return new k("Protocol message end-group tag did not match expected tag.");
    }

    static k g() {
        return new k("Protocol message tag had invalid wire type.");
    }

    static k h() {
        return new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static k i() {
        return new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static k j() {
        return new k("Protocol message had invalid UTF-8.");
    }

    public k a(q q2) {
        this.a = q2;
        return this;
    }

    public q a() {
        return this.a;
    }
}

