import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Palabras {
	
	private static String[] P = new String[5000];
	private static int n = 0;
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		int casos = Integer.parseInt(br.readLine());
		int[] tamano = new int[casos];
		ArrayList<char[][]> ArrayTablas = new ArrayList<char[][]>();
		char[][] tabla;
		char[][] tablaprueba={{'u','n','o'},{'d','o','s'},{'v','e','s'}};
		
		for(int i=0;i<casos;i++){
			br.readLine();
			tamano[i]=Integer.parseInt(br.readLine());
			tabla=new char[tamano[i]][tamano[i]];
			String texto="";
			for(int j=0;j<tamano[i];j++){
			texto=texto+br.readLine();
			}		
				
			int cont=0;
			for(int j=0;j<tamano[i];j++){
				for(int k=0;k<tamano[i];k++){
					tabla[j][k]=texto.charAt(cont);
					cont++;
				}	
			}
			ArrayTablas.add(tabla);
			

		}//fin for casos
		
		
		System.out.print("deo");
		for(int i=0;i<casos;i++){
			char[][] tablaenv = ArrayTablas.get(i);
			
			
			for(int j=0;j<tamano[i];j++){
				for(int k=0;k<tamano[i];k++){
					
					calcular(tablaenv,j,k,"",tamano[i]);
				}
				
			}
			ordenar();
			System.out.println();
		}
		
	}//fin main

	
	
	private static void calcular(char[][] tabla,int i, int j, String d, int tamano){		//función backtracking
		
		
		
		d=d+tabla[i][j]; 


		if(i-1>=0 && i-1<tamano && tabla[i-1][j]>d.charAt(d.length()-1)){
			
			calcular(tabla,i-1, j,d,tamano);
		}
		
		if(i-1>=0 && i-1<tamano && j+1>=0 && j+1<tamano && tabla[i-1][j+1]>d.charAt(d.length()-1)){
						
			calcular(tabla,i-1, j+1,d,tamano);
		}
		
		if(j+1>=0 && j+1<tamano && tabla[i][j+1]>d.charAt(d.length()-1)){
					
			calcular(tabla,i, j+1,d,tamano);
			
		}

		if(i+1>=0 && i+1<tamano && j+1>=0 && j+1<tamano && tabla[i+1][j+1]>d.charAt(d.length()-1)){
						
			calcular(tabla,i+1, j+1,d,tamano);
			
		}
		
		if(i+1>=0 && i+1<tamano && tabla[i+1][j]>d.charAt(d.length()-1)){
						
			calcular(tabla,i+1, j,d,tamano);
			
		}
		
		if(i+1>=0 && i+1<tamano && j-1>=0 && j-1<tamano && tabla[i+1][j-1]>d.charAt(d.length()-1)){
						
			calcular(tabla,i+1, j-1,d,tamano);
			
		}
		
		if(j-1>=0 && j-1<tamano && tabla[i][j-1]>d.charAt(d.length()-1)){
					
			calcular(tabla,i, j-1,d,tamano);
			
		}

		if(i-1>=0 && i-1<tamano && j-1>=0 && j-1<tamano && tabla[i-1][j-1]>d.charAt(d.length()-1)){
						
			calcular(tabla,i-1, j-1,d,tamano);
			
		}
		
		else if(d.length()>2){
			
			//System.out.println("d:"+d+"   n:"+n);
			P[n]=d;
			n++;
			
			
			return;
		}
		
		d="";
		
	}//fin calcular
	
	private static void ordenar (){
		
		
		List<String> lista = Arrays.asList(P);
		List<String> listasinduplicados = new ArrayList<String>();
		Set<String> set = new LinkedHashSet<String>(lista);
		listasinduplicados.addAll(set);
		int tam=(listasinduplicados.size())-1;
		for(int l=0;l<=n;l++){
			P[l]=null;
		}
		n=0;
		
		
		
		String[] ListaS= new String[tam];  
		ListaS= listasinduplicados.toArray(new String[listasinduplicados.size()]);
		
		
		
				
			for (int r = 0; r < tam; r++){
				for(int l=r+1;l<tam;l++){
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
			
			
			for (int r = 0; r < tam; r++){
				System.out.println();
				System.out.print(ListaS[r]);
			}
		
			
	}//Fin ordenar
}//Fin clase

	
