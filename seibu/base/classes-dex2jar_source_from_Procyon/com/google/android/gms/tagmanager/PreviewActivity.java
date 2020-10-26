// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.app.AlertDialog;
import android.net.Uri;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

public class PreviewActivity extends Activity
{
    public void onCreate(final Bundle bundle) {
        while (true) {
            while (true) {
                Label_0244: {
                    try {
                        super.onCreate(bundle);
                        zzdj.zzaS("Preview activity");
                        final Uri data = this.getIntent().getData();
                        if (!TagManager.getInstance((Context)this).zzr(data)) {
                            final String value = String.valueOf(data);
                            final String string = new StringBuilder(String.valueOf(value).length() + 73).append("Cannot preview the app with the uri: ").append(value).append(". Launching current version instead.").toString();
                            zzdj.zzaT(string);
                            final AlertDialog create = new AlertDialog$Builder((Context)this).create();
                            create.setTitle((CharSequence)"Preview failure");
                            create.setMessage((CharSequence)string);
                            create.setButton(-1, (CharSequence)"Continue", (DialogInterface$OnClickListener)new zzeh(this));
                            create.show();
                        }
                        final Intent launchIntentForPackage = this.getPackageManager().getLaunchIntentForPackage(this.getPackageName());
                        if (launchIntentForPackage != null) {
                            final String value2 = String.valueOf(this.getPackageName());
                            String concat;
                            if (value2.length() != 0) {
                                concat = "Invoke the launch activity for package name: ".concat(value2);
                            }
                            else {
                                concat = new String("Invoke the launch activity for package name: ");
                            }
                            zzdj.zzaS(concat);
                            this.startActivity(launchIntentForPackage);
                            return;
                        }
                    }
                    catch (Exception ex) {
                        final String value3 = String.valueOf(ex.getMessage());
                        if (value3.length() != 0) {
                            final String concat2 = "Calling preview threw an exception: ".concat(value3);
                            zzdj.e(concat2);
                            return;
                        }
                        break Label_0244;
                    }
                    break;
                }
                final String concat2 = new String("Calling preview threw an exception: ");
                continue;
            }
        }
        final String value4 = String.valueOf(this.getPackageName());
        String concat3;
        if (value4.length() != 0) {
            concat3 = "No launch activity found for package name: ".concat(value4);
        }
        else {
            concat3 = new String("No launch activity found for package name: ");
        }
        zzdj.zzaS(concat3);
    }
}
