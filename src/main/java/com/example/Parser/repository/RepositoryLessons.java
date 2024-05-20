package com.example.Parser.repository;

import com.example.Parser.model.LessonsUn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryLessons extends JpaRepository<LessonsUn,Long> {

}
