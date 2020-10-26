/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010 \u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J*\u0010*\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006."}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/EditNameDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/text/TextWatcher;", "()V", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "getAlertDialog", "()Landroidx/appcompat/app/AlertDialog;", "setAlertDialog", "(Landroidx/appcompat/app/AlertDialog;)V", "clearButton", "Landroidx/appcompat/widget/AppCompatImageView;", "getClearButton", "()Landroidx/appcompat/widget/AppCompatImageView;", "setClearButton", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "listener", "Landroid/content/DialogInterface$OnClickListener;", "getListener", "()Landroid/content/DialogInterface$OnClickListener;", "setListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onTextChanged", "before", "showKeyboard", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends androidx.f.a.c
implements TextWatcher {
    public static final a ak = new a(null);
    public DialogInterface.OnClickListener ag;
    public EditText ah;
    public AppCompatImageView ai;
    public androidx.appcompat.app.b aj;
    private HashMap al;

    private final void ak() {
        Object object = this.m();
        if (object == null) {
            j.a();
        }
        if ((object = object.getSystemService("input_method")) != null) {
            object = (InputMethodManager)object;
            EditText editText = this.ah;
            if (editText == null) {
                j.b("editText");
            }
            object.showSoftInput((View)editText, 0);
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        j.b((Object)onClickListener, "<set-?>");
        this.ag = onClickListener;
    }

    public void afterTextChanged(Editable object) {
        object = this.ah;
        if (object == null) {
            j.b("editText");
        }
        boolean bl2 = (object = (CharSequence)object.getText()) == null || n.a((CharSequence)object);
        if (bl2) {
            object = this.aj;
            if (object == null) {
                j.b("alertDialog");
            }
            object = ((androidx.appcompat.app.b)object).a(-1);
            j.a(object, "alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)");
            object.setEnabled(false);
            object = this.aj;
            if (object == null) {
                j.b("alertDialog");
            }
            object = ((androidx.appcompat.app.b)object).a(-1);
            Context context = this.m();
            if (context == null) {
                j.a();
            }
            object.setTextColor(androidx.core.a.a.c(context, 2131034209));
            object = this.ai;
            if (object == null) {
                j.b("clearButton");
            }
            object.setVisibility(4);
            return;
        }
        object = this.aj;
        if (object == null) {
            j.b("alertDialog");
        }
        object = ((androidx.appcompat.app.b)object).a(-1);
        j.a(object, "alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)");
        object.setEnabled(true);
        object = this.aj;
        if (object == null) {
            j.b("alertDialog");
        }
        object = ((androidx.appcompat.app.b)object).a(-1);
        Context context = this.m();
        if (context == null) {
            j.a();
        }
        object.setTextColor(androidx.core.a.a.c(context, 2131034226));
        object = this.ai;
        if (object == null) {
            j.b("clearButton");
        }
        object.setVisibility(0);
    }

    public final EditText ai() {
        EditText editText = this.ah;
        if (editText == null) {
            j.b("editText");
        }
        return editText;
    }

    public void aj() {
        if (this.al != null) {
            this.al.clear();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
    }

    @Override
    public Dialog c(Bundle object) {
        object = this.k();
        if (object == null || (object = object.getString("myRouteName")) == null) {
            object = "";
        }
        View view = LayoutInflater.from((Context)this.m()).inflate(2131427370, null);
        View view2 = view.findViewById(2131230806);
        j.a((Object)view2, "layoutForDialog.findView\u2026R.id.clearable_edit_text)");
        this.ah = (EditText)view2;
        view2 = view.findViewById(2131230805);
        j.a((Object)view2, "layoutForDialog.findView\u2026d.clearable_button_clear)");
        this.ai = (AppCompatImageView)view2;
        view2 = this.ah;
        if (view2 == null) {
            j.b("editText");
        }
        view2.setText((CharSequence)object);
        object = this.ah;
        if (object == null) {
            j.b("editText");
        }
        object.addTextChangedListener((TextWatcher)this);
        object = this.ai;
        if (object == null) {
            j.b("clearButton");
        }
        object.setOnClickListener(new View.OnClickListener(){

            public final void onClick(View view) {
                this.ai().setText((CharSequence)"");
            }
        });
        object = this.m();
        if (object == null) {
            j.a();
        }
        object = new b.a((Context)object, 2131623950).a(2131558510).b(view);
        view = this.ag;
        if (view == null) {
            j.b("listener");
        }
        object = ((b.a)object).a(2131558478, (DialogInterface.OnClickListener)view).b(2131558453, (DialogInterface.OnClickListener)d.a).b();
        j.a(object, "builder.create()");
        object = this.aj = object;
        if (object == null) {
            j.b("alertDialog");
        }
        object.setOnShowListener(new DialogInterface.OnShowListener(){

            public final void onShow(DialogInterface dialogInterface) {
                new Handler().postDelayed(new Runnable(){

                    @Override
                    public final void run() {
                        this.ak();
                    }
                }, 0L);
            }

        });
        object = this.aj;
        if (object == null) {
            j.b("alertDialog");
        }
        object.setCanceledOnTouchOutside(false);
        object = this.ah;
        if (object == null) {
            j.b("editText");
        }
        if ((view = this.ah) == null) {
            j.b("editText");
        }
        object.setSelection(view.getText().length());
        object = this.aj;
        if (object == null) {
            j.b("alertDialog");
        }
        return (Dialog)object;
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.aj();
    }

    public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/EditNameDialogFragment$Companion;", "", "()V", "MY_ROUTE_NAME", "", "newInstance", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/EditNameDialogFragment;", "title", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final b a(String string2) {
            j.b(string2, "title");
            b b2 = new b();
            Bundle bundle = new Bundle();
            bundle.putString("myRouteName", string2);
            b2.g(bundle);
            return b2;
        }
    }

}

