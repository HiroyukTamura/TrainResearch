/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.f;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class b {
    public static CodingErrorAction a = CodingErrorAction.REPORT;

    public static String a(ByteBuffer byteBuffer) {
        Object object = Charset.forName("UTF8").newDecoder();
        ((CharsetDecoder)object).onMalformedInput(a);
        ((CharsetDecoder)object).onUnmappableCharacter(a);
        try {
            byteBuffer.mark();
            object = ((CharsetDecoder)object).decode(byteBuffer).toString();
            byteBuffer.reset();
            return object;
        }
        catch (CharacterCodingException characterCodingException) {
            throw new com.mixpanel.android.a.c.b(1007, characterCodingException);
        }
    }

    public static String a(byte[] object, int n2, int n3) {
        try {
            object = new String((byte[])object, n2, n3, "ASCII");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    public static byte[] a(String arrby) {
        try {
            arrby = arrby.getBytes("UTF8");
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }

    public static byte[] b(String arrby) {
        try {
            arrby = arrby.getBytes("ASCII");
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException);
        }
    }
}

