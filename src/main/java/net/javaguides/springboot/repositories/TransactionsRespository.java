package net.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.models.TransactionsModel;

@Repository
public interface TransactionsRespository extends JpaRepository<TransactionsModel, Long>{

}
