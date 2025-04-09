package com.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.beans.Account;

public interface AccountsRepo extends JpaRepository<Account, Integer> {

}
