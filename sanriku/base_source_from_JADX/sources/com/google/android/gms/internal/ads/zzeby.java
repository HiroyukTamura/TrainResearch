package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzeby {
    DOUBLE(0, zzeca.SCALAR, zzecq.DOUBLE),
    FLOAT(1, zzeca.SCALAR, zzecq.FLOAT),
    INT64(2, zzeca.SCALAR, zzecq.LONG),
    UINT64(3, zzeca.SCALAR, zzecq.LONG),
    INT32(4, zzeca.SCALAR, zzecq.INT),
    FIXED64(5, zzeca.SCALAR, zzecq.LONG),
    FIXED32(6, zzeca.SCALAR, zzecq.INT),
    BOOL(7, zzeca.SCALAR, zzecq.BOOLEAN),
    STRING(8, zzeca.SCALAR, zzecq.STRING),
    MESSAGE(9, zzeca.SCALAR, zzecq.MESSAGE),
    BYTES(10, zzeca.SCALAR, zzecq.BYTE_STRING),
    UINT32(11, zzeca.SCALAR, zzecq.INT),
    ENUM(12, zzeca.SCALAR, zzecq.ENUM),
    SFIXED32(13, zzeca.SCALAR, zzecq.INT),
    SFIXED64(14, zzeca.SCALAR, zzecq.LONG),
    SINT32(15, zzeca.SCALAR, zzecq.INT),
    SINT64(16, zzeca.SCALAR, zzecq.LONG),
    GROUP(17, zzeca.SCALAR, zzecq.MESSAGE),
    DOUBLE_LIST(18, zzeca.VECTOR, zzecq.DOUBLE),
    FLOAT_LIST(19, zzeca.VECTOR, zzecq.FLOAT),
    INT64_LIST(20, zzeca.VECTOR, zzecq.LONG),
    UINT64_LIST(21, zzeca.VECTOR, zzecq.LONG),
    INT32_LIST(22, zzeca.VECTOR, zzecq.INT),
    FIXED64_LIST(23, zzeca.VECTOR, zzecq.LONG),
    FIXED32_LIST(24, zzeca.VECTOR, zzecq.INT),
    BOOL_LIST(25, zzeca.VECTOR, zzecq.BOOLEAN),
    STRING_LIST(26, zzeca.VECTOR, zzecq.STRING),
    MESSAGE_LIST(27, zzeca.VECTOR, zzecq.MESSAGE),
    BYTES_LIST(28, zzeca.VECTOR, zzecq.BYTE_STRING),
    UINT32_LIST(29, zzeca.VECTOR, zzecq.INT),
    ENUM_LIST(30, zzeca.VECTOR, zzecq.ENUM),
    SFIXED32_LIST(31, zzeca.VECTOR, zzecq.INT),
    SFIXED64_LIST(32, zzeca.VECTOR, zzecq.LONG),
    SINT32_LIST(33, zzeca.VECTOR, zzecq.INT),
    SINT64_LIST(34, zzeca.VECTOR, zzecq.LONG),
    DOUBLE_LIST_PACKED(35, zzeca.PACKED_VECTOR, zzecq.DOUBLE),
    FLOAT_LIST_PACKED(36, zzeca.PACKED_VECTOR, zzecq.FLOAT),
    INT64_LIST_PACKED(37, zzeca.PACKED_VECTOR, zzecq.LONG),
    UINT64_LIST_PACKED(38, zzeca.PACKED_VECTOR, zzecq.LONG),
    INT32_LIST_PACKED(39, zzeca.PACKED_VECTOR, zzecq.INT),
    FIXED64_LIST_PACKED(40, zzeca.PACKED_VECTOR, zzecq.LONG),
    FIXED32_LIST_PACKED(41, zzeca.PACKED_VECTOR, zzecq.INT),
    BOOL_LIST_PACKED(42, zzeca.PACKED_VECTOR, zzecq.BOOLEAN),
    UINT32_LIST_PACKED(43, zzeca.PACKED_VECTOR, zzecq.INT),
    ENUM_LIST_PACKED(44, zzeca.PACKED_VECTOR, zzecq.ENUM),
    SFIXED32_LIST_PACKED(45, zzeca.PACKED_VECTOR, zzecq.INT),
    SFIXED64_LIST_PACKED(46, zzeca.PACKED_VECTOR, zzecq.LONG),
    SINT32_LIST_PACKED(47, zzeca.PACKED_VECTOR, zzecq.INT),
    SINT64_LIST_PACKED(48, zzeca.PACKED_VECTOR, zzecq.LONG),
    GROUP_LIST(49, zzeca.VECTOR, zzecq.MESSAGE),
    MAP(50, zzeca.MAP, zzecq.VOID);
    
    private static final zzeby[] zzhxf = null;
    private static final Type[] zzhxg = null;

    /* renamed from: id */
    private final int f353id;
    private final zzecq zzhxb;
    private final zzeca zzhxc;
    private final Class<?> zzhxd;
    private final boolean zzhxe;

    static {
        int i;
        zzhxg = new Type[0];
        zzeby[] values = values();
        zzhxf = new zzeby[values.length];
        for (zzeby zzeby : values) {
            zzhxf[zzeby.f353id] = zzeby;
        }
    }

    private zzeby(int i, zzeca zzeca, zzecq zzecq) {
        int i2;
        this.f353id = i;
        this.zzhxc = zzeca;
        this.zzhxb = zzecq;
        int i3 = zzebx.zzhva[zzeca.ordinal()];
        boolean z = true;
        this.zzhxd = (i3 == 1 || i3 == 2) ? zzecq.zzbfq() : null;
        this.zzhxe = (zzeca != zzeca.SCALAR || (i2 = zzebx.zzhvb[zzecq.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    /* renamed from: id */
    public final int mo16557id() {
        return this.f353id;
    }
}
