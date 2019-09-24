import java.net.*;
import java.io.*;
class temp
{
    private int[] n;
    public temp(int l)
    {
	this.n=new int[l];
    }
    public int[] getArray(){
	return (n);
    }
    public int get(int i)
    {
	return n[i];
    }
    public void set(int index,int value)
    {
	this.n[index]=value;
    }
}
class fiboRun implements Runnable
{
    // private int[] n;
    private int length;
    private temp t;
    public fiboRun(int number,temp t1)
    {
	this.length=number;
	this.t=t1;
    }
    public void run()
    {
	t.set(0,0);
	t.set(1,1);
	for(int i=2;i<length;i++)
	    {
		t.set(i,t.get(i-1)+t.get(i-2));
	    }
    }    
}

public class fibonacci
{
    public static void main(String[] args)
    {
	System.out.print("Enter the number of Fibbonacci series length: ");
	//Scanner sc=new Scanner(System.in);
	//String str=sc.nextLine();
	int n=Integer.parseInt(args[0]);
	temp t=new temp(n);
	Thread worker= new Thread(new fiboRun(n,t));
	worker.start();
	try{
	    worker.join();
	}
	catch(InterruptedException ie){}
	int[] data=t.getArray();
	System.out.println("Fibonacci series is: ");
	for(int i=0;i<n;i++)
	    {
		System.out.println(""+data[i]+" ");
	    }
	/*
	int[] n;
	n=returnArray();
	System.out.println(n[5]);*/
	
    }
}
