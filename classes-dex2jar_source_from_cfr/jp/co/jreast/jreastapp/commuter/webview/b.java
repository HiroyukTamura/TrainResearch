/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.webkit.JavascriptInterface
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.webkit.JavascriptInterface;
import androidx.lifecycle.v;
import com.b.a.s;
import jp.co.jreast.jreastapp.commuter.model.TrainHeaderParam;
import jp.co.jreast.jreastapp.commuter.webview.a;
import jp.co.jreast.jreastapp.commuter.webview.f;
import jp.co.jreast.jreastapp.commuter.webview.j;
import jp.co.jreast.jreastapp.commuter.webview.m;
import jp.co.jreast.jreastapp.commuter.webview.r;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0007J\b\u0010&\u001a\u00020\"H\u0007J-\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0016\u0010)\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010*\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\"H\u0007J\b\u0010-\u001a\u00020\"H\u0007J\b\u0010.\u001a\u00020\"H\u0007J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0006H\u0007J\b\u00101\u001a\u00020\u0006H\u0007J\u000e\u00102\u001a\u00020\"2\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207H\u0007J\u0016\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006;"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;", "", "userInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;)V", "TRAIN_NET_JS_KEY", "", "getTRAIN_NET_JS_KEY", "()Ljava/lang/String;", "audioWaveBeaconDelegate", "Ljp/co/jreast/jreastapp/commuter/webview/AudioWaveBeaconDelegate;", "getAudioWaveBeaconDelegate", "()Ljp/co/jreast/jreastapp/commuter/webview/AudioWaveBeaconDelegate;", "setAudioWaveBeaconDelegate", "(Ljp/co/jreast/jreastapp/commuter/webview/AudioWaveBeaconDelegate;)V", "commonWebViewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "getCommonWebViewModel", "()Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "setCommonWebViewModel", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;)V", "javaScriptDelegate", "Ljp/co/jreast/jreastapp/commuter/webview/JavaScriptDelegate;", "getJavaScriptDelegate", "()Ljp/co/jreast/jreastapp/commuter/webview/JavaScriptDelegate;", "setJavaScriptDelegate", "(Ljp/co/jreast/jreastapp/commuter/webview/JavaScriptDelegate;)V", "webViewModel", "Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "getWebViewModel", "()Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "setWebViewModel", "(Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;)V", "checkBeaconWithPermissionCheck", "", "progressMessage", "errorMessage", "denyMessage", "createImage", "createJavascriptFunction", "functionName", "objects", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getPreviousUrl", "getTrainHeaderParam", "getUid", "goErrorDialog", "status", "isRunning", "saveScrollTopPosition", "isZw", "", "setCall", "id", "", "setScrollTopPosition", "offsetY", "url", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    public m a;
    public a b;
    public j c;
    public r d;
    private final String e;
    private final jp.co.jreast.jreastapp.commuter.m.r f;

    public b(jp.co.jreast.jreastapp.commuter.m.r r2) {
        kotlin.e.b.j.b(r2, "userInformationRepository");
        this.f = r2;
        this.e = "niOfxTbeEvZCjBtwv2YOBQ==";
    }

    /*
     * Enabled aggressive block sorting
     */
    private final /* varargs */ String a(String object, Object ... arrobject) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append((String)object);
        stringBuilder.append("(");
        int n2 = arrobject.length;
        int n3 = 0;
        n2 = n2 == 0 ? 1 : 0;
        if ((n2 ^ 1) != 0) {
            int n4 = arrobject.length;
            for (n2 = n3; n2 < n4; ++n2) {
                object = arrobject[n2];
                if (object == null) {
                    object = "'null',";
                } else {
                    stringBuilder.append("'");
                    stringBuilder.append(object.toString());
                    object = "',";
                }
                stringBuilder.append((String)object);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append(")");
        object = stringBuilder.toString();
        kotlin.e.b.j.a(object, "sb.toString()");
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(String string2, String object) {
        StringBuilder stringBuilder;
        kotlin.e.b.j.b(string2, "offsetY");
        kotlin.e.b.j.b(object, "url");
        if (n.b((CharSequence)object, (CharSequence)"zw01", false, 2, null)) {
            stringBuilder = new StringBuilder();
            object = "$('#scroll_body').animate({scrollTop : ";
        } else {
            stringBuilder = new StringBuilder();
            object = "$('html,body').animate({scrollTop : ";
        }
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        stringBuilder.append("},{queue : false});");
        string2 = stringBuilder.toString();
        object = this.a;
        if (object == null) {
            kotlin.e.b.j.b("javaScriptDelegate");
        }
        object.c(string2);
    }

    public final void a(a a2) {
        kotlin.e.b.j.b(a2, "<set-?>");
        this.b = a2;
    }

    public final void a(j j2) {
        kotlin.e.b.j.b(j2, "<set-?>");
        this.c = j2;
    }

    public final void a(m m2) {
        kotlin.e.b.j.b(m2, "<set-?>");
        this.a = m2;
    }

    public final void a(r r2) {
        kotlin.e.b.j.b(r2, "<set-?>");
        this.d = r2;
    }

    public final void a(boolean bl2) {
        String string2 = bl2 ? "document.getElementById('scroll_body').scrollTop" : "$(window).scrollTop()";
        m m2 = this.a;
        if (m2 == null) {
            kotlin.e.b.j.b("javaScriptDelegate");
        }
        m2.d(string2);
    }

    @JavascriptInterface
    public final void checkBeaconWithPermissionCheck(String string2, String string3, String string4) {
        kotlin.e.b.j.b(string2, "progressMessage");
        kotlin.e.b.j.b(string3, "errorMessage");
        kotlin.e.b.j.b(string4, "denyMessage");
        a a2 = this.b;
        if (a2 == null) {
            kotlin.e.b.j.b("audioWaveBeaconDelegate");
        }
        a2.a(string2, string3, string4);
    }

    @JavascriptInterface
    public final void createImage() {
        String string2 = this.a("setImage", new Object[]{this.e});
        m m2 = this.a;
        if (m2 == null) {
            kotlin.e.b.j.b("javaScriptDelegate");
        }
        m2.c(string2);
    }

    @JavascriptInterface
    public final void getPreviousUrl() {
        String string2 = this.a("setPreviousUrl", new Object[0]);
        m m2 = this.a;
        if (m2 == null) {
            kotlin.e.b.j.b("javaScriptDelegate");
        }
        m2.c(string2);
    }

    @JavascriptInterface
    public final void getTrainHeaderParam() {
        String string2 = this.a("setHeaderParam", new Object[]{new s.a().a().a(TrainHeaderParam.class).a(new TrainHeaderParam(null, null, null, null, null, null, null, null, null, null, 1023, null))});
        m m2 = this.a;
        if (m2 == null) {
            kotlin.e.b.j.b("javaScriptDelegate");
        }
        m2.c(string2);
    }

    @JavascriptInterface
    public final void getUid() {
        String string2 = this.f.a();
        boolean bl2 = ((CharSequence)string2).length() > 0;
        if (bl2) {
            string2 = this.a("setUid", new Object[]{string2});
            m m2 = this.a;
            if (m2 == null) {
                kotlin.e.b.j.b("javaScriptDelegate");
            }
            m2.c(string2);
        }
    }

    @JavascriptInterface
    public final void goErrorDialog(String object) {
        kotlin.e.b.j.b(object, "status");
        object = this.c;
        if (object == null) {
            kotlin.e.b.j.b("commonWebViewModel");
        }
        ((j)object).b(f.b);
    }

    @JavascriptInterface
    public final String isRunning() {
        v v2 = this.c;
        if (v2 == null) {
            kotlin.e.b.j.b("commonWebViewModel");
        }
        if (!((j)v2).z()) {
            v2 = this.d;
            if (v2 == null) {
                kotlin.e.b.j.b("webViewModel");
            }
            if (!((r)v2).j()) {
                return "false";
            }
        }
        return "true";
    }

    /*
     * Enabled aggressive block sorting
     */
    @JavascriptInterface
    public final void setCall(int n2) {
        j j2;
        String string2;
        if (n2 == 0) {
            j2 = this.c;
            if (j2 == null) {
                kotlin.e.b.j.b("commonWebViewModel");
            }
            string2 = "javascript:callIn()";
        } else {
            j2 = this.c;
            if (j2 == null) {
                kotlin.e.b.j.b("commonWebViewModel");
            }
            string2 = "javascript:callOut()";
        }
        j2.b(string2);
    }
}

