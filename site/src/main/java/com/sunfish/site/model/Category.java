package com.sunfish.site.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangshi
 * @since 2021-06-23
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户ID(新增填null,编辑填写id)", required = false, name = "id", example = "0")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 父栏目ID
     */
    @ApiModelProperty(value = "父级ID", required = true, name = "parnetId", example = "0")
    @TableField("parnet_id")
    private Integer parnetId;

    /**
     * 栏目名称
     */
    @ApiModelProperty(value = "栏目名称", required = false, name = "title", example = "栏目一")
    @TableField("title")
    private String title;

    /**
     * 栏目权重
     */
    @ApiModelProperty(value = "栏目权重", required = false, name = "weight", example = "0")
    @TableField("weight")
    private Integer weight;

    /**
     * 转载
     */
    @ApiModelProperty(value = "转载", required = false, name = "siteurl", example = "")
    @TableField("siteurl")
    private String siteurl;

    /**
     * SEO标题
     */
    @ApiModelProperty(value = "SEO标题", required = false, name = "seoTitle", example = "")
    @TableField("seo_title")
    private String seoTitle;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "SEO关键字", required = false, name = "keywords", example = "")
    @TableField("keywords")
    private String keywords;

    /**
     * 描述
     */
    @ApiModelProperty(value = "SEO描述", required = false, name = "description", example = "")
    @TableField("description")
    private String description;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容,为富文本", required = false, name = "content", example = "")
    @TableField("content")
    private String content;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = false, name = "type", example = "")
    @TableField("type")
    private Integer type;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标", required = false, name = "icon", example = "")
    @TableField("icon")
    private String icon;

    /**
     * 是否隐藏
     */
    @ApiModelProperty(value = "是否隐藏，默认为false", required = false, name = "hide", example = "false")
    @TableField("hide")
    private Boolean hide;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = false, name = "upuateAt", example = "")
    @TableField("upuate_at")
    private LocalDateTime upuateAt;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false, name = "createAt", example = "")
    @TableField("create_at")
    private LocalDateTime createAt;


    @TableField(exist = false)
    private List<Category> children;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParnetId() {
        return parnetId;
    }

    public void setParnetId(Integer parnetId) {
        this.parnetId = parnetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public LocalDateTime getUpuateAt() {
        return upuateAt;
    }

    public void setUpuateAt(LocalDateTime upuateAt) {
        this.upuateAt = upuateAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parnetId=" + parnetId +
                ", title=" + title +
                ", weight=" + weight +
                ", siteurl=" + siteurl +
                ", seoTitle=" + seoTitle +
                ", keywords=" + keywords +
                ", description=" + description +
                ", content=" + content +
                ", type=" + type +
                ", icon=" + icon +
                ", hide=" + hide +
                ", upuateAt=" + upuateAt +
                ", createAt=" + createAt +
                "}";
    }
}
