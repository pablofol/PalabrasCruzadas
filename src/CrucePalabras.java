import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class CrucePalabras {
	
	

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
		System.out.println();
		System.out.println(recorrer(tabla,0,0,tamano,tabla[0][0]));
			
		
		}//fin for casos
	}//fin main
	
	
	
		
		boolean existeSolucion=false;
		int n=1;

		private static String recorrer(String[][] tabla, int i, int j, int tamano, String d){		//función backtracking
			//comprueba si es solución
		   				
			//marcar camino
			
			//imprimir(laberinto);

			if(i-1>=0 && i-1<tamano && tabla[i-1][j].charAt(0)>d.charAt(d.length()-1)){
				
				d=d+(recorrer(tabla, i-1, j, tamano,d));
			}

			if(i-1>=0 && i-1<tamano && tabla[i][j+1].charAt(0)>d.charAt(d.length()-1)){
				
				d=d+(recorrer(tabla, i-1, j, tamano,d));
			}

			if(i-1>=0 && i-1<tamano && tabla[i+1][j].charAt(0)>d.charAt(d.length()-1)){
				
				d=d+(recorrer(tabla, i-1, j, tamano,d));
			}

			if(i-1>=0 && i-1<tamano && tabla[i][j-1].charAt(0)>d.charAt(d.length()-1)){
				
				d=d+(recorrer(tabla, i-1, j, tamano,d));
			}
			return d;

			//desmarcar camino
		}	
		
	
}//fin clase

