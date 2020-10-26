// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

import java.io.UnsupportedEncodingException;
import com.google.zxing.common.StringUtils;
import java.util.List;
import java.util.Collection;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.FormatException;
import java.util.ArrayList;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.DecodeHintType;
import java.util.Map;

final class DecodedBitStreamParser
{
    private static final char[] ALPHANUMERIC_CHARS;
    private static final int GB2312_SUBSET = 1;
    
    static {
        ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    }
    
    private DecodedBitStreamParser() {
    }
    
    static DecoderResult decode(final byte[] array, final Version version, final ErrorCorrectionLevel errorCorrectionLevel, final Map<DecodeHintType, ?> map) throws FormatException {
        final BitSource bitSource = new BitSource(array);
        final StringBuilder sb = new StringBuilder(50);
        final ArrayList<byte[]> list = new ArrayList<byte[]>(1);
        int n = -1;
        int n2 = -1;
        CharacterSetECI characterSetECI = null;
        boolean b = false;
        Mode mode = null;
        CharacterSetECI characterSetECIByValue;
        int bits;
        int bits2;
        boolean b2;
        int bits3;
        Mode terminator;
        String string;
        List<byte[]> list2;
        String string2;
        int bits4;
        int bits5;
        Label_0057_Outer:Label_0195_Outer:
        while (true) {
        Label_0195:
            while (true) {
            Label_0120_Outer:
                while (true) {
                    while (true) {
                        Label_0545: {
                            Label_0341: {
                                Label_0306: {
                                    Label_0263: {
                                        while (true) {
                                            Label_0181: {
                                                try {
                                                    if (bitSource.available() >= 4) {
                                                        break Label_0181;
                                                    }
                                                    mode = Mode.TERMINATOR;
                                                    characterSetECIByValue = characterSetECI;
                                                    bits = n;
                                                    bits2 = n2;
                                                    b2 = b;
                                                    switch (mode) {
                                                        case TERMINATOR: {
                                                            break Label_0195;
                                                        }
                                                        case STRUCTURED_APPEND: {
                                                            break Label_0263;
                                                        }
                                                        case ECI: {
                                                            break Label_0306;
                                                        }
                                                        case HANZI: {
                                                            break Label_0341;
                                                        }
                                                        default: {
                                                            break Label_0545;
                                                        }
                                                        case FNC1_FIRST_POSITION:
                                                        case FNC1_SECOND_POSITION: {
                                                            break Label_0120_Outer;
                                                        }
                                                    }
                                                    throw FormatException.getFormatInstance();
                                                    bits3 = bitSource.readBits(mode.getCharacterCountBits(version));
                                                }
                                                // switch([Lcom.strobel.decompiler.ast.Label;@2370c1a1, DecodedBitStreamParser$1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()])
                                                catch (IllegalArgumentException ex) {
                                                    throw FormatException.getFormatInstance();
                                                }
                                            }
                                            mode = Mode.forBits(bitSource.readBits(4));
                                            continue Label_0195_Outer;
                                        }
                                        terminator = Mode.TERMINATOR;
                                        characterSetECI = characterSetECIByValue;
                                        n = bits;
                                        n2 = bits2;
                                        b = b2;
                                        if (mode == terminator) {
                                            string = sb.toString();
                                            if (list.isEmpty()) {
                                                list2 = null;
                                            }
                                            else {
                                                list2 = list;
                                            }
                                            if (errorCorrectionLevel == null) {
                                                string2 = null;
                                            }
                                            else {
                                                string2 = errorCorrectionLevel.toString();
                                            }
                                            return new DecoderResult(array, string, list2, string2, bits, bits2);
                                        }
                                        continue Label_0057_Outer;
                                    }
                                    if (bitSource.available() < 16) {
                                        throw FormatException.getFormatInstance();
                                    }
                                    bits = bitSource.readBits(8);
                                    bits2 = bitSource.readBits(8);
                                    characterSetECIByValue = characterSetECI;
                                    b2 = b;
                                    continue Label_0195;
                                }
                                characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                                bits = n;
                                bits2 = n2;
                                b2 = b;
                                if (characterSetECIByValue == null) {
                                    throw FormatException.getFormatInstance();
                                }
                                continue Label_0195;
                            }
                            bits4 = bitSource.readBits(4);
                            bits5 = bitSource.readBits(mode.getCharacterCountBits(version));
                            characterSetECIByValue = characterSetECI;
                            bits = n;
                            bits2 = n2;
                            b2 = b;
                            if (bits4 == 1) {
                                decodeHanziSegment(bitSource, sb, bits5);
                                characterSetECIByValue = characterSetECI;
                                bits = n;
                                bits2 = n2;
                                b2 = b;
                            }
                            continue Label_0195;
                            Label_0412: {
                                decodeNumericSegment(bitSource, sb, bits3);
                            }
                            characterSetECIByValue = characterSetECI;
                            bits = n;
                            bits2 = n2;
                            b2 = b;
                            continue Label_0195;
                            Label_0440:
                            decodeAlphanumericSegment(bitSource, sb, bits3, b);
                            characterSetECIByValue = characterSetECI;
                            bits = n;
                            bits2 = n2;
                            b2 = b;
                            continue Label_0195;
                            Label_0470:
                            decodeByteSegment(bitSource, sb, bits3, characterSetECI, list, map);
                            characterSetECIByValue = characterSetECI;
                            bits = n;
                            bits2 = n2;
                            b2 = b;
                            continue Label_0195;
                            Label_0503:
                            decodeKanjiSegment(bitSource, sb, bits3);
                            characterSetECIByValue = characterSetECI;
                            bits = n;
                            bits2 = n2;
                            b2 = b;
                            continue Label_0195;
                        }
                        continue;
                    }
                    Label_0548: {
                        continue Label_0120_Outer;
                    }
                }
                b2 = true;
                characterSetECIByValue = characterSetECI;
                bits = n;
                bits2 = n2;
                continue Label_0195;
            }
        }
    }
    
