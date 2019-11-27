package com.exercise.uidemo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	
	int dateDiff;
	
	@Value("${error.invaliddaterange}")
	private String errorMsg;
	
	@GetMapping("/")
    public String showForm(Model model) {
		
		InputForm frm = new InputForm();
		model.addAttribute("frm", frm);
        return "index";
    }
	
	/**
	 * 
	 * @param frm
	 * @param bindingResult
	 * @param model
	 * @return view: index.html, valid: return the difference in number of days, invalid: error message
	 */
	@PostMapping("/")
    public String validateDates(@Valid @ModelAttribute("frm") InputForm frm, BindingResult bindingResult, Model model) { // 
		
		
		 if (bindingResult.hasErrors()) {
			 model.addAttribute("invalidDate", true);
			 
			 if(bindingResult.hasGlobalErrors() && !(bindingResult.hasFieldErrors()))
			 		model.addAttribute("showRangeMsg", true);
			 		
	         return "index";
	        }

		 	model.addAttribute("dateDiff", DateUtil.getDateDiff(frm.getStartDate(), frm.getEndDate()));
	        return "index";
    }

}
