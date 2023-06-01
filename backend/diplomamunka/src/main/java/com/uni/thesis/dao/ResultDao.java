package com.uni.thesis.dao;

import com.uni.thesis.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao extends CrudRepository<Result, Integer> {
}
