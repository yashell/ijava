package com.sunfish.site.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunfish.site.common.PageResult;
import com.sunfish.site.model.Article;
import com.sunfish.site.mapper.ArticleMapper;
import com.sunfish.site.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查单条
     *
     * @param id
     * @return
     */
    public Article selectById(int id) {
        return articleMapper.selectById(id);
    }


    /***
     * 新增
     * @param article
     * @return
     */
    public int add(Article article) {
        return articleMapper.insert(article);
    }

    /***
     * 编辑
     * @param article
     * @return
     */
    public int updata(Article article) {
        return articleMapper.updateById(article);
    }

    /***
     * 逻辑删除
     * @param id
     * @return
     */
    public int delete(int id) {
        Article article = articleMapper.selectById(id);
        article.setIsDel(true);
        int eq = articleMapper.updateById(article);
        return eq;
    }


    /**
     * 查列表
     *
     * @param current
     * @param size
     * @param title
     * @return
     */
    public PageResult list(int current, int size, String title, Integer categoryId, boolean isbanner) {


        IPage<Article> articlePage = new Page<>(current, size);

        QueryWrapper<Article> sql = new QueryWrapper<Article>();
        sql.eq("is_del", 0);
        sql.orderByDesc("update_at");
        if (StringUtils.isNotBlank(title) && !"null".equals(title)) {
            sql.like("title", title);
        }
        if (categoryId != null) {
            sql.eq("category_id", categoryId);
        }

//        System.out.println(parnetCategoryId);
//        if(categoryId != null) {
//            sql.eq("parnet_category_id", parnetCategoryId);
//        }
//        if(StringUtils.isNotBlank(categoryId) && !"null".equals(title)) {
//           sql.like("title", title);
//        }

        if (isbanner) {
            sql.ne("banner", "");
        }

        System.out.println(isbanner);


        articlePage = articleMapper.selectPage(articlePage, sql);
        List<Article> list = articlePage.getRecords();
        PageResult pageResult = new PageResult();
        pageResult.setCurrent(current);
        pageResult.setSize(size);
        pageResult.setTotal(articlePage.getTotal());
        pageResult.setData(articlePage.getRecords());
        pageResult.setCode(200);
        pageResult.setMessage("操作成功");
        pageResult.setStatus(true);

        return pageResult;
    }

}
