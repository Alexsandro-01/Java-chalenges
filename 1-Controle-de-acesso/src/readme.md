# Descrição do desafio: Sistema de Controle de Acesso

O objetivo do desafio foi desenvolver um sistema que deveria apresentar um relatório que divide as pessoas que acessaram o estabelecimento em três categorias:

1. Pessoas menores de 18 anos,
2. Pessoas adultas (entre 18 e 49 anos), e
3. Pessoas a partir de 50 anos.

Esse sistema apresenta um menu, no console, indicando a opção de acessar o estabelecimento e a opção de finalizar o sistema e mostrar um relatório. O fluxo do sistema é definido seguindo duas etapas principais que são executadas na seguinte ordem:

1. **Inserir idade de pessoa cliente no sistema:** essa etapa se repete até que a opção de finalizar o sistema seja escolhida. A idade das pessoas clientes foram armazenadas em um array de tamanho dinâmico, já que não sabemos quantas pessoas clientes chegarão ao estabelecimento. Utilizei a classe `ArrayList` do Java para a criação e manipulação de arrays de tamanho dinâmico. Mais informações você pode consultar o site da [W3Schools](https://www.w3schools.com/java/java_arraylist.asp) ou [JavaPoint](https://www.javatpoint.com/java-arraylist), ou então verificar a documentação da Oracle.

2. **Finalizar o sistema e mostrar o relatório:** nessa etapa, o laço de repetição é terminado e então o relatório é impresso no console. O relatório contém o total de pessoas que acessaram o estabelecimento, e também o número de pessoas menores de 18 anos, o número de pessoas adultas (entre 18 e 49 anos) e o número de pessoas a partir de 50 anos que acessaram o estabelecimento. O relatório também calcula, em relação ao total de pessoas, a porcentagem delas que eram menores de 18, que eram adultas (entre 18 e 49), e as a partir de 50.

Esse sistema tem a classe `Principal`, contendo nela o método `main`. No método `main`, tem uma instância da classe `Scanner` para poder ler as entradas da pessoa usuária pelo console e um laço de repetição que representa o menu da aplicação. Dessa forma podemos registrar a entrada de todas as pessoas que chegarem durante o expediente.

- O menu deve tem o formato:

    ```
    Entre com o número correspondente à opção desejada:
    1 - Acessar o estabelecimento
    2 - Finalizar sistema e mostrar relatório
    ```
Se a pessoa usuária entrar com o valor 1 (que indica que ela quer acessar o estabelecimento), então a mensagem `Entre com a idade:` será impressa no console. Em seguida, depois de inserir a idade da pessoa cliente e pressionar enter, aparecerá uma das mensagens listadas abaixo:

- `Pessoa cliente menor de idade, catraca liberada!`: se a idade da pessoa inserida for menor que 18 anos.

- `Pessoa adulta, catraca liberada!`: se a idade da pessoa inserida for igual ou maior que 18 anos, e menor ou igual a 49 anos.

- `Pessoa adulta a partir de 50, catraca liberada!`: se a idade da pessoa inserida for a partir de 50 anos.

Depois que a mensagem for impressa, então retornará ao estado inicial do menu. Supondo que a idade da primeira pessoa seja 18 anos, um exemplo do conteúdo do console depois de inserir a idade da primeira pessoa cliente será:
```
Entre com o número correspondente à opção desejada:
1 - Acessar o estabelecimento
2 - Finalizar sistema e mostar relatório
1
Entre com a sua idade:
18
Pessoa adulta, catraca liberada!
Entre com o número correspondente à opção desejada:
1 - Acessar o estabelecimento
2 - Finalizar sistema e mostrar relatório
```
Esse ciclo se repete até a opção 2 ser escolhida, o que indica que a pessoa usuária quer finalizar o expediente e imprimir o relatório.

## Relatório

O relatório é impresso no console quando a opção 2 for selecionada. Supondo que 200 pessoas visitaram o estabelecimento, o relatório deve conter as seguintes informações:

- Número total de pessoas que visitaram o estabelecimento: nesse caso, esse valor deverá ser 200.

- Número de pessoas menores de 18 anos que visitaram o estabelecimento: supondo que, das 200 pessoas, 20 eram menores de 18 anos, então no relatório esse valor deverá ser 20.

- Número de pessoas adultas (entre 18 e 49 anos) que visitaram o estabelecimento: supondo que, das 200 pessoas, 150 eram adultas entre 18 e 49 anos, então esse valor deverá ser 150.

- Número de pessoas a partir de 50 anos que visitaram o estabelecimento: supondo que, das 200 pessoas, 30 tinham a partir de 50, então esse valor deverá ser 30.


O relatório também calcula a porcentagem de pessoas em cada categoria em relação ao total de pessoas. Ainda seguindo a suposição anterior, o total de visitas ao estabelecimento foi de 200 pessoas, então o relatório na parte dos números percentuais deve apresentar:

- Percentual de pessoas menores de 18 anos que visitaram o estabelecimento: supondo que, das 200 pessoas, 20 eram menores de 18 anos, então no relatório esse valor deverá ser 10.0%.

- Número de pessoas adultas (entre 18 e 49 anos) que visitaram o estabelecimento: supondo que, das 200 pessoas, 150 eram adultas entre 18 e 49 anos, então esse valor deverá ser 75.0%.

- Número de pessoas a partir de 50 anos que visitaram o estabelecimento: supondo que, das 200 pessoas, 30 tinham a partir de 50, então esse valor deverá ser 15.0%.

Para essa suposição, a saída do relatório é similar à saída abaixo:
```
----- Quantidade -----
menores: 20
adultas: 150
a partir de 50: 30

----- Percentual -----
menores: 10.0%
adultas: 75.0%
a partir de 50: 15.0%

TOTAL: 200
```

## Restrições

- Caso a opção inserida pela pessoa usuária seja um valor diferente de 1 ou de 2, a mensagem `Entre com uma opção válida!` é impressa no console, e o menu voltar para o estado inicial.

## Exemplo

Aqui tem outro exemplo da saída do relatório, considerando que 173 pessoas visitaram o estabelecimento, das quais 34 eram menores de 18 anos, 108 eram adultas entre 18 e 49 anos de idade, e 31 tinham a partir de 50 anos:
```
----- Quantidade -----
menores: 34
adultas: 108
a partir de 50: 31

----- Percentual -----
menores: 19.65%
adultas: 62.43%
a partir de 50: 17.92%

TOTAL: 173
```
---
