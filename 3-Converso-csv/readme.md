## Conversor de CSV

**Programa em Java que converte os arquivos para o formato requerido pelo subsistema.**


## Descrição dos arquivos de entrada e saída

Os arquivos CSV estão disponíveis na pasta `entradas`, estando separados por estado. Por exemplo: `sp.csv`, `mg.csv`, `ba.csv` (não limitado a esses três!). Para cada arquivo contido na pasta `entradas`, o programa cria um arquivo correspondente com o mesmo nome na pasta `saidas`.

Os arquivos de entrada podem são tratados como arquivos de texto e possuem a seguinte estrutura-padrão: 

- A primeira linha é sempre um cabeçalho fixo que contém os nomes das colunas separados por vírgula:

```text
Nome completo,Data de nascimento,Email,CPF
```

- Cada uma das linhas seguintes contém as informações de um inscrito, também separadas por vírgula. Exemplo:

```text
Moacir Monforte,04/07/1986,monforte@yahoo.com,72614377279
```

São garantidas as seguintes condições a respeito dos arquivos de entrada:

- Toda data de nascimento está em formato brasileiro: `dd/mm/aaaa`
- Todo email é válido
- Todo CPF é válido e composto por exatamente 11 dígitos decimais (sem ponto nem hífen)

Os nomes completos dos inscritos podem estar em letras maiúsculas, minúsculas ou meio a meio.

A formatação requerida para os arquivos de saída são a seguinte:

- O cabeçalho é o mesmo dos arquivos de entrada.
- Os nomes completos dos inscritos são padronizados todos em letras maiúsculas (acentos gráficos devem ser mantidos).
- As datas de nascimento estão no formato ISO-8601: `aaaa-mm-dd`.
- Os números de CPF devem estão corretamente formatados com ponto e hífen. Exemplo: `123.456.789-09`.

As linhas dos arquivos de saída estão dispostas na mesma ordem que as dos arquivos de entrada.

## Exemplo

Para o arquivo de entrada a seguir: `entradas/sp.csv`

```text
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,29/06/2001,tapereba@gmail.com,81627775471
catarina mafra,28/05/1991,cmafra@gmail.com,75157671466
bento naves,25/12/1993,b.naves@aol.com,88826690685
Lurdes Neves,08/04/1985,lurdes.neves85@verizon.net,92277079138
```

Será produzido o seguinte arquivo de saída: `saidas/sp.csv`

```text
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,2001-06-29,tapereba@gmail.com,816.277.754-71
CATARINA MAFRA,1991-05-28,cmafra@gmail.com,751.576.714-66
BENTO NAVES,1993-12-25,b.naves@aol.com,888.266.906-85
LURDES NEVES,1985-04-08,lurdes.neves85@verizon.net,922.770.791-38
```

## Requisitos do código

O código foi construído a partir da classe `Conversor` abaixo:

```java
import java.io.File;
import java.io.IOException;

public class Conversor {

  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    // TODO: Implementar.
  }
}
```

---