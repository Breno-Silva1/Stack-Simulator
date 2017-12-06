package arquitetura.ifrn;

import java.util.Scanner;

public class Main {
	//Teste
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] regsNomes = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		String[] instrucaoCompleta = new String[2];
		String instrucao = null;
		Integer[] regs = new Integer[10];
		Integer[] pilha = new Integer[10];
		Integer[] operandos = new Integer[2];
		int r1 = 0, r2 = 0;

		System.out.println("Digite o valor para os registradores: ");
		for (int i = 0; i < regs.length; i++) {
			System.out.print(regsNomes[i] + " <- ");
			regs[i] = scanner.nextInt();
		}

		System.out.println("Digite instrução: ");
		instrucao = scanner.nextLine();
		instrucao = scanner.nextLine();

		while (!instrucao.equals("sair")) {

			if (instrucao.length() >= 5)
				instrucaoCompleta = instrucao.split(" ");
			else
				instrucaoCompleta[0] = instrucao;

			switch (instrucaoCompleta[0].trim().toUpperCase()) {
			case "POP":
				break;
			case "PUSH":
				switch (instrucaoCompleta[1].trim().toUpperCase()) {
				case "A":
					pushPilha(pilha, regs, 0);
					break;
				case "B":
					pushPilha(pilha, regs, 1);
					break;
				case "C":
					pushPilha(pilha, regs, 2);
					break;
				case "D":
					pushPilha(pilha, regs, 3);
					break;
				case "E":
					pushPilha(pilha, regs, 4);
					break;
				case "F":
					pushPilha(pilha, regs, 5);
					break;
				case "G":
					pushPilha(pilha, regs, 6);
					break;
				case "H":
					pushPilha(pilha, regs, 7);
					break;
				case "I":
					pushPilha(pilha, regs, 8);
					break;
				case "J":
					pushPilha(pilha, regs, 9);
					break;

				default:
					System.out.println(" >> Registrador não encontrado! << ");
					break;
				}
				break;
			case "ADD":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] + pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "SUB":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] - pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "MULT":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] * pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "DIV":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] / pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "AND":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] & pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "OR":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] | pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "XOR":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					r2 = operandos[1];
					pilha[r2] = pilha[r2] ^ pilha[r1];
					pilha[r1] = null;
				} else {
					System.out.println(" >> Não é possível executar esta instrução! << ");
				}
				break;
			case "NOT":
				operandos = operandosPilha(pilha);
				if(operandos[0] != null){
					r1 = operandos[0];
					pilha[r1] = ~pilha[r1];
				} else {
					pilha[0] = ~pilha[0];
				}
				break;
				
			default:
				System.out.println(" >> Instrução não reconhecida! << ");
				break;
			}
			imprimirPilha(pilha);
			
			System.out.println("Digite a instrução: ");
			instrucao = scanner.nextLine();
		}
		System.out.println(" >> Programa encerrado! << ");
		scanner.close();
	}
	
	static Integer[] operandosPilha(Integer[] pilha){
		Integer[] operandos = new Integer[2];
		int index = 0;
		for (int i = 0; i < pilha.length; i++) {
			if (pilha[i] == null) {
				index = i;
				break;
			} else {
				index = pilha.length;
			}
		}
		if ((index - 2) >= 0) {
			operandos[0] = (index - 1);
			operandos[1] = (index - 2);	
		} 
		return operandos;
	}
	
	static void pushPilha(Integer[] pilha, Integer[] regs, int index){
		for (int i = 0; i < pilha.length; i++) {
			if (pilha[i] == null) {
				pilha[i] = regs[index];
				break;
			}
		}
	}
	
	static void imprimirPilha(Integer[] registradores){
		System.out.println();
		System.out.println("=== Pilha ===");
		
		for (int i = registradores.length - 1; i >= 0; i--) {
			if (registradores[i] == null) 
				System.out.println(">> ");
			 else 
				System.out.println("-> " + registradores[i]);
		}
		System.out.println();
	}
}
