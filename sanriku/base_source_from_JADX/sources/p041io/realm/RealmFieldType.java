package p041io.realm;

import java.nio.ByteBuffer;
import java.util.Date;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.Keep;
import p043jp.reifrontier.silentlogsdkandroid.BuildConfig;

@Keep
/* renamed from: io.realm.RealmFieldType */
public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    LIST(13),
    LINKING_OBJECTS(14),
    INTEGER_LIST(128),
    BOOLEAN_LIST(129),
    STRING_LIST(130),
    BINARY_LIST(132),
    DATE_LIST(BuildConfig.VERSION_CODE),
    FLOAT_LIST(137),
    DOUBLE_LIST(138);
    
    private static final RealmFieldType[] basicTypes = null;
    private static final RealmFieldType[] listTypes = null;
    private final int nativeValue;

    static {
        int i;
        basicTypes = new RealmFieldType[15];
        listTypes = new RealmFieldType[15];
        for (RealmFieldType realmFieldType : values()) {
            int i2 = realmFieldType.nativeValue;
            if (i2 < 128) {
                basicTypes[i2] = realmFieldType;
            } else {
                listTypes[i2 - 128] = realmFieldType;
            }
        }
    }

    private RealmFieldType(int i) {
        this.nativeValue = i;
    }

    public static RealmFieldType fromNativeValue(int i) {
        RealmFieldType realmFieldType;
        RealmFieldType realmFieldType2;
        if (i >= 0) {
            RealmFieldType[] realmFieldTypeArr = basicTypes;
            if (i < realmFieldTypeArr.length && (realmFieldType2 = realmFieldTypeArr[i]) != null) {
                return realmFieldType2;
            }
        }
        if (128 <= i) {
            int i2 = i - 128;
            RealmFieldType[] realmFieldTypeArr2 = listTypes;
            if (i2 < realmFieldTypeArr2.length && (realmFieldType = realmFieldTypeArr2[i2]) != null) {
                return realmFieldType;
            }
        }
        throw new IllegalArgumentException(C0681a.m316a("Invalid native Realm type: ", i));
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    public boolean isValid(Object obj) {
        int i = this.nativeValue;
        if (i == 0) {
            return (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte);
        }
        if (i == 1) {
            return obj instanceof Boolean;
        }
        if (i == 2) {
            return obj instanceof String;
        }
        if (i == 4) {
            return (obj instanceof byte[]) || (obj instanceof ByteBuffer);
        }
        if (i == 132) {
            return false;
        }
        switch (i) {
            case 8:
                return obj instanceof Date;
            case 9:
                return obj instanceof Float;
            case 10:
                return obj instanceof Double;
            default:
                switch (i) {
                    case 12:
                    case 13:
                    case 14:
                        break;
                    default:
                        switch (i) {
                            case 128:
                            case 129:
                            case 130:
                                break;
                            default:
                                switch (i) {
                                    case BuildConfig.VERSION_CODE /*136*/:
                                    case 137:
                                    case 138:
                                        break;
                                    default:
                                        throw new RuntimeException("Unsupported Realm type:  " + this);
                                }
                        }
                }
                return false;
        }
    }
}
