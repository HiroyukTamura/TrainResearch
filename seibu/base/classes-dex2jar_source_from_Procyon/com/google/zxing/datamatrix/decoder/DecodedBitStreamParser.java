// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.decoder;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Collection;
import com.google.zxing.FormatException;
import java.util.ArrayList;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;

final class DecodedBitStreamParser
{
    private static final char[] C40_BASIC_SET_CHARS;
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_BASIC_SET_CHARS;
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS;
    
    static {
        C40_BASIC_SET_CHARS = new char[] { '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        C40_SHIFT2_SET_CHARS = new char[] { '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_' };
        TEXT_BASIC_SET_CHARS = new char[] { '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        TEXT_SHIFT2_SET_CHARS = DecodedBitStreamParser.C40_SHIFT2_SET_CHARS;
        TEXT_SHIFT3_SET_CHARS = new char[] { '`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', '\u007f' };
    }
    
    private DecodedBitStreamParser() {
    }
    
    static DecoderResult decode(final byte[] array) throws FormatException {
        final BitSource bitSource = new BitSource(array);
        final StringBuilder sb = new StringBuilder(100);
        final StringBuilder s = new StringBuilder(0);
        final ArrayList<byte[]> list = new ArrayList<byte[]>(1);
        Mode mode = Mode.ASCII_ENCODE;
        while (true) {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, sb, s);
            }
            else {
                switch (mode) {
                    default: {
                        throw FormatException.getFormatInstance();
                    }
                    case C40_ENCODE: {
                        decodeC40Segment(bitSource, sb);
                        break;
                    }
                    case TEXT_ENCODE: {
                        decodeTextSegment(bitSource, sb);
                        break;
                    }
                    case ANSIX12_ENCODE: {
                        decodeAnsiX12Segment(bitSource, sb);
                        break;
                    }
                    case EDIFACT_ENCODE: {
                        decodeEdifactSegment(bitSource, sb);
                        break;
                    }
                    case BASE256_ENCODE: {
                        decodeBase256Segment(bitSource, sb, list);
                        break;
                    }
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode == Mode.PAD_ENCODE || bitSource.available() <= 0) {
                if (s.length() > 0) {
                    sb.append((CharSequence)s);
                }
                final String string = sb.toString();
                ArrayList<byte[]> list2 = list;
                if (list.isEmpty()) {
                    list2 = null;
                }
                return new DecoderResult(array, string, list2, null);
            }
        }
    }
    
    private static void decodeAnsiX12Segment(final BitSource bitSource, final StringBuilder sb) throws FormatException {
        final int[] array = new int[3];
        while (bitSource.available() != 8) {
            final int bits = bitSource.readBits(8);
            if (bits == 254) {
                break;
            }
            parseTwoBytes(bits, bitSource.readBits(8), array);
            for (int i = 0; i < 3; ++i) {
                final int n = array[i];
                switch (n) {
                    default: {
                        if (n < 14) {
                            sb.append((char)(n + 44));
                            break;
                        }
                        if (n < 40) {
                            sb.append((char)(n + 51));
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 0: {
                        sb.append('\r');
                        break;
                    }
                    case 1: {
                        sb.append('*');
                        break;
                    }
                    case 2: {
                        sb.append('>');
                        break;
                    }
                    case 3: {
                        sb.append(' ');
                        break;
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }
    
    private static Mode decodeAsciiSegment(final BitSource bitSource, final StringBuilder sb, final StringBuilder sb2) throws FormatException {
        int n = 0;
    Label_0221:
        while (true) {
            final int bits = bitSource.readBits(8);
            if (bits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (bits <= 128) {
                int n2 = bits;
                if (n != 0) {
                    n2 = bits + 128;
                }
                sb.append((char)(n2 - 1));
                return Mode.ASCII_ENCODE;
            }
            if (bits == 129) {
                return Mode.PAD_ENCODE;
            }
            int n3;
            if (bits <= 229) {
                final int i = bits - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
                n3 = n;
            }
            else {
                n3 = n;
                switch (bits) {
                    case 237: {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                        n3 = n;
                        break;
                    }
                    case 236: {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                        n3 = n;
                        break;
                    }
                    case 235: {
                        n3 = 1;
                        break;
                    }
                    case 232: {
                        sb.append('\u001d');
                        n3 = n;
                    }
                    case 233:
                    case 234:
                    case 241: {
                        break;
                    }
                    default: {
                        n3 = n;
                        if (bits < 242) {
                            break;
                        }
                        if (bits != 254) {
                            break Label_0221;
                        }
                        n3 = n;
                        if (bitSource.available() != 0) {
                            break Label_0221;
                        }
                        break;
                    }
                    case 230: {
                        return Mode.C40_ENCODE;
                    }
                    case 231: {
                        return Mode.BASE256_ENCODE;
                    }
                    case 238: {
                        return Mode.ANSIX12_ENCODE;
                    }
                    case 239: {
                        return Mode.TEXT_ENCODE;
                    }
                    case 240: {
                        return Mode.EDIFACT_ENCODE;
                    }
                }
            }
            n = n3;
            if (bitSource.available() <= 0) {
                return Mode.ASCII_ENCODE;
            }
        }
        throw FormatException.getFormatInstance();
    }
    
    private static void decodeBase256Segment(final BitSource bitSource, final StringBuilder sb, final Collection<byte[]> collection) throws FormatException {
        final int n = bitSource.getByteOffset() + 1;
        final int bits = bitSource.readBits(8);
        int n2 = n + 1;
        final int unrandomize255State = unrandomize255State(bits, n);
        int n3;
        if (unrandomize255State == 0) {
            n3 = bitSource.available() / 8;
        }
        else if (unrandomize255State < 250) {
            n3 = unrandomize255State;
        }
        else {
            final int bits2 = bitSource.readBits(8);
            final int n4 = n2 + 1;
            final int n5 = (unrandomize255State - 249) * 250 + unrandomize255State(bits2, n2);
            n2 = n4;
            n3 = n5;
        }
        if (n3 < 0) {
            throw FormatException.getFormatInstance();
        }
        final byte[] bytes = new byte[n3];
        for (int i = 0; i < n3; ++i, ++n2) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bytes[i] = (byte)unrandomize255State(bitSource.readBits(8), n2);
        }
        collection.add(bytes);
        try {
            sb.append(new String(bytes, "ISO8859_1"));
        }
        catch (UnsupportedEncodingException obj) {
            throw new IllegalStateException("Platform does not support required encoding: " + obj);
        }
    }
    
    private static void decodeC40Segment(final BitSource bitSource, final StringBuilder sb) throws FormatException {
        int n = 0;
        final int[] array = new int[3];
        int n2 = 0;
        while (bitSource.available() != 8) {
            final int bits = bitSource.readBits(8);
            if (bits == 254) {
                break;
            }
            parseTwoBytes(bits, bitSource.readBits(8), array);
            for (int i = 0; i < 3; ++i) {
                final int n3 = array[i];
                switch (n2) {
                    default: {
                        throw FormatException.getFormatInstance();
                    }
                    case 0: {
                        if (n3 < 3) {
                            n2 = n3 + 1;
                            break;
                        }
                        if (n3 >= DecodedBitStreamParser.C40_BASIC_SET_CHARS.length) {
                            throw FormatException.getFormatInstance();
                        }
                        final char c = DecodedBitStreamParser.C40_BASIC_SET_CHARS[n3];
                        if (n != 0) {
                            sb.append((char)(c + '\u0080'));
                            n = 0;
                            break;
                        }
                        sb.append(c);
                        break;
                    }
                    case 1: {
                        if (n != 0) {
                            sb.append((char)(n3 + 128));
                            n = 0;
                        }
                        else {
                            sb.append((char)n3);
                        }
                        n2 = 0;
                        break;
                    }
                    case 2: {
                        if (n3 < DecodedBitStreamParser.C40_SHIFT2_SET_CHARS.length) {
                            final char c2 = DecodedBitStreamParser.C40_SHIFT2_SET_CHARS[n3];
                            if (n != 0) {
                                sb.append((char)(c2 + '\u0080'));
                                n = 0;
                            }
                            else {
                                sb.append(c2);
                            }
                        }
                        else {
                            switch (n3) {
                                default: {
                                    throw FormatException.getFormatInstance();
                                }
                                case 27: {
                                    sb.append('\u001d');
                                    break;
                                }
                                case 30: {
                                    n = 1;
                                    break;
                                }
                            }
                        }
                        n2 = 0;
                        break;
                    }
                    case 3: {
                        if (n != 0) {
                            sb.append((char)(n3 + 224));
                            n = 0;
                        }
                        else {
                            sb.append((char)(n3 + 96));
                        }
                        n2 = 0;
                        break;
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }
    
    private static void decodeEdifactSegment(final BitSource bitSource, final StringBuilder sb) {
    Label_0009:
        while (bitSource.available() > 16) {
            int i = 0;
            while (i < 4) {
                final int bits = bitSource.readBits(6);
                if (bits == 31) {
                    final int n = 8 - bitSource.getBitOffset();
                    if (n != 8) {
                        bitSource.readBits(n);
                        return;
                    }
                    break Label_0009;
                }
                else {
                    int n2 = bits;
                    if ((bits & 0x20) == 0x0) {
                        n2 = (bits | 0x40);
                    }
                    sb.append((char)n2);
                    ++i;
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }
    
    private static void decodeTextSegment(final BitSource bitSource, final StringBuilder sb) throws FormatException {
        int n = 0;
        final int[] array = new int[3];
        int n2 = 0;
        while (bitSource.available() != 8) {
            final int bits = bitSource.readBits(8);
            if (bits == 254) {
                break;
            }
            parseTwoBytes(bits, bitSource.readBits(8), array);
            for (int i = 0; i < 3; ++i) {
                final int n3 = array[i];
                switch (n2) {
                    default: {
                        throw FormatException.getFormatInstance();
                    }
                    case 0: {
                        if (n3 < 3) {
                            n2 = n3 + 1;
                            break;
                        }
                        if (n3 >= DecodedBitStreamParser.TEXT_BASIC_SET_CHARS.length) {
                            throw FormatException.getFormatInstance();
                        }
                        final char c = DecodedBitStreamParser.TEXT_BASIC_SET_CHARS[n3];
                        if (n != 0) {
                            sb.append((char)(c + '\u0080'));
                            n = 0;
                            break;
                        }
                        sb.append(c);
                        break;
                    }
                    case 1: {
                        if (n != 0) {
                            sb.append((char)(n3 + 128));
                            n = 0;
                        }
                        else {
                            sb.append((char)n3);
                        }
                        n2 = 0;
                        break;
                    }
                    case 2: {
                        if (n3 < DecodedBitStreamParser.TEXT_SHIFT2_SET_CHARS.length) {
                            final char c2 = DecodedBitStreamParser.TEXT_SHIFT2_SET_CHARS[n3];
                            if (n != 0) {
                                sb.append((char)(c2 + '\u0080'));
                                n = 0;
                            }
                            else {
                                sb.append(c2);
                            }
                        }
                        else {
                            switch (n3) {
                                default: {
                                    throw FormatException.getFormatInstance();
                                }
                                case 27: {
                                    sb.append('\u001d');
                                    break;
                                }
                                case 30: {
                                    n = 1;
                                    break;
                                }
                            }
                        }
                        n2 = 0;
                        break;
                    }
                    case 3: {
                        if (n3 < DecodedBitStreamParser.TEXT_SHIFT3_SET_CHARS.length) {
                            final char c3 = DecodedBitStreamParser.TEXT_SHIFT3_SET_CHARS[n3];
                            if (n != 0) {
                                sb.append((char)(c3 + '\u0080'));
                                n = 0;
                            }
                            else {
                                sb.append(c3);
                            }
                            n2 = 0;
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }
    
    private static void parseTwoBytes(int n, int n2, final int[] array) {
        n = (n << 8) + n2 - 1;
        n2 = n / 1600;
        array[0] = n2;
        n -= n2 * 1600;
        n2 = n / 40;
        array[2] = n - (array[1] = n2) * 40;
    }
    
    private static int unrandomize255State(int n, final int n2) {
        n -= n2 * 149 % 255 + 1;
        if (n >= 0) {
            return n;
        }
        return n + 256;
    }
    
    private enum Mode
    {
        ANSIX12_ENCODE, 
        ASCII_ENCODE, 
        BASE256_ENCODE, 
        C40_ENCODE, 
        EDIFACT_ENCODE, 
        PAD_ENCODE, 
        TEXT_ENCODE;
    }
}
