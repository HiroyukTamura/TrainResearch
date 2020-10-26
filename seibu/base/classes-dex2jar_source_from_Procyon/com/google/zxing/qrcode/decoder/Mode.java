// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

public enum Mode
{
    ALPHANUMERIC(new int[] { 9, 11, 13 }, 2), 
    BYTE(new int[] { 8, 16, 16 }, 4), 
    ECI(new int[] { 0, 0, 0 }, 7), 
    FNC1_FIRST_POSITION(new int[] { 0, 0, 0 }, 5), 
    FNC1_SECOND_POSITION(new int[] { 0, 0, 0 }, 9), 
    HANZI(new int[] { 8, 10, 12 }, 13), 
    KANJI(new int[] { 8, 10, 12 }, 8), 
    NUMERIC(new int[] { 10, 12, 14 }, 1), 
    STRUCTURED_APPEND(new int[] { 0, 0, 0 }, 3), 
    TERMINATOR(new int[] { 0, 0, 0 }, 0);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;
    
    private Mode(final int[] characterCountBitsForVersions, final int bits) {
        this.characterCountBitsForVersions = characterCountBitsForVersions;
        this.bits = bits;
    }
    
    public static Mode forBits(final int n) {
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 0: {
                return Mode.TERMINATOR;
            }
            case 1: {
                return Mode.NUMERIC;
            }
            case 2: {
                return Mode.ALPHANUMERIC;
            }
            case 3: {
                return Mode.STRUCTURED_APPEND;
            }
            case 4: {
                return Mode.BYTE;
            }
            case 5: {
                return Mode.FNC1_FIRST_POSITION;
            }
            case 7: {
                return Mode.ECI;
            }
            case 8: {
                return Mode.KANJI;
            }
            case 9: {
                return Mode.FNC1_SECOND_POSITION;
            }
            case 13: {
                return Mode.HANZI;
            }
        }
    }
    
    public int getBits() {
        return this.bits;
    }
    
    public int getCharacterCountBits(final Version version) {
        final int versionNumber = version.getVersionNumber();
        int n;
        if (versionNumber <= 9) {
            n = 0;
        }
        else if (versionNumber <= 26) {
            n = 1;
        }
        else {
            n = 2;
        }
        return this.characterCountBitsForVersions[n];
    }
}
