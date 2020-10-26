// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

final class Base256Encoder implements Encoder
{
    private static char randomize255State(final char c, final int n) {
        final int n2 = c + (n * 149 % 255 + 1);
        if (n2 <= 255) {
            return (char)n2;
        }
        return (char)(n2 - 256);
    }
    
    @Override
    public void encode(final EncoderContext encoderContext) {
        final StringBuilder sb = new StringBuilder();
        sb.append('\0');
        while (encoderContext.hasMoreCharacters()) {
            sb.append(encoderContext.getCurrentChar());
            ++encoderContext.pos;
            if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, this.getEncodingMode()) != this.getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        final int i = sb.length() - 1;
        final int n = encoderContext.getCodewordCount() + i + 1;
        encoderContext.updateSymbolInfo(n);
        boolean b;
        if (encoderContext.getSymbolInfo().getDataCapacity() - n > 0) {
            b = true;
        }
        else {
            b = false;
        }
        if (encoderContext.hasMoreCharacters() || b) {
            if (i <= 249) {
                sb.setCharAt(0, (char)i);
            }
            else {
                if (i > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + i);
                }
                sb.setCharAt(0, (char)(i / 250 + 249));
                sb.insert(1, (char)(i % 250));
            }
        }
        for (int j = 0; j < sb.length(); ++j) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(j), encoderContext.getCodewordCount() + 1));
        }
    }
    
    @Override
    public int getEncodingMode() {
        return 5;
    }
}
