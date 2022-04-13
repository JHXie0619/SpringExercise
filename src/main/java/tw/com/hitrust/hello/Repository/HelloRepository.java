package tw.com.hitrust.hello.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.hitrust.hello.entity.HelloEntity;

public interface HelloRepository extends JpaRepository<HelloEntity, Integer> {
}
