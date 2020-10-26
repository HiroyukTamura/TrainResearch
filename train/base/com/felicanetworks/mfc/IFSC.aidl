//
// IFSC.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.DeviceList;
import com.felicanetworks.mfc.IFSCEventListener;
import com.felicanetworks.mfc.IFelica;
import com.felicanetworks.mfc.FelicaResultInfo;

/**
 * FSC API�����s���邽�߂�AIDL�C���^�[�t�F�[�X�ł��B
 * <p>
 */
interface IFSC {

    /**
     * FeliCa�T�[�o�Ƃ̃I�����C���������J�n���܂��B
     * <p>
     *
     * @param url FeliCa�T�[�o��URL
     * @param deviceList <code>DeviceList</code>
     * @param fscEventListener <code>FSC</code> �C�x���g���X�i
     * @param felica IFelica�u�W�F�N�g
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �w�肳�ꂽURL�� <code>null</code> �̏ꍇ
     *             <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} FeliCa�T�[�o�Ƃ̃I�����C�������̊J�n�����s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     *             <p>
     *             <table style="vertical-align: middle;" border="1" cellpadding="2" * cellspacing="2">
     *             <tbody>
     *             <tr>
     *             <th style="text-align: center;">���</th> <th
     *             style="text-align: center;">�^�C�v</th>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_FELICA_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_DEVICELIST_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_LISTENER_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_COMMUNICATION_START_FAILED}</td>
     *             </tr>
     *             </tbody>
     *             </table>
     */
    FelicaResultInfo start(String url, in DeviceList deviceList, IFSCEventListener fscEventListener, IFelica felica);

    /**
     * FeliCa�T�[�o�Ƃ̃I�����C�������𒆒f���܂��B
     * <p>
     * <code>FSC</code> ���I�����C���������ł͂Ȃ��ꍇ�A�����s���܂���B
     * <p>
     */
    void stop();

    /**
     * �f�o�C�X����v���̌��ʂ�����I���������ꍇ�ɒʒm���܂��B
     * <p>
     * @param result ���쏈������
     */
    void notifyResult(in byte[] result);

    /**
     * �f�o�C�X����v������Exception�����������ꍇ�ɒʒm���܂��B
     * <p>
     * @param msg �G���[���b�Z�[�W
     */
    void notifyError(in String msg );

}
