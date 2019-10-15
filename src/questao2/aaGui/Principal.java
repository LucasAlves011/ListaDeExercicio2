package questao2.aaGui;

import questao2.anegocio.ControladorMidia;
import questao2.dados.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        /**
         * Questão 2
         * @autor Lucas Alves - IP2 - Prof: Vanilson Buréguio
         */


        /**
         * Criando controlador
         */
        ControladorMidia sinalizador = ControladorMidia.getInstance();

        /**
         * Dados Lucas
         */
        LocalDate dataLucas = LocalDate.of(1998,11,11);
        ArrayList<Categorias> cateLucas = new ArrayList<>();
        cateLucas.add(Categorias.GAMEPLAY);
        cateLucas.add(Categorias.POLICIAL);
        cateLucas.add(Categorias.COMEDIA);
        cateLucas.add(Categorias.CULINARIA);

        Produtor lucas = new Produtor("Lucas Alves","emailLucasProdutor.com",dataLucas,"Canal do Lucas",cateLucas);

        sinalizador.cadastrar(lucas);

        /**
         * Dados Paulo
         */
        LocalDate dataPaulo = LocalDate.of(1997,4,13);
        ArrayList<Categorias> catePaulo = new ArrayList<>();
        catePaulo.add(Categorias.VIDEOAULA);
        catePaulo.add(Categorias.ACAO);
        catePaulo.add(Categorias.MUSICA);
        catePaulo.add(Categorias.DRAMA);

        Produtor paulo = new Produtor("Paulo Ricardo","emailPauloProdutor.com",dataPaulo,"Canal do Paulo",catePaulo);
        sinalizador.cadastrar(paulo);

        /**
         * Dados Laura
         */
        ArrayList<Categorias> cateLaura = new ArrayList<>();
        cateLaura.add(Categorias.TEEN);
        cateLaura.add(Categorias.COMEDIA);
        cateLaura.add(Categorias.TUTORIAL);
        cateLaura.add(Categorias.REVIEW);

        Produtor laura = new Produtor("Laura Freitas","emailLauraProdutora.com",LocalDate.of(1999,9,13),"Canal da Laura",cateLaura);
        sinalizador.cadastrar(laura);

        ////////////////////////////////////////////

        Consumidor isabella = new Consumidor("Isabella Rodrigues","isabellaalvesrodrigues@consu.com",LocalDate.of(1988,1,29),selecionarCategorias());
        sinalizador.cadastrar(isabella);

        Consumidor rafael = new Consumidor("Rafael Dias","rafaelbarbosadias@consu.com",LocalDate.of(1973,3,18),selecionarCategorias());
        sinalizador.cadastrar(rafael);

        Consumidor gabrielle = new Consumidor("Gabrielle Barbosa","gabriellerodriguesbarbosa@consu.com",LocalDate.of(2010,4,4),selecionarCategorias());
        sinalizador.cadastrar(gabrielle);

        Consumidor roberto = new Consumidor("Roberto Bales","robertocbales@consu.com",LocalDate.of(1979,6,26),selecionarCategorias());
        sinalizador.cadastrar(roberto);

        Consumidor gabriel = new Consumidor("Gabriel Martins","gabrielcorreiamartins@consu.com",LocalDate.of(1994,4,20),selecionarCategorias());
        sinalizador.cadastrar(gabriel);

        Consumidor vitoria = new Consumidor("Vitoria","vitoriabarrosrodrigues@consu.com",LocalDate.of(2001,7,12),selecionarCategorias());
        sinalizador.cadastrar(vitoria);

        Consumidor fernanda = new Consumidor("Fernannda Souza","fernandabarbosasouza@consu.com",LocalDate.of(2013,3,2),selecionarCategorias());
        sinalizador.cadastrar(fernanda);

        sinalizador.remover(fernanda);

        System.out.println("Lista de todos os usuários maiores de 16 anos: \n\n"+sinalizador.listarPorIdade(16));

        System.out.println("\n\n\n\n\n");
        System.out.println("Lista de todos os usuários da classe consumidor: \n\n"+sinalizador.listarPorTipo(Consumidor.class));

        ///////////////////////////////////////////////////////

        Midia m1 = new Midia(LocalDateTime.of(2017,2,10,5,21),"Video de Apresentação",12,Categorias.GAMEPLAY,lucas);
        sinalizador.cadastrarMidia(m1);

        Midia m2 = new Midia(LocalDateTime.of(2019,8,21,4,57),"Segundo vídeo",14,Categorias.CULINARIA,lucas);
        sinalizador.cadastrarMidia(m2);

        Midia m3 = new Midia(LocalDateTime.of(2017,7,19,13,18),"Video divertido",18,Categorias.COMEDIA,lucas);
        sinalizador.cadastrarMidia(m3);

        Midia m4 = new Midia(LocalDateTime.of(2018,1,20,9,20),"Correndo atras do carteiro",16,Categorias.ACAO,paulo);
        sinalizador.cadastrarMidia(m4);

        Midia m5 = new Midia(LocalDateTime.of(2018,11,26,22,17),"Review motoZ3 play",10,Categorias.REVIEW,laura);
        sinalizador.cadastrarMidia(m5);

        Midia m6 = new Midia(LocalDateTime.of(2019,10,4,16,14),"Tutorial Java #05",-1,Categorias.TUTORIAL,laura);
        sinalizador.cadastrarMidia(m6);

        Midia m7 = new Midia(LocalDateTime.of(2019,5,7,9,43),"Maquiagem !! Como escolher os produtos certo ?!",10,Categorias.TEEN,laura);
        sinalizador.cadastrarMidia(m7);

        Midia m8 = new Midia(LocalDateTime.of(2018,8,14,3,0),"Passeando no parque",-1,unicaCategoria(),paulo);
        sinalizador.cadastrarMidia(m8);

        sinalizador.removerMidia(m8);

        System.out.println("\n\n\n\nLista de todas as midias que tem a faixa etaria maior que 14 anos: \n\n"+sinalizador.listarMidiaPorIdade(14));

        System.out.println("\n\n\n\nListando todas as midia da categoria Tutorial \n\n\n\n"+sinalizador.listarPorCategoria(Categorias.TUTORIAL));


        /**
         * Arrays usados pelas funções estaticas para aleatorizar algumas escolhas
         */
        Midia[] pMidias = new Midia[]{m1,m2,m3,m4,m5,m6,m7};
        Consumidor[] pConsumidores = new Consumidor[]{fernanda,gabriel,gabrielle,rafael,roberto,vitoria};

        /**
         * Criei um metodo estatico da propria classe principal que aleatoriza as combinações
         * de Midia e Consumidor para criar varias classes de ReproduzirMidia diferetes . E que vai
         * rodar 20 vezes no FOR
         */
        for (int i=0;i<20;i++) {
            sinalizador.adicionar(criarReproduçãoMidiaAuto(pMidias, pConsumidores));
        }

        System.out.println("\n\n\n\nLista todas as reproduções de midia: \n\n"+sinalizador.listarTudo()+"\n\n\n");


        /**
         * Criei uma nova instancia do controlador para testar o padrão singlenton
         */
        ControladorMidia segundoSinalizador = ControladorMidia.getInstance();
        System.out.println(segundoSinalizador.listarPorPeriodo(LocalDateTime.of(2018,12,30,23,58),LocalDateTime.of(2019,12,30,23,58)));

        System.out.println("\n\n\n\n\nLista de reproduções de um unico usuario\n\n"+segundoSinalizador.listarPorPessoa(selecionarUsuario(pConsumidores))+"\n\n\n\n\n");

        ArrayList<Categorias> listaTeste = new ArrayList<>();
        listaTeste.add(Categorias.GAMEPLAY);
        listaTeste.add(Categorias.MUSICA);
        listaTeste.add(Categorias.TEEN);

        System.out.println(segundoSinalizador.listarPorCategorias(listaTeste));
    }
    public static ArrayList<Categorias> selecionarCategorias(){
        int numero =(int) (Math.random()*15) +1;
        ArrayList<Categorias> request = new ArrayList<>();

        Categorias[] escolhas = new Categorias[]{Categorias.ACAO,Categorias.COMEDIA,Categorias.DRAMA,Categorias.POLICIAL,Categorias.ADULTO,Categorias.CULINARIA,Categorias.GAMEPLAY,Categorias.MUSICA,Categorias.PEGADINHA,Categorias.TEEN,Categorias.VIDEOAULA,Categorias.INFANTIL,Categorias.REVIEW,Categorias.TUTORIAL,Categorias.VLOG};

        int k ;
        for (int i = 0 ; i < numero ; ){
            k = (int)(Math.random()*15);
            if (!(request.contains(escolhas[k]))){
                request.add(escolhas[k]);
                i++;
            }
        }
        return request;
    }

    public static Categorias unicaCategoria(){
        int numero = (int) (Math.random()*15);
        Categorias[] escolhas = new Categorias[]{Categorias.ACAO,Categorias.COMEDIA,Categorias.DRAMA,Categorias.POLICIAL,Categorias.ADULTO,Categorias.CULINARIA,Categorias.GAMEPLAY,Categorias.MUSICA,Categorias.PEGADINHA,Categorias.TEEN,Categorias.VIDEOAULA,Categorias.INFANTIL,Categorias.REVIEW,Categorias.TUTORIAL,Categorias.VLOG};

        return escolhas[numero];
    }

    public static ReproduzirMidia criarReproduçãoMidiaAuto(Midia[] midias, Consumidor[] consumidores){
        int numM =(int) (Math.random()* midias.length);
        int numC =(int) (Math.random()* consumidores.length);

        ReproduzirMidia temp = new ReproduzirMidia(midias[numM],consumidores[numC]);
        return temp;
    }

    public static Consumidor selecionarUsuario(Consumidor[] consumidores){
        int numC =(int) (Math.random()* consumidores.length);
        return consumidores[numC];
    }
}
