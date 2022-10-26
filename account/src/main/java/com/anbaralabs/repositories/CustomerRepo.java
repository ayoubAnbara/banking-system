package com.anbaralabs.repositories;

import com.anbaralabs.entities.Account;
import com.anbaralabs.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Ayoub Anbara
 */
public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
