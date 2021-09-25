package com.nhu.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceContext {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortField;
    private String sortType;
    private String keyWord;
}
