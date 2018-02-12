/**
 * Created by huzhihui on 2016/4/17.
 */
//var URL_HEAD = 'http://192.168.2.115:8080/xhupubmed.server/admin/';
var URL_HEAD = 'http://192.168.31.219:8080/xhupubmed.server/admin/';
var server_url = {
    'informationPush':{
        'doInsert': URL_HEAD + 'informationPush/doInsert',/**/
        'selectByAttributeAnd': URL_HEAD + 'informationPush/selectByAttributeAnd',
        'doDelete':URL_HEAD + 'informationPush/doDelete',
        'selectByPrimaryKey':URL_HEAD + 'informationPush/selectByPrimaryKey'
    },
    'schoolProfile':{/*考研学校增加*/
        'doInsert': URL_HEAD + 'schoolProfile/doInsert',
        'selectByAttributeAnd':URL_HEAD + 'schoolProfile/selectByAttributeAnd',
        'selectByPrimaryKey':URL_HEAD + 'schoolProfile/selectByPrimaryKey',
        'doUpdate':URL_HEAD + 'schoolProfile/doUpdate'
    },
    'schoolInformation':{
        'doInsert': URL_HEAD + 'schoolInformation/doInsert',
        'selectByAttributeAnd':URL_HEAD + 'schoolInformation/selectByAttributeAnd',
        'selectByPrimaryKey':URL_HEAD + 'schoolInformation/selectByPrimaryKey',
        'doUpdate':URL_HEAD + 'schoolInformation/doUpdate'
    },
    'post':{
        'selectByAttributeAnd':URL_HEAD +'post/selectByAttribute',
        'selectByPrimaryKey':URL_HEAD +'post/selectByPrimaryKey',
        'doDelete':URL_HEAD + 'post/doDelete'
    },
    'replies':{
        'selectByAttributeAnd':URL_HEAD +'replies/selectByAttribute',
        'selectByPrimaryKey':URL_HEAD +'replies/selectByPrimaryKey',
        'doDelete':URL_HEAD + 'replies/doDelete'
    },
    'sysUser':{
        'selectByAttributeAnd':URL_HEAD +'sysUser/selectByAttributeAnd',
        'selectByPrimaryKey':URL_HEAD +'sysUser/selectByPrimaryKey',
        'doDelete':URL_HEAD + 'sysUser/doDelete',
        'doUpdate':URL_HEAD + 'sysUser/doUpdateByPrimaryKeySelective',
        'doLogin':URL_HEAD + 'sysUser/doLogin',
        'selectMydata':URL_HEAD + 'sysUser/selectMydata',
        'doInsert':URL_HEAD +'sysUser/doInsert',
        'doLoginOut':URL_HEAD +'sysUser/doLoginOut'
    },
    'keyLog':{
        'selectByAttributeAnd':URL_HEAD +'keyLog/selectByAttributeAnd',
        'doDelete':URL_HEAD + 'keyLog/doDelete',
        'selectByPrimaryKey':URL_HEAD + 'keyLog/selectByPrimaryKey'
    },
    'dataSharing':{
        'doInsert':URL_HEAD +'dataSharing/doInsert',
        'selectByAttributeAnd':URL_HEAD +'dataSharing/selectByAttributeAnd',
        'doDelete':URL_HEAD + 'dataSharing/doDelete',
        'doUpdate':URL_HEAD + 'dataSharing/doUpdate',
        'selectByPrimaryKey':URL_HEAD + 'dataSharing/selectByPrimaryKey'
    },
    'publicData':{
        'selectBaseInfo':URL_HEAD + 'publicData/selectBaseInfo'
    }
};