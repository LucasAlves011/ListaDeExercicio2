package questao3.dados;

import questao3.negocio.ControladorRECnPlay;
import questao3.negocio.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TesteQuestão3 {
    public static void main(String[] args) {

        ControladorRECnPlay sinalizador = ControladorRECnPlay.getInstace();

  Palestrante gustavo = new Palestrante("Gustavo Franco","emailgustavoFranco.com",LocalDate.of(1980,05,13),"São Paulo","Empresa X");

  Palestra p1 = new Palestra("A inovação financeira e o sistema financeiro do futuro",gustavo,"Palesta sobre como as inovações tecnológicas financeiras podem influenciar o sistema financeiro.",LocalDateTime.of(2019,10,2,10,00),"Teatro Apolo",Trilha.TECNOLOGIA);
  sinalizador.cadastrarPalestra(p1);


  Palestrante simone = new Palestrante("Simone Zelaquett","simoneEmailZelaquett.com",LocalDate.of(1981,5,5),"Jaboatão dos Guararapes","Accenture");

  Palestra p2 = new Palestra("Apresentação do humanoide NAO",simone,"Nessa atividade os participantes assistirão a performance do Nao- humanóide prigramado por estudantes da rede municipal do Recife,\napresetações de Yoga e Dança que serão contagiantes e motivarão a interação dos presentes.",LocalDateTime.of(2019,10,2,11,15),"Accenture Innovation Center",Trilha.TECNOLOGIA);
  sinalizador.cadastrarPalestra(p2);

  Palestrante andrea = new Palestrante("Andrea Pinho","andreaPinhEmail.com",LocalDate.of(1977,10,4),"Cabo de Santo Agostinho","Prefeitura do Recife");

  Palestra p3 = new Palestra("Imprensa Mirim",andrea,"Durante o evento os palestrantes serão intrevistados como pauta da Cobertura jonalística das ações do Rec'n'Play, realizadas \npor estudantes da Prefeitura do Recife. Muitos Participantes poderão compopr com os palestrantes as entrevistas prestando depoimentos sobre o evento e suas impressões e novas aprendizagens.",LocalDateTime.of(2019,10,2,10,00),"Porto Digital",Trilha.ECONOMIA_CRIATIVA);
  sinalizador.cadastrarPalestra(p3);


    Palestrante mariana = new Palestrante("Mariana Moura","mariaMouraEmail.com",LocalDate.of(1991,4,2),"Porto Alegre","Grupo Moura");

    Palestra p4 = new Palestra("Educação experimental para famílias empresárias.",mariana,"Uma conversa com os sócios e membros da Escola F para debater um novo modelo educacional voltado para famílias empresárias.\nUm modelo de negócio colaborativo que valoriza a aprendizagem a partir da troca de experiências, investe na facilitção de grupos\n para gerar conhecimento e desenvolvimento, por meio da construção de entendimentos e não apenas a partir de conteúdos externos.",LocalDateTime.of(2019,10,4,10,00),"Cesar Bom Jesus - Sala Garagem (5º andar)",Trilha.CIDADES);
    sinalizador.cadastrarPalestra(p4);

    Palestrante silvio = new Palestrante("Silvio Meira","silvioEmail.com",LocalDate.of(1974,12,15),"São Lourenço da Mata","UFPE");

    Palestra p5 = new Palestra("Como você e sua empresa irão sobreviver ao apocalipse digital?",silvio,"Talk Show com o renomado líder de setor de inovação que conversará sobre o tema da transformação digital.",LocalDateTime.of(2019,10,5,10,00),"Cais do Setão - Auditório",Trilha.CIDADES);
    sinalizador.cadastrarPalestra(p5);


    ////////////////////////////////////////////////////////

    Participante thiago = new Participante("Thiago Barbosa","ThiagoBarbosaCavalcanti@gmail.com",LocalDate.of(1989,2,12),"Recife",Trilha.CIDADES);
      sinalizador.realizarInscricao(thiago);

    Participante gabriel = new Participante("Gabriel Ribeiro","GabrielCastroRibeiro@gmail.com",LocalDate.of(1996,5,16),"Joãao Pessoa",Trilha.TECNOLOGIA);
      sinalizador.realizarInscricao(gabriel);

    Participante matilda = new Participante("Matilda Alves","matildadeAvis@hotmail.com",LocalDate.of(1977,5,6),"Rio de Janeiro",Trilha.ECONOMIA_CRIATIVA);
      sinalizador.realizarInscricao(matilda);

    Participante carlos = new Participante("Carlos Fernandes","CarlosCunhaFernandes@yahoo.com",LocalDate.of(1985,5,30),"Florianópolis",Trilha.CIDADES);
      sinalizador.realizarInscricao(carlos);

    Participante sarah = new Participante("Sarah Sousa","sarahOliveiraSoousa@duckDuck.com",LocalDate.of(1979,2,19),"Cuiabá",Trilha.TECNOLOGIA);
      sinalizador.realizarInscricao(sarah);

    Participante luiz = new Participante("Luiz Costa","luizDeAlmeidaCosa@gmail.com",LocalDate.of(1999,1,11),"Camaragibe",Trilha.ECONOMIA_CRIATIVA);
      sinalizador.realizarInscricao(luiz);

    Participante isabelle = new Participante("Isabelle Oliveira","isabelOlili@gmail.com",LocalDate.of(2000,9,17),"Sabará",Trilha.CIDADES);
      sinalizador.realizarInscricao(isabelle);

    Participante laura = new Participante("Laura Freitas","MyloveLauras2@gmail.com",LocalDate.of(1997,8,28),"Recife",Trilha.CIDADES);
      sinalizador.realizarInscricao(laura);

    Participante katarina  = new Participante("Katarina Silva","katSilvers2@love.com",LocalDate.of(1998,Month.APRIL,13),"Curitiba",Trilha.TECNOLOGIA);
      sinalizador.realizarInscricao(katarina);

      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      Palestra[] arrayPalestra = new Palestra[] {p1,p2,p3,p4,p5};
      Participante[] arrayParticipante = new Participante[] {thiago,gabriel,matilda,carlos,sarah,luiz,isabelle,laura,katarina};

      Avaliacao[] p = new Avaliacao[15];

      //Metodo STATICO usado para construir avaliações aleatorias e "procedurais"
      for (int i=0;i<15;i++){
        p[i] = criadorDeAvalicaoAle(arrayPalestra,arrayParticipante);
       sinalizador.avaliarPalestra(p[i]);
      }

      System.out.println(sinalizador.listarParticipanteComIdadeMaior(39)+"\n\n\n\n\n");

      System.out.println("Palestras com nota maior que :"+sinalizador.listarPalestraPorNota(3)+"\n\n\n\n\n\n");

      System.out.println("Palestras ordenadas por ordem de nota: "+sinalizador.listarOrdenadas());

    }
    public static Avaliacao criadorDeAvalicaoAle(Palestra[] palestras , Participante[] participantes){
     int nota =  (int) (Math.random()*6);
     String comentario = "  ";

      int escolhaComent = (int) (Math.random()*5);

      switch (nota){
         case 0:
           String[] case0 = new String[]{"Muito ruim,horrorosso , patético","Péssimo palestrante","Local com infraestutura precária","Pior palestra da minha vida","Palestrante so falou merda ,perca de tempo"};
           comentario = case0[escolhaComent];
           break;

           case 1:
             String[] case1 = new String[]{"Palestrante nervoso e perdido","Participantes fizeram muito barulho e atrapalharam","Espaço muito pequeno e calor insuportável","Microfone falhando muito durante a palestra","Palestrante só falou o óbvio, quem não foi não perdeu nada"};
             comentario = case1[escolhaComent];
             break;

        case 2:
          String[] case2 = new String[]{"Local de difícil acesso e com o elevador quebrado","Palestrante enrolou muito, mas chegou onde queria","Pelo menos valeu todos os infortunios pra nos participantes tivemos pra chegar","Palestra atrasou um pouco e não os organizadores não nos davam uma estimativa de tempo","Até que foi legalzinha"};
          comentario = case2[escolhaComent];
          break;

        case 3:
          String[] case3 = new String[]{"Legal, dentro do que se espereva","Foi um pouco trabalhos achar o local, mas valeu a pena","Fila bem grande para entrar","Legal ,palestrante falou muitas coisas que levam a pessoa a refletir","Foi maneira, até que me diverti"};
          comentario = case3[escolhaComent];
          break;

        case 4:
          String[] case4 = new String[]{"Foi muito legal mesmo","Palestrante muito conciso e engraçado","Se a gente não tivesse esperado 2 horas na fila seria uma palestra PERFEITO","Pena que não tinha cadeira pra todo mundo","Foi tudo muito bom"};
          comentario = case4[escolhaComent];
          break;

        case 5:
          String[] case5 = new String[] {"Muito obrigado a todos envolvidos nesse evento maravilhoso","Agradeço a toda comissão organizadora por me dar a oportunidade de conhecer a pessoa que mais me inspira nesse planeta","Palestrante ótimo,boa oratória, humilde .Local escolhido foi adequado e suportou todo mundo com conforto","Penso de uma outra forma depois desse evento . Obrigado a equipe respónsavel por tal evento","Vou lembrar desse dia por muitos anos durante minha vida"};
          comentario = case5[escolhaComent];
          break;
      }
      int x = (int) (Math.random()*5);
      int y = (int) (Math.random()*5);

      Avaliacao temp = new Avaliacao(palestras[x],nota,comentario,participantes[y]);
      return temp;

    }
}
