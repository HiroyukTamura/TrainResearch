// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import com.feilang.mvpproject.R;

public class Constants
{
    public static final String MAP_KEY_LOGIN_PASSWORD = "password";
    public static final String MAP_KEY_LOGIN_USER_NAME = "username";
    
    public enum DataRefreshEvent
    {
        KEY_ARCHIVE_DATA_UPDATED, 
        KEY_CHANNEL_DATA_UPDATED, 
        KEY_CHANNEL_SLOTS_UPDATED, 
        KEY_NOTICE_COUNT_UPDATED, 
        KEY_NOTICE_DATA_UPDATED, 
        KEY_PROFILE_DATA_UPDATED, 
        KEY_TAGS_DATA_UPDATED, 
        KEY_TIMELINE_DATA_UPDATED;
    }
    
    public enum LayoutType
    {
        GRID_BIG(1, R.drawable.ic_grid_big), 
        GRID_SMALL(2, R.drawable.ic_grid_small), 
        LINEAR(0, R.drawable.ic_linear);
        
        private int iconRes;
        private int typeId;
        
        private LayoutType(final int typeId, final int iconRes) {
            this.typeId = typeId;
            this.iconRes = iconRes;
        }
        
        public static LayoutType getTypeById(final int n) {
            final LayoutType[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                final LayoutType layoutType = values[i];
                if (layoutType.getTypeId() == n) {
                    return layoutType;
                }
            }
            return null;
        }
        
        public static LayoutType getTypeIconRes(final int n) {
            final LayoutType[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                final LayoutType layoutType = values[i];
                if (layoutType.getIconRes() == n) {
                    return layoutType;
                }
            }
            return null;
        }
        
        public int getIconRes() {
            return this.iconRes;
        }
        
        public LayoutType getNextType() {
            return getTypeById((this.typeId + 1) % values().length);
        }
        
        public int getTypeId() {
            return this.typeId;
        }
    }
}
