//
// IFelica.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.IFelicaEventListener;
import com.felicanetworks.mfc.IFelicaPushAppNotificationListener;
import com.felicanetworks.mfc.DataList;
import com.felicanetworks.mfc.BlockList;
import com.felicanetworks.mfc.BlockDataList;
import com.felicanetworks.mfc.PushSegment;
import com.felicanetworks.mfc.PushSegmentParcelableWrapper;
import com.felicanetworks.mfc.PrivacySettingData;
import com.felicanetworks.mfc.FelicaResultInfo;
import com.felicanetworks.mfc.FelicaResultInfoBoolean;
import com.felicanetworks.mfc.FelicaResultInfoInt;
import com.felicanetworks.mfc.FelicaResultInfoByteArray;
import com.felicanetworks.mfc.FelicaResultInfoIntArray;
import com.felicanetworks.mfc.FelicaResultInfoBlockCountInformationArray;
import com.felicanetworks.mfc.FelicaResultInfoDataArray;
import com.felicanetworks.mfc.FelicaResultInfoNodeInformation;

/**
 * FeliCa API�����s���邽�߂�AIDL�C���^�[�t�F�[�X�ł��B
 * <p>
 */
interface IFelica {

    /**
     * FeliCa�`�b�v�̗��p�J�n���������{���܂��B<p>
     * permitList�ɂ�null��ݒ肷�邱�Ƃ��\�ł��B
     * <p>
     * @param permitList ���؃��X�g
     * @param listener �������ʒʒm�p���X�i
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_SECURITY} �A�N�Z�X��������Ȃ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �������ʒʒm�p���X�i��null�̏ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} ���p�J�n���������s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_USED_BY_OTHER_APP}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ALREADY_ACTIVATED}</td>
     * </tr>
     * </tbody> </table>
     * ����ʂ�{@link FelicaException#ID_ILLEGAL_STATE_ERROR}�Ń^�C�v��{@link FelicaException#TYPE_USED_BY_OTHER_APP}�̏ꍇ��
     * {@link FelicaResultInfo#getOtherAppPID}��Felica���p���̃v���Z�XID���擾�ł��܂��B
     */
    FelicaResultInfo activateFelica(in String[] permitList , IFelicaEventListener listener);

    /**
     * FeliCa�`�b�v���N���[�Y���܂��B�`�b�v�̓d���̓I�t�ɂȂ�܂��B���ɃN���[�Y����Ă���ꍇ�͉����s���܂���B
     * <p>
     * <code>FSC</code>
     * ��FeliCa�T�[�o�Ƃ̃I�����C���������s���Ă���Ԃɂ��̃��\�b�h���Ă΂ꂽ�ꍇ�AFeliCa�T�[�o�ɉ����ʒm���邱�ƂȂ������I�����܂��B
     * <p>
     * {@link #setPushNotificationListener}�Őݒ肵��Push�A�v���ʒm���X�i�y�уA�v���P�[�V�������ʃR�[�h���N���A���܂��B
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �N���[�Y�����s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo close();

    /**
     * �w�肵���G���A�܂��̓T�[�r�X�̃u���b�N�g�p�󋵁i���蓖�ău���b�N������ы󂫃u���b�N���j��FeliCa�`�b�v����擾���܂��B
     * <p>
     * @param nodeCodeList �G���A�܂��̓T�[�r�X�̈ꗗ
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * <p>
     * @return �w�肵���G���A�܂��̓T�[�r�X�̃u���b�N�g�p��
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �G���A�܂��̓T�[�r�X�̈ꗗ�̐����K��l�͈̔͊O�ƂȂ�ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} ���蓖�ău���b�N������ы󂫃u���b�N�����擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_BLOCK_COUNT_INFORMATION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_BLOCK_COUNT_INFORMATION_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_BLOCK_COUNT_INFORMATION_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_GET_BLOCK_COUNT_INFORMATION_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
    �@    */
    FelicaResultInfoBlockCountInformationArray getBlockCountInformation(in int[] nodeCodeList, int timeout, int retry);

