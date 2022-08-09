package net.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.models.MessagesModel;

@Repository
public interface MessagesRepository extends JpaRepository<MessagesModel, Long>{
	public MessagesModel findByMessageCode(String messageCode);
}
