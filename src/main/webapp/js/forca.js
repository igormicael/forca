var app = new Vue({
  el: '#app',
  data: {
    titulo: 'Jogo da Forca',
    retorno:{
    	mensagem: null,
    	letra: null,
    	palavraNaTela: null,
    	palavraEscolhida: null,
    	numeroTentativas: null
    }
  },
  methods: {
	iniciarJogo(){
		forcaService.comecar()
			.then(retorno => {
				console.log(retorno);
				this.retorno.mensagem = retorno.mensagem;
				this.retorno.numeroTentativas = retorno.numeroTentativas;
				this.retorno.palavraNaTela = retorno.palavraNaTela;
				this.retorno.palavraEscolhida = retorno.palavraEscolhida;
			})
			.catch(erro=> {
				console.log(erro);
			})
	},
	darPalpite(){
		forcaService.darPalpite_(this.retorno)
		.then(retorno => {
				console.log(retorno);
				this.retorno.mensagem = retorno.mensagem;
				this.retorno.letra = null;
				this.retorno.numeroTentativas = retorno.numeroTentativas;
				this.retorno.palavraNaTela = retorno.palavraNaTela;
				this.retorno.palavraEscolhida = retorno.palavraEscolhida;
			})
			.catch(erro=> {
				console.log(erro);
			})
	}
}
    
});