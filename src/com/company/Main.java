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
        Scanner scannerReservas;
        Sala[] salas = new Sala[ 100 ];
        Reserva[] reservas = new Reserva[ 200 ];
        int num_salas = 0;
        int num_reservas = 0;
        int i;
        String output= "";



        /**
         *********************************************
         ************ salas.txt **********************
         *********************************************
         */

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

        //output de salas.txt para ecra
        for( i = 0;  i < num_salas;  i++ )
        {
            System.out.print  ( "L" + i + ":\t") ;
            System.out.print  ( "C1:" + salas[i].idSala +       "\t");
            System.out.print  ( "C2:" +salas[i].nomeSala +      "\t");
            System.out.print  ( "C3:" +salas[i].filas +         "\t");
            System.out.print  ( "C4:" +salas[i].lugares +       "\t");
            System.out.print  ( "C5:" +salas[i].nomeEspetaculo+ "\t");
            System.out.println( "C6:" +salas[i].precoBilhete +  "\t");


        }

        //usamos isto para gerar a variavel que vai para o ficheiro
        // / output = output+ "* ID: " + salas[i].idSala + " " ;

        System.out.println("fim de salas.txt. agora começa o reservas.txt");

        /**
         *********************************************
         ************ reservas.txt *******************
         *********************************************
         */


        //le os dados do ficheiro reservas.txt. guarda na variavel scanner_reservas.
        try	{
            scannerReservas = new Scanner( new File("reservas.txt") ).useDelimiter( "\\s*:\\s*|\\s*\n\\s*" );
        }
        catch( FileNotFoundException ex )
        {
            System.out.println( ex );
            return;
        }

        scannerReservas.skip( "\\s*" );

        // separa o conteudo da variavel scanner em arrays diferentes.
        for( i = 0;  scannerReservas.hasNextLine();  i++ )
        {
            System.out.println("i:" + i);  // troubleshooting
            reservas[i] = new Reserva();
            reservas[i].idSala = scannerReservas.nextInt();
            reservas[i].nomeEspetaculo = scannerReservas.next();
            reservas[i].condicao = scannerReservas.next();
            reservas[i].fila = scannerReservas.nextInt();
            reservas[i].lugar = scannerReservas.nextInt();
            reservas[i].dia = scannerReservas.nextInt();
            reservas[i].mes = scannerReservas.nextInt();
            reservas[i].sessao = scannerReservas.next();
            scannerReservas.skip( "\\s*" );
            num_reservas++;
        }
        //troubleshooting
        System.out.println("nr reservas:" + num_reservas);

        //output de salas.txt para ecra
        for( i = 0;  i < num_reservas;  i++ )
        {
            System.out.print  ( "L" + i + ":\t") ;
            System.out.print  ( "C1:" + reservas[i].idSala          + "\t");
            System.out.print  ( "C2:" + reservas[i].nomeEspetaculo  + "\t");
            System.out.print  ( "C3:" + reservas[i].condicao        + "\t");
            System.out.print  ( "C4:" + reservas[i].fila            + "\t");
            System.out.print  ( "C5:" + reservas[i].lugar           + "\t");
            System.out.print  ( "C6:" + reservas[i].dia             + "\t");
            System.out.print  ( "C7:" + reservas[i].mes             + "\t");
            System.out.println( "C8:" + reservas[i].sessao          + "\t");
        }

        //usamos isto para gerar a variavel que vai para o ficheiro
        // / output = output+ "* ID: " + salas[i].idSala + " " ;

        /**
         *********************************************
         ************ output.txt *********************
         *********************************************
         */
        System.out.println(output);

        // escreve o ficheiro output.txt  . from: aula11
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("output.txt"), "utf-8"));
            writer.write(output);
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}

