package gui.util;

public class CalculateTime {

	double totalMinutos = 0.0;
	double valor = 0.0;
	double minutos = 0.0;
	double horas = 0.0;	
	int m = 0;
	int h = 0;
	String result = null;
		
	public String calculateTime(double hS, double mS, double hE, double mE) {
		
		totalMinutos = ((hE * 60) + mE) - ((hS * 60) + mS); 
		
		valor = totalMinutos;
		minutos = valor % 60;
		m = (int) minutos;
		horas = (valor - minutos) / 60;	
		h = (int) horas;
		
		if((h == 0 && h < 10) && (m == 0 || m < 10)) {
			result = String.valueOf(h)+ "h " +String.valueOf(m) + "min";	
			return result;
		}
		else if(h > 9 && (m == 0 || m < 10)) {
			result = String.valueOf(h)+ "h " +String.valueOf(m) + "min";
			return result;
		}
		result = String.valueOf(h)+ "h " +String.valueOf(m) + "min";
		return result;
	}
}
