package p009e.p010a.p011a.p012a;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.JsonReader;
import androidx.fragment.app.Fragment;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p041io.realm.ProxyState;
import p041io.realm.internal.RealmObjectProxy;
import p043jp.reifrontier.gym.activity.RFGSettingActivity;

/* renamed from: e.a.a.a.a */
/* compiled from: outline */
public class C0681a {
    /* renamed from: a */
    public static float m301a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* renamed from: a */
    public static int m302a(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    /* renamed from: a */
    public static int m303a(IntRange intRange, int i) {
        return intRange.getEndInclusive().intValue() + i;
    }

    /* renamed from: a */
    public static long m304a(RealmObjectProxy realmObjectProxy) {
        return realmObjectProxy.realmGet$proxyState().getRow$realm().getIndex();
    }

    /* renamed from: a */
    public static RemoteException m305a(String str, Throwable th) {
        zzazw.zzc(str, th);
        return new RemoteException();
    }

    /* renamed from: a */
    public static IObjectWrapper m306a(Parcel parcel) {
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return asInterface;
    }

    /* renamed from: a */
    public static IllegalArgumentException m307a(JsonReader jsonReader, String str) {
        jsonReader.skipValue();
        return new IllegalArgumentException(str);
    }

    /* renamed from: a */
    public static Object m308a(CharSequence charSequence, int i, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i)));
    }

    /* renamed from: a */
    public static String m309a(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m310a(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m311a(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m312a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m313a(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m314a(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m315a(ProxyState proxyState) {
        return proxyState.getRow$realm().getTable().getName();
    }

    /* renamed from: a */
    public static String m316a(String str, int i) {
        return str + i;
    }

    /* renamed from: a */
    public static String m317a(String str, int i, String str2) {
        return str + i + str2;
    }

    /* renamed from: a */
    public static String m318a(String str, long j) {
        return str + j;
    }

    /* renamed from: a */
    public static String m319a(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* renamed from: a */
    public static String m320a(String str, String str2) {
        return str + str2;
    }

    /* renamed from: a */
    public static String m321a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: a */
    public static String m322a(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m323a(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m324a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m325a(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m326a(Throwable th, StringBuilder sb) {
        sb.append(th.getLocalizedMessage());
        return sb.toString();
    }

    /* renamed from: a */
    public static String m327a(RFGSettingActivity rFGSettingActivity, int i, String str) {
        String string = rFGSettingActivity.getResources().getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, str);
        return string;
    }

    /* renamed from: a */
    public static String m328a(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkExpressionValueIsNotNull(format, str2);
        return format;
    }

    /* renamed from: a */
    public static StringBuilder m329a(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m330a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m331a(String str, Throwable th, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        Intrinsics.checkExpressionValueIsNotNull(th, str2);
        return sb;
    }

    /* renamed from: a */
    public static ArrayList m332a(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList m333a(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static void m334a(int i, Canvas canvas, int i2, int i3) {
        InlineMarker.finallyStart(i);
        canvas.restoreToCount(i2);
        InlineMarker.finallyEnd(i3);
    }

    /* renamed from: a */
    public static void m335a(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    /* renamed from: b */
    public static int m336b(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    /* renamed from: b */
    public static StringBuilder m337b(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    /* renamed from: b */
    public static StringBuilder m338b(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* renamed from: b */
    public static StringBuilder m339b(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        return sb;
    }

    /* renamed from: c */
    public static StringBuilder m340c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }
}
