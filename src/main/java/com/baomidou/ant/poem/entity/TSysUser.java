package com.baomidou.ant.poem.entity;

    import java.sql.Date;
    import java.sql.Timestamp;
    import java.time.LocalDateTime;

    import com.baomidou.mybatisplus.annotation.IdType;
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
* @since 2020-04-21
*/
    @Data
    @Accessors(chain = true)
    public class TSysUser {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uid;

    private String username;

    private String password;

    private String wecharid;

    private String wecharuid;

    private String qqid;

    private String qquid;

    private String realname;

    private String salt;

    private Integer status;

    private String email;

    private String mobile;

    private String nickname;

    private String sex;

    private Timestamp birthday;

    private String maxim;

    private Integer rank;

    private String picture;

}
