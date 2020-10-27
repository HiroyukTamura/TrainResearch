package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

final class zzhs<T> implements zzic<T> {
    private static final int[] zzxq = new int[0];
    private static final Unsafe zzxr = zzja.zzdh();
    private final zzho zzxm;
    private final zziu<?, ?> zzxn;
    private final boolean zzxo;
    private final zzfw<?> zzxp;
    private final int[] zzxs;
    private final Object[] zzxt;
    private final int zzxu;
    private final int zzxv;
    private final boolean zzxw;
    private final boolean zzxx;
    private final boolean zzxy;
    private final int[] zzxz;
    private final int zzya;
    private final int zzyb;
    private final zzht zzyc;
    private final zzgy zzyd;
    private final zzhh zzye;

    private zzhs(int[] iArr, Object[] objArr, int i, int i2, zzho zzho, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzht zzht, zzgy zzgy, zziu<?, ?> zziu, zzfw<?> zzfw, zzhh zzhh) {
        this.zzxs = iArr;
        this.zzxt = objArr;
        this.zzxu = i;
        this.zzxv = i2;
        this.zzxw = zzho instanceof zzgg;
        this.zzxx = z;
        this.zzxo = zzfw != null && zzfw.zze(zzho);
        this.zzxy = false;
        this.zzxz = iArr2;
        this.zzya = i3;
        this.zzyb = i4;
        this.zzyc = zzht;
        this.zzyd = zzgy;
        this.zzxn = zziu;
        this.zzxp = zzfw;
        this.zzxm = zzho;
        this.zzye = zzhh;
    }

    private static <UT, UB> int zza(zziu<UT, UB> zziu, T t) {
        return zziu.zzk(zziu.zzm(t));
    }

