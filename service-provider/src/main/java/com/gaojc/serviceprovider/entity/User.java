package com.gaojc.serviceprovider.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * User 实体类
 * </p>
 *
 * @author gaojc
 * @since 2018-11-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String passWord;

    private String email;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
