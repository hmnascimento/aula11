package com.company;


import java.io.*;
import java.util.Scanner;

class Sala {
    public int salaId;                  //coluna1
    public String salaNome;             //coluna2
    public int salaNrFilas;             //coluna3
    public int salaNrLugares;           //coluna4
    public String salaNomeEspetaculo;   //coluna5
    public int salaPrecoBilhete;        //coluna6
}

public class Main {

    public static void main(String[] args) {
        //declara variaveis
        Scanner scanner;
        Sala[] salas = new Sala[ 100 ];
        int num_salas = 0;
        int i;

        //le os dados do ficheiro salas.txt. guarda na variavel scanner.
        try	{
            scanner = new Scanner( new File("salas.txt") ).useDelimiter( "\\s*:\\s*|\\s*\n\\s*" );
        }
        catch( FileNotFoundException ex )
        {
            System.out.println( ex );
            return;
        }




        scanner.skip( "\\s*" );

        // separa o conteudo da var scanner em arrays diferentes.
        for( i = 0;  scanner.hasNextLine();  i++ )
        {
            salas[i] = new Sala();
            salas[i].salaId = scanner.nextInt();
            salas[i].salaNome = scanner.next();
            salas[i].salaNrFilas = scanner.nextInt();
            scanner.skip( "\\s*" );
            num_salas++;
        }

        String linhaCompleta= "";
        for( i = 0;  i < num_salas;  i++ )
        {
            System.out.print  (   "ID: "          + salas[i].salaId);
            System.out.print  ( "  Nome: "        + salas[i].salaNome);
            System.out.println( "  Experiencia: " + salas[i].salaNrFilas);
            linhaCompleta = linhaCompleta + "* ID: " + salas[i].salaId + " " ;
        }


        System.out.println(linhaCompleta);

        // escreve o ficheiro output.txt  . from: aula11
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("output.txt"), "utf-8"));
            writer.write(linhaCompleta);
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }


    }

}

