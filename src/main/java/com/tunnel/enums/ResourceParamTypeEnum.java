package com.tunnel.enums;

import lombok.Getter;

/**
 * List of resource types
 */
public enum ResourceParamTypeEnum {
    SPARK_CONFIG("sparkConf", 'M'), PACKAGE("pkgs", 'L'), SUPPORTING_PY_RES("supPy", 'L'),
    SUPPORTING_JAR_RES("supJars", 'L'), APP_ARGS("appArgs", 'L'), SPARK_ARGS("sparkArgs", 'L'),
    NOT_APPLICABLE("NA", 'F');

    @Getter
    private String code;

    //defines the data type. L - List type, M - Map type,F - Flat type
    @Getter
    private char type;


    ResourceParamTypeEnum(String code, char type) {
        this.code = code;
        this.type = type;
    }

    public static ResourceParamTypeEnum from(final String code) {
        for (ResourceParamTypeEnum aVal : ResourceParamTypeEnum.values()) {
            if (aVal.code.equalsIgnoreCase(code)) {
                return aVal;
            }
        }
        return NOT_APPLICABLE;
    }

    public boolean isListType() {
        return this.type == 'L';
    }

    public boolean isMapType() {
        return this.type == 'M';
    }
}