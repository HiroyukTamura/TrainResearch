// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.data;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public class PositionSavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<PositionSavedState> CREATOR;
    private int lastSelectedPosition;
    private int selectedPosition;
    private int selectingPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PositionSavedState>() {
            public PositionSavedState createFromParcel(final Parcel parcel) {
                return new PositionSavedState(parcel, null);
            }
            
            public PositionSavedState[] newArray(final int n) {
                return new PositionSavedState[n];
            }
        };
    }
    
    private PositionSavedState(final Parcel parcel) {
        super(parcel);
        this.selectedPosition = parcel.readInt();
        this.selectingPosition = parcel.readInt();
        this.lastSelectedPosition = parcel.readInt();
    }
    
    public PositionSavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public int getLastSelectedPosition() {
        return this.lastSelectedPosition;
    }
    
    public int getSelectedPosition() {
        return this.selectedPosition;
    }
    
    public int getSelectingPosition() {
        return this.selectingPosition;
    }
    
    public void setLastSelectedPosition(final int lastSelectedPosition) {
        this.lastSelectedPosition = lastSelectedPosition;
    }
    
    public void setSelectedPosition(final int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
    
    public void setSelectingPosition(final int selectingPosition) {
        this.selectingPosition = selectingPosition;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.selectedPosition);
        parcel.writeInt(this.selectingPosition);
        parcel.writeInt(this.lastSelectedPosition);
    }
}
