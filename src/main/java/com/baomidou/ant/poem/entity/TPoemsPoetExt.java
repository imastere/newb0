package com.baomidou.ant.poem.entity;

    import com.baomidou.mybatisplus.annotation.TableField;
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
    public class TPoemsPoetExt{

    private static final long serialVersionUID = 1L;

    private String uid;

    private String biography;

    private String achievements;

        @TableField("literaryFeatures")
    private String literaryFeatures;

        @TableField("characterEvaluation")
    private String characterEvaluation;

        @TableField("anecdotesAllusions")
    private String anecdotesAllusions;

        @TableField("familyMembers")
    private String familyMembers;

        @TableField("affectFuture")
    private String affectFuture;

    private String dispute;

    private String commemorate;

        @TableField("artisticImage")
    private String artisticImage;


}
