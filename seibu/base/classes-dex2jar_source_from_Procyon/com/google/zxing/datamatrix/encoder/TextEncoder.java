// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

final class TextEncoder extends C40Encoder
{
    @Override
    int encodeChar(final char c, final StringBuilder sb) {
        if (c == ' ') {
            sb.append('\u0003');
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char)(c - '0' + 4));
            return 1;
        }
        if (c >= 'a' && c <= 'z') {
            sb.append((char)(c - 'a' + 14));
            return 1;
        }
        if (c >= '\0' && c <= '\u001f') {
            sb.append('\0');
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append('\u0001');
            sb.append((char)(c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append('\u0001');
            sb.append((char)(c - ':' + 15));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append('\u0001');
            sb.append((char)(c - '[' + 22));
            return 2;
        }
        if (c == '`') {
            sb.append('\u0002');
            sb.append((char)(c - '`'));
            return 2;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append('\u0002');
            sb.append((char)(c - 'A' + 1));
            return 2;
        }
        if (c >= '{' && c <= '\u007f') {
            sb.append('\u0002');
            sb.append((char)(c - '{' + 27));
            return 2;
        }
        if (c >= '\u0080') {
            sb.append("\u0001\u001e");
            return this.encodeChar((char)(c - '\u0080'), sb) + 2;
        }
        HighLevelEncoder.illegalCharacter(c);
        return -1;
    }
    
    @Override
    public int getEncodingMode() {
        return 2;
    }
}
