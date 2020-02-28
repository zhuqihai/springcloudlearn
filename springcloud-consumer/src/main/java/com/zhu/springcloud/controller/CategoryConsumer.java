package com.zhu.springcloud.controller;

import com.zhu.springcloud.entiry.CategoryInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;
    //private static final String REST_URL_PRIFIX="http://localhost:8000/";



    private static final String REST_URL_PRIFIX="http://PROVIDER-01";



    @GetMapping("getListByLevel/{level}")
    @ApiOperation(value = "获取根据level分类列表")
    public List <CategoryInfo> getCategoryInfoListByLevel(@PathVariable @NotBlank Integer level){

        return   restTemplate.getForObject(REST_URL_PRIFIX+"/category/getListByLevel/"+level,List.class);

    }

    @GetMapping("getList")
    @ApiOperation(value = "获取分类列表")
    public List <CategoryInfo> getCategoryInfoList() {
        System.out.println("---------------getCategoryInfoList------------");
        return   restTemplate.getForObject(REST_URL_PRIFIX+"/category/getList",List.class);

        //return (List <CategoryInfo>) restTemplate.getForEntity(REST_URL_PRIFIX+"/category/getList",List.class);

    }

    @ApiOperation(value = "根据id获取某个分类")
    @GetMapping("getCategoryById/{id}")
    public  CategoryInfo  getCategoryById (@PathVariable @NotBlank String id) {

        return   restTemplate.getForObject(REST_URL_PRIFIX+"/category/getListById/"+id,CategoryInfo.class);
    }

    @ApiOperation(value = "新建一个分类")
    @PostMapping("categoryInfoCreate")
    public Boolean categoryInfoCreate (CategoryInfo categoryInfo) {
        categoryInfo.setFullPath(StringUtils.trimAllWhitespace(categoryInfo.getCategory()));

        return   restTemplate.postForObject(REST_URL_PRIFIX+"/category/create",categoryInfo,Boolean.class);

    }



    @ApiOperation(value = "根据id更新某个分类")
    @PutMapping("categoryInfoUpdate")
    public void    categoryInfoUpdateById (CategoryInfo categoryInfo) {

           restTemplate.put(REST_URL_PRIFIX+"/category/update",categoryInfo);

    }

 /*   @ApiOperation(value = "根据id删除某个分类")
    @DeleteMapping("categoryRemoveById/{id}")
    public  String  categoryRemoveById (@PathVariable String id) {


        return   restTemplate.delete();
    }*/


}
