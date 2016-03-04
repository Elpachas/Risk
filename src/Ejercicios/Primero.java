package Ejercicios;

import java.util.Scanner;

public class Primero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1-km-m");
		System.out.println("2-menor");
		System.out.println("3-milla-km");
		System.out.println("4-descuento");
		System.out.println("5-Primera letra ");
		System.out.println("Que eliges?");
		
		Scanner lector = new Scanner(System.in);
		byte opcion =lector.nextByte();
		switch (opcion){
		  case 1: 
				System.out.println("Que valor en km quieres convertir en metros?");
				int valor1=lector.nextInt();
				int resultat = convertir(valor1);
				System.out.println("El resultado es: "+ resultat +" metros");
              break;
		  case 2: 
			  System.out.println("Valor menor");
			  System.out.println("primer numero:");
				int num1=lector.nextInt();
			  System.out.println("segundo numero:");
				int num2=lector.nextInt();
				int resultado = menor(num1,num2);
				System.out.println("El numero: "+ resultado +" es menor");
              break;
		  case 3: 
			  System.out.println("Dime un valor en millas ");
				int milla=lector.nextInt();
				double resultado2 = convertirmilla(milla);
				System.out.println("El resultado es: "+ resultado2 +" km");
            break;
		  case 4:
			  System.out.println("precio real:");
			  int real=lector.nextInt();
			  System.out.println("precio pagado:");
			  int pagado=lector.nextInt();
			  int resultado3=porcentaje(real,pagado);
			  System.out.println("El descuento es del "+ resultado3 +"% ");
			  break;
		  case 5:
			  System.out.println("Dime una palabra");
			  String letra=lector.next();
			  char resultado4=primera(letra);
			  System.out.println("la primera letra es "+ resultado4 );
			  break;
		}
	}
	//caso1
	
	public static int convertir(int a)
	{
		int solucion=a*1000;
		return solucion;
	}
	//Caso2
	public static int menor(int a,int b)
	{
		if (a>b){
			int solucion=b;
			return solucion;
		}else{
			int solucion=a;
			return solucion;
		}
	}
	//caso3
	public static double convertirmilla(int milla)
	{
		double solucion=milla*1.852;
		return solucion;
	}
	//caso4
	public static int porcentaje(int cantidad,int total)
	{
		int solucion=(total*100)/cantidad;
		return solucion;
	}
	//caso5
	public static char primera(String unico)
	{
		  char [] CharArray=unico.toCharArray();
		  char prim=CharArray[0];
		return prim;
	}
}
