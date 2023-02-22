package com.blue1992256.rediscluster.configuration;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

  // 6개의 노드로 클러스터링 구성
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    // https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/connection/jedis/JedisConnectionFactory.html
    Collection<String> clusterNodes = new ArrayList<>();
    clusterNodes.add("127.0.0.1:16001");
    clusterNodes.add("127.0.0.1:17001");
    clusterNodes.add("127.0.0.1:18001");
    clusterNodes.add("127.0.0.1:16002");
    clusterNodes.add("127.0.0.1:17002");
    clusterNodes.add("127.0.0.1:18002");
    RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterNodes);
    return new JedisConnectionFactory(redisClusterConfiguration);
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
}
