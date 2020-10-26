// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Locale;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public final class zzalx extends zzamh
{
    private static boolean zzafv;
    private Object zzafA;
    private AdvertisingIdClient.Info zzafw;
    private final zzaoo zzafx;
    private String zzafy;
    private boolean zzafz;
    
    zzalx(final zzamj zzamj) {
        super(zzamj);
        this.zzafz = false;
        this.zzafA = new Object();
        this.zzafx = new zzaoo(zzamj.zzkq());
    }
    
    private final boolean zza(final AdvertisingIdClient.Info info, AdvertisingIdClient.Info id) {
        String s = null;
        if (id == null) {
            id = null;
        }
        else {
            id = ((AdvertisingIdClient.Info)id).getId();
        }
        if (TextUtils.isEmpty((CharSequence)id)) {
            return true;
        }
    Label_0091_Outer:
        while (true) {
            final String zzli = this.zzkz().zzli();
            final AdvertisingIdClient.Info original;
        Label_0252:
            while (true) {
            Label_0240:
                while (true) {
                    synchronized (this.zzafA) {
                        if (!this.zzafz) {
                            this.zzafy = this.zzkj();
                            this.zzafz = true;
                            final String value = String.valueOf(id);
                            s = String.valueOf(zzli);
                            if (s.length() == 0) {
                                break Label_0240;
                            }
                            final String concat = value.concat(s);
                            if (TextUtils.isEmpty((CharSequence)zzbm(concat))) {
                                return false;
                            }
                            break Label_0252;
                        }
                    }
                    if (!TextUtils.isEmpty((CharSequence)this.zzafy)) {
                        continue Label_0091_Outer;
                    }
                    String id2;
                    if (original == null) {
                        id2 = s;
                    }
                    else {
                        id2 = original.getId();
                    }
                    if (id2 == null) {
                        final String value2 = String.valueOf(id);
                        final String value3 = String.valueOf(zzli);
                        String concat2;
                        if (value3.length() != 0) {
                            concat2 = value2.concat(value3);
                        }
                        else {
                            concat2 = new String(value2);
                        }
                        // monitorexit(o)
                        return this.zzbn(concat2);
                    }
                    final String value4 = String.valueOf(id2);
                    s = String.valueOf(zzli);
                    String concat3;
                    if (s.length() != 0) {
                        concat3 = value4.concat(s);
                    }
                    else {
                        concat3 = new String(value4);
                    }
                    this.zzafy = zzbm(concat3);
                    continue Label_0091_Outer;
                }
                final String concat = new String((String)original);
                continue;
            }
            if (((String)original).equals(this.zzafy)) {
                // monitorexit(o)
                return true;
            }
            String zzlj;
            if (!TextUtils.isEmpty((CharSequence)this.zzafy)) {
                this.zzbo("Resetting the client id because Advertising Id changed.");
                zzlj = this.zzkz().zzlj();
                this.zza("New client Id", zzlj);
            }
            else {
                zzlj = zzli;
            }
            final String value5 = String.valueOf(id);
            final String value6 = String.valueOf(zzlj);
            String concat4;
            if (value6.length() != 0) {
                concat4 = value5.concat(value6);
            }
            else {
                concat4 = new String(value5);
            }
            // monitorexit(o)
            return this.zzbn(concat4);
        }
    }
    
    private static String zzbm(final String s) {
        final MessageDigest zzbE = zzaos.zzbE("MD5");
        if (zzbE == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzbE.digest(s.getBytes())));
    }
    
    private final boolean zzbn(String zzbm) {
        try {
            zzbm = zzbm(zzbm);
            this.zzbo("Storing hashed adid.");
            final FileOutputStream openFileOutput = this.getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzbm.getBytes());
            openFileOutput.close();
            this.zzafy = zzbm;
            return true;
        }
        catch (IOException ex) {
            this.zze("Error creating hash file", ex);
            return false;
        }
    }
    
    private final AdvertisingIdClient.Info zzkh() {
        synchronized (this) {
            if (this.zzafx.zzu(1000L)) {
                this.zzafx.start();
                final AdvertisingIdClient.Info zzki = this.zzki();
                if (this.zza(this.zzafw, zzki)) {
                    this.zzafw = zzki;
                }
                else {
                    this.zzbs("Failed to reset client id on adid change. Not using adid");
                    this.zzafw = new AdvertisingIdClient.Info("", false);
                }
            }
            return this.zzafw;
        }
    }
    
    private final AdvertisingIdClient.Info zzki() {
        Object advertisingIdInfo = null;
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.getContext());
            return (AdvertisingIdClient.Info)advertisingIdInfo;
        }
        catch (IllegalStateException ex) {
            this.zzbr("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        }
        catch (Throwable t) {
            if (!zzalx.zzafv) {
                zzalx.zzafv = true;
                this.zzd("Error getting advertiser id", t);
                return null;
            }
            return (AdvertisingIdClient.Info)advertisingIdInfo;
        }
    }
    
    private final String zzkj() {
        FileInputStream openFileInput = null;
        Object o = null;
        try {
            openFileInput = this.getContext().openFileInput("gaClientIdData");
            o = new byte[128];
            final int read = openFileInput.read((byte[])o, 0, 128);
            if (openFileInput.available() > 0) {
                this.zzbr("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.getContext().deleteFile("gaClientIdData");
                return null;
            }
            if (read <= 0) {
                this.zzbo("Hash file is empty.");
                openFileInput.close();
                return null;
            }
            o = new String((byte[])o, 0, read);
            final FileInputStream fileInputStream = openFileInput;
            fileInputStream.close();
            final byte[] array = (byte[])o;
            return (String)(Object)array;
        }
        catch (IOException ex) {}
        catch (FileNotFoundException ex2) {
            return null;
        }
        try {
            final FileInputStream fileInputStream = openFileInput;
            fileInputStream.close();
            final byte[] array = (byte[])o;
            return (String)(Object)array;
        }
        catch (IOException ex3) {}
        catch (FileNotFoundException ex4) {}
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final boolean zzjZ() {
        final boolean b = false;
        this.zzkD();
        final AdvertisingIdClient.Info zzkh = this.zzkh();
        boolean b2 = b;
        if (zzkh != null) {
            b2 = b;
            if (!zzkh.isLimitAdTrackingEnabled()) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public final String zzkg() {
        this.zzkD();
        final AdvertisingIdClient.Info zzkh = this.zzkh();
        String id;
        if (zzkh != null) {
            id = zzkh.getId();
        }
        else {
            id = null;
        }
        if (TextUtils.isEmpty((CharSequence)id)) {
            return null;
        }
        return id;
    }
}
