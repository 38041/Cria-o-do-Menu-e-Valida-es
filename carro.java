package app.model;

public class Carro {
    
    private String modelo;   //* Modelo do carro */
    private int ano;         //* Ano de fabricação */
    private double velocidade;  //* Velocidade em km/h */

    // Construtor com modelo e ano
    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0.0;
    }

    // Construtor padrão
    public Carro() {
        this.modelo = "Fusca";
        this.ano = 2000;
        this.velocidade = 0.0;
    }

    // Construtor completo
    public Carro(String modelo, int ano, double velocidade) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = velocidade;
    }

    // Método que exibe informações do carro
    public void exibirInfo() {
        System.out.println("Carro: " + modelo + " | Ano: " + ano + " | Velocidade: " + velocidade + " km/h");
    }


    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getVelocidade() {
        return velocidade;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "Carro [modelo=" + modelo + ", ano=" + ano + ", velocidade=" + velocidade + " km/h]";
    }
}