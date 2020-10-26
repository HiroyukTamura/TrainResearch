// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI
{
    ASCII(new int[] { 27, 170 }, new String[] { "US-ASCII" }), 
    Big5(28), 
    Cp1250(21, new String[] { "windows-1250" }), 
    Cp1251(22, new String[] { "windows-1251" }), 
    Cp1252(23, new String[] { "windows-1252" }), 
    Cp1256(24, new String[] { "windows-1256" }), 
    Cp437(new int[] { 0, 2 }, new String[0]), 
    EUC_KR(30, new String[] { "EUC-KR" }), 
    GB18030(29, new String[] { "GB2312", "EUC_CN", "GBK" }), 
    ISO8859_1(new int[] { 1, 3 }, new String[] { "ISO-8859-1" }), 
    ISO8859_10(12, new String[] { "ISO-8859-10" }), 
    ISO8859_11(13, new String[] { "ISO-8859-11" }), 
    ISO8859_13(15, new String[] { "ISO-8859-13" }), 
    ISO8859_14(16, new String[] { "ISO-8859-14" }), 
    ISO8859_15(17, new String[] { "ISO-8859-15" }), 
    ISO8859_16(18, new String[] { "ISO-8859-16" }), 
    ISO8859_2(4, new String[] { "ISO-8859-2" }), 
    ISO8859_3(5, new String[] { "ISO-8859-3" }), 
    ISO8859_4(6, new String[] { "ISO-8859-4" }), 
    ISO8859_5(7, new String[] { "ISO-8859-5" }), 
    ISO8859_6(8, new String[] { "ISO-8859-6" }), 
    ISO8859_7(9, new String[] { "ISO-8859-7" }), 
    ISO8859_8(10, new String[] { "ISO-8859-8" }), 
    ISO8859_9(11, new String[] { "ISO-8859-9" });
    
    private static final Map<String, CharacterSetECI> NAME_TO_ECI;
    
    SJIS(20, new String[] { "Shift_JIS" }), 
    UTF8(26, new String[] { "UTF-8" }), 
    UnicodeBigUnmarked(25, new String[] { "UTF-16BE", "UnicodeBig" });
    
    private static final Map<Integer, CharacterSetECI> VALUE_TO_ECI;
    private final String[] otherEncodingNames;
    private final int[] values;
    
    static {
        VALUE_TO_ECI = new HashMap<Integer, CharacterSetECI>();
        NAME_TO_ECI = new HashMap<String, CharacterSetECI>();
        final CharacterSetECI[] values = values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final CharacterSetECI characterSetECI = values[i];
            final int[] values2 = characterSetECI.values;
            for (int length2 = values2.length, j = 0; j < length2; ++j) {
                CharacterSetECI.VALUE_TO_ECI.put(values2[j], characterSetECI);
            }
            CharacterSetECI.NAME_TO_ECI.put(characterSetECI.name(), characterSetECI);
            final String[] otherEncodingNames = characterSetECI.otherEncodingNames;
            for (int length3 = otherEncodingNames.length, k = 0; k < length3; ++k) {
                CharacterSetECI.NAME_TO_ECI.put(otherEncodingNames[k], characterSetECI);
            }
        }
    }
    
    private CharacterSetECI(final int n2) {
        this(new int[] { n2 }, new String[0]);
    }
    
    private CharacterSetECI(final int n, final String[] otherEncodingNames) {
        this.values = new int[] { n };
        this.otherEncodingNames = otherEncodingNames;
    }
    
    private CharacterSetECI(final int... values, final String[] otherEncodingNames) {
        this.values = values;
        this.otherEncodingNames = otherEncodingNames;
    }
    
    public static CharacterSetECI getCharacterSetECIByName(final String s) {
        return CharacterSetECI.NAME_TO_ECI.get(s);
    }
    
    public static CharacterSetECI getCharacterSetECIByValue(final int i) throws FormatException {
        if (i < 0 || i >= 900) {
            throw FormatException.getFormatInstance();
        }
        return CharacterSetECI.VALUE_TO_ECI.get(i);
    }
    
    public int getValue() {
        return this.values[0];
    }
}