    static <T> zzhs<T> zza(Class<T> cls, zzhm zzhm, zzht zzht, zzgy zzgy, zziu<?, ?> zziu, zzfw<?> zzfw, zzhh zzhh) {
        int i;
        char c;
        int[] iArr;
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i3;
        boolean z;
        int i4;
        zzhz zzhz;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c7;
        char c8;
        Field field;
        int i9;
        char charAt;
        int i10;
        Field field2;
        Field field3;
        int i11;
        char charAt2;
        int i12;
        char charAt3;
        int i13;
        char charAt4;
        int i14;
        int i15;
        char charAt5;
        int i16;
        char charAt6;
        int i17;
        char charAt7;
        int i18;
        char charAt8;
        int i19;
        char charAt9;
        int i20;
        char charAt10;
        int i21;
        char charAt11;
        int i22;
        char charAt12;
        int i23;
        char charAt13;
        char charAt14;
        zzhm zzhm2 = zzhm;
        if (zzhm2 instanceof zzhz) {
            zzhz zzhz2 = (zzhz) zzhm2;
            char c9 = 0;
            boolean z2 = zzhz2.zzch() == zzgg.zze.zzvu;
            String zzcn = zzhz2.zzcn();
            int length = zzcn.length();
            char charAt15 = zzcn.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzcn.charAt(i24);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i25;
                    i25 += 13;
                    i24 = i;
                }
                charAt15 = c10 | (charAt14 << i25);
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt16 = zzcn.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzcn.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i23;
                }
                charAt16 = c11 | (charAt13 << i27);
                i26 = i23;
            }
            if (charAt16 == 0) {
                iArr = zzxq;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                i2 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzcn.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzcn.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i22;
                    }
                    charAt17 = c12 | (charAt12 << i29);
                    i28 = i22;
                }
                int i30 = i28 + 1;
                char charAt18 = zzcn.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzcn.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i21;
                    }
                    charAt18 = c13 | (charAt11 << i31);
                    i30 = i21;
                }
                int i32 = i30 + 1;
                c3 = zzcn.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzcn.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i20;
                    }
                    c3 = c14 | (charAt10 << i33);
                    i32 = i20;
                }
                int i34 = i32 + 1;
                char charAt19 = zzcn.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzcn.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i19;
                    }
                    charAt19 = c15 | (charAt9 << i35);
                    i34 = i19;
                }
                int i36 = i34 + 1;
                c2 = zzcn.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzcn.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i18;
                    }
                    c2 = c16 | (charAt8 << i37);
                    i36 = i18;
                }
                int i38 = i36 + 1;
                char charAt20 = zzcn.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzcn.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i17;
                    }
                    charAt20 = c17 | (charAt7 << i39);
                    i38 = i17;
                }
                int i40 = i38 + 1;
                char charAt21 = zzcn.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzcn.charAt(i41);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i41 = i16;
                    }
                    charAt21 = c18 | (charAt6 << i42);
                    i14 = i16;
                } else {
                    i14 = i40;
                }
                int i43 = i14 + 1;
                char charAt22 = zzcn.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzcn.charAt(i44);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i44 = i15;
                    }
                    charAt22 = c19 | (charAt5 << i45);
                    i43 = i15;
                }
                int i46 = (charAt17 << 1) + charAt18;
                c4 = charAt19;
                i2 = i46;
                c = charAt22;
                c9 = charAt17;
                i26 = i43;
                char c20 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c5 = c20;
            }
            Unsafe unsafe = zzxr;
            Object[] zzco = zzhz2.zzco();
            Class<?> cls3 = zzhz2.zzcj().getClass();
            int i47 = i26;
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i48 = c + c5;
            char c21 = c;
            int i49 = i47;
            int i50 = i48;
            int i51 = 0;
            int i52 = 0;
            while (i49 < length) {
                int i53 = i49 + 1;
                int charAt23 = zzcn.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzcn.charAt(i56);
                        c6 = c;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i55 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i56 = i13;
                        c = c6;
                    }
                    charAt23 = i55 | (charAt4 << i57);
                    i3 = i13;
                } else {
                    c6 = c;
                    i3 = i53;
                }
                int i58 = i3 + 1;
                char charAt24 = zzcn.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzcn.charAt(i60);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c22 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i60 = i12;
                        z2 = z;
                    }
                    charAt24 = c22 | (charAt3 << i61);
                    i4 = i12;
                } else {
                    z = z2;
                    i4 = i59;
                }
                char c23 = charAt24 & 255;
                char c24 = c4;
                if ((charAt24 & 1024) != 0) {
                    iArr[i51] = i52;
                    i51++;
                }
                char c25 = c3;
                if (c23 >= '3') {
                    int i62 = i4 + 1;
                    char charAt25 = zzcn.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzcn.charAt(i62);
                            if (charAt2 < c26) {
                                break;
                            }
                            c27 |= (charAt2 & 8191) << i63;
                            i63 += 13;
                            i62 = i11;
                            c26 = 55296;
                        }
                        charAt25 = c27 | (charAt2 << i63);
                        i62 = i11;
                    }
                    int i64 = c23 - '3';
                    int i65 = i62;
                    if (i64 == 9 || i64 == 17) {
                        objArr[((i52 / 3) << 1) + 1] = zzco[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzco[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzco[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzco[i66] = field2;
                    }
                    zzhz = zzhz2;
                    String str2 = zzcn;
                    i8 = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzco[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzco[i67] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i65;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    c7 = c9;
                } else {
                    zzhz = zzhz2;
                    String str3 = zzcn;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzco[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzco[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzco[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzco[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzco[i71];
                                    c21 = i69;
                                } else {
                                    i68 = i71;
                                    c8 = 1;
                                    c21 = i69;
                                }
                            }
                            c8 = 1;
                        }
                        i68 = i10;
                    }
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c8 || c23 > 17) {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                        i7 = 0;
                        i6 = 0;
                    } else {
                        int i72 = i4 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i4);
                        if (charAt26 >= 55296) {
                            char c28 = charAt26 & 8191;
                            int i73 = 13;
                            while (true) {
                                i9 = i72 + 1;
                                charAt = str.charAt(i72);
                                if (charAt < 55296) {
                                    break;
                                }
                                c28 |= (charAt & 8191) << i73;
                                i73 += 13;
                                i72 = i9;
                            }
                            charAt26 = c28 | (charAt << i73);
                            i72 = i9;
                        }
                        int i74 = (charAt26 / ' ') + (c9 << 1);
                        Object obj3 = zzco[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzco[i74] = field;
                        }
                        c7 = c9;
                        cls2 = cls3;
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i6 = charAt26 % ' ';
                        i4 = i72;
                    }
                    if (c23 >= 18 && c23 <= '1') {
                        iArr[i50] = i8;
                        i50++;
                    }
                }
                int i75 = i52 + 1;
                iArr2[i52] = charAt23;
                int i76 = i75 + 1;
                iArr2[i75] = i8 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (c23 << 20);
                i52 = i76 + 1;
                iArr2[i76] = (i6 << 20) | i7;
                c9 = c7;
                zzcn = str;
                i49 = i4;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                cls3 = cls2;
                c3 = c25;
                i2 = i5;
                zzhz2 = zzhz;
            }
            char c29 = c4;
            boolean z3 = z2;
            return new zzhs(iArr2, objArr, c3, c4, zzhz2.zzcj(), z2, false, iArr, c, i48, zzht, zzgy, zziu, zzfw, zzhh);
        }
        int zzch = ((zzin) zzhm2).zzch();
        int i77 = zzgg.zze.zzvu;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(C0681a.m324a(C0681a.m337b(C0681a.m336b(arrays, name.length() + C0681a.m336b(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", arrays));
        }
    }

    private static void zza(int i, Object obj, zzjo zzjo) throws IOException {
        if (obj instanceof String) {
            zzjo.zza(i, (String) obj);
        } else {
            zzjo.zza(i, (zzff) obj);
        }
    }

    private static <UT, UB> void zza(zziu<UT, UB> zziu, T t, zzjo zzjo) throws IOException {
        zziu.zza(zziu.zzm(t), zzjo);
    }

    private final <K, V> void zza(zzjo zzjo, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjo.zza(i, this.zzye.zzh(zzaf(i2)), this.zzye.zzf(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzja.zzo(t, zzag);
            Object zzo2 = zzja.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzja.zza((Object) t, zzag, zzgk.zzb(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzja.zza((Object) t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzxx) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzja.zzn(t, j) != 0.0d;
                case 1:
                    return zzja.zzm(t, j) != 0.0f;
                case 2:
                    return zzja.zzk(t, j) != 0;
                case 3:
                    return zzja.zzk(t, j) != 0;
                case 4:
                    return zzja.zzj(t, j) != 0;
                case 5:
                    return zzja.zzk(t, j) != 0;
                case 6:
                    return zzja.zzj(t, j) != 0;
                case 7:
                    return zzja.zzl(t, j);
                case 8:
                    Object zzo = zzja.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzff) {
                        return !zzff.zzri.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzja.zzo(t, j) != null;
                case 10:
                    return !zzff.zzri.equals(zzja.zzo(t, j));
                case 11:
                    return zzja.zzj(t, j) != 0;
                case 12:
                    return zzja.zzj(t, j) != 0;
                case 13:
                    return zzja.zzj(t, j) != 0;
                case 14:
                    return zzja.zzk(t, j) != 0;
                case 15:
                    return zzja.zzj(t, j) != 0;
                case 16:
                    return zzja.zzk(t, j) != 0;
                case 17:
                    return zzja.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzja.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzja.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzxx ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzic zzic) {
        return zzic.zzj(zzja.zzo(obj, (long) (i & 1048575)));
    }

    private final zzic zzae(int i) {
        int i2 = (i / 3) << 1;
        zzic zzic = (zzic) this.zzxt[i2];
        if (zzic != null) {
            return zzic;
        }
        zzic zze = zzia.zzcp().zze((Class) this.zzxt[i2 + 1]);
        this.zzxt[i2] = zze;
        return zze;
    }

    private final Object zzaf(int i) {
        return this.zzxt[(i / 3) << 1];
    }

    private final int zzag(int i) {
        return this.zzxs[i + 1];
    }

    private final int zzah(int i) {
        return this.zzxs[i + 2];
    }

    private final void zzb(T t, int i) {
        if (!this.zzxx) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzja.zza((Object) t, j, zzja.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzja.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.fitness.zzjo r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzxo
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.fitness.zzfw<?> r3 = r0.zzxp
            com.google.android.gms.internal.fitness.zzgb r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r5 = r3.zzsj
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzxs
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzxr
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzag(r10)
            int[] r13 = r0.zzxs
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzxx
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005d
            r4 = 17
            if (r15 > r4) goto L_0x005d
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0057
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0057:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0060
        L_0x005d:
            r17 = r10
            r4 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.fitness.zzfw<?> r9 = r0.zzxp
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.fitness.zzfw<?> r9 = r0.zzxp
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0060
        L_0x007c:
            r5 = 0
            goto L_0x0060
        L_0x007e:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0485;
                case 1: goto L_0x0479;
                case 2: goto L_0x046d;
                case 3: goto L_0x0461;
                case 4: goto L_0x0455;
                case 5: goto L_0x0449;
                case 6: goto L_0x043d;
                case 7: goto L_0x0431;
                case 8: goto L_0x0425;
                case 9: goto L_0x0414;
                case 10: goto L_0x0405;
                case 11: goto L_0x03f8;
                case 12: goto L_0x03eb;
                case 13: goto L_0x03de;
                case 14: goto L_0x03d1;
                case 15: goto L_0x03c4;
                case 16: goto L_0x03b7;
                case 17: goto L_0x03a6;
                case 18: goto L_0x0396;
                case 19: goto L_0x0386;
                case 20: goto L_0x0376;
                case 21: goto L_0x0366;
                case 22: goto L_0x0356;
                case 23: goto L_0x0346;
                case 24: goto L_0x0336;
                case 25: goto L_0x0326;
                case 26: goto L_0x0317;
                case 27: goto L_0x0304;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c5;
                case 32: goto L_0x02b5;
                case 33: goto L_0x02a5;
                case 34: goto L_0x0295;
                case 35: goto L_0x0285;
                case 36: goto L_0x0275;
                case 37: goto L_0x0265;
                case 38: goto L_0x0255;
                case 39: goto L_0x0245;
                case 40: goto L_0x0235;
                case 41: goto L_0x0225;
                case 42: goto L_0x0215;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01e5;
                case 46: goto L_0x01d5;
                case 47: goto L_0x01c5;
                case 48: goto L_0x01b5;
                case 49: goto L_0x01a2;
                case 50: goto L_0x0199;
                case 51: goto L_0x018a;
                case 52: goto L_0x017b;
                case 53: goto L_0x016c;
                case 54: goto L_0x015d;
                case 55: goto L_0x014e;
                case 56: goto L_0x013f;
                case 57: goto L_0x0130;
                case 58: goto L_0x0121;
                case 59: goto L_0x0112;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00ef;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00c5;
                case 65: goto L_0x00b7;
                case 66: goto L_0x00a9;
                case 67: goto L_0x009b;
                case 68: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r13 = 0
            goto L_0x0490
        L_0x0089:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzff r4 = (com.google.android.gms.internal.fitness.zzff) r4
            r2.zza((int) r14, (com.google.android.gms.internal.fitness.zzff) r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0086
        L_0x0112:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzjo) r2)
            goto L_0x0086
        L_0x0121:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            boolean r4 = zzi(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzf(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zze(r1, r9)
            r2.zza((int) r14, (double) r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.gms.internal.fitness.zzjo) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r10 = r0.zzae(r12)
            com.google.android.gms.internal.fitness.zzie.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.fitness.zzie.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (boolean) r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (boolean) r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.fitness.zzie.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r10 = r0.zzae(r12)
            com.google.android.gms.internal.fitness.zzie.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.fitness.zzjo) r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.fitness.zzie.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (boolean) r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.fitness.zzjo) r2, (boolean) r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzff r4 = (com.google.android.gms.internal.fitness.zzff) r4
            r2.zza((int) r14, (com.google.android.gms.internal.fitness.zzff) r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0490
        L_0x0425:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.fitness.zzjo) r2)
            goto L_0x0490
        L_0x0431:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            boolean r4 = com.google.android.gms.internal.fitness.zzja.zzl(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x0490
        L_0x0455:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x0490
        L_0x0461:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.fitness.zzja.zzm(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.fitness.zzja.zzn(r1, r9)
            r2.zza((int) r14, (double) r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.fitness.zzfw<?> r4 = r0.zzxp
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0494
        L_0x04a9:
            r5 = 0
            goto L_0x0494
        L_0x04ab:
            com.google.android.gms.internal.fitness.zziu<?, ?> r3 = r0.zzxn
            zza(r3, r1, (com.google.android.gms.internal.fitness.zzjo) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zzb(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzxs[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzja.zzo(t, j);
            Object zzo2 = zzja.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzja.zza((Object) t, j, zzgk.zzb(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzja.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static List<?> zzd(Object obj, long j) {
        return (List) zzja.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzja.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzja.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzja.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzja.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzja.zzo(t, j)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzl(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzl(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.fitness.zzja.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.fitness.zzja.zzm(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.fitness.zzja.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.fitness.zzja.zzn(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzxs
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01ba
            int r4 = r9.zzag(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0198;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01b3
        L_0x001c:
            int r4 = r9.zzah(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r4)
            if (r8 != r4) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.fitness.zzie.zze(r3, r4)
            goto L_0x01b3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            boolean r4 = com.google.android.gms.internal.fitness.zzja.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.fitness.zzja.zzl(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            float r4 = com.google.android.gms.internal.fitness.zzja.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.fitness.zzja.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01b3
        L_0x0197:
            goto L_0x01b2
        L_0x0198:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            double r4 = com.google.android.gms.internal.fitness.zzja.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.fitness.zzja.zzn(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
        L_0x01b2:
            r3 = 0
        L_0x01b3:
            if (r3 != 0) goto L_0x01b6
            return r1
        L_0x01b6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01ba:
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r9.zzxn
            java.lang.Object r0 = r0.zzm(r10)
            com.google.android.gms.internal.fitness.zziu<?, ?> r2 = r9.zzxn
            java.lang.Object r2 = r2.zzm(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r9.zzxo
            if (r0 == 0) goto L_0x01e2
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r9.zzxp
            com.google.android.gms.internal.fitness.zzgb r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r9.zzxp
            com.google.android.gms.internal.fitness.zzgb r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = zzg(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = zzh(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.fitness.zzgk.zzc(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0108, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0122, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0126, code lost:
        r3 = com.google.android.gms.internal.fitness.zzgk.zzj(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzxs
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0130
            int r3 = r8.zzag(r1)
            int[] r4 = r8.zzxs
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0111;
                case 2: goto L_0x010a;
                case 3: goto L_0x010a;
                case 4: goto L_0x0102;
                case 5: goto L_0x010a;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x010a;
                case 15: goto L_0x0102;
                case 16: goto L_0x010a;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012c
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x0093:
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0108
        L_0x009b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            goto L_0x0126
        L_0x00b0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            goto L_0x0117
        L_0x00bd:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012c
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
            goto L_0x0122
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012c
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x012a
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.fitness.zzja.zzl(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.fitness.zzgk.zzc((boolean) r3)
            goto L_0x012a
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.fitness.zzja.zzj(r9, r5)
        L_0x0108:
            int r2 = r2 + r3
            goto L_0x012c
        L_0x010a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.fitness.zzja.zzk(r9, r5)
            goto L_0x0126
        L_0x0111:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.fitness.zzja.zzm(r9, r5)
        L_0x0117:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x012a
        L_0x011c:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.fitness.zzja.zzn(r9, r5)
        L_0x0122:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0126:
            int r3 = com.google.android.gms.internal.fitness.zzgk.zzj(r3)
        L_0x012a:
            int r3 = r3 + r2
            r2 = r3
        L_0x012c:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0130:
            int r2 = r2 * 53
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r8.zzxn
            java.lang.Object r0 = r0.zzm(r9)
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r1 = r8.zzxo
            if (r1 == 0) goto L_0x014e
            int r0 = r0 * 53
            com.google.android.gms.internal.fitness.zzfw<?> r1 = r8.zzxp
            com.google.android.gms.internal.fitness.zzgb r9 = r1.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r0 = r0 + r9
        L_0x014e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.hashCode(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0387, code lost:
        r15.zzb(r9, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r8 & 1048575)), zzae(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a2, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b3, code lost:
        r15.zze(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c4, code lost:
        r15.zzj(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d5, code lost:
        r15.zzm(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03e6, code lost:
        r15.zzn(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03f7, code lost:
        r15.zzd(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0402, code lost:
        r15.zza(r9, (com.google.android.gms.internal.fitness.zzff) com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0415, code lost:
        r15.zza(r9, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r8 & 1048575)), zzae(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x042a, code lost:
        zza(r9, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0441, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0452, code lost:
        r15.zzf(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0462, code lost:
        r15.zzc(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0472, code lost:
        r15.zzc(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0482, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0492, code lost:
        r15.zzi(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04a2, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04b2, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0846, code lost:
        r15.zzb(r10, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r9 & 1048575)), zzae(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0861, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0872, code lost:
        r15.zze(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0883, code lost:
        r15.zzj(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0894, code lost:
        r15.zzm(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08a5, code lost:
        r15.zzn(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08b6, code lost:
        r15.zzd(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08c1, code lost:
        r15.zza(r10, (com.google.android.gms.internal.fitness.zzff) com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x08d4, code lost:
        r15.zza(r10, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r9 & 1048575)), zzae(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x08e9, code lost:
        zza(r10, com.google.android.gms.internal.fitness.zzja.zzo(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0900, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0911, code lost:
        r15.zzf(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0921, code lost:
        r15.zzc(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0931, code lost:
        r15.zzc(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0941, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0951, code lost:
        r15.zzi(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0961, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0971, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x097a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.fitness.zzjo r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzay()
            int r1 = com.google.android.gms.internal.fitness.zzgg.zze.zzvx
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04d1
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r13.zzxn
            zza(r0, r14, (com.google.android.gms.internal.fitness.zzjo) r15)
            boolean r0 = r13.zzxo
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r13.zzxp
            com.google.android.gms.internal.fitness.zzgb r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r1 = r0.zzsj
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzxs
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x04b9
            int r8 = r13.zzag(r7)
            int[] r9 = r13.zzxs
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.fitness.zzfw<?> r10 = r13.zzxp
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.fitness.zzfw<?> r10 = r13.zzxp
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a6;
                case 1: goto L_0x0496;
                case 2: goto L_0x0486;
                case 3: goto L_0x0476;
                case 4: goto L_0x0466;
                case 5: goto L_0x0456;
                case 6: goto L_0x0446;
                case 7: goto L_0x0435;
                case 8: goto L_0x0424;
                case 9: goto L_0x040f;
                case 10: goto L_0x03fc;
                case 11: goto L_0x03eb;
                case 12: goto L_0x03da;
                case 13: goto L_0x03c9;
                case 14: goto L_0x03b8;
                case 15: goto L_0x03a7;
                case 16: goto L_0x0396;
                case 17: goto L_0x0381;
                case 18: goto L_0x0370;
                case 19: goto L_0x035f;
                case 20: goto L_0x034e;
                case 21: goto L_0x033d;
                case 22: goto L_0x032c;
                case 23: goto L_0x031b;
                case 24: goto L_0x030a;
                case 25: goto L_0x02f9;
                case 26: goto L_0x02e8;
                case 27: goto L_0x02d3;
                case 28: goto L_0x02c2;
                case 29: goto L_0x02b1;
                case 30: goto L_0x02a0;
                case 31: goto L_0x028f;
                case 32: goto L_0x027e;
                case 33: goto L_0x026d;
                case 34: goto L_0x025c;
                case 35: goto L_0x024b;
                case 36: goto L_0x023a;
                case 37: goto L_0x0229;
                case 38: goto L_0x0218;
                case 39: goto L_0x0207;
                case 40: goto L_0x01f6;
                case 41: goto L_0x01e5;
                case 42: goto L_0x01d4;
                case 43: goto L_0x01c3;
                case 44: goto L_0x01b2;
                case 45: goto L_0x01a1;
                case 46: goto L_0x0190;
                case 47: goto L_0x017f;
                case 48: goto L_0x016e;
                case 49: goto L_0x0159;
                case 50: goto L_0x014e;
                case 51: goto L_0x0140;
                case 52: goto L_0x0132;
                case 53: goto L_0x0124;
                case 54: goto L_0x0116;
                case 55: goto L_0x0108;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00ec;
                case 58: goto L_0x00de;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00ce;
                case 61: goto L_0x00c6;
                case 62: goto L_0x00b8;
                case 63: goto L_0x00aa;
                case 64: goto L_0x009c;
                case 65: goto L_0x008e;
                case 66: goto L_0x0080;
                case 67: goto L_0x0072;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x04b5
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0387
        L_0x0072:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03a2
        L_0x0080:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03b3
        L_0x008e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03c4
        L_0x009c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03d5
        L_0x00aa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03e6
        L_0x00b8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03f7
        L_0x00c6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0402
        L_0x00ce:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0415
        L_0x00d6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x042a
        L_0x00de:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            goto L_0x0441
        L_0x00ec:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0452
        L_0x00fa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0462
        L_0x0108:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0472
        L_0x0116:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0482
        L_0x0124:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0492
        L_0x0132:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            goto L_0x04a2
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            goto L_0x04b2
        L_0x014e:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            r13.zza((com.google.android.gms.internal.fitness.zzjo) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04b5
        L_0x0159:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            com.google.android.gms.internal.fitness.zzie.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x04b5
        L_0x016e:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zze(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x017f:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzj(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0190:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzg(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01a1:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzl(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01b2:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzm(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01c3:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzi(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01d4:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzn(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01e5:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzk(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01f6:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzf(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0207:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzh(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0218:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzd(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0229:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzc(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x023a:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r4)
            goto L_0x04b5
        L_0x024b:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r4)
            goto L_0x04b5
        L_0x025c:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zze(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x026d:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzj(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x027e:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzg(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x028f:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzl(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02a0:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzm(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02b1:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzi(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02c2:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb(r9, r8, r15)
            goto L_0x04b5
        L_0x02d3:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            com.google.android.gms.internal.fitness.zzie.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x04b5
        L_0x02e8:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.fitness.zzjo) r15)
            goto L_0x04b5
        L_0x02f9:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzn(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x030a:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzk(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x031b:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzf(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x032c:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzh(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x033d:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzd(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x034e:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzc(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x035f:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0370:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0381:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0387:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x04b5
        L_0x0396:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
        L_0x03a2:
            r15.zzb((int) r9, (long) r10)
            goto L_0x04b5
        L_0x03a7:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x03b3:
            r15.zze(r9, r8)
            goto L_0x04b5
        L_0x03b8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
        L_0x03c4:
            r15.zzj(r9, r10)
            goto L_0x04b5
        L_0x03c9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x03d5:
            r15.zzm(r9, r8)
            goto L_0x04b5
        L_0x03da:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x03e6:
            r15.zzn(r9, r8)
            goto L_0x04b5
        L_0x03eb:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x03f7:
            r15.zzd(r9, r8)
            goto L_0x04b5
        L_0x03fc:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0402:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzff r8 = (com.google.android.gms.internal.fitness.zzff) r8
            r15.zza((int) r9, (com.google.android.gms.internal.fitness.zzff) r8)
            goto L_0x04b5
        L_0x040f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0415:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.fitness.zzic) r10)
            goto L_0x04b5
        L_0x0424:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x042a:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.fitness.zzjo) r15)
            goto L_0x04b5
        L_0x0435:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.fitness.zzja.zzl(r14, r10)
        L_0x0441:
            r15.zza((int) r9, (boolean) r8)
            goto L_0x04b5
        L_0x0446:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x0452:
            r15.zzf(r9, r8)
            goto L_0x04b5
        L_0x0456:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
        L_0x0462:
            r15.zzc((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0466:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
        L_0x0472:
            r15.zzc((int) r9, (int) r8)
            goto L_0x04b5
        L_0x0476:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
        L_0x0482:
            r15.zza((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0486:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
        L_0x0492:
            r15.zzi(r9, r10)
            goto L_0x04b5
        L_0x0496:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.fitness.zzja.zzm(r14, r10)
        L_0x04a2:
            r15.zza((int) r9, (float) r8)
            goto L_0x04b5
        L_0x04a6:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.fitness.zzja.zzn(r14, r10)
        L_0x04b2:
            r15.zza((int) r9, (double) r10)
        L_0x04b5:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x04b9:
            if (r1 == 0) goto L_0x04d0
            com.google.android.gms.internal.fitness.zzfw<?> r14 = r13.zzxp
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04ce
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04b9
        L_0x04ce:
            r1 = r3
            goto L_0x04b9
        L_0x04d0:
            return
        L_0x04d1:
            boolean r0 = r13.zzxx
            if (r0 == 0) goto L_0x0994
            boolean r0 = r13.zzxo
            if (r0 == 0) goto L_0x04f2
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r13.zzxp
            com.google.android.gms.internal.fitness.zzgb r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r1 = r0.zzsj
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04f2
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f4
        L_0x04f2:
            r0 = r3
            r1 = r0
        L_0x04f4:
            int[] r7 = r13.zzxs
            int r7 = r7.length
            r8 = 0
        L_0x04f8:
            if (r8 >= r7) goto L_0x0978
            int r9 = r13.zzag(r8)
            int[] r10 = r13.zzxs
            r10 = r10[r8]
        L_0x0502:
            if (r1 == 0) goto L_0x0520
            com.google.android.gms.internal.fitness.zzfw<?> r11 = r13.zzxp
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0520
            com.google.android.gms.internal.fitness.zzfw<?> r11 = r13.zzxp
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x051e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0502
        L_0x051e:
            r1 = r3
            goto L_0x0502
        L_0x0520:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0965;
                case 1: goto L_0x0955;
                case 2: goto L_0x0945;
                case 3: goto L_0x0935;
                case 4: goto L_0x0925;
                case 5: goto L_0x0915;
                case 6: goto L_0x0905;
                case 7: goto L_0x08f4;
                case 8: goto L_0x08e3;
                case 9: goto L_0x08ce;
                case 10: goto L_0x08bb;
                case 11: goto L_0x08aa;
                case 12: goto L_0x0899;
                case 13: goto L_0x0888;
                case 14: goto L_0x0877;
                case 15: goto L_0x0866;
                case 16: goto L_0x0855;
                case 17: goto L_0x0840;
                case 18: goto L_0x082f;
                case 19: goto L_0x081e;
                case 20: goto L_0x080d;
                case 21: goto L_0x07fc;
                case 22: goto L_0x07eb;
                case 23: goto L_0x07da;
                case 24: goto L_0x07c9;
                case 25: goto L_0x07b8;
                case 26: goto L_0x07a7;
                case 27: goto L_0x0792;
                case 28: goto L_0x0781;
                case 29: goto L_0x0770;
                case 30: goto L_0x075f;
                case 31: goto L_0x074e;
                case 32: goto L_0x073d;
                case 33: goto L_0x072c;
                case 34: goto L_0x071b;
                case 35: goto L_0x070a;
                case 36: goto L_0x06f9;
                case 37: goto L_0x06e8;
                case 38: goto L_0x06d7;
                case 39: goto L_0x06c6;
                case 40: goto L_0x06b5;
                case 41: goto L_0x06a4;
                case 42: goto L_0x0693;
                case 43: goto L_0x0682;
                case 44: goto L_0x0671;
                case 45: goto L_0x0660;
                case 46: goto L_0x064f;
                case 47: goto L_0x063e;
                case 48: goto L_0x062d;
                case 49: goto L_0x0618;
                case 50: goto L_0x060d;
                case 51: goto L_0x05ff;
                case 52: goto L_0x05f1;
                case 53: goto L_0x05e3;
                case 54: goto L_0x05d5;
                case 55: goto L_0x05c7;
                case 56: goto L_0x05b9;
                case 57: goto L_0x05ab;
                case 58: goto L_0x059d;
                case 59: goto L_0x0595;
                case 60: goto L_0x058d;
                case 61: goto L_0x0585;
                case 62: goto L_0x0577;
                case 63: goto L_0x0569;
                case 64: goto L_0x055b;
                case 65: goto L_0x054d;
                case 66: goto L_0x053f;
                case 67: goto L_0x0531;
                case 68: goto L_0x0529;
                default: goto L_0x0527;
            }
        L_0x0527:
            goto L_0x0974
        L_0x0529:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x0846
        L_0x0531:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0861
        L_0x053f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0872
        L_0x054d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0883
        L_0x055b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0894
        L_0x0569:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08a5
        L_0x0577:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08b6
        L_0x0585:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08c1
        L_0x058d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08d4
        L_0x0595:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            goto L_0x08e9
        L_0x059d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            goto L_0x0900
        L_0x05ab:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0911
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0921
        L_0x05c7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0931
        L_0x05d5:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0941
        L_0x05e3:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x0951
        L_0x05f1:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            goto L_0x0961
        L_0x05ff:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            goto L_0x0971
        L_0x060d:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            r13.zza((com.google.android.gms.internal.fitness.zzjo) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0974
        L_0x0618:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            com.google.android.gms.internal.fitness.zzie.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (com.google.android.gms.internal.fitness.zzic) r11)
            goto L_0x0974
        L_0x062d:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zze(r10, r9, r15, r4)
            goto L_0x0974
        L_0x063e:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r10, r9, r15, r4)
            goto L_0x0974
        L_0x064f:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0660:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0671:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0682:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r10, r9, r15, r4)
            goto L_0x0974
        L_0x0693:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06a4:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06b5:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06c6:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06d7:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06e8:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r10, r9, r15, r4)
            goto L_0x0974
        L_0x06f9:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r4)
            goto L_0x0974
        L_0x070a:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r4)
            goto L_0x0974
        L_0x071b:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zze(r10, r9, r15, r5)
            goto L_0x0974
        L_0x072c:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r10, r9, r15, r5)
            goto L_0x0974
        L_0x073d:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r10, r9, r15, r5)
            goto L_0x0974
        L_0x074e:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r10, r9, r15, r5)
            goto L_0x0974
        L_0x075f:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0770:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r10, r9, r15, r5)
            goto L_0x0974
        L_0x0781:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r10, r9, r15)
            goto L_0x0974
        L_0x0792:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            com.google.android.gms.internal.fitness.zzie.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (com.google.android.gms.internal.fitness.zzic) r11)
            goto L_0x0974
        L_0x07a7:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.fitness.zzjo) r15)
            goto L_0x0974
        L_0x07b8:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07c9:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07da:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07eb:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r10, r9, r15, r5)
            goto L_0x0974
        L_0x07fc:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r10, r9, r15, r5)
            goto L_0x0974
        L_0x080d:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r10, r9, r15, r5)
            goto L_0x0974
        L_0x081e:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r5)
            goto L_0x0974
        L_0x082f:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.fitness.zzjo) r15, (boolean) r5)
            goto L_0x0974
        L_0x0840:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x0846:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.fitness.zzic) r11)
            goto L_0x0974
        L_0x0855:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
        L_0x0861:
            r15.zzb((int) r10, (long) r11)
            goto L_0x0974
        L_0x0866:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x0872:
            r15.zze(r10, r9)
            goto L_0x0974
        L_0x0877:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
        L_0x0883:
            r15.zzj(r10, r11)
            goto L_0x0974
        L_0x0888:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x0894:
            r15.zzm(r10, r9)
            goto L_0x0974
        L_0x0899:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x08a5:
            r15.zzn(r10, r9)
            goto L_0x0974
        L_0x08aa:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x08b6:
            r15.zzd(r10, r9)
            goto L_0x0974
        L_0x08bb:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08c1:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzff r9 = (com.google.android.gms.internal.fitness.zzff) r9
            r15.zza((int) r10, (com.google.android.gms.internal.fitness.zzff) r9)
            goto L_0x0974
        L_0x08ce:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08d4:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.fitness.zzic) r11)
            goto L_0x0974
        L_0x08e3:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
        L_0x08e9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.fitness.zzjo) r15)
            goto L_0x0974
        L_0x08f4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.fitness.zzja.zzl(r14, r11)
        L_0x0900:
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0974
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x0911:
            r15.zzf(r10, r9)
            goto L_0x0974
        L_0x0915:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
        L_0x0921:
            r15.zzc((int) r10, (long) r11)
            goto L_0x0974
        L_0x0925:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
        L_0x0931:
            r15.zzc((int) r10, (int) r9)
            goto L_0x0974
        L_0x0935:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
        L_0x0941:
            r15.zza((int) r10, (long) r11)
            goto L_0x0974
        L_0x0945:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
        L_0x0951:
            r15.zzi(r10, r11)
            goto L_0x0974
        L_0x0955:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.fitness.zzja.zzm(r14, r11)
        L_0x0961:
            r15.zza((int) r10, (float) r9)
            goto L_0x0974
        L_0x0965:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0974
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.fitness.zzja.zzn(r14, r11)
        L_0x0971:
            r15.zza((int) r10, (double) r11)
        L_0x0974:
            int r8 = r8 + 3
            goto L_0x04f8
        L_0x0978:
            if (r1 == 0) goto L_0x098e
            com.google.android.gms.internal.fitness.zzfw<?> r2 = r13.zzxp
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x098c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0978
        L_0x098c:
            r1 = r3
            goto L_0x0978
        L_0x098e:
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r13.zzxn
            zza(r0, r14, (com.google.android.gms.internal.fitness.zzjo) r15)
            return
        L_0x0994:
            r13.zzb(r14, (com.google.android.gms.internal.fitness.zzjo) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zza(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzya;
        while (true) {
            i = this.zzyb;
            if (i2 >= i) {
                break;
            }
            long zzag = (long) (zzag(this.zzxz[i2]) & 1048575);
            Object zzo = zzja.zzo(t, zzag);
            if (zzo != null) {
                zzja.zza((Object) t, zzag, this.zzye.zzg(zzo));
            }
            i2++;
        }
        int length = this.zzxz.length;
        while (i < length) {
            this.zzyd.zza(t, (long) this.zzxz[i]);
            i++;
        }
        this.zzxn.zzc(t);
        if (this.zzxo) {
            this.zzxp.zzc(t);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.fitness.zzja.zzo(r8, r2));
        zzb(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.fitness.zzja.zzo(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.fitness.zzja.zzj(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.fitness.zzja.zzk(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        zzb(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0105
            r0 = 0
        L_0x0003:
            int[] r1 = r6.zzxs
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzag(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzxs
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.zzb(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.fitness.zzja.zzo(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.fitness.zzhh r1 = r6.zzye
            com.google.android.gms.internal.fitness.zzie.zza((com.google.android.gms.internal.fitness.zzhh) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.fitness.zzgy r1 = r6.zzyd
            r1.zza(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.fitness.zzja.zzo(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.fitness.zzja.zzl(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.fitness.zzja.zzj(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.fitness.zzja.zzm(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.fitness.zzja.zzn(r8, r2)
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.zzb(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00f2:
            boolean r0 = r6.zzxx
            if (r0 != 0) goto L_0x0104
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r6.zzxn
            com.google.android.gms.internal.fitness.zzie.zza(r0, r7, r8)
            boolean r0 = r6.zzxo
            if (r0 == 0) goto L_0x0104
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r6.zzxp
            com.google.android.gms.internal.fitness.zzie.zza(r0, r7, r8)
        L_0x0104:
            return
        L_0x0105:
            r7 = 0
            goto L_0x0108
        L_0x0107:
            throw r7
        L_0x0108:
            goto L_0x0107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zzd(java.lang.Object, java.lang.Object):void");
    }

    public final boolean zzj(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzya) {
                return !this.zzxo || this.zzxp.zza((Object) t).isInitialized();
            }
            int i5 = this.zzxz[i3];
            int i6 = this.zzxs[i5];
            int zzag = zzag(i5);
            if (!this.zzxx) {
                int i7 = this.zzxs[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzxr.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzag) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzag) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzag, zzae(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzf = this.zzye.zzf(zzja.zzo(t, (long) (zzag & 1048575)));
                            if (!zzf.isEmpty()) {
                                if (this.zzye.zzh(zzaf(i5)).zzxi.zzdl() == zzjl.MESSAGE) {
                                    zzic<?> zzic = null;
                                    Iterator<?> it = zzf.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzic == null) {
                                            zzic = zzia.zzcp().zze(next.getClass());
                                        }
                                        if (!zzic.zzj(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzja.zzo(t, (long) (zzag & 1048575));
                if (!list.isEmpty()) {
                    zzic zzae = zzae(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzae.zzj(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzag, zzae(i5))) {
                return false;
            }
            i3++;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d7, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e8, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f9, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020a, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020c, code lost:
        r2.putInt(r1, (long) r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0210, code lost:
        r11 = ((com.google.android.gms.internal.fitness.zzfs.zzr(r3) + com.google.android.gms.internal.fitness.zzfs.zzp(r13)) + r3) + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02aa, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzc(r13, (com.google.android.gms.internal.fitness.zzho) com.google.android.gms.internal.fitness.zzja.zzo(r1, r14), zzae(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c4, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzf(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02d3, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzi(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02de, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzh(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02e9, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzk(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02f8, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzl(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0307, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzh(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0312, code lost:
        r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x031d, code lost:
        r3 = com.google.android.gms.internal.fitness.zzie.zzc(r13, com.google.android.gms.internal.fitness.zzja.zzo(r1, r14), zzae(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0329, code lost:
        r11 = r11 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0338, code lost:
        if ((r3 instanceof com.google.android.gms.internal.fitness.zzff) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x033a, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzc(r13, (com.google.android.gms.internal.fitness.zzff) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0341, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzb(r13, (java.lang.String) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x034e, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzb(r13, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0359, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzj(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0364, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzg(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0373, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzg(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0382, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zze(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0391, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzd(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x039c, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzb(r13, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a7, code lost:
        r3 = com.google.android.gms.internal.fitness.zzfs.zzb(r13, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03af, code lost:
        r10 = r10 + 3;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0476, code lost:
        if ((r6 instanceof com.google.android.gms.internal.fitness.zzff) != false) goto L_0x072c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x050b, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x051d, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x052f, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0541, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0553, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0565, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0577, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0589, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x059a, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x05ab, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x05bc, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x05cd, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x05de, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05ef, code lost:
        if (r0.zzxy != false) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05f1, code lost:
        r2.putInt(r1, (long) r10, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05f5, code lost:
        r7 = ((com.google.android.gms.internal.fitness.zzfs.zzr(r6) + com.google.android.gms.internal.fitness.zzfs.zzp(r11)) + r6) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x06b0, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzc(r11, (com.google.android.gms.internal.fitness.zzho) r2.getObject(r1, r13), zzae(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06c7, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzf(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x06d4, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzi(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x06dd, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzh(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e8, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzk(r11, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06f6, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzl(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0703, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzh(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x070c, code lost:
        r6 = r2.getObject(r1, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0714, code lost:
        r6 = com.google.android.gms.internal.fitness.zzie.zzc(r11, r2.getObject(r1, r13), zzae(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x072a, code lost:
        if ((r6 instanceof com.google.android.gms.internal.fitness.zzff) != false) goto L_0x072c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x072c, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzc(r11, (com.google.android.gms.internal.fitness.zzff) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0733, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzb(r11, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        if ((r3 instanceof com.google.android.gms.internal.fitness.zzff) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0751, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzg(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x075d, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzg(r11, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0769, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zze(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0775, code lost:
        r6 = com.google.android.gms.internal.fitness.zzfs.zzd(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0779, code lost:
        r7 = r7 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0783, code lost:
        r7 = r7 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0790, code lost:
        r4 = r4 + 3;
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0126, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0138, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014a, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015c, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0180, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0192, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a4, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b5, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c6, code lost:
        if (r0.zzxy != false) goto L_0x020c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzk(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.zzxx
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 1
            r7 = 0
            r9 = 0
            if (r2 == 0) goto L_0x03bd
            sun.misc.Unsafe r2 = zzxr
            r10 = 0
            r11 = 0
        L_0x0016:
            int[] r12 = r0.zzxs
            int r12 = r12.length
            if (r10 >= r12) goto L_0x03b5
            int r12 = r0.zzag(r10)
            r3 = r3 & r12
            int r3 = r3 >>> 20
            int[] r13 = r0.zzxs
            r13 = r13[r10]
            r12 = r12 & r5
            long r14 = (long) r12
            com.google.android.gms.internal.fitness.zzgc r12 = com.google.android.gms.internal.fitness.zzgc.DOUBLE_LIST_PACKED
            int r12 = r12.mo18219id()
            if (r3 < r12) goto L_0x0040
            com.google.android.gms.internal.fitness.zzgc r12 = com.google.android.gms.internal.fitness.zzgc.SINT64_LIST_PACKED
            int r12 = r12.mo18219id()
            if (r3 > r12) goto L_0x0040
            int[] r12 = r0.zzxs
            int r16 = r10 + 2
            r12 = r12[r16]
            r12 = r12 & r5
            goto L_0x0041
        L_0x0040:
            r12 = 0
        L_0x0041:
            switch(r3) {
                case 0: goto L_0x03a1;
                case 1: goto L_0x0396;
                case 2: goto L_0x0387;
                case 3: goto L_0x0378;
                case 4: goto L_0x0369;
                case 5: goto L_0x035e;
                case 6: goto L_0x0353;
                case 7: goto L_0x0348;
                case 8: goto L_0x032c;
                case 9: goto L_0x0317;
                case 10: goto L_0x030c;
                case 11: goto L_0x02fd;
                case 12: goto L_0x02ee;
                case 13: goto L_0x02e3;
                case 14: goto L_0x02d8;
                case 15: goto L_0x02c9;
                case 16: goto L_0x02ba;
                case 17: goto L_0x02a4;
                case 18: goto L_0x029a;
                case 19: goto L_0x0290;
                case 20: goto L_0x0286;
                case 21: goto L_0x027c;
                case 22: goto L_0x0272;
                case 23: goto L_0x029a;
                case 24: goto L_0x0290;
                case 25: goto L_0x0268;
                case 26: goto L_0x025e;
                case 27: goto L_0x0250;
                case 28: goto L_0x0246;
                case 29: goto L_0x023c;
                case 30: goto L_0x0232;
                case 31: goto L_0x0290;
                case 32: goto L_0x029a;
                case 33: goto L_0x0228;
                case 34: goto L_0x021e;
                case 35: goto L_0x01fc;
                case 36: goto L_0x01eb;
                case 37: goto L_0x01da;
                case 38: goto L_0x01c9;
                case 39: goto L_0x01b8;
                case 40: goto L_0x01a7;
                case 41: goto L_0x0196;
                case 42: goto L_0x0184;
                case 43: goto L_0x0172;
                case 44: goto L_0x0160;
                case 45: goto L_0x014e;
                case 46: goto L_0x013c;
                case 47: goto L_0x012a;
                case 48: goto L_0x0118;
                case 49: goto L_0x010a;
                case 50: goto L_0x00fa;
                case 51: goto L_0x00f2;
                case 52: goto L_0x00ea;
                case 53: goto L_0x00de;
                case 54: goto L_0x00d2;
                case 55: goto L_0x00c6;
                case 56: goto L_0x00be;
                case 57: goto L_0x00b6;
                case 58: goto L_0x00ae;
                case 59: goto L_0x009e;
                case 60: goto L_0x0096;
                case 61: goto L_0x008e;
                case 62: goto L_0x0082;
                case 63: goto L_0x0076;
                case 64: goto L_0x006e;
                case 65: goto L_0x0066;
                case 66: goto L_0x005a;
                case 67: goto L_0x004e;
                case 68: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x03af
        L_0x0046:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02aa
        L_0x004e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzh(r1, r14)
            goto L_0x02c4
        L_0x005a:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzg(r1, r14)
            goto L_0x02d3
        L_0x0066:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02de
        L_0x006e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x02e9
        L_0x0076:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzg(r1, r14)
            goto L_0x02f8
        L_0x0082:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzg(r1, r14)
            goto L_0x0307
        L_0x008e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0312
        L_0x0096:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x031d
        L_0x009e:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.fitness.zzff
            if (r12 == 0) goto L_0x0341
            goto L_0x033a
        L_0x00ae:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x034e
        L_0x00b6:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0359
        L_0x00be:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x0364
        L_0x00c6:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = zzg(r1, r14)
            goto L_0x0373
        L_0x00d2:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzh(r1, r14)
            goto L_0x0382
        L_0x00de:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = zzh(r1, r14)
            goto L_0x0391
        L_0x00ea:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x039c
        L_0x00f2:
            boolean r3 = r0.zza(r1, (int) r13, (int) r10)
            if (r3 == 0) goto L_0x03af
            goto L_0x03a7
        L_0x00fa:
            com.google.android.gms.internal.fitness.zzhh r3 = r0.zzye
            java.lang.Object r12 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            java.lang.Object r14 = r0.zzaf(r10)
            int r3 = r3.zzb(r13, r12, r14)
            goto L_0x0329
        L_0x010a:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.fitness.zzic r12 = r0.zzae(r10)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzd(r13, r3, r12)
            goto L_0x0329
        L_0x0118:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzd((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x012a:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzh(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x013c:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzj(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x014e:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0160:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zze(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0172:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzg(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0184:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzk(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x0196:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01a7:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzj(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01b8:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzf((java.util.List<java.lang.Integer>) r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01c9:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzc(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01da:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzb(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01eb:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzi(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
            goto L_0x020c
        L_0x01fc:
            java.lang.Object r3 = r2.getObject(r1, r14)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.fitness.zzie.zzj(r3)
            if (r3 <= 0) goto L_0x03af
            boolean r14 = r0.zzxy
            if (r14 == 0) goto L_0x0210
        L_0x020c:
            long r14 = (long) r12
            r2.putInt(r1, r14, r3)
        L_0x0210:
            int r12 = com.google.android.gms.internal.fitness.zzfs.zzp(r13)
            int r13 = com.google.android.gms.internal.fitness.zzfs.zzr(r3)
            int r13 = r13 + r12
            int r13 = r13 + r3
            int r13 = r13 + r11
            r11 = r13
            goto L_0x03af
        L_0x021e:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzq(r13, r3, r9)
            goto L_0x0329
        L_0x0228:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzu(r13, r3, r9)
            goto L_0x0329
        L_0x0232:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzr(r13, r3, r9)
            goto L_0x0329
        L_0x023c:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzt(r13, r3, r9)
            goto L_0x0329
        L_0x0246:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzd(r13, r3)
            goto L_0x0329
        L_0x0250:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            com.google.android.gms.internal.fitness.zzic r12 = r0.zzae(r10)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzc((int) r13, (java.util.List<?>) r3, (com.google.android.gms.internal.fitness.zzic) r12)
            goto L_0x0329
        L_0x025e:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzc(r13, r3)
            goto L_0x0329
        L_0x0268:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzx(r13, r3, r9)
            goto L_0x0329
        L_0x0272:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzs(r13, r3, r9)
            goto L_0x0329
        L_0x027c:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzp(r13, r3, r9)
            goto L_0x0329
        L_0x0286:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzo(r13, r3, r9)
            goto L_0x0329
        L_0x0290:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzv(r13, r3, r9)
            goto L_0x0329
        L_0x029a:
            java.util.List r3 = zzd((java.lang.Object) r1, (long) r14)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzw(r13, r3, r9)
            goto L_0x0329
        L_0x02a4:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02aa:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            com.google.android.gms.internal.fitness.zzho r3 = (com.google.android.gms.internal.fitness.zzho) r3
            com.google.android.gms.internal.fitness.zzic r12 = r0.zzae(r10)
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzc(r13, r3, r12)
            goto L_0x0329
        L_0x02ba:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.fitness.zzja.zzk(r1, r14)
        L_0x02c4:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzf((int) r13, (long) r14)
            goto L_0x0329
        L_0x02c9:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.fitness.zzja.zzj(r1, r14)
        L_0x02d3:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzi(r13, r3)
            goto L_0x0329
        L_0x02d8:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02de:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzh((int) r13, (long) r7)
            goto L_0x0329
        L_0x02e3:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x02e9:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzk(r13, r9)
            goto L_0x0329
        L_0x02ee:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.fitness.zzja.zzj(r1, r14)
        L_0x02f8:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzl(r13, r3)
            goto L_0x0329
        L_0x02fd:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.fitness.zzja.zzj(r1, r14)
        L_0x0307:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzh((int) r13, (int) r3)
            goto L_0x0329
        L_0x030c:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0312:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            goto L_0x033a
        L_0x0317:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x031d:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            com.google.android.gms.internal.fitness.zzic r12 = r0.zzae(r10)
            int r3 = com.google.android.gms.internal.fitness.zzie.zzc((int) r13, (java.lang.Object) r3, (com.google.android.gms.internal.fitness.zzic) r12)
        L_0x0329:
            int r11 = r11 + r3
            goto L_0x03af
        L_0x032c:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r1, r14)
            boolean r12 = r3 instanceof com.google.android.gms.internal.fitness.zzff
            if (r12 == 0) goto L_0x0341
        L_0x033a:
            com.google.android.gms.internal.fitness.zzff r3 = (com.google.android.gms.internal.fitness.zzff) r3
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzc((int) r13, (com.google.android.gms.internal.fitness.zzff) r3)
            goto L_0x0329
        L_0x0341:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r13, (java.lang.String) r3)
            goto L_0x0329
        L_0x0348:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x034e:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r13, (boolean) r6)
            goto L_0x0329
        L_0x0353:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0359:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzj(r13, r9)
            goto L_0x0329
        L_0x035e:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x0364:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzg((int) r13, (long) r7)
            goto L_0x0329
        L_0x0369:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            int r3 = com.google.android.gms.internal.fitness.zzja.zzj(r1, r14)
        L_0x0373:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzg((int) r13, (int) r3)
            goto L_0x0329
        L_0x0378:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.fitness.zzja.zzk(r1, r14)
        L_0x0382:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zze((int) r13, (long) r14)
            goto L_0x0329
        L_0x0387:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
            long r14 = com.google.android.gms.internal.fitness.zzja.zzk(r1, r14)
        L_0x0391:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzd((int) r13, (long) r14)
            goto L_0x0329
        L_0x0396:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x039c:
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r13, (float) r4)
            goto L_0x0329
        L_0x03a1:
            boolean r3 = r0.zza(r1, (int) r10)
            if (r3 == 0) goto L_0x03af
        L_0x03a7:
            r14 = 0
            int r3 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r13, (double) r14)
            goto L_0x0329
        L_0x03af:
            int r10 = r10 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03b5:
            com.google.android.gms.internal.fitness.zziu<?, ?> r2 = r0.zzxn
            int r1 = zza(r2, r1)
            int r11 = r11 + r1
            return r11
        L_0x03bd:
            sun.misc.Unsafe r2 = zzxr
            r3 = -1
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x03c3:
            int[] r9 = r0.zzxs
            int r9 = r9.length
            if (r4 >= r9) goto L_0x0795
            int r9 = r0.zzag(r4)
            int[] r10 = r0.zzxs
            r11 = r10[r4]
            r12 = 267386880(0xff00000, float:2.3665827E-29)
            r12 = r12 & r9
            int r12 = r12 >>> 20
            r13 = 17
            if (r12 > r13) goto L_0x03eb
            int r13 = r4 + 2
            r10 = r10[r13]
            r13 = r10 & r5
            int r14 = r10 >>> 20
            int r6 = r6 << r14
            if (r13 == r3) goto L_0x040b
            long r14 = (long) r13
            int r8 = r2.getInt(r1, r14)
            r3 = r13
            goto L_0x040b
        L_0x03eb:
            boolean r6 = r0.zzxy
            if (r6 == 0) goto L_0x0408
            com.google.android.gms.internal.fitness.zzgc r6 = com.google.android.gms.internal.fitness.zzgc.DOUBLE_LIST_PACKED
            int r6 = r6.mo18219id()
            if (r12 < r6) goto L_0x0408
            com.google.android.gms.internal.fitness.zzgc r6 = com.google.android.gms.internal.fitness.zzgc.SINT64_LIST_PACKED
            int r6 = r6.mo18219id()
            if (r12 > r6) goto L_0x0408
            int[] r6 = r0.zzxs
            int r10 = r4 + 2
            r6 = r6[r10]
            r6 = r6 & r5
            r10 = r6
            goto L_0x040a
        L_0x0408:
            r6 = 0
            r10 = 0
        L_0x040a:
            r6 = 0
        L_0x040b:
            r9 = r9 & r5
            long r13 = (long) r9
            switch(r12) {
                case 0: goto L_0x0785;
                case 1: goto L_0x077b;
                case 2: goto L_0x076e;
                case 3: goto L_0x0762;
                case 4: goto L_0x0756;
                case 5: goto L_0x074c;
                case 6: goto L_0x0743;
                case 7: goto L_0x073a;
                case 8: goto L_0x0721;
                case 9: goto L_0x0711;
                case 10: goto L_0x0709;
                case 11: goto L_0x06fc;
                case 12: goto L_0x06ef;
                case 13: goto L_0x06e5;
                case 14: goto L_0x06da;
                case 15: goto L_0x06cd;
                case 16: goto L_0x06c0;
                case 17: goto L_0x06ad;
                case 18: goto L_0x066c;
                case 19: goto L_0x06a0;
                case 20: goto L_0x0693;
                case 21: goto L_0x0686;
                case 22: goto L_0x0679;
                case 23: goto L_0x066c;
                case 24: goto L_0x06a0;
                case 25: goto L_0x065f;
                case 26: goto L_0x0653;
                case 27: goto L_0x0643;
                case 28: goto L_0x0637;
                case 29: goto L_0x062a;
                case 30: goto L_0x061d;
                case 31: goto L_0x06a0;
                case 32: goto L_0x066c;
                case 33: goto L_0x0610;
                case 34: goto L_0x0603;
                case 35: goto L_0x05e1;
                case 36: goto L_0x05d0;
                case 37: goto L_0x05bf;
                case 38: goto L_0x05ae;
                case 39: goto L_0x059d;
                case 40: goto L_0x058c;
                case 41: goto L_0x057b;
                case 42: goto L_0x0569;
                case 43: goto L_0x0557;
                case 44: goto L_0x0545;
                case 45: goto L_0x0533;
                case 46: goto L_0x0521;
                case 47: goto L_0x050f;
                case 48: goto L_0x04fd;
                case 49: goto L_0x04ed;
                case 50: goto L_0x04dd;
                case 51: goto L_0x04cf;
                case 52: goto L_0x04c2;
                case 53: goto L_0x04b6;
                case 54: goto L_0x04aa;
                case 55: goto L_0x049e;
                case 56: goto L_0x0494;
                case 57: goto L_0x0487;
                case 58: goto L_0x047a;
                case 59: goto L_0x046a;
                case 60: goto L_0x0462;
                case 61: goto L_0x045a;
                case 62: goto L_0x044e;
                case 63: goto L_0x0442;
                case 64: goto L_0x043a;
                case 65: goto L_0x0432;
                case 66: goto L_0x0426;
                case 67: goto L_0x041a;
                case 68: goto L_0x0412;
                default: goto L_0x0410;
            }
        L_0x0410:
            goto L_0x0790
        L_0x0412:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06b0
        L_0x041a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzh(r1, r13)
            goto L_0x06c7
        L_0x0426:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzg(r1, r13)
            goto L_0x06d4
        L_0x0432:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06dd
        L_0x043a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x06e8
        L_0x0442:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzg(r1, r13)
            goto L_0x06f6
        L_0x044e:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzg(r1, r13)
            goto L_0x0703
        L_0x045a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x070c
        L_0x0462:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            goto L_0x0714
        L_0x046a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.fitness.zzff
            if (r9 == 0) goto L_0x0733
            goto L_0x072c
        L_0x047a:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 1
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (boolean) r6)
            goto L_0x0779
        L_0x0487:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzj(r11, r6)
            goto L_0x0779
        L_0x0494:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r9 = 0
            goto L_0x0751
        L_0x049e:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            int r6 = zzg(r1, r13)
            goto L_0x075d
        L_0x04aa:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzh(r1, r13)
            goto L_0x0769
        L_0x04b6:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            long r9 = zzh(r1, r13)
            goto L_0x0775
        L_0x04c2:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (float) r6)
            goto L_0x0779
        L_0x04cf:
            boolean r6 = r0.zza(r1, (int) r11, (int) r4)
            if (r6 == 0) goto L_0x0790
            r9 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (double) r9)
            goto L_0x0779
        L_0x04dd:
            com.google.android.gms.internal.fitness.zzhh r6 = r0.zzye
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.lang.Object r10 = r0.zzaf(r4)
            int r6 = r6.zzb(r11, r9, r10)
            goto L_0x0779
        L_0x04ed:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r4)
            int r6 = com.google.android.gms.internal.fitness.zzie.zzd(r11, r6, r9)
            goto L_0x0779
        L_0x04fd:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzd((java.util.List<java.lang.Long>) r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x050f:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzh(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0521:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzj(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0533:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzi(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0545:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zze(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0557:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzg(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x0569:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzk(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x057b:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzi(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x058c:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzj(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x059d:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzf((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05ae:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzc(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05bf:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzb(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05d0:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzi(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
            goto L_0x05f1
        L_0x05e1:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzj(r6)
            if (r6 <= 0) goto L_0x0790
            boolean r9 = r0.zzxy
            if (r9 == 0) goto L_0x05f5
        L_0x05f1:
            long r9 = (long) r10
            r2.putInt(r1, r9, r6)
        L_0x05f5:
            int r9 = com.google.android.gms.internal.fitness.zzfs.zzp(r11)
            int r10 = com.google.android.gms.internal.fitness.zzfs.zzr(r6)
            int r10 = r10 + r9
            int r10 = r10 + r6
            int r10 = r10 + r7
            r7 = r10
            goto L_0x0790
        L_0x0603:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.fitness.zzie.zzq(r11, r6, r9)
            goto L_0x0779
        L_0x0610:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzu(r11, r9, r6)
            goto L_0x0779
        L_0x061d:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzr(r11, r9, r6)
            goto L_0x0779
        L_0x062a:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzt(r11, r9, r6)
            goto L_0x0779
        L_0x0637:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzd(r11, r6)
            goto L_0x0779
        L_0x0643:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r4)
            int r6 = com.google.android.gms.internal.fitness.zzie.zzc((int) r11, (java.util.List<?>) r6, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0779
        L_0x0653:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.fitness.zzie.zzc(r11, r6)
            goto L_0x0779
        L_0x065f:
            java.lang.Object r6 = r2.getObject(r1, r13)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.fitness.zzie.zzx(r11, r6, r9)
            goto L_0x0779
        L_0x066c:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzw(r11, r9, r6)
            goto L_0x0779
        L_0x0679:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzs(r11, r9, r6)
            goto L_0x0779
        L_0x0686:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzp(r11, r9, r6)
            goto L_0x0779
        L_0x0693:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzo(r11, r9, r6)
            goto L_0x0779
        L_0x06a0:
            r6 = 0
            java.lang.Object r9 = r2.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            int r6 = com.google.android.gms.internal.fitness.zzie.zzv(r11, r9, r6)
            goto L_0x0779
        L_0x06ad:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06b0:
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.fitness.zzho r6 = (com.google.android.gms.internal.fitness.zzho) r6
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r4)
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzc(r11, r6, r9)
            goto L_0x0779
        L_0x06c0:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x06c7:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzf((int) r11, (long) r9)
            goto L_0x0779
        L_0x06cd:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x06d4:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzi(r11, r6)
            goto L_0x0779
        L_0x06da:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06dd:
            r9 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzh((int) r11, (long) r9)
            goto L_0x0779
        L_0x06e5:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x06e8:
            r6 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzk(r11, r6)
            goto L_0x0779
        L_0x06ef:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x06f6:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzl(r11, r6)
            goto L_0x0779
        L_0x06fc:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x0703:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzh((int) r11, (int) r6)
            goto L_0x0779
        L_0x0709:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x070c:
            java.lang.Object r6 = r2.getObject(r1, r13)
            goto L_0x072c
        L_0x0711:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
        L_0x0714:
            java.lang.Object r6 = r2.getObject(r1, r13)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r4)
            int r6 = com.google.android.gms.internal.fitness.zzie.zzc((int) r11, (java.lang.Object) r6, (com.google.android.gms.internal.fitness.zzic) r9)
            goto L_0x0779
        L_0x0721:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            java.lang.Object r6 = r2.getObject(r1, r13)
            boolean r9 = r6 instanceof com.google.android.gms.internal.fitness.zzff
            if (r9 == 0) goto L_0x0733
        L_0x072c:
            com.google.android.gms.internal.fitness.zzff r6 = (com.google.android.gms.internal.fitness.zzff) r6
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzc((int) r11, (com.google.android.gms.internal.fitness.zzff) r6)
            goto L_0x0779
        L_0x0733:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (java.lang.String) r6)
            goto L_0x0779
        L_0x073a:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 1
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (boolean) r6)
            goto L_0x0783
        L_0x0743:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzj(r11, r6)
            goto L_0x0783
        L_0x074c:
            r6 = r6 & r8
            r9 = 0
            if (r6 == 0) goto L_0x0790
        L_0x0751:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzg((int) r11, (long) r9)
            goto L_0x0779
        L_0x0756:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            int r6 = r2.getInt(r1, r13)
        L_0x075d:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzg((int) r11, (int) r6)
            goto L_0x0779
        L_0x0762:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x0769:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zze((int) r11, (long) r9)
            goto L_0x0779
        L_0x076e:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            long r9 = r2.getLong(r1, r13)
        L_0x0775:
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzd((int) r11, (long) r9)
        L_0x0779:
            int r7 = r7 + r6
            goto L_0x0790
        L_0x077b:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r6 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (float) r6)
        L_0x0783:
            int r7 = r7 + r6
            goto L_0x0790
        L_0x0785:
            r6 = r6 & r8
            if (r6 == 0) goto L_0x0790
            r9 = 0
            int r6 = com.google.android.gms.internal.fitness.zzfs.zzb((int) r11, (double) r9)
            int r6 = r6 + r7
            r7 = r6
        L_0x0790:
            int r4 = r4 + 3
            r6 = 1
            goto L_0x03c3
        L_0x0795:
            r2 = 0
            com.google.android.gms.internal.fitness.zziu<?, ?> r3 = r0.zzxn
            int r3 = zza(r3, r1)
            int r7 = r7 + r3
            boolean r3 = r0.zzxo
            if (r3 == 0) goto L_0x07ef
            com.google.android.gms.internal.fitness.zzfw<?> r3 = r0.zzxp
            com.google.android.gms.internal.fitness.zzgb r1 = r3.zza((java.lang.Object) r1)
            r3 = 0
        L_0x07a8:
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r4 = r1.zzsj
            int r4 = r4.zzcq()
            if (r3 >= r4) goto L_0x07c8
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r4 = r1.zzsj
            java.util.Map$Entry r4 = r4.zzaj(r3)
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.fitness.zzgd r5 = (com.google.android.gms.internal.fitness.zzgd) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.fitness.zzgb.zzb((com.google.android.gms.internal.fitness.zzgd<?>) r5, (java.lang.Object) r4)
            int r2 = r2 + r4
            int r3 = r3 + 1
            goto L_0x07a8
        L_0x07c8:
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r1 = r1.zzsj
            java.lang.Iterable r1 = r1.zzcr()
            java.util.Iterator r1 = r1.iterator()
        L_0x07d2:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x07ee
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.fitness.zzgd r4 = (com.google.android.gms.internal.fitness.zzgd) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.fitness.zzgb.zzb((com.google.android.gms.internal.fitness.zzgd<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x07d2
        L_0x07ee:
            int r7 = r7 + r2
        L_0x07ef:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zzk(java.lang.Object):int");
    }
}
