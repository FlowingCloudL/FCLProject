package com.fp.common.core.util;

public class IdUtil {

    private final static SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(0, 0);

    public static String getId(){
        return String.valueOf(idGenerator.nextId());
    }

    public static Long getLongID() {
        return idGenerator.nextId();
    }

    public static String getStringID(){
        return String.valueOf(idGenerator.nextId());
    }

}
