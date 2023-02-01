package com.shq.nacosTest.spi.impl;

import com.shq.nacosTest.spi.UploadCDN;

public class QiyiCDN implements UploadCDN {
    @Override
    public void upload(String url) {
        System.out.println("上传到Qiyi");
    }
}
