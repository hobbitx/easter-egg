package com.senai.easteregg.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Instrucoes {

	public ArrayList<String> instrucoes = new ArrayList<String>(
			Arrays.asList(
					"Você deve procurar por dicas que estão espalhadas pelas dependências do SENAI que te levarão a encontrar o tesouro. ",
					"Essas dicas estão escondidas em QR Codes, os mesmos deverão ser capturados para que apareça a próxima dica. ",
					"Cada jogador poderá participar somente uma vez, e terá 1 hora para completar todo o percurso, das 20h as 21h na sexta-feira 11 de setembro.",
					"Serão 60 ganhadores sendo, 20 ganhadores a cada 20 minutos, os ganhadores serão premiados por ordem de chegada. ",
					"Para receber o prêmio, o jogador deverá passar por todos os checkpoints. "));

	public ArrayList<String> tituloInstrucoes = new ArrayList<String>(Arrays.asList(
			"As regras do jogo são simples",
			"A caçada",
			"Quando o jogo começa?",
			"O tesouro",
			"Fim da jornada"));

	public ArrayList<String> dicas = new ArrayList<String>(Arrays.asList(
			"A higiene pessoal é muito importante para se ter uma vida saudável. Que tal lavar as mãos antes de continuar?!",
			"Leitura é a chave para se ter um universo de ideias e uma tempestade de palavras - Pedro Bom Jesus",
			"Essa sala não é destinada à alunos, somente aos Mestres. Sabe onde fica?",
			"Comer, comer, comer, comer; É o melhor para poder crescer [...]",
			"A vida profissional começa com uma oportunidade para adquirir experiência. Mas como conseguir uma vaga?"
			));
	
	public ArrayList<String> controle = new ArrayList<String>(Arrays.asList(
			"banheiro",
			"biblioteca",
			"professores",
			"cantina",
			"estagios"
			));

	public ArrayList<String> propaganda = new ArrayList<String>(Arrays.asList(
			"Além dos cursos técnicos, o SENAI também oferece cursos de Aprendizagem Industrial e Qualificação Profissional.",
			"O curso de Mecatrônica forma profissionais para atuar em diversos segmentos do mercado, como na Indústria Automobilística e na fabricação de maquinários.",
			"O SENAI disponibiliza nove cursos na área de Aprendizagem Industrial para os mais diversos setores produtivos.",
			"O SENAI oferece sete cursos na área de Qualificação Profissional para quem busca preparo ou a atualização para o exercício de funções demandadas pelo mercado de trabalho.",
			"O curso Técnico de Automação Industrial prepara profissionais preferencialmente para a indústria de processos de fabricação contínuos, como petroquímicas, alimentos e de energia."
			));
}
