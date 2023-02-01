package com.shq.gulimall.product.test;

import com.shq.gulimall.product.dao.BrandDao;
import com.shq.gulimall.product.entity.BrandEntity;
import com.shq.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    BrandService brandService;

    @Test
    public void testMapper() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("测试品牌");
        brandService.save(brandEntity);
    }

}
