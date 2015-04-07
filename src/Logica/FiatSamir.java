package Logica;
import java.math.BigInteger;
import java.util.Scanner;

public class FiatSamir {
	
	public static BigInteger operacionesA(BigInteger N, BigInteger s, BigInteger x, BigInteger e){
		
		BigInteger y = new BigInteger("0");
		BigInteger aux;
		
		if(e.equals(BigInteger.ZERO)){
			y = x.mod(N);
		}
		else{	//Si no es 0 es uno ya que solo aceptamos esos dos valores
			aux = x.multiply(s);
			y = aux.mod(N);
		}
		return y;
	}
	
	public static void comprobacion(BigInteger a, BigInteger b){
		
		if(a.equals(b))
			System.out.println("Iteraci�n v�lida");
		else{
			System.out.println("Iteraci�n inv�lida");
			System.exit(0);
		}
	}
	
	public static boolean EsPrimo(BigInteger a){
		
		BigInteger divisor = new BigInteger("2");
		boolean primo = true;
		if(a.intValue() == 2){
			primo = false;
		}
		
		while(primo && (divisor.intValue() < a.intValue())){
			if(a.mod(divisor).intValue() == 0){
				primo = false;
			}
			else 
				divisor = divisor.add(new BigInteger("1"));
		}
		return primo;
	}

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		BigInteger N, v, q, p;
		BigInteger aux; //variable utilizada para almacenar valores intermedios
		boolean pri;
		
		Scanner in = new Scanner(System.in);
		
		//Pedimos los datos por consola
		System.out.println("p: ");
		p = in.nextBigInteger();
		
		//Comprobamos si el numero es primo y si no lo es lo seguimos pidiendo hasta que lo sea
		pri = EsPrimo(p);
		while(!pri){
			System.out.println("p no era primo vuelva a introducirlo: ");
			p = in.nextBigInteger();
			pri = EsPrimo(p);
		}

		System.out.println("q: ");
		q = in.nextBigInteger();
		
		pri = EsPrimo(q);

		while(!pri){
			System.out.println("q no era primo vuelva a introducirlo: ");
			q= in.nextBigInteger();
			pri = EsPrimo(q);
		}
		
		N = p.multiply(q);
		
		System.out.println("s: ");
		BigInteger s = in.nextBigInteger();
		
		//Comprobamos que s est� entre 0 y N, si no lo est� lo pedimos hasta que se introduzca un n�mero v�lido
		while((s.intValue() <= 0) || (s.intValue() >= N.intValue())){
			System.out.println("Vuelva a introducir s y recuerde que 0 < s < N: ");
			s = in.nextBigInteger();
		}
		
		System.out.println("i (Iteraciones): ");
		int i = in.nextInt();
		
		aux = s.pow(2);
		v =  aux.mod(N);

		System.out.println("N = " + N);
		System.out.println("v = " + v);
		System.out.println("\n");

		for (int k = 0; k < i; k++){
			
			BigInteger e, x, y, a;
			BigInteger bi1, bi2; //almacenaremos los valores finales que deber�n tener el mismo valor
			
			System.out.println("e: ");
			e = in.nextBigInteger();
			
			while((!e.equals(BigInteger.ZERO)) && (!e.equals(BigInteger.ONE))){
				System.out.println("e tiene que tomar los valores 0 o 1. Vuelva a introducirlo: ");
				e = in.nextBigInteger();
			}
			
			System.out.println("x: ");
			x = in.nextBigInteger();

			while((x.intValue() < 0) || x.intValue() > N.intValue()){
				System.out.println("Vuelva a introducir x y recuerde que 0 < x < N: ");
				x = in.nextBigInteger();
			}
			
			aux = x.pow(2);
			a = aux.mod(N);
			y =  operacionesA(N, s, x , e);
			
			System.out. println("Iteraci�n " + (k + 1) + ": a = " + a + ", y = " + y);

			aux = y.pow(2);
			bi1 = aux.mod(N);
			
			aux = v.pow(e.intValue());
			aux = aux.multiply(a);
			bi2 = aux.mod(N);
			
			comprobacion(bi1, bi2);
		}
	}
}
