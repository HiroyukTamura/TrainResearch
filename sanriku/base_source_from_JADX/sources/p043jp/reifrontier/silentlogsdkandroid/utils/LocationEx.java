package p043jp.reifrontier.silentlogsdkandroid.utils;

import java.util.List;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/LocationEx;", "", "()V", "fourDigitJapan", "", "", "getFourDigitJapan", "()Ljava/util/List;", "threeDigitJapan", "getThreeDigitJapan", "twoDigitJapan", "getTwoDigitJapan", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.LocationEx */
public final class LocationEx {
    public static final LocationEx INSTANCE = new LocationEx();

    /* renamed from: a */
    private static final List<String> f3807a = CollectionsKt__CollectionsKt.listOf("xn", "xj", "xh", "wu", "xr", "xq", "xm");

    /* renamed from: b */
    private static final List<String> f3808b = CollectionsKt__CollectionsKt.listOf("wsx", "wsr", "wvg", "wvu", "wvv", "wvy", "wvz", "wv8", "wv9", "wvd", "wve", "wvs", "wvs", "wvs", "wvt", "wvw", "wvx", "wv2", "wv3", "wv6", "wv7", "wvk", "wvm", "wvq", "wvr", "wv0", "wv1", "wv4", "wv5", "wvh", "wvj", "wvn", "wvp", "wyw", "wyx", "wym", "wyq", "wyr", "wyj", "wyn", "wyp", "wyh", "xpf", "xpg", "xpu", "xpv", "xpy", "xpz", "xpd", "xpe", "xps", "xpt", "xpw", "xpx", "xp2", "xp3", "xp6", "xp7", "xpk", "xpm", "xpq", "xpr", "xp0", "xp1", "xp4", "xp5", "xph", "xpj", "xpn", "xpp", "xkb", "xk8", "xk2", "xk0", "xkc", "xk9", "xk3", "xk1", "xkf", "xkf", "xk6", "xk4", "xkg", "xke", "xk7", "xk5", "xku", "xks", "xkk", "xkh", "xkv", "xkt", "xkm", "xkj", "x5b", "x5c", "x58", "x59", "z20", "z21");

    /* renamed from: c */
    private static final List<String> f3809c = CollectionsKt__CollectionsKt.listOf("wyts", "wytu", "wyte", "wytg", "wytd", "wytf", "wyt9", "wytc", "wyt8", "wytb", "wy5v", "wy5u", "wy5g", "wy5f", "z0h5", "z0h7", "z0he", "z0hg", "z0h4", "z0h6", "z0hd", "z0hf", "z0h1", "z0h3", "z0h9", "z0hc", "z0h0", "z0h2", "z0h8", "z0hb", "z0j5", "z0j7", "z0je", "z0jg", "z0j4", "z0j6", "z0jd", "z0jf", "z0j1", "z0j3", "z0j9", "z0jc", "z0j0", "z0j2", "z0j8", "z0jb");

    private LocationEx() {
    }

    public final List<String> getFourDigitJapan() {
        return f3809c;
    }

    public final List<String> getThreeDigitJapan() {
        return f3808b;
    }

    public final List<String> getTwoDigitJapan() {
        return f3807a;
    }
}
