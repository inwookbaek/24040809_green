package com.lec.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.board.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}