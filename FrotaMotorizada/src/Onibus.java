
public class Onibus extends Veiculo {

	private int assentos;
	
	public Onibus(String marca, String modelo, int ano, double quilometragem, String placa, int assentos) {
		super(marca, modelo, ano, quilometragem, placa);
		this.assentos = assentos;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	
	public String toString() {
		String retorno = super.toString();
		retorno += "Assentos: " + this.assentos + "\n";
		return retorno;
	}

}
