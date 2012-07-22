// Erste.Hilfe.3.0.compatible
package de.firstai;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class FirstAidMobile extends MIDlet implements CommandListener {

		boolean started = false;
		Form formTextHolder;
		Display display;
		List menu;	
		List telEmergency;
		
		// Setup of the navigation buttons:
		// static final Command cmdChose = new Command("W�hle", Command.OK, 2);
		static final Command cmdBack = new Command("Zur�ck", Command.BACK, 2);
		static final Command cmdExit = new Command("Exit", Command.EXIT, 2);

		StringItem softwareha;
		StringItem allgemeines;
		StringItem allergreakt;
		StringItem amputation; 
		StringItem asthma; 
		StringItem atemstillstand;
		StringItem atmungpruefen;
		StringItem augenverletzung;
		StringItem augenveraetzung;
		StringItem bwlosOhneAtmung;
		StringItem bwlosMitAtmung;
		StringItem blutungleicht;
		StringItem blutungschwer;
		StringItem diabetkoma;
		StringItem durchfall;
		StringItem eisunfall;
		StringItem elektrounfall;
		StringItem epileptanfall;
		StringItem erbrechen;
		StringItem erfrierleicht;
		StringItem erfrierstark;
		StringItem ersticken;
		StringItem ertrinken;
		StringItem geburt;
		StringItem gefahrenzone;
		StringItem gehirnerschuett;
		StringItem herzinfarkt;
		StringItem hitzschlag;
		StringItem insektenstich;
		StringItem knochenbruch;
		StringItem nasenbluten;
		StringItem notruf;
		StringItem schaedelbruch;
		StringItem schlaganfall;
		StringItem schlangenbiss;
		StringItem schock;
		StringItem sonnenbrand;
		StringItem sonnenstich;
		StringItem sos;
		StringItem stabileseitenlage;
		StringItem tierbiss;
		StringItem unterkuehlung;
		StringItem unterzuckerung;
		StringItem veraetzung;
		StringItem verbrennungLeicht;
		StringItem verbrennungSchwer;
		StringItem vergiftung;
		StringItem verkehrsunfall;
		StringItem verstauchung;
		StringItem wiederbelebung;
		StringItem wirbelsaeule;
		
		StringItem stringAfrica;
		StringItem stringAsia;
		StringItem stringEurope;
		StringItem stringNorthamerica;
		StringItem stringOceania;
		StringItem stringSouthamerica;
		
		public FirstAidMobile() {
			formTextHolder = new Form ("Erste Hilfe");
		}

		public void startApp() {
			
			if (!started) {
				telEmergency = new List ("Kontinent w�hlen", Choice.IMPLICIT);
				telEmergency.append("Afrika", null);
				telEmergency.append("Asien", null);
				telEmergency.append("Europa", null);
				telEmergency.append("Nord-/Zentralamerika", null);
				telEmergency.append("Ozeanien", null);
				telEmergency.append("S�damerika", null);
				telEmergency.addCommand(cmdBack);
				telEmergency.setCommandListener(this);
				
				stringAfrica = new StringItem("Afrika", "\n\n# �gypten\nFeuer:180 | Pol:122 | Not:123\n\n# Algerien\nFeuer:14 | Pol:17 | Not:17\n\n# Angola\nFeuer:118 | Pol:110 | Not:118\n\n# �quatorialguinea\nnur lokale Nummern\n\n# �thiopien\nFeuer:93 | Pol:91 | Not:92\n\n# Benin\nFeuer:18 | Pol:17 | Not:301769\n\n# Botsuana\nFeuer:998 | Pol:999 | Not:997\n\n# Burkina Faso\nFeuer:18 | Pol:17 | Not:lokal\n\n# Burundi\nkein System\n\n# Dschibuti\nFeuer:18 | Pol:17 | Not:351351\n\n# Elfenbeink�ste\nFeuer:180 | Pol:110 | Not:110\n\n# Eritrea\nnur lokale Nummern\n\n# Gabun\nFeuer:18 | Pol:1730 | Not:1300\n\n# Gambia\nFeuer:118 | Pol:117 | Not:116\n\n# Ghana\nFeuer:192 | Pol:191 | Not:193\n\n# Guinea\nnur lokale Nummern\n\n# Guinea-Bissau\nnur lokale Nummern\n\n# Kamerun\nFeuer:18 | Pol:17 | Not:lokal\n\n# Kap Verde\nFeuer:131 | Pol:132 | Not:130\n\n# Kenia\nFeuer:999 | Pol:999 | Not:999\n\n# Komoren\nnur Radiotelefon\n\n# Kongo (Demokrat. Republik)\nnur lokale Nummern\n\n# Kongo (Republik)\nnur lokale Nummern\n\n# Lesotho\nFeuer:122 | Pol:123 | Not:121\n\n# Liberia\nFeuer:911 | Pol:911 | Not:911\n\n# Libyen\nFeuer:193 | Pol:193 | Not:193\n\n# Madagaskar\nFeuer:18 | Pol:117 | Not:2262566\n\n# Malawi\nFeuer:199 | Pol:199 | Not:199\n\n# Mali\nFeuer:18 | Pol:17 | Not:15\n\n# Marokko\nFeuer:15 | Pol:19 | Not:15\n\n# Mauretanien\nFeuer:118 | Pol:117 | Not:lokal\n\n# Mauritius\nFeuer:999 | Pol:999 | Not:999\n\n# Mayotte\nFeuer:603054 | Pol:112 | Not:15\n\n# Mosambik\nFeuer:198 | Pol:119 | Not:117\n\n# Namibia\nFeuer:2032270 | Pol:1011 | Not:2032276\n\n# Niger\nFeuer:18 | Pol:17 | Not:723141\n\n# Nigeria\nFeuer:190 | Pol:119 | Not:199\n\n# Reunion\nFeuer:18 oder 112 mobil | Pol:17 oder 112 mobil | Not:15 oder 112 mobil\n\n# Ruanda\nFeuer:lokal | Pol:112 | Not:lokal\n\n# Sahara (Demokrat. Arab. Republik)\nunbekannt\n\n# Sambia\nFeuer | Pol | Not: 991 oder 112 mobil\n\n# Sao Tome und Principe\nunbekannt\n\n# Senegal\nFeuer:lokal | Pol:lokal | Not:8891515\n\n# Seychellen\nFeuer:999 | Pol:999 | Not:999\n\n# Sierra Leone\nFeuer:999 | Pol:999 | Not:999\n\n# Simbabwe\nFeuer:993 | Pol:995 | Not:994\n\n# Somalia\nnur lokale Nummern\n\n# S�dafrika\nFeuer:10111 | Pol:10111 | Not:10177\n\n# Sudan\nFeuer:999 | Pol:999 | Not:lokal\n\n# Swasiland\nFeuer:lokal | Pol:999 | Not:6060911\n\n# Tansania\nFeuer:112 | Pol:112 | Not:112\n\n# Togo\nFeuer:118 | Pol:101 | Not:191\n\n# Tschad\nFeuer:18 | Pol:17 | Not:lokal\n\n# Tunesien\nFeuer:198 | Pol:197 | Not:190\n\n# Uganda\nFeuer | Pol | Not: 999 oder 111 mobil\n\n# Zentralafrikanische Republik\nFeuer:118 | Pol:611253 | Not:610600");
				stringAsia = new StringItem("Asien", "\n\n# Afghanistan\nFeuer:-- | Pol:-- | Not:112\n\n# Armenien\nFeuer:101 | Pol:102 | Not:103\n\n# Aserbaidschan\nFeuer:101 | Pol:102 | Not:103\n\n# Bahrain\nFeuer:999 | Pol:999 | Not:999\n\n# Bangladesch\nFeuer:9555555 | Pol:8665513 | Not:199\n\n# Bhutan\nFeuer:113 | Pol:110 | Not:112\n\n# Brunei\nFeuer:995 | Pol:993 | Not:991\n\n# China\nFeuer:119 | Pol:110 | Not:120\n\n# Georgien\nFeuer:022 | Pol:022 | Not:022\n\n# Hong Kong\nFeuer:999 | Pol:999 | Not:999\n\n# Indien\nFeuer:101 | Pol:100 | Not:102\n\n# Indonesien\nFeuer:113 | Pol:110 | Not:118\n\n# Irak\nkein System\n\n# Iran\nFeuer:125 oder 112 mobil | Pol:110 oder 112 mobil  | Not:115 oder 112 mobil\n\n# Israel\nFeuer:102 | Pol:100 | Not:101\n\n# Japan\nFeuer:119 | Pol:110 | Not:119\n\n# Jemen\nFeuer:199 | Pol:199 | Not:199\n\n# Jordanien\nFeuer:193 | Pol:192 | Not:193\n\n# Kambodscha\nFeuer:118 | Pol:117 | Not:199\n\n# Kasachstan\nFeuer:03 | Pol:03 | Not:03\n\n# Katar\nFeuer:999 | Pol:999 | Not:999\n\n# Kirgisistan\nFeuer:03 | Pol:133 | Not:03\n\n# Kurdistan\nFeuer:125 | Pol:129 | Not:115\n\n# Kuwait\nFeuer:777 | Pol:777 | Not:777\n\n# Laos\nFeuer:lokal | Pol:lokal | Not:03\n\n# Libanon\nFeuer:175 | Pol:112 | Not:140\n\n# Macao\nFeuer:999 | Pol:999 | Not:999\n\n# Malaysia\nFeuer | Pol | Not: 999 oder 112 mobil\n\n# Malediven\nFeuer:118 | Pol:119 | Not:102\n\n# Mongolei\nFeuer:101 | Pol:102 | Not:103\n\n# Myanmar\nFeuer:199 | Pol:199 | Not:199\n\n# Nepal\nFeuer:101 | Pol:100 | Not:228094\n\n# Nordkorea\nnur lokale Nummern\n\n# Oman\nFeuer:999 | Pol:999 | Not:999\n\n# Osttimor\nFeuer:-- | Pol:112 | Not:7233212\n\n# Pakistan\nFeuer:16 | Pol:15 | Not:115\n\n# Philippinen\nFeuer:117 | Pol:117 | Not:117\n\n# Saudi-Arabien\nFeuer:998 | Pol:999 | Not:997\n\n# Singapur\nFeuer:995 | Pol:999 | Not:995\n\n# Sri Lanka\nFeuer:111 | Pol:119 oder 112 mobil | Not:110\n\n# S�dkorea\nFeuer:119 | Pol:112 | Not:119\n\n# Syrien\nFeuer:113 | Pol:112 | Not:110\n\n# Tadschikistan\nFeuer:lokal | Pol:02 | Not:03\n\n# Taiwan\nFeuer:119 | Pol:110 | Not:119\n\n# Thailand\nFeuer:199 | Pol:191 oder 1155 (Touristen) | Not:191\n\n# Turkmenistan\nFeuer:03 | Pol:03 | Not:03\n\n# Usbekistan\nFeuer:03 | Pol:03 | Not:03\n\n# Vereinigte Arabische Emirate\nFeuer:997 | Pol:999 | Not:998\n\n# Vietnam\nFeuer:114 | Pol:113 | Not:115");
				stringEurope = new StringItem("Europa", "\n\n# Albanien\nFeuer:18 | Pol:19 | Not:17\n\n# Andorra\nFeuer:118 | Pol:110 | Not:118\n\n# Belgien\nFeuer:112 | Pol:112 | Not:112\n\n# Bosnien und Herzegowina\nFeuer:123 | Pol:122 | Not:124\n\n# Bulgarien\nFeuer:112 | Pol:112 | Not:112\n\n# D�nemark\nFeuer:112 | Pol:112 | Not:112\n\n# Deutschland\nFeuer:112 | Pol:110 | Not:112\n\n# Estland\nFeuer:112 | Pol:112 | Not:112\n\n# Finnland\nFeuer:112 | Pol:112 | Not:112\n\n# Frankreich\nFeuer:18 oder 112 | Pol:17 oder 112 | Not:15 oder 112\n\n# Griechenland\nFeuer:112 | Pol:112 | Not:112\n\n# Gro�britannien\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Irland\nFeuer:112 | Pol:112 | Not:112\n\n# Island\nFeuer:112 | Pol:112 | Not:112\n\n# Italien\nFeuer:112 | Pol:112 | Not:112\n\n# Kosovo\nFeuer:911 | Pol:911 | Not:911\n\n# Kroatien\nFeuer:93 | Pol:92 | Not:94\n\n# Lettland\nFeuer:112 | Pol:112 | Not:112\n\n# Liechtenstein\nFeuer:112 | Pol:112 | Not:112\n\n# Litauen\nFeuer:112 | Pol:112 | Not:112\n\n# Luxemburg\nFeuer:112 | Pol:112 | Not:112\n\n# Malta\nFeuer:112 | Pol:112 | Not:112\n\n# Mazedonien\nFeuer:112 | Pol:112 | Not:112\n\n# Moldau (Moldawien)\nFeuer:901 | Pol:902 | Not:903\n\n# Monaco\nFeuer:112 | Pol:112 | Not:112\n\n# Montenegro\nFeuer:112 | Pol:112 | Not:112\n\n# Niederlande\nFeuer:112 | Pol:112 | Not:112\n\n# Norwegen\nFeuer:110 | Pol:112 | Not:113\n\n# �sterreich\nFeuer:112 | Pol:112 | Not:112\n\n# Polen\nFeuer:112 | Pol:112 | Not:112\n\n# Portugal\nFeuer:112 | Pol:112 | Not:112\n\n# Rum�nien\nFeuer:112 | Pol:112 | Not:112\n\n# Russland\nFeuer:01 | Pol:02 | Not:03\n\n# San Marino\nFeuer:116 | Pol:112 | Not:113\n\n# Schweden\nFeuer:112 | Pol:112 | Not:112\n\n# Schweiz\nFeuer:118 oder 112 | Pol:117 oder 112 | Not:144 oder 112\n\n# Serbien\nFeuer:112 | Pol:112 | Not:112\n\n# Slowakei\nFeuer:112 | Pol:112 | Not:112\n\n# Slowenien\nFeuer:112 | Pol:113 | Not:112\n\n# Spanien\nFeuer:112 | Pol:112 | Not:112\n\n# Tschechien\nFeuer:112 | Pol:112 | Not:112\n\n# T�rkei\nFeuer:110 | Pol:155 | Not:112\n\n# Ukraine\nFeuer:112 | Pol:112 | Not:112\n\n# Ungarn\nFeuer:112 | Pol:112 | Not:112\n\n# Vatikanstadt\nFeuer:115 | Pol:112 | Not:113\n\n# Wei�russland\nFeuer:01 | Pol:02 | Not:03\n\n# Zypern\nFeuer:112 | Pol:112 | Not:112");
				stringNorthamerica = new StringItem("Nord-/Zentralamerika", "\n\n# USA\nFeuer:911 | Pol:911 | Not:911\n\n# Antigua und Barbuda\nFeuer:911 | Pol:911 | Not:911\n\n# Bahamas\nFeuer:911 | Pol:911 | Not:911\n\n# Barbados\nFeuer:113 | Pol:112 | Not:115\n\n# Belize\nFeuer:911 | Pol:911 | Not:911\n\n# Cayman Islands\nFeuer:911 | Pol:911 | Not:911\n\n# Costa Rica\nFeuer:911 | Pol:911 | Not:911\n\n# Dominica\nFeuer:999 | Pol:999 | Not:999\n\n# Dominikanische Republik\nFeuer:911 | Pol:911 | Not:911\n\n# El Salvador\nFeuer:911 | Pol:911 | Not:911\n\n# Grenada\nFeuer:911 | Pol:112 | Not:911\n\n# Gr�nland\nnur lokale Nummern\n\n# Guatemala\nFeuer:122 | Pol:110 | Not:123\n\n# Haiti\nFeuer:lokal | Pol:114 | Not:118\n\n# Honduras\nFeuer:198 | Pol:119 | Not:378654\n\n# Jamaika\nFeuer:110 | Pol:119 | Not:110\n\n# Kanada\nFeuer:911 | Pol:911 | Not:911\n\n# Kuba\nFeuer:26811 | Pol:26811 | Not:26811\n\n# Mexiko\nFeuer:060 | Pol:080 | Not:060\n\n# Nicaragua\nFeuer:2650162 | Pol:118 | Not:2651761\n\n# Panama\nFeuer:103 | Pol:104 | Not:2699778\n\n# Saint Kitts und Nevis\nFeuer:911 | Pol:911 | Not:911\n\n# Saint Lucia\nFeuer:911 | Pol:999 | Not:911\n\n# Saint Pierre und Miquelon\nFeuer:18 | Pol:17 | Not:15\n\n# Saint Vincent und Grenadinen\nFeuer:911 | Pol:911 | Not:911\n\n# Trinidad und Tobago\nFeuer:990 | Pol:999 | Not:990");
				stringOceania = new StringItem("Ozeanien", "\n\n# Australien\nFeuer | Pol: | Not: 000 oder 112 mobil\n\n# Fidschi\nFeuer:9170 | Pol:911 | Not:911\n\n# Kiribati\nFeuer:lokal | Pol:lokal | Not:994\n\n# Marshallinseln\nFeuer:lokal | Pol:6258666 | Not:6254111 \n\n# Mikronesien\nnur lokale Nummern\n\n# Nauru\nnur lokale Nummern\n\n# Neuseeland\nFeuer:111 | Pol:111 | Not:111\n\n# Palau\nFeuer:911 | Pol:911 | Not:911\n\n# Papua-Neuguinea\nFeuer:110 | Pol:000 | Not:lokal\n\n# Salomonen\nFeuer:911 | Pol:911 | Not:911\n\n# Samoa\nFeuer:994 | Pol:995 | Not:996\n\n# Tonga\nFeuer:999 | Pol:922 | Not:933\n\n# Tuvalu\nFeuer:911 | Pol:911 | Not:911\n\n# Vanuatu\nFeuer:112 | Pol:112 | Not:112");
				stringSouthamerica = new StringItem("S�damerika", "\n\n# Argentinien\nFeuer:100 | Pol:101 | Not:107\n\n# Bolivien\nFeuer:911 | Pol:911 | Not:911\n\n# Brasilien\nFeuer:193 | Pol:190 | Not:192\n\n# Chile\nFeuer:132 | Pol:133 | Not:131\n\n# Ecuador\nFeuer:102 | Pol:101 | Not:131\n\n# Guyana\nFeuer:912 | Pol:911 | Not:913\n\n# Kolumbien\nFeuer:119 | Pol:119 | Not:119\n\n# Paraguay\nFeuer:911 | Pol:911 | Not:911\n\n# Peru\nFeuer:116 | Pol:105 | Not:116\n\n# Suriname\nFeuer:115 | Pol:115 | Not:115\n\n# Uruguay\nFeuer:911 | Pol:911 | Not:911\n\n# Venezuela\nFeuer:171 | Pol:171 | Not:171");
				
				menu = new List("Erste Hilfe 3.0", Choice.IMPLICIT);
				menu.append("- Haftung+Hinweise -", null); // 0
				menu.append("- Notrufe weltweit -", null); // 1 
				menu.append("Allgemeines", null); // 2
				menu.append("Allergische Reaktion", null); // 3
				menu.append("Amputation", null); // 4
				menu.append("Asthma / Atemnot", null); // 4
				menu.append("Atemstillstand", null); // 5
				menu.append("Atmung pr�fen", null); // 6
				menu.append("Augenverletzung", null); // 7
				menu.append("Augenver�tzung", null); // 8
				menu.append("Beatmung", null); // 9
				menu.append("Bewusstlosigkeit mit Atmung", null); // 10
				menu.append("Bewusstlosigkeit ohne Atmung", null); // 11
				menu.append("Blutung Leicht", null); // 12
				menu.append("Blutung Schwer", null); // 13
				menu.append("Diabetisches Koma", null); // 14
				menu.append("Durchfall", null); // 15
				menu.append("Eisunfall", null); // 16
				menu.append("Elektrounfall", null); // 17
				menu.append("Epileptischer Anfall", null); // 18
				menu.append("Erbrechen", null); // 19
				menu.append("Erfrierung leicht", null); // 20
				menu.append("Erfrierung stark", null); // 21
				menu.append("Ersticken", null); // 22
				menu.append("Ertrinken", null); // 23
				menu.append("Geburt", null); // 24
				menu.append("Gefahrenzone", null); // 25
				menu.append("Gehirnersch�tterung", null); // 26
				menu.append("Herzdruckmassage", null); // 27
				menu.append("Herzinfarkt", null); // 28
				menu.append("Hitzschlag", null); // 29
				menu.append("Insektenstich", null); // 30
				menu.append("Knochenbruch", null); // 31
				menu.append("Nasenbluten", null); // 32
				menu.append("Notruf", null); // 33
				menu.append("Reanimation", null); // 34
				menu.append("R�ckenverletzung", null); // 35
				menu.append("Sch�delbasisbruch", null); // 36
				menu.append("Schlaganfall", null); // 37
				menu.append("Schlangenbiss", null); // 38
				menu.append("Schock", null); // 39
				menu.append("Sonnenbrand", null); // 40
				menu.append("Sonnenstich", null); // 41
				menu.append("SOS", null); // 42
				menu.append("Stabile Seitenlage", null); // 43
				menu.append("Tierbiss", null); // 44
				menu.append("�berhitzung", null); // 45
				menu.append("�berzuckerung", null); // 46
				menu.append("Unfallstelle sichern", null); // 47
				menu.append("Unterk�hlung", null); // 48
				menu.append("Unterzuckerung", null); // 49
				menu.append("Ver�tzung", null); // 50
				menu.append("Verbrennung Leicht", null); // 51
				menu.append("Verbrennung Schwer", null); // 52
				menu.append("Vergiftung", null); // 53
				menu.append("Verkehrsunfall", null); // 54
				menu.append("Verschlucken", null); // 55
				menu.append("Verstauchung/Verrenkung", null); // 56
				menu.append("Wiederbelebung", null); // 57
				menu.append("Wirbels�ulen-Verletzung", null); // 58
				menu.append("-------------", null); // 59
				// Navigation
				// menu.addCommand(cmdChose);
				menu.addCommand(cmdExit);
				menu.setCommandListener(this);

				// First-Aid-Text
				softwareha = new StringItem ("Haftung + Hinweise", "\n\n-- Software --\nErste Hilfe auf dem Handy\nVersion: j3.0\nRelease: 2008-12-24\nLizenz: Creative Commons BY-NC-ND 3.0\nCopyright: Kai Kajus Noack\n\nDieses Programm soll Informationen zur Ersten Hilfe geben. Es stellt jedoch in keiner Weise einen Ersatz f�r einen Erste-Hilfe-Kurs dar, sondern dient der Auffrischung des bereits erworbenen Wissens.\n\n-- Haftungsausschluss --\nBitte beachten Sie, dass ich keine Verantwortung f�r Konsequenzen, die aus der Nutzung entstehen, �bernehme.\nJEGLICHE HAFTUNG IST AUSGESCHLOSSEN!\nVERWENDUNG AUF EIGENE GEFAHR!\n\nIn allen Notf�llen suchen Sie bitte sofort professionelle Hilfe.\n\n-- Entwicklung des Projekts --\nDas Programm soll vielsprachig werden. Freiwillige �bersetzer gesucht!!\n\nWeitere Informationen erhalten Sie im Internet unter www.firstai.de oder schreiben Sie eine E-Mail an: info@firstai.de");
				allgemeines = new StringItem ("Allgemeines", "\n\n1. Leisten Sie immer Erste Hilfe. Sie k�nnen keine Fehler machen.\n2. Achten Sie immer auf Ihre eigene Sicherheit.\n3. Machen Sie sich ein Bild von der Situation + Sichern Sie die Unfallstelle.\n4. Notruf + Sofortma�nahmen!\n5. Bei mehreren Verletzten hat der am st�rksten bedrohte Vorrang.\n6. Beruhigen Sie den Betroffenen. Und bleiben Sie selbst ruhig!\n7. Lagern Sie den Betroffenen falls m�glich bequem. Grunds�tzlich nie Alkohol, Nikotin oder Medikamente verabreichen.");
				allergreakt = new StringItem ("Allergische Reaktion", "\n\n1. Notruf absetzen.\n2. Beruhigen des Betroffenen und bequem hinsetzen.\n3. Allergie-ausl�senden Stoff (z. B. Insektenstachel) vorsichtig entfernen.\n4. Betroffene Hautstelle k�hlen (feuchter Umschlag, Eis).\n5. Falls Betroffener ein Gegenmittel hat, sollte er dieses nutzen.\n6. Kontrolle des Zustands bis Notarzt eintrifft.\n7. Bei eintretender Bewusstlosigkeit oder Atemnot entsprechende Ma�nahmen ergreifen!");
				amputation = new StringItem ("Amputation", "\n\nAbgetrennter K�rperteil kann wieder angen�ht werden. Ziel: Amputat bis zum Eintreffen im Krankenhaus k�hlen.\n\n1. Betroffenen beruhigen, hinlegen und zudecken.\n2. Blutung stoppen, siehe 'Blutung (schwer)' und 'Schock'.\n3. Abgetrennten K�rperteil in ein sauberes trockenes Tuch wickeln und in eine wasserdichte Plastikt�te legen.\n4. Diese Plastikt�te verschlie�en und in eine zweite Plastikt�te legen, die k�hles Wasser/Eis enth�lt.\n5. Keinen Alkohol, Zigaretten oder Essen geben (falls im Krankenhaus mit Narkose operiert wird).\n6. Das Amputat nicht einfrieren (nur k�hlen).\n7. Notarzt rufen oder selbst zum Krankenhaus fahren.");
				asthma = new StringItem ("Asthma/Atemnot", "\n\nStarke Atemnot. Pfeifendes Atemger�usch. Angstgef�hle.\n\n1. Beruhigen des Betroffenen. (Bleiben Sie selbst ruhig!)\n2. Kleidung lockern.\n3. Betroffenen bequem leicht nach vorne gebeugt hinsetzen und auffordern, langsam und tief ein- und auszuatmen.\n4. Falls der Betroffene einen Inhalator besitzt, sollte dieser benutzt werden (helfen Sie dabei). Nach 5-10 min sollte sich Wirkung zeigen.\n5. Sofern keine Besserung eintritt: Inhalator jede 5 min anwenden, solange bis Notarzt eintrifft.\n6. Notruf absetzen.\n7. Falls es zum Atemstillstand kommt, mit der Beatmung beginnen.");
				atemstillstand = new StringItem ("Atemstillstand/Beatmen","\n\nKeine Ger�usche oder Atembewegungen, auffallende Hautverf�rbung.\n\n1. Notruf absetzen.\n2. Betroffenen auf R�cken legen.\n3. Entfernen von Fremdk�rpern aus Mund und Rachen. �berstrecken des Kopfes in den Nacken.\n4. Nasenfl�gel zusammendr�cken, damit Nase geschlossen ist.\n5. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n6. Langsam und vollst�ndig ausatmen.\n7. Falls ohne Erfolg: Atemspende fortsetzen bis Notarzt eintrifft.");
				atmungpruefen = new StringItem ("Atmung pr�fen", "\n\n1. Atemger�usche pr�fen.\n2. Atmung am Oberbauch feststellen (Hand auflegen).\n3. Atmung an Nase/Mund f�hlbar.");
				augenverletzung = new StringItem ("Augenverletzung", "\n\n1. Fremdk�rper im Auge belassen, nicht entfernen.\n2. Augen nicht bewegen, um weitere Verletzungen zu vermeiden. Auge nicht ber�hren.\n3. Bei Augen-Blutung mit Kompresse oder Verbandtuch bedecken.\n4. Auge mit kalter Auflage k�hlen (verringert Schwellung, Blutung stoppt schneller).\n5. Notruf absetzen oder selbst zum Krankenhaus fahren.");
				augenveraetzung = new StringItem ("Augenver�tzung", "\n\n1. Notarzt rufen, auf �tz-Substanz hinweisen.\n2. Auge sofort mit viel Wasser sp�len. Gesundes Auge w�hrend Sp�lung abdecken.\n3. Wasserstrahl vom inneren Augenwinkel zum �u�eren Augenwinkel. Ca. 20 min reinigen.\n4. Beide Augen des Betroffenen schlie�en und mit angefeuchtetem Tuch verbinden.\n5. Zustand kontrollieren, bis Notarzt eintrifft.");
				bwlosMitAtmung = new StringItem ("Bewusstlosigkeit mit Atmung","\n\nKeine Reaktion auf Ansprache und Sch�tteln. Atmung vorhanden.\n\n1. Falls Menschen in der N�he sind, bitten Sie diese um Mithilfe.\n2. Stabile Seitenlage einnehmen. Mund �ffnen und Kopf so positionieren, dass Erbrochenes ablaufen kann.\n3. Notruf absetzen.");
				bwlosOhneAtmung = new StringItem ("Bewusstlosigkeit ohne Atmung","\n\nKeine Reaktion vorhanden, Atmung nicht feststellbar.\n\nWiederbelebung einleiten:\n\n");
				blutungleicht = new StringItem ("Leichte Blutung", "\n\nZiel: Stoppen der Blutung.\n\n1. Wunde nicht ber�hren (Infektionsgefahr).\n2. Wunde nicht mit Puder, Salben, Sprays behandeln.\n3. Wundversorgung mittels keimfreier Wundauflage und Befestigungsmaterial (Pflaster, Binde).\n4. Bei kleiner Blutung reicht meist ein Pflasterstreifen.\n5. Bei gro�fl�chiger Verletzung Wundauflage und Verbandtuch benutzen. Verband nicht zu fest binden, da Stauung zu vermehrter Blutung f�hrt.\n6. Hinweis: Tollwut-Wunden mit Seifenl�sung auswaschen.");
				blutungschwer = new StringItem ("Schwere Blutung", "\n\nSpritzendes, in St��en austretendes Blut. Gefahr: Schock durch Blutverlust, Infektionen, Tod. Ziel: Stoppen der Blutung.\n\n1. Kleidung entfernen (notfalls aufschneiden), Wunde freilegen.\n2. Binde oder notfalls Kleidungsst�ck mit Druck um Wunde wickeln.\n3. F�r mind. 10 min Druck auf Wunde aus�ben.\n4. Falls Binde mit Blut durchn�sst, nicht die alte Binde entfernen! Eine andere Binde/Kleidungsst�ck dar�ber binden.\n5. Verletztes Glied (sofern nicht gebrochen) �ber H�he des Herzens lagern, damit sich Blutung verlangsamt. Wenn m�glich Betroffenen hinlegen.\n6. Falls Blutung nicht stoppt, Druck auf Wunde beibehalten und zus�tzlich Druckpunkte �ber der Wunde setzen: Bei Blutung am Unterarm den Oberarm abdr�cken (Ader auf Arm-Innenseite mittig zwischen Ellbogen und Achselh�hle, mit Fingern abdr�cken). Bei Blutung des Beins, Druckpunkt in Leiste setzen (Ader in Leistenbeuge, wo Arterie �ber Beckenknochen verl�uft, mit Handballen abdr�cken).\n7. Sofort Notarzt anfordern.\n8. Sobald Blutung unter Kontrolle: Schockbek�mpfung einleiten.");
				diabetkoma = new StringItem ("Diabetisches Koma/�berzuckerung","\n\nBlutzuckerspiegel zu hoch bzw. Insulinmangel.\nSymptome: Durst, h�ufiges Wasserlassen, �belkeit, Erbrechen. Atem riecht nach Obst.\n\n1. Notruf absetzen.\n2. Unterst�tzung bei der Insulingabe, sofern sichergestellt, dass Diabetiker.\n3. Stabile Seitenlage. (Keine weiteren M�glichkeiten f�r den Ersthelfer.)\n4. Zustand des Betroffenen kontrollieren bis Notarzt eintrifft.");
				durchfall = new StringItem("Durchfall", "\n\nNahrungsmittel-Unvertr�glichkeit, Darm-Entz�ndung oder Erkrankung. Stuhlgang w�ssrig, schleimig oder blutig.\n\n1. Gefahr f�r Kreislauf aufgrund Fl�ssigkeits- und Salz-Verlustes!\n2. Fl�ssigkeit zuf�hren (Tee, Wasser).\n3. Bei starken Beschwerden Arzt aufsuchen oder Notruf absetzen.");
				eisunfall = new StringItem("Eisunfall", "\n\nEigenschutz beachten! Gefahr: Ertrinken, Unterk�hlung.\n\n1. Rettung erfolgt via Leiter, Brett, Stange. Gewicht muss gro�fl�chig verteilt werden.\n2. Andere Personen um Mithilfe auffordern. Notruf absetzen lassen.\n3. Auf Bauch (m�glichst angeseilt) mit Hilfsmittel vorsichtig zur Einbruchstelle robben.\n4. Verungl�cktem auf Distanz das Hilfsmittel reichen (nicht die Hand!) und herausziehen.\n5. R�ckw�rts bis zum Ufer zur�ckrobben.\n6. Erste-Hilfe-Ma�nahmen.\n7. Eigenrettung m�glich: Bei festem Eis Gewicht auf Eis verteilen und sich selbst herausziehen. Flach auf Bauch zum Ufer zur�ckrobben. Bei br�chigem Eis versuchen Eis bis zum Ufer St�ck f�r St�ck abzubrechen.");
				elektrounfall = new StringItem ("Elektrounfall", "\n\nZuerst Stromzuleitung unterbrechen!\n\nGefahr: Bewusstlosigkeit, Atemstillstand.\n\n");
				epileptanfall = new StringItem ("Epileptischer Anfall", "\n\nStarrer K�rper, geballte F�uste, gepresster Kiefer, Zucken in Beinen oder Gesicht. Rollende Augen. Speichelfluss. Bewusstlosigkeit m�glich.\n\n1. Betroffenen nicht halten oder in Bewegung einschr�nken.\n2. Betroffenen auf weiche Unterlage (Kissen) legen, Objekte in direkter N�he entfernen, somit Selbstverletzungen vorbeugen.\n3. Beruhigend zum Betroffenen reden. Kleidung lockern, f�r Atemfreiheit sorgen.\n4. Falls Betroffener erbricht, Kopf zur Seite drehen, damit Erbrochenes abflie�en kann.\n5. Atemwege freihalten. Gefahr, dass Zunge verschluckt wird.\n6. Stabile Seitenlage + Notruf absetzen. Weiterhin Zustand des Betroffenen kontrollieren.\n7. Andere Leute auf Distanz halten.");
				erbrechen = new StringItem ("Erbrechen", "\n\nFolge von �belkeit. Magen befreit sich. Ursachen: Infektion, Vergiftung, Geschw�r, Medikamente, falsche Nahrung, Schwangerschaft.\n\n1. Gefahr f�r Kreislauf aufgrund Fl�ssigkeits- und Salz-Verlustes!\n2. Fl�ssigkeit zuf�hren (Tee, Wasser).\n3. Bei starken Beschwerden, blutigem oder anhaltendem Erbrechen Arzt aufsuchen.");
				erfrierleicht = new StringItem ("Leichte Erfrierung", "\n\nBl�sse, Schwellen. Gefahr f�r Blutzufuhr.\n\n1. Warmen Bereich aufsuchen.\n2. K�lte beseitigen. Nasse Kleidung entfernen, abtrocknen.\n3. Aufw�rmen mit lauwarmem Wasser und K�rperw�rme des Helfers.\n4. Warmes Getr�nk (Tee) geben. Keinen Alkohol!");
				erfrierstark = new StringItem ("Starke Erfrierung", "\n\nKalte harte Haut, grau-wei�, Blasenbildung, Gewebe stirbt ab. Gefahr f�r Blutzufuhr!\n\n1. Warmen Bereich aufsuchen.\n2. Wunden versorgen/abdecken.\n3. Zuckerhaltiges Getr�nk verabreichen.\n4. Nicht warmreiben!\n5. Notruf absetzen.");
				ersticken = new StringItem ("Ersticken/Verschlucken","\n\nUnzureichende Sauerstoffversorgung. Luftr�hre verschlossen. Gefahr: Atemstillstand.\nSymptome: Pfeifendes Atemger�usch, Hustenreiz, Atemnot, Hautverf�rbung.\n\n1. Sofort handeln! Betroffenen kr�ftig Husten lassen.\n2. Mit flacher Hand auf R�cken zwischen Schulterbl�ttern kr�ftig klopfen (Babys dabei auf Unterarm legen, Kopf nach unten halten).\n3. Wenn ohne Erfolg: Hinter Person stellen, Arme um Taille legen, leicht nach vorne beugen.\n4. Hand zur Faust ballen, auf Magen-H�he des Betroffenen positionieren und mit anderer Hand umfassen.\n5. Beide H�nde in Umklammerung mit hartem Sto� in Richtung Magen nach oben/innen ziehen (als ob Sie die Person hochheben wollen).\n6. Bis zu 5-mal wiederholen! Luftwege sollten vom Objekt befreit sein.\n7. Notruf absetzen.\n8. Falls Ma�nahme nicht erfolgreich, trotzdem fortsetzen, bis Notarzt eintrifft.");
				ertrinken = new StringItem ("Ertrinken", "\n\n1. Notruf absetzen. Personen in der N�he um Hilfe bitten.\n2. Aus Wasser retten!\n3. Wenn Atmung vorhanden: Stabile Seitenlage. Betroffenen warm halten (Decke). Zustand kontrollieren, bis der Notarzt eintrifft.\n4. Bei Atemstillstand sofort mit Wiederbelebung beginnen! (Ausflie�enlassen von Wasser aus Lungen ist nutzlos.)\n\n");
				geburt = new StringItem ("Geburt", "\n\nAbgang von Fruchtwasser. Presswehen treten ein. Unerwartete Geburt.\n\n1. Intimsph�re wahren und Ruhe bewahren! - Notruf absetzen.\n2. Die Schwangere breitbeinig, mit freigemachtem Unterk�rper auf sterile Unterlage hinsetzen.\n3. Kniee anwinkeln. Beine etwas heranziehen. Becken leicht erh�ht lagern. - Die Geburt ist ein nat�rlicher Prozess und l�uft h�ufig ohne Komplikationen ab.\n4. Schwangere beruhigen und auf Atmung konzentrieren lassen: Durch Nase einatmen und Mund ausatmen (normales Atemtempo).\n5. Pressrhythmus: Tief Luft holen, anhalten und pressen. Sobald Kopf des Babys erscheint, mit beiden H�nden unterst�tzend zugreifen.\n6. Nach der Geburt: Neugeborenes schr�g nach unten h�ngen, um Fruchtwasser aus Atemwegen zu befreien. (Evtl. mit dem Mund das Fruchtwasser aus der Nase des Babys absaugen.) Kind muss atmen und schreien!\n7. Nabelschnur 30 cm vom Kind entfernt abbinden (kann auch im Krankenhaus erfolgen). Scheide der Mutter steril abdecken.\n8. Das Baby abtrocknen und warm halten. Uhrzeit notieren und zum Krankenhaus fahren.");  
				gefahrenzone = new StringItem ("Retten aus Gefahrenzone", "\n\n1. Grifftechnik: Arm des Verletzten vor dessen Brust, hinter den Verletzten stellen.\n2. Mit beiden H�nden den angewinkelten Arm des Verletzten durch dessen Achseln greifen.\n3. Person in Sicherheit bringen.");
				gehirnerschuett = new StringItem ("Gehirnersch�tterung", "\n\nKopfschmerz, �belkeit, Erbrechen. Sehst�rung. Bewusstlosigkeit kann eintreten.\n\n1. Betroffenen hinlegen.\n2. Notruf absetzen.\n\n*Bei Blutung am Kopf:\n1. Betroffenen hinlegen, Kopf erh�ht lagern (Kissen).\n2. Wundversorgung durchf�hren (Kopf-Verband anlegen).\n3. Notruf absetzen.");
				herzinfarkt = new StringItem ("Herzinfarkt", "\n\nSchwere mehr als 5 min anhaltende Schmerzen + Druck im Brustkorb, besonders in Arme/Schultern ausstrahlend. Angstgef�hl, Bl�sse, kalter Schwei�. Eventuell �belkeit, Kurzatmigkeit.\n\n1. Notruf absetzen! Hinweis auf vermuteten Herzinfarkt.\n2. Oberk�rper erh�ht lagern. Enge Kleidung lockern. Keine Medikamente oder Getr�nke geben.\n3. Beruhigend auf Betroffenen einreden.\n4. Bewusstsein und Atmung kontrollieren.\n5. Dem Betroffenen Aspirin verabreichen, falls verf�gbar.\n6. Bei Bewusstlosigkeit die Wiederbelebung einleiten:\n\n");
				hitzschlag = new StringItem ("Hitzschlag/�berhitzung","\n\nDurst, Schw�che, Desorientiertheit, Bewusstseinsst�rung, starker Schwei�, hei�e Haut.\n\n1. Notruf absetzen.\n2. K�hlen, schattigen Platz aufsuchen (Raum mit Klimaanlage sehr geeignet).\n3. Betroffenen hinlegen, Beine hochlagern. Kleidung lockern.\n4. Haut mit Wasser k�hlen oder kalte Handt�cher auflegen.\n5. Viel Wasser oder S�fte trinken.");
				insektenstich = new StringItem ("Insektenstich", "\n\nSchwellungen, Hautausschlag, brennendes Gef�hl, Schw�che, Atemnot, Kreislaufprobleme, Herzrasen.\n\n1. Stachel vorsichtig entfernen (mit Pinzette). Nicht auf Stachel dr�cken, k�nnte noch mehr Gift injizieren.\n2. K�hlung der betroffenen Stelle (kalte Kompresse).\n3. Betroffene Stelle niedriger als Herz-H�he halten, damit Gift langsamer zirkuliert.\n4. Bei Stich im Mund-Rachen-Raum: Eis lutschen lassen, kalte Umschl�ge um Hals.\n5. Bei ernsten Beschwerden Notruf absetzen.");
				knochenbruch = new StringItem ("Knochenbruch", "\n\nAnzeichen: Unnat�rliche Lage und Beweglichkeit. Deformierung. Schmerzhafte Bewegung, ber�hrungsempfindlich.\n\n1. Bewegungen vermeiden!\n2. Notruf absetzen.\n3. Bruch ruhig stellen, d.h. Umpolstern mit dichtem Material. Position des gebrochenen Knochens beibehalten.\n4. Bei offenem Bruch die Wunde keimfrei abdecken.");
				nasenbluten = new StringItem ("Nasenbluten", "\n\nKleine Ader in Nasenspitze geplatzt.\n\n1. Blutenden leicht nach vorne gelehnt hinsetzen. Kopf gerade halten.\n2. Nicht flach lagern, da Kopf �ber Herz-H�he Bluten verlangsamt.\n3. Kalter Nackenumschlag.\n4. Nasenspitze bis zum Stopp der Blutung zudr�cken (f�r 10 min).\n5. Anschlie�end Nase in keiner Weise anstrengen (kein Naseschnauben).\n6. Bei ernsten Beschwerden oder wenn Blutung anh�lt Notruf absetzen.");
				notruf = new StringItem ("Notruf", "\n\nW�hlen Sie mit dem n�chst-verf�gbaren Telefon 112. Immer m�glich und kostenlos! Z�gern Sie nie, den Notarzt zu rufen!\n\nAm Telefon Folgendes durchgeben: Wo (Unfallort) - Was ist passiert - Wie viele Verletzte - Welche Verletzungen. Danach auf R�ckfragen warten.");
				schaedelbruch = new StringItem ("Sch�delbasisbruch", "\n\nLeichte Blutungen aus Nase, Mund oder Ohr. Oft offene Wunde am Sch�del.\n\n1. Atemwege freihalten.\n2. Bei Bewusstsein: Verletzten nach vorne gebeugt hinsetzen. Weitere Bewegungen vermeiden!\n3. Bei Bewusstlosigkeit: Stabile Seitenlage (keinen Druck auf Kopfwunde).\n4. Notruf absetzen.\n5. Kopfverband anlegen.\n6. Bei Atem- und Herz-Kreislauf-St�rungen Wiederbelebung einleiten:\n\n");
				schlaganfall = new StringItem ("Schlaganfall", "\n\nPl�tzliches L�hmungs- oder Taubheitsgef�hl (Gesicht, Arm, Bein), gest�rtes Sprachverst�ndnis, Sehst�rung, Bewusstseinstr�bung, starke Kopfschmerzen. Probleme beim Atmen und Schlucken, Kontrollverlust �ber Blase und Darm.\n\n1. Notruf absetzen!\n2. Enge Kleidung lockern, keine Medikamente oder Getr�nke geben.\n3. Betroffenen bequem hinsetzen oder hinlegen. Beruhigen!\n4. Bewusstsein und Atmung kontrollieren.\n5. Bei Atem- und Herz-Kreislauf-St�rungen Wiederbelebung einleiten:\n\n");
				schlangenbiss = new StringItem ("Schlangenbiss", "\n\nPunktf�rmige Wunde in Stecknadelgr��e, heftige Schmerzen, Schwellung, blaurote Verf�rbung. Kreislaufst�rung, Schockgefahr.\n\n1. Verletzten K�rperteil ruhigstellen\n2. Kalte Umschl�ge auf Bissstelle.\n3. Schockbek�mpfung.\n4. Notruf absetzen.");
				schock = new StringItem ("Schock", "\n\nKreislauf-St�rung durch mangelhafte Sauerstoffversorgung im K�rper.\nUrsache: Verlust von Fl�ssigkeit, reduzierte Blutmenge.\nSymptome: Bl�sse, kalte Haut, kalter Schwei�, Unruhe.\n\n1. Schockursache beseitigen (z.B. Fl�ssigkeitsverlust stoppen, Wunde abbinden)!\n2. Betroffenen auf Decke legen, Beine hoch lagern. Beruhigen.\n3. Notruf absetzen.\n4. Bei Atem- und Herz-Kreislauf-St�rungen Wiederbelebung einleiten:\n\n");
				sonnenbrand = new StringItem ("Sonnenbrand", "\n\n1. Betroffenen aus direkter Sonneneinstrahlung nehmen. Weitere Sonne meiden.\n2. Viel Wasser trinken, um Dehydration entgegenzuwirken.\n3. Bei ernsthaftem Sonnenbrand (Blasenbildung, R�tung, Schmerzen) unbedingt Arzt aufsuchen.\n4. Leichte Hautr�tungen mit feuchten Umschl�gen k�hlen. After-Sun-Lotion oder Gel auftragen.");
				sonnenstich = new StringItem ("Sonnenstich", "\n\nHei�er roter Kopf, k�hle Haut, �belkeit, Kopfschmerz, Schwindelgef�hl. Ursache: Reizung der Hirnhaut.\n\n1. K�hlen Ort aufsuchen (Schatten) und Oberk�rper des Betroffenen erh�ht lagern.\n2. Mit nassen T�chern Kopf k�hlen.\n3. Notruf absetzen, Atmung weiterhin kontrollieren.\n4. Bei Bewusstsein: Ggf. k�hles Getr�nk geben.\n5. Bei Atemstillstand mit Beatmung beginnen:\n\n");
				sos = new StringItem ("SOS", "\n\nSignal: 3x kurz, 3x lang, 3x kurz.\n\nOptisch (Blitzlicht, Taschenlampe) oder Akustisch (Signalpfeife, Klopfen).");
				stabileseitenlage = new StringItem ("Stabile Seitenlage", "\n\n1. Betroffenen in R�ckenlage, Beine ausstrecken. Daneben knien.\n2. Nahen Arm im rechten Winkel zum K�rper positionieren.\n3. Fernen Arm �ber Brust des Verletzten ziehen und Handr�cken auf Wange platzieren.\n4. Entferntes Knie fassen, zu sich ziehen und auf Boden legen. Bein etwa im rechten Winkel positionieren. Hand des Betroffenen bleibt auf dessen Wange.\n5. Sicherstellen, dass Atemwege frei sind.\n 6. Mund �ffnen, Kinn anheben und Kopf so positionieren, dass Erbrochenes ablaufen kann. Atmung kontrollieren.\n7. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.");
				tierbiss = new StringItem ("Tierbiss", "\n\nAchtung, hohe Infektionsgefahr. Folgen wie Eiter, Tetanus, Tollwut.\n\n1. Wunde sofort mit hei�em Seifenwasser auswaschen.\n2. Anschlie�end Wunddesinfektion auftragen.\n3. Bei starker Blutung den Oberk�rper erh�ht lagern.\n4. Keimfreien Verband anlegen.\n5. Krankenhaus aufsuchen oder Notruf absetzen.");
				unterkuehlung = new StringItem ("Unterk�hlung", "\n\nK�ltezittern, Schl�frigkeit, Ersch�pfung, bis hin zur Bewusstlosigkeit. Kalte, blasse Haut. Langsamer Puls, schwacher Herzschlag.\n\n1. Warmen Bereich aufsuchen.\n2. Notruf absetzen.\n3. K�lteeinwirkung beenden. K�rpertemperatur erh�hen (Decke und K�rper-zu-K�rper-Kontakt).\n4. Nasse Kleidung entfernen und trockene warme Kleidung anziehen. In Decken packen. Kopf bedecken.\n5. Hei�en Tee, Br�he oder hei�es Wasser zu trinken geben. Keinen Alkohol! Betroffenen wachhalten.\n6. Zustand bis zum Eintreffen des Notarztes kontrollieren. Bei Verlust des Bewusstseins Wiederbelebung einleiten:\n\n");
				unterzuckerung = new StringItem ("Unterzuckerung", "\n\nBlutzuckerspiegel unter Mindestwert (aufgrund �berdosierung von Insulin oder ungen�gender Nahrungsaufnahme).\nSymptome: Bl�sse, Nervosit�t, Hunger, Zittern, Schwei�.\n\n1. Zuerst kl�ren, ob der Betroffene Diabetiker ist (siehe Diabetiker-Ausweis).\n2. Notruf absetzen.\n3. Dem Betroffenen gezuckerte Getr�nke und Traubenzucker geben (sofern keine Schluckschwierigkeiten).\n4. Bei Bewusstlosigkeit und vorhandener Atmung: Stabile Seitenlage einnehmen und Atmung kontrollieren. Falls Atemstillstand eintritt, den Betroffenen beatmen.\n5. Wenn Atmung vorhanden, dem Bewusstlosen ein St�ck Zucker in die Backentasche legen und von au�en gegendr�cken.");
				veraetzung = new StringItem ("Ver�tzung", "\n\nZerst�rung von Gewebe.\n\n1. Eigenschutz beachten!\n2. Z�gig handeln und ver�tzte Stellen absp�len.\n3. Notruf absetzen.\n4. Bei Ver�tzung des Verdauungsweges: Vermehrt Fl�ssigkeit trinken.\n5. Kein Erbrechen ausl�sen!");
				verbrennungLeicht = new StringItem ("Leichte Verbrennung", "\n\nR�tung der Haut. Leichte Schwellung. Schmerzen.\n\n1. Betroffene Stelle unter laufendem kalten Wasser k�hlen.\n2. Feuchten Verband locker anlegen.");
				verbrennungSchwer = new StringItem ("Schwere Verbrennung", "\n\nGefleckte wei�e rote Stellen, Blasenbildung. Fl�ssigkeitsaustritt aus Haut. Tiefe Gewebesch�digung. Starke Schmerzen oder keine Schmerzen (aufgrund verbrannter Nerven).\n\n1. Kleidung soweit wie m�glich entfernen.\n2. Mit kaltem Wasser (ca. 15�C) bis zu 10 min k�hlen, bis Schmerzlinderung eintritt.\n3. Falls Verbrennung gro�fl�chig, nur mit feuchten T�chern k�hlen.\n4. Notruf absetzen.\n5. Nach K�hlung die Wundversorgung durchf�hren. Sterile, trockene Wundauflage benutzen. Keine Fl�ssigkeiten aufbringen (keine Cremes, �le, Salben etc.). Blasen nicht aufstechen.\n6. Atmung und Bewusstsein des Betroffenen kontrollieren, bis Notarzt eintrifft.");
				vergiftung = new StringItem ("Vergiftung", "\n\nVerwirrung, Halluzination, gro�e Pupillen, Fieber, Kr�mpfe. Bewusstlosigkeit.\n\n1. Gegenmittel nur verabreichen, wenn medizinisch ausgebildete Person vor Ort.\n2. Keine Getr�nke geben. Kein Erbrechen ausl�sen.\n3. Notruf absetzen + auf Vergiftung hinweisen!\n4. Giftreste und Erbrochenes sicherstellen!\n5. Sofern Betroffener bewusstlos ist und atmet: Stabile Seitenlage herstellen. Bewusstsein und Atmung kontrollieren bis Notarzt eintrifft.\n6. Sofern keine Atmung: Ma�nahmen zur Wiederbelebung einleiten. Mund vorher von eventuell Erbrochenem befreien.\n\n");
				verkehrsunfall = new StringItem ("Unfallstelle sichern/Verkehrsunfall","\n\n1. Eigenen Pkw 50-100 m hinter Unfallstelle halten (falls Autobahn oder Landstra�e). Danach Warnblinker anschalten und Warnweste anziehen.\n2. Warndreieck vor Unfallstelle aufstellen. Achtung: Bei einem Unfall in der Kurve, Warndreieck vor der Kurve platzieren!\n3. Andere Personen um Mithilfe auffordern.\n4. T�r des Unfall-Pkws �ffnen (falls verklemmt, mittels Wagenheber aufstemmen). Z�ndung ausschalten.\n5. Unfallopfer bergen: Abschnallen, Sitz nach hinten schieben. Verletzten mit Rettungsgriff aus Wagen befreien.\n6. Notruf absetzen.\n7. Erste-Hilfe-Ma�nahmen.");
				verstauchung = new StringItem ("Verstauchung/Verrenkung", "\n\nSchmerzen, Schwellung (Bluterguss), Funktionsverlust, Verformung des Gliedes.\n\n1. Ruhigstellung des Gliedes ausschlie�lich in der f�r Betroffenen angenehmsten Position.\n2. K�hlen (mit Eisbeutel).\n3. Falls m�glich Glied hoch lagern.\n4. Krankenhaus aufsuchen oder Notruf absetzen.");
				wiederbelebung = new StringItem("Wiederbelebung", "\n\n-- Herzdruckmassage --\n1. Betroffenen in R�ckenlage. Daneben hinknien.\n2. Brustkorb freimachen.\n3. In der Mitte des Brustkorbs (kurz �ber Brustbein) einen Handballen platzieren.\n4. Anderen Handballen auf Handr�cken der bereits platzierten Hand.\n5. Arme, Ellbogen durchdr�cken.\n6. Brustkorb des Betroffenen 5 cm senkrecht eindr�cken (aus dem Oberk�rper arbeiten) und wieder entlasten.\n7. 30-mal in Folge kurz und kr�ftig dr�cken.\n\n-- Beatmung --\n1. Entfernen von Fremdk�rpern aus Mund und Rachen. �berstrecken des Kopfes in den Nacken.\n2. Nasenfl�gel zusammendr�cken, damit Nase geschlossen ist.\n3. Tief einatmen und Mund auf Mund des Betroffenen aufsetzen, sodass keine Luft entweichen kann.\n4. Zweimal Mund zu Mund beatmen (langsam, vollst�ndig ausatmen).\n5. Danach wieder Herzdruckmassage.\n\n*Herzdruckmassage + Beatmung fortf�hren bis Rettungsdienst kommt.");
				wirbelsaeule = new StringItem ("R�cken-/Wirbels�ulen-Verletzung", "\n\nSchmerzen im R�cken, gef�hllose Arme und Beine.\n\n1. Verletzten auf keinen Fall bewegen!!\n2. Kopf so halten, dass Betroffener stabil liegt.\n3. Verletzten nur mittels seitlicher Polsterung stabilisieren.\n4. Betroffenen beruhigen.\n5. Notruf absetzen, Hinweis auf R�ckenverletzung.");
				
				// set display, show menu:
				display = Display.getDisplay(this);
				display.setCurrent(menu);
				
				// set command + listener for form:
				formTextHolder.addCommand(cmdBack);
				formTextHolder.setCommandListener(this);

				// application has started
				started = true;
			}
		}

		public void applyText(int auswahl) {
			// clear form
			formTextHolder.deleteAll();
			
			if (auswahl == 0) { formTextHolder.append(softwareha); }
			else if (auswahl == 2) { formTextHolder.append(allgemeines); }
			else if (auswahl == 3) { formTextHolder.append(allergreakt); }
			else if (auswahl == 4) { formTextHolder.append(amputation); }
			else if (auswahl == 5) { formTextHolder.append(asthma); formTextHolder.append(atemstillstand); } 
			else if (auswahl == 6) { formTextHolder.append(atemstillstand); } // Atemstillstand
			else if (auswahl == 7) { formTextHolder.append(atmungpruefen); }
			else if (auswahl == 8) { formTextHolder.append(augenverletzung); }
			else if (auswahl == 9) { formTextHolder.append(augenveraetzung); }
			else if (auswahl == 10) { formTextHolder.append(atemstillstand); } // Beatmung
			else if (auswahl == 11) { formTextHolder.append(bwlosMitAtmung); }
			else if (auswahl == 12) { formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); } 
			else if (auswahl == 13) { formTextHolder.append(blutungleicht); }
			else if (auswahl == 14) { formTextHolder.append(blutungschwer); }
			else if (auswahl == 15) { formTextHolder.append(diabetkoma); }
			else if (auswahl == 16) { formTextHolder.append(durchfall); }
			else if (auswahl == 17) { formTextHolder.append(eisunfall); }
			else if (auswahl == 18) { formTextHolder.append(elektrounfall); formTextHolder.append(bwlosMitAtmung); formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 19) { formTextHolder.append(epileptanfall); }
			else if (auswahl == 20) { formTextHolder.append(erbrechen); }
			else if (auswahl == 21) { formTextHolder.append(erfrierleicht); }
			else if (auswahl == 22) { formTextHolder.append(erfrierstark); }
			else if (auswahl == 23) { formTextHolder.append(ersticken); } // Ersticken
			else if (auswahl == 24) { formTextHolder.append(ertrinken); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 25) { formTextHolder.append(geburt); }
			else if (auswahl == 26) { formTextHolder.append(gefahrenzone); }
			else if (auswahl == 27) { formTextHolder.append(gehirnerschuett); }
			else if (auswahl == 28) { formTextHolder.append(wiederbelebung); } // Herzdruckmassage
			else if (auswahl == 29) { formTextHolder.append(herzinfarkt); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 30) { formTextHolder.append(hitzschlag); } // Hitzschlag
			else if (auswahl == 31) { formTextHolder.append(insektenstich); }
			else if (auswahl == 32) { formTextHolder.append(knochenbruch); }
			else if (auswahl == 33) { formTextHolder.append(nasenbluten); }
			else if (auswahl == 34) { formTextHolder.append(notruf); }
			else if (auswahl == 35) { formTextHolder.append(wiederbelebung); } // Reanimation
			else if (auswahl == 36) { formTextHolder.append(wirbelsaeule); } // R�ckenverletzung
			else if (auswahl == 37) { formTextHolder.append(schaedelbruch); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 38) { formTextHolder.append(schlaganfall); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 39) { formTextHolder.append(schlangenbiss); }
			else if (auswahl == 40) { formTextHolder.append(schock); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 41) { formTextHolder.append(sonnenbrand); }
			else if (auswahl == 42) { formTextHolder.append(sonnenstich); formTextHolder.append(atemstillstand); }
			else if (auswahl == 43) { formTextHolder.append(sos); }
			else if (auswahl == 44) { formTextHolder.append(stabileseitenlage); }
			else if (auswahl == 45) { formTextHolder.append(tierbiss); }
			else if (auswahl == 46) { formTextHolder.append(hitzschlag); } // �berhitzung
			else if (auswahl == 47) { formTextHolder.append(diabetkoma); } // �berzuckerung
			else if (auswahl == 48) { formTextHolder.append(verkehrsunfall); } // Unfallstelle Sichern
			else if (auswahl == 49) { formTextHolder.append(unterkuehlung); formTextHolder.append(bwlosMitAtmung); formTextHolder.append(bwlosOhneAtmung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 50) { formTextHolder.append(unterzuckerung); formTextHolder.append(atemstillstand); }
			else if (auswahl == 51) { formTextHolder.append(veraetzung); }
			else if (auswahl == 52) { formTextHolder.append(verbrennungLeicht); }
			else if (auswahl == 53) { formTextHolder.append(verbrennungSchwer); }
			else if (auswahl == 54) { formTextHolder.append(vergiftung); formTextHolder.append(wiederbelebung); }
			else if (auswahl == 55) { formTextHolder.append(verkehrsunfall); }
			else if (auswahl == 56) { formTextHolder.append(ersticken);} // Verschlucken
			else if (auswahl == 57) { formTextHolder.append(verstauchung); }
			else if (auswahl == 58) { formTextHolder.append(wiederbelebung); } // Wiederbelebung
			else if (auswahl == 59) { formTextHolder.append(wirbelsaeule); } // Wirbels�ulen-Verletzung
		}

		public void pauseApp() {
			//display = null;
			//menu = null;
		}

		public void destroyApp(boolean unconditional) {
			notifyDestroyed();
		}

		public void commandAction(Command c, Displayable d) {
			// String label = c.getLabel();
			if(c.getCommandType() == Command.BACK) {
				display.setCurrent(menu);
			}
			else if (c.getCommandType() == Command.EXIT) {
				notifyDestroyed();
			}
			// Country Emergency Menu
			else if (display.getCurrent().getTitle() == telEmergency.getTitle()) {
				formTextHolder.deleteAll();
				if (telEmergency.getSelectedIndex() == 0) { formTextHolder.append(stringAfrica); } 
				else if (telEmergency.getSelectedIndex() == 1) { formTextHolder.append(stringAsia); }
				else if (telEmergency.getSelectedIndex() == 2) { formTextHolder.append(stringEurope); }
				else if (telEmergency.getSelectedIndex() == 3) { formTextHolder.append(stringNorthamerica); }
				else if (telEmergency.getSelectedIndex() == 4) { formTextHolder.append(stringOceania); }
				else if (telEmergency.getSelectedIndex() == 5) { formTextHolder.append(stringSouthamerica); }
				display.setCurrent(formTextHolder);
			}
			// Main Menu
			else if (display.getCurrent().getTitle() == menu.getTitle()) {
				if (menu.getSelectedIndex() == 1) { 
					display = Display.getDisplay(this);
					display.setCurrent(telEmergency);
				}
				// catch divider
				else if (menu.getSelectedIndex() == 60) { }
				else {
					// apply text to form and show it
					applyText(menu.getSelectedIndex());
					display = Display.getDisplay(this);
					display.setCurrent(formTextHolder);
				}
			}
		}
	}


//	 load data here!? ... record store -- http://www.areamobile.de/specials/J2ME2/teil_II.php
//	 dort auch Fehler-Nennung 'Aufgrund von Problemen bei einigen Handys beim Aktualisieren von Record Stores...'

