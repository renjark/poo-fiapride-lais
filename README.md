# Projeto FiapRide - Laís Krajner Lacerda

## Informações do Aluno

- **Nome:** Laís Krajner Lacerda
- **RM:** 563182
- **Turma:** 2CCPH
- **Curso:** Ciências Da Computação
- **GitHub:** renjark (https://github.com/renjark)

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema FiapRide, cobrindo desde a criação de classes simples até hierarquias completas com herança, polimorfismo, classes abstratas e interfaces.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no `main`, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`?

**Sua Resposta:**
Variáveis soltas não escalam. Com 1 milhão de usuários, teríamos 2 milhões de variáveis desconexas (`nomeAna`, `saldoAna`, `nomeCarlos`, `saldoCarlos`...) sem nenhuma relação entre elas. A classe `Passageiro` agrupa os dados que pertencem a um mesmo conceito, funcionando como um molde reutilizável. Basta fazer `new Passageiro()` um milhão de vezes e cada instância carrega seus próprios dados de forma organizada. Além disso, a classe permite adicionar comportamento (métodos) junto com os dados — algo impossível com variáveis soltas. A orientação a objetos reflete o mundo real: um passageiro é uma entidade única com nome, CPF e saldo, não três variáveis aleatórias na memória.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que criar um método específico `adicionarSaldo(valor)`?

**Sua Resposta:**
Alterar o saldo diretamente elimina qualquer controle sobre o que acontece. Sem o método, qualquer programador pode escrever `passageiro.saldo = -500` e criar um estado inválido no sistema. O método `adicionarSaldo(valor)` centraliza a regra de negócio: o valor precisa ser positivo. Se essa regra mudar no futuro, basta alterar o método em um único lugar — não caçar todos os pontos do código onde o saldo era manipulado diretamente. Para uma startup financeira, isso é crítico: uma vulnerabilidade de saldo negativo pode causar prejuízos reais e processos judiciais.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar o `getSaldo()` público, mas perigoso deixar o atributo `saldo` público?

**Sua Resposta:**
O `getSaldo()` retorna uma **cópia** do valor — é como dar uma fotocópia do seu extrato bancário para alguém. A pessoa pode ler a informação, mas não pode rasurá-la. Já o atributo `saldo` público seria como entregar o documento original: qualquer um pode escrever o que quiser por cima. Com o `get` público e o atributo `private`, garantimos que a leitura é livre, mas a escrita só acontece pelos canais controlados (`adicionarSaldo`, `pagarViagem`). Isso protege a integridade dos dados — o objeto sempre estará em um estado válido, pois toda mudança passa por uma validação.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na IDE?

**Sua Resposta:**
A IDE não conhece as regras do negócio — ela só enxerga atributos. Gerar `setModelo()` para um carro seria um erro grave: o modelo de um veículo não muda na vida real. Se alguém chamar `carro.setModelo("Ferrari")` após o cadastro, o sistema fica inconsistente. No nosso design, `setPlaca()` é privado propositalmente: atualizar uma placa no mundo real não é só "mudar um dado no banco", é abrir um processo no Detran, pagar taxas, validar formatos. Por isso existe o método público `atualizarPlaca()` que encapsula esse processo — e internamente chama o `setPlaca()`. A IDE gera código; o engenheiro projeta comportamento.

---

### Aula 5 - Associação

**Pergunta:** Se o resumo só precisa imprimir o nome da pessoa, não seria mais leve pedir apenas a `String nomeDoPassageiro` no construtor da `Viagem`?

**Sua Resposta:**
Imprimir o nome é só a ponta do iceberg. Quando a viagem termina, o sistema precisa descontar o saldo do passageiro chamando `passageiro.pagarViagem(valor)`. Se a `Viagem` tiver apenas a `String "Ana Silva"`, ela não tem como interagir com o objeto real — é apenas um pedaço de texto, não uma referência ao passageiro verdadeiro. Com o objeto inteiro (`Passageiro solicitante`), a `Viagem` pode invocar qualquer comportamento: cobrar, verificar saldo, atualizar histórico. Além disso, se Ana atualizar seu saldo depois que a viagem foi criada, a viagem "enxerga" essa mudança porque aponta para o mesmo objeto na memória — isso é a **passagem por referência** em ação.

---

### Aula 6 - Herança

**Pergunta:** Por que o Java não deixa a classe filha `Carro` alterar as variáveis `private` da mãe `Veiculo` diretamente?

**Sua Resposta:**
Esse comportamento é exatamente o **Encapsulamento** da Aula 3 sendo aplicado dentro da hierarquia de herança. Os atributos `placa` e `modelo` são privados da classe `Veiculo` — isso significa que apenas a `Veiculo` controla como eles são escritos. Se o `Carro` pudesse fazer `this.placa = "ABC"` diretamente, toda a validação dentro do `setPlaca()` seria contornada. A filha herda o **estado** (os atributos existem nela) e o **comportamento público** (getters, métodos), mas não o **controle interno** (setters privados). Ela deve usar `super()` no construtor ou `getPlaca()` para acessar o valor — respeitando o contrato definido pela mãe.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se esquecêssemos de criar `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo dentro do loop mesmo sabendo que ele existe em `Carro` e `Moto`?

**Sua Resposta:**
Não. O loop declara a variável como `Veiculo veiculo`, e o Java só "enxerga" os métodos que existem na classe `Veiculo` em tempo de compilação. Mesmo que o objeto real em memória seja um `Carro`, o compilador analisa o **tipo declarado**, não o tipo real. Sem o método em `Veiculo`, o compilador recusaria a chamada com erro. O contrato na base da hierarquia é fundamental: ele diz ao compilador "todo objeto desta família tem esse método", permitindo que o código genérico funcione com qualquer subclasse atual ou futura, sem `if/else` para descobrir o tipo.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Por que ele não deduz isso sozinho?

**Sua Resposta:**
O Java não pode deduzir a intenção do programador. Uma classe pode ter métodos com corpo padrão e ainda assim não fazer sentido ser instanciada — como `Veiculo`, que tem lógica de placa e modelo mas não representa nada concreto no mundo real. Sem o `abstract`, alguém faria `new Veiculo("AAA-1234", "Genérico")` e teria um objeto sem tipo definido no sistema, quebrando a lógica de corridas (qual autonomia calcular? qual tipo exibir?). O `abstract` é uma declaração explícita de intenção arquitetural: "esta classe existe só para ser herdada, nunca instanciada". O compilador passa a garantir isso automaticamente, tornando impossível criar o objeto inválido.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples, mas múltipla implementação de interfaces?

**Sua Resposta:**
O problema da herança múltipla de classes é o **Diamond Problem**: se `CarroEletrico` herdasse de `Veiculo` e de `Bateria`, e ambas tivessem um método `ligar()` com implementações diferentes, o Java não saberia qual código executar. Interfaces resolvem isso porque **não têm código** — apenas assinaturas de métodos. Não há conflito quando duas interfaces exigem o mesmo método, porque a classe concreta fornece **uma única implementação** que satisfaz ambas. É a diferença entre herdar DNA (código, comportamento) e assinar contratos (compromisso de implementar). Uma classe pode ter só uma mãe biológica, mas pode assinar quantos contratos quiser.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema de Biblioteca Digital — um sistema que gerencia empréstimos de livros físicos e digitais, com controle de usuários e acervo.

**Quais classes você criou?**
- `Livro` (abstrata) — superclasse com atributos e comportamentos comuns a todo livro
- `LivroFisico` — subclasse concreta com localização na estante
- `LivroDigital` — subclasse concreta que também implementa a interface `Baixavel`
- `Usuario` — representa o leitor com controle de limite de empréstimos
- `Emprestimo` — associação entre `Usuario` e `Livro` (TEM-UM)
- `Baixavel` — interface para objetos que podem ser baixados digitalmente

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi entender quando usar herança e quando usar interface ao modelar o sistema de biblioteca. A princípio, parecia natural criar uma única classe `Livro` com um atributo `tipo` (String "Físico" ou "Digital") e resolver tudo com `if/else`. Porém, ao aplicar os conceitos da aula 7, percebi que isso violava o princípio do Polimorfismo: eu estaria colocando a lógica de `exibirDetalhes()` dentro de um único método gigante cheio de condicionais, em vez de deixar cada objeto responsável pelo seu próprio comportamento.

A solução foi tornar `Livro` uma classe abstrata (Aula 8), forçar cada subclasse a implementar `exibirDetalhes()` e `getTipoAcesso()`, e usar a interface `Baixavel` (Aula 9) apenas para o `LivroDigital` — já que um livro físico não pode ser "baixado". Isso demonstrou na prática a diferença entre herança (é-um) e interface (tem-um-comportamento): `LivroDigital` É UM `Livro` E TAMBÉM É `Baixavel`, enquanto `LivroFisico` É UM `Livro` mas NÃO é `Baixavel`. Modelar esse raciocínio foi o momento em que o POO começou a fazer sentido de verdade.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que Programação Orientada a Objetos não é apenas uma forma diferente de escrever código — é uma forma diferente de pensar sobre problemas. Nas primeiras aulas, o desafio era entender a diferença entre a classe (o molde) e o objeto (a instância real na memória). Conforme o projeto evoluiu, cada conceito novo se apoiou no anterior: o Encapsulamento protegeu os dados que a Aula 1 criou; o Construtor formalizou a Aula 3; a Herança reutilizou o que a Aula 4 construiu. O maior salto de entendimento veio com o Polimorfismo — perceber que posso escrever `veiculo.calcularAutonomia()` sem saber se é um Carro ou uma Moto, e que o objeto certo saberá responder, foi o momento em que entendi por que POO existe.

**Qual conceito foi mais difícil de entender?**
A diferença entre Classe Abstrata e Interface foi o conceito mais difícil. Ambas parecem "incompletas" à primeira vista e ambas forçam implementação nas subclasses. A virada de chave foi entender o critério de escolha: uso classe abstrata quando as classes compartilham **código em comum** (como `placa` e `modelo` em `Veiculo`), e uso interface quando quero garantir um **comportamento** em classes que não têm relação de herança entre si (como `CarroEletrico` e `Celular` ambos sendo `Recarregavel`). Depois dessa distinção, ficou claro por que Java permite implementar várias interfaces mas herdar de apenas uma classe.

**O que você melhoraria no seu projeto se pudesse refazer?**
Refazendo o projeto, eu adicionaria uma classe `Motorista` para separar melhor as responsabilidades — hoje o `SistemaPrincipal` faz muito trabalho manual de orquestração. Também substituiria os arrays por `List<>` desde a Aula 5, já que é a abordagem mais realista para um sistema com dados dinâmicos. No projeto pessoal (Biblioteca), criaria um `GerenciadorBiblioteca` com métodos como `buscarPorAutor()` e `listarDisponíveis()`, em vez de acessar os livros diretamente no `main`. Finalmente, adicionaria um atributo `dataEmprestimo` real em `Emprestimo` usando a classe `LocalDate` do Java, tornando o controle de prazo funcional de verdade.

