// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.util.Iterator;
import java.util.ArrayList;
import android.util.Log;
import java.util.Collections;
import java.net.NetworkInterface;
import java.util.HashMap;
import java.util.Map;

public class MacAddress
{
    private static final String TAG;
    private static StringBuilder mStringBuilder;
    
    static {
        TAG = MacAddress.class.getSimpleName();
        MacAddress.mStringBuilder = new StringBuilder();
    }
    
    public static Map<String, String> getMacAddress() {
        HashMap<String, String> hashMap2 = null;
    Label_0053_Outer:
        while (true) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            while (true) {
                String name = null;
                Label_0157: {
                    try {
                        final ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
                        Log.d(MacAddress.TAG, "intf num:" + list.size());
                        final Iterator<Object> iterator = list.iterator();
                        while (true) {
                            hashMap2 = hashMap;
                            if (!iterator.hasNext()) {
                                break;
                            }
                            final NetworkInterface networkInterface = iterator.next();
                            name = networkInterface.getName();
                            if (name == null) {
                                continue Label_0053_Outer;
                            }
                            final byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress == null) {
                                break Label_0157;
                            }
                            final String macString = getMacString(hardwareAddress);
                            hashMap.put(name, macString);
                            Log.d(MacAddress.TAG, "intf name:" + name + ", mac:" + macString);
                        }
                    }
                    catch (Exception ex) {
                        Log.d(MacAddress.TAG, "exception occured:", (Throwable)ex);
                        hashMap2 = null;
                    }
                    break;
                }
                hashMap.put(name, null);
                Log.d(MacAddress.TAG, "intf name:" + name + ", mac: null");
                continue;
            }
        }
        return hashMap2;
    }
    
    private static String getMacString(final byte[] array) {
        MacAddress.mStringBuilder.setLength(0);
        for (int i = 0; i < array.length; ++i) {
            MacAddress.mStringBuilder.append(String.format("%02x", array[i]));
        }
        return MacAddress.mStringBuilder.toString();
    }
}