    private static void decodeAlphanumericSegment(final BitSource bitSource, final StringBuilder sb, int i, final boolean b) throws FormatException {
        final int length = sb.length();
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            final int bits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(bits / 45));
            sb.append(toAlphaNumericChar(bits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (b) {
            for (i = length; i < sb.length(); ++i) {
                if (sb.charAt(i) == '%') {
                    if (i < sb.length() - 1 && sb.charAt(i + 1) == '%') {
                        sb.deleteCharAt(i + 1);
                    }
                    else {
                        sb.setCharAt(i, '\u001d');
                    }
                }
            }
        }
    }
    
    private static void decodeByteSegment(final BitSource bitSource, final StringBuilder sb, final int n, final CharacterSetECI characterSetECI, final Collection<byte[]> collection, final Map<DecodeHintType, ?> map) throws FormatException {
        if (n << 3 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        final byte[] bytes = new byte[n];
        for (int i = 0; i < n; ++i) {
            bytes[i] = (byte)bitSource.readBits(8);
        }
        Label_0087: {
            if (characterSetECI != null) {
                break Label_0087;
            }
            String charsetName = StringUtils.guessEncoding(bytes, map);
            try {
                while (true) {
                    sb.append(new String(bytes, charsetName));
                    collection.add(bytes);
                    return;
                    charsetName = characterSetECI.name();
                    continue;
                }
            }
            catch (UnsupportedEncodingException ex) {
                throw FormatException.getFormatInstance();
            }
        }
    }
    
    private static void decodeHanziSegment(final BitSource bitSource, final StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        final byte[] bytes = new byte[i * 2];
        int n = 0;
        while (i > 0) {
            final int bits = bitSource.readBits(13);
            final int n2 = bits / 96 << 8 | bits % 96;
            int n3;
            if (n2 < 959) {
                n3 = n2 + 41377;
            }
            else {
                n3 = n2 + 42657;
            }
            bytes[n] = (byte)(n3 >> 8);
            bytes[n + 1] = (byte)n3;
            n += 2;
            --i;
        }
        try {
            sb.append(new String(bytes, "GB2312"));
        }
        catch (UnsupportedEncodingException ex) {
            throw FormatException.getFormatInstance();
        }
    }
    
    private static void decodeKanjiSegment(final BitSource bitSource, final StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        final byte[] bytes = new byte[i * 2];
        int n = 0;
        while (i > 0) {
            final int bits = bitSource.readBits(13);
            final int n2 = bits / 192 << 8 | bits % 192;
            int n3;
            if (n2 < 7936) {
                n3 = n2 + 33088;
            }
            else {
                n3 = n2 + 49472;
            }
            bytes[n] = (byte)(n3 >> 8);
            bytes[n + 1] = (byte)n3;
            n += 2;
            --i;
        }
        try {
            sb.append(new String(bytes, "SJIS"));
        }
        catch (UnsupportedEncodingException ex) {
            throw FormatException.getFormatInstance();
        }
    }
    
    private static void decodeNumericSegment(final BitSource bitSource, final StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            final int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar(bits / 10 % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            i = bitSource.readBits(7);
            if (i >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(i / 10));
            sb.append(toAlphaNumericChar(i % 10));
        }
        else if (i == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            i = bitSource.readBits(4);
            if (i >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(i));
        }
    }
    
    private static int parseECIValue(final BitSource bitSource) throws FormatException {
        final int bits = bitSource.readBits(8);
        if ((bits & 0x80) == 0x0) {
            return bits & 0x7F;
        }
        if ((bits & 0xC0) == 0x80) {
            return (bits & 0x3F) << 8 | bitSource.readBits(8);
        }
        if ((bits & 0xE0) == 0xC0) {
            return (bits & 0x1F) << 16 | bitSource.readBits(16);
        }
        throw FormatException.getFormatInstance();
    }
    
    private static char toAlphaNumericChar(final int n) throws FormatException {
        if (n >= DecodedBitStreamParser.ALPHANUMERIC_CHARS.length) {
            throw FormatException.getFormatInstance();
        }
        return DecodedBitStreamParser.ALPHANUMERIC_CHARS[n];
    }
}
