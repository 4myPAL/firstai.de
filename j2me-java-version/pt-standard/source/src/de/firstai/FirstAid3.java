package de.firstai;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import de.enough.polish.ui.UiAccess;


public class FirstAid3 extends MIDlet implements CommandListener {

	boolean started = false;
	Form details;
	Display display;
	List menu;
	List telEmergency;

	// setup of the navigation buttons
	static final Command cmdBack = new Command("Voltar", Command.BACK, 2);
	static final Command cmdExit = new Command("Fechar", Command.EXIT, 2);

	StringItem aid_disclaimer, aid_general, aid_allergic, aid_asthma, aid_amputation, aid_apnoea, aid_checkbreathing, aid_eyeinjury, aid_chemicalburneyes, 
	aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_bleedinglight, aid_bleedingsevere, aid_diabeticcoma, aid_diarrhoea, aid_icerescue, aid_electricityaccident, aid_epilepsy, 
	aid_vomiting, aid_frostbitemild, aid_frostbitesevere, aid_suffocation, aid_drowning, aid_birth, aid_dangerzone, aid_brainconcussion, aid_resuscitation, aid_heartattack, aid_hyperthermia, 
	aid_insectstings, aid_fracture, aid_nosebleeding, aid_emergencycall, aid_backinjury, aid_skullfracture, aid_stroke, aid_snakebite, aid_shock, aid_sunburn, aid_sunstroke, 
	aid_sos, aid_recoveryposition, aid_animalbite, aid_safeguardaccident, aid_hypothermia, aid_hypoglycaemia, aid_chemicalburn, aid_burningslight, aid_burningsevere, aid_poisining, 
	aid_sprain, separator;

	StringItem[] stringItemArray;
	Image aid001, aid003, aid008, aid009, aid010, aid011, aid012, aid013, aid019, aid022;
	Image aid023, aid025, aid028, aid029, aid030, aid031, aid034, aid041, aid045, aid058;
	Image aid061, aid065, aid067, aid069, aid084, aid085, aid089, aid092, aid107;
	Image imageCC;

	StringItem stringAfrica;
	StringItem stringAsia;
	StringItem stringEurope;
	StringItem stringNorthamerica;
	StringItem stringOceania;
	StringItem stringSouthamerica;
	
