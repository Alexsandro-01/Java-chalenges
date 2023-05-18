import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe Conversor.
 */
public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   */
  public static void main(String[] args) {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados
   * na pasta de saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas   Pasta em que serão colocados os arquivos gerados no formato
   *                        requerido pelo subsistema.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) {

    if (!pastaDeSaidas.exists()) {
      boolean wasSuccesfull = pastaDeSaidas.mkdirs();

      if (!wasSuccesfull) {
        System.out.println("Não foi possível criar o diretório");
      }
    }

    for (File file : Objects.requireNonNull(pastaDeEntradas.listFiles())) {
      ArrayList<String> lines = readFile(file);
      writeFile(pastaDeSaidas, file.getName(), lines);
    }
  }

  private ArrayList<String> readFile(File inputFile) {
    ArrayList<String> lines = new ArrayList<>();

    try {
      FileReader reader = new FileReader(inputFile);
      BufferedReader bufferedReader = new BufferedReader(reader);

      String lineContent = bufferedReader.readLine();

      boolean isFirstLine = true;

      while (lineContent != null) {
        if (isFirstLine) {
          lines.add(lineContent);
          isFirstLine = false;

        } else {
          String formattedLine = formatString(lineContent);
          lines.add(formattedLine);
        }

        lineContent = bufferedReader.readLine();
      }

      reader.close();
      bufferedReader.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    return lines;
  }

  /**
   * Método para transformar as linhas do arquivo csv
   * no formato esperado pelo programa com base nas regras de negócio.
   *
   * @param lineToFormat linhas do arquivo csv para ser trasnformada.
   * @return linha trasnformada para o padrão esperado.
   */
  public String formatString(String lineToFormat) {
    String[] infos = lineToFormat.split(",");

    String name = infos[0].toUpperCase();
    String[] date = infos[1].split("/");
    String isoDate = date[2] + "-" + date[1] + "-" + date[0];

    String email = infos[2];
    String cpf = infos[3].replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    return MessageFormat.format("{0},{1},{2},{3}", name, isoDate, email, cpf);
  }

  private void writeFile(
      File pastaDeSaidas,
      String fileName,
      ArrayList<String> lines
  ) {
    String pathName = pastaDeSaidas.getAbsolutePath() + File.separator + fileName;

    try {
      FileWriter writer = new FileWriter(pathName);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      for (String line : lines) {
        bufferedWriter.write(line + "\n");
      }

      bufferedWriter.flush();

      bufferedWriter.close();
      writer.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
