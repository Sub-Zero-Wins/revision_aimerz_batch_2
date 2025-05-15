package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.beans.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

	List<Account> findAllByTxnId(int userId);

}
