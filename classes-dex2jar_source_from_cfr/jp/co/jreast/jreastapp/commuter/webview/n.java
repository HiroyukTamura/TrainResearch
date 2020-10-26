/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;
import androidx.f.a.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u0011"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/MessageDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "negativeListener", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeListener", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "positiveListener", "getPositiveListener", "setPositiveListener", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class n
extends c {
    public static final a ah = new a(null);
    public DialogInterface.OnClickListener ag;
    private DialogInterface.OnClickListener ai;
    private HashMap aj;

    public final void a(DialogInterface.OnClickListener onClickListener) {
        j.b((Object)onClickListener, "<set-?>");
        this.ag = onClickListener;
    }

    public void ai() {
        if (this.aj != null) {
            this.aj.clear();
        }
    }

    public final void b(DialogInterface.OnClickListener onClickListener) {
        this.ai = onClickListener;
    }

    @Override
    public Dialog c(Bundle object) {
        object = this.m();
        if (object == null) {
            j.a();
        }
        b.a a2 = new b.a((Context)object, 2131623950);
        object = this.k();
        if (object == null || (object = object.getString("msgDialogTitle")) == null) {
            object = "";
        }
        b.a a3 = a2.a((CharSequence)object);
        object = this.k();
        if (object == null || (object = object.getString("msgDialogMessage")) == null) {
            object = "";
        }
        a3 = a3.b((CharSequence)object);
        object = this.k();
        if (object == null || (object = object.getString("msgDialogPositiveLabel")) == null) {
            object = "OK";
        }
        object = (CharSequence)object;
        DialogInterface.OnClickListener onClickListener = this.ag;
        if (onClickListener == null) {
            j.b("positiveListener");
        }
        a3.a((CharSequence)object, onClickListener);
        object = this.k();
        if (object == null || (object = object.getString("msgDialogNegativeLabel")) == null) {
            object = "";
        }
        if (j.a(object, (Object)"") ^ true && this.ai != null) {
            a2.b((CharSequence)object, this.ai);
        }
        object = a2.b();
        object.setCanceledOnTouchOutside(false);
        j.a(object, "dialog");
        return (Dialog)object;
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.ai();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/MessageDialogFragment$Companion;", "", "()V", "MESSAGE", "", "NEGATIVE_LABEL", "POSITIVE_LABEL", "TITLE", "newInstance", "Ljp/co/jreast/jreastapp/commuter/webview/MessageDialogFragment;", "title", "message", "positiveLabel", "negativeLabel", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final n a(String string2, String string3, String string4, String string5) {
            j.b(string2, "title");
            j.b(string3, "message");
            j.b(string4, "positiveLabel");
            n n2 = new n();
            Bundle bundle = new Bundle();
            bundle.putString("msgDialogTitle", string2);
            bundle.putString("msgDialogMessage", string3);
            bundle.putString("msgDialogPositiveLabel", string4);
            bundle.putString("msgDialogNegativeLabel", string5);
            n2.g(bundle);
            return n2;
        }
    }

}

