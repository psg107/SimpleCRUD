package com.sgpark.simplecrud.service;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class DrinkService {
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
    public ArrayList<Drink> getAllDrink() {
        //#warning 자동으로 매핑하는 방법이 없나?

        var drinks = this.drinkRepository.getAll()
                .stream()
                .map(x -> new Drink(){{
                    var id = x.getId();
                    var name = x.getName();
                    var price = x.getPrice();
                    var employeeId = x.getRegEmployeeId();

                    var employee = employeeRepository.getById(employeeId);
                    var employeeName = employee == null
                                                ? ""
                                                : employee.getName();

                    setDrinkId(id);
                    setName(name);
                    setPrice(price);
                    setRegEmployeeId(employeeId);
                    setRegEmployeeName(employeeName);
                }})
                .collect(Collectors.toCollection(ArrayList<Drink>::new));
        return drinks;
    }

    /**
     * 특정 음료 정보 가져오기
     * @param drinkId
     * @return
     */
    public Drink getDrink(int drinkId){
        var drinkInfo = this.getAllDrink().stream()
                .filter(x -> x.getDrinkId() == drinkId)
                .findFirst()
                .orElse(null);
        
        return drinkInfo;
    }

    /**
     * 음료 메뉴 추가
     * @param drink
     * @return
     */
    public boolean addDrink(AddDrink drink, int employeeId) {
        var drinkEntity = new DrinkEntity(drink.getName(), drink.getPrice(), employeeId);
        var inserted = this.drinkRepository.insert(drinkEntity);

        return inserted;
    }

    /**
     * 음료 정보 수정
     * @param drink
     * @param employeeId
     * @return
     */
    public boolean updateDrink(UpdateDrink drink, int employeeId) {
        var drinkId = drink.getDrinkId();
        var savedDrinkEntity = this.drinkRepository.getById(drinkId);

        if (savedDrinkEntity == null){
            return false;
        }

        var newDrinkEntity = new DrinkEntity(drink.getDrinkId(), drink.getName(), drink.getPrice(), employeeId);

        var updated = this.drinkRepository.update(newDrinkEntity);

        return updated;
    }

    /**
     * 음료 정보 삭제
     * @param drinkId
     * @return
     */
    public boolean deleteDrink(int drinkId) {
        var deleted = this.drinkRepository.delete(drinkId);

        return deleted;
    }
}
