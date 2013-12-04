import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;





public class CrucePalabras {
	static final int MAX = 500;						//máximo tamaño del tablero
	
	
	static class Estado{
	    int x , y;								// Fila, columna y distancia
		String d;
	    
	    public Estado( int x1, int y1 , String d1){
	        this.x = x1;
	        this.y = y1;
	        this.d = d1;
	    }
	}

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		int casos = Integer.parseInt(br.readLine());
		
		
		for (int i=0;i<casos;i++){
		br.readLine();	
		int tamano = Integer.parseInt(br.readLine());
		String texto="";
		String tabla[][] = new String[tamano][tamano];
		
			for (int a=0;a<tamano;a++){
					texto = texto+ br.readLine()+" ";
			}
		String[] palabra= texto.split(" ");
			
		
			for(int j=0;j<tamano;j++){
				//System.out.println("palabra "+j+": "+palabra[j]);
				String[] elemento = palabra[j].split("");
				for(int k=0;k<tamano;k++){
					tabla[j][k]=elemento[k+1];
					
				}
			}
		
		System.out.println("tabla: ");
			for(int j=0;j<tamano;j++){
				System.out.print("\n");
			
				for(int k=0;k<tamano;k++){
					System.out.print(" "+tabla[j][k]);
				}
			}
		
		System.out.println(resultado(tabla,tamano));
			
		
		}//fin for casos
	}//fin main
	
	
	private static String resultado (String[][] tabla, int tamano){
		
			boolean visitado[][] = new boolean[ MAX ][ MAX ];	//array de estados visitados
			int x=0,y=0;
			Queue<Estado> Q = new LinkedList<Estado>();			//Cola de todos los posibles Estados por los que se pase para llegar al destino
			Q.add( new Estado( x , y , "" ) );					//Insertamos el estado inicial en la Cola con distnacia 0.
			
			int dx[  ] = { 0 , 1 , 1 , 1 , 0 , -1, -1, -1};	//incremento en coordenada x
			int dy[  ] = { 1 , 1 , 0 ,-1 ,-1 , -1 , 0 , 1};		//incremento en coordenada y
			
			int nx , ny;
			
			
			while( !Q.isEmpty() ){							//Mientras cola no este vacia
				Estado actual = Q.remove();					//Obtengo de la cola el estado actual, en un comienzo será el inicial
				String d=actual.d;
				//Si llega al destino
				visitado[ actual.x ][ actual.y ] = true;	//Marco como visitado dicho estado para no volver a recorrerlo
				
				for( int i = 0 ; i < 8 ; i++ ){				//Recorremos hasta 8 porque tenemos 8 posibles adyacentes
					nx = dx[ i ] + actual.x;				//nx y ny tendran la coordenada adyacente
					ny = dy[ i ] + actual.y;				//ejemplo en i=0 y actual (3,4) -> 3+dx[0]=3+1=4, 4+dy[0]=4+2=6, nueva coordenada (4,6)
			        										//aqui comprobamos que la coordenada adyacente no sobrepase las dimensiones del tablero
			        										//ademas comprobamos que no este visitado
					if( nx >= 0 && nx < tamano && ny >= 0 && ny < tamano && !visitado[ nx ][ ny ] && 0<actual.d.compareTo(d)){
						Q.add( new Estado( nx , ny , d+actual.d ) ); //agregamos estado adyacente aumento en 1 la distancia recorrida
						d=d+actual.d;
					}
					else System.out.print(d);
					
				}
				return d;
			}
			
			return null;
		
		
/*
		public static void main(String[] args) throws IOException {
			
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
			String texto="";
			texto = br.readLine();				//Leemos entrada
			String[] entrada= texto.split(" ");
			int tamano=Integer.parseInt(entrada[0]);		//Tamaño Tablero		
			int salx=Integer.parseInt(entrada[1]);			//Coordenada X inicial
			int saly=Integer.parseInt(entrada[2]);			//Coordenada Y inicial
			int llex=Integer.parseInt(entrada[3]);			//Coordenada X final
			int lley=Integer.parseInt(entrada[4]);			//Coordenada Y final

			
			
			int min = BFS( salx , saly , tamano , llex, lley );			//Llamada al metodo BFS
			if( min == -1 ) System.out.print("0 -1");				//No hay solución posible
			else System.out.println( min );		//Imprime resultado
			
		}
*/
		
		
		
		
		
	}
}//fin clase

