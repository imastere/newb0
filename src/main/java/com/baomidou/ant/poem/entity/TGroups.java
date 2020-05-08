package com.baomidou.ant.poem.entity;

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
* @since 2020-04-21
*/
    @Data
    @Accessors(chain = true)
    public class TGroups  {

    private static final long serialVersionUID = 1L;

    private String uid;

    private LocalDateTime createtime;

    private Integer nature;

    private String departmentuid;

    private Integer defaultGroup;

    private String groupName;

    private String groupdeanuid;

    private Integer flag;

    private Integer grouptype;

    private Integer activityDegree;


}
