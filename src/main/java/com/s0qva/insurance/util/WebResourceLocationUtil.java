package com.s0qva.insurance.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public final class WebResourceLocationUtil {

    private WebResourceLocationUtil() {
    }

    public static URI buildWebResourceLocation(String path, Object resource) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path)
                .buildAndExpand(resource)
                .toUri();
    }
}
