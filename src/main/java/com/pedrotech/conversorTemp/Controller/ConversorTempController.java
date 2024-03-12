package com.pedrotech.conversorTemp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversorTempController {
	
	@GetMapping("/")
	public ModelAndView conversorTemp() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("conversorTemp");
		return modelAndView;
	}
	
	@PostMapping("/calculate")
	public String calculate(@RequestParam("temp") double temp,
							@RequestParam("operacao") String operacao,
							Model model) {

		double result = 0;
		switch (operacao) {
			case "C->F":
				result = (temp * 1.8) + 32;
				break;
			case "C->K":
				result = temp + 273;
				break;
			case "F->C":
				result = (temp - 32) / 1.8;
				break;
			case "F->K":
				result = (temp - 32) * 5/9 +273;
				break;
			case "K->C":
				result = temp - 273;
				break;
			case "K->F":
				result = (temp - 273) * 1.8 + 32;
				break;
			default:
				break;
		}

		model.addAttribute("result" ,result);
		return "conversorTemp";
	}
	
}
