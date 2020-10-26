// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.encoder;

import java.util.Iterator;
import java.util.ArrayList;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;

public final class Encoder
{
    private static final int[] ALPHANUMERIC_TABLE;
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";
    
    static {
        ALPHANUMERIC_TABLE = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
    }
    
    private Encoder() {
    }
    
    static void append8BitBytes(final String s, final BitArray bitArray, final String charsetName) throws WriterException {
        try {
            final byte[] bytes = s.getBytes(charsetName);
            for (int length = bytes.length, i = 0; i < length; ++i) {
                bitArray.appendBits(bytes[i], 8);
            }
        }
        catch (UnsupportedEncodingException ex) {
            throw new WriterException(ex);
        }
    }
    
    static void appendAlphanumericBytes(final CharSequence charSequence, final BitArray bitArray) throws WriterException {
        final int length = charSequence.length();
        int i = 0;
        while (i < length) {
            final int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            if (i + 1 < length) {
                final int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i + 1));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits(alphanumericCode * 45 + alphanumericCode2, 11);
                i += 2;
            }
            else {
                bitArray.appendBits(alphanumericCode, 6);
                ++i;
            }
        }
    }
    
    static void appendBytes(final String s, final Mode obj, final BitArray bitArray, final String s2) throws WriterException {
        switch (obj) {
            default: {
                throw new WriterException("Invalid mode: " + obj);
            }
            case NUMERIC: {
                appendNumericBytes(s, bitArray);
            }
            case ALPHANUMERIC: {
                appendAlphanumericBytes(s, bitArray);
            }
            case BYTE: {
                append8BitBytes(s, bitArray, s2);
            }
            case KANJI: {
                appendKanjiBytes(s, bitArray);
            }
        }
    }
    
    private static void appendECI(final CharacterSetECI characterSetECI, final BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }
    
    static void appendKanjiBytes(final String s, final BitArray bitArray) throws WriterException {
        while (true) {
        Label_0064_Outer:
            while (true) {
                int n = 0;
                int n4 = 0;
            Label_0118:
                while (true) {
                    int n2;
                    int n3;
                    try {
                        final byte[] bytes = s.getBytes("Shift_JIS");
                        final int length = bytes.length;
                        n = 0;
                        if (n >= length) {
                            break;
                        }
                        n2 = ((bytes[n] & 0xFF) << 8 | (bytes[n + 1] & 0xFF));
                        n3 = -1;
                        if (n2 >= 33088 && n2 <= 40956) {
                            n4 = n2 - 33088;
                            if (n4 == -1) {
                                throw new WriterException("Invalid byte sequence");
                            }
                            break Label_0118;
                        }
                    }
                    catch (UnsupportedEncodingException ex) {
                        throw new WriterException(ex);
                    }
                    n4 = n3;
                    if (n2 < 57408) {
                        continue;
                    }
                    n4 = n3;
                    if (n2 <= 60351) {
                        n4 = n2 - 49472;
                        continue;
                    }
                    continue;
                }
                bitArray.appendBits((n4 >> 8) * 192 + (n4 & 0xFF), 13);
                n += 2;
                continue Label_0064_Outer;
            }
        }
    }
    
    static void appendLengthInfo(final int i, final Version version, final Mode mode, final BitArray bitArray) throws WriterException {
        final int characterCountBits = mode.getCharacterCountBits(version);
        if (i >= 1 << characterCountBits) {
            throw new WriterException(i + " is bigger than " + ((1 << characterCountBits) - 1));
        }
        bitArray.appendBits(i, characterCountBits);
    }
    
    static void appendModeInfo(final Mode mode, final BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }
    
    static void appendNumericBytes(final CharSequence charSequence, final BitArray bitArray) {
        final int length = charSequence.length();
        int i = 0;
        while (i < length) {
            final int n = charSequence.charAt(i) - '0';
            if (i + 2 < length) {
                bitArray.appendBits(n * 100 + (charSequence.charAt(i + 1) - '0') * 10 + (charSequence.charAt(i + 2) - '0'), 10);
                i += 3;
            }
            else if (i + 1 < length) {
                bitArray.appendBits(n * 10 + (charSequence.charAt(i + 1) - '0'), 7);
                i += 2;
            }
            else {
                bitArray.appendBits(n, 4);
                ++i;
            }
        }
    }
    
    private static int calculateBitsNeeded(final Mode mode, final BitArray bitArray, final BitArray bitArray2, final Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }
    
    private static int calculateMaskPenalty(final ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }
    
    private static int chooseMaskPattern(final BitArray bitArray, final ErrorCorrectionLevel errorCorrectionLevel, final Version version, final ByteMatrix byteMatrix) throws WriterException {
        int n = Integer.MAX_VALUE;
        int n2 = -1;
        int n3;
        for (int i = 0; i < 8; ++i, n = n3) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i, byteMatrix);
            final int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < (n3 = n)) {
                n3 = calculateMaskPenalty;
                n2 = i;
            }
        }
        return n2;
    }
    
    public static Mode chooseMode(final String s) {
        return chooseMode(s, null);
    }
    
    private static Mode chooseMode(final String s, final String anObject) {
        if ("Shift_JIS".equals(anObject) && isOnlyDoubleByteKanji(s)) {
            return Mode.KANJI;
        }
        boolean b = false;
        boolean b2 = false;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= '0' && char1 <= '9') {
                b = true;
            }
            else {
                if (getAlphanumericCode(char1) == -1) {
                    return Mode.BYTE;
                }
                b2 = true;
            }
        }
        if (b2) {
            return Mode.ALPHANUMERIC;
        }
        if (b) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }
    
    private static Version chooseVersion(final int n, final ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i = 1; i <= 40; ++i) {
            final Version versionForNumber = Version.getVersionForNumber(i);
            if (willFit(n, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }
    
    public static QRCode encode(final String s, final ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(s, errorCorrectionLevel, null);
    }
    
    public static QRCode encode(final String s, final ErrorCorrectionLevel ecLevel, final Map<EncodeHintType, ?> map) throws WriterException {
        String string = "ISO-8859-1";
        boolean b;
        if (map != null && map.containsKey(EncodeHintType.CHARACTER_SET)) {
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            string = map.get(EncodeHintType.CHARACTER_SET).toString();
        }
        final Mode chooseMode = chooseMode(s, string);
        final BitArray bitArray = new BitArray();
        if (chooseMode == Mode.BYTE && (b || !"ISO-8859-1".equals(string))) {
            final CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(string);
            if (characterSetECIByName != null) {
                appendECI(characterSetECIByName, bitArray);
            }
        }
        int n;
        if (map != null && map.containsKey(EncodeHintType.GS1_FORMAT)) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0 && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString())) {
            appendModeInfo(Mode.FNC1_FIRST_POSITION, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        final BitArray bitArray2 = new BitArray();
        appendBytes(s, chooseMode, bitArray2, string);
        Version version2;
        if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
            final Version version = version2 = Version.getVersionForNumber(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, version), version, ecLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        else {
            version2 = recommendVersion(ecLevel, chooseMode, bitArray, bitArray2);
        }
        final BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        int n2;
        if (chooseMode == Mode.BYTE) {
            n2 = bitArray2.getSizeInBytes();
        }
        else {
            n2 = s.length();
        }
        appendLengthInfo(n2, version2, chooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        final Version.ECBlocks ecBlocksForLevel = version2.getECBlocksForLevel(ecLevel);
        final int n3 = version2.getTotalCodewords() - ecBlocksForLevel.getTotalECCodewords();
        terminateBits(n3, bitArray3);
        final BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, version2.getTotalCodewords(), n3, ecBlocksForLevel.getNumBlocks());
        final QRCode qrCode = new QRCode();
        qrCode.setECLevel(ecLevel);
        qrCode.setMode(chooseMode);
        qrCode.setVersion(version2);
        final int dimensionForVersion = version2.getDimensionForVersion();
        final ByteMatrix matrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        final int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, ecLevel, version2, matrix);
        qrCode.setMaskPattern(chooseMaskPattern);
        MatrixUtil.buildMatrix(interleaveWithECBytes, ecLevel, version2, chooseMaskPattern, matrix);
        qrCode.setMatrix(matrix);
        return qrCode;
    }
    
    static byte[] generateECBytes(byte[] array, final int n) {
        final int length = array.length;
        final int[] array2 = new int[length + n];
        for (int i = 0; i < length; ++i) {
            array2[i] = (array[i] & 0xFF);
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(array2, n);
        array = new byte[n];
        for (int j = 0; j < n; ++j) {
            array[j] = (byte)array2[length + j];
        }
        return array;
    }
    
    static int getAlphanumericCode(final int n) {
        if (n < Encoder.ALPHANUMERIC_TABLE.length) {
            return Encoder.ALPHANUMERIC_TABLE[n];
        }
        return -1;
    }
    
    static void getNumDataBytesAndNumECBytesForBlockID(final int n, int n2, final int n3, final int n4, final int[] array, final int[] array2) throws WriterException {
        if (n4 >= n3) {
            throw new WriterException("Block ID too large");
        }
        final int n5 = n % n3;
        final int n6 = n3 - n5;
        final int n7 = n / n3;
        n2 /= n3;
        final int n8 = n2 + 1;
        final int n9 = n7 - n2;
        final int n10 = n7 + 1 - n8;
        if (n9 != n10) {
            throw new WriterException("EC bytes mismatch");
        }
        if (n3 != n6 + n5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (n != (n2 + n9) * n6 + (n8 + n10) * n5) {
            throw new WriterException("Total bytes mismatch");
        }
        if (n4 < n6) {
            array[0] = n2;
            array2[0] = n9;
            return;
        }
        array[0] = n8;
        array2[0] = n10;
    }
    
    static BitArray interleaveWithECBytes(final BitArray bitArray, final int i, int j, final int initialCapacity) throws WriterException {
        if (bitArray.getSizeInBytes() != j) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        int n = 0;
        int max = 0;
        int max2 = 0;
        final ArrayList<BlockPair> list = new ArrayList<BlockPair>(initialCapacity);
        for (int k = 0; k < initialCapacity; ++k) {
            final int[] array = { 0 };
            final int[] array2 = { 0 };
            getNumDataBytesAndNumECBytesForBlockID(i, j, initialCapacity, k, array, array2);
            final int b = array[0];
            final byte[] array3 = new byte[b];
            bitArray.toBytes(n << 3, array3, 0, b);
            final byte[] generateECBytes = generateECBytes(array3, array2[0]);
            list.add(new BlockPair(array3, generateECBytes));
            max = Math.max(max, b);
            max2 = Math.max(max2, generateECBytes.length);
            n += array[0];
        }
        if (j != n) {
            throw new WriterException("Data bytes does not match offset");
        }
        final BitArray bitArray2 = new BitArray();
        Iterator<Object> iterator;
        byte[] dataBytes;
        for (j = 0; j < max; ++j) {
            iterator = list.iterator();
            while (iterator.hasNext()) {
                dataBytes = iterator.next().getDataBytes();
                if (j < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[j], 8);
                }
            }
        }
        Iterator<Object> iterator2;
        byte[] errorCorrectionBytes;
        for (j = 0; j < max2; ++j) {
            iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                errorCorrectionBytes = iterator2.next().getErrorCorrectionBytes();
                if (j < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[j], 8);
                }
            }
        }
        if (i != bitArray2.getSizeInBytes()) {
            throw new WriterException("Interleaving error: " + i + " and " + bitArray2.getSizeInBytes() + " differ.");
        }
        return bitArray2;
    }
    
    private static boolean isOnlyDoubleByteKanji(final String s) {
        try {
            final byte[] bytes = s.getBytes("Shift_JIS");
            final int length = bytes.length;
            if (length % 2 == 0) {
                for (int i = 0; i < length; i += 2) {
                    final int n = bytes[i] & 0xFF;
                    if ((n < 129 || n > 159) && (n < 224 || n > 235)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        catch (UnsupportedEncodingException ex) {
            return false;
        }
    }
    
    private static Version recommendVersion(final ErrorCorrectionLevel errorCorrectionLevel, final Mode mode, final BitArray bitArray, final BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }
    
    static void terminateBits(final int n, final BitArray bitArray) throws WriterException {
        final int i = n << 3;
        if (bitArray.getSize() > i) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i);
        }
        for (int n2 = 0; n2 < 4 && bitArray.getSize() < i; ++n2) {
            bitArray.appendBit(false);
        }
        int j = bitArray.getSize() & 0x7;
        if (j > 0) {
            while (j < 8) {
                bitArray.appendBit(false);
                ++j;
            }
        }
        for (int sizeInBytes = bitArray.getSizeInBytes(), k = 0; k < n - sizeInBytes; ++k) {
            int n3;
            if ((k & 0x1) == 0x0) {
                n3 = 236;
            }
            else {
                n3 = 17;
            }
            bitArray.appendBits(n3, 8);
        }
        if (bitArray.getSize() != i) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }
    
    private static boolean willFit(final int n, final Version version, final ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (n + 7) / 8;
    }
}
