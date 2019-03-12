package com.henry.api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.henry.api.model
 * YourStoreRepository.java
 *
 * @Author : henry
 * @Data : 2019-03-10
 * @Version : 1.0
 */
@Repository
public interface YourStoreRepository extends JpaRepository<YourStore, Long> {

}
