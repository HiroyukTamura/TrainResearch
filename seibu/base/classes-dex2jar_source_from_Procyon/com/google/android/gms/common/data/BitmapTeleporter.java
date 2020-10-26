// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import android.graphics.Bitmap$Config;
import java.io.InputStream;
import java.io.DataInputStream;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import android.os.Parcel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class BitmapTeleporter extends zza implements ReflectedParcelable
{
    public static final Parcelable$Creator<BitmapTeleporter> CREATOR;
    private ParcelFileDescriptor zzTP;
    private Bitmap zzaFr;
    private boolean zzaFs;
    private File zzaFt;
    private int zzaku;
    private int zzamr;
    
    static {
        CREATOR = (Parcelable$Creator)new com.google.android.gms.common.data.zza();
    }
    
    BitmapTeleporter(final int zzaku, final ParcelFileDescriptor zzTP, final int zzamr) {
        this.zzaku = zzaku;
        this.zzTP = zzTP;
        this.zzamr = zzamr;
        this.zzaFr = null;
        this.zzaFs = false;
    }
    
    public BitmapTeleporter(final Bitmap zzaFr) {
        this.zzaku = 1;
        this.zzTP = null;
        this.zzamr = 0;
        this.zzaFr = zzaFr;
        this.zzaFs = true;
    }
    
    private static void zza(final Closeable closeable) {
        try {
            closeable.close();
        }
        catch (IOException ex) {
            Log.w("BitmapTeleporter", "Could not close stream", (Throwable)ex);
        }
    }
    
    private final FileOutputStream zzqP() {
        if (this.zzaFt == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        File file;
        try {
            final File tempFile;
            file = (tempFile = File.createTempFile("teleporter", ".tmp", this.zzaFt));
            final FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            final BitmapTeleporter bitmapTeleporter = this;
            final File file2 = file;
            final int n = 268435456;
            final ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(file2, n);
            bitmapTeleporter.zzTP = parcelFileDescriptor;
            final File file3 = file;
            file3.delete();
            return fileOutputStream;
        }
        catch (IOException cause) {
            throw new IllegalStateException("Could not create temporary file", cause);
        }
        try {
            final File tempFile = file;
            final FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            final BitmapTeleporter bitmapTeleporter = this;
            final File file2 = file;
            final int n = 268435456;
            final ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(file2, n);
            bitmapTeleporter.zzTP = parcelFileDescriptor;
            final File file3 = file;
            file3.delete();
            return fileOutputStream;
        }
        catch (FileNotFoundException ex) {
            throw new IllegalStateException("Temporary file is somehow already deleted");
        }
    }
    
    public final void release() {
        if (this.zzaFs) {
            return;
        }
        try {
            this.zzTP.close();
        }
        catch (IOException ex) {
            Log.w("BitmapTeleporter", "Could not close PFD", (Throwable)ex);
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        Label_0109: {
            if (this.zzTP != null) {
                break Label_0109;
            }
            final Bitmap zzaFr = this.zzaFr;
            final ByteBuffer allocate = ByteBuffer.allocate(zzaFr.getRowBytes() * zzaFr.getHeight());
            zzaFr.copyPixelsToBuffer((Buffer)allocate);
            final byte[] array = allocate.array();
            final DataOutputStream dataOutputStream = new DataOutputStream(this.zzqP());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(zzaFr.getWidth());
                dataOutputStream.writeInt(zzaFr.getHeight());
                dataOutputStream.writeUTF(zzaFr.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
                final int zze = zzd.zze(parcel);
                zzd.zzc(parcel, 1, this.zzaku);
                zzd.zza(parcel, 2, (Parcelable)this.zzTP, n | 0x1, false);
                zzd.zzc(parcel, 3, this.zzamr);
                zzd.zzI(parcel, zze);
                this.zzTP = null;
            }
            catch (IOException cause) {
                throw new IllegalStateException("Could not write into unlinked file", cause);
            }
            finally {
                zza(dataOutputStream);
            }
        }
    }
    
    public final void zzc(final File zzaFt) {
        if (zzaFt == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.zzaFt = zzaFt;
    }
    
    public final Bitmap zzqO() {
        Label_0096: {
            if (this.zzaFs) {
                break Label_0096;
            }
            Object wrap = new DataInputStream((InputStream)new ParcelFileDescriptor$AutoCloseInputStream(this.zzTP));
            try {
                final byte[] array = new byte[((DataInputStream)wrap).readInt()];
                final int int1 = ((DataInputStream)wrap).readInt();
                final int int2 = ((DataInputStream)wrap).readInt();
                final Bitmap$Config value = Bitmap$Config.valueOf(((DataInputStream)wrap).readUTF());
                ((DataInputStream)wrap).read(array);
                zza((Closeable)wrap);
                wrap = ByteBuffer.wrap(array);
                final Bitmap bitmap = Bitmap.createBitmap(int1, int2, value);
                bitmap.copyPixelsFromBuffer((Buffer)wrap);
                this.zzaFr = bitmap;
                this.zzaFs = true;
                return this.zzaFr;
            }
            catch (IOException cause) {
                throw new IllegalStateException("Could not read from parcel file descriptor", cause);
            }
            finally {
                zza((Closeable)wrap);
            }
        }
    }
}
