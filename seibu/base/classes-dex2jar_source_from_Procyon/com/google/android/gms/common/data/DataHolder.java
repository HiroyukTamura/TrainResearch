// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import java.util.Iterator;
import com.google.android.gms.common.internal.zzc;
import android.content.ContentValues;
import java.util.HashMap;
import android.database.CharArrayBuffer;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.database.CursorIndexOutOfBoundsException;
import java.util.Map;
import android.util.Log;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zzbo;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.annotation.KeepName;
import java.io.Closeable;
import com.google.android.gms.common.internal.safeparcel.zza;

@KeepName
public final class DataHolder extends com.google.android.gms.common.internal.safeparcel.zza implements Closeable
{
    public static final Parcelable$Creator<DataHolder> CREATOR;
    private static final zza zzaFI;
    private boolean mClosed;
    private final String[] zzaFB;
    private Bundle zzaFC;
    private final CursorWindow[] zzaFD;
    private final Bundle zzaFE;
    private int[] zzaFF;
    int zzaFG;
    private boolean zzaFH;
    private int zzaku;
    private final int zzaxu;
    
    static {
        CREATOR = (Parcelable$Creator)new zzf();
        zzaFI = (zza)new zze(new String[0], null);
    }
    
    DataHolder(final int zzaku, final String[] zzaFB, final CursorWindow[] zzaFD, final int zzaxu, final Bundle zzaFE) {
        this.mClosed = false;
        this.zzaFH = true;
        this.zzaku = zzaku;
        this.zzaFB = zzaFB;
        this.zzaFD = zzaFD;
        this.zzaxu = zzaxu;
        this.zzaFE = zzaFE;
    }
    
    private DataHolder(final zza zza, final int n, final Bundle bundle) {
        this(zza.zzaFB, zza(zza, -1), n, null);
    }
    
    private DataHolder(final String[] array, final CursorWindow[] array2, final int zzaxu, final Bundle zzaFE) {
        this.mClosed = false;
        this.zzaFH = true;
        this.zzaku = 1;
        this.zzaFB = zzbo.zzu(array);
        this.zzaFD = zzbo.zzu(array2);
        this.zzaxu = zzaxu;
        this.zzaFE = zzaFE;
        this.zzqR();
    }
    
    public static zza zza(final String[] array) {
        return new zza(array, null, null);
    }
    
