package net.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.helpers.BankHelper;


@Repository
public interface BankRepository extends JpaRepository<BankHelper, String>{

}
