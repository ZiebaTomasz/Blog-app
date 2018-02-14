package com.tomek.repository;

import com.tomek.domain.Writer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriterRepository extends CrudRepository<Writer, Long> {

    Writer findByFirstName(String firstName);

    List<Writer> findAll();
}
