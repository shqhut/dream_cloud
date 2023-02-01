package com.shq.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shq.gulimall.common.utils.PageUtils;
import com.shq.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author shq
 * @email 15292242950@163.com
 * @date 2023-01-01 18:29:37
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

