package com.gaojc.security.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gaojc
 * @date 2019/4/13 23:11
 */
@Data
public class UserVO implements Serializable {
    private String userName;
    private String password;
    private String userDesc;
    private List<String> roleCodes;
}
