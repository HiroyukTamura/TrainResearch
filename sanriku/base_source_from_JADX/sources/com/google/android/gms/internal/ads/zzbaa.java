package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzbaa implements zzazn {
    @Nullable
    private final String zzbft;

    public zzbaa() {
        this((String) null);
    }

    public zzbaa(@Nullable String str) {
        this.zzbft = str;
    }

    @WorkerThread
    public final void zzeq(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        HttpURLConnection httpURLConnection;
        try {
            String valueOf = String.valueOf(str);
            zzazw.zzed(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzvj.zzpr();
            zzazm.zza(true, httpURLConnection, this.zzbft);
            zzazq zzazq = new zzazq();
            zzazq.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzazq.zza(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                sb2.append("Received non-success response code ");
                sb2.append(responseCode);
                sb2.append(" from pinging URL: ");
                sb2.append(str);
                zzazw.zzfc(sb2.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            str2 = C0681a.m314a(C0681a.m336b(message, C0681a.m336b(str, 32)), "Error while parsing ping URL: ", str, ". ", message);
            zzazw.zzfc(str2);
        } catch (IOException e2) {
            str3 = e2.getMessage();
            sb = new StringBuilder(C0681a.m336b(str3, C0681a.m336b(str, 27)));
            sb.append("Error while pinging URL: ");
            sb.append(str);
            sb.append(". ");
            sb.append(str3);
            str2 = sb.toString();
            zzazw.zzfc(str2);
        } catch (RuntimeException e3) {
            str3 = e3.getMessage();
            sb = new StringBuilder(C0681a.m336b(str3, C0681a.m336b(str, 27)));
            sb.append("Error while pinging URL: ");
            sb.append(str);
            sb.append(". ");
            sb.append(str3);
            str2 = sb.toString();
            zzazw.zzfc(str2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
