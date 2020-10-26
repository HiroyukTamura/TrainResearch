// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import java.util.ListIterator;
import android.net.Uri;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzalx;
import android.text.TextUtils;
import com.google.android.gms.internal.zzalt;
import com.google.android.gms.internal.zzamj;

public class zza extends zzk<zza>
{
    private final zzamj zzadj;
    private boolean zzadk;
    
    public zza(final zzamj zzadj) {
        super(zzadj.zzkt(), zzadj.zzkq());
        this.zzadj = zzadj;
    }
    
    public final void enableAdvertisingIdCollection(final boolean zzadk) {
        this.zzadk = zzadk;
    }
    
    @Override
    protected final void zza(final zzi zzi) {
        final zzalt zzalt = zzi.zzb(zzalt.class);
        if (TextUtils.isEmpty((CharSequence)zzalt.zzjX())) {
            zzalt.setClientId(this.zzadj.zzkJ().zzli());
        }
        if (this.zzadk && TextUtils.isEmpty((CharSequence)zzalt.zzjY())) {
            final zzalx zzkI = this.zzadj.zzkI();
            zzalt.zzbk(zzkI.zzkg());
            zzalt.zzG(zzkI.zzjZ());
        }
    }
    
    public final void zzaY(final String s) {
        zzbo.zzcF(s);
        final Uri zzaZ = zzb.zzaZ(s);
        final ListIterator<zzo> listIterator = super.zzaeb.zzjr().listIterator();
        while (listIterator.hasNext()) {
            if (zzaZ.equals((Object)listIterator.next().zzjl())) {
                listIterator.remove();
            }
        }
        super.zzaeb.zzjr().add(new zzb(this.zzadj, s));
    }
    
    final zzamj zzji() {
        return this.zzadj;
    }
    
    @Override
    public final zzi zzjj() {
        final zzi zzjp = super.zzaeb.zzjp();
        zzjp.zza(this.zzadj.zzkB().zzkW());
        zzjp.zza(this.zzadj.zzkC().zzlA());
        this.zzd(zzjp);
        return zzjp;
    }
}
