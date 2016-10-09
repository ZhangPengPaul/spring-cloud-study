package com.paulzhang.cloud.study.repository;


import com.paulzhang.cloud.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PaulZhang on 2016/10/9.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
