package com.senai.easteregg;

import java.util.ArrayList;
import java.util.Arrays;

public class Instrucoes {

	ArrayList<String> instrucoes = new ArrayList<String>(
			Arrays.asList(
					"Você deve procurar por dicas que estão espalhadas pelas dependências do SENAI que te levarão a encontrar o tesouro. ",
					"Essas dicas estão escondidas em QR Codes, os mesmos deverão ser capturados para que apareça a próxima dica. ",
					"Cada jogador poderá participar somente uma vez, e terá 1 hora para completar todo o percurso, das 20h as 21h na sexta-feira 11 de setembro.",
					"Serão 60 ganhadores sendo, 20 ganhadores a cada 20 minutos, os ganhadores serão premiados por ordem de chegada. ",
					"Para receber o prêmio, o jogador deverá passar por todos os checkpoints. "));

	ArrayList<String> tituloInstrucoes = new ArrayList<String>(Arrays.asList(
			"As regras do jogo são simples",
			"A caçada",
			"Quando o jogo começa?",
			"O tesouro",
			"Fim da jornada"));

	ArrayList<String> dicas = new ArrayList<String>(Arrays.asList(
			"Dica nº1 - Vá ao banheiro",
			"Dica nº2 - Vá a biblioteca",
			"Dica nº3 - Vá a sala dos professores",
			"Dica nº4 - Vá a cantina",
			"Dica nº5 - Vá ao Quadro de estagios",
			"Dica nº6 - Vote ao inicio"));
	
	ArrayList<String> controle = new ArrayList<String>(Arrays.asList(
			"banheiro",
			"biblioteca",
			"sala_dos_professores",
			"cantina",
			"Quadro_de_estagios",
			"inicio"));
}
