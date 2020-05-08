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
public class TPoemsIncludedbooks {

    private static final long serialVersionUID = 1L;

    private String poemid;

    private String bookid;

    private String memo;


}
