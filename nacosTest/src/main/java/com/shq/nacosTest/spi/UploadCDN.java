package com.shq.nacosTest.spi;

import org.springframework.context.annotation.Conditional;

public interface UploadCDN {
    void upload(String url);
}
