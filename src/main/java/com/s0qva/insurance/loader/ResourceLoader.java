package com.s0qva.insurance.loader;

import java.nio.file.Path;

public interface ResourceLoader<T> {

    T load(Path pathToResource);
}
