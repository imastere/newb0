package com.baomidou.ant.poem.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2020-05-03
*/
    @Data
    @Accessors(chain = true)
    public class TUserInfo  {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String avatar;

    private String email;

    private Integer userid;

    private String signature;

    private String title;

    private String usergroup;

    @TableField("notifyCount")
    private Integer notifyCount;

    @TableField("unreadCount")
    private String unreadCount;

    private String country;

    private String adress;

    private String phone;

//    private String province;
//
//    private String



}
