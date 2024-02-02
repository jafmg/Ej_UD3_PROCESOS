package ejerciciosTCP;

public class EjCalculadoraOperacionPaquete {
	
	private int operando1;
	private int operando2;
	private String operador;
	
	
	public EjCalculadoraOperacionPaquete(int operando1, 
			int operando2, String operador) {
		setOperando1(operando1);
		setOperando2(operando2);
		try {
			setOperador(operador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getOperando1() {
		return operando1;
	}
	public void setOperando1(int operando1) {
		this.operando1 = operando1;
	}
	public int getOperando2() {
		return operando2;
	}
	public void setOperando2(int operando2) {
		this.operando2 = operando2;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador)throws Exception {
		if(operador.matches("[+\\-*/]")) {
			this.operador = operador;
		}else {
			throw new Exception("Operador inválido");
		}
		
	}
	
	@Override
	public String toString() {
		return this.operando1 + " " + operador + " " + operando2;
	}
	
	

}
