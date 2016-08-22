package com.tunnel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jbelligund001 on 8/2/2016.
 */
@Getter
@AllArgsConstructor
public class AuthVo {

    private final String userId;

    private final byte[] pwd;
}
