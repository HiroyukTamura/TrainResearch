package p122k.p123a.p124a.p125a.p128G;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: k.a.a.a.G.c */
public class C2433c<Key1, Key2, Value> {

    /* renamed from: a */
    Map<Key1, Map<Key2, Value>> f3988a = new LinkedHashMap();

    /* renamed from: a */
    public Value mo34218a(Key1 key1, Key2 key2) {
        Map map = this.f3988a.get(key1);
        if (map == null) {
            return null;
        }
        return map.get(key2);
    }

    /* renamed from: a */
    public Value mo34219a(Key1 key1, Key2 key2, Value value) {
        Value value2;
        Map map = this.f3988a.get(key1);
        if (map == null) {
            map = new LinkedHashMap();
            this.f3988a.put(key1, map);
            value2 = null;
        } else {
            value2 = map.get(key2);
        }
        map.put(key2, value);
        return value2;
    }
}
