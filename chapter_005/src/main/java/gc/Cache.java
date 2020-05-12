package gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 */

public class Cache implements CacheImpl<String, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Cache.class);
    private final HashMap<String, SoftReference<String>> cache = new HashMap<>();
    private final String pathFile;

    public Cache(String fileName) {
        this.pathFile = fileName;
    }

    @Override
    public String getValue(String key) {
        SoftReference<String> value = cache.get(key);
        if (value == null) {
            String fileData = "";
            try {
                fileData = Files.readString(Paths.get(this.pathFile + File.separator + key));
            } catch (IOException e) {
                LOGGER.error("file read fail ", e);
            }
            value = new SoftReference<>(fileData);
            cache.put(key, value);
        }
        return value.get();
    }
}
