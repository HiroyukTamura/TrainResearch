package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;
import p009e.p010a.p011a.p012a.C0681a;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new C1205a();

    /* renamed from: a */
    public final SimpleArrayMap<String, Bundle> f1244a;

    /* renamed from: com.google.android.material.stateful.ExtendableSavedState$a */
    static class C1205a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        C1205a() {
        }

        public Object createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, (ClassLoader) null, (C1205a) null);
        }

        public Object[] newArray(int i) {
            return new ExtendableSavedState[i];
        }

        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, (C1205a) null);
        }
    }

    /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, C1205a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f1244a = new SimpleArrayMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f1244a.put(strArr[i], bundleArr[i]);
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f1244a = new SimpleArrayMap<>();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ExtendableSavedState{");
        a.append(Integer.toHexString(System.identityHashCode(this)));
        a.append(" states=");
        a.append(this.f1244a);
        a.append("}");
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f1244a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f1244a.keyAt(i2);
            bundleArr[i2] = this.f1244a.valueAt(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
