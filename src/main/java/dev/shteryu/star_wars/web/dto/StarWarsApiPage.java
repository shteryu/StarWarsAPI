package dev.shteryu.star_wars.web.dto;

import java.util.List;
import org.springframework.data.domain.Page;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@JsonPropertyOrder({"pagination", "content"})
public class StarWarsApiPage<T> {

    private List<T> content;

    private PaginationMetadata pagination;

    public StarWarsApiPage(Page<T> springPage) {
        this.content = springPage.getContent();
        this.pagination =
                PaginationMetadata.builder()
                        .currentPage(springPage.getPageable().getPageNumber())
                        .totalElements(springPage.getTotalElements())
                        .totalPages(springPage.getTotalPages())
                        .pageSize(springPage.getPageable().getPageSize())
                        .build();
    }


    @Data
    @Builder
    private static class PaginationMetadata {
        private Integer currentPage;
        private Integer pageSize;
        private Integer totalPages;
        private Long totalElements;
    }
}
