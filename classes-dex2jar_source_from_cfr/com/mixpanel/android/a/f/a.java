/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 */
package com.mixpanel.android.a.f;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

@SuppressLint(value={"Assert"})
public class a {
    static final /* synthetic */ boolean a;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final byte[] f;
    private static final byte[] g;

    static {
        a = a.class.desiredAssertionStatus() ^ true;
        b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private a() {
    }

    public static String a(byte[] object) {
        IOException iOException2;
        block4 : {
            try {
                object = a.a(object, 0, ((byte[])object).length, 0);
            }
            catch (IOException iOException2) {
                if (!a) break block4;
                object = null;
            }
            if (!a) {
                if (object != null) {
                    return object;
                }
                throw new AssertionError();
            }
            return object;
        }
        throw new AssertionError((Object)iOException2.getMessage());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(byte[] arrby, int n2, int n3, int n4) {
        arrby = a.b(arrby, n2, n3, n4);
        try {
            return new String(arrby, "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(arrby);
        }
    }

    private static byte[] a(byte[] arrby, int n2, int n3, byte[] arrby2, int n4, int n5) {
        byte[] arrby3 = a.b(n5);
        int n6 = 0;
        n5 = n3 > 0 ? arrby[n2] << 24 >>> 8 : 0;
        int n7 = n3 > 1 ? arrby[n2 + 1] << 24 >>> 16 : 0;
        if (n3 > 2) {
            n6 = arrby[n2 + 2] << 24 >>> 24;
        }
        n2 = n5 | n7 | n6;
        switch (n3) {
            default: {
                return arrby2;
            }
            case 3: {
                arrby2[n4] = arrby3[n2 >>> 18];
                arrby2[n4 + 1] = arrby3[n2 >>> 12 & 63];
                arrby2[n4 + 2] = arrby3[n2 >>> 6 & 63];
                arrby2[n4 + 3] = arrby3[n2 & 63];
                return arrby2;
            }
            case 2: {
                arrby2[n4] = arrby3[n2 >>> 18];
                arrby2[n4 + 1] = arrby3[n2 >>> 12 & 63];
                arrby2[n4 + 2] = arrby3[n2 >>> 6 & 63];
                arrby2[n4 + 3] = 61;
                return arrby2;
            }
            case 1: 
        }
        arrby2[n4] = arrby3[n2 >>> 18];
        arrby2[n4 + 1] = arrby3[n2 >>> 12 & 63];
        arrby2[n4 + 2] = 61;
        arrby2[n4 + 3] = 61;
        return arrby2;
    }

    private static int b(byte[] arrby, int n2, byte[] arrby2, int n3, int n4) {
        if (arrby != null) {
            if (arrby2 != null) {
                int n5;
                if (n2 >= 0 && (n5 = n2 + 3) < arrby.length) {
                    int n6;
                    if (n3 >= 0 && (n6 = n3 + 2) < arrby2.length) {
                        byte[] arrby3 = a.c(n4);
                        n4 = n2 + 2;
                        if (arrby[n4] == 61) {
                            n4 = arrby3[arrby[n2]];
                            arrby2[n3] = (byte)(((arrby3[arrby[n2 + 1]] & 255) << 12 | (n4 & 255) << 18) >>> 16);
                            return 1;
                        }
                        if (arrby[n5] == 61) {
                            n6 = arrby3[arrby[n2]];
                            n2 = arrby3[arrby[n2 + 1]];
                            n2 = (arrby3[arrby[n4]] & 255) << 6 | ((n2 & 255) << 12 | (n6 & 255) << 18);
                            arrby2[n3] = (byte)(n2 >>> 16);
                            arrby2[n3 + 1] = (byte)(n2 >>> 8);
                            return 2;
                        }
                        byte by2 = arrby3[arrby[n2]];
                        n2 = arrby3[arrby[n2 + 1]];
                        n4 = arrby3[arrby[n4]];
                        n2 = arrby3[arrby[n5]] & 255 | ((n2 & 255) << 12 | (by2 & 255) << 18 | (n4 & 255) << 6);
                        arrby2[n3] = (byte)(n2 >> 16);
                        arrby2[n3 + 1] = (byte)(n2 >> 8);
                        arrby2[n6] = (byte)n2;
                        return 3;
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", arrby2.length, n3));
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", arrby.length, n2));
            }
            throw new NullPointerException("Destination array was null.");
        }
        throw new NullPointerException("Source array was null.");
    }

    private static final byte[] b(int n2) {
        if ((n2 & 16) == 16) {
            return d;
        }
        if ((n2 & 32) == 32) {
            return f;
        }
        return b;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static byte[] b(byte[] object, int n2, int n3, int n4) {
        ByteArrayOutputStream byteArrayOutputStream;
        Object object2;
        block35 : {
            a a2;
            block32 : {
                int n5;
                block38 : {
                    Object object3;
                    block33 : {
                        block39 : {
                            DeflaterOutputStream deflaterOutputStream;
                            block34 : {
                                if (object == null) throw new NullPointerException("Cannot serialize a null array.");
                                if (n2 < 0) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("Cannot have negative offset: ");
                                    ((StringBuilder)object).append(n2);
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                if (n3 < 0) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("Cannot have length offset: ");
                                    ((StringBuilder)object).append(n3);
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                if (n2 + n3 > ((Object)object).length) {
                                    throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", n2, n3, ((Object)object).length));
                                }
                                if ((n4 & 2) == 0) break block38;
                                deflaterOutputStream = null;
                                object2 = null;
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                a2 = new a(byteArrayOutputStream, n4 | 1);
                                object3 = new GZIPOutputStream(a2);
                                ((GZIPOutputStream)object3).write((byte[])object, n2, n3);
                                ((DeflaterOutputStream)object3).close();
                                ((DeflaterOutputStream)object3).close();
                                break block32;
                                catch (Throwable throwable) {
                                    object2 = a2;
                                    break block33;
                                }
                                catch (IOException iOException) {
                                    object = object3;
                                    break block34;
                                }
                                catch (Throwable throwable) {
                                    object3 = deflaterOutputStream;
                                    object2 = a2;
                                    break block33;
                                }
                                catch (IOException iOException) {
                                    object = null;
                                    break block34;
                                }
                                catch (Throwable throwable) {
                                    object2 = null;
                                    object3 = deflaterOutputStream;
                                    break block33;
                                }
                                catch (IOException iOException) {
                                    a2 = null;
                                    object = a2;
                                }
                            }
                            object3 = byteArrayOutputStream;
                            byteArrayOutputStream = object2;
                            object2 = object3;
                            break block39;
                            catch (Throwable throwable) {
                                byteArrayOutputStream = null;
                                object2 = byteArrayOutputStream;
                                object3 = deflaterOutputStream;
                                break block33;
                            }
                            catch (IOException iOException) {
                                a2 = null;
                                object = a2;
                            }
                        }
                        try {
                            throw byteArrayOutputStream;
                        }
                        catch (Throwable throwable) {
                            byteArrayOutputStream = object2;
                            object3 = object;
                            object2 = a2;
                            object = throwable;
                        }
                    }
                    ((DeflaterOutputStream)object3).close();
                    break block35;
                }
                boolean bl2 = (n4 & 8) != 0;
                int n6 = n3 / 3;
                int n7 = n3 % 3 > 0 ? 4 : 0;
                n7 = n6 = n6 * 4 + n7;
                if (bl2) {
                    n7 = n6 + n6 / 76;
                }
                byte[] arrby = new byte[n7];
                n7 = 0;
                n6 = 0;
                for (n5 = 0; n5 < n3 - 2; n5 += 3, n7 += 4) {
                    a.a((byte[])object, n5 + n2, 3, arrby, n7, n4);
                    if (!bl2 || (n6 += 4) < 76) continue;
                    arrby[n7 + 4] = 10;
                    ++n7;
                    n6 = 0;
                }
                n6 = n7;
                if (n5 < n3) {
                    a.a((byte[])object, n5 + n2, n3 - n5, arrby, n7, n4);
                    n6 = n7 + 4;
                }
                if (n6 > arrby.length - 1) return arrby;
                object = new byte[n6];
                System.arraycopy(arrby, 0, object, 0, n6);
                return object;
                catch (Exception exception) {}
            }
            try {
                a2.close();
            }
            catch (Exception exception) {}
            try {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            catch (Exception exception) {
                return byteArrayOutputStream.toByteArray();
            }
            catch (Exception exception) {}
        }
        try {
            ((a)object2).close();
        }
        catch (Exception exception) {}
        try {
            byteArrayOutputStream.close();
        }
        catch (Exception exception) {
            throw object;
        }
        throw object;
    }

    private static byte[] b(byte[] arrby, byte[] arrby2, int n2, int n3) {
        a.a(arrby2, 0, n2, arrby, 0, n3);
        return arrby;
    }

    private static final byte[] c(int n2) {
        if ((n2 & 16) == 16) {
            return e;
        }
        if ((n2 & 32) == 32) {
            return g;
        }
        return c;
    }

    public static class a
    extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public a(OutputStream outputStream, int n2) {
            super(outputStream);
            boolean bl2 = true;
            boolean bl3 = (n2 & 8) != 0;
            this.f = bl3;
            bl3 = (n2 & 1) != 0 ? bl2 : false;
            this.a = bl3;
            int n3 = this.a ? 3 : 4;
            this.d = n3;
            this.c = new byte[this.d];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = n2;
            this.j = a.c(n2);
        }

        public void a() {
            if (this.b > 0) {
                if (this.a) {
                    this.out.write(a.b(this.g, this.c, this.b, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override
        public void close() {
            this.a();
            super.close();
            this.c = null;
            this.out = null;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void write(int n2) {
            int n3;
            block8 : {
                block7 : {
                    block6 : {
                        if (this.h) {
                            this.out.write(n2);
                            return;
                        }
                        if (!this.a) break block6;
                        byte[] arrby = this.c;
                        int n4 = this.b;
                        this.b = n4 + 1;
                        arrby[n4] = (byte)n2;
                        if (this.b < this.d) return;
                        this.out.write(a.b(this.g, this.c, this.d, this.i));
                        this.e += 4;
                        if (this.f && this.e >= 76) {
                            this.out.write(10);
                            this.e = 0;
                        }
                        break block7;
                    }
                    byte[] arrby = this.j;
                    n3 = n2 & 127;
                    if (arrby[n3] <= -5) break block8;
                    arrby = this.c;
                    n3 = this.b;
                    this.b = n3 + 1;
                    arrby[n3] = (byte)n2;
                    if (this.b < this.d) return;
                    n2 = a.b(this.c, 0, this.g, 0, this.i);
                    this.out.write(this.g, 0, n2);
                }
                this.b = 0;
                return;
            }
            if (this.j[n3] == -5) return;
            {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override
        public void write(byte[] arrby, int n2, int n3) {
            if (this.h) {
                this.out.write(arrby, n2, n3);
                return;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                this.write(arrby[n2 + i2]);
            }
        }
    }

}

