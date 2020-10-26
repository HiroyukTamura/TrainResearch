// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.proxy;

import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import android.util.Log;
import java.net.URLEncoder;
import android.content.Context;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TorServiceUtils
{
    public static final String CHMOD_EXE_VALUE = "700";
    public static final String SHELL_CMD_CHMOD = "chmod";
    public static final String SHELL_CMD_KILL = "kill -9";
    public static final String SHELL_CMD_PIDOF = "pidof";
    public static final String SHELL_CMD_PS = "ps";
    public static final String SHELL_CMD_RM = "rm";
    private static final String TAG = "TorUtils";
    
    public static int doShellCommand(final String[] array, final StringBuilder sb, final boolean b, final boolean b2) throws Exception {
        final int n = -1;
        Process process;
        if (b) {
            process = Runtime.getRuntime().exec("su");
        }
        else {
            process = Runtime.getRuntime().exec("sh");
        }
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(process.getOutputStream());
        for (int i = 0; i < array.length; ++i) {
            outputStreamWriter.write(array[i]);
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
        outputStreamWriter.write("exit\n");
        outputStreamWriter.flush();
        int wait = n;
        if (b2) {
            final char[] array2 = new char[10];
            final InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            while (true) {
                final int read = inputStreamReader.read(array2);
                if (read == -1) {
                    break;
                }
                if (sb == null) {
                    continue;
                }
                sb.append(array2, 0, read);
            }
            final InputStreamReader inputStreamReader2 = new InputStreamReader(process.getErrorStream());
            while (true) {
                final int read2 = inputStreamReader2.read(array2);
                if (read2 == -1) {
                    break;
                }
                if (sb == null) {
                    continue;
                }
                sb.append(array2, 0, read2);
            }
            wait = process.waitFor();
        }
        return wait;
    }
    
    public static int findProcessId(Context string) {
        string = (Context)(string.getFilesDir().getParentFile().getParentFile().getAbsolutePath() + "/" + "org.torproject.android" + "/app_bin/tor");
        int n = -1;
        try {
            final int n2 = n = findProcessIdWithPidOf((String)string);
            if (n2 == -1) {
                n = n2;
                n = findProcessIdWithPS((String)string);
            }
            return n;
        }
        catch (Exception ex2) {
            try {
                return findProcessIdWithPS((String)string);
            }
            catch (Exception ex) {
                Log.e("TorUtils", "Unable to get proc id for command: " + URLEncoder.encode((String)string), (Throwable)ex);
                return n;
            }
        }
    }
    
    public static int findProcessIdWithPS(final String str) throws Exception {
        final int n = -1;
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
        String line;
        do {
            line = bufferedReader.readLine();
            final int int1 = n;
            if (line != null) {
                continue;
            }
            return int1;
        } while (line.indexOf(' ' + str) == -1);
        final StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        stringTokenizer.nextToken();
        return Integer.parseInt(stringTokenizer.nextToken().trim());
    }
    
    public static int findProcessIdWithPidOf(String pathname) throws Exception {
        final int n = -1;
        pathname = (String)new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "pidof", new File(pathname).getName() }).getInputStream()));
        while (true) {
            final String line = ((BufferedReader)pathname).readLine();
            int int1 = n;
            if (line == null) {
                return int1;
            }
            try {
                int1 = Integer.parseInt(line.trim());
                return int1;
            }
            catch (NumberFormatException ex) {
                Log.e("TorServiceUtils", "unable to parse process pid: " + line, (Throwable)ex);
            }
        }
    }
    
    public static boolean isRootPossible() {
        final StringBuilder sb = new StringBuilder();
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
            if (!new File("/system/app/superuser.apk").exists()) {
                if (new File("/system/bin/su").exists()) {
                    if (doShellCommand(new String[] { "su" }, sb, false, true) != 0) {
                        return false;
                    }
                }
                else {
                    if (doShellCommand(new String[] { "which su" }, sb, false, true) == 0) {
                        Log.d("TorUtils", "root exists, but not sure about permissions");
                        return true;
                    }
                    goto Label_0113;
                }
            }
        }
        catch (IOException ex) {
            Log.e("TorUtils", "Error checking for root access", (Throwable)ex);
        }
        catch (Exception ex2) {
            Log.e("TorUtils", "Error checking for root access", (Throwable)ex2);
            goto Label_0113;
        }
        return true;
    }
}
