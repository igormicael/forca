class ForcaService {
  constructor() {
    this.axios = axios.create({ baseURL: 'rest/jogo' });
  }
  request(method, url, data) {
    return this.axios[method](url, data)
      .then(response => {
        return response.data;
      })
      .catch(error => {
        console.error(
                  '[ERROR: JogoService] ' + method + ' ' + url, error);
        return Promise.reject(error);
      });
  }

  comecar() {
    return this.request('get'); 
  }
  
  darPalpite_(retorno) {
  	return this.request('post', '/', retorno);
  }
}

var forcaService = new ForcaService();