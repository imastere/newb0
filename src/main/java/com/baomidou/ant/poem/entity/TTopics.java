package com.baomidou.ant.poem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-05-02
 */
@Data
@Accessors(chain = true)
public class TTopics {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String owner;
    @NotBlank
    private String title;

    private String avatar;

    private String cover;

    private int status;

    private Integer percent;

    private String logo;

    private String href;

    @TableField("updateAt")
    private String updateAt;

    @TableField("createdAt")
    private String createdAt;

    @TableField("subDescription")
    private String subDescription;

    private String description;

    @TableField("activeUser")
    private Integer activeUser;

    @TableField("newUser")
    private Integer newUser;

    private Integer start;

    private Integer likenum;

    private Integer message;

    private String content;

    private Integer publictype;


}