	public FirstAid3() {

		this.menu = new List("Primeiros Socorros 3.0", Choice.IMPLICIT);
		this.menu.append("# Aviso Legal", null);
		this.menu.append("# Chamadas de emerg�ncia", null);
		this.menu.append("# Conduta Geral", null);
		this.menu.append("A compress�o do t�rax", null);
		this.menu.append("A hiperglicemia (a��car)", null);
		this.menu.append("A hipoglicemia (n�veis baixos de a��car)", null);
		this.menu.append("A hipotermia (corpo frio)", null);
		this.menu.append("Acidente com Electricidade", null);
		this.menu.append("Acidente de Tr�fego", null);
		this.menu.append("Acidente of�dico", null);
		this.menu.append("Afogamento", null);
		this.menu.append("Amputa��o", null);
		this.menu.append("Apn�ia", null);
		this.menu.append("Asfixia", null);
		this.menu.append("Asma", null);
		this.menu.append("Ataque do cora��o", null);
		this.menu.append("Ataque S�bito", null);
		this.menu.append("Checar Respira��o", null);
		this.menu.append("Choque", null);
		this.menu.append("Coma diab�tico", null);
		this.menu.append("Concuss�o no cer�bro", null);
		this.menu.append("Diarreia", null);
		this.menu.append("Dispn�ia", null);
		this.menu.append("Engasgado", null);
		this.menu.append("Envenenamento", null);
		this.menu.append("Epilepsia", null);
		this.menu.append("Esfor�os + disten��o", null);
		this.menu.append("Fratura", null);
		this.menu.append("Fratura Craniana", null);
		this.menu.append("Fratura Espinhal", null);
		this.menu.append("Hipertermia (calor corporal)", null);
		this.menu.append("Inconsci�ncia com respira��o", null);
		this.menu.append("Inconsci�ncia sem respirar", null);
		this.menu.append("Insola��o", null);
		this.menu.append("Les�es nas Costas", null);
		this.menu.append("Les�es oculares", null);
		this.menu.append("Ligar para emerg�ncia", null);
		this.menu.append("Mordida de Animal", null);
		this.menu.append("Nascimento", null);
		this.menu.append("Picadas de Insetos", null);
		this.menu.append("Posi��o de Recupera��o", null);
		this.menu.append("Queimadura por frio grave", null);
		this.menu.append("Queimadura por frio leve", null);
		this.menu.append("Queimadura Quimica", null);
		this.menu.append("Queimadura Quimica (Olhos)", null);
		this.menu.append("Queimadura solar", null);
		this.menu.append("Queimaduras Graves", null);
		this.menu.append("Queimaduras Ligeiras", null);
		this.menu.append("Rea��o al�rgica", null);
		this.menu.append("Reanima��o", null);
		this.menu.append("Resgate no gelo", null);
		this.menu.append("Respira��o", null);
		this.menu.append("Sangramento grave", null);
		this.menu.append("Sangramento leve", null);
		this.menu.append("Sangramento no Nariz", null);
		this.menu.append("Seguran�a em Acidente", null);
		this.menu.append("SOS", null);
		this.menu.append("V�mito", null);
		this.menu.append("Zona de Perigo (Resgate)", null);
		this.menu.append("-------------", null);
		this.menu.append("Ligue para emerg�ncia 192", null);
 
		// commands
		this.menu.addCommand(cmdExit);
		this.menu.setCommandListener(this);

		details = new Form ("Primeiros Socorros no seu celular");

		/**** Init the Images ****/
		try { aid001 = Image.createImage ("/aid001.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid003 = Image.createImage ("/aid003.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid008 = Image.createImage ("/aid008.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid009 = Image.createImage ("/aid009.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid010 = Image.createImage ("/aid010.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid011 = Image.createImage ("/aid011.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid012 = Image.createImage ("/aid012.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid013 = Image.createImage ("/aid013.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid019 = Image.createImage ("/aid019.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid022 = Image.createImage ("/aid022.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid023 = Image.createImage ("/aid023.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid025 = Image.createImage ("/aid025.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid028 = Image.createImage ("/aid028.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid029 = Image.createImage ("/aid029.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid030 = Image.createImage ("/aid030.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid031 = Image.createImage ("/aid031.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid034 = Image.createImage ("/aid034.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid041 = Image.createImage ("/aid041.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid045 = Image.createImage ("/aid045plug.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid058 = Image.createImage ("/aid058.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }

		try { aid061 = Image.createImage ("/aid061.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid065 = Image.createImage ("/aid065.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid067 = Image.createImage ("/aid067.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid069 = Image.createImage ("/aid069.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid084 = Image.createImage ("/aid084.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid085 = Image.createImage ("/aid085.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid089 = Image.createImage ("/aid089.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid092 = Image.createImage ("/aid092.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		try { aid107 = Image.createImage ("/aid107.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
		
		try { imageCC = Image.createImage ("/cc88x31.png"); } catch (IOException e1) { throw new RuntimeException ("Unable to load Image: "+e1); }
	}

	public void startApp() {
		if (!started) {
			// emergency numbers list
			telEmergency = new List ("Continent", Choice.IMPLICIT);
			telEmergency.append("�frica", null);
			telEmergency.append("Am�rica do Norte/Central", null);
			telEmergency.append("Am�rica do Sul", null);
			telEmergency.append("�sia", null);
			telEmergency.append("Europa", null);
			telEmergency.append("Oceania", null);
			telEmergency.addCommand(cmdBack);
			telEmergency.setCommandListener(this);
			stringAfrica = new StringItem("- �frica -", "\n# �frica do Sul\nPol:10111 | M�d:10177 | Bom:10111\n\n# Angola\nPol:110 | M�d:118 | Bom:118\n\n# Arg�lia\nPol:17 | M�d:17 | Bom:14\n\n# Benin\nPol:17 | M�d:301769 | Bom:18\n\n# Botsuana\nPol:999 | M�d:997 | Bom:998\n\n# Burkina Faso\nPol:17 | M�d:local n�meros | Bom:18\n\n# Burundi\nPol:n�o obrigat�rias | M�d:n�o obrigat�rias | Bom:n�o obrigat�rias\n\n# Cabo Verde\nPol:132 | M�d:130 | Bom:131\n\n# Camar�es\nPol:17 | M�d:local n�meros | Bom:18\n\n# Central Africano Rep�blica\nPol:611253 | M�d:610600 | Bom:118\n\n# Chade\nPol:17 | M�d:local n�meros | Bom:18\n\n# Comoros\nPol:apenas telefones de r�dio | M�d:apenas telefones de r�dio | Bom:apenas telefones de r�dio\n\n# Congo (Rep�blica Democr�tica)\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Congo (Rep�blica)\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Costa do Marfim\nPol:110 | M�d:110 | Bom:180\n\n# Djibuti\nPol:17 | M�d:351351 | Bom:18\n\n# Egito\nPol:122 | M�d:123 | Bom:180\n\n# Eritr�ia\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Eti�pia\nPol:91 | M�d:92 | Bom:93\n\n# Gab�o\nPol:1730 | M�d:1300 | Bom:18\n\n# G�mbia\nPol:117 | M�d:116 | Bom:118\n\n# Gana\nPol:191 | M�d:193 | Bom:192\n\n# Guin�\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Guin� Equatorial\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Guin�-Bissau\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Lesoto\nPol:123 | M�d:121 | Bom:122\n\n# Lib�ria\nPol:911 | M�d:911 | Bom:911\n\n# L�bia\nPol:193 | M�d:193 | Bom:193\n\n# Madagascar\nPol:117 | M�d:2262566 | Bom:18\n\n# Malau�\nPol:199 | M�d:199 | Bom:199\n\n# Mali\nPol:17 | M�d:15 | Bom:18\n\n# Marrocos\nPol:19 | M�d:15 | Bom:15\n\n# Maur�cio\nPol:999 | M�d:999 | Bom:999\n\n# Maurit�nia\nPol:117 | M�d:local n�meros | Bom:118\n\n# Mayotte\nPol:112 | M�d:15 | Bom:603054\n\n# Mo�ambique\nPol:119 | M�d:117 | Bom:198\n\n# Nam�bia\nPol:1011 | M�d:2032276 | Bom:2032270\n\n# N�ger\nPol:17 | M�d:723141 | Bom:18\n\n# Nig�ria\nPol:119 | M�d:199 | Bom:190\n\n# Qu�nia\nPol:999 | M�d:999 | Bom:999\n\n# Rep�blica �rabe Saaraui Democr�tica\nPol:-- | M�d:-- | Bom:--\n\n# Reuni�o\nPol:17 or 112  | M�d:15 or 112  | Bom:18 or 112 \n\n# Ruanda\nPol:112 | M�d:local n�meros | Bom:local n�meros\n\n# S�o Tom� e Pr�ncipe\nPol:-- | M�d:-- | Bom:--\n\n# Senegal\nPol:local n�meros | M�d:8891515 | Bom:local n�meros\n\n# Serra Leoa\nPol:999 | M�d:999 | Bom:999\n\n# Seychelles\nPol:999 | M�d:999 | Bom:999\n\n# Som�lia\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Suazil�ndia\nPol:999 | M�d:6060911 | Bom:local n�meros\n\n# Sud�o\nPol:999 | M�d:local n�meros | Bom:999\n\n# Tanz�nia\nPol:112 | M�d:112 | Bom:112\n\n# Togo\nPol:101 | M�d:191 | Bom:118\n\n# Tun�sia\nPol:197 | M�d:190 | Bom:198\n\n# Uganda\nPol:999 or 111 m�vel | M�d:999 or 111 m�vel | Bom:999 or 111 m�vel\n\n# Z�mbia\nPol:999 or 112 m�vel | M�d:991 or 112 m�vel | Bom:993 or 112 m�vel\n\n# Zimbabu�\nPol:995 | M�d:994 | Bom:993");
			stringAsia = new StringItem("- Asia -", "\n# Afeganist�o\nPol:-- | M�d:112 | Bom:--\n\n# Ar�bia Saudita\nPol:999 | M�d:997 | Bom:998\n\n# Arm�nia\nPol:102 | M�d:103 | Bom:101\n\n# Azerbaij�o\nPol:102 | M�d:103 | Bom:101\n\n# Bangladesh\nPol:8665513 | M�d:199 | Bom:9555555\n\n# Bar�m\nPol:999 | M�d:999 | Bom:999\n\n# Brunei\nPol:993 | M�d:991 | Bom:995\n\n# But�o\nPol:110 | M�d:112 | Bom:113\n\n# Camboja\nPol:117 | M�d:199 | Bom:118\n\n# Catar\nPol:999 | M�d:999 | Bom:999\n\n# Cazaquist�o\nPol:03 | M�d:03 | Bom:03\n\n# China\nPol:110 | M�d:120 | Bom:119\n\n# Cingapura\nPol:999 | M�d:995 | Bom:995\n\n# Cor�ia do Norte\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Cor�ia do Sul (Rep�blica da Coreia)\nPol:112 | M�d:119 | Bom:119\n\n# Curdist�o\nPol:129 | M�d:115 | Bom:125\n\n# Emirados �rabes Unidos\nPol:999 | M�d:998 | Bom:997\n\n# Filipinas\nPol:117 | M�d:117 | Bom:117\n\n# Ge�rgia\nPol:022 | M�d:022 | Bom:022\n\n# Hong Kong\nPol:999 | M�d:999 | Bom:999\n\n# I�men\nPol:199 | M�d:199 | Bom:199\n\n# �ndia\nPol:100 | M�d:102 | Bom:101\n\n# Indon�sia\nPol:110 | M�d:118 | Bom:113\n\n# Ir�o\nPol:110 or 112  | M�d:115 or 112  | Bom:125 or 112 \n\n# Iraque\nPol:n�o obrigat�rias | M�d:n�o obrigat�rias | Bom:n�o obrigat�rias\n\n# Israel\nPol:100 | M�d:101 | Bom:102\n\n# Jap�o\nPol:110 | M�d:119 | Bom:119\n\n# Jord�nia\nPol:192 | M�d:193 | Bom:193\n\n# Kuwait\nPol:777 | M�d:777 | Bom:777\n\n# Laos\nPol:local n�meros | M�d:03 | Bom:local n�meros\n\n# L�bano\nPol:112 | M�d:140 | Bom:175\n\n# Macau\nPol:999 | M�d:999 | Bom:999\n\n# Mal�sia\nPol:999 or 112  | M�d:999 or 112  | Bom:999 or 112 \n\n# Maldivas\nPol:119 | M�d:102 | Bom:118\n\n# Mong�lia\nPol:102 | M�d:103 | Bom:101\n\n# Myanmar\nPol:199 | M�d:199 | Bom:199\n\n# Nepal\nPol:100 | M�d:228094 | Bom:101\n\n# O Sri Lanka\nPol:119 or 112 n�o obrigat�rias | M�d:110 | Bom:111\n\n# Om�\nPol:999 | M�d:999 | Bom:999\n\n# Paquist�o\nPol:15 | M�d:115 | Bom:16\n\n# Quirguist�o\nPol:133 | M�d:03 | Bom:03\n\n# S�ria\nPol:112 | M�d:110 | Bom:113\n\n# Tail�ndia\nPol:191 m�vel | M�d:191 | Bom:199\n\n# Taiwan\nPol:110 | M�d:119 | Bom:119\n\n# Tajiquist�o\nPol:02 | M�d:03 | Bom:local n�meros\n\n# Timor Leste\nPol:112 | M�d:7233212 | Bom:--\n\n# Turquemenist�o\nPol:03 | M�d:03 | Bom:03\n\n# Uzbequist�o\nPol:03 | M�d:03 | Bom:03\n\n# Vietn�\nPol:113 | M�d:115 | Bom:114");
			stringEurope = new StringItem("- Europa -", "\n# A B�snia e Herzegovina\nPol:122 | M�d:124 | Bom:123\n\n# A Cro�cia\nPol:92 | M�d:94 | Bom:93\n\n# Alb�nia\nPol:19 | M�d:17 | Bom:18\n\n# Alemanha\nPol:110 | M�d:112 | Bom:112\n\n# Andorra\nPol:110 | M�d:118 | Bom:118\n\n# �ustria\nPol:112 | M�d:112 | Bom:112\n\n# B�lgica\nPol:112 | M�d:112 | Bom:112\n\n# Bielorr�ssia\nPol:02 | M�d:03 | Bom:01\n\n# Bulg�ria\nPol:112 | M�d:112 | Bom:112\n\n# Chipre\nPol:112 | M�d:112 | Bom:112\n\n# Cidade do Vaticano\nPol:112 | M�d:113 | Bom:115\n\n# Dinamarca\nPol:112 | M�d:112 | Bom:112\n\n# Eslov�quia\nPol:112 | M�d:112 | Bom:112\n\n# Eslov�nia\nPol:113 | M�d:112 | Bom:112\n\n# Espanha\nPol:112 | M�d:112 | Bom:112\n\n# Est�nia\nPol:112 | M�d:112 | Bom:112\n\n# Finl�ndia\nPol:112 | M�d:112 | Bom:112\n\n# Fran�a\nPol:17 or 112 | M�d:15 or 112 | Bom:18 or 112\n\n# Gr�cia\nPol:112 | M�d:112 | Bom:112\n\n# Holanda\nPol:112 | M�d:112 | Bom:112\n\n# Hungria\nPol:112 | M�d:112 | Bom:112\n\n# Irlanda\nPol:112 | M�d:112 | Bom:112\n\n# Isl�ndia\nPol:112 | M�d:112 | Bom:112\n\n# It�lia\nPol:112 | M�d:112 | Bom:112\n\n# Kosovo\nPol:911 | M�d:911 | Bom:911\n\n# Let�nia\nPol:112 | M�d:112 | Bom:112\n\n# Liechtenstein\nPol:112 | M�d:112 | Bom:112\n\n# Litu�nia\nPol:112 | M�d:112 | Bom:112\n\n# Luxemburgo\nPol:112 | M�d:112 | Bom:112\n\n# Maced�nia\nPol:112 | M�d:112 | Bom:112\n\n# Malta\nPol:112 | M�d:112 | Bom:112\n\n# Mold�via\nPol:902 | M�d:903 | Bom:901\n\n# M�naco\nPol:112 | M�d:112 | Bom:112\n\n# Montenegro\nPol:112 | M�d:112 | Bom:112\n\n# Noruega\nPol:112 | M�d:113 | Bom:110\n\n# Pol�nia\nPol:112 | M�d:112 | Bom:112\n\n# Portugal\nPol:112 | M�d:112 | Bom:112\n\n# Reino Unido\nPol:112 | M�d:112 | Bom:112\n\n# Rep�blica Checa\nPol:112 | M�d:112 | Bom:112\n\n# Rom�nia\nPol:112 | M�d:112 | Bom:112\n\n# R�ssia\nPol:02 | M�d:03 | Bom:01\n\n# San Marino\nPol:112 | M�d:113 | Bom:116\n\n# S�rvia\nPol:112 | M�d:112 | Bom:112\n\n# Su�cia\nPol:112 | M�d:112 | Bom:112\n\n# Su��a\nPol:117 or 112 | M�d: 144 or 112 | Bom:118 or 112\n\n# Turquia\nPol:155 | M�d:112 | Bom:110\n\n# Ucr�nia\nPol:112 | M�d:112 | Bom:112");
			stringNorthamerica = new StringItem("- Am�rica do Norte/Central -", "\n# Ant�gua e Barbuda\nPol:911 | M�d:911 | Bom:911\n\n# Bahamas\nPol:911 | M�d:911 | Bom:911\n\n# Barbados\nPol:112 | M�d:115 | Bom:113\n\n# Belize\nPol:911 | M�d:911 | Bom:911\n\n# Canad�\nPol:911 | M�d:911 | Bom:911\n\n# Costa Rica\nPol:911 | M�d:911 | Bom:911\n\n# Cuba\nPol:26811 | M�d:26811 | Bom:26811\n\n# Dominica\nPol:999 | M�d:999 | Bom:999\n\n# El Salvador\nPol:911 | M�d:911 | Bom:911\n\n# Estados Unidos da Am�rica \nPol:911 | M�d:911 | Bom:911\n\n# Granada\nPol:112 | M�d:911 | Bom:911\n\n# Gronel�ndia\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Guatemala\nPol:110 | M�d:123 | Bom:122\n\n# Haiti\nPol:114 | M�d:118 | Bom:local n�meros\n\n# Honduras\nPol:119 | M�d:378654 | Bom:198\n\n# Ilhas Cayman\nPol:911 | M�d:911 | Bom:911\n\n# Jamaica\nPol:119 | M�d:110 | Bom:110\n\n# M�xico\nPol:080 | M�d:060 | Bom:060\n\n# Nicar�gua\nPol:118 | M�d:2651761 | Bom:2650162\n\n# Panam�\nPol:104 | M�d:2699778 | Bom:103\n\n# Rep�blica Dominicana\nPol:911 | M�d:911 | Bom:911\n\n# Saint Pierre e Miquelon\nPol:999 | M�d:911 | Bom:911\n\n# Santa L�cia\nPol:911 | M�d:911 | Bom:911\n\n# S�o Crist�v�o e Nevis\nPol:17 | M�d:15 | Bom:18\n\n# S�o Vicente e Granadinas\nPol:911 | M�d:911 | Bom:911\n\n# Trinidad e Tobago\nPol:999 | M�d:990 | Bom:990");
			stringOceania = new StringItem("- Oceania -", "\n# Austr�lia\nPol:000 or 112 m�vel | M�d:000 or 112 m�vel | Bom:000 or 112 m�vel\n\n# Fiji\nPol:911 | M�d:911 | Bom:9170\n\n# Ilhas Marshall\nPol:6258666 | M�d:6254111  | Bom:local n�meros\n\n# Ilhas Salom�o\nPol:911 | M�d:911 | Bom:911\n\n# Kiribati\nPol:local n�meros | M�d:994 | Bom:local n�meros\n\n# Micron�sia\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Nauru\nPol:local n�meros | M�d:local n�meros | Bom:local n�meros\n\n# Nova Zel�ndia\nPol:111 | M�d:111 | Bom:111\n\n# Palau\nPol:911 | M�d:911 | Bom:911\n\n# Papua Nova Guin�\nPol:000 | M�d:local n�meros | Bom:110\n\n# Samoa\nPol:995 | M�d:996 | Bom:994\n\n# Tonga\nPol:922 | M�d:933 | Bom:999\n\n# Tuvalu\nPol:911 | M�d:911 | Bom:911\n\n# Vanuatu\nPol:112 | M�d:112 | Bom:112");
			stringSouthamerica = new StringItem("- Am�rica do Sul -", "\n# Argentina\nPol:101 | M�d:107 | Bom:100\n\n# Bol�via\nPol:911 | M�d:911 | Bom:911\n\n# Brasil\nPol:190 | M�d:192 | Bom:193\n\n# Chile\nPol:133 | M�d:131 | Bom:132\n\n# Col�mbia\nPol:119 | M�d:119 | Bom:119\n\n# Equador\nPol:101 | M�d:131 | Bom:102\n\n# Guiana\nPol:911 | M�d:913 | Bom:912\n\n# Paraguai\nPol:911 | M�d:911 | Bom:911\n\n# Peru\nPol:105 | M�d:116 | Bom:116\n\n# Suriname\nPol:115 | M�d:115 | Bom:115\n\n# Uruguai\nPol:911 | M�d:911 | Bom:911\n\n# Venezuela \nPol:171 | M�d:171 | Bom:171");

			// First-Aid-Text
			aid_disclaimer = new StringItem ("Aviso Legal", "1. Software \nPrimeiros Socorros no seu celular\nVers�o: j3.0\nRelease: 2009-08-18\n\nCopyright: Kai Kajus Noack\nTradutor: Lucas Daniel Souza de Medeiros\nLicen�a: Creative Commons BY NC ND\n\nFiguras � Med4Teens\n\nEste programa tem o prop�sito de dar informa��es sobre primeiros socorros. No entanto, elas n�o substituem nenhum curso. � algo que serve para atualizar o conhecimento j� adquirido.\n\n2. Disclaimer \nPor favor note que eu n�o me responsabilizo pelas consequ�ncias resultantes da utiliza��o do software.\nQualquer responsabilidade � exclu�da!\nUtiliza��o por sua conta e risco!\n\nEm todas as situa��es de emerg�ncia, por favor procurar ajuda profissional imediatamente.\n\n3. Projeto de Desenvolvimento \nO programa pretende tornar-se multilingue. Tradutores Volunt�rios s�o bem vindos!\n\nMais informa��es est�o dispon�veis na Internet www.firstai.de ou escreva um e-mail para: info@firstai.de\n\nSalvar uma vida, � ter salvado o mundo.");aid_general = new StringItem ("Conduta Geral", "1. Realizar sempre os primeiros socorros. Voc� n�o pode cometer erros.\n2. Prestar sempre aten��o � sua pr�pria seguran�a.\n3. Analisar a situa��o e garantir seguran�a no lugar do acidente.\n4. Chamada de emerg�ncia + Primeiros Socorros!\n5. Se existirem v�rias v�timas, o tratamento dos mais prejudicados tem prioridade.\n6. Tente acalmar a v�tima. Fique calmo voc� tamb�m!\n7. Se poss�vel deit�-lo(a) confortavelmente. Nunca d� �lcool, nicotina ou drogas para uma pessoa.");aid_allergic = new StringItem ("Rea��o al�rgica", "1. Telefone para uma ambul�ncia imediatamente.\n2. Tente acalmar a v�tima e deix�-lo sentar-se confortavelmente.\n3. Remover a causa da alergia (por exemplo um f�rr�o de abelha) cuidadosamente.\n4. Esfrie a pele afetada (compressa �mida, gelo).\n5. Se tiver um ant�doto, ele deve us�-lo (ajude-o).\n6. Monitore a condi��o da v�tima at� a ambul�ncia chegar.\n7. Se o acidentado perder a consci�ncia ou a respira��o parar, siga instru��es apropriadas!");aid_amputation = new StringItem ("Amputa��o", "A parte do corpo amputada pode ser recolocada. Objetivo: Manter a parte amputada arrefecida at� chegar ao hospital.\n1. Acalmar a pessoa, deit�-lo(a) para baixo, e cobrir com cobertor.\n2. Parar o sangramento, consulte 'Hemorragia (grave)' e 'Choque'.\n3. Embrulhe a parte amputada em um pano limpo e seco, e coloc�-la em um saco pl�stico imperme�vel.\n4. Fechar este saco pl�stico e coloc�-lo em outro saco pl�stico, que contenha �gua fria/gelo.\n5. N�o d� �lcool, cigarros ou alimentos � v�tima (no caso de uma cirurgia com anestesia no hospital).\n6. N�o congele a parte amputada, (apenas mantenha fria).\n7. Ligue para emerg�ncia ou por ultimo leve-a ao hospital sozinho.");aid_animalbite = new StringItem ("Mordida de Animal", "Aten��o: alto risco de infec��o. Resultado poderia dar infec��o, t�tano, ou raiva.\n1. Lavar ferida com �gua quente sab�o.\n2. Depois desinfecte a ferida.\n3. Se houver hemorragia grave, elevar a parte superior do corpo da pessoa.\n4. Aplicar um curativo ass�ptico.\n5. V� a um hospital ou ligue para emerg�ncia.");aid_apnoea = new StringItem ("Apn�ia", "Sem sons ou movimentos respirat�rios, percept�vel descolora��o da pele.\n1. Chamada de emerg�ncia.\n2. Deite o acidentado de costas.\n3. Estique a cabe�a pra tr�s. Remover objetos da boca e da garganta.\n4. Puxe o nariz e verifique se est� fechado.\n5. Respire fundo e encaixe a boca na boca do acidentado, de forma que n�o possa vazar ar.\n6. Respire fora devagar e completamente.\n7. Sen�o tiver sucesso: Fa�a respira��o at� a ambul�ncia chegar.");aid_asthma = new StringItem ("Asma", "Grande dificuldade em respirar. Chiado ru�do respirat�rio. Ansiedades.\n1. Acalme � pessoa. Fique calmo voc� tamb�m!\n2. Afrouxar roupas.\n3. Deixe o acidentado sentar inclinado para frente, mande-o respirar devagar e profundamente.\n4. Se ocasionalmente tiver um inalador, ele deve us�-lo (ajude-o). 5-10 min ap�s a utiliza��o dever� fazer efeito.\n5. Caso n�o haja melhora: Use o inalador a cada 5 min at� ambul�ncia chegar.\n6. Chamada de emerg�ncia.\n7. Se houver apn�ia, comece com a respira��o.");aid_backinjury = new StringItem ("Les�es nas Costas", "Dor nas costas, bra�os e pernas dormentes.\n1. N�o mova o acidentado!!\n2. Segure a cabe�a do jeito que estiver, mantendo a pessoa est�vel (manter a sua cabe�a parado)\n3. Estabilizar o acidentado com travesseiros na lateral.\n4. Acalme � vitima.\n5. Ligue para emerg�ncia, lembre-se de salientar o tipo de les�o.");aid_birth = new StringItem ("Nascimento", "Sa�da de l�quido amni�tico. Contra��o, ocorrer� dores. Nascimento inesperado.\n1. Preste aten��o � privacidade e mantenha a calma! - Ligue para a emerg�ncia.\n2. Deixar a mulher gr�vida nua apenas parte inferior do seu corpo, e sente-se em local est�ril sobre um cal�o com as pernas dobradas.\n3. Dobre os joelhos. Suba as pernas. Posi��o da bacia ligeiramente ascendente. - O parto � um processo natural e ocorrer� sem complica��es.\n4. Mantenha a mulher calma, deixe-a concentrar-se na propria respira��o: inspire atrav�s do nariz, e expire da boca para fora (em velocidade normal).\n5. Ritmo de pressionamento: Respire fundo, mantenha respira��o, e pressione. Logo que a cabe�a do beb� aparecer, apoie-o, segurando-o com ambas as m�os.\n6. Ap�s o parto: Segure o beb� cuidadosamente com cabe�a para baixo para liberar as vias a�reas e saida de l�quido amni�tico. (Talvez voc� tenha que sugar para fora o fluido a partir da boca do beb� pelo nariz.) O beb� deve respirar e chorar!\n7. Amarrar o cord�o umbilical 30 cent�metros de dist�ncia da crian�a (tamb�m pode ser feito no hospital). Mantenha a vagina da m�e est�ril.\n8. Seque o beb� e o mantenha aquecido. Anote a hora e leve-a para o hospital.");aid_bleedinglight = new StringItem ("Sangramento leve", "Objetivo: Parar o sangramento.\n1. N�o toque na ferida (risco de infec��o).\n2. N�o se trata ferida com p� ou sprays.\n3. Rratamento da ferida: utilize material est�ril e uma bandagem.\n4. Para pequenas hemorragias � freq�entemente suficiente um tamponamento.\n5. Se for uma grande hemorragia usar uma atadura e cobrir com uma bandagem. N�o se aplica � bandagem apertado como uma imobiliza��o, pode levar ao aumento das hemorragias.\n6. Nota: Ferimentos de raiva t�m que ser lavadas com solu��o de sab�o.");aid_bleedingsevere = new StringItem ("Sangramento grave", "Salpicos, sangue pulsante. Perigo: Pode engasgar por causa da perda de sangue, infec��es, a morte. Objetivo: Parar o sangramento.\n1. Remover roupas (cortar se necess�rio) e amostrar ferida.\n2. Enrole uma gaze ou se necess�rio, uma pe�a com a press�o em torno da ferida.\n3. Exercer press�o por pelo menos 10 min.\n4. Se for as bandagens ficarem encharcadas com sangue, n�o remova-as. Em vez disso, enrole outra bandagem / vestu�rio em torno do ferimento.\n5. Conservar o membro afetado (caso n�o esteja quebrado) mais elevado do que o cora��o para reduzir a quantidade de press�o arterial. Se poss�vel deitar � viima.\n6. Se n�o parar de sangrar, manter a press�o sobre a ferida, e defina mais um ponto de press�o na ferida: Para uma hemorragia do antebra�o comprima o bra�o (Pressione na face interna da veia do bra�o, no meio do cotovelo e na dobra do bra�o, utilizando seus dedos). Sangramento na perna deve-se fazer press�o de ponto no inguinal (pressione na veia da virilha trafulha, art�ria onde leva mais de osso il�aco, utilizando a sua palma da m�o).\n7. Ligue para emerg�ncia m�dico imediatamente.\n8. Assim que o sangramento estiver sob controle: Iniciar medidas anti-asfixiante.");aid_brainconcussion = new StringItem ("Concuss�o no cer�bro", "Dores de cabe�a, n�useas, v�mitos. Vis�o deficiente. Inconsci�ncia pode ocorrer.\n1. Olhar desinteressado ou vago (ao infinito).\n2. Chame a emerg�ncia.\n\nSe sangrar a cabe�a:\n1. Posicione a v�tima, em uma posi��o de cabe�a elevada (no travesseiro).\n2. Fa�a tratamento de ferida (utilize bandagem est�ril).\n3. Ligue para emerg�ncia.");aid_burningslight = new StringItem ("Queimaduras Ligeiras", "Vermelhid�o da pele. Leve incha�o. Dor.\n1. Mantenha a �rea queimada sob �gua fria.\n2. Aplicar curativo molhado folgadamente.");aid_burningsevere = new StringItem ("Queimaduras Graves", "Manchas de vermelho-branco e areas com forma��o de bolhas. A pele perde fluido. Danos profundos de tecido. Forte dor ou sem dor (por causa dos nervos queimados).\n1. Remover as roupas tanto quanto poss�vel.\n2. Refrigere as partes do corpo queimado com �gua (cerca de 15 � C, 59 � F) por at� 10 minutos, at� a dor diminuir.\n3. Em casos em que a queimadura for extensa, utilize toalhas molhadas para esfriar.\n4. Ligue para emerg�ncia.\n5. Ap�s o resfriamento da ferida: Use um curativo est�ril. N�o aplique qualquer fluido (sem cremes, �leos, pomadas, etc.) N�o furar as bolhas.\n6. Controle a respira��o e consci�ncia da pessoa at� a chegada da emerg�ncia.");aid_checkbreathing = new StringItem ("Checar Respira��o", "1. Verifique sons respirat�rios.\n2. Diagnosticar a respira��o na parte superior do abd�men (leigos a sua m�o sobre ela).\n3. No sentido respira��o boca e nariz.");aid_chemicalburneyes = new StringItem ("Queimadura Quimica (Olhos)", "1. Ligue para emerg�ncia, leve a embalagem do produto qu�mico, 'pois o mesmo tem telefone especifico para casos de acidentes.'\n2. Lave os olhos com muita �gua. Cubra algum olho saud�vel durante a lavagem.\n3. Conduzir o jato de �gua do �ngulo interior do olho ao �ngulo exterior do olho. Limpe durante pelo menos 20 minutos sob �gua.\n4. Fechar os dois olhos da vitima e cobri-lo com pano �mido.\n5. Monitore as condi��es at� a ambul�ncia chegar.");aid_chemicalburn = new StringItem ("Queimadura Quimica", "Les�es de tecido.\n1. Mente auto-defesa!\n2. Agir rapidamente e lavar os locais queimados.\n3. Ligar para emerg�ncia.\n4. Se h� uma queimadura qu�mica no sistema digestivo uma das maneiras � beber muita �gua.\n5. N�o provocar v�mitos!");aid_dangerzone = new StringItem ("Zona de Perigo (Resgate)", "1. Realiza��o: Posicione os bra�os da vitima na frente de seu peito, e ficar por tr�s dele / dela.\n2. Coloque as m�os sob os ombros dos feridos, agarrando o bra�o de forma angular.\n3. Puxar para tr�s e levar a pessoa em seguran�a.");aid_diabeticcoma = new StringItem ("Coma diab�tico", "N�vel de a��car no sangue for demasiado elevado (falta de insulina).\nSintomas: Sede, freq��ncia urin�ria, n�useas, v�mitos. Respira��o com cheiro de frutas / vinho.\n1. Ligue para emerg�ncia.\n2. Ajude a vitima (se for assegurada diab�ticos) a tomar insulina.\n3. Posi��o de recupera��o. (N�o existem posi��es para os primeiros socorros.)\n4. Monitorar a condi��o da vitima at� que chegue m�dico de emerg�ncia.");aid_diarrhoea = new StringItem ("Diarreia", "Rea��o para alimentos contaminados, a infec��o do intestino ou dist�rbio. Fezes � dilu�do, viscosas ou sanguinolenta.\n1. Perigo para a circula��o devido � desidrata��o e perda de sal!\n2. D� l�quidos (ch�, �gua).\n3. Se houver fortes perturba��es levar ao m�dico de emerg�ncia.");aid_drowning = new StringItem ("Afogamento", "1. Chamada de emerg�ncia. Pergunte as pessoas pr�ximas a voc� para ajudar.\n2. Resgate a pessoa para fora da �gua!\n3. Se a vitima estiver respirando: Posi��o de recupera��o. Mantenha-o quente (cubra-o). Monitore seu estado at� a chegada da ambulancia.\n4. Se a vitima n�o estiver respirando: Comece imediatamente com a reanima��o! (Remover a �gua dos pulm�es � in�til.)");aid_electricityaccident = new StringItem ("Acidente com Electricidade", "1. Em primeiro lugar interromper o fornecimento de electricidade!\nPerigo: inconsci�ncia, apneia.\n2. A - inconsci�ncia com a respira��o\n3. B - inconsci�ncia sem respirar");aid_emergencycall = new StringItem ("Ligar para emerg�ncia", "1. Disque 193 (bombeiros) 192 (SAMU). Sempre que poss�vel, � de gra�a! N�o hesite em ligar para uma ambul�ncia! Ao telefonar voc� deve fornecer as seguintes informa��es:\n\n- O que tem acontecido\n- Onde (lugar do acidente)\n- Quantas vitimas\n- Que tipo de les�es.\n\nPosteriormente espere para novas investiga��es.");aid_epilepsy = new StringItem ("Epilepsia", "Corpo r�gido, punhos fechados , mand�bula pressionada, contra��o muscular nos membros ou face. Olhos revirando. Saliva��o. poss�vel inconsci�ncia .\n1. N�o segure a vitima ou o seu movimento.\n2. Coloque a vitima em uma base suave (almofadas), remover objetos proximos para evitar auto-les�o.\n3. Acalme a vitima. Afrouxar roupas, dar liberdade de respira��o.\n4. Se a vitima v�mitar, vire a cabe�a para o lado que o v�mito possa escorrer.\n5. Manter vias a�reas claro. Risco de engolir a l�ngua.\n6. Posi��o recupera��o: chame a emerg�ncia. Continuar a monitorar o estado da v�tima.\n7. Mantenha os curiosos � dist�ncia.");aid_eyeinjury = new StringItem ("Les�es oculares", "1. Deixe objeto no olho da vitima, n�o remova-o!\n2. Mantenha os olhos sem se mexer para evitar novas les�es. N�o toque no olho.\n3. Se olho est� sangrando, cubra-o com uma compressa ou uma gaze est�ril.\n4. Mantenha o olho com uma almofada fria (reduz edema, estanca a hemorragia mais r�pido).\n5. Ligue para emerg�ncia ou leve-o por si mesmo.");aid_fracture = new StringItem ("Fratura", "Sintomas: Posi��o deslocada e mobilidade do osso. Deforma��o. Movimento doloroso, sens�vel ao toque.\n1. Evite movimentos!\n2. Ligar para emergencia.\n3. Imobilizar o osso fraturado, ou seja, imobilizar o local apoiado-o firmemente. Manter a posi��o do osso.\n4. Se for fratura aberta, cobrir a ferida com material est�ril.");aid_frostbitemild = new StringItem ("Queimadura por frio leve", "Palidez, incha�os. Perigo para a irriga��o sangu�nea.\n1. Leve � vitima para uma zona quente.\n2. Afaste-se de frio, retire roupas frio, seque a pessoa.\n3. Aquecer com �gua morna e com o calor do corpo do ajudante.\n4. Dar bebida quente (ch�). Nenhum �lcool!");aid_frostbitesevere = new StringItem ("Queimadura por frio grave", "Pele extremamente fria, cinza-branca, bolhas, tecido morto. Perigo para o fornecimento de sangue!\n1. Ir para a �rea quente.\n2. Tratamento ferida / cobertura.\n3. D� uma bebida a�ucarada.\n4. N�o esfregue a vitima com material quente!\n5. Chame a emerg�ncia.");aid_heartattack = new StringItem ("Ataque do cora��o", "Pesados, com dura��o superior a 5 min de press�o e dor no peito, especialmente irradiando nos bra�os/ombros. Ansiedade, palidez, sudorese fria. Eventualmente, n�useas, falta de ar.\n1. Chame a emerg�ncia e pe�a o 'DEA'(desfribilador externo automatico)! Avise sobre o suposto ataque card�aco.\n2. Posicione a parte superior do corpo elevada. Afrouxar roupas apertadas. N�o d� drogas ou bebidas.\n3. Calmamente conversar com a pessoa em causa.\n4. Controle a consci�ncia e respira��o.\n5. D� a aspirina se dispon�vel.\n6. Se pessoa estiver inconsciente iniciar a reanima��o.");aid_hypoglycaemia = new StringItem ("A hipoglicemia (n�veis baixos de a��car)", "N�vel de a��car no sangue est� abaixo valor m�nimo (porcausa de overdose de insulina suficiente ou n�o ingest�o de alimentos).\nSintomas: Palidez, nervosismo, a fome, arrepios, suores.\n1. Certifique-se de que a pessoa � diab�tica (procure por um crach� de diab�tico).\n2. Chame a emerg�ncia.\n3. D� uma bebida a�ucarada e dextrose/glicose (se n�o houver problemas de degluti��o).\n4. Se pessoa est� consciente e respira: Posi��o de recupera��o. Monitore a respira��o da pessoa. Se houver apneia, d� in�cio com a respira��o.\n5. Se n�o houver respira��o, voc� pode colocar um pouco de a��car na bochecha, empurre a partir de fora contra ele.");aid_hyperthermia = new StringItem ("Hipertermia (calor corporal)", "Sede, fraqueza, desorienta��o, n�useas, confus�o, forte sudorese, pele quente.\n1. Chame a emerg�ncia.\n2. Encontre um lugar fresco (sala com ar condicionado prefer�vel).\n3. Fixar pessoa, elevar as pernas. Afrouxar roupas.\n4. Arrefecer a pele com muita �gua ou passar toalha umida.\n5. D� muita �gua ou sucos para beber.");aid_hypothermia = new StringItem ("A hipotermia (corpo frio)", "Arrepio frio, sonol�ncia, cansa�o, at� inconsci�ncia. Cor de pele p�lida. Pulso lento, batimento card�aco fraco.\n1. V� a uma �rea quente/sala.\n2. Chamar a emerg�ncia.\n3. Pare de impacto do frio. Aumente da temperatura corporal (cubra e fa�a contato corpo-a-corpo).\n4. Remover roupas molhadas e colocar roupas quentes. Cobrir a cabe�a.\n5. D� ch� quente, sopa quente ou �gua para beber. Nenhum �lcool! Manter a pessoa acordada.\n6. Monitore a condi��o da vitima at� que a emergencia chegue. Se pessoa ficar inconsciente, inicie a reanima��o:\n7. A - inconsci�ncia com a respira��o\n8. B - inconsci�ncia sem respirar");aid_icerescue = new StringItem ("Resgate no gelo", "Preste aten��o � sua pr�pria seguran�a. Perigo: Afogamento, hipotermia.\n1. Resgate via escada de bordo ou corda. O peso deve ser distribu�do amplamente.\n2. Chame outras pessoas para ajudar. Deixe uma pessoa responsavel por chamar a ambul�ncia.\n3. Rastejar cuidadosamente sobre sua barriga (se poss�vel at� um ponto est�vel) com a ferramenta para a viola��o.\n4. Manuseie sobre a vitima a dist�ncia da ferramenta, (n�o � a sua m�o!) E puxe-a para fora.\n5. Rastejar para tr�s de volta para a beira.\n6. Primeiros socorros.\n7. Poss�vel auto-salvamento: Se o gelo � s�lido pode-se distribuir o seu peso sobre o gelo e puxe-se. Rastejar em sua barriga para a beira. Se gelo for fr�gil, pode tentar quebrar o gelo peda�o por peda�o at� a beira.");aid_insectstings = new StringItem ("Picadas de Insetos", "Incha�o, vermelhid�o, sensa��o de queimor, fraqueza, dificuldade respirat�ria, diminui��o da consci�ncia, taquicardia.\n1. Retire com cuidado o ferr�o (com uma pin�a). N�o aperte o ferr�o pois assim poderia injetar mais veneno.\n2. Refrigerar o local da causa (aplicar uma compressa fria).\n3. �rea em quest�o deve ser mantida mais baixo do que o cora��o a fim de diminuir a circula��o do veneno.\n4. Se a picada for na area boca-queixo: Abuse de gelados, e aplique uma compressa fria em torno da garganta.\n5. Se ocorrerem problemas graves chamar uma ambul�ncia.");aid_nosebleeding = new StringItem ("Sangramento no Nariz", "Rompeu uma pequena art�ria na ponta do nariz.\n1. Sente a pessoa com o sangramento, um pouco virada pra frente. Manter a cabe�a reta.\n2. N�o coloque a pessoa deitada, mantenha a cabe�a acima do nivel do cora��o, para assim cessar o sangramento lentamente.\n3. Enrole o pesco�o com pano frio.\n4. Pressione as narinas juntas at� que estanque a hemorragia (por 10 min).\n5. Depois n�o assoe o nariz (sem sopros violentos).\n6. Se ocorrerem problemas graves ou sangramento n�o puder ser parado, chame a emerg�ncia m�dica.");aid_poisining = new StringItem ("Envenenamento", "Confus�o, alucina��es, pupilas dilatadas, febre, c�inbras. Inconsci�ncia.\n1. S� dar ant�dotos, se forem acompanhados por um m�dico treinado.\n2. N�o d� bebidas. N�o provocar v�mitos.\n3. Chame a emerg�ncia anotar o tipo do envenenamento!\n4. Guardar os restos do veneno e vomitar!\n5. Se v�tima est� consciente e respira: Manter em posi��o de recupera��o . Monitore o estado da vitima ate a chegada da ambul�ncia.\n6. Se a v�tima n�o estiver respirando: Come�ar imediatamente com reanima��o! Limpe a boca de v�mito de antem�o.");aid_recoveryposition = new StringItem ("Posi��o de Recupera��o", "1. Coloque a vitima sobre as suas costas, posiciona as pernas. Joelho para baixo ao lado.\n2. Coloque o bra�o mais pr�ximo a voc� em um �ngulo reto com o corpo.\n3. Puxar bra�o mais afastado do peito e coloque as costas da m�o contra a bochecha.\n4. Pegue o joelho longe, puxe-o para seu lado, e estabelecem-lo no ch�o. Posi��o da perna direita em um �ngulo. Manter a m�o sobre a bochecha da vitima.\n5. Certifique-se as vias a�reas est�o livres.\n6. Boca ligeiramente aberta, e a posi��o da cabe�a de forma que o v�mito possa escorrer. Confira a respira��o.\n7. Controle o estado da vitima at� que a emerg�ncia chegue.");aid_resuscitation = new StringItem ("Reanima��o", "# Massagem no Cora��o\n1. Deite a vitima de frente. Ajoelhe-se ao lado.\n2. Retire qualquer roupa que cubra o peito(regiao do coracao).\n3. Coloque uma m�o aberta no meio do peito (um pouco acima do esterno).\n4. Colocar a outra m�o sobre as costas da m�o, que j� est� na posi��o correta.\n5. Estique os seus bra�os e cotovelos.\n6. Pressione 5 cm de profundidade no t�rax da vitima (a for�a vem da parte superior do corpo) e solte.\n7. Pressione 30 vezes em uma linha em breve e forte!\n\n# Respira��o\n1. Estique a cabe�a para tr�s do pesco�o. Remover subst�ncias para fora da boca e da garganta.\n2. Empurre as abas do nariz em conjunto, de forma que nariz fique fechado.\n3. Respire fundo e coloque a boca na boca da vitima, de forma que n�o pode vazar ar.\n4. Fazer a respira��o boca-a-boca duas vezes (respira��o lenta e totalmente fora).\n5. Depois fazer massagem card�aca novamente.\n\nRepita a massagem card�aca, respira��o boca at� a chegada da ambul�ncia.");aid_safeguardaccident = new StringItem ("Seguran�a em Acidente", "1. Pare com seu pr�prio carro 50-100m atr�s do local do acidente, (se voc� estiver em uma rodovia). Ligue os alertas. Ponha colentede visibilidade.\n2. Posicione o tri�ngulo de aviso antes do local do acidente. Aten��o: Se o acidente � uma curva posicione o tri�ngulo de aviso antes da curva!\n3. Pe�a ajuda � outras pessoas.\n4. Abrir a porta do carro da vitima. Desligue igni��o.\n5. Socorro �s v�timas do acidente: soltar o cinto de seguran�a, mova o assento para tr�s. Deixe a remo��o da vitima de dentro do carro pelo pessoal de resgate.\n6. Chame a emerg�ncia.\n7. Prossiga com os primeiros socorros.");aid_shock = new StringItem ("Choque", "Dist�rbio circulat�rio pela fraca oferta de oxig�nio no organismo.\nCausa: Perda de l�quido, reduzido volume sangu�neo.\nSintomas: Palidez, pele fria, suor frio, ansiedade.\n1. Eliminar a causa do choque (por exemplo, parar a perda de fluido, vincular a ferida)!\n2. Estabelecer os feridos em um cobertor, a posi��o das pernas para cima. Manter a vitima calma.\n3. Chame a emerg�ncia.\n4. Se notar dificuldades em respirar ou consci�ncia, iniciar reanima��o.");aid_skullfracture = new StringItem ("Fratura Craniana", "Aspectos: sangramentos fora do nariz, boca ou ouvido. Muitas vezes existem feridas abertas no cr�nio.\n1. Mantenha as vias a�reas livres.\n2. Se consciente: Sente com os feridos curvando a cabe�a para frente. Evitar maiores movimentos!\n3. Se inconsciente: Posi��o de Recupera��o (sem press�o sobre a ferida da cabe�a).\n4. Chame a emerg�ncia.\n5. Aplicar curativo na cabe�a.\n6. Se as dificuldades em respirar ou consci�ncia, iniciar reanima��o.");aid_snakebite = new StringItem ("Acidente of�dico", "Ferimento no tamanho de um alfinete, dor severa, edema, cor p�rpura. Dist�rbio circulat�rio, perigo de choque.\n1. Estabilize a parte do corpo ferida.\n2. Aplicar compressa fria ao redor da ferida.\n3. Utilize medidas contra choque.\n4. Chame a emerg�ncia.");aid_sos = new StringItem ("SOS", "1. Sinal: 3x curto, longas 3x, 3x curto.\n2. Visualmente (luz estrobo, lanterna), ou acusticamente (sinal de apito, bater).");aid_sprain = new StringItem ("Esfor�os + disten��o", "Dor, incha�o (contus�o), perda da fun��o, deforma��o do membro.\n1. Imobilize a parte lesada do corpo apenas na posi��o mais confort�vel para a vitima.\n2. Resfriar (utilizando bolsa de gelo).\n3. Se poss�vel, elevar a parte lesada.\n4. Ir para o hospital ou chamar a emerg�ncia m�dica.");aid_stroke = new StringItem ("Ataque S�bito", "S�bita sensa��o de dorm�ncia ou paralisia (face, bra�os, pernas), perturba��es da linguagem compreens�o, a vis�o problemas de consci�ncia perturbada, uma forte dor de cabe�a. Problemas na respira��o e degluti��o, perda de controle sobre a bexiga e intestino.\n1. Chame a emerg�ncia!\n2. Afrouxar roupas apertadas, n�o d� drogas ou bebidas.\n3. Sentar ou deita-lo confortavelmente. Acalme-o!\n4. Controle consci�ncia e respira��o.\n5. Se sentir dificuldades em respirar ou consci�ncia, iniciar reanima��o.");aid_suffocation = new StringItem ("Asfixia", "A insufici�ncia de oxig�nio. Traqu�ia fechou. Perigo: apneia.\nSintomas: ofegante ru�do respirat�rio, tosse constante, falta de ar, descolora��o da pele.\n1. A��o imediata! Deixa a pessoa aflita com tosse muito forte.\n2. Bata firmemente com uma m�o nas costas plana entre as esc�pulas.\n3. Se sem sucesso: Fique atr�s da vitima, bra�os em volta da cintura, curvar ligeiramente para frente.\n4. Firmar o seu punho, posi��o que tinha � altura do est�mago da pessoa, e lev�-la com a outra m�o.\n5. Ao abra�ar usar as duas m�os para dar um duro golpe para cima em dire��o O est�mago (seria como tentar levantar a pessoa).\n6. Repita at� 5-vezes! Vias respirat�rias devem ficar isentas do objeto.\n7. Chamada de emerg�ncia.\n8. Se os primeiros socorros n�o for bem-sucedido, continue � faz�-lo at� que chegue a emerg�ncia.");aid_sunburn = new StringItem ("Queimadura solar", "1. Retire a pessoa afectada a partir de luz solar direta. Evitar maiores exposi��es.\n2. Beba muita �gua para reparar a desidrata��o.\n3. Se existir uma grave queimadura solar (bolhas, vermelhid�o, dor), procurar um m�dico.\n4. Se a pele tiver um leve vermelho, ela pode ser arrefecida com toalha molhada. Usar gel ou lo��o ap�s o a exposi��o.");aid_sunstroke = new StringItem ("Insola��o", "Cabe�a quente vermelho, pele fria, de doen�a, de cabe�a, tontura. Causa: irrita��o da membrana cerebral.\n1. V� para um lugar frio (sombra) e colocar a parte superior do corpo da pessoa para cima.\n2. Esfriar a cabe�a com cobertores molhados.\n3. Chame a emerg�ncia, mantenha o controle da respira��o.\n4. Se consciente: Ministre bebida fresca, se aplic�vel.\n5. Se aparecer apneia, inicie a respira��o:\n6. V� em frente d�-lhe respira��o!");aid_unconsciouswithbreath = new StringItem ("Inconsci�ncia com respira��o", "Nenhuma rea��o em voz alta a perguntas, sem resposta sobre agita��o. Existe apenas respira��o.\n1. Se h� pessoas pr�ximas a voc� pe�a ajuda.\n2. Posi��o de recupera��o. Boca aberta de maneira que o v�mito possa escorrer.\n3. Chame a emerg�ncia.");aid_unconsciouswithoutbreath = new StringItem ("Inconsci�ncia sem respirar", "1. Nenhuma rea��o da v�tima, sem respirar.\n\nInicie Reanima��o.");aid_vomiting = new StringItem ("V�mito", "Surge a partir de n�useas. Est�mago esvazia por si mesmo. Causas: Infec��o, intoxica��o, �lcera, drogas, comida ruim, ou gravidez.\n1. Perigo para a circula��o devido � desidrata��o e perda de sal!\n2. D� l�quidos (ch�, �gua).\n3. Se houver fortes perturba��es, com sangue ou v�mitos cont�nuos chame a emerg�ncia m�dica.");separator = new StringItem ("Separator", "-");			separator = new StringItem ("Separator", "-");
			stringItemArray = new StringItem[] {
					aid_disclaimer, separator, aid_general, aid_resuscitation, aid_diabeticcoma, aid_hypoglycaemia, aid_hypothermia, aid_electricityaccident, aid_safeguardaccident, aid_snakebite, aid_drowning, aid_amputation, aid_apnoea, aid_suffocation, aid_asthma, aid_heartattack, aid_stroke, aid_checkbreathing, aid_shock, aid_diabeticcoma, aid_brainconcussion, aid_diarrhoea, aid_asthma, aid_suffocation, aid_poisining, aid_epilepsy, aid_sprain, aid_fracture, aid_skullfracture, aid_backinjury, aid_hyperthermia, aid_unconsciouswithbreath, aid_unconsciouswithoutbreath, aid_sunstroke, aid_backinjury, aid_eyeinjury, aid_emergencycall, aid_animalbite, aid_birth, aid_insectstings, aid_recoveryposition, aid_frostbitesevere, aid_frostbitemild, aid_chemicalburn, aid_chemicalburneyes, aid_sunburn, aid_burningsevere, aid_burningslight, aid_allergic, aid_resuscitation, aid_icerescue, aid_apnoea, aid_bleedingsevere, aid_bleedinglight, aid_nosebleeding, aid_safeguardaccident, aid_sos, aid_vomiting, aid_dangerzone, separator}; 

			display = Display.getDisplay(this);
			display.setCurrent(this.menu);

			// sets the focus to the given index of the specified list.
			UiAccess.setCurrentListIndex(display, this.menu, 0);

			// set commands and listener to form
			details.addCommand(cmdBack);
			details.setCommandListener(this);

			// application has started
			started = true;
		}
	}


	public void applyText(int auswahl) {
		// clear form
		details.deleteAll();
		// assign title according title of menuItem 
		details.setTitle(UiAccess.getListItem(menu, menu.getSelectedIndex()).getText());
		// assign text according to int 'auswahl' 
		details.append(stringItemArray[auswahl].getText());

		// img:IMAGES
		
		  // spacer
		  details.append(""); 

		  // img: CC licence
		  if (auswahl==0) { details.append(imageCC); }
		  // img:apnoea
		else if (auswahl==12 || auswahl==51) { details.append(aid067);        details.append(""); details.append(aid010);        details.append(""); details.append(aid011); }
		  // img:backinjury
		  else if (auswahl==34 || auswahl==29) { details.append(aid065); }
		  // img:birth
		  else if (auswahl==38) { details.append(aid025);        details.append(""); details.append(aid022);         details.append(""); details.append(aid023); }
		  // img:chemicalburneyes
		  else if (auswahl==44) { details.append(aid019); }
		  // img:bleedinglight
		  else if (auswahl==53) { details.append(aid084);           details.append(""); details.append(aid085); }
		  // img:bleedingsevere
		  else if (auswahl==52) { details.append(aid084);           details.append(""); details.append(aid085);           details.append(""); details.append(aid089);           details.append(""); details.append(aid092); }
		  // img:brainconcussion
		  else if (auswahl==20) { details.append(aid061); }
		  // img:dangerzone
		  else if (auswahl==58) { details.append(aid001); }
		  // img:drowning
		  else if (auswahl==10) { details.append(aid034); }
		  // img:electricityaccident
		  else if (auswahl==7) { details.append(aid045); }
		  // img:epilepsy
		  else if (auswahl==25) { details.append(aid058); }
		  // img:fracture
		  else if (auswahl==27) { details.append(aid107); }
		  // img:heartattack
		  else if (auswahl==15) { details.append(aid061); }
		  // img:icerescue
		  else if (auswahl==50) { details.append(aid041); }
		  // img:recoveryposition
		  else if (auswahl==40) { details.append(aid008);          details.append(""); details.append(aid009);          details.append("\nPosi��o de recupera��o para beb�s:"); details.append(aid028); }
		  // img:resuscitation
		  else if (auswahl==3 || auswahl==49) {          details.append(aid013);
		details.append(""); details.append(aid003);          details.append(""); details.append(aid067);          details.append(""); details.append(aid010);
		         details.append(""); details.append(aid011);          details.append(""); details.append(aid012);
		details.append("\n\n# Ressuscita��o (Beb�)\n\nUse apenas dois dedos:"); details.append(aid029);          details.append("\nN�o respire muito forte:"); details.append(aid030); }
		  // img:safeguardaccident
		  else if (auswahl==55 || auswahl==8) { details.append(aid001); }
		  // img:suffocation
		  else if (auswahl==13 || auswahl==23) { details.append(aid031);          details.append(""); details.append(aid069); }
		  // img:sunstroke
		  else if (auswahl==33) { details.append(aid061); }
		  // img: unconsciouswithbreath
		  else if (auswahl==31) { details.append(aid008);          details.append(""); details.append(aid009); }
		  // spacer below
		  details.append("");

		  // append Resuscitation measures! for unconsciouswithoutbreath / drowning / heartattack / brainconcussion / stroke / shock / poisining
		  if (auswahl==32 || auswahl==10 || auswahl==15 || auswahl==20 || auswahl==16 || auswahl==18 || auswahl==24) { 
		   details.append(aid_resuscitation);     details.append(aid013);     details.append(""); details.append(aid003);  details.append(""); details.append(aid067);      details.append(""); details.append(aid010);  details.append(""); details.append(aid011);      details.append(""); details.append(aid012);  }
		  // for electricity / hypothermia
		  else if (auswahl==7 || auswahl==6) {    details.append(aid_unconsciouswithbreath);    details.append("");   details.append(aid_unconsciouswithoutbreath); 
		   details.append("");   details.append(aid_resuscitation);      details.append(""); details.append(aid003);   details.append(""); details.append(aid067);     details.append(""); details.append(aid010);  details.append(""); details.append(aid011);   }
		 // for sunstroke / asthma / hypoglycaemia
		  else if (auswahl==33 || auswahl==14 || auswahl==5) {    details.append(aid_apnoea);  details.append(""); details.append(aid010);    details.append(""); details.append(aid011);   }
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public void commandAction(Command c, Displayable d) {
		// System.out.println(c.getLabel());
		if(c.getCommandType() == Command.BACK) {
			display.setCurrent(menu);
		}
		else if (c.getCommandType() == Command.EXIT) {
			notifyDestroyed();
		}
		// Country Emergency Menu
		else if (display.getCurrent().getTitle() == telEmergency.getTitle()) {
			details.deleteAll();
			details.setTitle(UiAccess.getListItem(telEmergency, telEmergency.getSelectedIndex()).getText());
			if (telEmergency.getSelectedIndex() == 0) { details.append(stringAfrica); } 
			else if (telEmergency.getSelectedIndex() == 1) { details.append(stringNorthamerica); }
			else if (telEmergency.getSelectedIndex() == 2) { details.append(stringSouthamerica); }
			else if (telEmergency.getSelectedIndex() == 3) { details.append(stringAsia); }
			else if (telEmergency.getSelectedIndex() == 4) { details.append(stringEurope); }
			else if (telEmergency.getSelectedIndex() == 5) { details.append(stringOceania); }
			display.setCurrent(details);
		}
		// Main Menu
		else if (display.getCurrent().getTitle() == menu.getTitle()) {
			if (menu.getSelectedIndex() == 1) { 
				display = Display.getDisplay(this);
				display.setCurrent(telEmergency);
			}
			// catch divider
			else if (menu.getSelectedIndex() == 59) { }
			// notruf
			else if (menu.getSelectedIndex() == 60) {
				try {
					platformRequest("tel:192");
					// platformRequest("http://www.yahoo.com");
					// http://developers.sun.com/mobility/midp/ttips/platformRequest/index.html
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			else {
				// apply text to form and show it
				applyText(menu.getSelectedIndex());
				display = Display.getDisplay(this);
				display.setCurrent(details);
			}
		}
	}
}
