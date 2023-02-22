package com.blue1992256.rediscluster.Service;

import com.blue1992256.rediscluster.vo.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateService {

  private final RedisTemplate redisTemplate;

  public RedisTemplateService(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void putKey(Person person) {
   redisTemplate.opsForValue().set(person.getUserName(), person.getAge());
  }

  public Object getValue(Person person) {
    return redisTemplate.opsForValue().get(person.getUserName());
  }

  public void deleteKey(Person person) {
    redisTemplate.delete(person.getUserName());
  }

  public Object updateValue(Person person) {
    return redisTemplate.opsForValue().getAndSet(person.getUserName(), person.getAge());
  }
}
