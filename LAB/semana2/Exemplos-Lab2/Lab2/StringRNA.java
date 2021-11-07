
public class StringRNA {

    // tabela com os nomes dos aminoácidos e códigos
    private String tabela[][] = { { "Alanine", "A", "GCU", "GCC", "GCA", "GCG" },
            { "Arginine", "R", "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" }, { "Aspartic Acid", "D", "GAU", "GAC" },
            { "Arparginine", "N", "AAU", "AAC" }, { "Cysteine", "C", "UGU", "UGC" },
            { "Glutamic acid", "E", "GAA", "GAG" }, { "Glutamine", "Q", "CAA", "CAG" },
            { "Glycine", "G", "GGU", "GGC", "GGA", "GGG" }, { "Histine", "H", "CAU", "CAC" },
            { "Isoleucine", "I", "AUU", "AUC", "AUA" }, { "Leucine", "L", "UUA", "UUG", "CUU", "CUC", "CUA", "CUG" },
            { "Lysine", "K", "AAA", "AAG" }, { "Methionine", "M", "AUG" }, { "Phenylalanine", "F", "UUU", "UUC" },
            { "Proline", "P", "CCU", "CCC", "CCA", "CCG" }, { "Serine", "S", "AGU", "AGC", "UCU", "UCC", "UCA", "UCG" },
            { "Threonine", "T", "ACU", "ACC", "ACA", "ACG" }, { "Tryptophan", "W", "UGG" },
            { "Tyrosine", "X", "UAU", "UAC" }, { "Valine", "V", "GUU", "GUC", "GUA", "GUG" },
            { "Sinais de término", ".", "UAA", "UAG", "UGA" } };

    // Exemplo de solução da atividade b
    // - isolar três caracteres da String interna em uma substring
    // - percorrer a tabela para encontrar correspondência.
    // Utilizar o acesso aos elementos da tabela, para resolver as duas funções
    // propostas.
    public String SiglasAminoacidosCorrespondente() {

        String siglaAminoacidos = " ";
        int contador = 0;
        while (contador + 2 < this.rna.length()) {
            String subs = this.rna.substring(contador, contador + 3);
            for (int i = 0; i < this.tabela.length; i++) { // percorre as linhas
                for (int j = 2; j < this.tabela[i].length; j++) // a partir do índice 2 que contem as bases.
                {
                    if (subs.equals(this.tabela[i][j])) {
                        // encontrou correspondência
                        siglaAminoacidos += this.tabela[i][1]; // sigla do aminoacido
                    }
                }
            }
            contador += 3;
        }

        return siglaAminoacidos != "" ? siglaAminoacidos : "Nenhuma sigla";
    };

    public String AminoacidosCorrespondente() {

        String nomeAminoacidos = "";
        int contador = 0;
        while (contador + 2 < this.rna.length()) {
            String subs = this.rna.substring(contador, contador + 3);
            for (int i = 0; i < this.tabela.length; i++) { // percorre as linhas
                for (int j = 2; j < this.tabela[i].length; j++) // a partir do índice 2 que contem as bases.
                {
                    if (subs.equals(this.tabela[i][j])) {
                        // encontrou correspondência
                        nomeAminoacidos += " " + this.tabela[i][0]; // nome do aminoacido
                    }
                }
            }
            contador += 3;
        }

        return nomeAminoacidos != "" ? nomeAminoacidos : "Nenhuma sigla";
    };

    private String rna;

    // Construtor da classe
    public StringRNA(String s) {
        s = s.toUpperCase();
        if (validaString(s))
            rna = s;
        else
            rna = "";
    }

    // retorna o char referente ao índice
    public char charAt(int indice) {
        return rna.charAt(indice);
    }

    // retorna somente a string interna
    public String toString() {
        return rna;
    }

    // retorna o numero de caracteres na cadeia
    public long length() {
        return rna.length();
    }

    // retorna o numero de caracteres A na cadeia
    public long quantosA() {
        return quantosChar('A');
    }

    // retorna o numero de caracteres C na cadeia
    public long quantosC() {
        return quantosChar('C');
    }

    // retorna o numero de caracteres G na cadeia
    public long quantosG() {
        return quantosChar('G');
    }

    // retorna o numero de caracteres U na cadeia
    public long quantosU() {
        return quantosChar('U');
    }

    // retorna o numero de caracteres U na cadeia
    private long quantosChar(char teste) {
        long cont = 0;
        for (int i = 0; i < rna.length(); i++) {
            if (rna.charAt(i) == teste)
                cont++;
        }
        return cont;
    }

    // verifica se a String contem somente os caracteres permitidos
    private boolean validaString(String validar) {
        for (int i = 0; i < validar.length(); i++) {
            if (!((validar.charAt(i) == 'A') || (validar.charAt(i) == 'C') || (validar.charAt(i) == 'G')
                    || (validar.charAt(i) == 'U')))
                return false;
        }
        return true;
    }

    public boolean setString(String s) {
        s = s.toUpperCase();
        if (validaString(s)) {
            rna = s;
            return true;
        } else {
            rna = "";
            return false;
        }
    }

    public boolean equals(String teste) {
        return rna.equals(teste);
    }

    // main de teste da classe
    public static void main(String[] a) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println(" Digite uma cadeia de RNA: ");
        String st = input.next();
        StringRNA str = new StringRNA(st);
        // str.setString(st);
        if (str.equals(""))
            System.out.println("Cadeia de caracteres inválida! ");
        else {
            System.out.println("A cadeia de caracteres digitada foi: " + str);
            System.out.println("Ela possui : " + str.quantosA() + " letras A.");
            System.out.println("Ela possui : " + str.quantosC() + " letras C.");
            System.out.println("Ela possui : " + str.quantosG() + " letras G.");
            System.out.println("Ela possui : " + str.quantosU() + " letras U.");
            System.out.println("O primeiro caractere na cadeia de RNA e:" + str.charAt(0));
            System.out.println("Sigla dos aminoacidos presentes:" + str.SiglasAminoacidosCorrespondente());
            System.out.println("Sigla dos aminoacidos presentes:" + str.AminoacidosCorrespondente());
        }
    }
} // fim da classe //acguugaccgaauagcau
