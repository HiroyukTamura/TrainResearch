/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J.\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J.\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J.\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J.\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationSearcher;", "", "()V", "replaceWords", "", "", "", "aggregationOfStationName", "stationName", "searchExactFirstKanaMatch", "keyword", "stationList", "searchExactMatch", "searchForwardMatch", "searchPartialMatch", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f {
    private final List<String[]> a;

    public f() {
        String[] arrstring = new String[]{" ", ""};
        String[] arrstring2 = new String[]{"jr", "\uff2a\uff32"};
        String[] arrstring3 = new String[]{"\uff4a\uff52", "\uff2a\uff32"};
        this.a = m.b(arrstring, {"\u30f6", "\u30b1"}, {"JR", "\uff2a\uff32"}, arrstring2, arrstring3);
    }

    public final String a(String string2) {
        j.b(string2, "stationName");
        string2 = string2.toLowerCase();
        j.a((Object)string2, "(this as java.lang.String).toLowerCase()");
        for (String[] arrstring : (Iterable)this.a) {
            string2 = n.a(string2, arrstring[0], arrstring[1], false, 4, null);
        }
        return string2;
    }

    public final List<String[]> a(String string2, List<String[]> collection) {
        j.b(string2, "keyword");
        j.b(collection, "stationList");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            String[] arrstring = (String[])e2;
            boolean bl2 = true;
            CharSequence charSequence = (CharSequence)n.b((CharSequence)arrstring[1], new String[]{"("}, false, 0, 6, null).get(0);
            CharSequence charSequence2 = string2;
            boolean bl3 = bl2;
            if (!n.b(charSequence, charSequence2, false, 2, null)) {
                bl3 = n.b((CharSequence)arrstring[2], charSequence2, false, 2, null) ? bl2 : false;
            }
            if (!bl3) continue;
            collection.add(e2);
        }
        return collection;
    }

    public final List<String[]> b(String string2, List<String[]> collection) {
        j.b(string2, "keyword");
        j.b(collection, "stationList");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            boolean bl2;
            Object e2 = object.next();
            String[] arrstring = (String[])e2;
            List list = n.b((CharSequence)arrstring[2], new String[]{";"}, false, 0, 6, null);
            boolean bl3 = bl2 = true;
            if (!n.a(arrstring[1], string2, false, 2, null)) {
                bl3 = bl2;
                if (!n.a((String)list.get(0), string2, false, 2, null)) {
                    bl3 = n.a((String)list.get(m.a(list)), string2, false, 2, null) ? bl2 : false;
                }
            }
            if (!bl3) continue;
            collection.add(e2);
        }
        return collection;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final List<String[]> c(String string2, List<String[]> collection) {
        j.b(string2, "keyword");
        j.b(collection, "stationList");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            boolean bl2;
            Object e2 = object.next();
            Object object2 = (String[])e2;
            boolean bl3 = bl2 = true;
            if (!j.a((Object)((String)n.b((CharSequence)object2[1], new String[]{"("}, false, 0, 6, null).get(0)), (Object)string2)) {
                if (!((object2 = (Iterable)n.b((CharSequence)object2[2], new String[]{";"}, false, 0, 6, null)) instanceof Collection) || !((Collection)object2).isEmpty()) {
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        if (!((String)object2.next()).equals(string2)) continue;
                        bl3 = true;
                        break;
                    }
                } else {
                    bl3 = false;
                }
                bl3 = bl3 ? bl2 : false;
            }
            if (!bl3) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    public final List<String[]> d(String string2, List<String[]> collection) {
        j.b(string2, "keyword");
        j.b(collection, "stationList");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!j.a((Object)((String)n.b((CharSequence)((String[])e2)[2], new String[]{";"}, false, 0, 6, null).get(0)), (Object)string2)) continue;
            collection.add(e2);
        }
        return collection;
    }
}

