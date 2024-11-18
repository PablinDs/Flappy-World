# Flappy-World
A proposta do projeto Flappy World é desenvolver um jogo que incentive a educação ambiental, unindo tecnologia e sustentabilidade. Ele busca conscientizar os jogadores sobre questões ambientais por meio de uma abordagem lúdica e interativa, utilizando elementos visuais e mecânicas de jogo inspirados em Flappy Bird.

No jogo, o jogador controla o planeta Terra, que deve desviar de obstáculos representados por lixeiras, enquanto mensagens e elementos gráficos reforçam a importância da preservação ambiental e da sustentabilidade. A ideia é combinar diversão e aprendizado, promovendo reflexões sobre responsabilidades individuais em relação ao meio ambiente.

Desenvolvimento

O desenvolvimento do jogo Flappy World foi realizado utilizando a linguagem de programação Java, com base na mecânica do famoso jogo Flappy Bird. A criação envolveu diversas técnicas de programação para implementar as funcionalidades desejadas, destacando-se conceitos fundamentais como herança e polimorfismo, que facilitaram a organização do código em múltiplas classes, promovendo modularidade e eficiência.

O projeto conta com 11 classes principais, cada uma responsável por um aspecto específico do jogo, como:

- Ação: É uma interface que define um método genérico para executar ações. Outras classes implementam essa interface para realizar ações específicas no jogo.

- Cano: Controla os obstáculos do jogo, representados por lixeiras. Define suas posições, tamanhos e movimentação na tela, criando desafios para o jogador.

- Cor: Gerencia as cores usadas no jogo, utilizando componentes RGB. Implementa um mecanismo de cache para reutilizar cores, otimizando a criação de objetos gráficos.

- FlappyWorld: Classe principal do jogo. Gerencia o estado do jogo, os elementos como personagem, obstáculos e pontuação, além de coordenar as interações entre as outras classes.

- Hitbox: Define áreas de colisão para detectar interseções entre o personagem e os obstáculos, assegurando que as regras de jogo sejam aplicadas corretamente.

- Interface Jogo: Estrutura básica que especifica os métodos fundamentais para qualquer jogo, como desenho, interação com o teclado e controle de estados.

- Lixeira: Representa os obstáculos (lixeiras) que o jogador deve evitar. Define o comportamento de movimentação e interação visual dos obstáculos na tela.

- Motor: Controla o loop principal do jogo, gerenciando o tempo, as atualizações de estado e as entradas do jogador, como teclas pressionadas.

- Mundo: Representa o personagem principal, o planeta Terra. Gerencia seu movimento, colisões e animações, além de responder aos comandos do jogador.

- ScoreNumber: Gerencia a pontuação do jogador, exibindo o valor atual e o recorde durante o jogo, de maneira gráfica e interativa.

- Tela: Cuida da renderização de todos os elementos gráficos na interface do jogador. Gerencia a exibição de imagens, formas e textos no jogo.
Para a implementação, foi utilizado um Ambiente de Desenvolvimento Integrado (IDE), que facilitou a escrita e depuração do código. A mecânica do jogo foi construída com base em eventos, como pressionar a tecla de espaço para fazer o planeta “bater suas asas” e evitar obstáculos. O design gráfico do jogo foi inspirado em elementos da natureza e cenários de poluição, reforçando a temática ambiental.

Além da funcionalidade básica, o jogo inclui mensagens de conscientização e telas de feedback que exibem as consequências de ações inadequadas no jogo, alinhando-se ao objetivo educativo de promover a sustentabilidade de maneira indireta e interativa.

Essa abordagem combina tecnologia e educação para engajar os jogadores em um formato lúdico, enquanto os estimula a refletir sobre sua responsabilidade em relação ao meio ambiente.

- Captura e Manipulação de imagens

O código do jogo Flappy World faz a captura das imagens acima utilizando uma abordagem eficiente que envolve armazenamento em cache e renderização dinâmica. Inicialmente, as imagens são carregadas de arquivos locais no disco e armazenadas em uma estrutura de dados que permite reutilizá-las sem precisar recarregá-las continuamente. Isso melhora o desempenho do jogo.

Quando uma imagem precisa ser exibida na tela, o sistema verifica se ela já está carregada. Caso contrário, ela é carregada e armazenada para futuras chamadas. Em seguida, as imagens são desenhadas na tela usando uma ferramenta gráfica que permite especificar o posicionamento, tamanho e, se necessário, aplicar transformações como rotações.

Essa renderização ocorre de forma precisa, ajustando as imagens às dimensões e posições necessárias para cada elemento do jogo, como o fundo, os obstáculos ou o personagem. Dessa forma, o código garante que os elementos gráficos sejam exibidos corretamente, de maneira fluida e integrada à jogabilidade.

# Download

Para fazer o download completo basta instalar o arquivo "FlappyWorld.zip",
Os outros arquivos estão ai apenas para poderem acompanhar o código.
