package dev.shteryu.star_wars.web.dto;

import java.util.List;
import org.springframework.data.domain.Page;
import lombok.Builder;
import lombok.Data;

@Data
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
