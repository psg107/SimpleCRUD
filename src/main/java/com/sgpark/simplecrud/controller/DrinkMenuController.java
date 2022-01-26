package com.sgpark.simplecrud.controller;

import com.sgpark.simplecrud.model.DrinkInfo;
import com.sgpark.simplecrud.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DrinkMenuController {

    @Autowired
    private DrinkService drinkService;

    /**
     * 조회
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        var drinks = drinkService.getAllDrinkInfo();

        model.addAttribute("drinks", drinks);
        return "index";
    }

    /**
     * 등록
     * @param drinkInfo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Insert")
    public RedirectView insert(DrinkInfo drinkInfo) {
        //#warning 데이터 검증은 어떻게 처리하지?
        //#warning DrinkInfo 대신 다르게 처리..편의상 같은거씀

        var added = this.drinkService.addDrink(drinkInfo);
        
        if (added == false){
            //#warning 실패했다고 화면에 적당히 출력해주기
        }

        return new RedirectView("/");
    }

    /**
     * 수정
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Update")
    public void update(DrinkInfo drinkInfo) throws Exception {
        //#warning 데이터 검증은 어떻게 처리하지?
        //#warning DrinkInfo 대신 다르게 처리..편의상 같은거씀

        throw new Exception("만들어야해");
    }

    /**
     * 삭제
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, path = "/Delete")
    public void delete(int id) throws Exception {
        throw new Exception("만들어야해");
    }
}
