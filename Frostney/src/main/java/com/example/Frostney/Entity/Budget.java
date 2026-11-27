package com.example.Frostney.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(
    name = "Budget",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = {"user_id", "budget_month"}
        )
    }
)
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budget_id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal budget_amount;

    // Store the first day of the budget month
    @Column(name = "budget_month", nullable = false)
    private LocalDate budgetMonth;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Budget() {}

    public Long getBudget_id() {
        return budget_id;
    }

    public BigDecimal getBudget_amount() {
        return budget_amount;
    }

    public void setBudget_amount(BigDecimal budget_amount) {
        this.budget_amount = budget_amount;
    }

    public LocalDate getBudgetMonth() {
        return budgetMonth;
    }

    public void setBudgetMonth(LocalDate budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}