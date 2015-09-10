package com.senai.easteregg.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Instrucoes {

	public ArrayList<String> instrucoes = new ArrayList<String>(
			Arrays.asList(
					"Voc� deve procurar por dicas que est�o espalhadas pelas depend�ncias do SENAI que te levar�o a encontrar o tesouro. ",
					"Essas dicas est�o escondidas em QR Codes, os mesmos dever�o ser capturados para que apare�a a pr�xima dica. ",
					"Cada jogador poder� participar somente uma vez, e ter� 1 hora para completar todo o percurso, das 20h as 21h na sexta-feira 11 de setembro.",
					"Ser�o 60 ganhadores sendo, 20 ganhadores a cada 20 minutos, os ganhadores ser�o premiados por ordem de chegada. ",
					"Para receber o pr�mio, o jogador dever� passar por todos os checkpoints. "));

	public ArrayList<String> tituloInstrucoes = new ArrayList<String>(Arrays.asList(
			"As regras do jogo s�o simples",
			"A ca�ada",
			"Quando o jogo come�a?",
			"O tesouro",
			"Fim da jornada"));

	public ArrayList<String> dicas = new ArrayList<String>(Arrays.asList(
			"A higiene pessoal � muito importante para se ter uma vida saud�vel. Que tal lavar as m�os antes de continuar?!",
			"Leitura � a chave para se ter um universo de ideias e uma tempestade de palavras - Pedro Bom Jesus ...Fa�a silencio durante a sua visita",
			"Essa sala n�o � destinada � alunos, somente aos Mestres. Sabe onde fica?",
			"Comer, comer, comer, comer; � o melhor para poder crescer [...]",
			"A vida profissional come�a com uma oportunidade para adquirir experi�ncia. Mas como conseguir uma vaga?"
			));
	
	public ArrayList<String> controle = new ArrayList<String>(Arrays.asList(
			"banheiro",
			"biblioteca",
			"professores",
			"cantina",
			"estagios"
			));

	public ArrayList<String> propaganda = new ArrayList<String>(Arrays.asList(
			"Al�m dos cursos t�cnicos, o SENAI tamb�m oferece cursos de Aprendizagem Industrial e Qualifica��o Profissional.",
			"O curso de Mecatr�nica forma profissionais para atuar em diversos segmentos do mercado, como na Ind�stria Automobil�stica e na fabrica��o de maquin�rios.",
			"O SENAI disponibiliza nove cursos na �rea de Aprendizagem Industrial para os mais diversos setores produtivos.",
			"O SENAI oferece sete cursos na �rea de Qualifica��o Profissional para quem busca preparo ou a atualiza��o para o exerc�cio de fun��es demandadas pelo mercado de trabalho.",
			"O curso T�cnico de Automa��o Industrial prepara profissionais preferencialmente para a ind�stria de processos de fabrica��o cont�nuos, como petroqu�micas, alimentos e de energia."
			));
}
