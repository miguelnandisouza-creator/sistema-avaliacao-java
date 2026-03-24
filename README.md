# 📚 Sistema de Avaliação de Disciplina - POO

Um sistema completo em Java para automatizar o processo de avaliação de disciplinas, com suporte a cálculo de médias, recuperação e geração de relatórios.

## 🎯 Funcionalidades

✅ **Cálculo de Notas Bimestrais (N1, N2)**
- Média automática das avaliações de cada bimestre
- Exemplo: N1 = (Prova1 + Trabalho1) / 2

✅ **Cálculo de Média Semestral**
- Média aritmética entre N1 e N2
- M = (N1 + N2) / 2

✅ **Sistema de Recuperação**
- Verificação automática de direito à recuperação
- Critérios: Frequência ≥ 75% e Média entre 4.0 e 6.0 (exclusive)
- Substituição da menor nota

✅ **Relatórios Detalhados**
- Relatório individual do aluno
- Relatório de alunos em recuperação
- Relatório geral do sistema

✅ **POO com Interfaces**
- Interface `Avaliavel`: Define contrato para entidades avaliáveis
- Interface `Recuperavel`: Define contrato para recuperação
- Interface `Relatorio`: Define contrato para geração de relatórios

## 📁 Estrutura do Projeto

```
├── Avaliavel.java              # Interface para entidades avaliáveis
├── Recuperavel.java            # Interface para recuperação
├── Relatorio.java              # Interface para relatórios
├── Avaliacao.java              # Gerencia avaliações de um bimestre
├── Aluno.java                  # Entidade principal - Aluno
├── AlunosEmRecuperacao.java    # Coleção especializada de alunos
├── SistemaAvaliacao.java       # Facade do sistema
└── Main.java                   # Interface com usuário
```

## 🚀 Como Usar

### Compilação
```bash
javac *.java
```

### Execução
```bash
java Main
```

### Menu Principal
```
1. Registrar novo aluno
2. Registrar nota de recuperação
3. Processar recuperações
4. Relatório de aluno específico
5. Relatório de alunos em recuperação
6. Relatório geral do sistema
7. Sair
```

## 📝 Exemplo de Uso

```
Nome do aluno: João Silva
Matrícula: 12345
Frequência (%): 85

─ AVALIAÇÕES DO 1º BIMESTRE ─
Quantas avaliações? 2
Nome da avaliação 1: Prova 1
Nota (0-10): 7.5
Nome da avaliação 2: Trabalho 1
Nota (0-10): 8.0

─ AVALIAÇÕES DO 2º BIMESTRE ─
Quantas avaliações? 2
Nome da avaliação 1: Prova 2
Nota (0-10): 5.5
Nome da avaliação 2: Trabalho 2
Nota (0-10): 6.0
```

## 🏗️ Arquitetura e Design Patterns

### Interfaces
- **Avaliavel**: Define comportamentos para cálculo de média
- **Recuperavel**: Define comportamentos de recuperação
- **Relatorio**: Define comportamentos para geração de relatórios

### Classes Principais
- **Aluno**: Implementa todas as interfaces, representa um estudante
- **Avaliacao**: Gerencia conjunto de avaliações de um bimestre
- **AlunosEmRecuperacao**: Coleção especializada com operações filtragem
- **SistemaAvaliacao**: Facade que coordena todo o sistema

### Design Patterns Utilizados
- **Facade**: SistemaAvaliacao coordena as operações do sistema
- **Collections**: Uso de List, Map, Streams
- **Encapsulamento**: Getters/Setters bem definidos

## 📊 Critérios de Aprovação

### Aprovação Direta
- Média Semestral ≥ 6.0

### Direito à Recuperação
- Frequência ≥ 75%
- Média Semestral ≥ 4.0 e < 6.0

### Média Final com Recuperação
- Mfinal = (max(N1, N2) + R) / 2
- Onde R é a nota de recuperação

## 🛠️ Requisitos
- Java 8 ou superior
- JDK instalado

## 📦 Compilação e Execução no VS Code

1. Abra a pasta do projeto no VS Code
2. Terminal → New Terminal
3. Compile: `javac *.java`
4. Execute: `java Main`

## 👥 Autor
Desenvolvido com POO e boas práticas de programação

## 📄 Licença
Open Source