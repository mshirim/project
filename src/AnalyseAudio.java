import java.io.File;
import java.nio.ByteBuffer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import com.sun.*;

import java.util.*;

public class AnalyseAudio
{	
	public static int NumOfDigits(int x)
	{
		int n = 0;
		while(x!=0)
		{
			x= x/10;
			n++;
		}
		return n;
	}
	public static int BiggestDigit(int x)
	{
		int n = 0;
		while(x > 0)
		{
			if(x<10)
				n = x;
			x= x/10;
		}
		return n;
	}
	/*public static void avg()
	{
		GraphingAudio g = new GraphingAudio();
		ArrayList<int[]> lst = g.getList(); 
		int [] arr;
		int sum = 0;
		 int avg;
		for(int i=0; i<lst.size() ; i++)
		{	
			arr= lst.get(i);
			for(int b=0; b<arr.length; b++)
			{
				sum = sum + arr[b];
			}
			avg = sum/arr.length;
			System.out.println(avg);
        }
	}*/
	public static boolean Similar(int a,int b)
	{
		if(a>900 && b>900)
		{	
			int aNum = NumOfDigits(a);
			int bNum = NumOfDigits(b);
			if(aNum == bNum)
			{
				int a1 = BiggestDigit(a);
				int b1 = BiggestDigit(b);
				if((a1 == b1 || a1 == (b1+1) || a1 == (b1-1)))
				{
					return true;
				}
				return false;
			}
			else if(aNum == (bNum+1))
			{
				if((aNum == 1) && (bNum ==9))
					return true;
				return false;
			}
			else if(aNum == (bNum-1))
			{
				if((aNum == 9) && (bNum ==1))
					return true;
				return false;
			}
			return false;	
		}
		return false;
	}
	public static void clapCheck()
	{
		AudioCapture g = new AudioCapture();
		ArrayList<int[]> lst = g.getList(); 
		int [] preArr;
		int [] arr;
		int a,b,c,d,e,f;
		int a2,b2,c2,d2,e2,f2;
		int a3,b3,c3,d3,e3,f3;
		int a4,b4,c4,d4,e4,f4;
		int a5,b5,c5,d5,e5,f5;
		int a6,b6,c6,d6,e6,f6;
		int [] arr2;
		int [] arr3;
		int [] arr4;
		int [] arr5;
		int [] arr6;
		for(int i=0; i<lst.size() ; i++)
		{	
			arr= lst.get(i);
			a= (arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5])/6;
			b= (arr[200]+arr[201]+arr[202]+arr[203]+arr[204]+arr[205])/6;
			c= (arr[400]+arr[401]+arr[402]+arr[403]+arr[404]+arr[405])/6;
			d= (arr[600]+arr[601]+arr[602]+arr[603]+arr[604]+arr[605])/6;
			e= (arr[800]+arr[801]+arr[802]+arr[803]+arr[804]+arr[805])/6;
			f= (arr[1000]+arr[1001]+arr[1002]+arr[1003]+arr[1004]+arr[1005])/6;
			//System.out.println(a+ "\n"+b+ "\n"+c+ "\n"+d+ "\n"+e+ "\n"+f);
			if(a>700 && b>700 && c>700 && d>700 && e>700 && f>700)
			{
				arr2= lst.get(i+1);
				a2= (arr2[0]+arr2[1]+arr2[2]+arr2[3]+arr2[4]+arr2[5])/6;
				b2= (arr2[200]+arr2[201]+arr2[202]+arr2[203]+arr2[204]+arr2[205])/6;
				c2= (arr2[400]+arr2[401]+arr2[402]+arr2[403]+arr2[404]+arr2[405])/6;
				d2= (arr2[600]+arr2[601]+arr2[602]+arr2[603]+arr2[604]+arr2[605])/6;
				e2= (arr2[800]+arr2[801]+arr2[802]+arr2[803]+arr2[804]+arr2[805])/6;
				f2= (arr2[1000]+arr2[1001]+arr2[1002]+arr2[1003]+arr2[1004]+arr2[1005])/6;
				//System.out.println(a2+ " "+b2+ " "+c2+ " "+d2+ " "+e2+ " "+f2);
				if(a2>700 && b2>700 && c2>700 && d2>700 && e2>700 && f2>700)
				{
					arr3= lst.get(i+2);
					a3= (arr3[0]+arr3[1]+arr3[2]+arr3[3]+arr3[4]+arr3[5])/6;
					b3= (arr3[200]+arr3[201]+arr3[202]+arr3[203]+arr3[204]+arr3[205])/6;
					c3= (arr3[400]+arr3[401]+arr3[402]+arr3[403]+arr3[404]+arr3[405])/6;
					d3= (arr3[600]+arr3[601]+arr3[602]+arr3[603]+arr3[604]+arr3[605])/6;
					e3= (arr3[800]+arr3[801]+arr3[802]+arr3[803]+arr3[804]+arr3[805])/6;
					f3= (arr3[1000]+arr3[1001]+arr3[1002]+arr3[1003]+arr3[1004]+arr3[1005])/6;
					if(a3>700 && b3>700 && c3>700 && d3>700 && e3>700 && f3>700)
					{
						arr4= lst.get(i+3);
						a4= (arr4[0]+arr4[1]+arr4[2]+arr4[3]+arr4[4]+arr4[5])/6;
						b4= (arr4[200]+arr4[201]+arr4[202]+arr4[203]+arr4[204]+arr4[205])/6;
						c4= (arr4[400]+arr4[401]+arr4[402]+arr4[403]+arr4[404]+arr4[405])/6;
						d4= (arr4[600]+arr4[601]+arr4[602]+arr4[603]+arr4[604]+arr4[605])/6;
						e4= (arr4[800]+arr4[801]+arr4[802]+arr4[803]+arr4[804]+arr4[805])/6;
						f4= (arr4[1000]+arr4[1001]+arr4[1002]+arr4[1003]+arr4[1004]+arr4[1005])/6;
						if(a4>700 && b4>700 && c4>700 &&d4>700 && e4>700 && f4>700)
						{
							arr5= lst.get(i+4);
							a5= (arr5[0]+arr5[1]+arr5[2]+arr5[3]+arr5[4]+arr5[5])/6;
							b5= (arr5[200]+arr5[201]+arr5[202]+arr5[203]+arr5[204]+arr5[205])/6;
							c5= (arr5[400]+arr5[401]+arr5[402]+arr5[403]+arr5[404]+arr5[405])/6;
							d5= (arr5[600]+arr5[601]+arr5[602]+arr5[603]+arr5[604]+arr5[605])/6;
							e5= (arr5[800]+arr5[801]+arr5[802]+arr5[803]+arr5[804]+arr5[805])/6;
							f5= (arr5[1000]+arr5[1001]+arr5[1002]+arr5[1003]+arr5[1004]+arr5[1005])/6;
							if(a5>700 && b5>700 && c5>700 &&d5>700 && e5>700 && f5>700)
							{
								arr6= lst.get(i+5);
								a6= (arr6[0]+arr6[1]+arr6[2]+arr6[3]+arr6[4]+arr6[5])/6;
								b6= (arr6[200]+arr6[201]+arr6[202]+arr6[203]+arr6[204]+arr6[205])/6;
								c6= (arr6[400]+arr6[401]+arr6[402]+arr6[403]+arr6[404]+arr6[405])/6;
								d6= (arr6[600]+arr6[601]+arr6[602]+arr6[603]+arr6[604]+arr6[605])/6;
								e6= (arr6[800]+arr6[801]+arr6[802]+arr6[803]+arr6[804]+arr6[805])/6;
								f6= (arr6[1000]+arr6[1001]+arr6[1002]+arr6[1003]+arr6[1004]+arr6[1005])/6;
								if(a6>700 && b6>700 && c6>700 &&d6>700 && e6>700 && f6>700)
								{
									System.out.println("clap");
									i = i+5;
								}
								else
								{
									System.out.println("clap");
									i = i+4;
								}
							}
							else
							{
								System.out.println("clap");
								i = i+3;
							}
						}
						else
						{
							System.out.println("clap");
							i = i+2;
						}
					}
					else
					{
						System.out.println("clap");
						i++;
					}
				}
				else
				{
					System.out.println("clap");
				}
			}
        }
	}
