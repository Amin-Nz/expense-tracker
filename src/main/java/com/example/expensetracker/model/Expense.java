package com.example.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents an expense in the expense tracker application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {

    /**
     * The unique identifier for the expense.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A brief description of the expense.
     */
    private String description;

    /**
     * The amount of money spent on the expense.
     */
    private Double amount;

    /**
     * The category of the expense (e.g., Food, Transportation).
     */
    private String category;
}