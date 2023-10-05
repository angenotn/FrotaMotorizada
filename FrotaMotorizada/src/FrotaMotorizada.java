import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FrotaMotorizada {
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	public FrotaMotorizada() {
		this.veiculos = new ArrayList<Veiculo>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Automovel leAutomovel (){

		String [] valores = new String [3];
		String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "Motor"};
		valores = leValores (nomeVal);

		int ano = this.retornaInteiro(valores[2]);
		double quilometragem = this.retornaDouble(valores[3]);	
		double motor = this.retornaDouble(valores[5]);

		Automovel automovel = new Automovel (valores[0], valores[1], ano, quilometragem, valores[4], motor);
		return automovel;
	}

	public Caminhao leCaminhao (){

		String [] valores = new String [3];
		String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "Carga Máxima"};
		valores = leValores (nomeVal);

		int ano = this.retornaInteiro(valores[2]);
		double quilometragem = this.retornaDouble(valores[3]);
		double cargaMax = this.retornaDouble(valores[5]);		

		Caminhao caminhao = new Caminhao (valores[0],valores[1],ano, quilometragem, valores[4],cargaMax);
		return caminhao;
	}
	
	public Onibus leOnibus (){

		String [] valores = new String [3];
		String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "Assentos"};
		valores = leValores (nomeVal);

		int ano = this.retornaInteiro(valores[2]);
		double quilometragem = this.retornaDouble(valores[3]);
		int assentos = this.retornaInteiro(valores[5]);

		Onibus onibus = new Onibus (valores[0], valores[1], ano, quilometragem, valores[4], assentos);
		return onibus;
	}
	
	public void menuFrota (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Frota Motorizada\n" +
					"Opções:\n" + 
					"1. Entrar Veículos\n" +
					"2. Exibir Veículos\n" +
					"3. Limpar Veículoss\n" +
					"4. Gravar Veículos\n" +
					"5. Recuperar Veículos\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);
			
			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Veiculos\n" +
						"Opções:\n" + 
						"1. Automóvel\n" +
						"2. Caminhão\n" +
						"3. Ônibus";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: veiculos.add((Veiculo)leAutomovel());
				break;
				case 2: veiculos.add((Veiculo)leCaminhao());
				break;
				case 3: veiculos.add((Veiculo)leOnibus());
				break;	
				default: 
					JOptionPane.showMessageDialog(null,"Veículo para entrada NÃO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com veículos primeiramente");
					break;
				}				
				String dados = "";
				for (int i=0; i < veiculos.size(); i++)	{					
					dados += veiculos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com veículos primeiramente");
					break;
				}
				veiculos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com veículos primeiramente");
					break;
				}
				salvaVeiculos(veiculos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				veiculos = recuperaVeiculos();
				if (veiculos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo FROTA MOTORIZADA");
				break;
			}
		
		} while (opc1 != 9);
	
	}
	
	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}	
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n�mero inteiro.");
		}
		return Integer.parseInt(entrada);	
	}
	
	private boolean doubleValido (String s) {
		try {
			Double.parseDouble(s); // Método estático, que tenta transformar uma string em double
			return true;
		} catch (NumberFormatException e) { // Não conseguiu transformar em double e gera erro
			return false;
		}
	}
	public double retornaDouble(String entrada) { // retorna um valor inteiro
		float numFloat;
		
		//Enquanto não for possível converter o valor de entrada para FLOAT, permanece no loop
		while (!this.doubleValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorretor!\n\nDigite um número decimal.");			
		}
		return Double.parseDouble(entrada);
	}
	
	public void salvaVeiculos (ArrayList<Veiculo> veiculos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("frotaMotorizada.dados"));
			for (int i=0; i < veiculos.size(); i++)
				outputStream.writeObject(veiculos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Veiculo> recuperaVeiculos (){
		ArrayList<Veiculo> mamiferosTemp = new ArrayList<Veiculo>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("frotaMotorizada.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Veiculo) {
					mamiferosTemp.add((Veiculo) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com veículos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return mamiferosTemp;
		}
	}
	
	
		
	public static void main(String[] args) {
		
		FrotaMotorizada fm = new FrotaMotorizada();
		
		fm.menuFrota();

	}

}