    /**
     * FeliCa�`�b�v����R���e�iID���擾���܂��B
     * <p>
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return �R���e�iID
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �R���e�iID�̎擾���ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_CONTAINER_ID_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoByteArray getContainerId(int timeout, int retry);

    /**
     * FeliCa�`�b�v�̃R���e�i���s�����擾���܂��B
     * <p>
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return FeliCa�`�b�v�̃R���e�i���s���
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �R���e�i���s��񂪎擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_CONTAINER_ISSUE_INFORMATION_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoByteArray getContainerIssueInformation(int timeout, int retry);

    /**
     * ���ݑI������Ă���V�X�e����IC�R�[�h���擾���܂��B
     * <p>
     * @return ���ݑI������Ă���V�X�e����IC�R�[�h
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} IC�R�[�h���擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoByteArray getICCode();

    /**
     * ���ݑI������Ă���V�X�e����IDm���擾���܂��B
     * <p>
     * @return ���ݑI������Ă���V�X�e����IDm
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} IDm���擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoByteArray getIDm();

    /**
     * FeliCa�`�b�v�̃V�X�e���I���Ŏg�p�����C���^�t�F�[�X���(�L���E����)���擾���܂��B
     * <p>
     * @return �C���^�t�F�[�X���
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">�C���^�t�F�[�X���</th>
     * <th style="text-align: center;">�萔</th>
     * </tr>
     * <tr>
     * <td>�L���C���^�t�F�[�X</td>
     * <td>{@link Felica#INTERFACE_WIRED}</td>
     * </tr>
     * <tr>
     * <td>�����C���^�t�F�[�X</td>
     * <td>{@link Felica#INTERFACE_WIRELESS}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �C���^�t�F�[�X��ʂ��擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoInt getInterface();

    /**
     * �w�肳�ꂽ�T�[�r�X�A�܂��̓G���A�̌��o�[�W�������擾���܂��B<code>0xffff</code>(�m�[�h�R�[�h�T�C�Y��4�o�C�g�̏ꍇ��<code>0xffffffff</code>)
     * ���w�肳�ꂽ�ꍇ�A���ݑI������Ă���V�X�e���̌��o�[�W������Ԃ��܂��B<p>
     * serviceCode�ɂ͋��؂Ɋ܂܂��m�[�h�R�[�h�͈̔͂��w�肷�邱�Ƃ��ł��܂��B
     * <p>
     * @param serviceCode ���o�[�W�������擾����T�[�r�X�A�G���A�R�[�h
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return �w�肳�ꂽ�T�[�r�X�A�G���A�̌��o�[�W����
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �T�[�r�X�A�G���A�R�[�h�̑����l���������Ȃ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �T�[�r�X�A�܂��̓G���A�̌��o�[�W�������擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_NODECODE}</td>
     * </tr>
     * <tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_KEY_VERSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_KEY_VERSION_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoInt getKeyVersion(int serviceCode, int timeout, int retry);

    /**
     * �w�肵���G���A�ȉ��̊K�w�̃m�[�h�̏��i�G���A�R�[�h/�G���h�T�[�r�X�R�[�h�̈ꗗ����уT�[�r�X�R�[�h�̈ꗗ�j��FeliCa�`�b�v����擾���܂��B
     * <p>
     * @param parentAreaCode �e�G���A�R�[�h
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * <p>
     * @return �w�肵���G���A�ȉ��̊K�w�̃m�[�h�̏��
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �T�[�r�X�A�G���A�R�[�h���������Ȃ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �m�[�h�̏�񂪎擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_NODE_INFORMATION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND }</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_NODE_INFORMATION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_NODE_INFORMATION_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_NODE_INFORMATION_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_GET_NODE_INFORMATION_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
     */
    FelicaResultInfoNodeInformation getNodeInformation(int parentAreaCode, int timeout, int retry);

    /**
     * �w�肵���G���A�ȉ��̊K�w�̃v���C�o�V�ݒ肪�L���ȃm�[�h�̏��i�G���A�R�[�h/�G���h�T�[�r�X�R�[�h�̈ꗗ����уT�[�r�X�R�[�h�̈ꗗ�j��FeliCa�`�b�v����擾���܂��B<p>
     * parentAreaCode�ɂ͋��؂Ɋ܂܂��m�[�h�R�[�h�͈̔͂��w�肷�邱�Ƃ��ł��܂��B
     * <p>
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @param parentAreaCode �e�G���A�R�[�h
     * <p>
     * @return �w�肵���G���A�ȉ��̊K�w�̃v���C�o�V�ݒ肪�L���ȃm�[�h�̏��
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} ���؂ɐݒ肳��Ă��Ȃ��G���A�R�[�h���w�肵���ꍇ�܂��̓G���A�R�[�h�ł͂Ȃ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �v���C�o�V�ݒ肪�L���ȃm�[�h�̏�񂪎擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_PRIVACY_NODE_INFORMATION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND }</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_GET_PRIVACY_NODE_INFORMATION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_PRIVACY_NODE_INFORMATION_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_NODECODE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_PRIVACY_NODE_INFORMATION_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_GET_PRIVACY_NODE_INFORMATION_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
     */
    FelicaResultInfoNodeInformation getPrivacyNodeInformation(int parentAreaCode, int timeout, int retry);

