/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.Spanned
 *  android.text.TextWatcher
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.databinding.a;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.a.d;
import androidx.databinding.b.a.b;
import androidx.databinding.g;

public class e {
    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    public static void a(TextView textView, b object, c c2, a a2, g g2) {
        object = object == null && a2 == null && c2 == null && g2 == null ? null : new TextWatcher((b)object, c2, g2, a2){
            final /* synthetic */ b a;
            final /* synthetic */ c b;
            final /* synthetic */ g c;
            final /* synthetic */ a d;
            {
                this.a = b2;
                this.b = c2;
                this.c = g2;
                this.d = a2;
            }

            public void afterTextChanged(Editable editable) {
                if (this.d != null) {
                    this.d.a(editable);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (this.a != null) {
                    this.a.a(charSequence, n2, n3, n4);
                }
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (this.b != null) {
                    this.b.a(charSequence, n2, n3, n4);
                }
                if (this.c != null) {
                    this.c.a();
                }
            }
        };
        c2 = (TextWatcher)d.a((View)textView, object, b.a.textWatcher);
        if (c2 != null) {
            textView.removeTextChangedListener((TextWatcher)c2);
        }
        if (object != null) {
            textView.addTextChangedListener((TextWatcher)object);
        }
    }

    public static void a(TextView textView, CharSequence charSequence) {
        CharSequence charSequence2 = textView.getText();
        if (charSequence != charSequence2) {
            if (charSequence == null && charSequence2.length() == 0) {
                return;
            }
            if (charSequence instanceof Spanned ? charSequence.equals(charSequence2) : !e.a(charSequence, charSequence2)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int n2;
        int n3 = charSequence == null ? 1 : 0;
        if (n3 != (n2 = charSequence2 == null ? 1 : 0)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        n2 = charSequence.length();
        if (n2 != charSequence2.length()) {
            return true;
        }
        for (n3 = 0; n3 < n2; ++n3) {
            if (charSequence.charAt(n3) == charSequence2.charAt(n3)) continue;
            return true;
        }
        return false;
    }

    public static interface a {
        public void a(Editable var1);
    }

    public static interface b {
        public void a(CharSequence var1, int var2, int var3, int var4);
    }

    public static interface c {
        public void a(CharSequence var1, int var2, int var3, int var4);
    }

}

