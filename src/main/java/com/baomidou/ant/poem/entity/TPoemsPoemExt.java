package com.baomidou.ant.poem.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableName("t_poems_poem_ext")
    public class TPoemsPoemExt {

    private static final long serialVersionUID = 1L;

    private String uid;

        @TableField("engContent")
    private String engContent;

        @TableField("engIntro")
    private String engIntro;

    private String audio;

    private String vedio;

    private String yiwenAudio;

    private String pic;

    private String appreciation;

            /**
            * 创作背景
            */
    private String background;

    private String version;

    private String analyse;

    private String story;

            /**
            * 参考资料
            */
    private String memo;


}
