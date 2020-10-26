/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.SpannableStringBuilder
 *  android.text.style.UnderlineSpan
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import jp.co.jreast.jreastapp.commuter.common.c;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "resources", "Landroid/content/res/Resources;", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "getSearchPatternString", "", "selectedDepartureOrArrival", "", "getString", "resId", "vararg", "getUnderLinedCharSequence", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class p {
    private final Resources a;
    private final SpannableStringBuilder b;

    public p(Context context) {
        j.b((Object)context, "context");
        context = context.getResources();
        j.a((Object)context, "context.resources");
        this.a = context;
        this.b = new SpannableStringBuilder();
    }

    public final String a(int n2) {
        if (n2 > 0) {
            String string2 = this.a.getString(n2);
            j.a((Object)string2, "resources.getString(resId)");
            return string2;
        }
        return "";
    }

    public final String a(int n2, String string2) {
        j.b(string2, "vararg");
        if (n2 > 0) {
            string2 = this.a.getString(n2, new Object[]{string2});
            j.a((Object)string2, "resources.getString(resId, vararg)");
            return string2;
        }
        return "";
    }

    public final CharSequence b(int n2) {
        CharSequence charSequence = this.a.getString(n2);
        this.b.clear();
        this.b.append(charSequence);
        this.b.setSpan((Object)new UnderlineSpan(), 0, this.b.length(), 0);
        charSequence = this.b.subSequence(0, this.b.length());
        j.a((Object)charSequence, "spannableStringBuilder.s\u2026ableStringBuilder.length)");
        return charSequence;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final String c(int n2) {
        if (n2 == c.a.a()) {
            return this.a(2131558484);
        }
        if (n2 == c.b.a()) {
            n2 = 2131558444;
            return this.a(n2);
        }
        if (n2 == c.d.a()) {
            n2 = 2131558511;
            return this.a(n2);
        }
        if (n2 != c.c.a()) return this.a(2131558484);
        n2 = 2131558521;
        return this.a(n2);
    }
}

