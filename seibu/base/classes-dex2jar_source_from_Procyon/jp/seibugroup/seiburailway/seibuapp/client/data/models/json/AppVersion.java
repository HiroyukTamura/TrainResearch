// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

public class AppVersion
{
    private String latestReleaseDateTime;
    private String latestVersion;
    private String validReleaseDateTime;
    private String validVersion;
    
    public String getLatestReleaseDateTime() {
        return this.latestReleaseDateTime;
    }
    
    public String getLatestVersion() {
        return this.latestVersion;
    }
    
    public String getValidReleaseDateTime() {
        return this.validReleaseDateTime;
    }
    
    public String getValidVersion() {
        return this.validVersion;
    }
    
    public boolean isNewerThanCurrent(final String s) {
        final String[] split = this.validVersion.split("\\.");
        final String[] split2 = s.split("\\.");
        final int length = split.length;
        final int length2 = split2.length;
        final int min = Math.min(length, length2);
        int i = 0;
        while (i < min) {
            final int intValue = Integer.valueOf(split[i]);
            final int intValue2 = Integer.valueOf(split2[i]);
            if (intValue != intValue2) {
                if (intValue > intValue2) {
                    return true;
                }
                return false;
            }
            else {
                ++i;
            }
        }
        if (length <= length2) {
            return false;
        }
        return true;
    }
    
    public void setLatestReleaseDateTime(final String latestReleaseDateTime) {
        this.latestReleaseDateTime = latestReleaseDateTime;
    }
    
    public void setLatestVersion(final String latestVersion) {
        this.latestVersion = latestVersion;
    }
    
    public void setValidReleaseDateTime(final String validReleaseDateTime) {
        this.validReleaseDateTime = validReleaseDateTime;
    }
    
    public void setValidVersion(final String validVersion) {
        this.validVersion = validVersion;
    }
}
