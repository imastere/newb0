package com.baomidou.ant.poem.entity;

    import java.time.LocalDate;
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
    public class TPoemsPoet{

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private String name;

    private String nameZi;

    private String nameHao;

    private Integer gender;

    private LocalDate birthday;

    private LocalDate deathday;

    private Integer dynastyid;

    private String intro;

    private String masterwork;


}
