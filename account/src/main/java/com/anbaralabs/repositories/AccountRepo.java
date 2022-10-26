package com.anbaralabs.repositories;

import com.anbaralabs.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Ayoub Anbara
 */
public interface AccountRepo extends JpaRepository<Account,Long> {
    // =?1
    @Query("SELECT a.id, a.balance, a.type, a.currency,a.createdDate FROM Account a WHERE a.id=:id")
    Optional<Account> findById(@Param("id") Long id);

    @Query(value = "SELECT new Account (a.id, a.balance,a.currency, a.type,a.createdDate) FROM Account a")
    List<Account> findAll();

//    @Query(value = "SELECT a.id, a.balance, a.type, a.currency FROM Account a WHERE a.type=:type")
//    Page<Account> findAllByType(String type,Pageable pageable); // todo use pageable

    @Modifying
    @Transactional
    @Query("UPDATE Account a set a.deleted=true where a.id=:id")
    void deleteById(@Param("id") Long id);


}
