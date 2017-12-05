package arquitetura.ifrn;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer[] registradores = new Integer[11];
		registradores[10] = null;
		
		System.out.println("Digite valor para os registradores: ");
		
		//Lendo valor dos registradores
		
		for (int i = 0; i < registradores.length-1; i++) {
			System.out.print(i+1 + " <- ");
			registradores[i] = scanner.nextInt();
		}
		
		//Imprimindo valor dos registradores
		
		System.out.println();
		System.out.println("=== Pilha ===");
		for (int i = 0; i < registradores.length-1; i++) {
			System.out.println(registradores[i]);
		}
		int n = 9;
		while(n > 0){
			
			System.out.println();
			System.out.println("Digite a instrução desejada: ");
			String instrucao = scanner.next().trim().toUpperCase();
			
			if (instrucao.equals("ADD")) {
				registradores[0] += registradores[1];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("SUB")) {
				registradores[0] -= registradores[1];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("MUL")) {
				registradores[0] *= registradores[1];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("DIV")) {
				registradores[0] /= registradores[1];
				imprimirPilha(registradores);
			} 
			
			//LÓGICAS
			else if(instrucao.equals("AND")) {
				registradores[0] &= registradores[1];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("OR")) {
				registradores[0] |= registradores[1];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("NOT")) {
				registradores[0] = ~registradores[0];
				imprimirPilha(registradores);
				
			} else if(instrucao.equals("XOR")) {
				registradores[0] ^= registradores[1];
				imprimirPilha(registradores);
			}
			n--;
		}
		System.out.println(">> Fim do programa! <<");
		scanner.close();
	}
	
	static void imprimirPilha(Integer[] registradores){
		System.out.println();
		System.out.println("=== Pilha ===");
		System.out.println(registradores[0]);
		for (int k = 1; k < registradores.length-1; k++) {
			if (registradores[k] != null) {
				registradores[k] = registradores[k+1];
				if (registradores[k] != null) 
					System.out.println(registradores[k]);
			}
		}
	}
}
