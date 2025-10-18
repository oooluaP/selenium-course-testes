# 🛠️ Checklist de Requisitos e Comportamento da Classe `Desenvolvedor`

Este checklist lista o comportamento **esperado** da classe `Desenvolvedor.java`. Todos os itens devem estar [X] para que o código seja considerado funcional e livre dos bugs documentados.

| Status  | Requisito de Comportamento (Deve Ser) | Contexto/Método |
|:-------:| :--- | :--- |
| **[ ]** | O método `getNivelBaseadoEmExperiencia()` deve retornar **"Júnior"** se a experiência for menor ou igual a $2$ anos. | Lógica de Nível |
| **[ ]** | O método `getNivelBaseadoEmExperiencia()` deve retornar **"Pleno"** se a experiência for maior que $2$ e menor que $5$ anos. | Lógica de Nível |
| **[ ]** | O método `getNivelBaseadoEmExperiencia()` deve retornar **"Sênior"** se a experiência for igual ou maior que $5$ anos. | Lógica de Nível |
| **[ ]** | O método `adicionarProjeto()` deve **impedir** a inclusão de projetos duplicados. A comparação deve ser **case-insensitive**. | Gerenciamento de Projetos |
| **[ ]** | O método `removerProjeto()` deve conseguir remover um projeto com sucesso, mesmo que a capitalização do nome não seja exata (**remoção case-insensitive**). | Gerenciamento de Projetos |
| **[ ]** | O método `calcularHorasPorProjeto()` deve retornar **$0.0$** se a lista de projetos estiver vazia, garantindo que não haja `ArithmeticException` (Divisão por Zero). | Robustez/Cálculo |
| **[ ]** | O método `getProjetos()` deve retornar uma **cópia imutável** (`Collections.unmodifiableList`) para proteger a lista interna de modificações externas. | Encapsulamento |

---