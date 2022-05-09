package com.konradg.task.repositories;

import com.konradg.task.models.BaggageObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageObjectRepository extends CrudRepository<BaggageObject,Long> {
}
