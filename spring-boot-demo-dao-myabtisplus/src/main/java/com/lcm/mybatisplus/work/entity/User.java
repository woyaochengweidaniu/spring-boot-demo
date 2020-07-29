package com.lcm.mybatisplus.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcm
 * @since 2019-07-18
 */
@ApiModel(value = "用户模型",description = "用户模型")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id",value = "主键id",position = 0)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "userName",value = "用户姓名",position = 1)
    private String userName;

    @ApiModelProperty(name = "age",value = "年龄",position = 2)
    private Integer age;

    @ApiModelProperty(name = "sex",value = "性别",position = 3)
    private String sex;

    @ApiModelProperty(name = "address",value = "地址",position = 4)
    private String address;

    @ApiModelProperty(name = "phone",value = "手机号",position = 5)
    private String phone;

    @ApiModelProperty(name = "hobby",value = "兴趣",position = 6)
    private String hobby;

    @ApiModelProperty(name = "birthday",value = "生日",position = 7)
    private LocalDate birthday;

    @ApiModelProperty(name = "createTime",value = "创建时间",position = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = INSERT )
    private LocalDateTime createTime;

    @ApiModelProperty(name = "updateTime",value = "修改时间",position = 9)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(name = "isDelete",value = "是否删除",position = 10)
    @TableLogic
    private Integer isDelete;


}
