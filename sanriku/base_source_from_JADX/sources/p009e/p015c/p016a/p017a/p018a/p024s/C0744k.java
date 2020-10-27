package p009e.p015c.p016a.p017a.p018a.p024s;

import androidx.annotation.NonNull;
import java.util.Collection;

/* renamed from: e.c.a.a.a.s.k */
public class C0744k {
    @NonNull
    /* renamed from: a */
    public static String m437a(@NonNull String str) {
        return ((!str.startsWith("\"") || !str.endsWith("\"")) && (!str.startsWith("`") || !str.endsWith("`")) && (!str.startsWith("[") || !str.endsWith("]"))) ? str : str.substring(1, str.length() - 1);
    }

    /* renamed from: a */
    public <T> void mo19970a(StringBuilder sb, String str, Collection<T> collection) {
        int size = collection.size();
        int i = 0;
        for (T append : collection) {
            sb.append(append);
            i++;
            if (i != size) {
                sb.append(str);
            }
        }
    }
}
