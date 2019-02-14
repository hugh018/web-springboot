//package tech.hugh.demo;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//
//import java.util.HashSet;
//import java.util.Set;
// redis集群模式
//@Configuration
//public class RedisConfig {
//
//    // 注入集群结点
//    @Value("${spring.redis.cluster.nodes}")
//    private String clusterNodes;
//
//    @Bean
//    public JedisCluster getJedisCluster() {
//        // 解析结点
//        String[] split = clusterNodes.split(","); //127.0.0.1:7003
//        Set<HostAndPort> nodes = new HashSet<>();
//        for (String hostPort : split) {
//            String[] hp = hostPort.split(":");
//            nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
//        }
//        JedisCluster jedisCluster = null;
//        try {
//            jedisCluster = new JedisCluster(nodes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jedisCluster;
//    }
//}
