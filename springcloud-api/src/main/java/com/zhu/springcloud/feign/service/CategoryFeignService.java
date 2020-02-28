package com.zhu.springcloud.feign.service;

import com.zhu.springcloud.entiry.CategoryInfo;
import com.zhu.springcloud.feign.hystrix.CategoryFallbckFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
@FeignClient(value="PROVIDER-01",fallbackFactory = CategoryFallbckFactory.class)
@RequestMapping("/category")
@Component
public interface CategoryFeignService {

    @GetMapping("getListByLevel/{level}")
    public List <CategoryInfo> getCategoryInfoListByLevel(@PathVariable("level")  Integer level);


    @GetMapping("getList")
    public List <CategoryInfo> getCategoryInfoList();



    @GetMapping("getCategoryById/{id}")
    public  CategoryInfo  getCategoryById (@PathVariable("id")  String id);


    @PostMapping("categoryInfoCreate")
    public Boolean categoryInfoCreate (CategoryInfo categoryInfo) ;



    @PutMapping("categoryInfoUpdate")
    public Object    categoryInfoUpdateById (CategoryInfo categoryInfo);

    @DeleteMapping("categoryRemoveById/{id}")
    public  String  categoryRemoveById (@PathVariable("id") String id);
    @DeleteMapping("categoryBatchRemoveByMap")
    public  Boolean  categoryBatchRemove( Map <String, Object> columnMap);


}
