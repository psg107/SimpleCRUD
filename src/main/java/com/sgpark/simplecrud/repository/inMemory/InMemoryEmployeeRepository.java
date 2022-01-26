package com.sgpark.simplecrud.repository.inMemory;

import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.repository.inMemory.base.InMemoryRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("TestInMemoryEmployeeRepository")
public class InMemoryEmployeeRepository extends InMemoryRepositoryBase<EmployeeEntity> {

    public InMemoryEmployeeRepository() {
        var testList = new ArrayList<EmployeeEntity>();
        testList.add(new EmployeeEntity(0, "박상곤"));
        testList.add(new EmployeeEntity(1, "김상곤"));
        testList.add(new EmployeeEntity(2, "이상곤"));

        super.setInMemoryTestList(testList);
    }
}