    private static CursorWindow[] zza(final zza zza, int i) {
        final int n = 0;
        if (zza.zzaFB.length == 0) {
            return new CursorWindow[0];
        }
        final ArrayList zzb = zza.zzaFJ;
        final int size = zzb.size();
        CursorWindow e = new CursorWindow(false);
        final ArrayList<CursorWindow> list = new ArrayList<CursorWindow>();
        list.add(e);
        e.setNumColumns(zza.zzaFB.length);
        i = 0;
        int n2 = 0;
        while (i < size) {
        Label_0375_Outer:
            while (true) {
                CursorWindow e2 = e;
                boolean b = false;
            Label_0567:
                while (true) {
                Label_0715:
                    while (true) {
                        int n3 = 0;
                        Label_0708: {
                            try {
                                if (!e.allocRow()) {
                                    Log.d("DataHolder", new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i).append(")").toString());
                                    final CursorWindow cursorWindow = new CursorWindow(false);
                                    cursorWindow.setStartPosition(i);
                                    cursorWindow.setNumColumns(zza.zzaFB.length);
                                    list.add(cursorWindow);
                                    e2 = cursorWindow;
                                    if (!cursorWindow.allocRow()) {
                                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                                        list.remove(cursorWindow);
                                        return list.toArray(new CursorWindow[list.size()]);
                                    }
                                }
                                final Map<K, String> map = zzb.get(i);
                                n3 = 0;
                                b = true;
                                if (n3 < zza.zzaFB.length && b) {
                                    final String s = zza.zzaFB[n3];
                                    final String value = map.get(s);
                                    if (value == null) {
                                        b = e2.putNull(i, n3);
                                        break Label_0708;
                                    }
                                    if (value instanceof String) {
                                        b = e2.putString((String)value, i, n3);
                                        break Label_0708;
                                    }
                                    if (value instanceof Long) {
                                        b = e2.putLong((long)value, i, n3);
                                        break Label_0708;
                                    }
                                    if (value instanceof Integer) {
                                        b = e2.putLong((long)(int)value, i, n3);
                                        break Label_0708;
                                    }
                                    if (value instanceof Boolean) {
                                        if (value) {
                                            final long n4 = 1L;
                                            b = e2.putLong(n4, i, n3);
                                            break Label_0708;
                                        }
                                        break Label_0715;
                                    }
                                    else {
                                        if (value instanceof byte[]) {
                                            b = e2.putBlob((byte[])(Object)value, i, n3);
                                            break Label_0708;
                                        }
                                        if (value instanceof Double) {
                                            b = e2.putDouble((double)value, i, n3);
                                            break Label_0708;
                                        }
                                        if (value instanceof Float) {
                                            b = e2.putDouble((double)(float)value, i, n3);
                                            break Label_0708;
                                        }
                                        final String value2 = String.valueOf(value);
                                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(s).length() + 32 + String.valueOf(value2).length()).append("Unsupported object for column ").append(s).append(": ").append(value2).toString());
                                    }
                                }
                            }
                            catch (RuntimeException ex) {
                                int size2;
                                for (size2 = list.size(), i = n; i < size2; ++i) {
                                    list.get(i).close();
                                }
                                throw ex;
                            }
                            break Label_0567;
                        }
                        ++n3;
                        continue Label_0375_Outer;
                    }
                    final long n4 = 0L;
                    continue;
                }
                int n5;
                if (!b) {
                    if (n2 != 0) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", new StringBuilder(74).append("Couldn't populate window data for row ").append(i).append(" - allocating new window.").toString());
                    e2.freeLastRow();
                    e2 = new CursorWindow(false);
                    e2.setStartPosition(i);
                    e2.setNumColumns(zza.zzaFB.length);
                    list.add(e2);
                    n5 = i - 1;
                    i = 1;
                }
                else {
                    final int n6 = 0;
                    n5 = i;
                    i = n6;
                }
                final int n7 = i;
                i = n5 + 1;
                e = e2;
                n2 = n7;
                break;
            }
        }
        return list.toArray(new CursorWindow[list.size()]);
    }
    
    public static DataHolder zzau(final int n) {
        return new DataHolder(DataHolder.zzaFI, n, null);
    }
    
    private final void zzh(String s, final int n) {
        if (this.zzaFC == null || !this.zzaFC.containsKey(s)) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "No such column: ".concat(s);
            }
            else {
                s = new String("No such column: ");
            }
            throw new IllegalArgumentException(s);
        }
        if (this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (n < 0 || n >= this.zzaFG) {
            throw new CursorIndexOutOfBoundsException(n, this.zzaFG);
        }
    }
    
    @Override
    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.zzaFD.length; ++i) {
                    this.zzaFD[i].close();
                }
            }
        }
    }
    
    @Override
    protected final void finalize() throws Throwable {
        try {
            if (this.zzaFH && this.zzaFD.length > 0 && !this.isClosed()) {
                this.close();
                final String value = String.valueOf(this.toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(value).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(value).append(")").toString());
            }
        }
        finally {
            super.finalize();
        }
    }
    
    public final int getCount() {
        return this.zzaFG;
    }
    
    public final int getStatusCode() {
        return this.zzaxu;
    }
    
    public final boolean isClosed() {
        synchronized (this) {
            return this.mClosed;
        }
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.zzaFB, false);
        zzd.zza(parcel, 2, this.zzaFD, n, false);
        zzd.zzc(parcel, 3, this.zzaxu);
        zzd.zza(parcel, 4, this.zzaFE, false);
        zzd.zzc(parcel, 1000, this.zzaku);
        zzd.zzI(parcel, zze);
    }
    
    public final void zza(final String s, final int n, final int n2, final CharArrayBuffer charArrayBuffer) {
        this.zzh(s, n);
        this.zzaFD[n2].copyStringToBuffer(n, this.zzaFC.getInt(s), charArrayBuffer);
    }
    
    public final int zzat(int n) {
        int n2 = 0;
        zzbo.zzae(n >= 0 && n < this.zzaFG);
        int n3;
        while (true) {
            n3 = n2;
            if (n2 >= this.zzaFF.length) {
                break;
            }
            if (n < this.zzaFF[n2]) {
                n3 = n2 - 1;
                break;
            }
            ++n2;
        }
        if ((n = n3) == this.zzaFF.length) {
            n = n3 - 1;
        }
        return n;
    }
    
    public final long zzb(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getLong(n, this.zzaFC.getInt(s));
    }
    
    public final int zzc(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getInt(n, this.zzaFC.getInt(s));
    }
    
    public final boolean zzcv(final String s) {
        return this.zzaFC.containsKey(s);
    }
    
    public final String zzd(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getString(n, this.zzaFC.getInt(s));
    }
    
    public final boolean zze(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getLong(n, this.zzaFC.getInt(s)) == 1L;
    }
    
    public final float zzf(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getFloat(n, this.zzaFC.getInt(s));
    }
    
    public final byte[] zzg(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].getBlob(n, this.zzaFC.getInt(s));
    }
    
    public final boolean zzh(final String s, final int n, final int n2) {
        this.zzh(s, n);
        return this.zzaFD[n2].isNull(n, this.zzaFC.getInt(s));
    }
    
    public final Bundle zzqN() {
        return this.zzaFE;
    }
    
    public final void zzqR() {
        final int n = 0;
        this.zzaFC = new Bundle();
        for (int i = 0; i < this.zzaFB.length; ++i) {
            this.zzaFC.putInt(this.zzaFB[i], i);
        }
        this.zzaFF = new int[this.zzaFD.length];
        final int n2 = 0;
        int j = n;
        int zzaFG = n2;
        while (j < this.zzaFD.length) {
            this.zzaFF[j] = zzaFG;
            zzaFG += this.zzaFD[j].getNumRows() - (zzaFG - this.zzaFD[j].getStartPosition());
            ++j;
        }
        this.zzaFG = zzaFG;
    }
    
    public static class zza
    {
        private final String[] zzaFB;
        private final ArrayList<HashMap<String, Object>> zzaFJ;
        private final String zzaFK;
        private final HashMap<Object, Integer> zzaFL;
        private boolean zzaFM;
        private String zzaFN;
        
        private zza(final String[] array, final String zzaFK) {
            this.zzaFB = zzbo.zzu(array);
            this.zzaFJ = new ArrayList<HashMap<String, Object>>();
            this.zzaFK = zzaFK;
            this.zzaFL = new HashMap<Object, Integer>();
            this.zzaFM = false;
            this.zzaFN = null;
        }
        
        public zza zza(final ContentValues contentValues) {
            zzc.zzr(contentValues);
            final HashMap<String, Object> hashMap = new HashMap<String, Object>(contentValues.size());
            for (final Map.Entry<String, V> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return this.zza(hashMap);
        }
        
        public zza zza(final HashMap<String, Object> hashMap) {
            zzc.zzr(hashMap);
            int intValue;
            if (this.zzaFK == null) {
                intValue = -1;
            }
            else {
                final Object value = hashMap.get(this.zzaFK);
                if (value == null) {
                    intValue = -1;
                }
                else {
                    final Integer n = this.zzaFL.get(value);
                    if (n == null) {
                        this.zzaFL.put(value, this.zzaFJ.size());
                        intValue = -1;
                    }
                    else {
                        intValue = n;
                    }
                }
            }
            if (intValue == -1) {
                this.zzaFJ.add(hashMap);
            }
            else {
                this.zzaFJ.remove(intValue);
                this.zzaFJ.add(intValue, hashMap);
            }
            this.zzaFM = false;
            return this;
        }
        
        public final DataHolder zzav(final int n) {
            return new DataHolder(this, 0, null, null);
        }
    }
    
    public static final class zzb extends RuntimeException
    {
        public zzb(final String message) {
            super(message);
        }
    }
}
