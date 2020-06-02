package com.baomidou.ant.poem.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;

    import java.sql.Timestamp;
    import java.time.LocalDateTime;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2020-05-17
*/
    @Data
    @Accessors(chain = true)
    public class TComments {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String poem_id;

    private String content;

    private String create_time;

    private String user_name;

    private String user_avatar;


}
