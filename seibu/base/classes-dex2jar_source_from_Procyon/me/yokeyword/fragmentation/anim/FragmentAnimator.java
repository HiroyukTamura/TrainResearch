// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation.anim;

import android.os.Parcel;
import android.support.annotation.AnimRes;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class FragmentAnimator implements Parcelable
{
    public static final Parcelable$Creator<FragmentAnimator> CREATOR;
    @AnimRes
    protected int enter;
    @AnimRes
    protected int exit;
    @AnimRes
    protected int popEnter;
    @AnimRes
    protected int popExit;
    
    static {
        CREATOR = (Parcelable$Creator)new FragmentAnimator$1();
    }
    
    public FragmentAnimator() {
    }
    
    public FragmentAnimator(final int enter, final int exit) {
        this.enter = enter;
        this.exit = exit;
    }
    
    public FragmentAnimator(final int enter, final int exit, final int popEnter, final int popExit) {
        this.enter = enter;
        this.exit = exit;
        this.popEnter = popEnter;
        this.popExit = popExit;
    }
    
    protected FragmentAnimator(final Parcel parcel) {
        this.enter = parcel.readInt();
        this.exit = parcel.readInt();
        this.popEnter = parcel.readInt();
        this.popExit = parcel.readInt();
    }
    
    public FragmentAnimator copy() {
        return new FragmentAnimator(this.getEnter(), this.getExit(), this.getPopEnter(), this.getPopExit());
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int getEnter() {
        return this.enter;
    }
    
    public int getExit() {
        return this.exit;
    }
    
    public int getPopEnter() {
        return this.popEnter;
    }
    
    public int getPopExit() {
        return this.popExit;
    }
    
    public void setEnter(final int enter) {
        this.enter = enter;
    }
    
    public void setExit(final int exit) {
        this.exit = exit;
    }
    
    public void setPopEnter(final int popEnter) {
        this.popEnter = popEnter;
    }
    
    public void setPopExit(final int popExit) {
        this.popExit = popExit;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.enter);
        parcel.writeInt(this.exit);
        parcel.writeInt(this.popEnter);
        parcel.writeInt(this.popExit);
    }
}
