// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.IOException;

abstract class LineBuffer
{
    private StringBuilder line;
    private boolean sawReturn;
    
    LineBuffer() {
        this.line = new StringBuilder();
    }
    
    private boolean finishLine(final boolean b) throws IOException {
        final String string = this.line.toString();
        String s;
        if (this.sawReturn) {
            if (b) {
                s = "\r\n";
            }
            else {
                s = "\r";
            }
        }
        else if (b) {
            s = "\n";
        }
        else {
            s = "";
        }
        this.handleLine(string, s);
        this.line = new StringBuilder();
        this.sawReturn = false;
        return b;
    }
    
    protected void add(final char[] str, final int n, final int n2) throws IOException {
        int i = n;
        if (this.sawReturn) {
            i = n;
            if (n2 > 0) {
                final boolean b = str[n] == '\n';
                i = n;
                if (this.finishLine(b)) {
                    i = n + 1;
                }
            }
        }
        int offset = i;
        final int n3 = n + n2;
        while (i < n3) {
            int n4 = i;
            int n5 = offset;
            Label_0120: {
                switch (str[i]) {
                    default: {
                        n5 = offset;
                        n4 = i;
                        break Label_0120;
                    }
                    case '\n': {
                        this.line.append(str, offset, i - offset);
                        this.finishLine(true);
                        n5 = i + 1;
                        n4 = i;
                        break Label_0120;
                    }
                    case '\r': {
                        this.line.append(str, offset, i - offset);
                        this.sawReturn = true;
                        int n6 = i;
                        if (i + 1 < n3) {
                            final boolean b2 = str[i + 1] == '\n';
                            n6 = i;
                            if (this.finishLine(b2)) {
                                n6 = i + 1;
                            }
                        }
                        final int n7 = n6 + 1;
                        n4 = n6;
                        n5 = n7;
                    }
                    case '\u000b':
                    case '\f': {
                        i = n4 + 1;
                        offset = n5;
                        continue;
                    }
                }
            }
        }
        this.line.append(str, offset, n + n2 - offset);
    }
    
    protected void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            this.finishLine(false);
        }
    }
    
    protected abstract void handleLine(final String p0, final String p1) throws IOException;
}
