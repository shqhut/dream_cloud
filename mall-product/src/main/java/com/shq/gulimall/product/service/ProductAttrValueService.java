package com.shq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shq.gulimall.common.utils.PageUtils;
import com.shq.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author shq
 * @email 15292242950@163.com
 * @date 2023-01-01 18:29:38
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

