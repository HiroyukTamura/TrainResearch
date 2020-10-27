package p009e.p028d.p067e.p068a;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: e.d.e.a.a */
public class C1568a {
    /* renamed from: a */
    public static String m2195a(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        long j2 = 0;
        for (LatLng next : list) {
            long round = Math.round(next.latitude * 100000.0d);
            long round2 = Math.round(next.longitude * 100000.0d);
            m2196a(round - j, stringBuffer);
            m2196a(round2 - j2, stringBuffer);
            j = round;
            j2 = round2;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m2196a(long j, StringBuffer stringBuffer) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        long j2 = j << 1;
        if (i < 0) {
            j2 ^= -1;
        }
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) ((32 | (31 & j2)) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }
}
