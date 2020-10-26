/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionProvider
 *  android.view.ActionProvider$VisibilityListener
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.k;
import androidx.core.b.a.b;
import androidx.core.h.b;

class l
extends k {
    l(Context context, b b2) {
        super(context, b2);
    }

    @Override
    k.a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }

    class a
    extends k.a
    implements ActionProvider.VisibilityListener {
        b.b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override
        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        @Override
        public void a(b.b object) {
            this.c = object;
            ActionProvider actionProvider = this.a;
            object = object != null ? this : null;
            actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)object);
        }

        @Override
        public boolean d() {
            return this.a.overridesItemVisibility();
        }

        @Override
        public boolean e() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean bl2) {
            if (this.c != null) {
                this.c.a(bl2);
            }
        }
    }

}

