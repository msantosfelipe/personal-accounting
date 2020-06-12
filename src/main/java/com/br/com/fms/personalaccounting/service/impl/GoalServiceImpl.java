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

    private static final String GOAL_NOT_FOUND = "Goal not found";

    @Override
    public Goal create(Goal goal) {
        goal.setId(null);
        return goalRepository.save(goal);
    }

    @Override
    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal findById(String id) {
        Optional<Goal> entity = goalRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, GOAL_NOT_FOUND);
        }

        return entity.get();
    }


    @Override
    public Goal update(Goal goal) {
        Optional<Goal> entity = goalRepository.findById(goal.getId());

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, GOAL_NOT_FOUND);
        }

        return goalRepository.save(goal);
    }

    @Override
    public void delete(String id) {
        Optional<Goal> entity = goalRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, GOAL_NOT_FOUND);
        }

        goalRepository.delete(entity.get());
    }
}
