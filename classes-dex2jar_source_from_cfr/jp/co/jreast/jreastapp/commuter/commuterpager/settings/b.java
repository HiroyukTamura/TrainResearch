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
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;
import androidx.f.a.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/RemoveAccessLogCompleteDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "listener", "Landroid/content/DialogInterface$OnClickListener;", "getListener", "()Landroid/content/DialogInterface$OnClickListener;", "setListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends c {
    private HashMap ag;

    public void ai() {
        if (this.ag != null) {
            this.ag.clear();
        }
    }

    @Override
    public Dialog c(Bundle object) {
        object = this.m();
        if (object == null) {
            j.a();
        }
        object = new b.a((Context)object, 2131623950);
        ((b.a)object).a(2131558557).b(2131558467, (DialogInterface.OnClickListener)a.a);
        object = ((b.a)object).b();
        object.setCanceledOnTouchOutside(false);
        j.a(object, "dialog");
        return (Dialog)object;
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.ai();
    }

}
