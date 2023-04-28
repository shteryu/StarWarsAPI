package dev.shteryu.star_wars.config;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "dummy")
@Component
@Getter
@Setter
public class DummyConfigProperties {

    private String dummyReturnValue;
    private List<Integer> dummyNumbers;
    private Map<String, Integer> dummyCites;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CityNumbers {
        private String cityName;
        private Integer cityNumber;
    }
    
}
