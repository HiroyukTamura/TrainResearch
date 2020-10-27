package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzhw {
    DOUBLE(0, zzhy.SCALAR, zzil.DOUBLE),
    FLOAT(1, zzhy.SCALAR, zzil.FLOAT),
    INT64(2, zzhy.SCALAR, zzil.LONG),
    UINT64(3, zzhy.SCALAR, zzil.LONG),
    INT32(4, zzhy.SCALAR, zzil.INT),
    FIXED64(5, zzhy.SCALAR, zzil.LONG),
    FIXED32(6, zzhy.SCALAR, zzil.INT),
    BOOL(7, zzhy.SCALAR, zzil.BOOLEAN),
    STRING(8, zzhy.SCALAR, zzil.STRING),
    MESSAGE(9, zzhy.SCALAR, zzil.MESSAGE),
    BYTES(10, zzhy.SCALAR, zzil.BYTE_STRING),
    UINT32(11, zzhy.SCALAR, zzil.INT),
    ENUM(12, zzhy.SCALAR, zzil.ENUM),
    SFIXED32(13, zzhy.SCALAR, zzil.INT),
    SFIXED64(14, zzhy.SCALAR, zzil.LONG),
    SINT32(15, zzhy.SCALAR, zzil.INT),
    SINT64(16, zzhy.SCALAR, zzil.LONG),
    GROUP(17, zzhy.SCALAR, zzil.MESSAGE),
    DOUBLE_LIST(18, zzhy.VECTOR, zzil.DOUBLE),
    FLOAT_LIST(19, zzhy.VECTOR, zzil.FLOAT),
    INT64_LIST(20, zzhy.VECTOR, zzil.LONG),
    UINT64_LIST(21, zzhy.VECTOR, zzil.LONG),
    INT32_LIST(22, zzhy.VECTOR, zzil.INT),
    FIXED64_LIST(23, zzhy.VECTOR, zzil.LONG),
    FIXED32_LIST(24, zzhy.VECTOR, zzil.INT),
    BOOL_LIST(25, zzhy.VECTOR, zzil.BOOLEAN),
    STRING_LIST(26, zzhy.VECTOR, zzil.STRING),
    MESSAGE_LIST(27, zzhy.VECTOR, zzil.MESSAGE),
    BYTES_LIST(28, zzhy.VECTOR, zzil.BYTE_STRING),
    UINT32_LIST(29, zzhy.VECTOR, zzil.INT),
    ENUM_LIST(30, zzhy.VECTOR, zzil.ENUM),
    SFIXED32_LIST(31, zzhy.VECTOR, zzil.INT),
    SFIXED64_LIST(32, zzhy.VECTOR, zzil.LONG),
    SINT32_LIST(33, zzhy.VECTOR, zzil.INT),
    SINT64_LIST(34, zzhy.VECTOR, zzil.LONG),
    DOUBLE_LIST_PACKED(35, zzhy.PACKED_VECTOR, zzil.DOUBLE),
    FLOAT_LIST_PACKED(36, zzhy.PACKED_VECTOR, zzil.FLOAT),
    INT64_LIST_PACKED(37, zzhy.PACKED_VECTOR, zzil.LONG),
    UINT64_LIST_PACKED(38, zzhy.PACKED_VECTOR, zzil.LONG),
    INT32_LIST_PACKED(39, zzhy.PACKED_VECTOR, zzil.INT),
    FIXED64_LIST_PACKED(40, zzhy.PACKED_VECTOR, zzil.LONG),
    FIXED32_LIST_PACKED(41, zzhy.PACKED_VECTOR, zzil.INT),
    BOOL_LIST_PACKED(42, zzhy.PACKED_VECTOR, zzil.BOOLEAN),
    UINT32_LIST_PACKED(43, zzhy.PACKED_VECTOR, zzil.INT),
    ENUM_LIST_PACKED(44, zzhy.PACKED_VECTOR, zzil.ENUM),
    SFIXED32_LIST_PACKED(45, zzhy.PACKED_VECTOR, zzil.INT),
    SFIXED64_LIST_PACKED(46, zzhy.PACKED_VECTOR, zzil.LONG),
    SINT32_LIST_PACKED(47, zzhy.PACKED_VECTOR, zzil.INT),
    SINT64_LIST_PACKED(48, zzhy.PACKED_VECTOR, zzil.LONG),
    GROUP_LIST(49, zzhy.VECTOR, zzil.MESSAGE),
    MAP(50, zzhy.MAP, zzil.VOID);
    
    private static final zzhw[] zzbe = null;
    private static final Type[] zzbf = null;
    private final zzil zzaz;
    private final int zzba;
    private final zzhy zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    static {
        int i;
        zzbf = new Type[0];
        zzhw[] values = values();
        zzbe = new zzhw[values.length];
        for (zzhw zzhw : values) {
            zzbe[zzhw.zzba] = zzhw;
        }
    }

    private zzhw(int i, zzhy zzhy, zzil zzil) {
        int i2;
        this.zzba = i;
        this.zzbb = zzhy;
        this.zzaz = zzil;
        int i3 = zzhv.zza[zzhy.ordinal()];
        boolean z = true;
        this.zzbc = (i3 == 1 || i3 == 2) ? zzil.zza() : null;
        this.zzbd = (zzhy != zzhy.SCALAR || (i2 = zzhv.zzb[zzil.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int zza() {
        return this.zzba;
    }
}