    /**
     * RFS�[�q�̏�Ԃ��擾���܂��B
     * <p>
     * @return RFS�[�q�̏�ԁitrue: High / false: Low�j
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} RFS�[�q�̏�Ԏ擾���ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoBoolean getRFSState();

    /**
     * ���ݑI������Ă���V�X�e���̃V�X�e���R�[�h���擾���܂��B
     * <p>
     * @return ���ݑI������Ă���V�X�e���̃V�X�e���R�[�h
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �V�X�e���R�[�h���擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoInt getSystemCode();

    /**
     * FeliCa�`�b�v����V�X�e���R�[�h�̈ꗗ���擾���܂��B
     * <p>
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return �V�X�e���R�[�h�̈ꗗ
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �V�X�e���R�[�h�̈ꗗ���擾�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_GET_SYSTEM_CODE_LIST_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfoIntArray getSystemCodeList(int timeout, int retry);

    /**
     * FeliCa�`�b�v�̗��p�I�����������{���܂��B
     * <p>
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} ���p�I�����������s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_CLOSED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo inactivateFelica();

    /**
     * FeliCa�`�b�v���I�[�v�����܂��B�`�b�v�̓d�����I���ɂȂ�܂��B ���ɃI�[�v������Ă���ꍇ�͉����s���܂���B
     * �I�[�v������̃m�[�h�R�[�h�T�C�Y��2�o�C�g�i{@link #NODECODESIZE_2}�j�ł��B
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �I�[�v�������s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_OPEN_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_OPEN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_IC_CHIP_FORMATTING}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_OPEN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_FELICA_NOT_AVAILABLE}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo open();

    /**
     * Push�ɂ��f�[�^���M�������s���܂��B
     * <p>
     * @param timeout �^�C���A�E�g�l
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} ���M�f�[�^��̃T�C�Y��192byte�𒴂����ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} ���M�Ɏ��s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_PUSH_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo push(in PushSegmentParcelableWrapper pushSegmentParcelableWrapper);

    /**
     * �w�肳�ꂽ�u���b�N���X�g���g�p���ău���b�N�f�[�^��ǂݍ��݂܂��B<p>
     * blockList�ɂ͋��؂Ɋ܂܂��m�[�h�R�[�h�͈̔͂��w�肷�邱�Ƃ��ł��܂��B
     * <p>
     * @param blockList �ǂݍ��݂Ɏg�p����u���b�N���X�g
     * @param timeout �^�C���A�E�g�l(��)
     * @param retry ���g���C��
     * @return �w�肳�ꂽ�u���b�N���X�g�ɑΉ�����u���b�N�f�[�^�̃��X�g
     * <p>
     * ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �u���b�N���X�g�� <code>null</code> �A�܂��͋�̏ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �u���b�N�f�[�^���ǂݍ��߂Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_NODECODE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_READ_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_READ_ERROR}</td>
     * <td>{@link FelicaException#TYPE_BLOCK_NOT_FOUND}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_READ_ERROR}</td>
     * <td>{@link FelicaException#TYPE_PIN_NOT_CHECKED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_READ_ERROR}</td>
     * <td>{@link FelicaException#TYPE_READ_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_READ_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_READ_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
     * <p>
     * �������C���^�t�F�[�X�I�����A��ʂ�{@link FelicaException#ID_READ_ERROR}�̏ꍇ�́A
     * �^�C�v��{@link FelicaException#TYPE_READ_FAILED}�Œ�ƂȂ�܂��B
     */
    FelicaResultInfoDataArray read(in BlockList blockList,in int timeout,in int retry);

