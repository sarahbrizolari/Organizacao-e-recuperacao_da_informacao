import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public abstract class Conta implements IConta {
    public Conta() {
    }


    public Conta(int numero, String descricao, String tipo, Date dataAbertura, String diaAbertura, String mesAbertura, String anoAbertura) {
        this.numero = numero;
        this.descricao = descricao;
        this.tipo = tipo;
        this.diaAbertura = diaAbertura;
        this.mesAbertura = mesAbertura;
        this.anoAbertura = anoAbertura;
        this.dataAbertura = dataAbertura;
    }

    private int id;
    private int numero;
    private String descricao;
    private String tipo;
    private String diaAbertura;
    private String mesAbertura;
    private String anoAbertura;
    private int diff;

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    private Date dataAbertura;

    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDiaAbertura() {
        return diaAbertura;
    }

    public void setDiaAbertura(String diaAbertura) {
        this.diaAbertura = diaAbertura;
    }

    public String getMesAbertura() {
        return mesAbertura;
    }

    public void setMesAbertura(String mesAbertura) {
        this.mesAbertura = mesAbertura;
    }

    public String getAnoAbertura() {
        return anoAbertura;
    }

    public void setAnoAbertura(String anoAbertura) {
        this.anoAbertura = anoAbertura;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    @Override
    public String getNumeroContaComTipo(int numeroConta, String tipoConta) {
        this.numero = numeroConta;
        this.tipo = tipoConta;
        return "'Conta Numero': '" + numero + "' 'Tipo': '" + tipo;
    }

    @Override
    public int getNumeroDiasAberto(Date diaAbertura) {
        Date dataAtual = Date.from(Calendar.getInstance().toInstant());
        return (int) (ChronoUnit.DAYS.between(getDataAbertura().toInstant(), dataAtual.toInstant()));
    }

    @Override
    public String toString() {
        return "{" + getNumeroContaComTipo(this.getNumero(), this.getTipo()) + '\'' +
                new Tipo(this.getId(), this.getDescricao()) +
                ", 'data De Abertura' = '" + getDiaAbertura() + "\\" + getMesAbertura() + "\\" + getAnoAbertura() + '\'' + " }\n"
                + "{Sua conta esta a " + getDiff() + " dias aberta!";
    }

    public void gerarLogTxt(int id, int numero, String tipo, String descricao, Date dataAbertura){
        String path = "D:\\Logatti 6º Semestre\\Organização e recuperação da Informação\\Exercicios\\Ex_Aula5\\txt\\contas.txt";

        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;

        FileWriter arq = null;
           try{
            arq = new FileWriter(path);

            int n;
            PrintWriter gravarArq = new PrintWriter(arq);

            for (n = 0; n <=1; n++) {
                gravarArq.printf("Dados do Cliente: ");
                gravarArq.printf("'id': '" +  id + '\'');
                gravarArq.printf(" 'Número da conta': '" + numero + '\'');
                gravarArq.printf(" 'Tipo da conta': " + tipo + '\'');
                gravarArq.printf(" 'Descrição': '" +descricao + '\'');
                gravarArq.printf(" 'Data da Abertura': " + dataAbertura + '\'');
                n++;
            }
            gravarArq.println("\n+----------------------------------------------------------------+");
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dados Bancários Salvos com sucesso");
    }
    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }


}