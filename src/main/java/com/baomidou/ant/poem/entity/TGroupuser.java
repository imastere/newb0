package com.baomidou.ant.poem.entity;

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
    public class TGroupuser  {

    private static final long serialVersionUID = 1L;

    private String uid;

    private String userUid;

    private String groupId;

    private Integer role;

    private Integer flag;

    private Integer activityDegree;


}
