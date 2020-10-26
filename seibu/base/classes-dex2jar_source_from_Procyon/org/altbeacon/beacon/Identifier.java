// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.beacon;

import java.nio.LongBuffer;
import java.nio.ByteBuffer;
import java.util.UUID;
import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.io.Serializable;

public class Identifier implements Comparable<Identifier>, Serializable
{
    private static final Pattern DECIMAL_PATTERN;
    private static final char[] HEX_DIGITS;
    private static final Pattern HEX_PATTERN;
    private static final Pattern HEX_PATTERN_NO_PREFIX;
    private static final int MAX_INTEGER = 65535;
    private static final Pattern UUID_PATTERN;
    private final byte[] mValue;
    
    static {
        HEX_PATTERN = Pattern.compile("^0x[0-9A-Fa-f]*$");
        HEX_PATTERN_NO_PREFIX = Pattern.compile("^[0-9A-Fa-f]*$");
        DECIMAL_PATTERN = Pattern.compile("^0|[1-9][0-9]*$");
        UUID_PATTERN = Pattern.compile("^[0-9A-Fa-f]{8}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{12}$");
        HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    
    @Deprecated
    public Identifier(final Identifier identifier) {
        if (identifier == null) {
            throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"identifier\" is null.");
        }
        this.mValue = identifier.mValue;
    }
    
