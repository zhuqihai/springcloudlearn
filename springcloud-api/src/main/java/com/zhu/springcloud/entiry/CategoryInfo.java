package com.zhu.springcloud.entiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhu
 * @since 2020-02-09
 */
@Data
@Component
@Accessors(chain = true)
@ApiModel(value="CategoryInfo对象", description="")
public class CategoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "分类名")
    private String category;
    @ApiModelProperty(value = "分类深度")
    private Integer level;

    @ApiModelProperty(value = "分类顺序")
    private Integer sortNum;

    @ApiModelProperty(value = "父类id")
    private String parentId;

    @ApiModelProperty(value = "url",hidden = true)
    private String url;

    @ApiModelProperty(value = "分类从root开始全路径",hidden = true)
    private String fullPath;

    @ApiModelProperty(value = "分类从root开始全路径id",hidden = true)
    private String fullPathId;




    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "创建时间",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "创建人",hidden = true)
    private String creator;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String modifier;

    @ApiModelProperty(value = "修改时间",hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;

    @ApiModelProperty(value = "状态")
    private Integer status;


}
