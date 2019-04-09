package com.gaojc.serviceprovider.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 请求对象
 *
 * @author gaojc
 * @since 2019/4/9
 */
@Data
@ToString(callSuper = true)
@ApiModel("用户请求BO")
public class UserBO extends BaseBO {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String passWord;

    @ApiModelProperty(value = "用户邮箱")
    private String email;
}
