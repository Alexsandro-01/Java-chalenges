import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Principal registra o controle de acesso com
 * base na idade dos usuários e imprime um relatório
 * no final da execução.
 */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Principal principal = new Principal();

    // ESCREVA SEU CÓDIGO AQUI
    boolean finishProgram = false;

    ArrayList<Short> users = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    while (!finishProgram) {

      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n"
          + "2 - Finalizar sistema e mostrar relatório");

      short option = scanner.nextShort();

      if (option == 1) {
        System.out.println("Entre com a idade:");

        short userAge = scanner.nextShort();

        String message = principal.checkUserAge(userAge);

        System.out.println(message);
        users.add(userAge);

      } else if (option == 2) {
        finishProgram = true;
        principal.report(users);
      } else {
        System.out.println("Entre com uma opção válida!");
      }
    }

    scanner.close();
  }

  /**
   * método checa qual mensagem deve retornar com base
   * na idade do usuário.
   *
   * @param userAge a idade do usuário.
   * @return a mensagem a ser impressa.
   */
  public String checkUserAge(Short userAge) {
    if (userAge < 18) {
      return "Pessoa cliente menor de idade, catraca liberada!";
    } else if (userAge <= 49) {
      return "Pessoa adulta, catraca liberada!";
    } else {
      return "Pessoa adulta a partir de 50, catraca liberada!";
    }
  }

  /**
   * Método para imprimir o relatório com a qunatidade e
   * porcentagem de cada faixa etária de usuários que passaram
   * pelo sistema.
   *
   * @param users lista com as idades dos usuários.
   */
  public void report(ArrayList<Short> users) {
    short underEighteen = 0;
    short adult = 0;
    short oldPerson = 0;

    for (short age : users) {
      if (age < 18) {
        underEighteen += 1;
      } else if (age <= 49) {
        adult += 1;
      } else {
        oldPerson += 1;
      }
    }

    int usersSize = users.size();

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + underEighteen);
    System.out.println("adultas: " + adult);
    System.out.println("a partir de 50: " + oldPerson);

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + calcPercentage(underEighteen, usersSize) + "%");
    System.out.println("adultas: " + calcPercentage(adult, usersSize) + "%");
    System.out.println("a partir de 50: " + calcPercentage(oldPerson, usersSize) + "%");
  }

  /**
   * Metodo para calcular a pocentagem de cada grupo de usuários
   * com base na idade.
   *
   * @param quant quantidade de usuários de determinada idade.
   * @param size  quantidade total de usuários.
   * @return retorna a pocentagem desse grupo de usuários.
   */
  public String calcPercentage(int quant, int size) {
    String pattern = "00.0";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    double percent = (((float) quant / size) * 100);

    return decimalFormat.format(percent);
  }
}
