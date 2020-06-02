package com.baomidou.ant.poem.entity;

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
* @since 2020-05-07
*/
    @Data
    @Accessors(chain = true)
    public class TTopicOperate  {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String user;

    private Integer operate;

    private Integer topicid;

    private String creattime;


}
