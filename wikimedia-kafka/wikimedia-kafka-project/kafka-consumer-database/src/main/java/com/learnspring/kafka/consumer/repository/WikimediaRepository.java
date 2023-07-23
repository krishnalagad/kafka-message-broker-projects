package com.learnspring.kafka.consumer.repository;

import com.learnspring.kafka.consumer.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {

}