/*	public static void clapCheck()
	{
		GraphingAudio g = new GraphingAudio();
		ArrayList<int[]> lst = g.getList(); 
		int [] preArr;
		int [] arr;
		int a,b,c,d,e,f;
		for(int i=0; i<lst.size() ; i++)
		{	
			arr= lst.get(i);
			a= (arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5])/6;
			b= (arr[200]+arr[201]+arr[202]+arr[203]+arr[204]+arr[205])/6;
			c= (arr[400]+arr[401]+arr[402]+arr[403]+arr[404]+arr[405])/6;
			d= (arr[600]+arr[601]+arr[602]+arr[603]+arr[604]+arr[605])/6;
			e= (arr[800]+arr[801]+arr[802]+arr[803]+arr[804]+arr[805])/6;
			f= (arr[1000]+arr[1001]+arr[1002]+arr[1003]+arr[1004]+arr[1005])/6;
			System.out.println(a+ "\n"+b+ "\n"+c+ "\n"+d+ "\n"+e+ "\n"+f);
        }
		int [] arr2;
		int [] arr3;
		int [] arr4;
		for(int i=0; i<lst.size() ; i++)
        {	
        	arr= lst.get(i);
        	if(Similar(arr[0], arr[1])&& Similar(arr[0], arr[2])&&Similar(arr[0], arr[3])&&Similar(arr[0], arr[4])&&Similar(arr[0], arr[5]))
        	{
        		arr2= lst.get(i+1);
        		if(Similar(arr2[0], arr2[1])&& Similar(arr2[0], arr2[2])&&Similar(arr2[0], arr2[3])&&Similar(arr2[0], arr2[4])&&Similar(arr2[0], arr2[5]))
            	{
            		arr3= lst.get(i+2);
            		if(Similar(arr3[0], arr3[1])&& Similar(arr3[0], arr3[2])&&Similar(arr3[0], arr3[3])&&Similar(arr3[0], arr3[4])&&Similar(arr3[0], arr3[5]))
            		{
            			arr4= lst.get(i+3);
            			if(arr4[0]<(arr3[5]/2+100)&&arr4[1]<(arr3[5]/2+100)&&arr4[2]<(arr3[5]/2+100)&&arr4[3]<(arr3[5]/2+100)&&arr4[4]<(arr3[5]/2+100)&&arr4[5]<(arr3[5]/2+100))
            			{
            				preArr = lst.get(i-1);
                			if(!Similar(arr[0], preArr[0]) && !Similar(arr[0], preArr[1])&& !Similar(arr[0], preArr[2])&& !Similar(arr[0], preArr[3])&& !Similar(arr[0], preArr[4])&& !Similar(arr[0], preArr[5]))
                			{
                				i=i+2;
                				System.out.println("clap!");
                			}
            			}
            			else if(arr4[0]<(arr3[5]/2+100)&&arr4[1]<(arr3[5]/2+100)&&arr4[2]<(arr3[5]/2+100)&&arr4[3]<(arr3[5]/2+100)&&arr4[4]<(arr3[5]/2+100)&&arr4[5]<(arr3[5]/2+100))
                    	{
                			preArr = lst.get(i-1);
                			if(!Similar(arr[0], preArr[0]) && !Similar(arr[0], preArr[1])&& !Similar(arr[0], preArr[2])&& !Similar(arr[0], preArr[3])&& !Similar(arr[0], preArr[4])&& !Similar(arr[0], preArr[5]))
                			{
                				i++;
                				System.out.println("clap!");
                			}
                    	}
            		}
            		else if(arr3[0]<(arr2[5]/2+100)&&arr3[1]<(arr2[5]/2+100)&&arr3[2]<(arr2[5]/2+100)&&arr3[3]<(arr2[5]/2+100)&&arr3[4]<(arr2[5]/2+100)&&arr3[5]<(arr2[5]/2+100))
                	{
            			preArr = lst.get(i-1);
            			if(!Similar(arr[0], preArr[0]) && !Similar(arr[0], preArr[1])&& !Similar(arr[0], preArr[2])&& !Similar(arr[0], preArr[3])&& !Similar(arr[0], preArr[4])&& !Similar(arr[0], preArr[5]))
            			{
            				i++;
            				System.out.println("clap!");
            			}
                	}
            	}
        		else if(arr2[0]<(arr[5]/2+100)&&arr2[1]<(arr[5]/2+100)&&arr2[2]<(arr[5]/2+100)&&arr2[3]<(arr[5]/2+100)&&arr2[4]<(arr[5]/2+100)&&arr2[5]<(arr[5]/2+100))
        		{
        			preArr = lst.get(i-1);
        			if(!Similar(arr[0], preArr[0]) && !Similar(arr[0], preArr[1])&& !Similar(arr[0], preArr[2])&& !Similar(arr[0], preArr[3])&& !Similar(arr[0], preArr[4])&& !Similar(arr[0], preArr[5]))
        			{
        				System.out.println("clap!");
        			}
        		}
        	}
        }
	}
 	*/
	public static void main(String[] args) 
	{
		clapCheck();
	}
	
}

