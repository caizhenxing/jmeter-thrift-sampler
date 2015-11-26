package com.yy.expe.bean;

import jodd.util.StringUtil;
import org.apache.thrift.protocol.TSimpleJSONProtocol;

/**
 * Created by zhangzongchao on 2015/11/26.
 */
public enum TProtocol {

    TBinaryProtocol("TBinary", "�����Ƹ�ʽ"), TCompactProtocol("TCompact", "ѹ����ʽ"), TJSONProtocol("TJSON", "JSON��ʽ"), TSimepleJSONProtocol("TSimpleJSON", "�ṩJSONֻдЭ��, ���ɵ��ļ�������ͨ���ű����Խ���");

    private String protocol;
    private String desc;

    private TProtocol(String protocol, String desc) {
        this.protocol = protocol;
        this.desc = desc;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static TProtocol myValueOf(String protocol){
        if (StringUtil.isNotEmpty(protocol)){
            if ("tbinary".equalsIgnoreCase(protocol)){
                return TBinaryProtocol;
            }else if("tcompact".equalsIgnoreCase(protocol)){
                return TCompactProtocol;
            }else if ("tjson".equalsIgnoreCase(protocol)){
                return TJSONProtocol;
            }else if("tsimplejson".equalsIgnoreCase(protocol)){
                return TSimepleJSONProtocol;
            }
        }
        return TBinaryProtocol;
    }
}
