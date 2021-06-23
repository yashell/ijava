package com.sunfish.site.controller;



import com.sunfish.site.common.ServerResult;
import com.sunfish.site.model.Category;
import com.sunfish.site.service.impl.CategoryServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangshi
 * @since 2021-06-22
 */
@Api(tags = "栏目表的相关接口",description = "恩恩")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    /***
     * 保存方法 有id为编辑，没id为新增
     * @param category
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
    public Object handle(@RequestBody Category category) {
        int eq;
        if(category.getId() == null){
            eq = categoryServiceImpl.add(category);
        } else {
            eq =  categoryServiceImpl.updata(category);
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
     */
    @GetMapping("/delete/{id}")
    @ApiOperation(value="删除", notes="传入ID")
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
        eq = categoryServiceImpl.delete(id);
        ServerResult serverResult;
        if(eq > 0) {
            serverResult = ServerResult.defaultSuccess(null);
        } else {
            serverResult = ServerResult.defaultFailure();
        }
        return serverResult;
    }

    /***
     * 获取树
     * @param parnetId
     * @return
     */
    @GetMapping("/tree")
    @ApiOperation(value="获取列表", notes="仔细阅读参数，可以传一个或多个")
    @ApiImplicitParams({
            @ApiImplicitParam(name="parnetId",defaultValue="0",value="栏目ID，传则查该栏目下文章",required=false,paramType="query",dataType="int"),
    })

    @ApiResponses({
            @ApiResponse(code=200,message="查询成功"),
            @ApiResponse(code=401,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=403,message="禁止访问"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=500,message="传参有问题或后台出错"),
            @ApiResponse(code=900,message="token出错")
    })
    public ServerResult<Category> tree(@RequestParam(value = "parnetId",defaultValue="0") Integer parnetId) {
        ServerResult serverResult = ServerResult.defaultSuccess(categoryServiceImpl.tree(parnetId,0));
        return serverResult;
    }



}
