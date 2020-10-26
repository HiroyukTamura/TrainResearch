/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.b;

import androidx.appcompat.app.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\u0006"}, d2={"Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onPause", "", "onResume", "app_productRelease"}, k=1, mv={1, 1, 11})
public class a
extends c {
    @Override
    protected void onPause() {
        super.onPause();
        this.overridePendingTransition(0, 2130771989);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.overridePendingTransition(2130771987, 0);
    }
}

