# 📦 Sistema de Pedidos e Cálculo de Frete

Este projeto foi desenvolvido para disciplina de Clean Code e Boas Práticas e implementa um sistema modular de **gerenciamento de pedidos com cálculo de frete**, usando **princípios de Clean Code, SOLID, Design Patterns (Strategy, Null Object)** e separação clara por responsabilidades.

---

## 🧱 Estrutura de Pacotes

A organização segue princípios de **Clean Architecture** com separação em camadas:

```
src
└── main
    └── java
        ├── application
        │   ├── etiqueta         # Geração de etiquetas com diferentes formatos
        │   ├── promocao         # Estratégias de promoção de frete
        │   └── resumo           # Serviço para resumos de pedido (painel/relatório)
        ├── domain
        │   ├── frete            # Estratégias de cálculo de frete
        │   └── model            # Entidades de domínio: Pedido, Entrega, Resultado
        └── exception            # Exceções específicas da aplicação
```

---

## 💡 Principais Conceitos Aplicados

| Conceito                | Descrição                                                                 |
|-------------------------|---------------------------------------------------------------------------|
| ✅ **Imutabilidade**     | Classes como `Entrega` e `Pedido` são imutáveis após criadas.             |
| ✅ **SRP (Responsabilidade Única)** | Cada classe tem apenas um motivo para mudar.                   |
| ✅ **OCP (Aberto/Fechado)** | Novas estratégias de frete ou promoções não exigem alteração de código existente. |
| ✅ **Strategy Pattern**  | Aplicado para o cálculo de frete e para o formato das etiquetas.          |
| ✅ **Null Object Pattern** | `PromocaoFreteSemDesconto` evita `null` e condicionais.                 |
| ✅ **Resultado<T>**      | Substitui exceções para validações de entrada, promovendo segurança de fluxo. |

---

## 🧪 Testes Automatizados

Testes unitários organizados conforme os pacotes da aplicação. Eles garantem:

- Criação correta de objetos (`Entrega`, `Pedido`);
- Cálculo correto de frete (normal e com promoção);
- Formatação correta de etiquetas;
- Lançamento de exceções específicas;
- Resumos formatados para relatórios ou painéis.

Rodar testes (via Maven):

```bash
./mvnw clean test
```
