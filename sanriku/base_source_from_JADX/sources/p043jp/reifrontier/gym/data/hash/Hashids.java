package p043jp.reifrontier.gym.data.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u0012\u0010\u001b\u001a\u00020\u00032\n\u0010\u001c\u001a\u00020\u0018\"\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0015H\u0002J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u0003J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\n\u0010%\u001a\u00020\u0003*\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000¨\u0006&"}, mo21739d2 = {"Ljp/reifrontier/gym/data/hash/Hashids;", "", "salt", "", "length", "", "alphabet", "(Ljava/lang/String;ILjava/lang/String;)V", "guardDiv", "guards", "getLength", "()I", "setLength", "(I)V", "min", "getSalt", "()Ljava/lang/String;", "setSalt", "(Ljava/lang/String;)V", "seps", "sepsDiv", "", "consistentShuffle", "decode", "", "hash", "decodeHex", "encode", "numbers", "", "encodeHex", "hexa", "getCount", "div", "getVersion", "input", "unhash", "unique", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.hash.Hashids */
public final class Hashids {
    private String alphabet;
    private final int guardDiv;
    private String guards;
    private int length;
    private final int min;
    private String salt;
    private String seps;
    private final double sepsDiv;

    public Hashids() {
        this((String) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public Hashids(String str, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "salt");
        Intrinsics.checkParameterIsNotNull(str2, "alphabet");
        this.salt = str;
        this.length = i;
        this.min = 16;
        this.sepsDiv = 3.5d;
        this.guardDiv = 12;
        this.seps = "cfhistuCFHISTU";
        String unique = unique(str2);
        this.alphabet = unique;
        if (unique.length() >= this.min) {
            int length2 = this.seps.length() - 1;
            if (length2 >= 0) {
                int i2 = 0;
                while (true) {
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.alphabet, this.seps.charAt(i2), 0, false, 6, (Object) null);
                    if (indexOf$default == -1) {
                        StringBuilder sb = new StringBuilder();
                        String str3 = this.seps;
                        if (str3 != null) {
                            String substring = str3.substring(0, i2);
                            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb.append(substring);
                            sb.append(" ");
                            String str4 = this.seps;
                            int i3 = i2 + 1;
                            if (str4 != null) {
                                String substring2 = str4.substring(i3);
                                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                                sb.append(substring2);
                                this.seps = sb.toString();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        String str5 = this.alphabet;
                        if (str5 != null) {
                            String substring3 = str5.substring(0, indexOf$default);
                            Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb2.append(substring3);
                            sb2.append(" ");
                            String str6 = this.alphabet;
                            int i4 = indexOf$default + 1;
                            if (str6 != null) {
                                String substring4 = str6.substring(i4);
                                Intrinsics.checkExpressionValueIsNotNull(substring4, "(this as java.lang.String).substring(startIndex)");
                                sb2.append(substring4);
                                this.alphabet = sb2.toString();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    if (i2 == length2) {
                        break;
                    }
                    i2++;
                }
            }
            this.alphabet = new Regex("\\s+").replace((CharSequence) this.alphabet, "");
            String replace = new Regex("\\s+").replace((CharSequence) this.seps, "");
            this.seps = replace;
            String consistentShuffle = consistentShuffle(replace, this.salt);
            this.seps = consistentShuffle;
            if (Intrinsics.areEqual((Object) consistentShuffle, (Object) "") || ((double) (this.alphabet.length() / this.seps.length())) > this.sepsDiv) {
                int count = getCount(this.alphabet.length(), this.sepsDiv);
                count = count == 1 ? count + 1 : count;
                if (count > this.seps.length()) {
                    int length3 = count - this.seps.length();
                    StringBuilder a = C0681a.m330a(this.seps);
                    String str7 = this.alphabet;
                    if (str7 != null) {
                        String substring5 = str7.substring(0, length3);
                        Intrinsics.checkExpressionValueIsNotNull(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        a.append(substring5);
                        this.seps = a.toString();
                        String str8 = this.alphabet;
                        if (str8 != null) {
                            String substring6 = str8.substring(length3);
                            Intrinsics.checkExpressionValueIsNotNull(substring6, "(this as java.lang.String).substring(startIndex)");
                            this.alphabet = substring6;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    String str9 = this.seps;
                    if (str9 != null) {
                        String substring7 = str9.substring(0, count);
                        Intrinsics.checkExpressionValueIsNotNull(substring7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        this.seps = substring7;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            String consistentShuffle2 = consistentShuffle(this.alphabet, this.salt);
            this.alphabet = consistentShuffle2;
            int count2 = getCount(consistentShuffle2.length(), this.guardDiv);
            if (this.alphabet.length() < 3) {
                String str10 = this.seps;
                if (str10 != null) {
                    String substring8 = str10.substring(0, count2);
                    Intrinsics.checkExpressionValueIsNotNull(substring8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    this.guards = substring8;
                    String str11 = this.seps;
                    if (str11 != null) {
                        String substring9 = str11.substring(count2);
                        Intrinsics.checkExpressionValueIsNotNull(substring9, "(this as java.lang.String).substring(startIndex)");
                        this.seps = substring9;
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String str12 = this.alphabet;
            if (str12 != null) {
                String substring10 = str12.substring(0, count2);
                Intrinsics.checkExpressionValueIsNotNull(substring10, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                this.guards = substring10;
                String str13 = this.alphabet;
                if (str13 != null) {
                    String substring11 = str13.substring(count2);
                    Intrinsics.checkExpressionValueIsNotNull(substring11, "(this as java.lang.String).substring(startIndex)");
                    this.alphabet = substring11;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new IllegalArgumentException(C0681a.m322a(C0681a.m330a("Alphabet must contain at least "), this.min, " unique characters").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Hashids(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890" : str2);
    }

    private final String consistentShuffle(String str, String str2) {
        if (str2.length() == 0) {
            return str;
        }
        if (str2 != null) {
            char[] charArray = str2.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            int length2 = str2.length();
            int length3 = str.length() - 1;
            int i = 0;
            int i2 = 0;
            while (length3 > 0) {
                int i3 = i % length2;
                char c = charArray[i3];
                i2 += c;
                int i4 = ((c + i3) + i2) % length3;
                char charAt = str.charAt(i4);
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, i4);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append(str.charAt(length3));
                String substring2 = str.substring(i4 + 1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                if (sb2 != null) {
                    String substring3 = sb2.substring(0, length3);
                    Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb3.append(substring3);
                    sb3.append(charAt);
                    String substring4 = sb2.substring(length3 + 1);
                    Intrinsics.checkExpressionValueIsNotNull(substring4, "(this as java.lang.String).substring(startIndex)");
                    sb3.append(substring4);
                    str = sb3.toString();
                    length3--;
                    i = i3 + 1;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return str;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final int getCount(int i, double d) {
        double d2 = (double) i;
        Double.isNaN(d2);
        return (int) Math.ceil(d2 / d);
    }

    private final int getCount(int i, int i2) {
        return getCount(i, (double) i2);
    }

    private final String hash(long j, String str) {
        int length2 = str.length();
        char[] charArray = str.toCharArray();
        Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
        String str2 = "";
        do {
            long j2 = (long) length2;
            char c = charArray[(int) (j % j2)];
            str2 = String.valueOf(c) + str2;
            j /= j2;
        } while (j > 0);
        return str2;
    }

    private final long unhash(String str, String str2) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            int length2 = str.length() - 1;
            int i = 0;
            long j = 0;
            if (length2 >= 0) {
                while (true) {
                    double indexOf$default = (double) ((long) StringsKt__StringsKt.indexOf$default((CharSequence) str2, charArray[i], 0, false, 6, (Object) null));
                    double pow = Math.pow((double) str2.length(), (double) ((str.length() - i) - 1));
                    Double.isNaN(indexOf$default);
                    j += (long) (pow * indexOf$default);
                    if (i == length2) {
                        break;
                    }
                    i++;
                }
            }
            return j;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final long[] decode(String str) {
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, "hash");
        if (Intrinsics.areEqual((Object) str2, (Object) "")) {
            return new long[0];
        }
        String str3 = this.alphabet;
        ArrayList arrayList = new ArrayList();
        List split$default = StringsKt__StringsKt.split$default((CharSequence) new Regex(C0681a.m323a(C0681a.m329a('['), this.guards, ']')).replace((CharSequence) str2, " "), new String[]{" "}, false, 0, 6, (Object) null);
        String str4 = (String) split$default.get((split$default.size() == 3 || split$default.size() == 2) ? 1 : 0);
        if (str4 != null) {
            char[] charArray = str4.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            char c = charArray[0];
            String substring = str4.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str5 : StringsKt__StringsKt.split$default((CharSequence) new Regex(C0681a.m323a(sb, this.seps, ']')).replace((CharSequence) substring, " "), new String[]{" "}, false, 0, 6, (Object) null)) {
                StringBuilder sb2 = new StringBuilder();
                String str6 = this.salt;
                sb2.append(String.valueOf(c) + str6);
                sb2.append(str3);
                String sb3 = sb2.toString();
                int length2 = str3.length();
                if (sb3 != null) {
                    String substring2 = sb3.substring(0, length2);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str3 = consistentShuffle(str3, substring2);
                    arrayList.add(Long.valueOf(unhash(str5, str3)));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            int size = arrayList.size();
            long[] jArr = new long[size];
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                Object obj = arrayList.get(i);
                Intrinsics.checkExpressionValueIsNotNull(obj, "retArray[index]");
                jArr[i] = ((Number) obj).longValue();
            }
            return Intrinsics.areEqual((Object) encode(Arrays.copyOf(jArr, size)), (Object) str2) ^ true ? new long[0] : jArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String decodeHex(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hash");
        String str2 = "";
        for (long hexString : decode(str)) {
            StringBuilder a = C0681a.m330a(str2);
            String hexString2 = Long.toHexString(hexString);
            Intrinsics.checkExpressionValueIsNotNull(hexString2, "java.lang.Long.toHexString(number)");
            String substring = hexString2.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            a.append(substring);
            str2 = a.toString();
        }
        return str2;
    }

    public final String encode(long... jArr) {
        long[] jArr2 = jArr;
        Intrinsics.checkParameterIsNotNull(jArr2, "numbers");
        if (jArr2.length == 0) {
            return "";
        }
        int length2 = jArr2.length;
        int i = 0;
        while (i < length2) {
            if (jArr2[i] <= 9007199254740992L) {
                i++;
            } else {
                throw new IllegalArgumentException("Number can not be greater than 9007199254740992L".toString());
            }
        }
        int length3 = jArr2.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length3; i3++) {
            i2 += (int) (jArr2[i3] % ((long) (i3 + 100)));
        }
        String str = this.alphabet;
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            char c = charArray[i2 % str.length()];
            String str2 = String.valueOf(c) + "";
            int length4 = jArr2.length;
            char c2 = 0;
            while (c2 < length4) {
                long j = jArr2[c2];
                StringBuilder sb = new StringBuilder();
                String str3 = this.salt;
                StringBuilder sb2 = new StringBuilder();
                int i4 = length4;
                sb2.append(String.valueOf(c));
                sb2.append(str3);
                sb.append(sb2.toString());
                sb.append(str);
                String sb3 = sb.toString();
                int length5 = str.length();
                if (sb3 != null) {
                    String substring = sb3.substring(0, length5);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str = consistentShuffle(str, substring);
                    String hash = hash(j, str);
                    str2 = C0681a.m320a(str2, hash);
                    int i5 = c2 + 1;
                    if (i5 < jArr2.length) {
                        if (hash != null) {
                            char[] charArray2 = hash.toCharArray();
                            Intrinsics.checkExpressionValueIsNotNull(charArray2, "(this as java.lang.String).toCharArray()");
                            int length6 = (int) ((j % ((long) (charArray2[0] + c2))) % ((long) this.seps.length()));
                            StringBuilder a = C0681a.m330a(str2);
                            String str4 = this.seps;
                            if (str4 != null) {
                                char[] charArray3 = str4.toCharArray();
                                Intrinsics.checkExpressionValueIsNotNull(charArray3, "(this as java.lang.String).toCharArray()");
                                a.append(charArray3[length6]);
                                str2 = a.toString();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    c2 = i5;
                    length4 = i4;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (str2.length() < this.length) {
                char[] charArray4 = str2.toCharArray();
                Intrinsics.checkExpressionValueIsNotNull(charArray4, "(this as java.lang.String).toCharArray()");
                int i6 = charArray4[0] + i2;
                String str5 = this.guards;
                if (str5 == null) {
                    Intrinsics.throwNpe();
                }
                int length7 = i6 % str5.length();
                String str6 = this.guards;
                if (str6 == null) {
                    Intrinsics.throwNpe();
                }
                if (str6 != null) {
                    char[] charArray5 = str6.toCharArray();
                    Intrinsics.checkExpressionValueIsNotNull(charArray5, "(this as java.lang.String).toCharArray()");
                    char c3 = charArray5[length7];
                    str2 = String.valueOf(c3) + str2;
                    if (str2.length() < this.length) {
                        char[] charArray6 = str2.toCharArray();
                        Intrinsics.checkExpressionValueIsNotNull(charArray6, "(this as java.lang.String).toCharArray()");
                        int i7 = i2 + charArray6[2];
                        String str7 = this.guards;
                        if (str7 == null) {
                            Intrinsics.throwNpe();
                        }
                        int length8 = i7 % str7.length();
                        String str8 = this.guards;
                        if (str8 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (str8 != null) {
                            char[] charArray7 = str8.toCharArray();
                            Intrinsics.checkExpressionValueIsNotNull(charArray7, "(this as java.lang.String).toCharArray()");
                            str2 = str2 + charArray7[length8];
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            int length9 = str.length() / 2;
            while (str2.length() < this.length) {
                str = consistentShuffle(str, str);
                StringBuilder sb4 = new StringBuilder();
                if (str != null) {
                    String substring2 = str.substring(length9);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    sb4.append(substring2);
                    sb4.append(str2);
                    String substring3 = str.substring(0, length9);
                    Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb4.append(substring3);
                    String sb5 = sb4.toString();
                    int length10 = sb5.length();
                    int i8 = this.length;
                    int i9 = length10 - i8;
                    if (i9 > 0) {
                        int i10 = i9 / 2;
                        sb5 = sb5.substring(i10, i8 + i10);
                        Intrinsics.checkExpressionValueIsNotNull(sb5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return str2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodeHex(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hexa");
        if (!new Regex("^[0-9a-fA-F]+$").matches(str)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("[\\w\\W]{1,12}").matcher(str);
        while (matcher.find()) {
            StringBuilder a = C0681a.m330a("1");
            a.append(matcher.group());
            arrayList.add(Long.valueOf(Long.parseLong(a.toString(), 16)));
        }
        int size = arrayList.size();
        long[] jArr = new long[size];
        int size2 = arrayList.size();
        for (int i = 0; i < size2; i++) {
            Object obj = arrayList.get(i);
            Intrinsics.checkExpressionValueIsNotNull(obj, "matched[i]");
            jArr[i] = ((Number) obj).longValue();
        }
        return encode(Arrays.copyOf(jArr, size));
    }

    public final int getLength() {
        return this.length;
    }

    public final String getSalt() {
        return this.salt;
    }

    public final String getVersion() {
        return "1.0.0";
    }

    public final void setLength(int i) {
        this.length = i;
    }

    public final void setSalt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.salt = str;
    }

    public final String unique(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$unique");
        int length2 = str.length() - 1;
        if (length2 < 0) {
            return "";
        }
        int i = 0;
        String str2 = "";
        while (true) {
            StringBuilder a = C0681a.m330a("");
            a.append(str.charAt(i));
            String sb = a.toString();
            if (!StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) sb, false, 2, (Object) null) && (!Intrinsics.areEqual((Object) sb, (Object) " "))) {
                str2 = C0681a.m320a(str2, sb);
            }
            if (i == length2) {
                return str2;
            }
            i++;
        }
    }
}
