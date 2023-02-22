package com.blue1992256.rediscluster.Service;

import com.blue1992256.rediscluster.Repository.RedisRepository;
import com.blue1992256.rediscluster.vo.Person;
import org.springframework.stereotype.Service;

@Service
public class RedisRepositoryService {

  private final RedisRepository redisRepository;

  public RedisRepositoryService(RedisRepository redisRepository) {
    this.redisRepository = redisRepository;
  }

  public Object putKey(Person person) {
    return redisRepository.save(person);
  }

  public Object getValue(Person person) {
    return redisRepository.findByUserName(person.getUserName());
  }

  public void deleteKey(Person person) {
    redisRepository.delete(redisRepository.findByUserName(person.getUserName()));
  }

  public Object updateValue(Person person) {
    Person entity = redisRepository.findByUserName(person.getUserName());
    entity.setAge(person.getAge());
    return redisRepository.save(entity);
  }
}
