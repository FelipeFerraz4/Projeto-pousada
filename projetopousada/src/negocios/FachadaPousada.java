package negocios;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import dados.repositoriosquartos.RepositorioQuartoArrayList;
import exceptionpousada.DeletarGerentePrincipalException;
import exceptionpousada.PessoaJaExisteException;
import exceptionpousada.PessoaNaoEncontradoException;
import exceptionpousada.QuartoJaExisteException;
import exceptionpousada.QuartoNaoEncontradoException;


public class FachadaPousada {
	
	private NegocioGerente adm;
	private NegocioCliente user;
	
	public FachadaPousada() {
		IRepositorioPessoa repositorioPessoa = new RepositorioPessoaArrayList();
		IRepositorioQuarto repositorioQuarto = new RepositorioQuartoArrayList();
		this.adm = new NegocioGerente(repositorioPessoa, repositorioQuarto);
		this.user = new NegocioCliente(repositorioPessoa, repositorioQuarto);
	}	
	public void cadastrarNovoCliente(String nome, String cpf, String senha) 
			throws PessoaJaExisteException, ArrayIndexOutOfBoundsException{
		adm.cadastrarNovoCliente(nome, cpf, senha);
	}
	public void cadastrarNovoGerente(String nome, String cpf, String senha) 
			throws PessoaJaExisteException, ArrayIndexOutOfBoundsException{
		adm.cadastrarNovoGerente(nome, cpf, senha);
	}
	public void cadastrarQuartoNormal(int numeroQuarto) throws ArrayIndexOutOfBoundsException,
	QuartoJaExisteException{
		adm.cadastrarQuartoNormal(numeroQuarto);
	}
	public void cadastrarQuartoPrime(int numeroQuarto) throws ArrayIndexOutOfBoundsException,
	QuartoJaExisteException{
		adm.cadastrarQuartoPrime(numeroQuarto);
	}
	public void deletarPessoa(String cpf) throws PessoaNaoEncontradoException,
	DeletarGerentePrincipalException{
		adm.deletarPessoa(cpf);
	}
	public void deletarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException{
		adm.deletarQuarto(numeroQuarto, tipoQuarto);
	}
	public int buscarPessoa(String cpf) throws PessoaNaoEncontradoException{
		return adm.buscarPessoa(cpf);
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException{
		return adm.buscarQuarto(numeroQuarto, tipoQuarto);
	}
	public void modificarPessoaNome(int indexPessoa, String nome) {
		adm.modificarPessoaNome(indexPessoa, nome);
	}
	public void modificarPessoaSenha(int indexPessoa, String senha) {
		adm.modificarPessoaSenha(indexPessoa, senha);
	}
	public void modificarQuartoConsumo(int indexQuarto, float consumo) {
		adm.modificarQuartoConsumo(indexQuarto, consumo);
	}
	public void modificarQuartoCapacidade(int indexQuarto, int capacidade) {
		adm.modificarQuartoCapacidade(indexQuarto, capacidade);
	}
	public void modificarQuartoPrecoQuarto(int indexQuarto, float precoQuarto) {
		adm.modificarQuartoPrecoQuarto(indexQuarto, precoQuarto);
	}
	public void modificarQuartoOcupado(int indexQuarto) {
		adm.modificarQuartoOcupado(indexQuarto);
	}
	public int verificarSenha(int indexPessoa, String senha) {
		return adm.verificarSenha(indexPessoa, senha);
	}
	public int verificarTipoPessoa(int indexPessoa) {
		return adm.verificarTipoPessoa(indexPessoa);
	}
	public String toStringPessoa(int indexPessoa) {
		return adm.toStringPessoa(indexPessoa);
	}
	public String toStringQuarto(int indexQuarto) {
		return adm.toStringQuarto(indexQuarto);
	}
	public int quartoVazio(int tipoQuarto) throws QuartoNaoEncontradoException{
		return user.quartovazio(tipoQuarto);
	}
	public int buscarQuarto(int indexQuarto) throws ArrayIndexOutOfBoundsException,
	QuartoJaExisteException{
		return user.buscarQuarto(indexQuarto);
	}
	public void sevircoDeQuarto(int tipoDeServico , int indexQuarto, int quantidade){
		if(tipoDeServico == 1){
			user.agua(indexQuarto, quantidade);
		}
		if (tipoDeServico == 2){
			user.refrigerante(indexQuarto, quantidade);
		}
		if (tipoDeServico == 3){
			user.vinho(indexQuarto, quantidade);
		}
		if(tipoDeServico == 4){
			user.champagne(indexQuarto, quantidade);
		}
	}
	public void reservarQuarto(int indexQuarto, int diarias, int tipoDeQuarto){
		user.reservarQuarto(indexQuarto, diarias, tipoDeQuarto);
	}
	public float consumo(int indexQuarto){
		return user.consumo(indexQuarto);
	}
	public void pagarConta(int indexQuarto){
		user.pagarConta(indexQuarto);
	}
	public String dadosDoCliente(int indexPessoa){
		return user.dadosDoCliente(indexPessoa);
	}
	/*public int verCheckin (int indexCliente)throws CheckinNaoFeito {
		return user.isCheckin(indexCliente);
	}*/
	
	public int isCheckin (int indexCliente)/*throws Checkinfeito */{
		return user.isCheckin(indexCliente);

	}
	public void setCheckin(int indexCliente, boolean checkin){
		user.setCheckin(indexCliente, checkin);
	}
	public int getHistorico(int indexPessoa){
		return user.getHistorico(indexPessoa);
	}
	public void setHistorico(int indexPessoa){
		user.setHistorico(indexPessoa);
	}
}
