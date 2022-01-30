package com.sgpark.simplecrud.service;

import com.sgpark.simplecrud.entity.DrinkEntity;
import com.sgpark.simplecrud.entity.EmployeeEntity;
import com.sgpark.simplecrud.model.common.PagingList;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.modelBuilder.DrinkListBuilder;
import com.sgpark.simplecrud.repository.base.IRepositoryBase;
import com.sgpark.simplecrud.service.base.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Qualifier("DrinkServiceInMemory")
public class DrinkServiceInMemory implements IDrinkService {

    private final IRepositoryBase<DrinkEntity> drinkRepository;
    private final IRepositoryBase<EmployeeEntity> employeeRepository;

    @Autowired
    public DrinkServiceInMemory(
            @Qualifier("TestInMemoryDrinkRepository")IRepositoryBase<DrinkEntity> drinkRepository,
            @Qualifier("TestInMemoryEmployeeRepository")IRepositoryBase<EmployeeEntity> employeeRepository) {
        this.drinkRepository = drinkRepository;
        this.employeeRepository = employeeRepository;
    }

    /**
     * 모든 음료 정보 가져오기
     * @return
     */
    @Override
    public ArrayList<Drink> getAllDrinks() {
        var drinkEntities = this.drinkRepository.getAll();
        var employeeEntities = this.employeeRepository.getAll();

        var drinks = new DrinkListBuilder()
                .setDrinkEntities(drinkEntities)
                .setEmployeeEntities(employeeEntities)
                .buildDrinkList();

        return drinks;
    }

    /**
     * 음료 정보 가져오기 (페이징)
     * @return
     */
    @Override
    public PagingList<Drink> getDrinksWithPaging(int pageNumber, int pageSize) {
        var drinkEntities = this.drinkRepository.getWithPaging(pageNumber, pageSize);
        var employeeEntities = this.employeeRepository.getAll();

        var drinks = new DrinkListBuilder()
                .setDrinkEntities(drinkEntities)
                .setEmployeeEntities(employeeEntities)
                .setPageNumber(pageNumber)
                .setPageSize(pageSize)
                .buildDrinkList();

        var pagingDrinks = new PagingList<Drink>(pageNumber, drinkEntities.size(), drinks);

        return pagingDrinks;
    }

    /**
     * 특정 음료 정보 가져오기
     * @param drinkId
     * @return
     */
    @Override
    public Drink getDrink(int drinkId) {
        var drinkInfo = this.getAllDrinks().stream()
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
    @Override
    public boolean addDrink(AddDrink drink) {
        var drinkEntity = new DrinkEntity(drink.getName(), drink.getPrice(), drink.getRegEmployeeId());
        var inserted = this.drinkRepository.insert(drinkEntity);

        return inserted;
    }

    /**
     * 음료 정보 수정
     * @param drink
     * @return
     */
    @Override
    public boolean updateDrink(UpdateDrink drink) {
        var drinkId = drink.getDrinkId();
        var savedDrinkEntity = this.drinkRepository.getById(drinkId);

        if (savedDrinkEntity == null){
            return false;
        }

        var newDrinkEntity = new DrinkEntity(drink.getDrinkId(), drink.getName(), drink.getPrice(), drink.getRegEmployeeId());

        var updated = this.drinkRepository.update(newDrinkEntity);

        return updated;
    }

    /**
     * 음료 정보 삭제
     * @param drinkId
     * @return
     */
    @Override
    public boolean deleteDrink(int drinkId) {
        var deleted = this.drinkRepository.delete(drinkId);

        return deleted;
    }
}
