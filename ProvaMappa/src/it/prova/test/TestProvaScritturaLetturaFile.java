package it.prova.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TestProvaScritturaLetturaFile {
	public static void main(String[] args) {
	
		
		String path = "C:\\ws_corso_java/prova.txt" ;
		
		try {
			File file = new File(path);
			char[] in = new char[500];
			int size = 0;
			
			if(file.exists()) {
				System.out.println("Il file " + path + " esiste");
			} else if(file.createNewFile()) {
				System.out.println("Il file " + path + " è stato creato");
			} else {
				System.out.println("Il file " + path + " non può essere creato");
			}
			
			// Esempio FileWriter
			FileWriter fw = new FileWriter(file);
//			fw.write("Questo è il nostro primo file");
//			fw.flush();
//			fw.close();
			
			// Esempio BufferedWriter
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Questo è il nostro primo file.\nCiao mondo!");
			bw.flush();
			bw.close();
			
			// Esempio FileReader
			FileReader fr = new FileReader(file);
//			size = fr.read(in);
//			System.out.print("Caratteri presenti: " + size + "\n");
//			System.out.print("Il contenuto del file è il seguente:\n");
//			for(int i=0; i<size; i++)
//			System.out.print(in[i]);
//			fr.close();
			
			//Esempio BufferedReader
			BufferedReader br = new BufferedReader(fr);
			size = br.read(in);
			System.out.print("Caratteri presenti: " + size + "\n");
			System.out.print("Il contenuto del file è il seguente:\n");
			for(int i=0; i<size; i++)
			System.out.print(in[i]);
			br.close();
			
		
			
		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	}
	}
