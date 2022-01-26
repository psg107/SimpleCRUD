package com.sgpark.simplecrud.service;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.model.DrinkInfo;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class DrinkService {
    /**
     * 직원을 찾을 수 없음
     */
    private static final String EMPLOYEE_NAME_NOT_FOUND = "-------";

    @Autowired
    @Qualifier("TestInMemoryDrinkRepository")
//@Qualifier("MybatisDrinkRepository")
    private IRepositoryBase<DrinkEntity> drinkRepository;

    @Autowired
    @Qualifier("TestInMemoryEmployeeRepository")
//@Qualifier("MybatisEmployeeRepository")
    private IRepositoryBase<EmployeeEntity> employeeRepository;

    /**
     * 모든 음료 정보 가져오기
     * @return
     */
    public ArrayList<DrinkInfo> getAllDrinkInfo() {
        //#warning 자동으로 매핑하는 방법이 없나?

        var drinks = this.drinkRepository.getAll()
                .stream()
                .map(x -> new DrinkInfo(){{
                    var id = x.getId();
                    var name = x.getName();
                    var price = x.getPrice();
                    var employeeId = x.getRegEmployeeId();

                    var employee = employeeRepository.getById(employeeId);
                    var employeeName = employee == null
                                                ? EMPLOYEE_NAME_NOT_FOUND
                                                : employee.getName();

                    setDrinkId(id);
                    setName(name);
                    setPrice(price);
                    setRegEmployeeId(employeeId);
                    setRegEmployeeName(employeeName);
                }})
                .collect(Collectors.toCollection(ArrayList<DrinkInfo>::new));
        return drinks;
    }

    /**
     * 음료 메뉴 추가
     * @param drinkInfo
     * @return
     */
    public boolean addDrink(DrinkInfo drinkInfo) {
        var drinkEntity = new DrinkEntity(0, drinkInfo.getName(), drinkInfo.getPrice(), drinkInfo.getRegEmployeeId());
        var inserted = this.drinkRepository.insert(drinkEntity);

        return inserted;
    }
}
