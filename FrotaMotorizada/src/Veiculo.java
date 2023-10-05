import java.io.Serializable;

public abstract class Veiculo implements Serializable {
	
	private String marca;
	private String modelo;
	private int ano;
	private double quilometragem;
	private String placa;
	
	public Veiculo(String marca, String modelo, int ano, double quilometragem, String placa) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.quilometragem = quilometragem;
		this.placa = placa;
	}
	
	public String toString() {
		String retorno = "";
		retorno += "Marca: "   + this.marca     + "\n";
		retorno += "Modelo: "  + this.modelo    + "\n";
		retorno += "Ano: "     + this.ano       + "\n";
		retorno += "Quilometragem: " + this.quilometragem + "km\n";
		retorno += "Placa: " + this.placa + "\n";
		return retorno;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
