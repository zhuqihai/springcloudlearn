package com.zhu.springcloud.feign.hystrix;/**
 * @Author zhuqihai
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 */

import com.zhu.springcloud.entiry.CategoryInfo;
import com.zhu.springcloud.feign.service.CategoryFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuqihai
 * @Description ////用于服务降级
 * @Date $ $
 * @Param $
 * @return $
 */
@Component

public class CategoryFallbckFactory implements FallbackFactory {

    public CategoryFeignService create(Throwable cause) {
        return new CategoryFeignService(){
            //重写返回值尽量别null 最好有其他提示
            public List <CategoryInfo> getCategoryInfoListByLevel(Integer level) {
                return null;

            }

            public List <CategoryInfo> getCategoryInfoList() {
                return null;
            }

            public CategoryInfo getCategoryById(String id) {
                return null;
            }

            public Boolean categoryInfoCreate(CategoryInfo categoryInfo) {
                return null;
            }

            public Object categoryInfoUpdateById(CategoryInfo categoryInfo) {
                return null;
            }

            public String categoryRemoveById(String id) {
                return null;
            }

            public Boolean categoryBatchRemove(Map <String, Object> columnMap) {
                return null;
            }
        };
    }
}
