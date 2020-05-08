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
    public class TPoemsGenre  {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String representative;

    private String intro;


}
