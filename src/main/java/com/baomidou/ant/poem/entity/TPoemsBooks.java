package com.baomidou.ant.poem.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

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
public class TPoemsBooks {

    //    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String author;

    private String publisher;

    private Timestamp publishtime;

    private String studyphase;

    private String memo;


}
