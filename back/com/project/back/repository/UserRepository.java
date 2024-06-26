package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
  boolean existsByUserEmailId(String userId);
  boolean existsByNickname(String nickname);

  UserEntity findByUserEmailId(String userEmailId);
  UserEntity findBySnsId(String snsId);
}
