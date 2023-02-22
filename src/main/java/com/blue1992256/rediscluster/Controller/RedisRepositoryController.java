package com.blue1992256.rediscluster.Controller;

import com.blue1992256.rediscluster.Service.RedisRepositoryService;
import com.blue1992256.rediscluster.vo.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// RedisRepository 를 사용한 CRUD
@RestController
public class RedisRepositoryController {

  private final RedisRepositoryService redisRepositoryService;

  public RedisRepositoryController(RedisRepositoryService redisRepositoryService) {
    this.redisRepositoryService = redisRepositoryService;
  }

  @PutMapping("/redisRepository")
  public ResponseEntity<Object> create(@ModelAttribute Person person) {
    return ResponseEntity.ok(redisRepositoryService.putKey(person));
  }

  @GetMapping("/redisRepository")
  public ResponseEntity<Object> get(@ModelAttribute Person person) {
    return ResponseEntity.ok(redisRepositoryService.getValue(person));
  }

  @DeleteMapping("/redisRepository")
  public ResponseEntity<Object> delete(@ModelAttribute Person person) {
    redisRepositoryService.deleteKey(person);
    return ResponseEntity.ok(person);
  }

  @PostMapping("/redisRepository")
  public ResponseEntity<Object> update(@ModelAttribute Person person) {
    return ResponseEntity.ok(redisRepositoryService.updateValue(person));
  }
}
