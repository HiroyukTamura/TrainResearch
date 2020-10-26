// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.net;

import com.google.common.base.Objects;
import javax.annotation.Nullable;
import com.google.common.base.Strings;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;
import java.io.Serializable;

@Beta
@GwtCompatible
@Immutable
public final class HostAndPort implements Serializable
{
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0L;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;
    
    private HostAndPort(final String host, final int port, final boolean hasBracketlessColons) {
        this.host = host;
        this.port = port;
        this.hasBracketlessColons = hasBracketlessColons;
    }
    
    public static HostAndPort fromHost(final String s) {
        final HostAndPort fromString = fromString(s);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", s);
        return fromString;
    }
    
    public static HostAndPort fromParts(final String s, final int i) {
        Preconditions.checkArgument(isValidPort(i), "Port out of range: %s", i);
        final HostAndPort fromString = fromString(s);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", s);
        return new HostAndPort(fromString.host, i, fromString.hasBracketlessColons);
    }
    
    public static HostAndPort fromString(String s) {
        Preconditions.checkNotNull(s);
        String substring = null;
        boolean b = false;
        while (true) {
        Label_0096_Outer:
            while (true) {
                while (true) {
                    Label_0037: {
                        if (((String)s).startsWith("[")) {
                            final String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost((String)s);
                            final Object substring2 = hostAndPortFromBracketedHost[0];
                            substring = hostAndPortFromBracketedHost[1];
                            break Label_0037;
                        }
                        Label_0108: {
                            break Label_0108;
                            while (true) {
                                boolean b2 = false;
                                Preconditions.checkArgument(b2, "Unparseable port number: %s", s);
                                try {
                                    final int int1 = Integer.parseInt(substring);
                                    Preconditions.checkArgument(isValidPort(int1), "Port number out of range: %s", s);
                                    Object substring2 = null;
                                    return new HostAndPort((String)substring2, int1, b);
                                    final int index = ((String)s).indexOf(58);
                                    // iftrue(Label_0152:, index < 0 || s.indexOf(58, index + 1) != -1)
                                    substring2 = ((String)s).substring(0, index);
                                    substring = ((String)s).substring(index + 1);
                                    break;
                                    Label_0152: {
                                        substring2 = s;
                                    }
                                    b = (index >= 0);
                                    break;
                                    b2 = false;
                                }
                                catch (NumberFormatException ex) {
                                    s = String.valueOf(s);
                                    if (((String)s).length() != 0) {
                                        s = "Unparseable port number: ".concat((String)s);
                                    }
                                    else {
                                        s = new String("Unparseable port number: ");
                                    }
                                    throw new IllegalArgumentException((String)s);
                                }
                            }
                        }
                    }
                    final int int1 = -1;
                    if (Strings.isNullOrEmpty(substring)) {
                        continue;
                    }
                    break;
                }
                if (!substring.startsWith("+")) {
                    final boolean b2 = true;
                    continue Label_0096_Outer;
                }
                break;
            }
            continue;
        }
    }
    
    private static String[] getHostAndPortFromBracketedHost(final String s) {
        Preconditions.checkArgument(s.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", s);
        final int index = s.indexOf(58);
        final int lastIndex = s.lastIndexOf(93);
        Preconditions.checkArgument(index > -1 && lastIndex > index, "Invalid bracketed host/port: %s", s);
        final String substring = s.substring(1, lastIndex);
        if (lastIndex + 1 == s.length()) {
            return new String[] { substring, "" };
        }
        Preconditions.checkArgument(s.charAt(lastIndex + 1) == ':', "Only a colon may follow a close bracket: %s", s);
        for (int i = lastIndex + 2; i < s.length(); ++i) {
            Preconditions.checkArgument(Character.isDigit(s.charAt(i)), "Port must be numeric: %s", s);
        }
        return new String[] { substring, s.substring(lastIndex + 2) };
    }
    
    private static boolean isValidPort(final int n) {
        return n >= 0 && n <= 65535;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (this != o) {
            if (!(o instanceof HostAndPort)) {
                return false;
            }
            final HostAndPort hostAndPort = (HostAndPort)o;
            if (!Objects.equal(this.host, hostAndPort.host) || this.port != hostAndPort.port || this.hasBracketlessColons != hostAndPort.hasBracketlessColons) {
                return false;
            }
        }
        return true;
    }
    
    public String getHostText() {
        return this.host;
    }
    
    public int getPort() {
        Preconditions.checkState(this.hasPort());
        return this.port;
    }
    
    public int getPortOrDefault(int port) {
        if (this.hasPort()) {
            port = this.port;
        }
        return port;
    }
    
    public boolean hasPort() {
        return this.port >= 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.host, this.port, this.hasBracketlessColons);
    }
    
    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[').append(this.host).append(']');
        }
        else {
            sb.append(this.host);
        }
        if (this.hasPort()) {
            sb.append(':').append(this.port);
        }
        return sb.toString();
    }
    
    public HostAndPort withDefaultPort(final int n) {
        Preconditions.checkArgument(isValidPort(n));
        if (this.hasPort() || this.port == n) {
            return this;
        }
        return new HostAndPort(this.host, n, this.hasBracketlessColons);
    }
}
