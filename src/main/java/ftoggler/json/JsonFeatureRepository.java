package ftoggler.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ftoggler.core.DelegatingFeatureRepository;
import ftoggler.core.FTogglerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Joao Pedro Evangelista
 */
public class JsonFeatureRepository extends DelegatingFeatureRepository {

    private final File file;

    public JsonFeatureRepository(String file) {
        this.file = new File(file);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void loadPropertiesAndSetOnContext() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonArray array = objectMapper.readValue(fileInputStream, JsonArray.class);
            for (FeatureJson body : array) {
                this.enable(body.toFeature());
            }
        } catch (IOException e) {
            throw new FTogglerException(e);
        }
    }


    protected static class JsonArray extends ArrayList<FeatureJson> {
    /* no-op */
    }
}
