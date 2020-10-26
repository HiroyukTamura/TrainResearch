/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.Spannable
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 */
package androidx.core.f;

import android.graphics.Typeface;
import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.g.c;
import java.util.Locale;
import java.util.concurrent.Executor;

public class a
implements Spannable {
    private static final Object a = new Object();
    private static Executor b = null;
    private final Spannable c;
    private final a d;

    public a a() {
        return this.d;
    }

    public char charAt(int n2) {
        return this.c.charAt(n2);
    }

    public int getSpanEnd(Object object) {
        return this.c.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.c.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.c.getSpanStart(object);
    }

    public <T> T[] getSpans(int n2, int n3, Class<T> class_) {
        return this.c.getSpans(n2, n3, class_);
    }

    public int length() {
        return this.c.length();
    }

    public int nextSpanTransition(int n2, int n3, Class class_) {
        return this.c.nextSpanTransition(n2, n3, class_);
    }

    public void removeSpan(Object object) {
        if (!(object instanceof MetricAffectingSpan)) {
            this.c.removeSpan(object);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object object, int n2, int n3, int n4) {
        if (!(object instanceof MetricAffectingSpan)) {
            this.c.setSpan(object, n2, n3, n4);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int n2, int n3) {
        return this.c.subSequence(n2, n3);
    }

    public String toString() {
        return this.c.toString();
    }

    public static final class androidx.core.f.a$a {
        final PrecomputedText.Params a;
        private final TextPaint b;
        private final TextDirectionHeuristic c;
        private final int d;
        private final int e;

        public androidx.core.f.a$a(PrecomputedText.Params params) {
            this.b = params.getTextPaint();
            this.c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.a = null;
        }

        androidx.core.f.a$a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n2, int n3) {
            this.a = null;
            this.b = textPaint;
            this.c = textDirectionHeuristic;
            this.d = n2;
            this.e = n3;
        }

        public TextPaint a() {
            return this.b;
        }

        public boolean a(androidx.core.f.a$a a2) {
            if (this.a != null) {
                return this.a.equals((Object)a2.a);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.d != a2.c()) {
                    return false;
                }
                if (this.e != a2.d()) {
                    return false;
                }
            }
            if (this.b.getTextSize() != a2.a().getTextSize()) {
                return false;
            }
            if (this.b.getTextScaleX() != a2.a().getTextScaleX()) {
                return false;
            }
            if (this.b.getTextSkewX() != a2.a().getTextSkewX()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.b.getLetterSpacing() != a2.a().getLetterSpacing()) {
                    return false;
                }
                if (!TextUtils.equals((CharSequence)this.b.getFontFeatureSettings(), (CharSequence)a2.a().getFontFeatureSettings())) {
                    return false;
                }
            }
            if (this.b.getFlags() != a2.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24 ? !this.b.getTextLocales().equals((Object)a2.a().getTextLocales()) : Build.VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(a2.a().getTextLocale())) {
                return false;
            }
            return !(this.b.getTypeface() == null ? a2.a().getTypeface() != null : !this.b.getTypeface().equals((Object)a2.a().getTypeface()));
        }

        public TextDirectionHeuristic b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof androidx.core.f.a$a)) {
                return false;
            }
            if (!this.a((androidx.core.f.a$a)(object = (androidx.core.f.a$a)object))) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.c == ((androidx.core.f.a$a)object).b();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int hashCode() {
            Object[] arrobject;
            if (Build.VERSION.SDK_INT >= 24) {
                arrobject = new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), this.b.getFlags(), this.b.getTextLocales(), this.b.getTypeface(), this.b.isElegantTextHeight(), this.c, this.d, this.e};
                do {
                    return c.a(arrobject);
                    break;
                } while (true);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                arrobject = new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), this.b.getFlags(), this.b.getTextLocale(), this.b.getTypeface(), this.b.isElegantTextHeight(), this.c, this.d, this.e};
                return c.a(arrobject);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                arrobject = new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), this.b.getFlags(), this.b.getTextLocale(), this.b.getTypeface(), this.c, this.d, this.e};
                return c.a(arrobject);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                arrobject = new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), this.b.getFlags(), this.b.getTextLocale(), this.b.getTypeface(), this.c, this.d, this.e};
                return c.a(arrobject);
            }
            arrobject = new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), this.b.getFlags(), this.b.getTypeface(), this.c, this.d, this.e};
            return c.a(arrobject);
        }

        /*
         * Enabled aggressive block sorting
         */
        public String toString() {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            block7 : {
                void var2_4;
                block6 : {
                    block5 : {
                        stringBuilder2 = new StringBuilder("{");
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("textSize=");
                        stringBuilder.append(this.b.getTextSize());
                        stringBuilder2.append(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(", textScaleX=");
                        stringBuilder.append(this.b.getTextScaleX());
                        stringBuilder2.append(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(", textSkewX=");
                        stringBuilder.append(this.b.getTextSkewX());
                        stringBuilder2.append(stringBuilder.toString());
                        if (Build.VERSION.SDK_INT >= 21) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(", letterSpacing=");
                            stringBuilder.append(this.b.getLetterSpacing());
                            stringBuilder2.append(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(", elegantTextHeight=");
                            stringBuilder.append(this.b.isElegantTextHeight());
                            stringBuilder2.append(stringBuilder.toString());
                        }
                        if (Build.VERSION.SDK_INT < 24) break block5;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(", textLocale=");
                        LocaleList localeList = this.b.getTextLocales();
                        break block6;
                    }
                    if (Build.VERSION.SDK_INT < 17) break block7;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(", textLocale=");
                    Locale locale = this.b.getTextLocale();
                }
                stringBuilder.append(var2_4);
                stringBuilder2.append(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(", typeface=");
            stringBuilder.append((Object)this.b.getTypeface());
            stringBuilder2.append(stringBuilder.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(", variationSettings=");
                stringBuilder.append(this.b.getFontVariationSettings());
                stringBuilder2.append(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(", textDir=");
            stringBuilder.append((Object)this.c);
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(", breakStrategy=");
            stringBuilder.append(this.d);
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(", hyphenationFrequency=");
            stringBuilder.append(this.e);
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("}");
            return stringBuilder2.toString();
        }

        public static class a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            /*
             * Enabled aggressive block sorting
             */
            public a(TextPaint object) {
                this.a = object;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                object = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
                this.b = object;
            }

            public a a(int n2) {
                this.c = n2;
                return this;
            }

            public a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }

            public androidx.core.f.a$a a() {
                return new androidx.core.f.a$a(this.a, this.b, this.c, this.d);
            }

            public a b(int n2) {
                this.d = n2;
                return this;
            }
        }

    }

}

