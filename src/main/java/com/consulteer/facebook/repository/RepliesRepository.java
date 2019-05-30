package com.consulteer.facebook.repository;

import com.consulteer.facebook.entity.Replies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliesRepository extends JpaRepository <Replies,Long> {


}
