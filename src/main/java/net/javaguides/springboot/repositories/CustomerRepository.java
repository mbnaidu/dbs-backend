package net.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.models.CustomerModel;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {

}
