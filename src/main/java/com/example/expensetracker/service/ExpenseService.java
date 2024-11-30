package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseService.class);

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAllExpenses() {
        logger.info("Fetching all expenses");
        List<Expense> expenses = repository.findAll();
        logger.debug("Retrieved {} expenses", expenses.size());
        return expenses;
    }

    public Expense getExpenseById(Long id) {
        logger.info("Fetching expense with id: {}", id);
        Expense expense = repository.findById(id).orElse(null);
        if (expense == null) {
            logger.warn("Expense with id {} not found", id);
        } else {
            logger.debug("Retrieved expense: {}", expense);
        }
        return expense;
    }

    public Expense addExpense(Expense expense) {
        logger.info("Adding new expense: {}", expense);
        Expense savedExpense = repository.save(expense);
        logger.debug("Expense saved with id: {}", savedExpense.getId());
        return savedExpense;
    }

    public Expense updateExpense(Long id, Expense expense) {
        logger.info("Updating expense with id: {}", id);
        Expense existingExpense = repository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setCategory(expense.getCategory());
            Expense updatedExpense = repository.save(existingExpense);
            logger.debug("Expense updated: {}", updatedExpense);
            return updatedExpense;
        } else {
            logger.warn("Expense with id {} not found for update", id);
            return null;
        }
    }

    public void deleteExpense(Long id) {
        logger.info("Deleting expense with id: {}", id);
        try {
            repository.deleteById(id);
            logger.debug("Expense with id {} deleted successfully", id);
        } catch (Exception e) {
            logger.error("Error deleting expense with id {}", id, e);
        }
    }
}