package com.company.usertask.service.spesification;

import com.company.usertask.domain.Account;
import com.company.usertask.dto.request.AccountCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import static com.company.usertask.service.spesification.PredicateUtil.applyLikePattern;

public class AccountSpecification implements Specification<Account> {

    private AccountCriteria accountCriteria;


    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates  = PredicateUtil.builder()
                .addNullSafety(accountCriteria.getUsername(),
                        username ->  cb.like(root.get("username"), applyLikePattern(username))
                )
                .addNullSafety(accountCriteria.getUsername(), username -> cb.equal(root.get("username"), username))
                .build();
        return null;
    }
}
