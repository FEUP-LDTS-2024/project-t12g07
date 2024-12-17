# GEMSTONE GUARDIANS
## DESCRIÇÃO DO PROJETO
O jogo Gemstone Guardians trata-se de um jogo do tipo tower defense, cujo único objetivo  é defender o castelo e as suas preciosas jóias do ataque de diferentes tipos de monstros. Assim, o jogador deve derrotar o maior número de inimigos possível, ao longo do caminho, com o auxílio de torres estrategicamente posicionadas, de forma a evitar que os terríveis ladrões alcancem o castelo final.

Este projeto foi desenvolvido em conjunto pelas alunas Catarina Guimarães (up202307420@up.pt), Inês Oliveira (up202305418@up.pt) e Sara Garcia (up202306877@up.pt) para a cadeira de Laboratório de Desenho e Teste de Software, no ano letivo de 2024-2025.


## FEATURES IMPLEMENTADAS
### MENU ACESSÍVEL
O usuário tem a capacidade de aceder ao menu sempre que necessário (quer esteja a meio de uma partida, ou na página das instruções). O menu em questão conta com várias opções, tais como: Iniciar Jogo, Instruções e Sair do Jogo, as quais podem ser acedidas através do uso da seta para cima para selecionar opções em cima da atual e da seta para baixo para selecionar opções em baixo da atual. Para selecionar uma das opções, apenas basta pressionar a tecla enter.
### INSTRUÇÕES 
Fornecem ao usuário uma pequena história sobre o jogo, esta que é seguida pelos controlos necessários para jogar Gemstone Guardians da maneira correta.
### VARIEDADE DE DESIGNS 
Cada torre tem o seu próprio design; da mesma forma que cada tipo de inimigo também tem o seu próprio desenho. O castelo, vulgo a grande torre no final, à qual os inimigos não devem chegar, também possui uma configuração própria.
### TIPOS DIFERENTES DE INIMIGOS
Gemstone Guardians conta com três tipos diferentes de inimigos: o *cavaleiro*, caracterizado pela sua afiada espada, o *goblin*, que apesar do seu tamanho reduzido apresenta uma grande ameaça, e o *gigante*, cujo tamanho, por mais que seja uma desvantagem à distância, se torna algo de grande utilidade quando próximo ao seu alvo. Cada um destes tipos de inimigos faz um dano próprio e tem uma certa quantidade de vida, todas diferentes entre si. Aquando da sua devida eliminação, o monstro em questão recompensará o jogador com uma certa quantia de moedas (que difere entre os três tipos de inimigos disponíveis).
### SISTEMA DE MOEDAS
Tratam-se da ponte entre a eliminação de monstros e a loja, uma vez que são obtidas ao destruir os inimigos e podem ser usadas na compra de upgrades para as torres do jogador.
### TIPOS DIFERENTES DE TORRE
Cada torre possui características próprias, desde o material de qual é feita até a quantidade de dano que faz aquando de um ataque.
### IMPLEMENTAÇÃO DE UMA LOJA
Ao eliminar inimigos, o jogador recebe algumas moedas, que poderá depois depositar na loja, de maneira a aprimorar as suas torres.
### VARIADOS NÍVEIS DE DANO
Através da compra de novos níveis na loja, as torres tornar-se-ão capazes de fazer mais dano aos inimigos, fortalecendo a defesa e, posteriormente, evitando que os monstros se aproximem perigosamente do grande castelo.
### MAPA COM VÁRIAS TEXTURAS
O mapa de Gemstone Guardians conta com uma zona rochosa, a qual os inimigos percorrem rumo ao grande castelo, uma zona esverdejante, coberta das mais variadas plantas, e, ao fundo do horizonte, podemos até mesmo avistar o mar.

## FEATURES PLANEADAS
Todas as features discutidas antes do desenvolvimento do jogo conseguiram ser implementadas, com a exceção de um sistema de níveis, onde o jogador seria capaz de progredir através de 3 níveis diferentes, com diversos níveis de dificuldade.

-!-


**DOCUMENTATION:**
Usar os princípios SOLID no noss jogo de tower defense melhora a organização e facilita a manutenção do código. 
- Com o SRP, cada classe tem uma única responsabilidade, tornando o sistema mais claro.
- O OCP permite adicionar novos tipos de torres ou inimigos sem alterar o código existente.
- O LSP garante que subclasses, como torres específicas, funcionem sem problemas no lugar das classes base.
- O ISP evita interfaces excessivamente grandes, focando apenas no necessário.
- Já o DIP promove flexibilidade ao depender de abstrações, facilitando mudanças e expansões no projeto.
  ![LDTS drawio (1)](https://github.com/user-attachments/assets/ccce81fb-dc85-46ab-bd50-d2062c428379)

  
**MOCKUPS:**
![image](https://github.com/user-attachments/assets/9ef6f508-f019-4131-ba1b-40274a868b25)
![image](https://github.com/user-attachments/assets/b1eeef2e-a5be-4853-8a00-57d514041008)
![image](https://github.com/user-attachments/assets/c3575ff8-d877-4410-8e9d-54fd6dd809d1)
![image](https://github.com/user-attachments/assets/04333804-008e-4add-a657-3abf69c29c0e)




