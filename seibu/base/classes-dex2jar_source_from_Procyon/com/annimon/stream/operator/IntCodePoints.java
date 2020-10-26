// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntCodePoints extends OfInt
{
    private final CharSequence charSequence;
    private int current;
    private final boolean isString;
    private int length;
    
    public IntCodePoints(final CharSequence charSequence) {
        this.charSequence = charSequence;
        this.isString = (charSequence instanceof String);
        this.current = 0;
        this.length = -1;
    }
    
    private int ensureLength() {
        if (this.isString) {
            if (this.length == -1) {
                this.length = this.charSequence.length();
            }
            return this.length;
        }
        return this.charSequence.length();
    }
    
    @Override
    public boolean hasNext() {
        return this.current < this.ensureLength();
    }
    
    @Override
    public int nextInt() {
        final int ensureLength = this.ensureLength();
        if (this.current >= ensureLength) {
            throw new NoSuchElementException();
        }
        int n;
        final char c = (char)(n = this.charSequence.charAt(this.current++));
        if (Character.isHighSurrogate(c)) {
            n = c;
            if (this.current < ensureLength) {
                final char char1 = this.charSequence.charAt(this.current);
                n = c;
                if (Character.isLowSurrogate(char1)) {
                    ++this.current;
                    n = Character.toCodePoint(c, char1);
                }
            }
        }
        return n;
    }
}
