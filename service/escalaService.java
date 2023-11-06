package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Escala;

public class escalaService {

	static private List<String[]> listaDias = new ArrayList<>();
	
	public static void gerarEslaca(Escala escala) {
		
		LocalDate data = LocalDate.of(2023, escala.getMes(), 1);
		int nDias = data.lengthOfMonth();
		
		String[] cabecalho = new String[nDias +1];
		cabecalho[0] = "NOME";
		for(int i=1; i < cabecalho.length; i++) {
			cabecalho[i] = Integer.toString(i);
		}
		listaDias.add(cabecalho);
		cabecalho = null;
		
		escala.getEscalacao().forEach(x -> {
			String[] escalaDiaria = new String[nDias + 1];
			escalaDiaria[0] = x.getAgente().getName();
			
			escala.getAlteracoes().forEach(a -> {
				
				if(a.getReAgente() != x.getAgente().getRe()) return; 
				
				int dia = a.getDateChange().getDayOfMonth();
				if(x.getDiasDeTrabalho() % 2 ==0 & dia % 2 ==0) {
					escalaDiaria[dia] = "F";
				}else if (x.getDiasDeTrabalho() % 2 ==0 & dia % 2 !=0){
					escalaDiaria[dia] = "S";
				} else if(x.getDiasDeTrabalho() % 2 !=0 & dia % 2 ==0) {
					escalaDiaria[dia] = "S";
				}else {
					escalaDiaria[dia] = "F";
				}
				
				if(a.getDateReposition() != null) {
					int diaR = a.getDateReposition().getDayOfMonth();
					if(x.getDiasDeTrabalho() % 2 ==0 & diaR % 2 ==0) {
						escalaDiaria[diaR] = "F";
					}else if (x.getDiasDeTrabalho() % 2 ==0 & diaR % 2 !=0){
						escalaDiaria[diaR] = "S";
					} else if(x.getDiasDeTrabalho() % 2 !=0 & diaR % 2 ==0) {
						escalaDiaria[diaR] = "S";
					}else {
						escalaDiaria[diaR] = "F";
					}
				}
			});
			
			for (int i=1; i < escalaDiaria.length;i++) {
				
				if (escalaDiaria[i] !=null) continue;
				
				if(x.getDiasDeTrabalho() % 2 == 0) {
					String resul = (i % 2 ==0)? "S":"F"; 
					escalaDiaria[i] = resul;
				}else {
					String resul = (i % 2 ==0)? "F":"S"; 
					escalaDiaria[i] = resul;
				}		
			}
			listaDias.add(escalaDiaria);
		});
		
		listaDias.forEach(x -> System.out.println(Arrays.toString(x)));
	}
}
