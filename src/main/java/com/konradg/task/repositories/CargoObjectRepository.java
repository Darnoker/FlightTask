package com.konradg.task.repositories;

import com.konradg.task.models.CargoObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoObjectRepository extends CrudRepository<CargoObject,Long> {
}
