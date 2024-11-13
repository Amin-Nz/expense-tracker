package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense existingExpense = repository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setCategory(expense.getCategory());
            return repository.save(existingExpense);
        }
        return null;
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}
