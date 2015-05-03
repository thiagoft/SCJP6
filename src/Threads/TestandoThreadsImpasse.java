package Threads;

public class TestandoThreadsImpasse {
	private static class Resource {
		public int value;
	}
	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();
	
	public int read() {
		synchronized(resourceA) { //1
			synchronized(resourceB) {
				return resourceB.value+resourceA.value;
			}
		}
	}
	
	public void write(int a, int b) {
		synchronized(resourceB) { //2
			synchronized(resourceA) {
				resourceA.value = a;
				resourceB.value = a;
			}
		}
	}
	
	//1 e 2 podem causar dead lockpelo fato de 1 ficar esperando o termino de e vice versa
	//trocar a ordem de 2 B por A resolveria o problema ou 1 A por B
}
