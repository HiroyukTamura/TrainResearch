// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter
{
    private static final char[] ALT_START_END_CHARS;
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED;
    private static final char DEFAULT_GUARD;
    private static final char[] START_END_CHARS;
    
    static {
        START_END_CHARS = new char[] { 'A', 'B', 'C', 'D' };
        ALT_START_END_CHARS = new char[] { 'T', 'N', '*', 'E' };
        CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[] { '/', ':', '+', '.' };
        DEFAULT_GUARD = CodaBarWriter.START_END_CHARS[0];
    }
    
    @Override
    public boolean[] encode(final String str) {
        String s;
        if (str.length() < 2) {
            s = CodaBarWriter.DEFAULT_GUARD + str + CodaBarWriter.DEFAULT_GUARD;
        }
        else {
            final char upperCase = Character.toUpperCase(str.charAt(0));
            final char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            final boolean arrayContains = CodaBarReader.arrayContains(CodaBarWriter.START_END_CHARS, upperCase);
            final boolean arrayContains2 = CodaBarReader.arrayContains(CodaBarWriter.START_END_CHARS, upperCase2);
            final boolean arrayContains3 = CodaBarReader.arrayContains(CodaBarWriter.ALT_START_END_CHARS, upperCase);
            final boolean arrayContains4 = CodaBarReader.arrayContains(CodaBarWriter.ALT_START_END_CHARS, upperCase2);
            if (arrayContains) {
                s = str;
                if (!arrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            }
            else if (arrayContains3) {
                s = str;
                if (!arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            }
            else {
                if (arrayContains2 || arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                s = CodaBarWriter.DEFAULT_GUARD + str + CodaBarWriter.DEFAULT_GUARD;
            }
        }
        int n = 20;
        for (int i = 1; i < s.length() - 1; ++i) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-' || s.charAt(i) == '$') {
                n += 9;
            }
            else {
                if (!CodaBarReader.arrayContains(CodaBarWriter.CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, s.charAt(i))) {
                    throw new IllegalArgumentException("Cannot encode : '" + s.charAt(i) + '\'');
                }
                n += 10;
            }
        }
        final boolean[] array = new boolean[s.length() - 1 + n];
        int n2 = 0;
        int n7;
        for (int j = 0; j < s.length(); ++j, n2 = n7) {
            final char upperCase3 = Character.toUpperCase(s.charAt(j));
            char c = '\0';
            Label_0476: {
                if (j != 0) {
                    c = upperCase3;
                    if (j != s.length() - 1) {
                        break Label_0476;
                    }
                }
                switch (upperCase3) {
                    default: {
                        c = upperCase3;
                        break;
                    }
                    case 84: {
                        c = 'A';
                        break;
                    }
                    case 78: {
                        c = 'B';
                        break;
                    }
                    case 42: {
                        c = 'C';
                        break;
                    }
                    case 69: {
                        c = 'D';
                        break;
                    }
                }
            }
            final int n3 = 0;
            int n4 = 0;
            int n5;
            while (true) {
                n5 = n3;
                if (n4 >= CodaBarReader.ALPHABET.length) {
                    break;
                }
                if (c == CodaBarReader.ALPHABET[n4]) {
                    n5 = CodaBarReader.CHARACTER_ENCODINGS[n4];
                    break;
                }
                ++n4;
            }
            boolean b = true;
            int n6 = 0;
            int k = 0;
            while (k < 7) {
                array[n2] = b;
                ++n2;
                if ((n5 >> 6 - k & 0x1) == 0x0 || n6 == 1) {
                    b = !b;
                    ++k;
                    n6 = 0;
                }
                else {
                    ++n6;
                }
            }
            n7 = n2;
            if (j < s.length() - 1) {
                array[n2] = false;
                n7 = n2 + 1;
            }
        }
        return array;
    }
}