    /**
     * FeliCa�`�b�v���\�t�g�E�F�A���Z�b�g���܂��B
     * �����g���o�Ă��鎞�͒�~���܂��B
     * �V�X�e�������I���ɂȂ�܂��B
     * �m�[�h�R�[�h�T�C�Y��2�o�C�g�i{@link #NODECODESIZE_2}�j�ɖ߂�܂��B
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} FeliCa�`�b�v�̃��Z�b�g�����s�����ꍇ
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_RESET_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo reset();

    /**
     * �L���C���^�t�F�[�X���g�p����FeliCa�`�b�v��̃V�X�e����I�����܂��B
     * <p>
     * �V�X�e���R�[�h�ɂ̓��C���h�J�[�h( <code>0xffff, 0x00ff, 0xff00</code> )���w�肷�邱�Ƃ��ł��܂��B
     *
     * @param systemCode �V�X�e���R�[�h
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �V�X�e���R�[�h���͈͊O�̏ꍇ(
     *             <code>systemCode < 0x0000 || systemCode > 0xffff</code>)
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} FeliCa�`�b�v��̃V�X�e����I���ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SELECT_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo select(int systemCode);

    /**
     * �w�肵���C���^�t�F�[�X���g�p����FeliCa�`�b�v��̃V�X�e����I�����܂��B
     * <p>
     * �V�X�e���R�[�h�ɂ̓��C���h�J�[�h( <code>0xffff, 0x00ff, 0xff00</code> )���w�肷�邱�Ƃ��ł��܂��B
     * <p>
     * @param target �C���^�t�F�[�X���
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">�C���^�t�F�[�X���</th>
     * <th style="text-align: center;">�萔</th>
     * </tr>
     * <tr>
     * <td>�L���C���^�t�F�[�X</td>
     * <td>{@link #INTERFACE_WIRED}</td>
     * </tr>
     * <tr>
     * <td>�����C���^�t�F�[�X</td>
     * <td>{@link #INTERFACE_WIRELESS}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * @param systemCode �V�X�e���R�[�h
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �V�X�e���R�[�h���͈͊O�̏ꍇ(
     *             <code>systemCode < 0x0000 || systemCode > 0xffff</code>)�A
     *             �܂���target��{@link #INTERFACE_WIRED}�A
     *             {@link #INTERFACE_WIRELESS}�̂�����ł��Ȃ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} FeliCa�`�b�v��̃V�X�e����I���ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SELECT_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo selectWithTarget(int target, int systemCode);

    /**
     * CEN�[�q�𐧌䂵�܂��B
     * FeliCa�`�b�v�N���[�Y��Ԃ̂ݎ��s�\�ł��B
     * <p>
     * @param state CEN�[�q�ɐݒ肷���ԁitrue: High / false: Low�j
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} CEN�[�q�̐��䂪�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_CLOSED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * </tbody> </table>
     */
//    FelicaResultInfo setCENState(boolean state);

    /**
     * �m�[�h�̃v���C�o�V�ݒ��ύX���܂��B
     * <p>
     * @param privacySettingData �m�[�h�̃v���C�o�V�ݒ�̈ꗗ
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * <p>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �m�[�h�̐����K��l�͈̔͊O�ƂȂ�ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �v���C�o�V���ݒ�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_SET_PRIVACY_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND }</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_SET_PRIVACY_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SET_PRIVACY_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_METHOD_CALL}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SET_PRIVACY_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_SET_PRIVACY_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
     */
    FelicaResultInfo setPrivacy(in PrivacySettingData[] privacySettingData, int timeout, int retry);

    /**
     * �w�肳�ꂽ�u���b�N�f�[�^���X�g���g�p���ău���b�N�f�[�^���������݂܂��B<p>
     * blockDataList�ɂ͋��؂Ɋ܂܂��m�[�h�R�[�h�͈̔͂��w�肷�邱�Ƃ��ł��܂��B
     * <p>
     * @param blockDataList �������݂Ɏg�p����u���b�N�f�[�^���X�g
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �u���b�N�f�[�^���X�g�� <code>null</code> �A�܂��͋�̏ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �u���b�N�f�[�^���������߂Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_PERMISSION_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ILLEGAL_NODECODE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_PURSE_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CASH_BACK_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_PIN}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CHECK_PIN_LIMIT}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CHECK_PIN_OVERRUN}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SERVICE_NOT_FOUND}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_BLOCK_NOT_FOUND}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_PIN_NOT_CHECKED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ENABLE_PIN_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_WRITE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_WRITE_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_WRITE_FAILED}</td>
     * </tr>
     * </tbody> </table>
     * <p>
     * ����ʂ�{@link FelicaException#ID_WRITE_ERROR}�̏ꍇ��
     * �X�e�[�^�X�t���O���`�F�b�N���邱�Ƃɂ��G���[�ڍׂ��擾�ł��܂��B
     * <p>
     * �������C���^�t�F�[�X�I�����A��ʂ�{@link FelicaException#ID_WRITE_ERROR}�̏ꍇ�́A
     * �^�C�v��{@link FelicaException#TYPE_WRITE_FAILED}�Œ�ƂȂ�܂��B
     */
    FelicaResultInfo write(in BlockDataList blockDataList, int timeout, int retry);

