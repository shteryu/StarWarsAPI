package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmPeopleUpsertRequest {

    @NotNull
    private Set<Long> filmPeopleIds;

}