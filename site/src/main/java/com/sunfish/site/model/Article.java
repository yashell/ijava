package com.sunfish.site.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    @ApiModelProperty(value = "用户ID(新增填null,编辑填写id)", required = false, name = "id", example = "0")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别ID
     */
    @ApiModelProperty(value = "类别ID", required = false, name = "categoryId", example = "0")
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 父级类别ID
     */
    @ApiModelProperty(value = "父级类别ID", required = false, name = "parnetCategoryId", example = "0")
    @TableField("parnet_category_id")
    private Integer parnetCategoryId;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字", required = false, name = "keywords", example = "")
    @TableField("keywords")
    private String keywords;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址", required = false, name = "link", example = "")
    @TableField("link")
    private String link;

    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题", required = false, name = "title", example = "")
    @TableField("title")
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者", required = false, name = "author", example = "")
    @TableField("author")
    private String author;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", required = false, name = "introduction", example = "")
    @TableField("introduction")
    private String introduction;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容,为富文本", required = false, name = "content", example = "")
    @TableField("content")
    private String content;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = false, name = "remark", example = "")
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false, name = "createAt", example = "")
    @TableField("create_at")
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = false, name = "updateAt", example = "")
    @TableField("update_at")
    private LocalDateTime updateAt;

    /**
     * 删除标识
     */
    @ApiModelProperty(value = "删除标识,默认false", required = false, name = "isDel", example = "false")
    @TableField("is_del")
    private Boolean isDel;

    /**
     * 点击次数
     */
    @ApiModelProperty(value = "点击次数", required = false, name = "click", example = "0")
    @TableField("click")
    private Integer click;

    /**
     * 权重
     */
    @ApiModelProperty(value = "权重", required = false, name = "weight", example = "")
    @TableField("weight")
    private Integer weight;

    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图", required = false, name = "thumbnail", example = "")
    @TableField("thumbnail")
    private String thumbnail;

    /**
     * 轮播图
     */
    @ApiModelProperty(value = "轮播图", required = false, name = "banner", example = "")
    @TableField("banner")
    private String banner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getParnetCategoryId() {
        return parnetCategoryId;
    }

    public void setParnetCategoryId(Integer parnetCategoryId) {
        this.parnetCategoryId = parnetCategoryId;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", categoryId=" + categoryId +
            ", parnetCategoryId=" + parnetCategoryId +
            ", keywords=" + keywords +
            ", link=" + link +
            ", title=" + title +
            ", author=" + author +
            ", introduction=" + introduction +
            ", content=" + content +
            ", remark=" + remark +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", isDel=" + isDel +
            ", click=" + click +
            ", weight=" + weight +
            ", thumbnail=" + thumbnail +
            ", banner=" + banner +
        "}";
    }
}
