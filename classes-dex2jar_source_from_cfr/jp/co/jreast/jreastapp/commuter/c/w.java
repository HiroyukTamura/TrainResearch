/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.DatePicker
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.Space
 *  android.widget.TimePicker
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import android.widget.TimePicker;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.timeselect.b;

public abstract class w
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final Button d;
    public final DatePicker e;
    public final Space f;
    public final Button g;
    public final RadioGroup h;
    public final RadioButton i;
    public final RadioButton j;
    public final RadioButton k;
    public final RadioButton l;
    public final TimePicker m;
    protected b n;

    protected w(e e2, View view, int n2, AppCompatImageView appCompatImageView, Button button, DatePicker datePicker, Space space, Button button2, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, TimePicker timePicker) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = button;
        this.e = datePicker;
        this.f = space;
        this.g = button2;
        this.h = radioGroup;
        this.i = radioButton;
        this.j = radioButton2;
        this.k = radioButton3;
        this.l = radioButton4;
        this.m = timePicker;
    }

    public abstract void a(b var1);
}

