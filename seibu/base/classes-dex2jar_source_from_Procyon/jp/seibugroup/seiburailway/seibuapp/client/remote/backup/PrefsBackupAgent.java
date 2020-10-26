// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote.backup;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupHelper;
import android.content.Context;
import android.app.backup.SharedPreferencesBackupHelper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyStationData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefWallPaperData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyLineData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefTrafficCardData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMasterData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefBeaconData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppTestData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData;
import java.io.IOException;
import android.util.Log;
import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import android.app.backup.BackupAgentHelper;

public class PrefsBackupAgent extends BackupAgentHelper
{
    public void onBackup(final ParcelFileDescriptor parcelFileDescriptor, final BackupDataOutput backupDataOutput, final ParcelFileDescriptor parcelFileDescriptor2) throws IOException {
        super.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
        Log.d("PrefsBackupAgent", "onBackup");
    }
    
    public void onCreate() {
        Log.d("PrefsBackupAgent", "onCreate");
        this.addHelper("backup_key", (BackupHelper)new SharedPreferencesBackupHelper((Context)this, new String[] { PrefAppData.class.getSimpleName(), PrefAppPotAccount.class.getSimpleName(), PrefAppTestData.class.getSimpleName(), PrefBeaconData.class.getSimpleName(), PrefMasterData.class.getSimpleName(), PrefTrafficCardData.class.getSimpleName(), PrefMyLineData.class.getSimpleName(), PrefWallPaperData.class.getSimpleName(), PrefMyStationData.class.getSimpleName() }));
    }
    
    public void onRestore(final BackupDataInput backupDataInput, final int n, final ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        super.onRestore(backupDataInput, n, parcelFileDescriptor);
        Log.d("PrefsBackupAgent", "onRestore");
    }
}
