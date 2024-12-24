# GEMSTONE GUARDIANS
## DESCRIÇÃO DO PROJETO
O jogo Gemstone Guardians trata-se de um jogo do tipo tower defense, cujo objetivo é defender o castelo e as suas jóias do ataque de diferentes tipos de monstros. O jogador deve derrotar o maior número de inimigos possível, ao longo do caminho, com o auxílio de torres estrategicamente posicionadas por si, de forma a evitar que os terríveis ladrões alcancem o castelo final.

Este projeto foi desenvolvido em conjunto pelas alunas Catarina Guimarães (up202307420@up.pt), Inês Oliveira (up202305418@up.pt) e Sara Garcia (up202306877@up.pt) para a cadeira de Laboratório de Desenho e Teste de Software, no ano letivo de 2024-2025.

## FEATURES IMPLEMENTADAS
### MENU 
O usuário tem a capacidade de aceder ao menu sempre que necessário. O menu em questão conta com várias opções: Iniciar Jogo, Instruções e Sair do Jogo, que podem ser selecionadas com as setas.
### INSTRUÇÕES 
Fornecem ao usuário uma pequena contextualização sobre o jogo, que é seguida pelos controlos necessários para jogar Gemstone Guardians da maneira correta.
### CURSOR E A SUA UTILIDADE
O cursor permite a utilização das setas para posicionar torres no local que o utilizador achar mais adequado.
### VARIEDADE DE DESIGNS
Cada torre possui o seu próprio design, tal como os diferentes tipos de inimigos e o castelo.
### TIPOS DIFERENTES DE INIMIGOS
Gemstone Guardians conta com três tipos diferentes de inimigos: o *cavaleiro*, o *goblin*, e o *gigante*. Cada um destes tipos de inimigos faz um dano próprio e tem uma certa quantidade de vida, todas diferentes entre si. Aquando da sua morte, o monstro em questão recompensará o jogador com uma certa quantia de moedas (que difere entre os três tipos de inimigos disponíveis).
### SISTEMA DE MOEDAS
São obtidas ao destruir os inimigos e podem ser usadas na compra de mais unidades de defesa para o grande castelo
.###DIFERENTES TIPOS DE TERRENO
Implementamos diferentes tipos de terreno: a path por onde circulam os inimigos, a grass onde podem ser colocadas torres de defesa, e o sea onde não podem ser colocadas torres. 
### TIPOS DIFERENTES DE TORRE
Cada torre possui características próprias, sendo estas o custo, o dano e o material das mesmas.
### IMPLEMENTAÇÃO DE UMA LOJA
De modo a selecionar a torre que deseja comprar, o usuário deverá pressionar a tecla T, alternando ordenadamente pelos três tipos de torres disponíveis. A loja impede o usuário de prosseguir com a aquisição se este não tiver as moedas necessárias, ou se o local onde se está a tentar colocar uma torre estiver ocupado por outra torre ou não for do tipo grass.
## FEATURES PLANEADAS
Todas as features discutidas conseguiram ser implementadas, com a exceção da classe Arrow, já que o ataque acabou por ser uma relação entre torre e inimigo. 

