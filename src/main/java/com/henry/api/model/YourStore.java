package com.henry.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * com.henry.api.model
 * YourStore.java
 *
 * @Author : henry
 * @Data : 2019-03-08
 * @Version : 1.0
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class YourStore {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String shopCd;

    @Column
    private String shopNm;

    @Builder
    public YourStore(Long id, String shopCd, String shopNm){
        this.id = id;
        this.shopCd = shopCd;
        this.shopNm = shopNm;
    }


}
