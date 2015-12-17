package com.company;


import java.io.*;
import java.util.Scanner;

class Sala {
    public int idSala;                  //coluna1
    public String nomeSala;             //coluna2
    public int filas;                   //coluna3
    public int lugares;                 //coluna4
    public String nomeEspetaculo;       //coluna5
    public int precoBilhete;            //coluna6
}
class Reserva {
    public int idSala;                  //coluna1
    public String nomeEspetaculo;       //coluna2
    public String condicao;             //coluna3
    public int fila;                    //coluna4
    public int lugar;                   //coluna5
    public int dia;                     //coluna6
    public int mes;                     //coluna7
    public String sessao;               //coluna8
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

        // separa o conteudo da variavel scanner em arrays diferentes.
        for( i = 0;  scanner.hasNextLine();  i++ )
        {
            salas[i] = new Sala();
            salas[i].idSala = scanner.nextInt();
            salas[i].nomeSala = scanner.next();
            salas[i].filas = scanner.nextInt();
            salas[i].lugares = scanner.nextInt();
            salas[i].nomeEspetaculo = scanner.next();
            salas[i].precoBilhete = scanner.nextInt();
            scanner.skip( "\\s*" );
            num_salas++;
        }

        //output para ecra de todos os dados
        String linhaCompleta= "";
        for( i = 0;  i < num_salas;  i++ )
        {
            System.out.print  ( "L" + i + ":\t") ;
            System.out.print  ( "C1:" + salas[i].idSala +       "\t");
            System.out.print  ( "C2:" +salas[i].nomeSala +      "\t");
            System.out.print  ( "C3:" +salas[i].filas +         "\t");
            System.out.print  ( "C4:" +salas[i].lugares +       "\t");
            System.out.print  ( "C5:" +salas[i].nomeEspetaculo+ "\t");
            System.out.println( "C6:" +salas[i].precoBilhete +  "\t");

            // / linhaCompleta = linhaCompleta + "* ID: " + salas[i].idSala + " " ;

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

