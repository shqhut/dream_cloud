package com.shq.nacosTest.spi;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        // 通过ServiceLoader加载具体的实现类
        ServiceLoader<UploadCDN> uploadCDNS = ServiceLoader.load(UploadCDN.class);
        for (UploadCDN uploadCDN : uploadCDNS) {
            uploadCDN.upload("xxx");
        }
    }
}
