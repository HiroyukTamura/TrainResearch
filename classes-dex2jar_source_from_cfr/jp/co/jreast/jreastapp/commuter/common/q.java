/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;", "", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "addReloadFlag", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "site", "buildSubTitle", "", "id", "name", "buildTitle", "buildTrainInfoUrl", "trainLocationId", "buildUrl", "jrId", "lineCode", "generateSite", "railwayInfo", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "infoButtonVisibility", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class q {
    private final b a;
    private final p b;

    public q(b b2, p p2) {
        j.b(b2, "drawableRepository");
        j.b(p2, "translationRepository");
        this.a = b2;
        this.b = p2;
    }

    private final String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file:///android_asset/trainLocation/guide_");
        stringBuilder.append(string2);
        stringBuilder.append(".html");
        return stringBuilder.toString();
    }

    private final String a(String charSequence, String string2) {
        String string3;
        block7 : {
            switch (((String)charSequence).hashCode()) {
                default: {
                    return string2;
                }
                case 56316: {
                    string3 = string2;
                    if (((String)charSequence).equals("903")) {
                        break;
                    }
                    break block7;
                }
                case 56315: {
                    string3 = string2;
                    if (((String)charSequence).equals("902")) {
                        break;
                    }
                    break block7;
                }
                case 56314: {
                    string3 = string2;
                    if (!((String)charSequence).equals("901")) break block7;
                }
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(this.b.a(2131558523));
            string3 = ((StringBuilder)charSequence).toString();
        }
        return string3;
    }

    private final String a(String charSequence, String string2, String string3) {
        if (j.a((Object)charSequence, (Object)"68")) {
            return "https://rp.cloudrail.jp/com-static/ew01/static/trainnet/trainnetTop.html";
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("https://rp.cloudrail.jp/");
        ((StringBuilder)charSequence).append("com-static/zw01/line_");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(".html?lineCode=");
        ((StringBuilder)charSequence).append(string3);
        return ((StringBuilder)charSequence).toString();
    }

    private final int b(String string2) {
        block14 : {
            block15 : {
                block12 : {
                    block13 : {
                        int n2 = string2.hashCode();
                        if (n2 == 1721634) break block12;
                        if (n2 == 1745659) break block13;
                        switch (n2) {
                            default: {
                                break block14;
                            }
                            case 1793: {
                                if (string2.equals("89")) {
                                    break;
                                }
                                break block14;
                            }
                            case 1792: {
                                if (string2.equals("88")) {
                                    break;
                                }
                                break block14;
                            }
                            case 1791: {
                                if (string2.equals("87")) {
                                    break;
                                }
                                break block14;
                            }
                        }
                        break block15;
                    }
                    if (!string2.equals("90-1")) break block14;
                    break block15;
                }
                if (!string2.equals("86-1")) break block14;
            }
            return 4;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String b(String object, String string2) {
        int n2;
        switch (((String)object).hashCode()) {
            default: {
                return string2;
            }
            case 56318: {
                if (!((String)object).equals("905")) return string2;
                return "";
            }
            case 56317: {
                if (!((String)object).equals("904")) return string2;
                return "";
            }
            case 56316: {
                if (!((String)object).equals("903")) return string2;
                return "";
            }
            case 56315: {
                if (!((String)object).equals("902")) return string2;
                object = this.b;
                n2 = 2131558488;
                return ((p)object).a(n2);
            }
            case 56314: 
        }
        if (!((String)object).equals("901")) return string2;
        object = this.b;
        n2 = 2131558489;
        return ((p)object).a(n2);
    }

    public final o a(RailwayLineInformation railwayLineInformation) {
        j.b(railwayLineInformation, "railwayInfo");
        String string2 = this.a(railwayLineInformation.getTrainLocationId(), railwayLineInformation.getDisplayName());
        String string3 = this.b(railwayLineInformation.getTrainLocationId(), railwayLineInformation.getSection());
        String string4 = this.a(railwayLineInformation.getJrId(), railwayLineInformation.getTrainLocationId(), railwayLineInformation.getLineCode());
        String string5 = this.a(railwayLineInformation.getTrainLocationId());
        return new o(string2, string4, 0, this.a.a(railwayLineInformation.getIconName(), railwayLineInformation.getRailKind(), false), 0, string3, this.b(railwayLineInformation.getTrainLocationId()), string5, 0, railwayLineInformation);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final o a(o o2) {
        CharSequence charSequence;
        j.b(o2, "site");
        CharSequence charSequence2 = o2.b();
        if (n.b(charSequence2, (CharSequence)"zw01", false, 2, null)) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            String string2 = "&reload=1";
            charSequence2 = charSequence;
            charSequence = string2;
        } else {
            charSequence = charSequence2;
            if (!n.b((CharSequence)o2.b(), (CharSequence)"com-static/ew01/static/trainnet/trainnetTop.html", false, 2, null)) return new o(o2.a(), (String)charSequence, o2.c(), o2.d(), o2.e(), o2.f(), o2.g(), o2.h(), o2.i(), o2.j());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence2);
            charSequence = "?reload=1";
            charSequence2 = stringBuilder;
        }
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        return new o(o2.a(), (String)charSequence, o2.c(), o2.d(), o2.e(), o2.f(), o2.g(), o2.h(), o2.i(), o2.j());
    }
}

