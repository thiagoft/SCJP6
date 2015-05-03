package Threads;

/*public class TestandoThreadExtendida {
	public static void main(String[] args) {
		ThreadTeste1 a = new ThreadTeste1();
		ThreadTeste2 b = new ThreadTeste2();
		b.start();
		a.start();
	}
}

class ThreadTeste1 extends Thread {
	public void run() {
		new TesteSinc().hello("teste1");
	}
}

class ThreadTeste2 extends Thread {
	public void run() {
		new TesteSinc().hello("teste2");
	}
}

class TesteSinc {
	public void hello(String msg) {
		synchronized(this) {
			System.out.println("Hello "+msg);
		}
	}
}*/

public class TestandoThreadExtendida {
	public static void main(String[] args) {
		TesteSinc tSinc = new TesteSinc();
		
		ThreadTeste1 a = new ThreadTeste1(tSinc);
		ThreadTeste2 b = new ThreadTeste2(tSinc);
		b.start();
		a.start();
	}
}

class ThreadTeste1 extends Thread {
	
	TesteSinc tsinc;
	
	public ThreadTeste1(TesteSinc tSinc) {
		this.tsinc = tSinc;
	}
	
	public void run() {
		this.tsinc.hello("teste1");
	}
}

class ThreadTeste2 extends Thread {
	
	TesteSinc tsinc;
	
	public ThreadTeste2(TesteSinc tSinc) {
		this.tsinc = tSinc;
	}
	
	public void run() {
		this.tsinc.hello("teste2");
	}
}

class TesteSinc {
	public void hello(String msg) {
		synchronized(this) {
			System.out.println("Hello "+msg);
		}
	}
}