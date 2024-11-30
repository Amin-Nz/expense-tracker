package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Expense} entities.
 * Provides CRUD operations and query methods for expenses.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // No additional methods are defined here;
    // JpaRepository provides basic CRUD operations out of the box.
}