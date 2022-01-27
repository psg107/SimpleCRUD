package com.sgpark.simplecrud.controller;

import com.sgpark.simplecrud.model.drink.AddDrink;
import com.sgpark.simplecrud.model.drink.UpdateDrink;
import com.sgpark.simplecrud.service.DrinkServiceInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DrinkMenuController {

    /**
     * #warning 현재 로그인한 사원번호 임시 처리..
     */
    private final int CURRENT_LOGIN_EMPLOYEE_ID = 1;

    @Autowired
    private DrinkServiceInMemory drinkService;

    /**
     * 조회 페이지로 이동
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index(Model model){
        var drinks = this.drinkService.getAllDrink();

        model.addAttribute("drinks", drinks);

        return "index";
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
        var added = this.drinkService.addDrink(drink, CURRENT_LOGIN_EMPLOYEE_ID);
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
        var drinkInfo = this.drinkService.getDrink(id);
        if (drinkInfo == null) {
            return "index";
        }

        model.addAttribute("drink", drinkInfo);

        return "detail";
    }

    /**
     * 수정
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Update")
    public RedirectView update(UpdateDrink drink) throws Exception {
        var updated = this.drinkService.updateDrink(drink, CURRENT_LOGIN_EMPLOYEE_ID);
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
