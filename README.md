# leilaormi

Métodos disponíveis no servidor (valor 2,0):
- Consulta de leilões ativos (valor 0,3);
- Cadastro de leilão (código do produto, nome do produto, descrição do produto, preço inicial do produto e tempo final do leilão) (valor 0,3);
- Lance em um produto. Os processos só podem efetuar lances crescentes (lance maior que o atual) para um determinado produto. Um processo pode efetuar quantos lances desejar. Ao tentar dar um lance em um produto de um leilão finalizado, o processo deverá receber um mensagem de erro do servidor. Cada lance será considerado um registro de interesse em evento: o processo servidor tem a tarefa de permitir que seus clientes registrem interesse em eventos (aquisição de produtos). No momento do registro, o cliente deve informar o evento (isto é, o produto desejado, o valor do lance e sua referência de objeto remoto (valor 0,7);
- Encerrar leilão. O leilão de um determinado produto deve ser finalizado quando o tempo definido para esse leilão expirar ou quando o cliente leiloeiro desejar. Ao finalizar o leilão, todos os processos interessados neste leilão devem receber uma notificação contendo as seguintes informações: nome completo do vencedor do produto, identificação do produto, valor negociado (valor 0,4);
- Implementar um mecanismo que controle o acesso concorrente aos métodos do servidor. Atenção: controle de acesso apenas onde for realmente necessário (valor 0,3).

Método disponível no cliente (valor 0,5):
- Notificação de evento: o processo servidor tem a tarefa de enviar, via chamada de método, notificações assíncronas de eventos, isto é,mudanças no andamento do leilão (novos lances em um produto e encerramento de leilão) aos clientes interessados (isto é, aos clientes que efetuaram um lance no produto em questão). 
