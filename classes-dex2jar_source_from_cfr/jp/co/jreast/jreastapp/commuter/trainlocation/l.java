/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/LocalRailwaySearcher;", "", "()V", "replaceWords", "", "", "", "aggregationOfStationName", "stationName", "searchExactFirstKanaMatch", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "keyword", "list", "searchExactMatch", "searchForwardMatch", "searchPartialMatch", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class l {
    private final List<String[]> a;

    public l() {
        String[] arrstring = new String[]{"jr", "\uff2a\uff32"};
        this.a = m.b({" ", ""}, {"\u30f6", "\u30b1"}, {"JR", "\uff2a\uff32"}, arrstring, {"\uff4a\uff52", "\uff2a\uff32"});
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

    public final List<RailwayLineInformation> a(String string2, List<RailwayLineInformation> collection) {
        j.b(string2, "keyword");
        j.b(collection, "list");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            CharSequence charSequence;
            Object e2 = object.next();
            RailwayLineInformation railwayLineInformation = (RailwayLineInformation)e2;
            Object object2 = n.b((CharSequence)railwayLineInformation.getDisplayName(), new String[]{"("}, false, 0, 6, null);
            boolean bl2 = false;
            if (n.b((CharSequence)(object2 = (CharSequence)object2.get(0)), charSequence = (CharSequence)string2, false, 2, null) || n.b((CharSequence)railwayLineInformation.getKana(), charSequence, false, 2, null)) {
                bl2 = true;
            }
            if (!bl2) continue;
            collection.add((RailwayLineInformation)e2);
        }
        return collection;
    }

    public final List<RailwayLineInformation> b(String string2, List<RailwayLineInformation> collection) {
        j.b(string2, "keyword");
        j.b(collection, "list");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            RailwayLineInformation railwayLineInformation = (RailwayLineInformation)e2;
            Object object2 = railwayLineInformation.getKana();
            boolean bl2 = false;
            object2 = n.b((CharSequence)object2, new String[]{";"}, false, 0, 6, null);
            if (n.a(railwayLineInformation.getDisplayName(), string2, false, 2, null) || n.a((String)object2.get(0), string2, false, 2, null) || n.a((String)object2.get(m.a(object2)), string2, false, 2, null)) {
                bl2 = true;
            }
            if (!bl2) continue;
            collection.add((RailwayLineInformation)e2);
        }
        return collection;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final List<RailwayLineInformation> c(String string2, List<RailwayLineInformation> collection) {
        j.b(string2, "keyword");
        j.b(collection, "list");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        do {
            boolean bl2;
            Object e2;
            block9 : {
                block8 : {
                    boolean bl3;
                    if (!object.hasNext()) {
                        return (List)collection;
                    }
                    e2 = object.next();
                    Iterator iterator = (RailwayLineInformation)e2;
                    List list = n.b((CharSequence)((RailwayLineInformation)((Object)iterator)).getDisplayName(), new String[]{"("}, false, 0, 6, null);
                    bl2 = false;
                    if (j.a((Object)((String)list.get(0)), (Object)string2)) break block8;
                    if (!((iterator = (Iterable)n.b((CharSequence)((RailwayLineInformation)((Object)iterator)).getKana(), new String[]{";"}, false, 0, 6, null)) instanceof Collection) || !((Collection)((Object)iterator)).isEmpty()) {
                        iterator = iterator.iterator();
                        while (iterator.hasNext()) {
                            if (!j.a((Object)((String)iterator.next()), (Object)string2)) continue;
                            bl3 = true;
                            break;
                        }
                    } else {
                        bl3 = false;
                    }
                    if (!bl3) break block9;
                }
                bl2 = true;
            }
            if (!bl2) continue;
            collection.add((RailwayLineInformation)e2);
        } while (true);
    }

    public final List<RailwayLineInformation> d(String string2, List<RailwayLineInformation> collection) {
        j.b(string2, "keyword");
        j.b(collection, "list");
        Object object = collection;
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!j.a((Object)((String)n.b((CharSequence)((RailwayLineInformation)e2).getKana(), new String[]{";"}, false, 0, 6, null).get(0)), (Object)string2)) continue;
            collection.add((RailwayLineInformation)e2);
        }
        return collection;
    }
}

