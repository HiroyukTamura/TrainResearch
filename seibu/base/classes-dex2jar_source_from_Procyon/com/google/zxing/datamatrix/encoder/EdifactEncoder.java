// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder implements Encoder
{
    private static void encodeChar(final char c, final StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
            return;
        }
        if (c >= '@' && c <= '^') {
            sb.append((char)(c - '@'));
            return;
        }
        HighLevelEncoder.illegalCharacter(c);
    }
    
    private static String encodeToCodewords(final CharSequence charSequence, int n) {
        int char1 = 0;
        final int n2 = charSequence.length() - n;
        if (n2 == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        final char char2 = charSequence.charAt(n);
        char char3;
        if (n2 >= 2) {
            char3 = charSequence.charAt(n + 1);
        }
        else {
            char3 = '\0';
        }
        char char4;
        if (n2 >= 3) {
            char4 = charSequence.charAt(n + 2);
        }
        else {
            char4 = '\0';
        }
        if (n2 >= 4) {
            char1 = charSequence.charAt(n + 3);
        }
        n = (char2 << 18) + (char3 << 12) + (char4 << 6) + char1;
        final char c = (char)(n >> 16 & 0xFF);
        final char c2 = (char)(n >> 8 & 0xFF);
        final char c3 = (char)(n & 0xFF);
        final StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (n2 >= 2) {
            sb.append(c2);
        }
        if (n2 >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }
    
    private static void handleEOD(final EncoderContext encoderContext, final CharSequence charSequence) {
        final int n = 1;
        int length;
        try {
            length = charSequence.length();
            if (length == 0) {
                return;
            }
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                final int n2 = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                if (encoderContext.getRemainingCharacters() <= n2 && n2 <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
        }
        finally {
            encoderContext.signalEncoderChange(0);
        }
        final int n3 = length - 1;
        final CharSequence charSequence2;
        final String encodeToCodewords = encodeToCodewords(charSequence2, 0);
        int n4;
        if (!encoderContext.hasMoreCharacters() && n3 <= 2) {
            n4 = n;
        }
        else {
            n4 = 0;
        }
        int n5 = n4;
        if (n3 <= 2) {
            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + n3);
            n5 = n4;
            if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                n5 = 0;
                encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
            }
        }
        if (n5 != 0) {
            encoderContext.resetSymbolInfo();
            encoderContext.pos -= n3;
        }
        else {
            encoderContext.writeCodewords(encodeToCodewords);
        }
        encoderContext.signalEncoderChange(0);
    }
    
    @Override
    public void encode(final EncoderContext encoderContext) {
        final StringBuilder sb = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            encodeChar(encoderContext.getCurrentChar(), sb);
            ++encoderContext.pos;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, this.getEncodingMode()) != this.getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
                continue;
            }
        }
        sb.append('\u001f');
        handleEOD(encoderContext, sb);
    }
    
    @Override
    public int getEncodingMode() {
        return 4;
    }
}
