/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.d.b;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.SearchResultSubTitle;
import jp.co.jreast.jreastapp.commuter.model.Station;
import jp.co.jreast.jreastapp.commuter.o.c;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;", "", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "buildLeftSubTitle", "", "requestParameter", "Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteSearchResultRequestParameter;", "buildNextRoutesRequestParameter", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "routes", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "currentPageNumber", "", "buildPreviousRoutesRequestParameter", "buildRightSubTitle", "currentPage", "buildSubTitle", "Ljp/co/jreast/jreastapp/commuter/model/SearchResultSubTitle;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    private final p a;

    public a(p p2) {
        j.b(p2, "translationRepository");
        this.a = p2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final String a(int n2) {
        String string2;
        StringBuilder stringBuilder;
        if (n2 < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Math.abs(n2));
            string2 = "\u672c\u524d";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(n2);
            string2 = "\u672c\u5f8c";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final String a(c object) {
        String string2;
        block4 : {
            int n2;
            block2 : {
                block0 : {
                    block3 : {
                        block1 : {
                            n2 = ((c)object).e();
                            string2 = n2 == jp.co.jreast.jreastapp.commuter.common.c.d.a() || n2 == jp.co.jreast.jreastapp.commuter.common.c.c.a() ? "M\u6708d\u65e5(E)" : "M\u6708d\u65e5(E) HH:mm";
                            string2 = b.a(((c)object).d(), string2);
                            n2 = ((c)object).e();
                            if (n2 == jp.co.jreast.jreastapp.commuter.common.c.a.a()) break block0;
                            if (n2 != jp.co.jreast.jreastapp.commuter.common.c.b.a()) break block1;
                            object = this.a;
                            n2 = 2131558444;
                            break block2;
                        }
                        if (n2 != jp.co.jreast.jreastapp.commuter.common.c.d.a()) break block3;
                        object = this.a;
                        n2 = 2131558511;
                        break block2;
                    }
                    if (n2 != jp.co.jreast.jreastapp.commuter.common.c.c.a()) break block0;
                    object = this.a;
                    n2 = 2131558521;
                    break block2;
                }
                object = this.a.a(2131558484);
                break block4;
            }
            object = ((p)object).a(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public final jp.co.jreast.jreastapp.commuter.j.a a(List<Route> object, jp.co.jreast.jreastapp.commuter.j.a a2) {
        j.b(object, "routes");
        j.b(a2, "requestParameter");
        if (a2 instanceof c) {
            Object object2;
            Object object3;
            Iterator iterator = ((Iterable)object).iterator();
            if (!iterator.hasNext()) {
                object = null;
            } else {
                object = iterator.next();
                object3 = m.h(((Route)object).getLines()).getTo().dateTime();
                if (object3 == null) {
                    j.a();
                }
                object3 = ((Calendar)object3).getTime();
                while (iterator.hasNext()) {
                    object2 = iterator.next();
                    Comparable<Calendar> comparable = m.h(((Route)object2).getLines()).getTo().dateTime();
                    if (comparable == null) {
                        j.a();
                    }
                    if (object3.compareTo(comparable = (Comparable)comparable.getTime()) <= 0) continue;
                    object = object2;
                    object3 = comparable;
                }
            }
            object = (Route)object;
            if (object == null) {
                j.a();
            }
            if ((object = m.h(((Route)object).getLines()).getTo().dateTime()) == null) {
                j.a();
            }
            ((Calendar)object).add(12, -1);
            object = ((Calendar)object).getTime();
            a2 = (c)a2;
            object3 = ((c)a2).b();
            object2 = ((c)a2).c();
            j.a(object, "replaceDate");
            return new c((Station)object3, (Station)object2, (Date)object, jp.co.jreast.jreastapp.commuter.common.c.b.a(), ((c)a2).f(), ((c)a2).g(), ((c)a2).h(), ((c)a2).i());
        }
        return a2;
    }

    public final jp.co.jreast.jreastapp.commuter.j.a a(List<Route> object, jp.co.jreast.jreastapp.commuter.j.a a2, int n2) {
        block14 : {
            Object object2;
            Object object3;
            block16 : {
                block17 : {
                    block15 : {
                        j.b(object, "routes");
                        j.b(a2, "requestParameter");
                        if (!(a2 instanceof c)) break block14;
                        object2 = null;
                        object3 = null;
                        if (n2 != 0 || ((c)a2).e() != jp.co.jreast.jreastapp.commuter.common.c.b.a()) break block15;
                        Iterator iterator = ((Iterable)object).iterator();
                        if (iterator.hasNext()) {
                            object = iterator.next();
                            object2 = m.f(((Route)object).getLines()).getFrom().dateTime();
                            if (object2 == null) {
                                j.a();
                            }
                            object2 = ((Calendar)object2).getTime();
                            do {
                                object3 = object;
                                if (!iterator.hasNext()) break;
                                object3 = iterator.next();
                                Comparable<Calendar> comparable = m.f(((Route)object3).getLines()).getFrom().dateTime();
                                if (comparable == null) {
                                    j.a();
                                }
                                if (object2.compareTo(comparable = (Comparable)comparable.getTime()) >= 0) continue;
                                object = object3;
                                object2 = comparable;
                            } while (true);
                        }
                        if ((object = (Route)object3) == null) {
                            j.a();
                        }
                        object = object2 = m.f(((Route)object).getLines()).getFrom().dateTime();
                        if (object2 != null) break block16;
                        object = object2;
                        break block17;
                    }
                    Iterator iterator = ((Iterable)object).iterator();
                    if (!iterator.hasNext()) {
                        object3 = object2;
                    } else {
                        object = iterator.next();
                        object2 = m.f(((Route)object).getLines()).getFrom().dateTime();
                        if (object2 == null) {
                            j.a();
                        }
                        object2 = ((Calendar)object2).getTime();
                        do {
                            object3 = object;
                            if (!iterator.hasNext()) break;
                            object3 = iterator.next();
                            Comparable<Calendar> comparable = m.f(((Route)object3).getLines()).getFrom().dateTime();
                            if (comparable == null) {
                                j.a();
                            }
                            if (object2.compareTo(comparable = (Comparable)comparable.getTime()) <= 0) continue;
                            object = object3;
                            object2 = comparable;
                        } while (true);
                    }
                    object = (Route)object3;
                    if (object == null) {
                        j.a();
                    }
                    object = object2 = m.f(((Route)object).getLines()).getFrom().dateTime();
                    if (object2 != null) break block16;
                    object = object2;
                }
                j.a();
            }
            ((Calendar)object).add(12, 1);
            object = ((Calendar)object).getTime();
            a2 = (c)a2;
            object2 = ((c)a2).b();
            object3 = ((c)a2).c();
            j.a(object, "replaceDate");
            return new c((Station)object2, (Station)object3, (Date)object, jp.co.jreast.jreastapp.commuter.common.c.a.a(), ((c)a2).f(), ((c)a2).g(), ((c)a2).h(), ((c)a2).i());
        }
        return a2;
    }

    public final SearchResultSubTitle a(c object, int n2) {
        j.b(object, "requestParameter");
        object = this.a((c)object);
        if (n2 == 0) {
            return new SearchResultSubTitle((String)object, "", 8);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append("\u306e");
        return new SearchResultSubTitle(stringBuilder.toString(), this.a(n2), 0);
    }
}

