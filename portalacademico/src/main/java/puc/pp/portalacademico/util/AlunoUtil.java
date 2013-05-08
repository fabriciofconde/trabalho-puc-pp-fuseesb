package puc.pp.portalacademico.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlunoUtil {

	public static String obterNomeAlunoAleatorio() {
		String[] nomes = new String[] {"Douglas", "Eduardo", "Fabricio", "Fernando", "Marinete"};
		List<String> lista = Arrays.asList(nomes);
		Collections.shuffle(lista);
		
		return lista.get(0);
	}
	
}
