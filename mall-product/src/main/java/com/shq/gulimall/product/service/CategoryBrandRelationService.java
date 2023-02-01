package com.shq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shq.gulimall.common.utils.PageUtils;
import com.shq.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author shq
 * @email 15292242950@163.com
 * @date 2023-01-01 18:29:38
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

