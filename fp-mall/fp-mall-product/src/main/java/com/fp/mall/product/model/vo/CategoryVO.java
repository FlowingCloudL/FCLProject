package com.fp.mall.product.model.vo;

import com.fp.common.core.model.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CategoryVO extends BaseVO {

    @ApiModelProperty("分类id")
    private Long id;
    @ApiModelProperty("分类层级 | 0为根分类")
    private Short level;
    @ApiModelProperty("父ID")
    private Long parentId;
    @ApiModelProperty("分类名称")
    private String name;
    @ApiModelProperty("分类描述")
    private String desc;
    @ApiModelProperty("分类图标")
    private String iconUrl;
    @ApiModelProperty("状态 | 1:enable, 0:disable, -1:deleted")
    private Byte status;
    @ApiModelProperty("上级分类名称")
    private List<String> pathNames;
    @ApiModelProperty("子分类列表")
    private List<CategoryVO> categories;

    public Long getId() {
        return id;
    }

    public CategoryVO setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getLevel() {
        return level;
    }

    public CategoryVO setLevel(Short level) {
        this.level = level;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public CategoryVO setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }


    public String getName() {
        return name;
    }

    public CategoryVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CategoryVO setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public CategoryVO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public Byte getStatus() {
        return status;
    }

    public CategoryVO setStatus(Byte status) {
        this.status = status;
        return this;
    }


    @Override
    public String toString() {
        return "CategoryVO{" +
                "id=" + id +
                ", level=" + level +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
