//
// IFelicaEventListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.AppInfo;

/**
 * FeliCa�`�b�v���p�J�n�����Ɋւ���C�x���g��AIDL�p���X�i�C���^�t�F�[�X�ł��B
 * <p>
 */
oneway interface IFelicaEventListener {
    /**
     * FeliCa�`�b�v���p�J�n����������I�������ꍇ�ɌĂяo����܂��B<br>
     * �ڍׂ͈ȉ����Q��<br>
     * @see com.felicanetworks.mfc.FelicaEventListener#finished(()
     */
    void finished();

    /**
     * FeliCa�`�b�v���p�J�n�����ŃG���[�����������ꍇ�ɌĂяo����܂��B
     * �ڍׂ͈ȉ����Q��<br>
     * @see com.felicanetworks.mfc.FelicaEventListener#errorOccurred(int, java.lang.String, com.felicanetworks.mfc.AppInfo)
     */
    void errorOccurred(int id, in String msg, in AppInfo otherAppInfo);
}
