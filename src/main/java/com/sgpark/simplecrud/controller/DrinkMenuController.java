package com.sgpark.simplecrud.controller;

import com.sgpark.simplecrud.model.common.PagingList;
import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.Drink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.service.base.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class DrinkMenuController {

    /**
     * #warning 현재 로그인한 사원번호 임시 처리..
     */
    private final int CURRENT_LOGIN_EMPLOYEE_ID = 1;

    /**
     * #warning 페이지 사이즈 임시 처리..
     */
    private final int PAGE_SIZE = 5;

    private final IDrinkService drinkService;

    @Autowired
    public DrinkMenuController(@Qualifier("DrinkServiceMybatis")IDrinkService drinkService) {
        this.drinkService = drinkService;
    }

//    @Autowired
//    public DrinkMenuController(
//            @Qualifier("DrinkServiceInMemory")IDrinkService drinkService) {
//        this.drinkService = drinkService;
//    }

    /**
     * 조회 페이지로 이동
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/", "/{page}"})
    public String index(@PathVariable(required = false) Optional<Integer> page, Model model){
        try{
            var pageNumber = 1;

            if (page.isPresent()){
                pageNumber = page.get();
            }

            PagingList<Drink> pagingDrinks = this.drinkService.getDrinksWithPaging(pageNumber, PAGE_SIZE);
            var currentPageNumber = pagingDrinks.getCurrentPageNumber();
            var maxPageNumber = pagingDrinks.getMaxPageNumber();
            var startPageNumber = pagingDrinks.getStartPageNumber();
            var endPageNumber = pagingDrinks.getEndPageNumber();
            var showPreviousButton = pagingDrinks.isShowPreviousButton();
            var showNextButton = pagingDrinks.isShowNextButton();
            var drinks = pagingDrinks.getItems();

            model.addAttribute("currentPageNumber", currentPageNumber);
            model.addAttribute("maxPageNumber", maxPageNumber);
            model.addAttribute("startPageNumber", startPageNumber);
            model.addAttribute("endPageNumber", endPageNumber);
            model.addAttribute("showPreviousButton", showPreviousButton);
            model.addAttribute("showNextButton", showNextButton);
            model.addAttribute("drinks", drinks);

            return "index";
        }catch (Exception ex){
            return "redirect:/";
        }
    }

    /**
     * 등록 페이지로 이동
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/Insert")
    public String insert() throws Exception {
        return "insert";
    }

    /**
     * 등록
     * @param drink
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Insert")
    public RedirectView insert(AddDrink drink) throws Exception {
        drink.setRegEmployeeId(CURRENT_LOGIN_EMPLOYEE_ID);

        var added = this.drinkService.addDrink(drink);
        if (added == false) {
            throw new Exception("등록 오류");
        }

        return new RedirectView("/");
    }

    /**
     * 상세보기 페이지로 이동
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/Detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        var drink = this.drinkService.getDrink(id);
        if (drink == null) {
            return "index";
        }

        model.addAttribute("drink", drink);

        return "detail";
    }

    /**
     * 수정
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Update")
    public RedirectView update(UpdateDrink drink) throws Exception {
        drink.setRegEmployeeId(CURRENT_LOGIN_EMPLOYEE_ID);;

        var updated = this.drinkService.updateDrink(drink);
        if (updated == false) {
            throw new Exception("수정 오류");
        }

        return new RedirectView("/");
    }

    /**
     * 삭제
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/Delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id) {
        var deleted = this.drinkService.deleteDrink(id);
        if (deleted == false){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
