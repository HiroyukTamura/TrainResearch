package com.google.android.gms.common.images;

import p009e.p010a.p011a.p012a.C0681a;

public final class Size {
    private final int zanj;
    private final int zank;

    public Size(int i, int i2) {
        this.zanj = i;
        this.zank = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zah(str);
                }
            } else {
                throw zah(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException zah(String str) {
        throw new NumberFormatException(C0681a.m313a(C0681a.m336b(str, 16), "Invalid Size: \"", str, "\""));
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zanj == size.zanj && this.zank == size.zank;
        }
    }

    public final int getHeight() {
        return this.zank;
    }

    public final int getWidth() {
        return this.zanj;
    }

    public final int hashCode() {
        int i = this.zank;
        int i2 = this.zanj;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        int i = this.zanj;
        int i2 = this.zank;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
