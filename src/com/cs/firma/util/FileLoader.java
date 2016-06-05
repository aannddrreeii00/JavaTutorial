package com.cs.firma.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
	
	public static ArrayList<String[]> loadFile(String filePath) throws FileNotFoundException{
		File newFile= new File (filePath);
		Scanner sc= new Scanner (newFile);
		ArrayList <String[]> linesList= new ArrayList();
		sc.nextLine();
		while (sc.hasNextLine()){
			String line= sc.nextLine();
	//		System.out.println(line);
			String[] parsedLine = line.split(";");
			linesList.add(parsedLine);
		}
		sc.close();
		return linesList;
	}

}
