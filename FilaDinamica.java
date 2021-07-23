public class FilaDinamica implements Enfileiravel {

	private int quantidade;
	private int tamanho;
	private NoDuplo ponteiroInicio;
	private NoDuplo ponteiroFim;

	public FilaDinamica() {
		this(10);
	}

	public FilaDinamica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

	//enfileirar
	public void enfileirar(Object dado){
		if(!estaCheia()) {
			NoDuplo noTemporario = new NoDuplo();
			noTemporario.setDado(dado);
			if (!estaVazia()) {
				ponteiroFim.setProximo(noTemporario);
			} else  {
				ponteiroInicio = noTemporario;
			}
			noTemporario.setAnterior(ponteiroFim);
			ponteiroFim = noTemporario;

			quantidade++;
		} else {
			System.out.println("Fila Cheia!");
		}
	}

	//desenfileirar
	public Object desenfileirar(){
		Object elementoInicio = null;
		if(!estaVazia()) {
			elementoInicio = ponteiroInicio.getDado();
			ponteiroInicio = ponteiroInicio.getProximo();
			if (quantidade > 1) {
				ponteiroInicio.setAnterior(null);
			}
			quantidade--;
		} else {
			System.out.println("Fila Vazia!");			
		}
		return elementoInicio;		
	}

	//espiar
	public Object espiar(){
		Object elementoInicio = null;
		if(!estaVazia()) {
			elementoInicio = ponteiroInicio.getDado();
		} else {
			System.out.println("Fila Vazia!");			
		}
		return elementoInicio;
	}

	//estaCheio
	public boolean estaCheia(){
		return (quantidade == tamanho);
	}

	//estaVazio
	public boolean estaVazia(){
		return (quantidade == 0);
	}

	//paraTexto
	public String imprimir(){
		NoDuplo noAuxiliar = ponteiroInicio;
		String resultado = "[";
		for (int i = 0; i < quantidade; i++) {
			if (i == quantidade-1) {
				resultado += noAuxiliar.getDado();
			} else {
				resultado += noAuxiliar.getDado() + ",";
			}
			noAuxiliar = noAuxiliar.getProximo();
		}
		return resultado + "]";
	}
}