package net.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.models.BankModel;


@Repository
public interface BankRepository extends JpaRepository<BankModel, Long>{
	public BankModel findByBic(String bic);
}
