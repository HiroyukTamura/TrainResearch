//
// IFSCEventListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

/**
 * FeliCa�T�[�o�Ƃ̃I�����C�������Ɋւ���C�x���g��AIDL�p���X�i�C���^�t�F�[�X�ł��B
 * <p>
 */
oneway interface IFSCEventListener {
    /**
     * FeliCa�T�[�o�Ƃ̃I�����C�������ŃG���[�����������ꍇ�ɌĂяo����܂��B
     * <p>
     * ���̃��\�b�h�ɓn�����p�����[�^�̓��e�͈ȉ��̒ʂ�ł�:
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">����</th>
     * <th style="text-align: center;">�^�C�v</th>
     * <th style="text-align: center;">���b�Z�[�W</th>
     * </tr>
     * <tr>
     * <td>FeliCa�T�[�o����G���[���b�Z�[�W����M�����ꍇ</td>
     * <td colspan="1" rowspan="4">{@link #TYPE_PROTOCOL_ERROR}</td>
     * <td>�G���[���b�Z�[�W�̓��e</td>
     * </tr>
     * <tr>
     * <td>FeliCa�T�[�o�����M�������b�Z�[�W�̃t�H�[�}�b�g���������Ȃ��ꍇ</td>
     * <td>"Packet format error."</td>
     * </tr>
     * <tr>
     * <td>FeliCa�T�[�o�����M�������b�Z�[�W����ԂƓK�����Ȃ��ꍇ</td>
     * <td>"Illegal state error."</td>
     * </tr>
     * <tr>
     * <td>FeliCa�T�[�o�����M�����ʐM�p�����[�^���������Ȃ��ꍇ</td>
     * <td>"Communication initiation error."</td>
     * </tr>
     * <tr>
     * <td>HTTP���X�|���X�R�[�h��200�ȊO�̏ꍇ</td>
     * <td colspan="1" rowspan="4">{@link #TYPE_HTTP_ERROR}</td>
     * <td>"Invalid response code: <span style="font-style: italic;">���X�|���X�R�[�h
     * </span>"</td>
     * </tr>
     * <tr>
     * <td>HTTP���X�|���X�̃R���e���g�^�C�v���������Ȃ��ꍇ</td>
     * <td>"Invalid content-type: <span style="font-style: italic;">�R���e���g�^�C�v
     * </span>"</td>
     * </tr>
     * <tr>
     * <td>HTTP���X�|���X�̃R���e���g�^�C�v���ݒ肳��Ă��Ȃ��ꍇ</td>
     * <td>"Invalid content-type: null"</td>
     * </tr>
     * <tr>
     * <td>��L�ȊO��HTTP�ʐM�G���[�����������ꍇ</td>
     * <td>"HTTP communication error."</td>
     * </tr>
     * <tr>
     * <td>{@link FSC#stop()}�̌Ăяo���ɂ��FeliCa�T�[�o�Ƃ̃I�����C�����������f�����ꍇ</td>
     * <td colspan="1" rowspan="2">{@link #TYPE_INTERRUPTED_ERROR}</td>
     * <td colspan="1" rowspan="2">"Interrupted."</td>
     * </tr>
     * <tr>
     * <td>{@link Felica#close()}�̌Ăяo���ɂ��FeliCa�T�[�o�Ƃ̃I�����C�������������I�������ꍇ</td>
     * </tr>
     * <tr>
     * <td>{@link #operationRequested(int, String, byte[])}����O���X���[�����ꍇ</td>
     * <td colspan="1" rowspan="2">{@link #TYPE_UNKNOWN_ERROR}</td>
     * <td colspan="1" rowspan="2">�X���[���ꂽ��O�̃��b�Z�[�W</td>
     * </tr>
     * <tr>
     * <td><code>FSC</code> �����ŗ�O�����������ꍇ</td>
     * </tr>
     * </tbody> </table>
     *
     * @param type �G���[���
     * @param message �G���[���b�Z�[�W(���b�Z�[�W���Ȃ��ꍇ�� <code>null</code>)
     */
    void errorOccurred(int type, java.lang.String message);

    /**
     * FeliCa�T�[�o�Ƃ̃I�����C������������I�������ꍇ�ɌĂяo����܂��B
     * <p>
     *
     * @param status �X�e�[�^�X�R�[�h
     */
    void finished(int status);

    /**
     * FeliCa�T�[�o����f�o�C�X����v������M�����ꍇ�ɌĂяo����܂��B����Ώۂ̃f�o�C�X�̓f�o�C�XID�Ŏw�肳��܂��B
     * <p>
     * ���̃��\�b�h������Ƀ��^�[�������ꍇ�AFeliCa�T�[�o�ɂ̓f�o�C�X���쏈�����ʂ��n����A����������ɍs��ꂽ���Ƃ��ʒm����܂��B
     * ���̃��\�b�h�����O���X���[���ꂽ�ꍇ�AFeliCa�T�[�o�ɂ̓f�o�C�X���쏈��������ɍs���Ȃ��������Ƃ��ʒm����܂��B
     * <p>
     *
     * @param deviceID �f�o�C�XID
     * @param param ����p�p�����[�^(�p�����[�^���Ȃ��ꍇ�� <code>null</code>)
     * @param data ����p�f�[�^(�f�[�^���Ȃ��ꍇ�� <code>null</code>)
     * @return �f�o�C�X���쏈������
     */
    void operationRequested(int deviceID, java.lang.String param, in byte[] data);
}
