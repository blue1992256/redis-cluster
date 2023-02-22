package com.blue1992256.rediscluster.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("person")
public class Person {

  @Id
  private Long id;
  @Indexed
  private String userName;
  private String age;
}