    /**
     * Push��M�ɂ��A�v���P�[�V�����ʒm�̃��X�i��ݒ肵�܂��B
     * <p>
     * ��M�����f�[�^�̃A�v���P�[�V�������ʃR�[�h�Ɛݒ肵���A�v���P�[�V�������ʃR�[�h���قȂ�ꍇ�A�ʒm�͍s���܂���B<p>
     * Push�A�v���ʒm���X�i��null���w�肵���ꍇ�A���X�i�͉�������܂��B
     * @param listener Push�A�v���ʒm���X�i
     * @param appIdentificationCode �A�v���P�[�V�������ʃR�[�h
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} Push�A�v���ʒm���X�i��null���A�A�v���P�[�V�������ʃR�[�h��null�łȂ��ꍇ
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} ���X�i�o�^�Ɏ��s�����ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo setPushNotificationListener(IFelicaPushAppNotificationListener listener, String appIdentificationCode);

    /**
     * FeliCa�`�b�v�ɃA�N�Z�X����ۂ̃m�[�h�R�[�h(�T�[�r�X�A�G���A�R�[�h)�T�C�Y��ݒ肵�܂��B
     * <p>
     * @param nodeCodeSize �ݒ肷��m�[�h�R�[�h�T�C�Y
     * @param timeout �^�C���A�E�g�l
     * @param retry ���g���C��
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">�m�[�h�R�[�h�T�C�Y</th>
     * <th style="text-align: center;">�萔</th>
     * </tr>
     * <tr>
     * <td>2�o�C�g</td>
     * <td>{@link #NODECODESIZE_2}</td>
     * </tr>
     * <tr>
     * <td>4�o�C�g</td>
     * <td>{@link #NODECODESIZE_4}</td>
     * </tr>
     * </tbody> </table>
     * @return ��O�������A�ȉ��̗�O����Ԃ��܂��B��O��ʂ�{@link ResultInfo#getExceptionType}�Ŏ擾���܂��B
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} �m�[�h�R�[�h�T�C�Y���s���ȏꍇ(
     *             {@link #NODECODESIZE_2}�A{@link #NODECODESIZE_4}�̂�����ł��Ȃ��ꍇ)
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} �m�[�h�R�[�h�T�C�Y���ݒ�ł��Ȃ��ꍇ�i�ڍׂ͉��\���Q�Ɓj
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_SELECTED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_INVALID_RESPONSE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_IO_ERROR}</td>
     * <td>{@link FelicaException#TYPE_TIMEOUT_OCCURRED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_SET_NODECODESIZE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SET_NODECODESIZE_FAILED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_SET_NODECODESIZE_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo setNodeCodeSize(int nodeCodeSize, int timeout, int retry);

    /**
     * �I�����C�������̎��s���\���ǂ����̃`�F�b�N���s���܂�
     * <p>
     * @throws FelicaException
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo checkOnlineAccess();

    /**
     * select�Ŏg�p�����^�C���A�E�g�l��ݒ肵�܂��B
     *
     * @param timeout �ݒ肷��^�C���A�E�g�l(�~���b)
     * @throws FelicaException <code>Felica</code> ���g�p���Ă���A�v���ƁA���݂̃R���e�L�X�g�̃A�v���Ԃ�UID/PID���قȂ�.
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * </tbody> </table>
     */
    FelicaResultInfo setSelectTimeout(int timeout);
    
    /**
     * select�Ŏg�p�����^�C���A�E�g�l���擾���܂��B
     *
     * @return timeout �ݒ肷��^�C���A�E�g�l(�~���b)
     * @throws FelicaException <code>Felica</code> ���g�p���Ă���A�v���ƁA���݂̃R���e�L�X�g�̃A�v���Ԃ�UID/PID���قȂ�.
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_ACTIVATED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     * <td>{@link FelicaException#TYPE_REMOTE_ACCESS_FAILED}</td>
     * </tr>
     * </tbody> </table>
     */
   FelicaResultInfoInt getSelectTimeout();
    
    /**
     * �I�t���C���@�\�𒆒f���܂��B
     *
     * @throws FelicaException�@���f�\��ԂłȂ��ꍇ
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">���</th>
     * <th style="text-align: center;">�^�C�v</th>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     * </tr>
     * <tr>
     * <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     * <td>{@link FelicaException#TYPE_ACTIVATING_FALP}</td>
     * </tr>
     * </tbody> </table>
     */
	FelicaResultInfo cancelOffline();

}
