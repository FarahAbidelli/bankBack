package com.pfe.Bank.repository;


import com.pfe.Bank.model.FinancialData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<FinancialData,Long> {
}
