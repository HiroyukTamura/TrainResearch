package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzeco extends IOException {
    private zzedo zzhyr = null;

    public zzeco(String str) {
        super(str);
    }

    static zzeco zzbfg() {
        return new zzeco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzeco zzbfh() {
        return new zzeco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzeco zzbfi() {
        return new zzeco("CodedInputStream encountered a malformed varint.");
    }

    static zzeco zzbfj() {
        return new zzeco("Protocol message contained an invalid tag (zero).");
    }

    static zzeco zzbfk() {
        return new zzeco("Protocol message end-group tag did not match expected tag.");
    }

    static zzecn zzbfl() {
        return new zzecn("Protocol message tag had invalid wire type.");
    }

    static zzeco zzbfm() {
        return new zzeco("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzeco zzbfn() {
        return new zzeco("Failed to parse the message.");
    }

    static zzeco zzbfo() {
        return new zzeco("Protocol message had invalid UTF-8.");
    }

    public final zzeco zzl(zzedo zzedo) {
        this.zzhyr = zzedo;
        return this;
    }
}
