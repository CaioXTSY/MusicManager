import java.util.*;

public class MusicManager {

    private static List<String> nomes = new ArrayList<>();
    private static List<String> artistas = new ArrayList<>();
    private static List<String> generos = new ArrayList<>();
    private static List<Integer> ids = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adicionarMusica();
                    break;
                case 2:
                    removerMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    escolherMusicaAleatoria();
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("[1] Adicionar musica");
        System.out.println("[2] Remover musica");
        System.out.println("[3] Listar musicas");
        System.out.println("[4] Escolher musica aleatória");
        System.out.println("[5] Adios");
    }

    private static void adicionarMusica() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da musica:");
        nomes.add(sc.nextLine());
        System.out.println("Digite o nome do artista:");
        artistas.add(sc.nextLine());
        System.out.println("Digite o gênero da música:");
        generos.add(sc.nextLine());
        int id = random.nextInt(10000);
        ids.add(id);
        System.out.println("Música adicionada com o ID: " + id);
    }

    private static void removerMusica() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID da música para remover:");
        int id = sc.nextInt();
        int index = ids.indexOf(id);
        if(index != -1) {
            nomes.remove(index);
            artistas.remove(index);
            generos.remove(index);
            ids.remove(index);
            System.out.println("Música removida com o ID: " + id);
        } else {
            System.out.println("ID não encontrado");
        }
    }

    private static void listarMusicas() {
        System.out.println("--- Músicas ---");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Nome: " + nomes.get(i) + ", Artista: " + artistas.get(i) + ", Gênero: " + generos.get(i) + ", ID: " + ids.get(i));
        }
    }

    private static void escolherMusicaAleatoria() {
        if (!nomes.isEmpty()) {
            int index = random.nextInt(nomes.size());
            System.out.println("Nome: " + nomes.get(index) + ", Artista: " + artistas.get(index) + ", Gênero: " + generos.get(index) + ", ID: " + ids.get(index));
        } else {
            System.out.println("Nenhuma música disponível");
        }
    }
}
