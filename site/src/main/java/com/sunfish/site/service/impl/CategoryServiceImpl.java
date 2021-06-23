package com.sunfish.site.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunfish.site.common.PageResult;
import com.sunfish.site.mapper.ArticleMapper;
import com.sunfish.site.model.Article;
import com.sunfish.site.model.Category;
import com.sunfish.site.mapper.CategoryMapper;
import com.sunfish.site.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /***
     * 新增
     * @param category
     * @return
     */
    public int add(Category category) {
        return categoryMapper.insert(category);
    }

    /***
     * 编辑
     * @param category
     * @return
     */
    public int updata(Category category) {
        return categoryMapper.updateById(category);
    }

    /***
     * 物理删除
     * @param id
     * @return
     */
    public int delete(int id) {
        int eq = categoryMapper.deleteById(id);
        return eq;
    }

    /**
     * 查列表
     *
     * @return
     */
    public Category tree(int parnetId, int deep) {

        Category category;
        if (parnetId == 0) {
            category = new Category();
        } else {
            category = categoryMapper.selectById(parnetId);
        }

        QueryWrapper<Category> sql = new QueryWrapper<Category>().eq("parnet_id", parnetId).orderByDesc("weight");

        category.setChildren(categoryMapper.selectList(sql));

        return category;
    }
}
