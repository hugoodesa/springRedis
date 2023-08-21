package br.stapassoli.springRedis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student implements Serializable {

    @Id
    private String id;
    private String name;
    private int age;

}
