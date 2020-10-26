/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.d.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.d.a.a;

public abstract class c
extends a {
    private int j;
    private int k;
    private LayoutInflater l;

    @Deprecated
    public c(Context context, int n2, Cursor cursor, boolean bl2) {
        super(context, cursor, bl2);
        this.k = n2;
        this.j = n2;
        this.l = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Override
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.j, viewGroup, false);
    }

    @Override
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.l.inflate(this.k, viewGroup, false);
    }
}

