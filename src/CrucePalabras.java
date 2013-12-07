import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;






public class CrucePalabras {
	
	private static String[] P = new String[5000];
	//private static boolean existeSolucion = false;
	private static int n = 0;
	private static int tamano;
	

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		int casos = Integer.parseInt(br.readLine());
		 
		
		
		for (int i=0;i<casos;i++){
		br.readLine();	
		
		tamano = Integer.parseInt(br.readLine());
		String texto="";
		String[][] tabla = new String[tamano][tamano];
		
			for (int a=0;a<tamano;a++){
					texto = texto+ br.readLine()+" ";
			}
		String[] palabra= texto.split(" ");
			
		
			for(int j=0;j<tamano;j++){
				
				String[] elemento = palabra[j].split("");
				for(int k=0;k<tamano;k++){
					tabla[j][k]=elemento[k+1];
					
				}
			}
			for (int r = 0; r < tamano; r++){
				for (int j = 0; j < tamano; j++){
		
					recorrer(tabla,r,j,"");
				}
			}
		}
		
		
			
			
		
		
					
		
			
		
		
	}//fin main
	
	

			
		private static void recorrer(String[][] tabla,int i, int j, String d){		//función backtracking
			//comprueba si es solución
			  
			
			d=d+tabla[i][j]; //marcar camino

			//imprimir(laberinto);

			if(i-1>=0 && i-1<tamano && tabla[i-1][j].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i-1, j,d);
			}
			
			if(i-1>=0 && i-1<tamano && j+1>=0 && j+1<tamano && tabla[i-1][j+1].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i-1, j+1,d);
			}
			

			if(j+1>=0 && j+1<tamano && tabla[i][j+1].charAt(0)>d.charAt(d.length()-1)){
				
				
				
				recorrer(tabla,i, j+1,d);
			}

			if(i+1>=0 && i+1<tamano && j+1>=0 && j+1<tamano && tabla[i+1][j+1].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i+1, j+1,d);
			}
			
			if(i+1>=0 && i+1<tamano && tabla[i+1][j].charAt(0)>d.charAt(d.length()-1)){
				
				
				
				recorrer(tabla,i+1, j,d);
			}
			
			if(i+1>=0 && i+1<tamano && j-1>=0 && j-1<tamano && tabla[i+1][j-1].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i+1, j-1,d);
			}
			
			if(j-1>=0 && j-1<tamano && tabla[i][j-1].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i, j-1,d);
			}

			if(i-1>=0 && i-1<tamano && j-1>=0 && j-1<tamano && tabla[i-1][j-1].charAt(0)>d.charAt(d.length()-1)){
				
				
				recorrer(tabla,i-1, j-1,d);
			}
			
			else if(d.length()>2){
				
				//System.out.println("d:"+d+"   n:"+n);
				P[n]=d;
				n++;
				
				
				return;
			}
			
			
			d="";
			
			List<String> lista = Arrays.asList(P);
			List<String> listasinduplicados = new ArrayList<String>();
			Set<String> set = new LinkedHashSet<String>(lista);
			listasinduplicados.addAll(set);
			n=(listasinduplicados.size())-1;
			
			
			
			
			String[] ListaS= new String[n];  
			ListaS= listasinduplicados.toArray(new String[listasinduplicados.size()]);
			
			
			
					
				for (int r = 0; r < n; r++){
					for(int l=r+1;l<n;l++){
						if(ListaS[r].compareTo(ListaS[l])>0){
							String temp=ListaS[l];
							ListaS[l]=ListaS[r];
							ListaS[r]=temp;
						}
						if(ListaS[r].length()>ListaS[l].length()){
							String temp=ListaS[l];
							ListaS[l]=ListaS[r];
							ListaS[r]=temp;
						
							
						}
					}
					
				}
				
				for (int r = 0; r < n; r++){
					System.out.println(ListaS[r]);
				}
			
			
		}	
		
	
}//fin clase

