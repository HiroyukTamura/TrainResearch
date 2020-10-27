package com.google.firebase.crashlytics.internal.proto;

import android.app.ActivityManager;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.List;
import java.util.Map;

public class SessionProtobufHelper {
    private static final String SIGNAL_DEFAULT = "0";
    private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
    private static final ByteString UNITY_PLATFORM_BYTE_STRING = ByteString.copyFromUtf8("Unity");

    private SessionProtobufHelper() {
    }

    private static int getBinaryImageSize(ByteString byteString, ByteString byteString2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(3, byteString) + CodedOutputStream.computeUInt64Size(2, 0) + CodedOutputStream.computeUInt64Size(1, 0) + 0;
        return byteString2 != null ? computeBytesSize + CodedOutputStream.computeBytesSize(4, byteString2) : computeBytesSize;
    }

    private static int getEventAppCustomAttributeSize(String str, String str2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(str));
        if (str2 == null) {
            str2 = "";
        }
        return CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str2)) + computeBytesSize;
    }

    private static int getEventAppExecutionExceptionSize(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(trimmedThrowableData.className)) + 0;
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(str));
        }
        for (StackTraceElement frameSize : trimmedThrowableData.stacktrace) {
            int frameSize2 = getFrameSize(frameSize, true);
            computeBytesSize += CodedOutputStream.computeRawVarint32Size(frameSize2) + CodedOutputStream.computeTagSize(4) + frameSize2;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return computeBytesSize;
        }
        if (i < i2) {
            int eventAppExecutionExceptionSize = getEventAppExecutionExceptionSize(trimmedThrowableData2, i + 1, i2);
            return computeBytesSize + CodedOutputStream.computeRawVarint32Size(eventAppExecutionExceptionSize) + CodedOutputStream.computeTagSize(6) + eventAppExecutionExceptionSize;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i3++;
        }
        return computeBytesSize + CodedOutputStream.computeUInt32Size(7, i3);
    }

    private static int getEventAppExecutionSignalSize() {
        return CodedOutputStream.computeUInt64Size(3, 0) + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + 0;
    }

    private static int getEventAppExecutionSize(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) {
        int threadSize = getThreadSize(thread, stackTraceElementArr, 4, true);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(threadSize) + CodedOutputStream.computeTagSize(1) + threadSize + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int threadSize2 = getThreadSize(threadArr[i2], list.get(i2), 0, false);
            computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(threadSize2) + CodedOutputStream.computeTagSize(1) + threadSize2;
        }
        int eventAppExecutionExceptionSize = getEventAppExecutionExceptionSize(trimmedThrowableData, 1, i);
        int computeTagSize = CodedOutputStream.computeTagSize(2);
        int eventAppExecutionSignalSize = getEventAppExecutionSignalSize();
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(eventAppExecutionSignalSize) + CodedOutputStream.computeTagSize(3) + eventAppExecutionSignalSize + CodedOutputStream.computeRawVarint32Size(eventAppExecutionExceptionSize) + computeTagSize + eventAppExecutionExceptionSize + computeRawVarint32Size;
        int binaryImageSize = getBinaryImageSize(byteString, byteString2);
        return CodedOutputStream.computeRawVarint32Size(binaryImageSize) + CodedOutputStream.computeTagSize(3) + binaryImageSize + computeRawVarint32Size2;
    }

    private static int getEventAppSize(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int eventAppExecutionSize = getEventAppExecutionSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        boolean z = true;
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(eventAppExecutionSize) + CodedOutputStream.computeTagSize(1) + eventAppExecutionSize + 0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int eventAppCustomAttributeSize = getEventAppCustomAttributeSize((String) next.getKey(), (String) next.getValue());
                computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(eventAppCustomAttributeSize) + CodedOutputStream.computeTagSize(2) + eventAppCustomAttributeSize;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance == 100) {
                z = false;
            }
            computeRawVarint32Size += CodedOutputStream.computeBoolSize(3, z);
        }
        return CodedOutputStream.computeUInt32Size(4, i2) + computeRawVarint32Size;
    }

    private static int getEventDeviceSize(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.computeFloatSize(1, f.floatValue());
        }
        return CodedOutputStream.computeUInt64Size(6, j2) + CodedOutputStream.computeUInt64Size(5, j) + CodedOutputStream.computeUInt32Size(4, i2) + CodedOutputStream.computeBoolSize(3, z) + CodedOutputStream.computeSInt32Size(2, i) + i3;
    }

    private static int getEventLogSize(ByteString byteString) {
        return CodedOutputStream.computeBytesSize(1, byteString);
    }

    private static int getFrameSize(StackTraceElement stackTraceElement, boolean z) {
        int i = 0;
        long max = stackTraceElement.isNativeMethod() ? (long) Math.max(stackTraceElement.getLineNumber(), 0) : 0;
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + CodedOutputStream.computeUInt64Size(1, max) + 0;
        if (stackTraceElement.getFileName() != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            computeBytesSize += CodedOutputStream.computeUInt64Size(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i = 2;
        }
        return CodedOutputStream.computeUInt32Size(5, i) + computeBytesSize;
    }

    private static int getSessionAppSize(ByteString byteString, ByteString byteString2, ByteString byteString3, ByteString byteString4, int i, ByteString byteString5) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(6, byteString4) + CodedOutputStream.computeBytesSize(3, byteString3) + CodedOutputStream.computeBytesSize(2, byteString2) + CodedOutputStream.computeBytesSize(1, byteString) + 0;
        if (byteString5 != null) {
            computeBytesSize = CodedOutputStream.computeBytesSize(9, byteString5) + CodedOutputStream.computeBytesSize(8, UNITY_PLATFORM_BYTE_STRING) + computeBytesSize;
        }
        return CodedOutputStream.computeEnumSize(10, i) + computeBytesSize;
    }

    private static int getSessionDeviceSize(int i, ByteString byteString, int i2, long j, long j2, boolean z, int i3, ByteString byteString2, ByteString byteString3) {
        int i4 = 0;
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(12, i3) + CodedOutputStream.computeBoolSize(10, z) + CodedOutputStream.computeUInt64Size(7, j2) + CodedOutputStream.computeUInt64Size(6, j) + CodedOutputStream.computeUInt32Size(5, i2) + CodedOutputStream.computeEnumSize(3, i) + 0 + (byteString == null ? 0 : CodedOutputStream.computeBytesSize(4, byteString)) + (byteString2 == null ? 0 : CodedOutputStream.computeBytesSize(13, byteString2));
        if (byteString3 != null) {
            i4 = CodedOutputStream.computeBytesSize(14, byteString3);
        }
        return computeUInt32Size + i4;
    }

    private static int getSessionEventSize(long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, ByteString byteString, ByteString byteString2, Float f, int i3, boolean z, long j2, long j3, ByteString byteString3) {
        long j4 = j;
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str)) + CodedOutputStream.computeUInt64Size(1, j) + 0;
        int eventAppSize = getEventAppSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(eventAppSize) + CodedOutputStream.computeTagSize(3) + eventAppSize + computeBytesSize;
        int eventDeviceSize = getEventDeviceSize(f, i3, z, i2, j2, j3);
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(eventDeviceSize) + CodedOutputStream.computeTagSize(5) + eventDeviceSize + computeRawVarint32Size;
        if (byteString3 == null) {
            return computeRawVarint32Size2;
        }
        int eventLogSize = getEventLogSize(byteString3);
        return computeRawVarint32Size2 + CodedOutputStream.computeRawVarint32Size(eventLogSize) + CodedOutputStream.computeTagSize(6) + eventLogSize;
    }

    private static int getSessionOSSize(ByteString byteString, ByteString byteString2, boolean z) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, byteString);
        return CodedOutputStream.computeBoolSize(4, z) + CodedOutputStream.computeBytesSize(3, byteString2) + computeBytesSize + CodedOutputStream.computeEnumSize(1, 3) + 0;
    }

    private static int getThreadSize(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(2, i) + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(thread.getName()));
        for (StackTraceElement frameSize : stackTraceElementArr) {
            int frameSize2 = getFrameSize(frameSize, z);
            computeUInt32Size += CodedOutputStream.computeRawVarint32Size(frameSize2) + CodedOutputStream.computeTagSize(3) + frameSize2;
        }
        return computeUInt32Size;
    }

    private static ByteString stringToByteString(String str) {
        if (str == null) {
            return null;
        }
        return ByteString.copyFromUtf8(str);
    }

    public static void writeBeginSession(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(str2));
        codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
        codedOutputStream.writeUInt64(3, j);
    }

    private static void writeFrame(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeRawVarint32(getFrameSize(stackTraceElement, z));
        int i2 = 0;
        codedOutputStream.writeUInt64(1, stackTraceElement.isNativeMethod() ? (long) Math.max(stackTraceElement.getLineNumber(), 0) : 0);
        codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.writeUInt64(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 4;
        }
        codedOutputStream.writeUInt32(5, i2);
    }

    public static void writeSessionApp(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, int i, String str5) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString copyFromUtf82 = ByteString.copyFromUtf8(str2);
        ByteString copyFromUtf83 = ByteString.copyFromUtf8(str3);
        ByteString copyFromUtf84 = ByteString.copyFromUtf8(str4);
        ByteString copyFromUtf85 = str5 != null ? ByteString.copyFromUtf8(str5) : null;
        codedOutputStream.writeTag(7, 2);
        codedOutputStream.writeRawVarint32(getSessionAppSize(copyFromUtf8, copyFromUtf82, copyFromUtf83, copyFromUtf84, i, copyFromUtf85));
        codedOutputStream.writeBytes(1, copyFromUtf8);
        codedOutputStream.writeBytes(2, copyFromUtf82);
        codedOutputStream.writeBytes(3, copyFromUtf83);
        codedOutputStream.writeBytes(6, copyFromUtf84);
        if (copyFromUtf85 != null) {
            codedOutputStream.writeBytes(8, UNITY_PLATFORM_BYTE_STRING);
            codedOutputStream.writeBytes(9, copyFromUtf85);
        }
        codedOutputStream.writeEnum(10, i);
    }

    public static void writeSessionAppClsId(CodedOutputStream codedOutputStream, String str) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        codedOutputStream.writeTag(7, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, copyFromUtf8);
        codedOutputStream.writeRawVarint32(CodedOutputStream.computeRawVarint32Size(computeBytesSize) + CodedOutputStream.computeTagSize(5) + computeBytesSize);
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(2, copyFromUtf8);
    }

    public static void writeSessionDevice(CodedOutputStream codedOutputStream, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) throws Exception {
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        ByteString stringToByteString = stringToByteString(str);
        ByteString stringToByteString2 = stringToByteString(str3);
        ByteString stringToByteString3 = stringToByteString(str2);
        codedOutputStream.writeTag(9, 2);
        codedOutputStream.writeRawVarint32(getSessionDeviceSize(i, stringToByteString, i2, j, j2, z, i3, stringToByteString3, stringToByteString2));
        codedOutputStream.writeEnum(3, i);
        codedOutputStream.writeBytes(4, stringToByteString);
        codedOutputStream.writeUInt32(5, i2);
        codedOutputStream.writeUInt64(6, j);
        codedOutputStream.writeUInt64(7, j2);
        codedOutputStream.writeBool(10, z);
        codedOutputStream.writeUInt32(12, i3);
        if (stringToByteString3 != null) {
            codedOutputStream.writeBytes(13, stringToByteString3);
        }
        if (stringToByteString2 != null) {
            codedOutputStream.writeBytes(14, stringToByteString2);
        }
    }

    public static void writeSessionEvent(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f, int i3, boolean z, long j2, long j3) throws Exception {
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        String str4 = str3;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str2);
        ByteString byteString = null;
        ByteString copyFromUtf82 = str4 == null ? null : ByteString.copyFromUtf8(str4.replace("-", ""));
        if (bArr != null) {
            byteString = ByteString.copyFrom(bArr);
        } else {
            Logger.getLogger().mo25712d("No log data to include with this event.");
        }
        ByteString byteString2 = byteString;
        codedOutputStream2.writeTag(10, 2);
        codedOutputStream2.writeRawVarint32(getSessionEventSize(j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, map, runningAppProcessInfo, i2, copyFromUtf8, copyFromUtf82, f, i3, z, j2, j3, byteString2));
        codedOutputStream2.writeUInt64(1, j);
        codedOutputStream2.writeBytes(2, ByteString.copyFromUtf8(str));
        writeSessionEventApp(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, copyFromUtf8, copyFromUtf82, map, runningAppProcessInfo, i2);
        writeSessionEventDevice(codedOutputStream, f, i3, z, i2, j2, j3);
        writeSessionEventLog(codedOutputStream2, byteString2);
    }

    private static void writeSessionEventApp(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(getEventAppSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2));
        writeSessionEventAppExecution(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        if (map != null && !map.isEmpty()) {
            writeSessionEventAppCustomAttributes(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.writeBool(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.writeUInt32(4, i2);
    }

    private static void writeSessionEventAppCustomAttributes(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Map.Entry next : map.entrySet()) {
            codedOutputStream.writeTag(2, 2);
            codedOutputStream.writeRawVarint32(getEventAppCustomAttributeSize((String) next.getKey(), (String) next.getValue()));
            codedOutputStream.writeBytes(1, ByteString.copyFromUtf8((String) next.getKey()));
            String str = (String) next.getValue();
            if (str == null) {
                str = "";
            }
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
        }
    }

    private static void writeSessionEventAppExecution(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) throws Exception {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2));
        writeThread(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            writeThread(codedOutputStream, threadArr[i2], list.get(i2), 0, false);
        }
        writeSessionEventAppExecutionException(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionSignalSize());
        codedOutputStream.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
        codedOutputStream.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
        codedOutputStream.writeUInt64(3, 0);
        codedOutputStream.writeTag(4, 2);
        codedOutputStream.writeRawVarint32(getBinaryImageSize(byteString, byteString2));
        codedOutputStream.writeUInt64(1, 0);
        codedOutputStream.writeUInt64(2, 0);
        codedOutputStream.writeBytes(3, byteString);
        if (byteString2 != null) {
            codedOutputStream.writeBytes(4, byteString2);
        }
    }

    private static void writeSessionEventAppExecutionException(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        codedOutputStream.writeTag(i3, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionExceptionSize(trimmedThrowableData, 1, i2));
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(trimmedThrowableData.className));
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(str));
        }
        int i4 = 0;
        for (StackTraceElement writeFrame : trimmedThrowableData.stacktrace) {
            writeFrame(codedOutputStream, 4, writeFrame, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return;
        }
        if (i < i2) {
            writeSessionEventAppExecutionException(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
            return;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i4++;
        }
        codedOutputStream.writeUInt32(7, i4);
    }

    private static void writeSessionEventDevice(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(getEventDeviceSize(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.writeFloat(1, f.floatValue());
        }
        codedOutputStream.writeSInt32(2, i);
        codedOutputStream.writeBool(3, z);
        codedOutputStream.writeUInt32(4, i2);
        codedOutputStream.writeUInt64(5, j);
        codedOutputStream.writeUInt64(6, j2);
    }

    private static void writeSessionEventLog(CodedOutputStream codedOutputStream, ByteString byteString) throws Exception {
        if (byteString != null) {
            codedOutputStream.writeTag(6, 2);
            codedOutputStream.writeRawVarint32(getEventLogSize(byteString));
            codedOutputStream.writeBytes(1, byteString);
        }
    }

    public static void writeSessionOS(CodedOutputStream codedOutputStream, String str, String str2, boolean z) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString copyFromUtf82 = ByteString.copyFromUtf8(str2);
        codedOutputStream.writeTag(8, 2);
        codedOutputStream.writeRawVarint32(getSessionOSSize(copyFromUtf8, copyFromUtf82, z));
        codedOutputStream.writeEnum(1, 3);
        codedOutputStream.writeBytes(2, copyFromUtf8);
        codedOutputStream.writeBytes(3, copyFromUtf82);
        codedOutputStream.writeBool(4, z);
    }

    public static void writeSessionUser(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString stringToByteString = stringToByteString(str2);
        ByteString stringToByteString2 = stringToByteString(str3);
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, copyFromUtf8) + 0;
        if (str2 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, stringToByteString);
        }
        if (str3 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, stringToByteString2);
        }
        codedOutputStream.writeTag(6, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(1, copyFromUtf8);
        if (str2 != null) {
            codedOutputStream.writeBytes(2, stringToByteString);
        }
        if (str3 != null) {
            codedOutputStream.writeBytes(3, stringToByteString2);
        }
    }

    private static void writeThread(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(getThreadSize(thread, stackTraceElementArr, i, z));
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(thread.getName()));
        codedOutputStream.writeUInt32(2, i);
        for (StackTraceElement writeFrame : stackTraceElementArr) {
            writeFrame(codedOutputStream, 3, writeFrame, z);
        }
    }
}
