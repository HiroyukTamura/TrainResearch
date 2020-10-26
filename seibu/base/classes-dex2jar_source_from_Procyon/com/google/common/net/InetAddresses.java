// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.net;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import com.google.common.hash.Hashing;
import java.nio.ByteBuffer;
import java.net.Inet6Address;
import com.google.common.primitives.Ints;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import com.google.common.io.ByteStreams;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.Inet4Address;
import com.google.common.annotations.Beta;

@Beta
public final class InetAddresses
{
    private static final Inet4Address ANY4;
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Inet4Address LOOPBACK4;
    
    static {
        LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
        ANY4 = (Inet4Address)forString("0.0.0.0");
    }
    
    private InetAddresses() {
    }
    
    private static InetAddress bytesToInetAddress(final byte[] addr) {
        try {
            return InetAddress.getByAddress(addr);
        }
        catch (UnknownHostException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    public static int coerceToInteger(final InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }
    
    private static void compressLongestRunOfZeroes(final int[] a) {
        int fromIndex = -1;
        int n = -1;
        int n2 = -1;
        int n3;
        int n4;
        int n5;
        for (int i = 0; i < a.length + 1; ++i, n = n3, fromIndex = n4, n2 = n5) {
            if (i < a.length && a[i] == 0) {
                n3 = n;
                n4 = fromIndex;
                if ((n5 = n2) < 0) {
                    n5 = i;
                    n4 = fromIndex;
                    n3 = n;
                }
            }
            else {
                n3 = n;
                n4 = fromIndex;
                if ((n5 = n2) >= 0) {
                    final int n6 = i - n2;
                    int n7;
                    if (n6 > (n7 = n)) {
                        n7 = n6;
                        fromIndex = n2;
                    }
                    final int n8 = -1;
                    n3 = n7;
                    n4 = fromIndex;
                    n5 = n8;
                }
            }
        }
        if (n >= 2) {
            Arrays.fill(a, fromIndex, fromIndex + n, -1);
        }
    }
    
    private static String convertDottedQuadToHex(String s) {
        final int lastIndex = s.lastIndexOf(58);
        final String substring = s.substring(0, lastIndex + 1);
        final byte[] textToNumericFormatV4 = textToNumericFormatV4(s.substring(lastIndex + 1));
        if (textToNumericFormatV4 == null) {
            return null;
        }
        s = Integer.toHexString((textToNumericFormatV4[0] & 0xFF) << 8 | (textToNumericFormatV4[1] & 0xFF));
        final String hexString = Integer.toHexString((textToNumericFormatV4[2] & 0xFF) << 8 | (textToNumericFormatV4[3] & 0xFF));
        final String value = String.valueOf(String.valueOf(substring));
        s = String.valueOf(String.valueOf(s));
        final String value2 = String.valueOf(String.valueOf(hexString));
        return new StringBuilder(value.length() + 1 + s.length() + value2.length()).append(value).append(s).append(":").append(value2).toString();
    }
    
    public static InetAddress decrement(final InetAddress inetAddress) {
        byte[] address;
        int n;
        for (address = inetAddress.getAddress(), n = address.length - 1; n >= 0 && address[n] == 0; --n) {
            address[n] = -1;
        }
        Preconditions.checkArgument(n >= 0, "Decrementing %s would wrap.", inetAddress);
        --address[n];
        return bytesToInetAddress(address);
    }
    
    public static InetAddress forString(final String s) {
        final byte[] ipStringToBytes = ipStringToBytes(s);
        if (ipStringToBytes == null) {
            throw new IllegalArgumentException(String.format("'%s' is not an IP string literal.", s));
        }
        return bytesToInetAddress(ipStringToBytes);
    }
    
    public static InetAddress forUriString(final String s) {
        Preconditions.checkNotNull(s);
        String substring;
        int n;
        if (s.startsWith("[") && s.endsWith("]")) {
            substring = s.substring(1, s.length() - 1);
            n = 16;
        }
        else {
            substring = s;
            n = 4;
        }
        final byte[] ipStringToBytes = ipStringToBytes(substring);
        if (ipStringToBytes == null || ipStringToBytes.length != n) {
            throw new IllegalArgumentException(String.format("Not a valid URI IP literal: '%s'", s));
        }
        return bytesToInetAddress(ipStringToBytes);
    }
    
    public static Inet4Address fromInteger(final int n) {
        return getInet4Address(Ints.toByteArray(n));
    }
    
    public static InetAddress fromLittleEndianByteArray(final byte[] array) throws UnknownHostException {
        final byte[] addr = new byte[array.length];
        for (int i = 0; i < array.length; ++i) {
            addr[i] = array[array.length - i - 1];
        }
        return InetAddress.getByAddress(addr);
    }
    
    public static Inet4Address get6to4IPv4Address(final Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }
    
    public static Inet4Address getCoercedIPv4Address(final InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address)inetAddress;
        }
        final byte[] address = inetAddress.getAddress();
        final int n = 1;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= 15) {
                break;
            }
            if (address[n2] != 0) {
                n3 = 0;
                break;
            }
            ++n2;
        }
        if (n3 != 0 && address[15] == 1) {
            return InetAddresses.LOOPBACK4;
        }
        if (n3 != 0 && address[15] == 0) {
            return InetAddresses.ANY4;
        }
        final Inet6Address inet6Address = (Inet6Address)inetAddress;
        long long1;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            long1 = getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        }
        else {
            long1 = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int n4;
        if ((n4 = (Hashing.murmur3_32().hashLong(long1).asInt() | 0xE0000000)) == -1) {
            n4 = -2;
        }
        return getInet4Address(Ints.toByteArray(n4));
    }
    
    public static Inet4Address getCompatIPv4Address(final Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }
    
    public static Inet4Address getEmbeddedIPv4ClientAddress(final Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw new IllegalArgumentException(String.format("'%s' has no embedded IPv4 address.", toAddrString(inet6Address)));
    }
    
    private static Inet4Address getInet4Address(final byte[] array) {
        Preconditions.checkArgument(array.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", array.length);
        return (Inet4Address)bytesToInetAddress(array);
    }
    
    public static Inet4Address getIsatapIPv4Address(final Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }
    
    public static TeredoInfo getTeredoInfo(final Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        final byte[] address = inet6Address.getAddress();
        final Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        final short short1 = ByteStreams.newDataInput(address, 8).readShort();
        final short short2 = ByteStreams.newDataInput(address, 10).readShort();
        final byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i = 0; i < copyOfRange.length; ++i) {
            copyOfRange[i] ^= -1;
        }
        return new TeredoInfo(inet4Address, getInet4Address(copyOfRange), ~short2 & 0xFFFF, short1 & 0xFFFF);
    }
    
    public static boolean hasEmbeddedIPv4ClientAddress(final Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }
    
    private static String hextetsToIPv6String(final int[] array) {
        final StringBuilder sb = new StringBuilder(39);
        int n = 0;
        boolean b;
        for (int i = 0; i < array.length; ++i, n = (b ? 1 : 0)) {
            if (array[i] >= 0) {
                b = true;
            }
            else {
                b = false;
            }
            if (b) {
                if (n != 0) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(array[i]));
            }
            else if (i == 0 || n != 0) {
                sb.append("::");
            }
        }
        return sb.toString();
    }
    
    public static InetAddress increment(final InetAddress inetAddress) {
        byte[] address;
        int n;
        for (address = inetAddress.getAddress(), n = address.length - 1; n >= 0 && address[n] == -1; --n) {
            address[n] = 0;
        }
        Preconditions.checkArgument(n >= 0, "Incrementing %s would wrap.", inetAddress);
        ++address[n];
        return bytesToInetAddress(address);
    }
    
    private static byte[] ipStringToBytes(final String s) {
        boolean b = false;
        boolean b2 = false;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '.') {
                b2 = true;
            }
            else if (char1 == ':') {
                if (b2) {
                    return null;
                }
                b = true;
            }
            else if (Character.digit(char1, 16) == -1) {
                return null;
            }
        }
        if (b) {
            String convertDottedQuadToHex = s;
            if (b2) {
                convertDottedQuadToHex = convertDottedQuadToHex(s);
                if (convertDottedQuadToHex == null) {
                    return null;
                }
            }
            return textToNumericFormatV6(convertDottedQuadToHex);
        }
        if (b2) {
            return textToNumericFormatV4(s);
        }
        return null;
    }
    
    public static boolean is6to4Address(final Inet6Address inet6Address) {
        final byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }
    
    public static boolean isCompatIPv4Address(final Inet6Address inet6Address) {
        if (inet6Address.isIPv4CompatibleAddress()) {
            final byte[] address = inet6Address.getAddress();
            if (address[12] != 0 || address[13] != 0 || address[14] != 0 || (address[15] != 0 && address[15] != 1)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isInetAddress(final String s) {
        return ipStringToBytes(s) != null;
    }
    
    public static boolean isIsatapAddress(final Inet6Address inet6Address) {
        if (!isTeredoAddress(inet6Address)) {
            final byte[] address = inet6Address.getAddress();
            if ((address[8] | 0x3) == 0x3 && address[9] == 0 && address[10] == 94 && address[11] == -2) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isMappedIPv4Address(final String s) {
        final byte[] ipStringToBytes = ipStringToBytes(s);
        if (ipStringToBytes != null && ipStringToBytes.length == 16) {
            for (int i = 0; i < 10; ++i) {
                if (ipStringToBytes[i] != 0) {
                    return false;
                }
            }
            for (int j = 10; j < 12; ++j) {
                if (ipStringToBytes[j] != -1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static boolean isMaximum(final InetAddress inetAddress) {
        final byte[] address = inetAddress.getAddress();
        for (int i = 0; i < address.length; ++i) {
            if (address[i] != -1) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isTeredoAddress(final Inet6Address inet6Address) {
        final byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }
    
    public static boolean isUriInetAddress(final String s) {
        try {
            forUriString(s);
            return true;
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
    }
    
    private static short parseHextet(final String s) {
        final int int1 = Integer.parseInt(s, 16);
        if (int1 > 65535) {
            throw new NumberFormatException();
        }
        return (short)int1;
    }
    
    private static byte parseOctet(final String s) {
        final int int1 = Integer.parseInt(s);
        if (int1 > 255 || (s.startsWith("0") && s.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte)int1;
    }
    
    private static byte[] textToNumericFormatV4(final String s) {
        final String[] split = s.split("\\.", 5);
        byte[] array;
        if (split.length != 4) {
            array = null;
        }
        else {
            final byte[] array2 = new byte[4];
            int n = 0;
            while (true) {
                array = array2;
                try {
                    if (n >= array2.length) {
                        break;
                    }
                    array2[n] = parseOctet(split[n]);
                    ++n;
                }
                catch (NumberFormatException ex) {
                    return null;
                }
            }
        }
        return array;
    }
    
    private static byte[] textToNumericFormatV6(final String s) {
        final String[] split = s.split(":", 10);
        if (split.length >= 3 && split.length <= 9) {
            int n = -1;
            int n2;
            for (int i = 1; i < split.length - 1; ++i, n = n2) {
                n2 = n;
                if (split[i].length() == 0) {
                    if (n >= 0) {
                        return null;
                    }
                    n2 = i;
                }
            }
            while (true) {
            Label_0185_Outer:
                while (true) {
                    int length = 0;
                    int n7 = 0;
                    Label_0151: {
                        int n9;
                        while (true) {
                            int n6 = 0;
                            Label_0125: {
                                final ByteBuffer allocate;
                                Label_0176: {
                                    if (n < 0) {
                                        break Label_0176;
                                    }
                                    final int n3 = n;
                                    final int n4 = split.length - n - 1;
                                    int n5 = n3;
                                    if (split[0].length() == 0) {
                                        n5 = n3 - 1;
                                        if (n5 != 0) {
                                            return null;
                                        }
                                    }
                                    length = n5;
                                    n6 = n4;
                                    if (split[split.length - 1].length() != 0) {
                                        break Label_0125;
                                    }
                                    n6 = n4 - 1;
                                    if (n6 == 0) {
                                        length = n5;
                                        break Label_0125;
                                    }
                                    return null;
                                Label_0212_Outer:
                                    while (true) {
                                        while (true) {
                                            try {
                                                allocate.putShort(parseHextet(split[n7]));
                                                ++n7;
                                                break Label_0151;
                                                while (true) {
                                                    allocate.putShort((short)0);
                                                    int n8 = n8 + 1;
                                                    Label_0193: {
                                                        break Label_0193;
                                                        n8 = 0;
                                                        break Label_0193;
                                                        while (true) {
                                                            allocate.putShort(parseHextet(split[split.length - n6]));
                                                            --n6;
                                                            continue Label_0212_Outer;
                                                        }
                                                        length = split.length;
                                                        n6 = 0;
                                                        break Label_0125;
                                                        return null;
                                                    }
                                                    continue Label_0212_Outer;
                                                }
                                            }
                                            // iftrue(Label_0241:, n6 <= 0)
                                            // iftrue(Label_0142:, n9 == 0)
                                            // iftrue(Label_0247:, n8 >= n9)
                                            catch (NumberFormatException ex) {
                                                return null;
                                            }
                                            break;
                                            Label_0247: {
                                                continue Label_0185_Outer;
                                            }
                                        }
                                    }
                                }
                                Label_0241: {
                                    return allocate.array();
                                }
                            }
                            n9 = 8 - (length + n6);
                            if (n < 0) {
                                continue;
                            }
                            break;
                        }
                        if (n9 < 1) {
                            return null;
                        }
                        Label_0142: {
                            final ByteBuffer allocate = ByteBuffer.allocate(16);
                        }
                        n7 = 0;
                    }
                    if (n7 < length) {
                        continue;
                    }
                    break;
                }
                continue;
            }
        }
        return null;
    }
    
    public static String toAddrString(final InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        final byte[] address = inetAddress.getAddress();
        final int[] array = new int[8];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Ints.fromBytes((byte)0, (byte)0, address[i * 2], address[i * 2 + 1]);
        }
        compressLongestRunOfZeroes(array);
        return hextetsToIPv6String(array);
    }
    
    public static String toUriString(final InetAddress inetAddress) {
        if (inetAddress instanceof Inet6Address) {
            final String value = String.valueOf(String.valueOf(toAddrString(inetAddress)));
            return new StringBuilder(value.length() + 2).append("[").append(value).append("]").toString();
        }
        return toAddrString(inetAddress);
    }
    
    @Beta
    public static final class TeredoInfo
    {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;
        
        public TeredoInfo(@Nullable final Inet4Address inet4Address, @Nullable final Inet4Address inet4Address2, final int n, final int n2) {
            Preconditions.checkArgument(n >= 0 && n <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", n);
            Preconditions.checkArgument(n2 >= 0 && n2 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", n2);
            this.server = MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = n;
            this.flags = n2;
        }
        
        public Inet4Address getClient() {
            return this.client;
        }
        
        public int getFlags() {
            return this.flags;
        }
        
        public int getPort() {
            return this.port;
        }
        
        public Inet4Address getServer() {
            return this.server;
        }
    }
}
