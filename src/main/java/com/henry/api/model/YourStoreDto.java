package com.henry.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * com.henry.api.model
 * YourStoreDto.java
 *
 * @Author : henry
 * @Data : 2019-03-12
 * @Version : 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class YourStoreDto {

    private Long id;
    private String shopCd;
    private String shopNm;

    public YourStore toEntity(){
        return YourStore.builder()
                .id(id)
                .shopCd(shopCd)
                .shopNm(shopNm)
                .build();
    }
}
