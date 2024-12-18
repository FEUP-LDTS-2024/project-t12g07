# GEMSTONE GUARDIANS
## DESCRIÇÃO DO PROJETO
O jogo Gemstone Guardians trata-se de um jogo do tipo tower defense, cujo único objetivo é defender o castelo e as suas preciosas jóias do ataque de diferentes tipos de monstros. Assim, o jogador deve derrotar o maior número de inimigos possível, ao longo do caminho, com o auxílio de torres estrategicamente posicionadas por si, de forma a evitar que os terríveis ladrões alcancem o castelo final.

Este projeto foi desenvolvido em conjunto pelas alunas Catarina Guimarães (up202307420@up.pt), Inês Oliveira (up202305418@up.pt) e Sara Garcia (up202306877@up.pt) para a cadeira de Laboratório de Desenho e Teste de Software, no ano letivo de 2024-2025.


## FEATURES IMPLEMENTADAS
### MENU ACESSÍVEL
O usuário tem a capacidade de aceder ao menu sempre que necessário (quer esteja a meio de uma partida, ou na página das instruções). O menu em questão conta com várias opções, tais como: Iniciar Jogo, Instruções e Sair do Jogo, as quais podem ser acedidas através do uso da seta para cima para selecionar opções em cima da atual e da seta para baixo para selecionar opções em baixo da atual. Para eventualmente selecionar uma das opções, apenas basta pressionar a tecla *enter*.
### INSTRUÇÕES 
Fornecem ao usuário uma pequena história sobre o jogo, esta que é seguida pelos controlos necessários para jogar Gemstone Guardians da maneira correta.
### CURSOR E A SUA UTILIDADE
A utilização do cursor ao longo do uso da aplicação permite que o usuário tenha mais liberdade enquanto jogador do Gemstone Guardians. Podendo ser movida através das teclas de setas, esta feature possibilita uma quantidade mais variada de posicionamentos de torres, deixando que o jogador escolha livremente o local que achar mais adequado para conseguir concluir o nível com sucesso.
### VARIEDADE DE DESIGNS 
Cada torre tem o seu próprio design, da mesma forma que cada tipo de inimigo também tem o seu próprio desenho. O castelo, vulgo a grande torre no final, à qual os inimigos não devem chegar, também possui uma configuração própria.
### TIPOS DIFERENTES DE INIMIGOS
Gemstone Guardians conta com três tipos diferentes de inimigos: o *cavaleiro*, caracterizado pela sua afiada espada, o *goblin*, que apesar do seu tamanho reduzido apresenta uma grande ameaça, e o *gigante*, cuja grandeza, por mais que seja uma desvantagem à distância, se torna algo de grande utilidade quando próximo ao seu alvo. Cada um destes tipos de inimigos faz um dano próprio e tem uma certa quantidade de vida, todas diferentes entre si. Aquando da sua devida eliminação, o monstro em questão recompensará o jogador com uma certa quantia de moedas (que difere entre os três tipos de inimigos disponíveis).
### SISTEMA DE MOEDAS
Tratam-se da ponte entre a eliminação de monstros e a loja, uma vez que são obtidas ao destruir os inimigos e podem ser usadas na compra de mais unidades de defesa para o grande castelo.
### TIPOS DIFERENTES DE TORRE
Cada torre possui características próprias, desde o material do qual é feita até a quantidade de dano que faz aquando de um ataque.
### IMPLEMENTAÇÃO DE UMA LOJA
Ao eliminar inimigos, o jogador recebe algumas moedas, que poderá depois depositar na loja, de maneira a conseguir obter mais torres para defender o seu castelo. De modo a selecionar a torre que deseja comprar, o usuário deverá pressionar a tecla T, alternando ordenadamente pelos três tipos de torres disponíveis. A loja permite que o usuário compre mais do que uma torre de cada tipo, mas impede o usuário de prosseguir com a aquisição se este não tiver uma quantidade de moedas superior ou igual à necessária para o elemento desejado. 
### MAPA COM VÁRIAS TEXTURAS
O mapa de Gemstone Guardians conta com uma zona rochosa, a qual os inimigos percorrem rumo ao grande castelo, uma zona esverdejante, coberta das mais variadas plantas, e, ao fundo do horizonte, podemos até mesmo avistar o mar.

