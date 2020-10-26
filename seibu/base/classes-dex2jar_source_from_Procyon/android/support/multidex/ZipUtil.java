// 
// Decompiled by Procyon v0.5.36
// 

package android.support.multidex;

import java.io.File;
import java.util.zip.ZipException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.io.RandomAccessFile;

final class ZipUtil
{
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;
    
    static long computeCrcOfCentralDir(final RandomAccessFile randomAccessFile, final CentralDirectory centralDirectory) throws IOException {
        final CRC32 crc32 = new CRC32();
        long size = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        final int len = (int)Math.min(16384L, size);
        final byte[] b = new byte[16384];
        for (int i = randomAccessFile.read(b, 0, len); i != -1; i = randomAccessFile.read(b, 0, (int)Math.min(16384L, size))) {
            crc32.update(b, 0, i);
            size -= i;
            if (size == 0L) {
                break;
            }
        }
        return crc32.getValue();
    }
    
    static CentralDirectory findCentralDirectory(final RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long pos = randomAccessFile.length() - 22L;
        if (pos < 0L) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long n;
        if ((n = pos - 65536L) < 0L) {
            n = 0L;
        }
        final int reverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(pos);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                final CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.size = ((long)Integer.reverseBytes(randomAccessFile.readInt()) & 0xFFFFFFFFL);
                centralDirectory.offset = ((long)Integer.reverseBytes(randomAccessFile.readInt()) & 0xFFFFFFFFL);
                return centralDirectory;
            }
        } while (--pos >= n);
        throw new ZipException("End Of Central Directory signature not found");
    }
    
    static long getZipCrc(File file) throws IOException {
        file = (File)new RandomAccessFile(file, "r");
        try {
            return computeCrcOfCentralDir((RandomAccessFile)file, findCentralDirectory((RandomAccessFile)file));
        }
        finally {
            ((RandomAccessFile)file).close();
        }
    }
    
    static class CentralDirectory
    {
        long offset;
        long size;
    }
}
