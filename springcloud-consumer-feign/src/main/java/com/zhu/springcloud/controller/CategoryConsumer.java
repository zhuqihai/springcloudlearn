package com.zhu.springcloud.controller;

import com.zhu.springcloud.entiry.CategoryInfo;
import com.zhu.springcloud.feign.service.CategoryFeignService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@RestController
@RequestMapping("consumer/category")
public class CategoryConsumer {

    @GetMapping("test")
    public String test(){
        return "test------------------";
    }

    @Resource
    CategoryFeignService service=null;


    @GetMapping("getListByLevel/{level}")
    @ApiOperation(value = "获取根据level分类列表")
    public List <CategoryInfo> getCategoryInfoListByLevel(@PathVariable("level") @NotBlank Integer level){

        return   this.service.getCategoryInfoListByLevel(level);

    }

    @GetMapping("getList")
    @ApiOperation(value = "获取分类列表")
    public List <CategoryInfo> getCategoryInfoList() {
        System.out.println("---------------getCategoryInfoList------------");
        return   this.service.getCategoryInfoList();

    }

    @ApiOperation(value = "根据id获取某个分类")
    @GetMapping("getCategoryById/{id}")
    public  CategoryInfo  getCategoryById (@PathVariable("id") @NotBlank String id) {

        return   this.service.getCategoryById(id);
    }

    @ApiOperation(value = "新建一个分类")
    @PostMapping("categoryInfoCreate")
    public Boolean categoryInfoCreate (CategoryInfo categoryInfo) {
        categoryInfo.setFullPath(StringUtils.trimAllWhitespace(categoryInfo.getCategory()));

        return   this.service.categoryInfoCreate(categoryInfo);

    }



    @ApiOperation(value = "根据id更新某个分类")
    @PutMapping("categoryInfoUpdate")
    public void    categoryInfoUpdateById (CategoryInfo categoryInfo) {

        this.service.categoryInfoUpdateById(categoryInfo);

    }

 /*   @ApiOperation(value = "根据id删除某个分类")
    @DeleteMapping("categoryRemoveById/{id}")
    public  String  categoryRemoveById (@PathVariable String id) {


        return   restTemplate.delete();
    }*/


}
