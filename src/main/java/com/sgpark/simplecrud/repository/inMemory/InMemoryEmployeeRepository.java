package com.sgpark.simplecrud.repository.inMemory;

import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.repository.inMemory.base.InMemoryRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("TestInMemoryEmployeeRepository")
public class InMemoryEmployeeRepository extends InMemoryRepositoryBase<EmployeeEntity> {

    @Override
    public ArrayList<EmployeeEntity> getInMemoryTestList() {
        var testList = new ArrayList<EmployeeEntity>(List.of(
            new EmployeeEntity(0, "박상곤"),
            new EmployeeEntity(1, "김상곤"),
            new EmployeeEntity(2, "이상곤")
        ));

        return testList;
    }
}