## GALERIA
![print do menu](https://github.com/user-attachments/assets/bd9f9697-3c2b-4804-970f-7b2f220bbb84)
![print das instruções](https://github.com/user-attachments/assets/9012714b-4905-40e8-b5fd-d965a4e38402)
![print do level](https://github.com/user-attachments/assets/033427d5-8c54-49a6-80b6-4c8906845190)
![print do game over](https://github.com/user-attachments/assets/a422b8dd-0f56-4a8b-a786-23d014a4f5f4)
![print do victory](https://github.com/user-attachments/assets/d08b4de7-d759-4b78-885d-58e02de0b99b)

## USO DE GUI
Uma GUI (Graphical User Interface) trata-se de um tipo de interface visual que permite a interação de um usuário com um sistema através do uso de mecanismos gráficos tais como botões, janelas, ícones e menus. Por mais que este tipo de interface acabe por exigir mais recursos do sistema e tenha um processo de desenvolvimento mais demorado, podemos afirmar que as vantagens da sua utilização acabam por compensar os seus eventuais defeitos. 
Ao recorrer ao uso deste tipo de interface, sentimos que somos capazes de melhorar a qualidade da experiência do usuário ao utilizar a nossa aplicação. A navegação pelo programa torna-se mais intuitiva e simples, facilitando um acesso mais abrangente ao público. Através da aplicação de uma interface deste tipo, somos também capazes de obter um melhor resultado estético.
No entanto, a adoção de uma GUI também exige a aplicação de alguns padrões de design no código, com a finalidade de organizar a sua estrutura e facilitar o nosso processo de desenvolvimento.

## DESIGN
De maneira a melhorar a eficiência do nosso código, recorremos ao uso de alguns design patterns.

### STATE PATTERN
A utilização deste padrão comportamental permite que um objeto seja capaz de alterar o seu comportamento aquando da alteração do seu estado interno. Através da organização dos estados em classes separadas, promove tanto a flexibilidade e a organização do código, como o OCP, tal como o padrão anteriormente referido.

— o design pattern em questão pode ser encontrado nem qualquer uma das primeiras quatro classes de [states](https://github.com/FEUP-LDTS-2024/project-t12g07/tree/master/src/main/java/com/towerdefense/states)

Por exemplo, a classe GameOverState representa um estado específico de “Game Over”, tratando-se de uma extensão da classe State<T>. A classe em questão possui métodos que fornecem componentes específicos do estado (denominados como *GameOverController* e *GameOverViewer*). Assim sendo, o design utilizado implica que esta aplicação usa objetos derivados da classe principal para determinar o seu comportamento conforme o estado atual.

![image](https://github.com/user-attachments/assets/16ef4acf-e190-4f29-9068-d17814c92576)

— exemplo dado pode ser encontrado em [GameOverState](https://github.com/FEUP-LDTS-2024/project-t12g07/blob/master/src/main/java/com/towerdefense/states/GameOverState.java)

Assim, no contexto do nosso jogo, com o *state pattern* somos capazes de gerenciar os diferentes estados do jogo, sabendo que cada estado tem um modelo próprio e que implementa comportamentos específicos através dos seus *controllers* e *viewers*. O *state pattern* facilita também a extensão do código, uma vez que, se necessário adicionar um novo estado, basta apenas criar novas classes que sejam derivadas da classe State<T>.
O *state pattern* permite então que o jogo altere o seu comportamento de uma maneira simples e eficiente, facilitando a adição de novos estados sem a constante necessidade de atualizar o código já existente.

### MVC
O MVC organiza a nossa aplicação em três componentes principais de forma a separar responsabilidades, contribuindo assim para a modularidade do código e facilitando a manutenção deste. Este padrão arquitetural é frequentemente usado em interfaces que aplicam o GUI.
Assim, o MVC divide o código em três camadas essenciais: Model, View e Controller. O Model funciona como ponte entre as outras duas camadas, e trabalha com a lógica da aplicação, armazenando no seu interior o comportamento dos dados. O View, por sua vez, é a camada onde os dados do Model são revelados. Este nível também pode provocar interações com o usuário, quando associada à terceira camada: Controller. É neste terceiro elemento que as ações do usuário para com a interface assumem uma maior importância, sendo enviadas para o Model e o View, de modo a atualizar o estado de ambos através das operações necessárias.

![image](https://github.com/user-attachments/assets/1d0599ff-b51e-450d-8a41-bf26cb8298b0)

No caso do código de Gemstone Guardians, as funcionalidades dos três elementos seriam as seguintes:

#### MODEL
Sendo responsável pelo armazenamento de dados do jogo, esta camada guardaria informações tais como o estado do jogo (detalhes como quantas moedas o jogador tem na partida, por exemplo), detalhes sobre as torres (quantos tipos estão disponíveis e quais os atributos de cada um destes), atributos dos inimigos (tais como o dano que estes fazem ao grande castelo e a quantidade de ponto de vida que possuem), dados sobre o mapa e o seu layout e regras básicas do jogo.

#### VIEW
A camada *View* é a responsável pela apresentação dos dados ao jogador. Assim sendo, este elemento ficaria encarregue da renderização de elementos da aplicação tais como o mapa, as torres e os inimigos, da exibição dos dados sobre o estado atual do jogador (pontos de vida do castelo e quantas moedas possui no momento, por exemplo), e da representação visual de ações tais como o ataque das torres em relação ao inimigo.

#### CONTROLLER
Esta terceira camada é responsável pela recepção de informações por parte do jogador, transmitindo-as aos outros dois componentes do padrão arquitetural MVC de modo a que estes sofram as devidas alterações conforme os dados introduzidos. Assim, no contexto de Gemstone Guardians, o controller estaria encarregue de processar os cliques correspondentes aos movimentos do cursor e colocação das torres por parte do usuário, e de sincronizar as interações entre o Model e o View, de forma a atualizar o estado do jogo sempre que um inimigo seja derrotado, por exemplo.

### PRINCÍPIOS SOLID E O SEU PAPEL NO NOSSO PROJETO
A presença dos princípios SOLID mostrou-se bastante útil para o desenvolvimento deste projeto. A correta aplicação destes contribuiu para a melhora da organização do código e, se necessário, facilita no ato de manutenção do código.

#### SRP (SINGLE RESPONSIBILITY PRINCIPLE)
Através do uso deste princípio, cada uma das classes presentes possui apenas uma única tarefa. Assim sendo, a classe acabará por ter apenas um motivo para ser alterada futuramente, uma vez que todas as suas eventuais alterações estarão ligadas à sua única tarefa. A aplicação deste princípio leva a uma maior clareza do código.

#### OCP (OPEN-CLOSED PRINCIPLE) 
Ao evitar mudar o código-fonte original, apenas estendendo o seu comportamento através da criação de novas funcionalidades por meio da extensão de classe ou da adição de novos módulos, somos capazes de adicionar novos tipos de torres ou de inimigos, sem a necessidade de alterar o código já existente.

#### LSP (LISKOV SUBSTITUTION PRINCIPLE)
O princípio da substituição de Liskov defende que, se uma certa classe se trata de uma subclasse de outra, então os objetos da classe principal podem facilmente ser substituídos por objetos da subclasse sem que o devido funcionamento do programa seja perturbado. Na nossa aplicação, este princípio faz com que os tipos específicos de torre funcionem sem problemas quando aplicados no lugar da classe base.

#### ISP (INTERFACE SEGREGATION PRINCIPLE)
Por sua vez, o princípio da segregação de interfaces defende que nenhuma classe deve depender de métodos dos quais não precisa. Assim, conseguimos evitar que o programa possua interfaces extremamente grandes, uma vez que se foca apenas no necessário.

#### DIP (DEPENDENCY INVERSION PRINCIPLE)
Por fim, o princípio da inversão de dependência depende que uma classe não deve ser dependente de uma subclasse, implicando que ambas devem depender de abstrações. Com isto, o DIP permite que o código seja alterado mais facilmente, sem correr riscos de ter algum tipo de problema.

## CODE SMELLS
Um code smell trata-se de uma característica num código-fonte que pode indicar um problema tanto estrutural como de qualidade. Embora nem sempre possa significar um erro ou um bug direto, costuma apontar para algo que pode dificultar a manutenção, a leitura ou a evolução do código.
O nosso trabalho não tem nenhum major code smell à exceção de, na class enemy, o array de pontos que formam a path sobre a qual o inimigo caminha, torna o código mais extenso e impossibilita alterações fáceis ao mapa do level. No caso do mapa do level for alterado o jogo não será afetado a nível da gameplay, mas sim visualmente, sendo que o inimigo poderá estar a caminhar por outro tipo de terrenos sem ser o da “path”.

## TABELA COM O RELATÓRIO DE COBERTURA DO CÓDIGO
![image](https://github.com/user-attachments/assets/5fc18f58-a28d-4cb2-9d9e-fbb644cb645b)

## RELATÓRIO DE PITEST
### MODEL
![image](https://github.com/user-attachments/assets/168a98b3-a946-4249-a337-5b1a7299c4ab)
![image](https://github.com/user-attachments/assets/052bf2e1-8526-4a79-b578-2095538063b3)
![image](https://github.com/user-attachments/assets/95e230a9-6a30-480a-b53f-6e2edc7aaef4)
### VIEW
![image](https://github.com/user-attachments/assets/7d7fa69f-2983-4ea3-aac3-4e59de91b12e)
![image](https://github.com/user-attachments/assets/dd3a497d-50c3-4333-8e77-612df133b8b9)
### CONTROLLER
![image](https://github.com/user-attachments/assets/1bc2f877-70ee-4a68-baa1-d8269843ebfd)
![image](https://github.com/user-attachments/assets/bc60a242-756f-4844-b8a4-efeeeb59efaf)
### STATES
![image](https://github.com/user-attachments/assets/be0e1faa-5fae-45d8-8e82-be14e8456fe7)
### OUTROS
![image](https://github.com/user-attachments/assets/412f50f3-c244-4b33-8f67-cf12b9e3943d)

## AUTO-AVALIAÇÃO
Todos os elementos do grupo contribuíram para o seu desenvolvimento.
Catarina Guimarães — 33,3%
Inês Oliveira — 33,3%
Sara Garcia — 33,3%





-!-

### GALERIA DA PRIMEIRA ENTREGA
![LDTS drawio (1)](https://github.com/user-attachments/assets/ccce81fb-dc85-46ab-bd50-d2062c428379) 
**MOCKUPS:**
![image](https://github.com/user-attachments/assets/9ef6f508-f019-4131-ba1b-40274a868b25)
![image](https://github.com/user-attachments/assets/b1eeef2e-a5be-4853-8a00-57d514041008)
![image](https://github.com/user-attachments/assets/c3575ff8-d877-4410-8e9d-54fd6dd809d1)
![image](https://github.com/user-attachments/assets/04333804-008e-4add-a657-3abf69c29c0e)




