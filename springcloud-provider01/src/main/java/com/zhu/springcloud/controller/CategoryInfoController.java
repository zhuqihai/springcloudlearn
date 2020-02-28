package com.zhu.springcloud.controller;


import com.zhu.springcloud.config.ResponseData;
import com.zhu.springcloud.entiry.CategoryInfo;
import com.zhu.springcloud.service.ICategoryInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhu
 * @since 2020-02-09
 */
@Slf4j
@RestController
@Api(tags = "分类Api", description = "种类相关接口")
@RequestMapping("/category")
public class CategoryInfoController {

    // @Resource(name="CategoryInfoService")
    @Autowired
    ICategoryInfoService categoryInfoServiceImpl;

     //@Autowired
     //CategoryInfoMapper categoryInfoMapper;

    @GetMapping("getListByLevel/{level}")
    @ApiOperation(value = "获取根据level分类列表")
    public List <CategoryInfo> getCategoryInfoListByLevel(@PathVariable @NotBlank Integer level){
        System.out.println("------测试 provider01");

        return   categoryInfoServiceImpl.query().eq("level",level).list();

        // return   categoryInfoMapper.getCategoryInfoListByLevel(level);
    }



    @GetMapping("getList")
    @ApiOperation(value = "获取分类列表")
    public List <CategoryInfo> getCategoryInfoList() {

        System.out.println("------测试 provider01");

        return   categoryInfoServiceImpl.list(null);
    }

    @ApiOperation(value = "根据id获取某个分类")
    @GetMapping("getCategoryById/{id}")
    public  CategoryInfo  getCategoryById (@PathVariable @NotBlank String id) {

        return   categoryInfoServiceImpl.getById(id);
    }

    @ApiOperation(value = "新建一个分类")
    @PostMapping("categoryInfoCreate")
    public Boolean categoryInfoCreate (CategoryInfo categoryInfo) {
        categoryInfo.setFullPath(StringUtils.trimAllWhitespace(categoryInfo.getCategory()));

        return   categoryInfoServiceImpl.save(categoryInfo);

    }



    @ApiOperation(value = "根据id更新某个分类")
    @PutMapping("categoryInfoUpdate")
    public Object    categoryInfoUpdateById (CategoryInfo categoryInfo) {


        if(categoryInfo.getParentId()==categoryInfo.getId()){
            return  ResponseData.fail("本身不能作为父节点");
        }
        if(categoryInfoServiceImpl.updateById(categoryInfo)){
            return ResponseData.fail("失败");
        }else{
            return ResponseData.success();

        }

    }

    @ApiOperation(value = "根据id删除某个分类")
    @DeleteMapping("categoryRemoveById/{id}")
    public  String  categoryRemoveById (@PathVariable String id) {


        List<CategoryInfo>   categoryInfoList=categoryInfoServiceImpl.query().eq("parent_Id",id).list();
        if(categoryInfoList.size()>0){
            return "请先删除子节点";
        }else{
            boolean bl= categoryInfoServiceImpl.removeById(id);

            if(bl){
                return "true";
            }else{
                return "false";
            }


        }

        //return
    }

    @ApiOperation(value = "根据map删除分类")
    @DeleteMapping("categoryBatchRemoveByMap")
    public  Boolean  categoryBatchRemove( Map <String, Object> columnMap) {
        return categoryInfoServiceImpl.removeByMap(columnMap);

    }



}
