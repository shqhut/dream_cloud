package com.shq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shq.gulimall.common.utils.PageUtils;
import com.shq.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author shq
 * @email 15292242950@163.com
 * @date 2023-01-01 18:29:37
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

