package com.baomidou.ant.poem.entity;

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
    public class TPoemsPoem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uid;

    private String name;

    private Integer dynastyid;

    private Integer typeid;

    private String authoruid;

    private String content;

    private String annotation;

    private String translation;

    private String workintro;

    private String richtext;

    private String memo;


}
