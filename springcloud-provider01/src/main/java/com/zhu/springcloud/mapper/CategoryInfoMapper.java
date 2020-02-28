package com.zhu.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.springcloud.entiry.CategoryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryInfoMapper extends BaseMapper<CategoryInfo> {

    @Select("SELECT * FROM category_info WHERE LEVEL =#{level}")
    List <CategoryInfo> getCategoryInfoListByLevel(@Param("level") Integer Level);
}
