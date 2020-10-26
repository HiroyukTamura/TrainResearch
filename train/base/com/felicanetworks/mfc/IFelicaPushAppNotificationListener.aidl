//
// IFelicaPushAppNotificationListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.PushNotifyAppSegment;

/**
 * Push��M�@�\�̃A�v���P�[�V�����ʒm�Ɋւ���AIDL�p���X�i�C���^�t�F�[�X�ł��B
 * <p>
 */
oneway interface IFelicaPushAppNotificationListener {
    /**
     * Push�ɂ��A�v���P�[�V�����ʒm����M�����ꍇ�ɌĂяo����܂��B<p>
     * ��M�����f�[�^�̌ʕ��p�����[�^�T�C�Y��0�̏ꍇ�A�A�v���ʒm�̌ʕ��p�����[�^���̂��ꂼ��̒l�ɂ�null���ݒ肳��܂��B
     * @param pushNotificationAppSegment �A�v���ʒm�̌ʕ��p�����[�^
     */
    void pushAppNotified(in PushNotifyAppSegment pushNotificationAppSegment);
}
