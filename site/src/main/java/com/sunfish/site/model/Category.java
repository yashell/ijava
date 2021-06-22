package com.sunfish.site.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 栏目名称
     */
    private String title;

    /**
     * 栏目权重
     */
    private Integer weight;

    /**
     * 转载
     */
    private String siteurl;

    /**
     * SEO标题
     */
    private String seoTitle;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否显示
     */
    private Boolean isShow;

    /**
     * 父栏目ID
     */
    private Integer parnetId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
    public Integer getParnetId() {
        return parnetId;
    }

    public void setParnetId(Integer parnetId) {
        this.parnetId = parnetId;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", title=" + title +
            ", weight=" + weight +
            ", siteurl=" + siteurl +
            ", seoTitle=" + seoTitle +
            ", keywords=" + keywords +
            ", description=" + description +
            ", content=" + content +
            ", type=" + type +
            ", icon=" + icon +
            ", isShow=" + isShow +
            ", parnetId=" + parnetId +
        "}";
    }
}
