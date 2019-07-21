package br.com.fztn.Calculator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fztn.Calculator.Exception.MathInvalid;

@RestController
public class CalculatorController {

	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping(value="subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		
		Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping(value="division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		
		if(isNumeric(numberTwo)) {
			if(convertToDouble(numberTwo) == 0) {
				throw new MathInvalid("Impossivel dividir por 0");
			}
		}
		
		Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping(value="multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		

		
		Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping(value="sqrt/{number}", method = RequestMethod.GET)
	public Double square(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		
		Double sum = Math.sqrt(convertToDouble(number));
		
		return sum;
	}
	
	@RequestMapping(value="pow/{number}", method = RequestMethod.GET)
	public Double power(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new MathInvalid("Digite um valor numérico");
		}
		
		Double sum = Math.pow(convertToDouble(number), 2);
		
		return sum;
	}

	private Double convertToDouble(String strNumber) {
		if(isNumeric(transformNumber(strNumber))) 
			return Double.parseDouble(transformNumber(strNumber));
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber.equals(null))
			return false;
		return transformNumber(strNumber).matches("[-+]?[0-9]*\\.?[0-9]");
	}
	
	private String transformNumber(String strNumber) {
		return strNumber.replaceAll(",", ".");
	}
}
