package com.sunfish.site.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别ID
     */
    private Integer categoryId;

    /**
     * 父级类别ID
     */
    private Integer parnetCategoryId;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 删除标识
     */
    private Boolean isDel;

    /**
     * 点击次数
     */
    private Integer click;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 轮播图
     */
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
