package com.cognizant.repository;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.model.BookModel;

@Transactional
public interface BookRepository extends JpaRepository<BookModel, Integer> {

	@Query(value = "select * from book where id=:id", nativeQuery = true)
	public Optional<BookModel> findById(@Param("id") Long id);

	@Modifying
	@Query(value = "DELETE FROM book  WHERE id = :id", nativeQuery = true)
	public int deleteById(@Param("id") Long id);
}
