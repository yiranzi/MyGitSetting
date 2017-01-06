package hello;
/*
真是写烦了.为什么这么简单的题我要浪费这么多时间写写写呢.以后得记录一下每一份代码.或者每一次改动说花的时间.要不这根本做不完好不好.

这份作业里面对效率的优化有很大的空间.有空的话可以计算一下他的运行速度.(N?)
*/
import java.util.Scanner;
class WorkPrime {
	boolean bIsPrime =true;
	int iOri = 0;
	boolean ZhengChu(int number)
	{
		boolean bWanshu = false;
		int iMax = (number);	
		int[] aSave = new int[iMax];
		int iCount = 0;
		for( int i = 1;i<=iMax;i++)
		{
			
			if(number%i == 0 && number!=i)
			{
				aSave[iCount]=i;
				iCount++;
				bWanshu = true;
				//System.out.println(i);
			}					
		}
		if(bWanshu == true)
		{
			for(int i=0;i<aSave.length;i++)
			{
				number-=aSave[i];
			}
		}
		if(number ==0)
		{
			bWanshu  = true;
		}
		else bWanshu = false;
		return bWanshu;

	}
	int ReturnPrime(int number)
	{
		int iPrime = number;
		int iMax = (int) Math.ceil(Math.sqrt(number));		
		for( int i = 2;i<=iMax;i++)
		{
			if(number%i == 0 && number!=i)
			{
				bIsPrime = false;
				iPrime = i;
				break;
			}					
		}
		return iPrime;		
	}

}
public class Main {

	public static void main(String[] args) {
		int iSwitch = 1;
		
		Scanner sGet = new Scanner(System.in);
		//
		WorkPrime Wanshu = new WorkPrime();
		int iMin = sGet.nextInt();
		int iMax = sGet.nextInt();
		int iCount = 0;
		int[] aAnswer = new int[iMax-iMin+1];
		for(int i=iMin;i<=iMax;i++)
		{
			if(Wanshu.ZhengChu(i))
			{
				aAnswer[iCount] = i;
				iCount++;
			}
			
		}
		String sAnswer = "";
		for(int i=0;i<aAnswer.length;i++)
		{
			if(aAnswer[i]!=0)
			{
				if(!sAnswer.equals(""))sAnswer+=" ";
				sAnswer +=aAnswer[i];
			}

		}
		if(sAnswer.equals(""))System.out.println("NIL");
		else System.out.println(sAnswer);
		//
	}

}
