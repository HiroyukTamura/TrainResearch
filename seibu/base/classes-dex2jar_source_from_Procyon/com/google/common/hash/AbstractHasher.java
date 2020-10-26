// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.hash;

import java.nio.charset.Charset;

abstract class AbstractHasher implements Hasher
{
    @Override
    public final Hasher putBoolean(final boolean b) {
        byte b2;
        if (b) {
            b2 = 1;
        }
        else {
            b2 = 0;
        }
        return this.putByte(b2);
    }
    
    @Override
    public final Hasher putDouble(final double n) {
        return this.putLong(Double.doubleToRawLongBits(n));
    }
    
    @Override
    public final Hasher putFloat(final float n) {
        return this.putInt(Float.floatToRawIntBits(n));
    }
    
    @Override
    public Hasher putString(final CharSequence charSequence, final Charset charset) {
        return this.putBytes(charSequence.toString().getBytes(charset));
    }
    
    @Override
    public Hasher putUnencodedChars(final CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); ++i) {
            this.putChar(charSequence.charAt(i));
        }
        return this;
    }
}