## FEATURES PLANEADAS
Todas as features discutidas antes do desenvolvimento do jogo conseguiram ser implementadas, com a exceção de um sistema de níveis, onde o jogador seria capaz de progredir através de 3 níveis diferentes, com diversos níveis de dificuldade.

## GALERIA
![image](https://github.com/user-attachments/assets/9012714b-4905-40e8-b5fd-d965a4e38402)
(...print do level...)
(...print do menu...)
(...print do game over...)


## USO DE GUI
Uma GUI (Graphical User Interface) trata-se de um tipo de interface visual que permite a interação de um usuário com um sistema através do uso de mecanismos gráficos tais como botões, janelas, ícones e menus. Por mais que este tipo de interface acabe por exigir mais recursos do sistema e tenha um processo de desenvolvimento mais demorado, podemos afirmar que as vantagens da sua utilização acabam por compensar os seus eventuais defeitos. 
Ao recorrer ao uso deste tipo de interface, sentimos que somos capazes de melhorar a qualidade da experiência do usuário ao utilizar a nossa aplicação. A navegação pelo programa torna-se mais intuitiva e simples, facilitando um acesso mais abrangente ao público. Através da aplicação de uma interface deste tipo, somos também capazes de obter um melhor resultado estético.
No entanto, a adoção de uma GUI também exige a aplicação de alguns padrões de design no código, com a finalidade de organizar a sua estrutura e facilitar o nosso processo de desenvolvimento.


## DESIGN 
A presença de design patterns mostra-se cada vez mais essencial no processo de desenvolvimento de software, uma vez que o uso destes é capaz de fornecer soluções reutilizáveis para problemas comuns de código. Assim, de maneira a melhorar a eficiência do nosso código, recorremos ao uso de alguns.

### FACTORY METHOD PATTERN
Apesar de se tratar de um padrão de design criacional (definindo interfaces com a capacidade de criar objetos), o *factory method* permite que as subclasses decidam qual das classes querem instanciar. Assim, ajuda a promover a flexibilidade do código e contribui para um dos princípios SOLID, o OCP.

— o design pattern em questão pode ser encontrado em  [WindowGUI](https://github.com/FEUP-LDTS-2024/project-t12g07/blob/master/src/main/java/com/towerdefense/gui/WindowGUI.java)

![Factory Method](https://github.com/user-attachments/assets/b66142ee-ba16-47e8-b5bd-4d403b990a5b)

Neste exemplo, o método createTerminal() contém a lógica por detrás da criação do objeto Terminal, que a classe WindowGUI usará para desenhar o mapa na tela do computador do usuário. Este faz a configuração e a criação do terminal: ou seja, define o seu tamanho inicial e cria a instância do terminal com as configurações que lhe foram fornecidas. Este design pattern contribui ainda para a abstração de detalhes técnicos, uma vez que a classe que chama o método createTerminal() não necessita de saber qual é que é a configuração interna do terminal.

### STATE PATTERN
A utilização deste padrão comportamental permite que um objeto seja capaz de alterar o seu comportamento aquando da alteração do seu estado interno. Através da organização dos estados em classes separadas, promove tanto a flexibilidade e a organização do código, como o OCP, tal como o padrão anteriormente referido.

— o design pattern em questão pode ser encontrado nem qualquer uma das primeiras quatro classes de [states](https://github.com/FEUP-LDTS-2024/project-t12g07/tree/master/src/main/java/com/towerdefense/states)

Por exemplo, a classe GameOverState representa um estado específico de “Game Over”, tratando-se de uma extensão da classe State<T>. A classe em questão possui métodos que fornecem componentes específicos do estado (denominados como *GameOverController* e *GameOverViewer*). Assim sendo, o design utilizado implica que esta aplicação usa objetos derivados da classe principal para determinar o seu comportamento conforme o estado atual.

![state pattern](https://github.com/user-attachments/assets/9f6d3903-b23f-482c-a714-3a5a51a85ffc)

— exemplo dado pode ser encontrado em [GameOverState](https://github.com/FEUP-LDTS-2024/project-t12g07/blob/master/src/main/java/com/towerdefense/states/GameOverState.java)

Assim, no contexto da nossa aplicação, com o *state pattern* somos capazes de gerenciar os diferentes estados do jogo, sabendo que cada estado tem um modelo próprio e que implementa comportamentos específicos através dos seus *controllers* e *viewers*. O *state pattern* facilita também a extensão do código, uma vez que, se necessário adicionar um novo estado, basta apenas criar novas classes que sejam derivadas da classe State<T>.
O *state pattern* permite então que o jogo altere o seu comportamento de uma maneira simples e eficiente, facilitando a adição de novos estados sem a constante necessidade de atualizar o código já existente.

### MVC
O MVC organiza a nossa aplicação em três componentes principais de forma a separar responsabilidades, contribuindo assim para a modularidade do código e facilitando a manutenção deste. Este padrão arquitetural é frequentemente usado em interfaces que aplicam o GUI.
Assim, o MVC divide o código em três camadas essenciais: Model, View e Controller. O Model funciona como ponte entre as outras duas camadas, e trabalha com a lógica do programa, armazenando no seu interior o comportamento dos dados. O View, por sua vez, é a camada onde os dados do Model são revelados. Este nível também pode provocar interações com o usuário, quando associada à terceira camada: Controller. É neste terceiro elemento que as ações do usuário para com a interface assumem uma maior importância, sendo enviadas para o Model e o View, de modo a atualizar o estado de ambos através das operações necessárias.

![MVC](https://github.com/user-attachments/assets/102fa2b3-a609-4f82-8b6b-5b6c43ffd49b)

No caso do código de Gemstone Guardians, as funcionalidades dos três elementos seriam as seguintes:

#### MODEL
Sendo responsável pelo armazenamento de dados do jogo, esta camada guardaria informações tais como o estado do jogo (detalhes como quantas moedas o jogador tem na partida, por exemplo), detalhes sobre as torres (quantos tipos estão disponíveis e quais os atributos de cada um destes), atributos dos inimigos (tais como o dano que estes fazem ao grande castelo e a quantidade de ponto de vida que possuem), dados sobre o mapa e o seu layout e regras básicas do jogo.

#### VIEW
A camada *View* é a responsável pela apresentação dos dados ao jogador. Assim sendo, este elemento ficaria encarregue da renderização de elementos da aplicação tais como o mapa, as torres e os inimigos, da exibição dos dados sobre o estado atual do jogador (pontos de vida do castelo e quantas moedas possui no momento, por exemplo), e da representação visual de ações tais como o deslocamento dos inimigos em direção ao grande castelo.

#### CONTROLLER
Esta terceira camada é responsável pela recepção de informações por parte do jogador, transmitindo-as aos outros dois componentes do padrão arquitetural MVC de modo a que estes sofram as devidas alterações conforme os dados introduzidos. Assim, no contexto de Gemstone Guardians, o *controller* estaria encarregue de processar os cliques correspondentes aos movimentos do cursor e colocação das torres por parte do usuário, e de sincronizar as interações entre o *Model* e o *View*, de forma a atualizar o estado do jogo sempre que um inimigo (ou o próprio jogador) seja derrotado, por exemplo.


### PRINCÍPIOS SOLID E O SEU PAPEL NO NOSSO PROJETO
A presença dos princípios SOLID mostrou-se bastante útil para o desenvolvimento deste projeto. A correta aplicação destes contribuiu para a melhoria da organização do código e, se necessário, facilita no ato de manutenção do código.

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

(...indicar a presença ou a falta de code smells no produto final…)


## TABELA COM O RELATÓRIO DE COBERTURA DO CÓDIGO
(...inserir o relatório de cobertura do código...)


## RELATÓRIO DE PITEST
(...inserir o relatório de pitest...)



-!-

### GALERIA DA PRIMEIRA ENTREGA
![LDTS drawio (1)](https://github.com/user-attachments/assets/ccce81fb-dc85-46ab-bd50-d2062c428379) 
**MOCKUPS:**
![image](https://github.com/user-attachments/assets/9ef6f508-f019-4131-ba1b-40274a868b25)
![image](https://github.com/user-attachments/assets/b1eeef2e-a5be-4853-8a00-57d514041008)
![image](https://github.com/user-attachments/assets/c3575ff8-d877-4410-8e9d-54fd6dd809d1)
![image](https://github.com/user-attachments/assets/04333804-008e-4add-a657-3abf69c29c0e)