    protected Identifier(final byte[] mValue) {
        if (mValue == null) {
            throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"value\" is null.");
        }
        this.mValue = mValue;
    }
    
    @TargetApi(9)
    public static Identifier fromBytes(byte[] copyOfRange, final int from, final int to, final boolean b) {
        if (copyOfRange == null) {
            throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"bytes\" is null.");
        }
        if (from < 0 || from > copyOfRange.length) {
            throw new ArrayIndexOutOfBoundsException("start < 0 || start > bytes.length");
        }
        if (to > copyOfRange.length) {
            throw new ArrayIndexOutOfBoundsException("end > bytes.length");
        }
        if (from > to) {
            throw new IllegalArgumentException("start > end");
        }
        copyOfRange = Arrays.copyOfRange(copyOfRange, from, to);
        if (b) {
            reverseArray(copyOfRange);
        }
        return new Identifier(copyOfRange);
    }
    
    public static Identifier fromInt(final int n) {
        if (n < 0 || n > 65535) {
            throw new IllegalArgumentException("Identifiers can only be constructed from integers between 0 and 65535 (inclusive).");
        }
        return new Identifier(new byte[] { (byte)(n >> 8), (byte)n });
    }
    
    public static Identifier fromLong(long n, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Identifier length must be > 0.");
        }
        final byte[] array = new byte[i];
        for (--i; i >= 0; --i) {
            array[i] = (byte)(0xFFL & n);
            n >>= 8;
        }
        return new Identifier(array);
    }
    
    public static Identifier fromUuid(final UUID uuid) {
        final ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        return new Identifier(allocate.array());
    }
    
    public static Identifier parse(final String s) {
        return parse(s, -1);
    }
    
    public static Identifier parse(final String input, final int n) {
        if (input == null) {
            throw new NullPointerException("Identifiers cannot be constructed from null pointers but \"stringValue\" is null.");
        }
        if (Identifier.HEX_PATTERN.matcher(input).matches()) {
            return parseHex(input.substring(2), n);
        }
        if (Identifier.UUID_PATTERN.matcher(input).matches()) {
            return parseHex(input.replace("-", ""), n);
        }
        if (Identifier.DECIMAL_PATTERN.matcher(input).matches()) {
            int intValue;
            try {
                intValue = Integer.valueOf(input);
                if (n <= 0 || n == 2) {
                    return fromInt(intValue);
                }
            }
            catch (Throwable cause) {
                throw new IllegalArgumentException("Unable to parse Identifier in decimal format.", cause);
            }
            return fromLong(intValue, n);
        }
        if (Identifier.HEX_PATTERN_NO_PREFIX.matcher(input).matches()) {
            return parseHex(input, n);
        }
        throw new IllegalArgumentException("Unable to parse Identifier.");
    }
    
    private static Identifier parseHex(String str, int i) {
        String str2;
        if (str.length() % 2 == 0) {
            str2 = "";
        }
        else {
            str2 = "0";
        }
        final String s = str = str2 + str.toUpperCase();
        if (i > 0) {
            str = s;
            if (i < s.length() / 2) {
                str = s.substring(s.length() - i * 2);
            }
        }
        String string = str;
        if (i > 0) {
            string = str;
            if (i > str.length() / 2) {
                final int length = str.length();
                final StringBuilder sb = new StringBuilder();
                while (sb.length() < i * 2 - length) {
                    sb.append("0");
                }
                string = sb.toString() + str;
            }
        }
        byte[] array;
        for (array = new byte[string.length() / 2], i = 0; i < array.length; ++i) {
            array[i] = (byte)(Integer.parseInt(string.substring(i * 2, i * 2 + 2), 16) & 0xFF);
        }
        return new Identifier(array);
    }
    
    private static void reverseArray(final byte[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            final int n = array.length - i - 1;
            final byte b = array[i];
            array[i] = array[n];
            array[n] = b;
        }
    }
    
    @Override
    public int compareTo(final Identifier identifier) {
        if (this.mValue.length == identifier.mValue.length) {
            int i = 0;
            while (i < this.mValue.length) {
                if (this.mValue[i] != identifier.mValue[i]) {
                    if (this.mValue[i] >= identifier.mValue[i]) {
                        return 1;
                    }
                    return -1;
                }
                else {
                    ++i;
                }
            }
            return 0;
        }
        if (this.mValue.length >= identifier.mValue.length) {
            return 1;
        }
        return -1;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Identifier && Arrays.equals(this.mValue, ((Identifier)o).mValue);
    }
    
    public int getByteCount() {
        return this.mValue.length;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.mValue);
    }
    
    public byte[] toByteArray() {
        return this.mValue.clone();
    }
    
    @TargetApi(9)
    public byte[] toByteArrayOfSpecifiedEndianness(final boolean b) {
        final byte[] copy = Arrays.copyOf(this.mValue, this.mValue.length);
        if (!b) {
            reverseArray(copy);
        }
        return copy;
    }
    
    public String toHexString() {
        final int length = this.mValue.length;
        final char[] value = new char[length * 2 + 2];
        value[0] = '0';
        value[1] = 'x';
        int i = 0;
        int n = 2;
        while (i < length) {
            final int n2 = n + 1;
            value[n] = Identifier.HEX_DIGITS[(this.mValue[i] & 0xF0) >>> 4];
            n = n2 + 1;
            value[n2] = Identifier.HEX_DIGITS[this.mValue[i] & 0xF];
            ++i;
        }
        return new String(value);
    }
    
    public int toInt() {
        if (this.mValue.length > 2) {
            throw new UnsupportedOperationException("Only supported for Identifiers with max byte length of 2");
        }
        int n = 0;
        for (int i = 0; i < this.mValue.length; ++i) {
            n |= (this.mValue[i] & 0xFF) << (this.mValue.length - i - 1) * 8;
        }
        return n;
    }
    
    @Override
    public String toString() {
        if (this.mValue.length == 2) {
            return Integer.toString(this.toInt());
        }
        if (this.mValue.length == 16) {
            return this.toUuid().toString();
        }
        return this.toHexString();
    }
    
    public UUID toUuid() {
        if (this.mValue.length != 16) {
            throw new UnsupportedOperationException("Only Identifiers backed by a byte array with length of exactly 16 can be UUIDs.");
        }
        final LongBuffer longBuffer = ByteBuffer.wrap(this.mValue).asLongBuffer();
        return new UUID(longBuffer.get(), longBuffer.get());
    }
    
    @Deprecated
    public String toUuidString() {
        return this.toUuid().toString();
    }
}
