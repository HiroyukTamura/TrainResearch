// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.net;

import javax.annotation.Nullable;
import java.net.InetAddress;
import com.google.common.base.Preconditions;
import java.text.ParseException;
import com.google.common.annotations.Beta;

@Beta
public final class HostSpecifier
{
    private final String canonicalForm;
    
    private HostSpecifier(final String canonicalForm) {
        this.canonicalForm = canonicalForm;
    }
    
    public static HostSpecifier from(String s) throws ParseException {
        try {
            return fromValid(s);
        }
        catch (IllegalArgumentException cause) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "Invalid host specifier: ".concat(s);
            }
            else {
                s = new String("Invalid host specifier: ");
            }
            final ParseException ex = new ParseException(s, 0);
            ex.initCause(cause);
            throw ex;
        }
    }
    
    public static HostSpecifier fromValid(String s) {
        s = (String)HostAndPort.fromString(s);
        Label_0048: {
            if (((HostAndPort)s).hasPort()) {
                break Label_0048;
            }
            boolean b = true;
            while (true) {
                Preconditions.checkArgument(b);
                final String hostText = ((HostAndPort)s).getHostText();
                s = null;
                while (true) {
                    try {
                        s = (String)InetAddresses.forString(hostText);
                        if (s != null) {
                            return new HostSpecifier(InetAddresses.toUriString((InetAddress)s));
                        }
                        s = (String)InternetDomainName.from(hostText);
                        if (((InternetDomainName)s).hasPublicSuffix()) {
                            return new HostSpecifier(((InternetDomainName)s).toString());
                        }
                        s = String.valueOf(hostText);
                        if (s.length() != 0) {
                            s = "Domain name does not have a recognized public suffix: ".concat(s);
                        }
                        else {
                            s = new String("Domain name does not have a recognized public suffix: ");
                        }
                        throw new IllegalArgumentException(s);
                        b = false;
                    }
                    catch (IllegalArgumentException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public static boolean isValid(final String s) {
        try {
            fromValid(s);
            return true;
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return this == o || (o instanceof HostSpecifier && this.canonicalForm.equals(((HostSpecifier)o).canonicalForm));
    }
    
    @Override
    public int hashCode() {
        return this.canonicalForm.hashCode();
    }
    
    @Override
    public String toString() {
        return this.canonicalForm;
    }
}
