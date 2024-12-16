**DESCRIPTION:**
O jogo Gemstone Guardians trata-se de um jogo do tipo tower defense, cujo único objetivo  é defender o castelo e as suas preciosas jóias do ataque de diferentes tipos de monstros. Assim, o jogador deve derrotar o maior número de inimigos possível, ao longo do caminho, com o auxílio de torres estrategicamente posicionadas, de forma a evitar que os terríveis ladrões alcancem o castelo final.

Este projeto foi desenvolvido em conjunto pelas alunas Catarina Guimarães (up202307420@up.pt), Inês Oliveira (up202305418@up.pt) e Sara Garcia (up202306877@up.pt) para a cadeira de Laboratório de Desenho e Teste de Software, no ano letivo de 2024-2025.


**FEATURES:**

**Diferentes tipos de torre** (madeira, pedra e metal) com diferentes características
- Ataque
- Custo
  
**Diferentes tipos de inimigo** (gigante, cavaleiro, goblin) com diferentes características
- Vida
- Saque
- Recompensa (moedas recebidas ao matar)
  
**Sistema de moedas**
- Adquiridas ao matar inimigos
- Utilizadas para comprar torres

**Castelo (com as suas gemstones)**

**Mapa com vários tipos de terreno**
- Caminho (por onde se deslocam os inimigos)
- Relva (onde podem ser colocadas torres)
- Mar (onde não podem ser colocadas torres)
  
**Menu com várias opções**
- Iniciar o jogo
- Instruções
- Sair do jogo


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




