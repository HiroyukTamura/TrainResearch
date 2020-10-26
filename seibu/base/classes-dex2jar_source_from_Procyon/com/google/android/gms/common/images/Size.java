// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

public final class Size
{
    private final int zzrW;
    private final int zzrX;
    
    public Size(final int zzrW, final int zzrX) {
        this.zzrW = zzrW;
        this.zzrX = zzrX;
    }
    
    public static Size parseSize(final String s) throws NumberFormatException {
        if (s == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int endIndex;
        if ((endIndex = s.indexOf(42)) < 0) {
            endIndex = s.indexOf(120);
        }
        if (endIndex < 0) {
            throw zzcy(s);
        }
        try {
            return new Size(Integer.parseInt(s.substring(0, endIndex)), Integer.parseInt(s.substring(endIndex + 1)));
        }
        catch (NumberFormatException ex) {
            throw zzcy(s);
        }
    }
    
    private static NumberFormatException zzcy(final String s) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(s).length() + 16).append("Invalid Size: \"").append(s).append("\"").toString());
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != null) {
            if (this == o) {
                return true;
            }
            if (o instanceof Size) {
                final Size size = (Size)o;
                if (this.zzrW == size.zzrW && this.zzrX == size.zzrX) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public final int getHeight() {
        return this.zzrX;
    }
    
    public final int getWidth() {
        return this.zzrW;
    }
    
    @Override
    public final int hashCode() {
        return this.zzrX ^ (this.zzrW << 16 | this.zzrW >>> 16);
    }
    
    @Override
    public final String toString() {
        return new StringBuilder(23).append(this.zzrW).append("x").append(this.zzrX).toString();
    }
}
