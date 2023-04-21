package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmPlanetsGetResponse {

    private Set<Long> filmPlanetsIds;

}
