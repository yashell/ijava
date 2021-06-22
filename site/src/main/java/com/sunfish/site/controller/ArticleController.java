package com.sunfish.site.controller;


import com.sunfish.site.common.PageResult;
import com.sunfish.site.common.ServerResult;
import com.sunfish.site.model.Article;
import com.sunfish.site.service.ArticleService;
import com.sunfish.site.service.impl.ArticleServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
@Api(tags = "文章表的相关接口",description = "恩恩")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl ArticleServiceImpl;

    /***
     * 分页查列表
     * @param current
     * @param size
     * @param title
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value="获取列表", notes="仔细阅读参数，可以传一个或多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name="current",defaultValue="1",value="当前第几页，默认值为：1",required=false,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",defaultValue="10",value="每页多少条数据，默认值为10",required=false,paramType="path",dataType="int"),
            @ApiImplicitParam(name="title",defaultValue="",value="查询的文章名称，默认值为空",required=false,paramType="path",dataType="String",example="文章标题"),
//            @ApiImplicitParam(name="categoryId",defaultValue="0",value="栏目ID，传则查该栏目下文章",required=false,paramType="path",dataType="int"),
            @ApiImplicitParam(name="isbanner",value="是否是banner图，传则1则表示只查有banner图的文章，默认为0",required=false,paramType="path",dataType="int"),
            @ApiImplicitParam(name="parnetCategoryId",value="父栏目ID",required=false,paramType="path",dataType="int"),
    })

    @ApiResponses({
            @ApiResponse(code=200,message="查询成功"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="禁止访问"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="传参有问题或后台出错"),
            @ApiResponse(code=900,message="token出错")
    })
    public PageResult<List<Article>> queryList(@RequestParam(value="current",defaultValue="1") Integer current, @RequestParam(value="size",defaultValue="10") Integer size  , @RequestParam(value="title",defaultValue="") String title,  @RequestParam(value="categoryId",defaultValue="1") Integer categoryId) {
//        ,@RequestParam(value="isbanner",defaultValue="0") int isbanner, @RequestParam(value="parnetCategoryId",defaultValue="0") int parnetCategoryId
        System.out.println(categoryId);
        PageResult pageResult = ArticleServiceImpl.ArticleList(current,size, title);
        return pageResult;
    }

    /**
     * 查单条
     * @param id
     * @return
     * http://localhost:1111/plus/user/selectbyid?id=27
     */
    @GetMapping("/byid")
    @ApiOperation(value="获取单条", notes="这里边填写备注，用户可仔细阅读")
    @ApiResponses({
            @ApiResponse(code=200,message="查询成功"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="禁止访问"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="传参有问题或后台出错"),
            @ApiResponse(code=900,message="token出错")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",defaultValue="1",value="文章ID",required=true,paramType="path",dataType="int"),
    })
    public Object selectById(@RequestParam int id) {
        Article article = ArticleServiceImpl.selectById(id);
        ServerResult<Object> serverResult = ServerResult.defaultSuccess(article);
        return serverResult;
    }

    /***
     * 保存方法 有id为编辑，没id为新增
     * @param article
     * 请求示例 http://localhost:1111/userinfo/add?name=测试&sex=0&score=295.5
     * id 自增 ，时间后台自动添加
     * @return
     */
    @PostMapping("/handle")
    @ApiOperation(value="新增和编辑", notes="有ID为编辑，没有为新增")
    @ApiResponses({
            @ApiResponse(code=200,message="查询成功"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="禁止访问"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="传参有问题或后台出错"),
            @ApiResponse(code=900,message="token出错")
    })
    public Object handle(@RequestBody Article article) {
        int eq;
        if(article.getId() == null){
            eq = ArticleServiceImpl.add(article);
        } else {
            eq =  ArticleServiceImpl.updata(article);
        }
        ServerResult<String> serverResult;
        if(eq > 0) {
            serverResult = ServerResult.defaultSuccess(null);
        } else {
            serverResult = ServerResult.defaultFailure();
        }
        return serverResult;
    }


    /**
     * 删除
     * @param id
     * @return
     * http://localhost:1111/article/delete?id=27
     */
    @GetMapping("/delete/{id}")
    @ApiOperation(value="逻辑删除", notes="传入ID")
    @ApiResponses({
            @ApiResponse(code=200,message="查询成功"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="禁止访问"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="传参有问题或后台出错"),
            @ApiResponse(code=900,message="token出错")
    })
    public ServerResult delete(@PathVariable("id") int id) {
        int eq;
        eq = ArticleServiceImpl.delete(id);
        ServerResult serverResult;
        if(eq > 0) {
            serverResult = ServerResult.defaultSuccess(null);
        } else {
            serverResult = ServerResult.defaultFailure();
        }
        return serverResult;
    }




}
