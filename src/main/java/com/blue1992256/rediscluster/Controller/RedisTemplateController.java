package com.blue1992256.rediscluster.Controller;

import com.blue1992256.rediscluster.Service.RedisTemplateService;
import com.blue1992256.rediscluster.vo.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// RedisTemplate 를 사용한 CRUD
@RestController
public class RedisTemplateController {

  private final RedisTemplateService redisTemplateService;

  public RedisTemplateController(RedisTemplateService redisTemplateService) {
    this.redisTemplateService = redisTemplateService;
  }

  @PutMapping("/redisTemplate")
  public ResponseEntity<Object> create(@ModelAttribute Person person) {
    redisTemplateService.putKey(person);
    return ResponseEntity.ok(person);
  }

  @GetMapping("/redisTemplate")
  public ResponseEntity<Object> get(@ModelAttribute Person person) {
    return ResponseEntity.ok(redisTemplateService.getValue(person));
  }

  @DeleteMapping("/redisTemplate")
  public ResponseEntity<Object> delete(@ModelAttribute Person person) {
    redisTemplateService.deleteKey(person);
    return ResponseEntity.ok(person);
  }

  @PostMapping("/redisTemplate")
  public ResponseEntity<Object> update(@ModelAttribute Person person) {
    return ResponseEntity.ok(redisTemplateService.updateValue(person));
  }

}
