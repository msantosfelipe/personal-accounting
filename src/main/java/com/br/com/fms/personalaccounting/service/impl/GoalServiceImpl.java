package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Goal;
import com.br.com.fms.personalaccounting.repository.GoalRepository;
import com.br.com.fms.personalaccounting.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public Goal create(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal findById(String id) {
        Optional<Goal> goalEntity = goalRepository.findById(id);

        if (goalEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Goal not found");
        }

        return goalEntity.get();
    }


    @Override
    public Goal update(Goal goal) {
        Optional<Goal> goalEntity = goalRepository.findById(goal.getId());

        if (goalEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Account not found");
        }

        return goalRepository.save(goal);
    }

    @Override
    public void delete(String id) {
        Optional<Goal> goal = goalRepository.findById(id);

        if (goal.isPresent()) {
            goalRepository.delete(goal.get());
        }
    }
}
