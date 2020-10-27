package p043jp.reifrontier.gym.data.hash;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/data/hash/HashIdManager;", "", "()V", "ALPHABET", "", "MIN_HASH_LENGTH", "", "SALT", "hashIdsInstance", "Ljp/reifrontier/gym/data/hash/Hashids;", "decode", "hashValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "encode", "number", "default", "isIdHash", "", "isNumber", "value", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.hash.HashIdManager */
public final class HashIdManager {
    private static final String ALPHABET = "abcdefghij1234567890";
    public static final HashIdManager INSTANCE = new HashIdManager();
    private static final int MIN_HASH_LENGTH = 8;
    private static final String SALT = "most-strong-avengers";
    private static final Hashids hashIdsInstance = new Hashids(SALT, 8, ALPHABET);

    private HashIdManager() {
    }

    public static /* synthetic */ String encode$default(HashIdManager hashIdManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = RFGDef.INSTANCE.getDEFAULT_GYM_ID_HASH();
        }
        return hashIdManager.encode(str, str2);
    }

    private final boolean isNumber(String str) {
        return Pattern.compile("^[0-9]+$").matcher(str).find();
    }

    public final Integer decode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hashValue");
        long[] decode = hashIdsInstance.decode(str);
        if (decode.length != 1) {
            return null;
        }
        return Integer.valueOf((int) decode[0]);
    }

    public final String encode(int i) {
        return hashIdsInstance.encode((long) i);
    }

    public final String encode(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "default");
        return (str == null || !isNumber(str)) ? str2 : encode(Integer.parseInt(str));
    }

    public final boolean isIdHash(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hashValue");
        return Pattern.compile("^[a-zA-Z0-9]{8}$").matcher(str).find();
    }
}
