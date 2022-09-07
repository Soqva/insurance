package com.s0qva.insurance.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@UtilityClass
public class WebResourceLocationUtil {

    public URI buildWebResourceLocation(String path, Object resource) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path)
                .buildAndExpand(resource)
                .toUri();
    }
}
