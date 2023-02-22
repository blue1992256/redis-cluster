package com.blue1992256.rediscluster.Repository;

import com.blue1992256.rediscluster.vo.Person;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<Person, Long> {
  Person findByUserName(String userName);
}
