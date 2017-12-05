package arquitetura.ifrn;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer[] registradores = new Integer[11];
		registradores[10] = null;
		String instrucao;
		
		System.out.println("Digite valor para os registradores: ");
		
		//LENDO VALOR REGS
		for (int i = 0; i < registradores.length-1; i++) {
			System.out.print(i+1 + " <- ");
			registradores[i] = scanner.nextInt();
		}
		
		//IMPRIMINDO VALOR REGS
		System.out.println();
		System.out.println("=== Pilha ===");
		for (int i = 0; i < registradores.length-1; i++) {
			System.out.println(registradores[i]);
		}
		
		int n = 9;
		while(n > 0){
			System.out.println();
			System.out.println("Digite a instrução desejada: ");
			instrucao = scanner.nextLine().trim().toUpperCase();
			
			instrucoesAritimeticas(registradores, instrucao);
			
			instrucoesLogicas(registradores, instrucao);
			
			instrucoesTransferencia(registradores, instrucao);
			
			n--;
		}
		System.out.println(">> Fim do programa! <<");
		scanner.close();
	}
	
	static void instrucoesTransferencia(Integer[] registradores, String instrucao){
		
		if (instrucao.length() >= 5) {
			String[] instrucaoCompleta = instrucao.split(" ");
			
			if(instrucaoCompleta[0].equals("POP")) {
				if (instrucaoCompleta[1].equals("A")) {
					
				} else if (instrucaoCompleta[1].equals("A")) {
					registradores[0] = null;
				} else if (instrucaoCompleta[1].equals("B")) {
					registradores[1] = null;
				} else if (instrucaoCompleta[1].equals("C")) {
					registradores[2] = null;
				} else if (instrucaoCompleta[1].equals("D")) {
					registradores[3] = null;
				} else if (instrucaoCompleta[1].equals("E")) {
					registradores[4] = null;
				} else if (instrucaoCompleta[1].equals("F")) {
					registradores[5] = null;
				} else if (instrucaoCompleta[1].equals("G")) {
					registradores[6] = null;
				} else if (instrucaoCompleta[1].equals("H")) {
					registradores[7] = null;
				} else if (instrucaoCompleta[1].equals("I")) {
					registradores[8] = null;
				} else if (instrucaoCompleta[1].equals("J")) {
					registradores[9] = null;
				}
				imprimirPilha(registradores);
				
			} else if(instrucaoCompleta[0].equals("PUSH")) {
				registradores[0] |= registradores[1];
				imprimirPilha(registradores);
				
			}
		}
	}
	
	static void instrucoesLogicas(Integer[] registradores, String instrucao){
		if(instrucao.equals("AND")) {
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
	}
	
	static void instrucoesAritimeticas(Integer[] registradores, String instrucao){
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
	}
	
	static void imprimirPilha(Integer[] registradores){
		System.out.println();
		System.out.println("=== Pilha ===");
		if (registradores[0] != null) {
			System.out.println(registradores[0]);
		}
		
		for (int k = 1; k < registradores.length-1; k++) {
			if (registradores[k] != null) {
				registradores[k] = registradores[k+1];
				if (registradores[k] != null) 
					System.out.println(registradores[k]);
			}
		}
	}
}
